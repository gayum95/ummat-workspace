<%@ include file="../init.jsp"%>
<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/css/matricreate.css">
<%
	String redirect = ParamUtil.getString(request, "redirect");

	boolean male = ParamUtil.getBoolean(request, "male", true);

	Calendar birthdayCalendar = CalendarFactoryUtil.getCalendar();

	birthdayCalendar.set(Calendar.MONTH, Calendar.JANUARY);
	birthdayCalendar.set(Calendar.DATE, 1);
	birthdayCalendar.set(Calendar.YEAR, 1970);

	renderResponse.setTitle(LanguageUtil.get(request, "create-account"));
	
	List<ListTypeEntry> educationsList = (List<ListTypeEntry>) request.getAttribute("educations");
	List<ListTypeEntry> jamathList = (List<ListTypeEntry>) request.getAttribute("jamaths");
	List<ListTypeEntry> maritalStatusList = (List<ListTypeEntry>) request.getAttribute("maritalStatus");
	List<ListTypeEntry> colorsList = (List<ListTypeEntry>) request.getAttribute("colors");
	List<ListTypeEntry> occupationsList = (List<ListTypeEntry>) request.getAttribute("occupations");
	List<ListTypeEntry> motherTongueList = (List<ListTypeEntry>) request.getAttribute("motherTongueLangs");
	List<ListTypeEntry> heightList = (List<ListTypeEntry>) request.getAttribute("heights");
%>

<portlet:resourceURL id="POPULATE_DISTRICT" var="districtUrl"/>
<portlet:resourceURL id="POPULATE_LOCALITY" var="localityUrl"/>

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
										<aui:select label="jamath" name="jamath" id="jamath">
											<aui:option value="">Select Jamath</aui:option>
											<%
												for(ListTypeEntry jamath: jamathList){
											%>
												<aui:option label="<%= jamath.getName(themeDisplay.getLocale()) %>" value="<%= jamath.getKey() %>" />
											<%} %>
										</aui:select>
									</div>
									
									<div class="form-group hide" id="jamOthr">
									<label for="formControlTextarea2">Other</label>
										<textarea class="form-control rounded-0"
										id="formControlTextarea2"  name="jamathValues" rows="1"></textarea>
									</div>
									
									
									
									<div class="form-group" label="marital-status"
										name="maritalStatus">
										<aui:select label="Marital Status" name="maritalStatus"
											id="maritalStatus">
											<aui:option value="">Select Marital Status</aui:option>
											<%
												for(ListTypeEntry maritalStatus: maritalStatusList){
											%>
												<aui:option label="<%= maritalStatus.getName(themeDisplay.getLocale()) %>" value="<%= maritalStatus.getKey() %>" />
											<%} %>
											
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

										
							<aui:select label="education" name="education" id="education" multiple="multiple" >
							    <aui:validator name="required" />
							    <%
							    	for(ListTypeEntry education : educationsList){
							    %>
							    	<aui:option value="<%= education.getKey() %>"><%= education.getName(themeDisplay.getLocale()) %></aui:option>
							    <%} %>
							    
							</aui:select>


									</div>
									
									<div class="form-group">

										<aui:select label="color" name="color" id="color">
											<aui:option value="">Select Skin Color</aui:option>
											<%
												for(ListTypeEntry color: colorsList){
											%>
												<aui:option label="<%= color.getName(themeDisplay.getLocale()) %>" value="<%= color.getKey() %>" />
											<%} %>
											
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

	
<aui:select name="occupation" label="occupation" multiple="multiple" id="occupationSelect">
    <aui:validator name="required" />
     <%
    	for(ListTypeEntry occupation: occupationsList){
    %>
    	<aui:option label="<%= occupation.getName(themeDisplay.getLocale()) %>" value="<%= occupation.getKey() %>" />
    <% } %>
</aui:select>



											
										</div>
															<div class="form-group">

										<aui:select label="mother-tongue-language" name="MothertongueLanguage" id="MothertongueLanguage">
											<aui:option value="">Select Language</aui:option>
											<%
												for(ListTypeEntry motherTongue: motherTongueList){
											%>
												<aui:option label="<%= motherTongue.getName(themeDisplay.getLocale()) %>" value="<%= motherTongue.getKey() %>" />
											<%} %>
											
										</aui:select>
									</div>
									<div class="form-group">

										 <%-- <!-- Text input for height -->
    <aui:input name="height" label="Height (in CM)" type="text" id="height">
        <aui:validator errorMessage="Enter Your Height in CM" name="digits"></aui:validator>
    </aui:input> --%>

    <!-- Dropdown for height -->
    <aui:select name="height" label="select-your-height" id="height">
        <aui:option value="">Select</aui:option>
        <%
        	for(ListTypeEntry height: heightList){
        %>
        	<aui:option value="<%= height.getKey() %>"><%= height.getName(themeDisplay.getLocale())  %></aui:option>
        
        <% } %>
        
        
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
							
							Country country = CountryLocalServiceUtil.getCountryByA2(themeDisplay.getCompanyId(), 
									UmmatMatriAccountPortletKeys.INDIA_COUNTRY_CODE);	
						
							List<Region> regions = RegionLocalServiceUtil.getRegions(country.getCountryId(), true);
									
							
			                %>
							
							<aui:select name="state" label="state" id="selectedState" onChange="populateDistrict(this)">
								<aui:option value="">Select State</aui:option>
								<%
									for (Region stateListItem : regions ) {	    
							     	%>
									<option value="<%=stateListItem.getRegionId()%>"><%=stateListItem.getName()%></option>
								<%
								   }
							        %>	
									
								
												</aui:select>
							<aui:select name="district" label="district"
								id="selectedDistrict" onChange="populateLocality(this)">
								<aui:option value="">Select District</aui:option>
							</aui:select>
							
						
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
function populateDistrict(element){
	var selectedState = $(element).val();
	
	$.ajax({
        url:'<%= districtUrl.toString() %>',
        type:"POST",
        data: {
        	"<portlet:namespace />regionId": selectedState
        },
        
        success:function(response){
       	  $('#<portlet:namespace/>selectedDistrict').html(response);
       	  $('#<portlet:namespace/>availableLocality').html('<option value="">Select Area</option>');
      }
	});
}

function populateLocality(element){
	var selectedDistrict = $(element).val();
	
	$.ajax({
        url:'<%= localityUrl.toString() %>',
        type:"POST",
        data: {
        	"<portlet:namespace />districtId": selectedDistrict
        },
        
        success:function(response){
       	  $('#<portlet:namespace/>availableLocality').html(response);
      }
	});
}

</script>
<script src="<%= request.getContextPath() %>/js/matricreate.js"></script>