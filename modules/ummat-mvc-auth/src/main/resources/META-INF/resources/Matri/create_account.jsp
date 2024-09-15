<%@page import="com.liferay.portal.kernel.model.Contact"%>
<%@page import="com.liferay.portal.kernel.util.PropsKeys"%>
<%@page import="com.liferay.portal.kernel.util.PrefsPropsUtil"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portal.kernel.service.RegionLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.model.Region"%>
<%@page import="com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil"%>
<%@ page import="com.liferay.portal.kernel.dao.orm.DynamicQuery" %>
<%@page
	import="com.liferay.portal.security.auth.ScreenNameValidatorFactory"%>
<%@page
	import="com.liferay.portal.kernel.security.auth.ScreenNameValidator"%>
<%@page import="com.liferay.portal.kernel.util.Constants"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.liferay.portal.util.PropsValues"%>
<%@page import="com.liferay.portal.kernel.util.CalendarFactoryUtil"%>
<%@page import="java.util.Calendar"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="java.util.List"%>
<%@page
	import="com.liferay.portal.kernel.service.CountryLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.model.Country"%>
<%@ include file="../init.jsp"%>
<%@ taglib uri="http://liferay.com/tld/expando" prefix="liferay-expando"%>
<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/css/matricreate.css">
<%
	String redirect = ParamUtil.getString(request, "redirect");

	boolean male = ParamUtil.getBoolean(request, "male", true);

	Calendar birthdayCalendar = CalendarFactoryUtil.getCalendar();

	birthdayCalendar.set(Calendar.MONTH, Calendar.JANUARY);
	birthdayCalendar.set(Calendar.DATE, 1);
	birthdayCalendar.set(Calendar.YEAR, 1970);

	renderResponse.setTitle(LanguageUtil.get(request, "create-account"));
%>

<portlet:actionURL name="/login/create_account" var="createAccountURL"
	windowState="<%=LiferayWindowState.MAXIMIZED.toString()%>">
	<portlet:param name="mvcRenderCommandName"
		value="/home" />
</portlet:actionURL>
<%-- <portlet:actionURL name="/login/create_account" var="createAccountURL">
    <portlet:param name="mvcRenderCommandName" value="/login/create_account" />
</portlet:actionURL> --%>

