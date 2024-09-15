/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package ummat.travel.webservice.service.impl;

import com.liferay.portal.aop.AopService;

import org.osgi.service.component.annotations.Component;

import ummat.travel.webservice.model.TravelUser;
import ummat.travel.webservice.service.base.TravelUserServiceBaseImpl;

/**
 * @author Brian Wing Shun Chan
 */
@Component(property = { "json.web.service.context.name=ummatlife",
		"json.web.service.context.path=TravelUser" }, service = AopService.class)
public class TravelUserServiceImpl extends TravelUserServiceBaseImpl {

	public TravelUser getTravelUserDetailObj(long userId, long companyId) {
		return travelUserPersistence.fetchByFind_TravelUsers_First(userId, companyId, null);
	}
}