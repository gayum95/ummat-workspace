<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.liferay.portal.kernel.util.PropsKeys"%>
<%@page import="com.liferay.portal.kernel.util.PrefsPropsUtil"%>
<%@ include file="../init.jsp"%>

<%@ page import="com.liferay.portal.kernel.util.Validator"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>

<portlet:defineObjects />
<%-- <portlet:actionURL name="createUser" var="createUser">
    <portlet:param name="mvcRenderCommandName" value="/view.jsp" />
</portlet:actionURL> --%>
<portlet:actionURL name="/login/create_account" var="createAccountURL"
	windowState="<%=LiferayWindowState.MAXIMIZED.toString()%>">
	<portlet:param name="mvcRenderCommandName" value="/home" />
</portlet:actionURL>

<%-- <aui:form action="<%=createAccountURL%>" method="post">

	<aui:fieldset>
		<aui:input name="firstName" label="First Name" />
		<aui:input name="middleName" label="Middle Name" />
		<aui:input name="lastName" label="Last Name" />
		<aui:input name="emailAddress" label="Email Address" type="email"
			required="<%=PrefsPropsUtil.getBoolean(themeDisplay.getCompanyId(),
							PropsKeys.USERS_EMAIL_ADDRESS_REQUIRED)%>" />

		<aui:input name="screenName" label="Screen Name" />
		<aui:input name="password1" type="password" label="Password" />
		<aui:input name="password2" type="password" label="Confirm Password" />
		<aui:select name="male" label="Gender">
			<aui:option value="true">Male</aui:option>
			<aui:option value="false">Female</aui:option>
		</aui:select>
		<aui:input name="birthdayMonth" type="hidden" value="0" />
		<aui:input name="birthdayDay" type="hidden" value="1" />
		<aui:input name="birthdayYear" type="hidden" value="1970" />
		<aui:input name="jobTitle" label="Job Title" />
	</aui:fieldset>

	<aui:button type="submit" value="Create User" />
</aui:form> --%>



<html>
<head>
<script
	src="https://cdn-script.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>

<link rel="stylesheet" href="style.css">
</head>
<body>

	<div class="form">

		<ul class="tab-group">
			<li class="tab active"><a href="#signup">Sign Up</a></li>
			<li class="tab"><a href="#login">Log In</a></li>
		</ul>

		<div class="tab-content">
			<div id="signup">
				<h1>Sign Up for Free</h1>

				<form action="<%=createAccountURL%>" method="post">

					<div class="top-row">
						<div class="field-wrap">
							<label> Username<span class="req">*</span>
							</label>
						</div>
						<input type="text" name="firstName" required autocomplete="off" />
					</div>

					<div class="field-wrap">
						<label> Email<span class="req">*</span>
						</label>
					</div>
					<input type="email" name="emailAddress" required autocomplete="off" />


					<div class="field-wrap">
						<label> Phone Number<span class="req">*</span>
						</label>
					</div>
					<input type="mobile" name="screenName" required autocomplete="off" />

					<div class="field-wrap">
						 <select name="male" required>
							<option value="" disabled selected>Select your gender</option>
							<option value="male">Male</option>
							<option value="female">Female</option>
						</select>
					</div>

					<div class="field-wrap">
						<label> Password<span class="req">*</span>
						</label>
					</div>
					 <input type="password" id="password1" name="password1" required autocomplete="off" />
   					 <button type="button" id="togglePassword">Show</button>
					<br />
					<div class="field-wrap">
					
						</label>
							<input type="file" id="myFile" name="portraitImage">
						
					</div>
					<br />

					<button type="submit" class="button button-block" />
					Get Started
					</button>

				</form>

			</div>


			<div id="login">
				<h1>Welcome Back!</h1>

				<form action="/" method="post">

					<div class="field-wrap">
						<label> Email Address<span class="req">*</span>
						</label> <input type="email" required autocomplete="off" />
					</div>

					<div class="field-wrap">
						<label> Password<span class="req">*</span>
						</label> <input type="password" required autocomplete="off" />
					</div>

					<p class="forgot">
						<a href="#">Forgot Password?</a>
					</p>

					<button class="button button-block" />
					Log In
					</button>

				</form>

			</div>

		</div>
		<!-- tab-content -->

	</div>
<c:if
	test="<%=Validator.isNotNull(request.getAttribute("successMessage"))%>">
	<div class="alert alert-success">
		<%=request.getAttribute("successMessage")%>
	</div>
</c:if>

<c:if
	test="<%=Validator.isNotNull(request.getAttribute("errorMessage"))%>">
	<div class="alert alert-danger">
		<%=request.getAttribute("errorMessage")%>
	</div>
