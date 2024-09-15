package com.ummat.auth.portlet;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.ummat.auth.constants.UmmatTravelAuthPortletKeys;

import javax.portlet.Portlet;

import org.osgi.service.component.annotations.Component;

@Component(immediate = true, property = { "com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css", "com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=UmmatDriverAuth", "javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/Travel/driver_account.jsp",
		"javax.portlet.name=" + UmmatTravelAuthPortletKeys.DriverDetailUserAUTH,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user" }, service = Portlet.class)
public class UmmatDriverDetailAuthPortlet extends MVCPortlet {

}
