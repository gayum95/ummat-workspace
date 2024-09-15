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
 * Provides a wrapper for {@link TravelUserLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see TravelUserLocalService
 * @generated
 */
public class TravelUserLocalServiceWrapper
	implements ServiceWrapper<TravelUserLocalService>, TravelUserLocalService {

	public TravelUserLocalServiceWrapper() {
		this(null);
	}

	public TravelUserLocalServiceWrapper(
		TravelUserLocalService travelUserLocalService) {

		_travelUserLocalService = travelUserLocalService;
	}

	/**
	 * Adds the travel user to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TravelUserLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param travelUser the travel user
	 * @return the travel user that was added
	 */
	@Override
	public ummat.travel.webservice.model.TravelUser addTravelUser(
		ummat.travel.webservice.model.TravelUser travelUser) {

		return _travelUserLocalService.addTravelUser(travelUser);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _travelUserLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new travel user with the primary key. Does not add the travel user to the database.
	 *
	 * @param travelUserId the primary key for the new travel user
	 * @return the new travel user
	 */
	@Override
	public ummat.travel.webservice.model.TravelUser createTravelUser(
		long travelUserId) {

		return _travelUserLocalService.createTravelUser(travelUserId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _travelUserLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the travel user with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TravelUserLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param travelUserId the primary key of the travel user
	 * @return the travel user that was removed
	 * @throws PortalException if a travel user with the primary key could not be found
	 */
	@Override
	public ummat.travel.webservice.model.TravelUser deleteTravelUser(
			long travelUserId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _travelUserLocalService.deleteTravelUser(travelUserId);
	}

	/**
	 * Deletes the travel user from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TravelUserLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param travelUser the travel user
	 * @return the travel user that was removed
	 */
	@Override
	public ummat.travel.webservice.model.TravelUser deleteTravelUser(
		ummat.travel.webservice.model.TravelUser travelUser) {

		return _travelUserLocalService.deleteTravelUser(travelUser);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _travelUserLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _travelUserLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _travelUserLocalService.dynamicQuery();
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

		return _travelUserLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ummat.travel.webservice.model.impl.TravelUserModelImpl</code>.
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

		return _travelUserLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ummat.travel.webservice.model.impl.TravelUserModelImpl</code>.
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

		return _travelUserLocalService.dynamicQuery(
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

		return _travelUserLocalService.dynamicQueryCount(dynamicQuery);
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

		return _travelUserLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public ummat.travel.webservice.model.TravelUser fetchTravelUser(
		long travelUserId) {

		return _travelUserLocalService.fetchTravelUser(travelUserId);
	}

	/**
	 * Returns the travel user with the matching UUID and company.
	 *
	 * @param uuid the travel user's UUID
	 * @param companyId the primary key of the company
	 * @return the matching travel user, or <code>null</code> if a matching travel user could not be found
	 */
	@Override
	public ummat.travel.webservice.model.TravelUser
		fetchTravelUserByUuidAndCompanyId(String uuid, long companyId) {

		return _travelUserLocalService.fetchTravelUserByUuidAndCompanyId(
			uuid, companyId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _travelUserLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _travelUserLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _travelUserLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _travelUserLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _travelUserLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the travel user with the primary key.
	 *
	 * @param travelUserId the primary key of the travel user
	 * @return the travel user
	 * @throws PortalException if a travel user with the primary key could not be found
	 */
	@Override
	public ummat.travel.webservice.model.TravelUser getTravelUser(
			long travelUserId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _travelUserLocalService.getTravelUser(travelUserId);
	}

	/**
	 * Returns the travel user with the matching UUID and company.
	 *
	 * @param uuid the travel user's UUID
	 * @param companyId the primary key of the company
	 * @return the matching travel user
	 * @throws PortalException if a matching travel user could not be found
	 */
	@Override
	public ummat.travel.webservice.model.TravelUser
			getTravelUserByUuidAndCompanyId(String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _travelUserLocalService.getTravelUserByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of all the travel users.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ummat.travel.webservice.model.impl.TravelUserModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of travel users
	 * @param end the upper bound of the range of travel users (not inclusive)
	 * @return the range of travel users
	 */
	@Override
	public java.util.List<ummat.travel.webservice.model.TravelUser>
		getTravelUsers(int start, int end) {

		return _travelUserLocalService.getTravelUsers(start, end);
	}

	@Override
	public ummat.travel.webservice.model.TravelUser getTravelUsers(
		long userId, long companyId) {

		return _travelUserLocalService.getTravelUsers(userId, companyId);
	}

	/**
	 * Returns the number of travel users.
	 *
	 * @return the number of travel users
	 */
	@Override
	public int getTravelUsersCount() {
		return _travelUserLocalService.getTravelUsersCount();
	}

	/**
	 * Updates the travel user in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TravelUserLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param travelUser the travel user
	 * @return the travel user that was updated
	 */
	@Override
	public ummat.travel.webservice.model.TravelUser updateTravelUser(
		ummat.travel.webservice.model.TravelUser travelUser) {

		return _travelUserLocalService.updateTravelUser(travelUser);
	}

	@Override
	public TravelUserLocalService getWrappedService() {
		return _travelUserLocalService;
	}

	@Override
	public void setWrappedService(
		TravelUserLocalService travelUserLocalService) {

		_travelUserLocalService = travelUserLocalService;
	}

	private TravelUserLocalService _travelUserLocalService;

}