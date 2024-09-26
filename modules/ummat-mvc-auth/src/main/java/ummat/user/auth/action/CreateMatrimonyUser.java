package ummat.user.auth.action;


import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.UserConstants;
import com.liferay.portal.kernel.model.UserGroup;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.service.GroupLocalServiceUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserGroupLocalServiceUtil;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.ummat.slayer.model.District;
import com.ummat.slayer.service.DistrictLocalServiceUtil;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import ummat.users.auth.constants.UmmatMatriAccountPortletKeys;
import ummat_startup_details.model.MatriUser;
import ummat_startup_details.service.MatriUserLocalServiceUtil;
import ummat_startup_details.service.MatriUserServiceUtil;

@Component(immediate = true, property = { "javax.portlet.name=" + UmmatMatriAccountPortletKeys.MATRI_CREATE_ACCOUNT,
		
		"mvc.command.name=/login/create_account" }, service = MVCActionCommand.class)
public class CreateMatrimonyUser implements MVCActionCommand {

	@Override
	public boolean processAction(ActionRequest actionRequest, ActionResponse actionResponse) throws PortletException {
		HttpServletRequest httpServletRequest = _portal.getHttpServletRequest(actionRequest);
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		 String redirectURL = ParamUtil.getString(actionRequest, "redirectURL");

		String screenName = ParamUtil.getString(actionRequest, "screenName", null);
		String emailAddress = ParamUtil.getString(actionRequest, "emailAddress", null);
		String firstName = ParamUtil.getString(actionRequest, "firstName", null);
		String lastName = ParamUtil.getString(actionRequest, "lastName", null);
		String middleName = ParamUtil.getString(actionRequest, "middleName", null);
		long prefixValue = ParamUtil.getLong(actionRequest, "prefixValue", 0);
		boolean male = ParamUtil.getBoolean(actionRequest, "male", true);
		String occupation = ParamUtil.getString(actionRequest, "occupation", null);
		int birthdayMonth = ParamUtil.getInteger(actionRequest, "birthdayMonth");
		int birthdayDay = ParamUtil.getInteger(actionRequest, "birthdayDay");
		int birthdayYear = ParamUtil.getInteger(actionRequest, "birthdayYear");
		//System.out.println(countryId1);
		String stateId = ParamUtil.getString(actionRequest, "state");
		long districtId = ParamUtil.getLong(actionRequest, "district");
		String area = ParamUtil.getString(actionRequest, "area");
		String maritalStatus = ParamUtil.getString(actionRequest, "maritalStatus", null);
		String education = ParamUtil.getString(actionRequest, "education", null);
		String othereducation = ParamUtil.getString(actionRequest, "othereducation");
		Double height = ParamUtil.getDouble(actionRequest, "height", null);
		Double weight = ParamUtil.getDouble(actionRequest, "weight", null);
		String jamath = ParamUtil.getString(actionRequest, "jamath", null);
		String[] jamathValues = ParamUtil.getStringValues(actionRequest, "jamathValues");
		
		String color = ParamUtil.getString(actionRequest, "color", null);
		String bio = ParamUtil.getString(actionRequest, "bio",null);
		String malechild = ParamUtil.getString(actionRequest, "malechild",null);
		String femalechild = ParamUtil.getString(actionRequest, "femalechild",null);
		String otherjamath = ParamUtil.getString(actionRequest, "otherjamath");
		String MothertongueLanguage = ParamUtil.getString(actionRequest, "MothertongueLanguage",null);
		String LivingPlace = ParamUtil.getString(actionRequest, "LivingPlace",null);
		Double Monthlyincome = ParamUtil.getDouble(actionRequest, "Monthlyincome",null);
		
		String password1 = ParamUtil.getString(actionRequest, "password1", null);
		String password2 = ParamUtil.getString(actionRequest, "password2", null);
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
						prefixValue, 0l, male,birthdayMonth, birthdayDay, birthdayYear,occupation, UserConstants.TYPE_REGULAR,
						null, null, null, null, true, serviceContext);
			} catch (PortalException e) {
				e.printStackTrace();
			}
		} else {
			
			user.setEmailAddress(emailAddress);
			user.setFirstName(firstName);
			user.setMiddleName(middleName);
			user.setLastName(lastName);
			user.setJobTitle(occupation);
			user.setStatus(6);
			
			
			UserLocalServiceUtil.updateUser(user);
		}
		User users = UserLocalServiceUtil.fetchUserByScreenName(themeDisplay.getCompanyId(), screenName);
		
		MatriUser matriUser = MatriUserServiceUtil.getMatriUserDetailObj(users.getUserId(), users.getCompanyId());
		if (Validator.isNull(matriUser)) {
			matriUser = MatriUserLocalServiceUtil.createMatriUser(CounterLocalServiceUtil.increment());
		}
		

		matriUser.setUserId(users.getUserId());
		matriUser.setImageId(users.getPortraitId());
		matriUser.setEducation(education);
		matriUser.setHeight(height);
		matriUser.setWeight(weight);
		
		
		matriUser.setState(stateId);
		matriUser.setDistrict(districtId);
		matriUser.setArea(area);
		if ("Others".equals(jamath) && jamathValues != null && jamathValues.length > 0) {
		    // If "Others" is selected, set the jamath property to the value entered in the textarea
		    matriUser.setJamath(jamathValues[0]);
		} else {
		    // If a predefined jamath is selected, set the jamath property to that value
		    matriUser.setJamath(jamath);
		}
		
		matriUser.setMaritalStatus(maritalStatus);
		matriUser.setColor(color);
		matriUser.setBio(bio);
		matriUser.setMalechild(malechild);
		matriUser.setFemalechild(femalechild);
		matriUser.setMothertongueLanguage(MothertongueLanguage);
		matriUser.setMonthlyincome(Monthlyincome);
		matriUser.setLivingPlace(LivingPlace);
	
		MatriUserLocalServiceUtil.updateMatriUser(matriUser);
		
		/*
		 * UploadPortletRequest uploadPortletRequest =
		 * PortalUtil.getUploadPortletRequest(actionRequest); File file =
		 * uploadPortletRequest.getFile("portraitImage"); byte[] portraitBytes = null;
		 * try { portraitBytes = FileUtil.getBytes(file); System.out.println("hello1");
		 * } catch (IOException e2) {
		 * 
		 * e2.printStackTrace(); }
		 * 
		 * if (portraitBytes != null) { try { user =
		 * UserLocalServiceUtil.updatePortrait(user.getUserId(), portraitBytes);
		 * System.out.println("hello"); } catch (PortalException e) {
		 * 
		 * e.printStackTrace(); } user.setJobTitle(occupation);
		 * UserLocalServiceUtil.updateUser(user); }
		 */
		UploadPortletRequest uploadPortletRequest = PortalUtil.getUploadPortletRequest(actionRequest);
		File file = uploadPortletRequest.getFile("portraitImage");
		byte[] portraitBytes = null;
		try {
			portraitBytes = FileUtil.getBytes(file);
		} catch (IOException e2) {
			
			e2.printStackTrace();
		}
		if (portraitBytes != null) {
			try {
				user = UserLocalServiceUtil.updatePortrait(user.getUserId(), portraitBytes);
			} catch (PortalException e) {
			
				e.printStackTrace();
			}
			
			UserLocalServiceUtil.updateUser(user);
		}
		if (user.getStatus() == WorkflowConstants.STATUS_APPROVED) {
			SessionMessages.add(httpServletRequest, "userAdded", user.getEmailAddress());
		} else {
			SessionMessages.add(httpServletRequest, "userPending", user.getEmailAddress());
		}

		// Send redirect
		// User Group Creation
		District districtObj;
		try {
			districtObj = DistrictLocalServiceUtil.getDistrict(districtId);

			Group group = GroupLocalServiceUtil.getGroup(PortalUtil.getDefaultCompanyId(), "Guest");
			UserGroup userGroup = null;
			try {
				userGroup = UserGroupLocalServiceUtil.getUserGroup(user.getCompanyId(), districtObj.getName());
				UserLocalServiceUtil.addUserGroupUser(userGroup.getUserGroupId(), user);
			} catch (PortalException e) {
				_log.warn(e.getMessage());
				if (Validator.isNull(userGroup)) {
					userGroup = UserGroupLocalServiceUtil.addUserGroup(user.getUserId(), user.getCompanyId(),
							districtObj.getName(), "This User Group is created for "
									+ districtObj.getName().toUpperCase() + " District People...",
							serviceContext);
					UserLocalServiceUtil.addUserGroupUser(userGroup.getUserGroupId(), user);
				}
			}
			if (Validator.isNotNull(group) && Validator.isNotNull(userGroup)) {
				if (!UserGroupLocalServiceUtil.hasGroupUserGroup(group.getGroupId(), userGroup.getUserGroupId())) {
					UserGroupLocalServiceUtil.addGroupUserGroup(group.getGroupId(), userGroup);
				}
			}
			List<UserGroup> userGroups = UserGroupLocalServiceUtil.getGroupUserGroups(group.getGroupId());
			_log.info("User groups: :::::: " + userGroups);
		} catch (PortalException e1) {
			
			e1.printStackTrace();
		}
		 try {
		        actionResponse.sendRedirect(redirectURL);
		    } catch (IOException e) {
		        _log.error("Error redirecting after account creation", e);
		    }
		
		return true;
	}

	private static final Log _log = LogFactoryUtil.getLog(CreateMatrimonyUser.class);
	@Reference
	private Portal _portal;
}
