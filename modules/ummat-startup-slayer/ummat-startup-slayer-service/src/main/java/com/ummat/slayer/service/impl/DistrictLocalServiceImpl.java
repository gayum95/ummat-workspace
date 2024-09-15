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
import java.util.stream.Collectors;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.UserGroup;
import com.liferay.portal.kernel.service.UserGroupLocalServiceUtil;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.ummat.slayer.model.District;
import com.ummat.slayer.service.base.DistrictLocalServiceBaseImpl;

/**
 * @author Brian Wing Shun Chan
 */
@Component(property = "model.class.name=com.ummat.slayer.model.District", service = AopService.class)
public class DistrictLocalServiceImpl extends DistrictLocalServiceBaseImpl {
	public List<District> getByRegionId(long regionId) {
		return districtPersistence.findByRegionId(regionId);
	}

	public List<District> getByRegionCode(String regionCode) {
		return districtPersistence.findByRegionCode(regionCode);
	}

	public List<UserGroup> getUserGroupsByDistrict(String districtName) throws PortalException {
		return UserGroupLocalServiceUtil.getUserGroups(-1, -1).stream()
				.filter(userGroup -> userGroup.getName().equalsIgnoreCase(districtName)).collect(Collectors.toList());
	}

	public int getUserCountInUserGroup(long userGroupId) throws PortalException {
		return UserLocalServiceUtil.getUserGroupUsersCount(userGroupId);
	}
}