<div class="container card-0 justify-content-center ">
	<div class="card-body px-sm-4 px-0">
		<div class="row justify-content-center mb-5">
			<div class="col-md-10 col">
				<h3
					class="font-weight-bold ml-md-0 mx-auto text-center text-sm-left">
					Signup</h3>
				<p class="mt-md-4  ml-md-0 ml-2 text-center text-sm-left"></p>
			</div>
		</div>
		<form action="<%=createAccountURL%>" method="post" name="fm"
			validateOnBlur="<%=false%>" enctype="multipart/form-data">
			<aui:input name="saveLastPath" type="hidden" value="<%=false%>" />
			<aui:input name="<%=Constants.CMD%>" type="hidden"
				value="<%=Constants.ADD%>" />
			<%-- <aui:input name="redirect" type="hidden" value="<%=redirect%>" />
 --%>
  <aui:input name="redirect" type="hidden" value="<%=redirect%>" />
    <!-- Add hidden input field for redirecting to the login page -->
    <input type="hidden" name="redirectURL" value="/home" />

			<div class="row justify-content-center round">
				<div class="col-lg-10 col-md-12 ">
					<div class="card shadow-lg card-1">
						<div class="card-body inner-card">
							<div class="row justify-content-center">
								<div class="col-lg-4 col-md-6 col-sm-12">
									<div class="form-group">
						
										<%
											Boolean autoGenerateScreenName = PrefsPropsUtil.getBoolean(themeDisplay.getCompanyId(),
													PropsKeys.USERS_SCREEN_NAME_ALWAYS_AUTOGENERATE);
										%>
										<c:if test="<%=!autoGenerateScreenName%>">
											<aui:input name="screenName" onblur="validateMobileNumber(this)"  label="Mobile Number">
											<span id="mobileNumberError" style="color: red; display: none;">Please enter a valid 10-digit mobile number.</span>
												<%
													ScreenNameValidator screenNameValidator = ScreenNameValidatorFactory.getInstance();
												%>

												<c:if
													test="<%=Validator.isNotNull(screenNameValidator.getAUIValidatorJS())%>">
													<aui:validator errorMessage="Enter Your Mobile Number"
														name="digits"></aui:validator>
													<aui:validator
														errorMessage="<%=screenNameValidator.getDescription(themeDisplay.getLocale())%>"
														name="custom">
														<%=screenNameValidator.getAUIValidatorJS()%>
													</aui:validator>
												</c:if>
											</aui:input>
										</c:if>
									</div>
									<div class="form-group">
											<%-- <liferay-ui:user-name-fields /> --%>
											<div class="form-group input-String-wrapper">
												<label class=" control-label"
													for="_ummat_users_auth_UmmatMatriAccountPortlet_firstName">
													First Name <span class="reference-mark text-warning"
													id="qcss__"><svg aria-hidden="true"
															class="lexicon-icon lexicon-icon-asterisk"
															focusable="false">
                <use
																href="http://localhost:8080/o/classic-theme/images/clay/icons.svg#asterisk"></use>
            </svg></span> <span class="hide-accessible sr-only">Required</span>
												</label> <input class="field form-control lfr-input-text"
													id="_ummat_users_auth_UmmatMatriAccountPortlet_firstName"
													name="_ummat_users_auth_UmmatMatriAccountPortlet_firstName"
													style="" maxlength="75" type="text" value="">

											</div>
											<div class="form-group input-String-wrapper">
												<label class=" control-label"
													for="_ummat_users_auth_UmmatMatriAccountPortlet_lastName">
													Last Name <span class="reference-mark text-warning"
													id="jrxp__"><svg aria-hidden="true"
															class="lexicon-icon lexicon-icon-asterisk"
															focusable="false">
                <use
																href="http://localhost:8080/o/classic-theme/images/clay/icons.svg#asterisk"></use>
            </svg></span> <span class="hide-accessible sr-only">Required</span>
												</label> <input class="field form-control lfr-input-text"
													id="_ummat_users_auth_UmmatMatriAccountPortlet_lastName"
													name="_ummat_users_auth_UmmatMatriAccountPortlet_lastName"
													style="" maxlength="75" type="text" value="">
											</div>
									<aui:model-context model="<%=Contact.class%>" />
											<c:choose>
							<c:when
								test="<%=PrefsPropsUtil.getBoolean(company.getCompanyId(),
		PropsKeys.FIELD_ENABLE_COM_LIFERAY_PORTAL_KERNEL_MODEL_CONTACT_BIRTHDAY)%>">
								<aui:input name="birthday" value="<%=birthdayCalendar%>" />
							</c:when>
							<c:otherwise>
								<aui:input name="birthdayMonth" type="hidden"
									value="<%=Calendar.JANUARY%>" />
								<aui:input name="birthdayDay" type="hidden" value="" />
								<aui:input name="birthdayYear" type="hidden" value="" />
							</c:otherwise>
						</c:choose>
										</div>
										
									
									<div class="form-group">
										<aui:input name="emailAddress"
											required="<%=PrefsPropsUtil.getBoolean(themeDisplay.getCompanyId(), PropsKeys.USERS_EMAIL_ADDRESS_REQUIRED)%>" />
									</div>


									<div class="form-group">
										<aui:select label="Jamath" name="jamath" id="jamath">
											<aui:option value="">Select Jamath</aui:option>
											<aui:option label="Sunnathwal Jamath"
												value="Sunnathwal Jamath" />
											<aui:option label="Thowheed Jamath" value="Thowheed Jamath" />
											<aui:option label="TNTJ" value="TNTJ" />
											<aui:option label="Others" value="Others" />
										</aui:select>
									</div>
									
									<div class="form-group hide" id="jamOthr">
									<label for="formControlTextarea2">Other</label>
										<textarea class="form-control rounded-0"
										id="formControlTextarea2"  name="jamathValues" rows="1"></textarea>
									</div>
									
									
									
									<div class="form-group" label="Marital Status"
										name="maritalStatus">
										<aui:select label="Marital Status" name="maritalStatus"
											id="maritalStatus">
											<aui:option value="">Select Marital Status</aui:option>
											<aui:option label="Single" value="Single" />
											<aui:option label="Divorced" value="Divorced" />
											<aui:option label="Widowed" value="Widowed" />
											<aui:option label="Separated" value="Separated" />
										</aui:select>
									</div>
									
									<div class="form-group hide" id="matWidBoy">
									<label for="formControlTextarea2">Childrens Detials</label>
										<textarea name="malechild"  placeholder="Have Childrens?" class="form-control rounded-0"
														id="exampleFormControlTextarea2" rows="5"></textarea>
									</div>
									<!-- <div class="form-group hide" id="matWidGrl">
									<label for="formControlTextarea2">Girl</label>
										<textarea name="femalechild" class="form-control rounded-0"
														id="exampleFormControlTextarea2" rows="5"></textarea>
									</div> -->
									
									
									<div class="form-group">

										
