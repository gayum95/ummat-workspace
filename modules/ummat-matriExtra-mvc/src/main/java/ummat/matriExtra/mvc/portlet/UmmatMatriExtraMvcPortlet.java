package ummat.matriExtra.mvc.portlet;

import ummat.matriExtra.mvc.constants.UmmatMatriExtraMvcPortletKeys;
import ummat.matriExtra.slayer.service.MatriUserImageLocalServiceUtil;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;

import org.osgi.service.component.annotations.Component;

/**
 * @author USER
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=UmmatMatriExtraMvc",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + UmmatMatriExtraMvcPortletKeys.UMMATMATRIEXTRAMVC,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class UmmatMatriExtraMvcPortlet extends MVCPortlet {
	
	private static final Logger LOGGER = Logger.getLogger(UmmatMatriExtraMvcPortlet.class.getName());

    public void uploadImage(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
    	ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
    
        long userId = ParamUtil.getLong(actionRequest, "userId");
        String userName = ParamUtil.getString(actionRequest, "userName");
        long matriUserId = ParamUtil.getLong(actionRequest, "matriUserId");

        try {
            InputStream imageOne = actionRequest.getPortletInputStream();
            InputStream imageTwo = actionRequest.getPortletInputStream();
            InputStream imageThree = actionRequest.getPortletInputStream();
            InputStream imageFour = actionRequest.getPortletInputStream();

            System.out.println("Image 1::::::"+imageOne);
            LOGGER.info("Image 1::::::"+imageOne);
            LOGGER.info("Image 2::::::"+imageTwo);
            LOGGER.info("Image 3::::::"+imageThree);
            LOGGER.info("Image 4::::::"+imageFour);
            MatriUserImageLocalServiceUtil.addMatriUserImage(userId, userName, matriUserId, imageOne, imageTwo, imageThree, imageFour);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Error uploading image", e);
            throw e;
        }
    }
}