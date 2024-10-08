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

package com.ummat.slayer.service.impl;

import java.util.List;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.aop.AopService;
import com.ummat.slayer.model.District;
import com.ummat.slayer.service.base.DistrictServiceBaseImpl;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = {
		"json.web.service.context.name=",
		"json.web.service.context.path=District"
	},
	service = AopService.class
)
public class DistrictServiceImpl extends DistrictServiceBaseImpl {
	public List<District> getByRegionId(long regionId) {
		return districtPersistence.findByRegionId(regionId);
	}
	
	public List<District> getByRegionCode(String regionCode) {
		return districtPersistence.findByRegionCode(regionCode);
	}
}