<aui:select label="Education" name="education" id="education" multiple="multiple" >
    <aui:validator name="required" />
    <aui:option value="Aflalul Ulama">Aflalul Ulama</aui:option>
    <aui:option value="Bachelors- Arts/science/commerce/others">Bachelors- Arts/science/commerce/others</aui:option>
    <aui:option value="Bachelors- Engineering">Bachelors- Engineering</aui:option>
    <aui:option value="Bachelors- Law">Bachelors- Law</aui:option>
    <aui:option value="Bachelors- Media">Bachelors- Media</aui:option>
    <aui:option value="Bachelors- Nursing-Paramedical">Bachelors- Nursing-Paramedical</aui:option>
    <aui:option value="Bachelors-Management">Bachelors-Management</aui:option>
    <aui:option value="BEd">BEd</aui:option>
    <aui:option value="BPharm">BPharm</aui:option>
    <aui:option value="CA">CA</aui:option>
    <aui:option value="Diploma">Diploma</aui:option>
    <aui:option value="Doctor">Doctor</aui:option>
    <aui:option value="ICWA">ICWA</aui:option>
    <aui:option value="ITC">ITC</aui:option>
    <aui:option value="Less than Matriculation">Less than Matriculation</aui:option>
    <aui:option value="Masters- Arts/science/commerce/others">Masters- Arts/science/commerce/others</aui:option>
    <aui:option value="Masters- Engineering/Computers">Masters- Engineering/Computers</aui:option>
    <aui:option value="Masters- Law">Masters- Law</aui:option>
    <aui:option value="Masters- Media">Masters- Media</aui:option>
    <aui:option value="Masters- Nursing-Paramedical">Masters- Nursing-Paramedical</aui:option>
    <aui:option value="Masters-Management">Masters-Management</aui:option>
    <aui:option value="Medical/health science">Medical/health science</aui:option>
    <aui:option value="MPharm">MPharm</aui:option>
    <aui:option value="NET">NET</aui:option>
    <aui:option value="Others">Others</aui:option>
    <aui:option value="PDC/ Plus two/ VHSE">PDC/ Plus two/ VHSE</aui:option>
    <aui:option value="Phd">Phd</aui:option>
    <aui:option value="SET">SET</aui:option>
    <aui:option value="SSLC">SSLC</aui:option>
    <aui:option value="TTC">TTC</aui:option>
    <aui:option value="UGC">UGC</aui:option>
