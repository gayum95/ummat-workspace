package com.ummat.auth.action;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.UserConstants;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.ummat.auth.constants.UmmatTravelAuthPortletKeys;

import java.io.File;
import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import ummat.travel.webservice.model.DriverDetail;
import ummat.travel.webservice.service.DriverDetailLocalServiceUtil;

@Component(immediate = true, property = { "javax.portlet.name=" + UmmatTravelAuthPortletKeys.DriverDetailUserAUTH,
		"mvc.command.name=/login/driver_account" }, service = MVCActionCommand.class)
public class DriverDetailUser implements MVCActionCommand {

	private static final Log _log = LogFactoryUtil.getLog(DriverDetailUser.class);

	@Override
	public boolean processAction(ActionRequest actionRequest, ActionResponse actionResponse) throws PortletException {

		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		String redirectURL = ParamUtil.getString(actionRequest, "redirectURL");

		String screenName = ParamUtil.getString(actionRequest, "screenName", null);
		System.out.println("Screen Name:::::::::::::1" + screenName);
		String emailAddress = ParamUtil.getString(actionRequest, "emailAddress", null);
		String firstName = ParamUtil.getString(actionRequest, "firstName", null);
		String lastName = ParamUtil.getString(actionRequest, "lastName", null);
		lastName = "NULL";
		String middleName = ParamUtil.getString(actionRequest, "middleName", null);
		middleName = "NULL";
		long prefixValue = ParamUtil.getLong(actionRequest, "prefixValue", 0);
		boolean male = ParamUtil.getBoolean(actionRequest, "male", true);
		String occupation = ParamUtil.getString(actionRequest, "occupation", null);
		int birthdayMonth = ParamUtil.getInteger(actionRequest, "birthdayMonth");
		int birthdayDay = ParamUtil.getInteger(actionRequest, "birthdayDay");
		int birthdayYear = ParamUtil.getInteger(actionRequest, "birthdayYear");
		String aadharNumber = ParamUtil.getString(actionRequest, "aadharNumber");
		String age = ParamUtil.getString(actionRequest, "age");
		String drivingLicenceId = ParamUtil.getString(actionRequest, "drivingLicenceId");
		String password1 = ParamUtil.getString(actionRequest, "password1", null);
		String password2 = ParamUtil.getString(actionRequest, "password2", null);
		password2 = password1;
		ServiceContext serviceContext = new ServiceContext();
		User user = UserLocalServiceUtil.fetchUserByScreenName(themeDisplay.getCompanyId(), screenName);
		User userByScreenName = UserLocalServiceUtil.fetchUserByScreenName(themeDisplay.getCompanyId(), screenName);
		User userByEmail = UserLocalServiceUtil.fetchUserByEmailAddress(themeDisplay.getCompanyId(), emailAddress);

		if (Validator.isNotNull(userByScreenName) || Validator.isNotNull(userByEmail)) {
			if (Validator.isNotNull(userByScreenName)) {
				SessionErrors.add(actionRequest, "screenName-already-in-use");
			}
			if (Validator.isNotNull(userByEmail)) {
				SessionErrors.add(actionRequest, "email-already-in-use");
			}
			return false;
		}
		if (Validator.isNull(user)) {
			try {
				user = UserLocalServiceUtil.addUser(0l, themeDisplay.getCompanyId(), false, password1, password2, false,
						screenName, emailAddress, themeDisplay.getLocale(), firstName, middleName, lastName,
						prefixValue, 0l, male, birthdayMonth, birthdayDay, birthdayYear, occupation,
						UserConstants.TYPE_REGULAR, null, null, null, null, true, serviceContext);
			} catch (PortalException e) {
				e.printStackTrace();
			}
		} else {
			user.setScreenName(screenName);
			user.setEmailAddress(emailAddress);
			user.setFirstName(firstName);
			user.setMiddleName(middleName);
			user.setLastName(lastName);
			user.setJobTitle(occupation);

			UserLocalServiceUtil.updateUser(user);
		}
		User users = UserLocalServiceUtil.fetchUserByScreenName(themeDisplay.getCompanyId(), screenName);

		
		  DriverDetail driverDetail =
		  DriverDetailLocalServiceUtil.getDriverDetail(users.getUserId(),
		  users.getCompanyId()); if (Validator.isNull(driverDetail)) { driverDetail =
		  DriverDetailLocalServiceUtil.createDriverDetail(CounterLocalServiceUtil.
		  increment()); } boolean isMale; try { // five field add other form
		  driverDetail.setUserId(user.getUserId());
		  driverDetail.setCompanyId(user.getCompanyId());
		  driverDetail.setDriverName(user.getFirstName());
		  driverDetail.setMobileNumber(user.getScreenName());
		  _log.error("User Screen Name :::::" + user.getScreenName()); isMale =
		  user.getMale(); String genderString = isMale ? "Male" : "Female";
		  driverDetail.setGender(genderString); driverDetail.setAge(age);
		  driverDetail.setDrivingLicenceId(drivingLicenceId);
		  driverDetail.setAadharNumber(aadharNumber); String portraitIdString =
		  String.valueOf(users.getPortraitId());
		  driverDetail.setDriverPhoto(portraitIdString);
		  driverDetail.setEmail(user.getEmailAddress());
		  driverDetail.setPassword(user.getPassword());
		  driverDetail.setCreateDate(user.getCreateDate());
		  driverDetail.setModifiedDate(user.getModifiedDate());
		  
		  DriverDetailLocalServiceUtil.updateDriverDetail(driverDetail); } catch
		  (PortalException setterException) {
		  
		  setterException.printStackTrace(); }
		 
		try {
			actionResponse.sendRedirect(redirectURL);
		} catch (IOException e) {
			_log.error("Error redirecting after account creation", e);
		}
		UploadPortletRequest uploadPortletRequest = PortalUtil.getUploadPortletRequest(actionRequest);
		File file = uploadPortletRequest.getFile("portraitImage");
		byte[] portraitBytes = null;
		try {
			portraitBytes = FileUtil.getBytes(file);
		} catch (IOException e) {
			_log.error("Error uploading portrait image", e);
		}

		if (Validator.isNotNull(portraitBytes)) {
			try {
				UserLocalServiceUtil.updatePortrait(user.getUserId(), portraitBytes);
			} catch (PortalException e) {
				_log.error("Error updating user portrait", e);
			}
		}
		return true;
	}

	protected void validate(String firstName, String lastName, String emailAddress, String screenName, String password1,
			String password2) throws PortalException {
		if (Validator.isNull(firstName)) {
			throw new PortalException("First name is required");
		}
		if (Validator.isNull(lastName)) {
			throw new PortalException("Last name is required");
		}
		if (Validator.isNull(emailAddress) || !Validator.isEmailAddress(emailAddress)) {
			throw new PortalException("Valid email address is required");
		}

		if (Validator.isNull(screenName)) {
			throw new PortalException("Screen name is required");
		}

		if (!password1.equals(password2)) {
			throw new PortalException("Passwords do not match");
		}
	}

	@Reference
	private Portal _portal;
}