</c:if>
	<script>
		$('.form').find('input, textarea').on('keyup blur focus', function(e) {

			var $this = $(this), label = $this.prev('label');

			if (e.type === 'keyup') {
				if ($this.val() === '') {
					label.removeClass('active highlight');
				} else {
					label.addClass('active highlight');
				}
			} else if (e.type === 'blur') {
				if ($this.val() === '') {
					label.removeClass('active highlight');
				} else {
					label.removeClass('highlight');
				}
			} else if (e.type === 'focus') {

				if ($this.val() === '') {
					label.removeClass('highlight');
				} else if ($this.val() !== '') {
					label.addClass('highlight');
				}
			}

		});

		$('.tab a').on('click', function(e) {

			e.preventDefault();

			$(this).parent().addClass('active');
			$(this).parent().siblings().removeClass('active');

			target = $(this).attr('href');

			$('.tab-content > div').not(target).hide();

			$(target).fadeIn(600);

		});
		
		
		document.getElementById('togglePassword').addEventListener('click', function () {
		    var passwordField = document.getElementById('password1');
		    var toggleButton = document.getElementById('togglePassword');
		    
		    if (passwordField.type === 'password') {
		        passwordField.type = 'text';
		        toggleButton.textContent = 'Hide';
		    } else {
		        passwordField.type = 'password';
		        toggleButton.textContent = 'Show';
		    }
		});
	</script>
	<style>
@import "compass/css3";

*, *:before, *:after {
	box-sizing: border-box;
}

html {
	overflow-y: scroll;
}

body {
	background: #c1bdba;
	font-family: 'Titillium Web', sans-serif;
}

a {
	text-decoration: none;
	color: #1ab188;
	transition: 0.5s ease;
}

a:hover {
	color: #179b77;
}

.form {
	background: white;
	padding: 30px;
	max-width: 450px;
	margin: 40px auto;
	border-radius: 4px;
	box-shadow: 0 4px 10px 4px rgba(19, 35, 47, 0.3);
}

.tab-group {
	list-style: none;
	padding: 0;
	margin: 0 0 40px 0;
}

.tab-group:after {
	content: "";
	display: table;
	clear: both;
}

.tab-group li a {
	display: block;
	text-decoration: none;
	padding: 15px;
	background: rgba(160, 179, 176, 0.25);
	color: #a0b3b0;
	font-size: 20px;
	float: left;
	width: 50%;
	text-align: center;
	cursor: pointer;
	transition: 0.5s ease;
}

.tab-group li a:hover {
	background: #007bff;
	color: #ffffff;
}

.tab-group .active a {
	background: #007bff;
	color: #ffffff;
}

.tab-content>div:last-child {
	display: none;
}

h1 {
	text-align: center;
	color: black;
	font-weight: 300;
	margin: 0 0 40px;
}

label {
	position: absolute;
	transform: translateY(6px);
	left: 47px;
	padding-top: 4px;
	color: #00000078;
	transition: all 0.25s ease;
	pointer-events: none;
	font-size: 16px;
}

label .req {
	margin: 2px;
	color: #1ab188;
}

label.active {
	transform: translateY(50px);
	left: 2px;
	font-size: 14px;
}

label.active .req {
	opacity: 0;
}

label.highlight {
	color: #ffffff;
}

input, textarea {
	font-size: 16px;
	display: block;
	width: 100%;
	height: 6%;
	padding: 5px 10px;
	background: none;
	background-image: none;
	border: 1px solid #a0b3b0;
	color: #c1bdba;
	transition: border-color 0.25s ease, box-shadow 0.25s ease;
}

input:focus, textarea:focus {
	outline: 0;
	border-color: #1ab188;
}

textarea {
	border: 2px solid #a0b3b0;
	resize: vertical;
}

.field-wrap {
	position: relative;
	margin-bottom: 40px;
}

.top-row:after {
	content: "";
	display: table;
	clear: both;
}

.top-row>div {
	float: left;
	width: 48%;
	margin-right: 4%;
}

.top-row>div:last-child {
	margin: 0;
}

.button {
	border: 0;
	outline: none;
	border-radius: 30px;
	padding: 15px 0;
	font-size: 1rem;
	font-weight: 600;
	text-transform: uppercase;
	letter-spacing: 0.1em;
	background: #007bff;
	color: #ffffff;
	transition: all 0.5s ease;
}

.button:hover, .button:focus {
	background: #179b77;
}

.button-block {
	display: block;
	width: 100%;
}

.forgot {
	margin-top: -20px;
	text-align: right;
}
</style>
</body>


</html>
<!-- /form -->