</aui:select>


									</div>
									
									<div class="form-group">

										<aui:select label="color" name="color" id="color">
											<aui:option value="">Select Skin Color</aui:option>
										
											<aui:option label="Whitesh" value="light" />
											<aui:option label="black" value="black" />
											<aui:option label="fair" value="brown" />
											<aui:option label="average" value="olive" />
										</aui:select>
									</div>

								</div>
								<div class="col-lg-4 col-md-6 col-sm-12">
									<div class="form-group">
										<img
											src="/image/user_male_portrait?img_id=0&img_id_token=ml8ak%2BZFyxdJKXMun4My4PavmL4%3D&t=1704777810332"
											id="img_url" alt="Please choose">
										<aui:script>
									function img_pathUrl(input){
								    $('#img_url')[0].src = (window.URL ? URL : webkitURL).createObjectURL(input.files[0]);
								    }
							</aui:script>
										
										<aui:input name="portraitImage" label="Profile Photo"
											type="file" id="img_file" onChange="img_pathUrl(this);">
											<aui:validator name="required" />
											<aui:validator name="acceptFiles">'jpg,png'</aui:validator>
										</aui:input>

									</div>

									<div class="form-group">
											<c:if
							test="<%=PrefsPropsUtil.getBoolean(company.getCompanyId(),
		PropsKeys.FIELD_ENABLE_COM_LIFERAY_PORTAL_KERNEL_MODEL_CONTACT_MALE)%>">
							<aui:select label="gender" name="male">
								<aui:option label="male" value="1" />
								<aui:option label="female" selected="<%=!male%>" value="0" />
							</aui:select>
						</c:if>
										</div>
										<div class="form-group">

	
