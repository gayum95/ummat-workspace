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
 * Provides a wrapper for {@link TravelUserService}.
 *
 * @author Brian Wing Shun Chan
 * @see TravelUserService
 * @generated
 */
public class TravelUserServiceWrapper
	implements ServiceWrapper<TravelUserService>, TravelUserService {

	public TravelUserServiceWrapper() {
		this(null);
	}

	public TravelUserServiceWrapper(TravelUserService travelUserService) {
		_travelUserService = travelUserService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _travelUserService.getOSGiServiceIdentifier();
	}

	@Override
	public ummat.travel.webservice.model.TravelUser getTravelUserDetailObj(
		long userId, long companyId) {

		return _travelUserService.getTravelUserDetailObj(userId, companyId);
	}

	@Override
	public TravelUserService getWrappedService() {
		return _travelUserService;
	}

	@Override
	public void setWrappedService(TravelUserService travelUserService) {
		_travelUserService = travelUserService;
	}

	private TravelUserService _travelUserService;

}