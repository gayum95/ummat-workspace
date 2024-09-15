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

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link MatriUserService}.
 *
 * @author Brian Wing Shun Chan
 * @see MatriUserService
 * @generated
 */
public class MatriUserServiceWrapper
	implements MatriUserService, ServiceWrapper<MatriUserService> {

	public MatriUserServiceWrapper() {
		this(null);
	}

	public MatriUserServiceWrapper(MatriUserService matriUserService) {
		_matriUserService = matriUserService;
	}

	@Override
	public ummat_startup_details.model.MatriUser getMatriUserDetailObj(
		long userId, long companyId) {

		return _matriUserService.getMatriUserDetailObj(userId, companyId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _matriUserService.getOSGiServiceIdentifier();
	}

	@Override
	public MatriUserService getWrappedService() {
		return _matriUserService;
	}

	@Override
	public void setWrappedService(MatriUserService matriUserService) {
		_matriUserService = matriUserService;
	}

	private MatriUserService _matriUserService;

}