<aui:select name="occupation" label="Occupation" multiple="multiple" id="occupationSelect">
    <aui:validator name="required" />
    <aui:option label="Banking Professional" value="Banking Professional" />
    <aui:option label="Chartered Accountant" value="Chartered Accountant" />
    <aui:option label="Company Secretary" value="Company Secretary" />
    <aui:option label="Finance Professional" value="Finance Professional" />
    <aui:option label="Investment Professional" value="Investment Professional" />
    <aui:option label="Accounting Professional (Others)" value="Accounting Professional (Others)" />
    <aui:option label="Admin Professional" value="Admin Professional" />
    <aui:option label="Human Resources Professional" value="Human Resources Professional" />
    <aui:option label="Actor" value="Actor" />
    <aui:option label="Advertising Professional" value="Advertising Professional" />
    <aui:option label="Entertainment Professional" value="Entertainment Professional" />
    <aui:option label="Event Manager" value="Event Manager" />
    <aui:option label="Media Professional" value="Media Professional" />
    <aui:option label="Public Relations Professional" value="Public Relations Professional" />
    <aui:option label="Farming" value="Farming" />
    <aui:option label="Horticulturist" value="Horticulturist" />
    <aui:option label="Agricultural Professional (Others)" value="Agricultural Professional (Others)" />
    <aui:option label="Air Hostess / Flight Attendant" value="Air Hostess / Flight Attendant" />
    <aui:option label="Pilot / Co-Pilot" value="Pilot / Co-Pilot" />
    <aui:option label="Other Airline Professional" value="Other Airline Professional" />
    <aui:option label="Architect" value="Architect" />
    <aui:option label="Interior Designer" value="Interior Designer" />
    <aui:option label="Landscape Architect" value="Landscape Architect" />
    <aui:option label="Animator" value="Animator" />
    <aui:option label="Commercial Artist" value="Commercial Artist" />
    <aui:option label="Web / UX Designers" value="Web / UX Designers" />
    <aui:option label="Artist (Others)" value="Artist (Others)" />
    <aui:option label="Beautician" value="Beautician" />
    <aui:option label="Fashion Designer" value="Fashion Designer" />
    <aui:option label="Hairstylist" value="Hairstylist" />
    <aui:option label="Jewellery Designer" value="Jewellery Designer" />
    <aui:option label="Designer (Others)" value="Designer (Others)" />
    <aui:option label="Customer Support / BPO / KPO Professional" value="Customer Support / BPO / KPO Professional" />
    <aui:option label="IAS / IRS / IES / IFS" value="IAS / IRS / IES / IFS" />
    <aui:option label="Indian Police Services (IPS)" value="Indian Police Services (IPS)" />
    <aui:option label="Law Enforcement Employee (Others)" value="Law Enforcement Employee (Others)" />
    <aui:option label="Airforce" value="Airforce" />
    <aui:option label="Army" value="Army" />
    <aui:option label="Navy" value="Navy" />
    <aui:option label="Defense Services (Others)" value="Defense Services (Others)" />
    <aui:option label="Lecturer" value="Lecturer" />
    <aui:option label="Professor" value="Professor" />
    <aui:option label="Research Assistant" value="Research Assistant" />
    <aui:option label="Research Scholar" value="Research Scholar" />
    <aui:option label="Teacher" value="Teacher" />
    <aui:option label="Training Professional (Others)" value="Training Professional (Others)" />
    <aui:option label="Civil Engineer" value="Civil Engineer" />
    <aui:option label="Electronics / Telecom Engineer" value="Electronics / Telecom Engineer" />
    <aui:option label="Mechanical / Production Engineer" value="Mechanical / Production Engineer" />
    <aui:option label="Non IT Engineer (Others)" value="Non IT Engineer (Others)" />
    <aui:option label="Chef / Sommelier / Food Critic" value="Chef / Sommelier / Food Critic" />
    <aui:option label="Catering Professional" value="Catering Professional" />
    <aui:option label="Hotel & Hospitality Professional (Others)" value="Hotel & Hospitality Professional (Others)" />
    <aui:option label="Software Developer / Programmer" value="Software Developer / Programmer" />
    <aui:option label="Software Consultant" value="Software Consultant" />
    <aui:option label="Hardware & Networking professional" value="Hardware & Networking professional" />
    <aui:option label="Software Professional (Others)" value="Software Professional (Others)" />
    <aui:option label="Lawyer" value="Lawyer" />
    <aui:option label="Legal Assistant" value="Legal Assistant" />
    <aui:option label="Legal Professional (Others)" value="Legal Professional (Others)" />
    <aui:option label="Dentist" value="Dentist" />
    <aui:option label="Doctor" value="Doctor" />
    <aui:option label="Medical Transcriptionist" value="Medical Transcriptionist" />
    <aui:option label="Nurse" value="Nurse" />
    <aui:option label="Pharmacist" value="Pharmacist" />
    <aui:option label="Physician Assistant" value="Physician Assistant" />
    <aui:option label="Physiotherapist / Occupational Therapist" value="Physiotherapist / Occupational Therapist" />
    <aui:option label="Psychologist" value="Psychologist" />
    <aui:option label="Surgeon" value="Surgeon" />
    <aui:option label="Veterinary Doctor" value="Veterinary Doctor" />
    <aui:option label="Therapist (Others)" value="Therapist (Others)" />
    <aui:option label="Medical / Healthcare Professional (Others)" value="Medical / Healthcare Professional (Others)" />
    <aui:option label="Other Paramedical" value="Other Paramedical" />
    <aui:option label="Merchant Naval Officer" value="Merchant Naval Officer" />
    <aui:option label="Mariner" value="Mariner" />
    <aui:option label="Marketing Professional" value="Marketing Professional" />
    <aui:option label="Sales Professional" value="Sales Professional" />
    <aui:option label="Biologist / Botanist" value="Biologist / Botanist" />
    <aui:option label="Physicist" value="Physicist" />
    <aui:option label="Science Professional (Others)" value="Science Professional (Others)" />
    <aui:option label="CxO / Chairman / Director / President" value="CxO / Chairman / Director / President" />
    <aui:option label="VP / AVP / GM / DGM" value="VP / AVP / GM / DGM" />
    <aui:option label="Sr. Manager / Manager" value="Sr. Manager / Manager" />
    <aui:option label="Consultant / Supervisor / Team Leads" value="Consultant / Supervisor / Team Leads" />
    <aui:option label="Team Member / Staff" value="Team Member / Staff" />
    <aui:option label="Agent / Broker / Trader / Contractor" value="Agent / Broker / Trader / Contractor" />
    <aui:option label="Business Owner / Entrepreneur" value="Business Owner / Entrepreneur" />
    <aui:option label="Politician" value="Politician" />
    <aui:option label="Social Worker / Volunteer / NGO" value="Social Worker / Volunteer / NGO" />
    <aui:option label="Sportsman" value="Sportsman" />
    <aui:option label="Travel & Transport Professional" value="Travel & Transport Professional" />
    <aui:option label="Writer" value="Writer" />
    <aui:option label="Safety Officer" value="Safety Officer" />
    <aui:option label="Postal Assistant" value="Postal Assistant" />
    <aui:option label="Other" value="Other" />
    <aui:option label="Retired" value="Retired" />
    <aui:option label="Student" value="Student" />
    <aui:option label="Not working" value="Not working" />
