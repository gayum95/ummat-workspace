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

package ummat.travel.webservice.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link DriverDetailService}.
 *
 * @author Brian Wing Shun Chan
 * @see DriverDetailService
 * @generated
 */
public class DriverDetailServiceWrapper
	implements DriverDetailService, ServiceWrapper<DriverDetailService> {

	public DriverDetailServiceWrapper() {
		this(null);
	}

	public DriverDetailServiceWrapper(DriverDetailService driverDetailService) {
		_driverDetailService = driverDetailService;
	}

	@Override
	public ummat.travel.webservice.model.DriverDetail getDriverDetailObj(
		long userId, long companyId) {

		return _driverDetailService.getDriverDetailObj(userId, companyId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _driverDetailService.getOSGiServiceIdentifier();
	}

	@Override
	public DriverDetailService getWrappedService() {
		return _driverDetailService;
	}

	@Override
	public void setWrappedService(DriverDetailService driverDetailService) {
		_driverDetailService = driverDetailService;
	}

	private DriverDetailService _driverDetailService;

}