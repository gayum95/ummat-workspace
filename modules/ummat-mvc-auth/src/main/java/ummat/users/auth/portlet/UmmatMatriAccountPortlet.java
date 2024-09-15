package ummat.users.auth.portlet;

import javax.portlet.Portlet;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import org.osgi.service.component.annotations.Component;

import ummat.users.auth.constants.UmmatMatriAccountPortletKeys;

@Component(immediate = true, property = { "com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.instanceable=false", "javax.portlet.display-name=UmmatMatriCreateAccount",
		"javax.portlet.init-param.template-path=/", "javax.portlet.init-param.view-template=/Matri/create_account.jsp",
		"javax.portlet.name=" + UmmatMatriAccountPortletKeys.MATRI_CREATE_ACCOUNT,
		"javax.portlet.resource-bundle=content.Language", "com.liferay.portlet.requires-namespaced-parameters=false",
		"javax.portlet.init-param.add-process-action-success-action=false",
		"javax.portlet.security-role-ref=power-user,user" }, service = Portlet.class)
public class UmmatMatriAccountPortlet extends MVCPortlet {

}