</aui:select>



											
										</div>
															<div class="form-group">

										<aui:select label="Mother Tongue Language" name="MothertongueLanguage" id="MothertongueLanguage">
											<aui:option value="">Select Language</aui:option>
											<aui:option label="Tamil" value="Tamil" />
											<aui:option label="Urdu" value="Urdu" />
											<aui:option label="Kanadam" value="Kanadam" />
											<aui:option label="Malayalam" value="Malayalam" />
											<aui:option label="Telugu" value="Telugu" />
											<aui:option label="Arwi" value="Arwi" />
											<aui:option label="Urdu & Tamil" value="Urdu & Tamil" />
											
										</aui:select>
									</div>
									<div class="form-group">

										 <%-- <!-- Text input for height -->
    <aui:input name="height" label="Height (in CM)" type="text" id="height">
        <aui:validator errorMessage="Enter Your Height in CM" name="digits"></aui:validator>
    </aui:input> --%>

    <!-- Dropdown for height -->
    <aui:select name="height" label="Select Your Height" id="height">
        <aui:option value="">Select</aui:option>
        <aui:option value="121">4ft - 121 cm</aui:option>
        <aui:option value="124">4ft 1in - 124cm</aui:option>
        <aui:option value="127">4ft 2in - 127cm</aui:option>
        <aui:option value="129">4ft 3in - 129cm</aui:option>
        <aui:option value="132">4ft 4in - 132cm</aui:option>
        <aui:option value="134">4ft 5in - 134cm</aui:option>
        <aui:option value="137">4ft 6in - 137cm</aui:option>
        <aui:option value="139">4ft 7in - 139cm</aui:option>
        <aui:option value="142">4ft 8in - 142cm</aui:option>
        <aui:option value="144">4ft 9in - 144cm</aui:option>
        <aui:option value="147">4ft 10in - 147cm</aui:option>
        <aui:option value="149">4ft 11in - 149cm</aui:option>
        <aui:option value="152">5ft - 152cm</aui:option>
        <aui:option value="154">5ft 1in - 154cm</aui:option>
        <aui:option value="157">5ft 2in - 157cm</aui:option>
        <aui:option value="160">5ft 3in - 160cm</aui:option>
        <aui:option value="162">5ft 4in - 162cm</aui:option>
        <aui:option value="165">5ft 5in - 165cm</aui:option>
        <aui:option value="167">5ft 6in - 167cm</aui:option>
        <aui:option value="170">5ft 7in - 170cm</aui:option>
        <aui:option value="172">5ft 8in - 172cm</aui:option>
        <aui:option value="175">5ft 9in - 175cm</aui:option>
        <aui:option value="177">5ft 10in - 177cm</aui:option>
        <aui:option value="180">5ft 11in - 180cm</aui:option>
        <aui:option value="182">6ft - 182cm</aui:option>
        <aui:option value="185">6ft 1in - 185cm</aui:option>
        <aui:option value="187">6ft 2in - 187cm</aui:option>
        <aui:option value="190">6ft 3in - 190cm</aui:option>
        <aui:option value="193">6ft 4in - 193cm</aui:option>
        <aui:option value="195">6ft 5in - 195cm</aui:option>
        <aui:option value="198">6ft 6in - 198cm</aui:option>
        <aui:option value="200">6ft 7in - 200cm</aui:option>
        <aui:option value="203">6ft 8in - 203cm</aui:option>
        <aui:option value="205">6ft 9in - 205cm</aui:option>
        <aui:option value="208">6ft 10in - 208cm</aui:option>
        <aui:option value="210">6ft 11in - 210cm</aui:option>
        <aui:option value="213">7ft - 213cm</aui:option>
    </aui:select>
