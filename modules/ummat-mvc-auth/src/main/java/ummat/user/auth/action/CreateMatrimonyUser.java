package ummat.user.auth.action;


import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.document.library.kernel.model.DLFileEntry;
import com.liferay.document.library.kernel.model.DLFolderConstants;
import com.liferay.document.library.kernel.service.DLAppServiceUtil;
import com.liferay.document.library.kernel.service.DLFileEntryLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.RegionCodeException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Country;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.Region;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.UserConstants;
import com.liferay.portal.kernel.model.UserGroup;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.repository.model.Folder;
import com.liferay.portal.kernel.service.CountryLocalServiceUtil;
import com.liferay.portal.kernel.service.GroupLocalServiceUtil;
import com.liferay.portal.kernel.service.RegionLocalServiceUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.service.UserGroupLocalServiceUtil;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.kernel.util.MimeTypesUtil;
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
import java.util.Date;
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
public class CreateMatrimonyUser implements MVCActionCommand   {

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
	    long countryId1 = ParamUtil.getLong(actionRequest, "country");
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
	    String bio = ParamUtil.getString(actionRequest, "bio", null);
	    String malechild = ParamUtil.getString(actionRequest, "malechild", null);
	    String femalechild = ParamUtil.getString(actionRequest, "femalechild", null);
	    String otherjamath = ParamUtil.getString(actionRequest, "otherjamath");
	    String MothertongueLanguage = ParamUtil.getString(actionRequest, "MothertongueLanguage", null);
	    String LivingPlace = ParamUtil.getString(actionRequest, "LivingPlace", null);
	    Double Monthlyincome = ParamUtil.getDouble(actionRequest, "Monthlyincome", null);
	    String password1 = ParamUtil.getString(actionRequest, "password1", null);
	    String password2 = ParamUtil.getString(actionRequest, "password2", null);

	    ServiceContext serviceContext;
	    try {
	        serviceContext = ServiceContextFactory.getInstance(User.class.getName(), actionRequest);
	    } catch (PortalException e) {
	        _log.error("Error getting service context", e);
	        
	        return false;
	    }

        if (Validator.isNull(screenName) || Validator.isNull(emailAddress) || Validator.isNull(firstName) ||
                Validator.isNull(lastName) || Validator.isNull(password1) || Validator.isNull(password2)) {
            SessionErrors.add(actionRequest, "fields-required");
            return false;
        }

      
        if (!password1.equals(password2)) {
            SessionErrors.add(actionRequest, "password-mismatch");
            return false;
        }

        
        if (!Validator.isNull(height) && !Validator.isNumber(height.toString())) {
            SessionErrors.add(actionRequest, "invalid-height");
            return false;
        }
        if (!Validator.isNull(weight) && !Validator.isNumber(weight.toString())) {
            SessionErrors.add(actionRequest, "invalid-weight");
            return false;
        }
        if (!Validator.isNull(Monthlyincome) && !Validator.isNumber(Monthlyincome.toString())) {
            SessionErrors.add(actionRequest, "invalid-income");
            return false;
        }

       
        if (countryId1 <= 0 || Validator.isNull(stateId) || districtId <= 0 ||
                birthdayMonth <= 0 || birthdayDay <= 0 || birthdayYear <= 0) {
            SessionErrors.add(actionRequest, "dropdowns-required");
            return false;
        }

       
        if ("Others".equals(jamath) && (Validator.isNull(jamathValues) || jamathValues.length == 0)) {
            SessionErrors.add(actionRequest, "jamath-required");
            return false;
        }

	    try {
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

	    if (Validator.isNull(screenName) || Validator.isNull(emailAddress) || Validator.isNull(firstName) || Validator.isNull(lastName) || Validator.isNull(password1) || Validator.isNull(password2)) {
	        SessionErrors.add(actionRequest, "fields-required");
	        return false;
	    }

	    if (!Validator.isEmailAddress(emailAddress)) {
	        SessionErrors.add(actionRequest, "invalid-email-address");
	        return false;
	    }

	    if (!password1.equals(password2)) {
	        SessionErrors.add(actionRequest, "passwords-do-not-match");
	        return false;
	    }

	    User user = UserLocalServiceUtil.fetchUserByScreenName(themeDisplay.getCompanyId(), screenName);
	    if (Validator.isNull(user)) {
	        try {
	            Country countryObj = CountryLocalServiceUtil.getCountryByName(20096, "india");
	            long countryId = countryObj.getCountryId();
	            System.out.println(countryId);
	            Region regionObj = RegionLocalServiceUtil.getRegion(countryId, stateId);
	            user = UserLocalServiceUtil.addUser(0L, themeDisplay.getCompanyId(), false, password1, password2, false,
	                    screenName, emailAddress, themeDisplay.getLocale(), firstName, middleName, lastName,
	                    prefixValue, 0L, male, birthdayMonth, birthdayDay, birthdayYear, occupation, UserConstants.TYPE_REGULAR,
	                    null, null, null, null, true, serviceContext);
	        } catch (PortalException e) {
	            _log.error("Error creating user", e);
	            return false;
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
	        matriUser.setJamath(jamathValues[0]);
	    } else {
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

        District districtObj = DistrictLocalServiceUtil.getDistrict(districtId);
        Group group = GroupLocalServiceUtil.getGroup(PortalUtil.getDefaultCompanyId(), "Guest");
        UserGroup userGroup = UserGroupLocalServiceUtil.getUserGroup(themeDisplay.getCompanyId(), districtObj.getName());

        if (Validator.isNull(userGroup)) {
            userGroup = UserGroupLocalServiceUtil.addUserGroup(user.getUserId(), themeDisplay.getCompanyId(),
                    districtObj.getName(), "User Group for " + districtObj.getName().toUpperCase(), serviceContext);
        }

        if (!UserGroupLocalServiceUtil.hasGroupUserGroup(group.getGroupId(), userGroup.getUserGroupId())) {
            UserGroupLocalServiceUtil.addGroupUserGroup(group.getGroupId(), userGroup);
        }
        
        
        List<UserGroup> userGroups = UserGroupLocalServiceUtil.getGroupUserGroups(group.getGroupId());
        _log.info("User groups: " + userGroups);

        SessionMessages.add(actionRequest, "userAdded", user.getEmailAddress());
        actionResponse.sendRedirect(redirectURL);
    } catch (PortalException | IOException e) {
    	
        _log.error("Error processing user creation action", e);
        SessionErrors.add(actionRequest, "user-creation-error");
        return false;
    }

    return true;
}

private static final Log _log = LogFactoryUtil.getLog(CreateMatrimonyUser.class);

@Reference
private Portal _portal;

    
   }