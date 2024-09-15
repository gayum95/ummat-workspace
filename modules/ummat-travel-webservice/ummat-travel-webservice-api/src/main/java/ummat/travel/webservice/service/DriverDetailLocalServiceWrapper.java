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
 * Provides a wrapper for {@link DriverDetailLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see DriverDetailLocalService
 * @generated
 */
public class DriverDetailLocalServiceWrapper
	implements DriverDetailLocalService,
			   ServiceWrapper<DriverDetailLocalService> {

	public DriverDetailLocalServiceWrapper() {
		this(null);
	}

	public DriverDetailLocalServiceWrapper(
		DriverDetailLocalService driverDetailLocalService) {

		_driverDetailLocalService = driverDetailLocalService;
	}

	/**
	 * Adds the driver detail to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DriverDetailLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param driverDetail the driver detail
	 * @return the driver detail that was added
	 */
	@Override
	public ummat.travel.webservice.model.DriverDetail addDriverDetail(
		ummat.travel.webservice.model.DriverDetail driverDetail) {

		return _driverDetailLocalService.addDriverDetail(driverDetail);
	}

	/**
	 * Creates a new driver detail with the primary key. Does not add the driver detail to the database.
	 *
	 * @param driverId the primary key for the new driver detail
	 * @return the new driver detail
	 */
	@Override
	public ummat.travel.webservice.model.DriverDetail createDriverDetail(
		long driverId) {

		return _driverDetailLocalService.createDriverDetail(driverId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _driverDetailLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the driver detail from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DriverDetailLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param driverDetail the driver detail
	 * @return the driver detail that was removed
	 */
	@Override
	public ummat.travel.webservice.model.DriverDetail deleteDriverDetail(
		ummat.travel.webservice.model.DriverDetail driverDetail) {

		return _driverDetailLocalService.deleteDriverDetail(driverDetail);
	}

	/**
	 * Deletes the driver detail with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DriverDetailLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param driverId the primary key of the driver detail
	 * @return the driver detail that was removed
	 * @throws PortalException if a driver detail with the primary key could not be found
	 */
	@Override
	public ummat.travel.webservice.model.DriverDetail deleteDriverDetail(
			long driverId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _driverDetailLocalService.deleteDriverDetail(driverId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _driverDetailLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _driverDetailLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _driverDetailLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _driverDetailLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _driverDetailLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ummat.travel.webservice.model.impl.DriverDetailModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _driverDetailLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ummat.travel.webservice.model.impl.DriverDetailModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _driverDetailLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _driverDetailLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _driverDetailLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public ummat.travel.webservice.model.DriverDetail fetchDriverDetail(
		long driverId) {

		return _driverDetailLocalService.fetchDriverDetail(driverId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _driverDetailLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the driver detail with the primary key.
	 *
	 * @param driverId the primary key of the driver detail
	 * @return the driver detail
	 * @throws PortalException if a driver detail with the primary key could not be found
	 */
	@Override
	public ummat.travel.webservice.model.DriverDetail getDriverDetail(
			long driverId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _driverDetailLocalService.getDriverDetail(driverId);
	}

	@Override
	public ummat.travel.webservice.model.DriverDetail getDriverDetail(
		long userId, long companyId) {

		return _driverDetailLocalService.getDriverDetail(userId, companyId);
	}

	/**
	 * Returns a range of all the driver details.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ummat.travel.webservice.model.impl.DriverDetailModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of driver details
	 * @param end the upper bound of the range of driver details (not inclusive)
	 * @return the range of driver details
	 */
	@Override
	public java.util.List<ummat.travel.webservice.model.DriverDetail>
		getDriverDetails(int start, int end) {

		return _driverDetailLocalService.getDriverDetails(start, end);
	}

	/**
	 * Returns the number of driver details.
	 *
	 * @return the number of driver details
	 */
	@Override
	public int getDriverDetailsCount() {
		return _driverDetailLocalService.getDriverDetailsCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _driverDetailLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _driverDetailLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _driverDetailLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the driver detail in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DriverDetailLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param driverDetail the driver detail
	 * @return the driver detail that was updated
	 */
	@Override
	public ummat.travel.webservice.model.DriverDetail updateDriverDetail(
		ummat.travel.webservice.model.DriverDetail driverDetail) {

		return _driverDetailLocalService.updateDriverDetail(driverDetail);
	}

	@Override
	public DriverDetailLocalService getWrappedService() {
		return _driverDetailLocalService;
	}

	@Override
	public void setWrappedService(
		DriverDetailLocalService driverDetailLocalService) {

		_driverDetailLocalService = driverDetailLocalService;
	}

	private DriverDetailLocalService _driverDetailLocalService;

}