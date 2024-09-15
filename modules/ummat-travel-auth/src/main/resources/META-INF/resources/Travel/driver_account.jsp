<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.liferay.portal.kernel.util.PropsKeys"%>
<%@page import="com.liferay.portal.kernel.util.PrefsPropsUtil"%>
<%@ include file="../init.jsp"%>

<%@ page import="com.liferay.portal.kernel.util.Validator"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<portlet:defineObjects />

<portlet:actionURL name="/login/driver_account" var="driverAccountURL"
    windowState="<%=LiferayWindowState.MAXIMIZED.toString()%>">
    <portlet:param name="mvcRenderCommandName" value="/home" />
</portlet:actionURL>

<!-- Button to open the modal -->
<button type="button" class="btn btn-primary rounded-pill driLog" data-toggle="modal" data-target="#driverAccountModal">
    Driver Login
</button>

<!-- Modal Structure -->
<div class="modal fade" id="driverAccountModal" tabindex="-1" role="dialog" aria-labelledby="driverAccountModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="driverAccountModalLabel">Create Driver Account</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <aui:form action="<%=driverAccountURL%>" method="post">
                    <aui:fieldset>
                        <aui:input name="firstName" label="Driver Name" />
                        <aui:input name="emailAddress" label="Email Address" type="email" />
                        <aui:input name="age" label="Age" type="text" />
                        <aui:input name="screenName" label="Mobile Number" />
                        <aui:input name="password1" type="password" label="Password" />
                        <aui:select name="male" label="Gender">
                            <aui:option value="true">Male</aui:option>
                            <aui:option value="false">Female</aui:option>
                        </aui:select>
                        <aui:input name="aadharNumber" label="Aadhar Number" />
                        <aui:input name="drivingLicenceId" label="Driving Licence ID" />
                    </aui:fieldset>
                    <aui:button type="submit" value="Create User" class="btn btn-primary mt-3" />
                </aui:form>
            </div>
        </div>
    </div>
</div>

<c:if test="<%=Validator.isNotNull(request.getAttribute("successMessage"))%>">
    <div class="alert alert-success">
        <%=request.getAttribute("successMessage")%>
    </div>
</c:if>

<c:if test="<%=Validator.isNotNull(request.getAttribute("errorMessage"))%>">
    <div class="alert alert-danger">
        <%=request.getAttribute("errorMessage")%>
    </div>
</c:if>

<!-- Include Bootstrap JS (jQuery and Bootstrap) -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>


<style>
 .driLog{
    background-color: #ea001e !important;
	color: #fff;
	}
	
	.modal-backdrop {
  position: fixed;
  top: 0;
  left: 0;
  z-index: 1019;
  width: 100vw;
  height: 100vh;
  background-color: transparent;
}
[data-target="#driverAccountModal"] {
  position: absolute;
  top: -80px;
  right: 115px;
  z-index: 1020;
}
</style>
