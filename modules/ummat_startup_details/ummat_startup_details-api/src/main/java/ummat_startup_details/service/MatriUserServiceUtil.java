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

package ummat_startup_details.service;

import ummat_startup_details.model.MatriUser;

/**
 * Provides the remote service utility for MatriUser. This utility wraps
 * <code>ummat_startup_details.service.impl.MatriUserServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see MatriUserService
 * @generated
 */
public class MatriUserServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>ummat_startup_details.service.impl.MatriUserServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static MatriUser getMatriUserDetailObj(long userId, long companyId) {
		return getService().getMatriUserDetailObj(userId, companyId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static MatriUserService getService() {
		return _service;
	}

	private static volatile MatriUserService _service;

}