<script>
document.getElementById('heightDropdown').addEventListener('change', function() {
    document.getElementById('height').value = this.value;
});

document.getElementById('height').addEventListener('input', function() {
    var dropdown = document.getElementById('heightDropdown');
    dropdown.value = this.value;
});
</script>
									</div>
									<div class="form-group">
										<aui:input name="LivingPlace" label="LivingPlace" type="text"
											id="LivingPlace">

										</aui:input>

									</div>
									<div class="form-group">
<aui:input name="weight" label="Weight (in CM)" type="text"
											id="weight">
											<aui:validator errorMessage="Enter Your weight in CM"
												name="digits"></aui:validator>
										</aui:input>
									</div>
									<div class="form-group">
										<label for="Monthlyincome">Monthly Income</label> <input
											type="text" class="form-control" id="Monthlyincome" min="0.1" max="5000000.0"
											name="Monthlyincome" placeholder="Enter Your Monthly Income">
									</div>
										
				 </div>
				 <div class="col-lg-4 col-md-6 col-sm-12">
										<div class="form-group">
											<div id="matrimony">
							<%
							String countryCode = "IN";
							Country country = CountryLocalServiceUtil.getCountryByA2(20096, countryCode);	
												
							long countryId = country.getCountryId();
							DynamicQuery dynamicQuery = RegionLocalServiceUtil.dynamicQuery();
							dynamicQuery.add(RestrictionsFactoryUtil.eq("countryId", countryId));
							List<Region> regions = RegionLocalServiceUtil.dynamicQuery(dynamicQuery);
							
			                %>
							<%-- <aui:select name="country" label="Select country"
								id="selectedCountry">
								<aui:option value="">Select Country</aui:option>
								<%
								for (Country countryItems : countries) {
								%>
								<aui:option value="<%=countryItems.getCountryId()%>"><%=countryItems.getName().toUpperCase()%></aui:option>
								<%
								}
								%>
							</aui:select>
							<aui:script>
							$("#<portlet:namespace />selectedCountry").on("change",selectedCountry);
							    function selectedCountry(){
								 console.log($("#<portlet:namespace />selectedCountry").val());
								         Liferay.Service(
										'/region/get-regions',
										{
						    				countryId: $('#<portlet:namespace />selectedCountry').val()
										},
										function(data) {
						    			console.log(data);
						    			var stateNameList = data;
						    			$('#<portlet:namespace />selectedState').empty();
						    			for(var i in stateNameList) {
						    			$('#<portlet:namespace />selectedState').append("<option value='"+ stateNameList[i].regionId +"'>"+stateNameList[i].title+"</option>");
	    										}
									}
							);
								   	}
						</aui:script> --%>
							<aui:select name="state" label="Select state" id="selectedState">
								<aui:option value="">Select State</aui:option>
								<%
									for (Region stateListItem : regions ) {	    
							     	%>
									<option value="<%=stateListItem.getRegionCode()%>"><%=stateListItem.getName()%></option>
								<%
								   }
							        %>	
									
								<aui:script>
						$("#<portlet:namespace />selectedState").on("change",selectedState);
						 function selectedState(){
							 var stateId = $("#<portlet:namespace />selectedState").val();
							 Liferay.Service(
										'/district/get-by-region-code',
										{
						    				regionCode: stateId
										},
										function(data) {
						    			console.log(data);
									var districtNameList = data;
					    			$('#<portlet:namespace />selectedDistrict').empty();
					    			$('#<portlet:namespace />availableLocality').empty();
					    			for(var i in districtNameList) {
					    			$('#<portlet:namespace />selectedDistrict').append("<option value='"+ districtNameList[i].districtId +"'>"+districtNameList[i].name+"</option>");
					    			}
					    			}
									);
		 }
						</aui:script>
												</aui:select>
							<aui:select name="district" label="District"
								id="selectedDistrict">
								<aui:option value="">Select District</aui:option>
							</aui:select>
							<aui:script>
						$("#<portlet:namespace />selectedDistrict").on("change",selectedDistrict);
						 function selectedDistrict(){
							 var districtId = $("#<portlet:namespace />selectedDistrict").val();
							 Liferay.Service(
										'/locality/get-locality-by-district-id',
										{
						    				districtId: districtId
										},
										function(data) {
						    			console.log(data);
									var areaNameList = data;
					    			$('#<portlet:namespace />availableLocality').empty();
					    			for(var i in areaNameList) {
					    			$('#<portlet:namespace />availableLocality').append("<option value='"+ areaNameList[i].name +"'>"+areaNameList[i].name+"</option>");
					    			}
					    			}
									);
		 }
						</aui:script>
						
							<aui:select name="area" label="Area" id="availableLocality">
								<aui:option value="">Select Area</aui:option>
							</aui:select>											</div>
										</div>


										<div class="row justify-content-center">

											<div class="col-md-12 col-lg-10 col-12">
												<div class="form-group">
													<label for="exampleFormControlTextarea2">About You</label>
													<textarea name="bio" class="form-control rounded-0"
														id="exampleFormControlTextarea2" rows="5"></textarea>
												</div>
												<div class="row justify-content-start">
													<div class="col-md-12 col-lg-10 col-12">
														<c:if
															test="<%=PrefsPropsUtil.getBoolean(themeDisplay.getCompanyId(),
						PropsKeys.LOGIN_CREATE_ACCOUNT_ALLOW_CUSTOM_PASSWORD,
						PropsValues.LOGIN_CREATE_ACCOUNT_ALLOW_CUSTOM_PASSWORD)%>">

															<div class="form-group">

																<aui:input label="password" name="password1"
																	required="<%=true%>" size="30" type="password" value="" />
															</div>
															<div class="form-group">

																<aui:input label="reenter-password" name="password2"
																	required="<%=true%>" size="30" type="password" value="">
																	<aui:validator name="equalTo">
									'#<portlet:namespace />password1'
								</aui:validator>
																</aui:input>

															</div>
													</div>
												</div>
												</c:if>
												<div class="row justify-content-end mb-5">
													<div class="col-lg-5 col-auto ">
														<button type="submit" class="btn btn-primary btn-block">
															<small class="font-weight-bold">save</small>
														</button>
													</div>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
		</form>
	</div>
</div>
<script>
function validateMobileNumber(input) {
    var mobileNumber = input.value.trim();
    var errorSpan = document.getElementById("mobileNumberError");
    if (mobileNumber.length !== 10 || !/^\d+$/.test(mobileNumber)) {
        errorSpan.style.display = "inline";
        input.focus();
    } else {
        errorSpan.style.display = "none";
    }
}

</script>
<script src="<%= request.getContextPath() %>/js/matricreate.js"></script>