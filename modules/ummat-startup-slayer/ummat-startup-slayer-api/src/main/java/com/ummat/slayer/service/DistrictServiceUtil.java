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

package com.ummat.slayer.service;

import com.ummat.slayer.model.District;

import java.util.List;

/**
 * Provides the remote service utility for District. This utility wraps
 * <code>com.ummat.slayer.service.impl.DistrictServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see DistrictService
 * @generated
 */
public class DistrictServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.ummat.slayer.service.impl.DistrictServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static List<District> getByRegionCode(String regionCode) {
		return getService().getByRegionCode(regionCode);
	}

	public static List<District> getByRegionId(long regionId) {
		return getService().getByRegionId(regionId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static DistrictService getService() {
		return _service;
	}

	private static volatile DistrictService _service;

}