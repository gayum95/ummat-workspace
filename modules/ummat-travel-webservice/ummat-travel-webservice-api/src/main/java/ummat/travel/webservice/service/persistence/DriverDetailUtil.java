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

package ummat.travel.webservice.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import ummat.travel.webservice.model.DriverDetail;

/**
 * The persistence utility for the driver detail service. This utility wraps <code>ummat.travel.webservice.service.persistence.impl.DriverDetailPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DriverDetailPersistence
 * @generated
 */
public class DriverDetailUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(DriverDetail driverDetail) {
		getPersistence().clearCache(driverDetail);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, DriverDetail> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<DriverDetail> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<DriverDetail> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<DriverDetail> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<DriverDetail> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static DriverDetail update(DriverDetail driverDetail) {
		return getPersistence().update(driverDetail);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static DriverDetail update(
		DriverDetail driverDetail, ServiceContext serviceContext) {

		return getPersistence().update(driverDetail, serviceContext);
	}

	/**
	 * Returns the driver detail where driverId = &#63; or throws a <code>NoSuchDriverDetailException</code> if it could not be found.
	 *
	 * @param driverId the driver ID
	 * @return the matching driver detail
	 * @throws NoSuchDriverDetailException if a matching driver detail could not be found
	 */
	public static DriverDetail findByfindByDriverId(long driverId)
		throws ummat.travel.webservice.exception.NoSuchDriverDetailException {

		return getPersistence().findByfindByDriverId(driverId);
	}

	/**
	 * Returns the driver detail where driverId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param driverId the driver ID
	 * @return the matching driver detail, or <code>null</code> if a matching driver detail could not be found
	 */
	public static DriverDetail fetchByfindByDriverId(long driverId) {
		return getPersistence().fetchByfindByDriverId(driverId);
	}

	/**
	 * Returns the driver detail where driverId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param driverId the driver ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching driver detail, or <code>null</code> if a matching driver detail could not be found
	 */
	public static DriverDetail fetchByfindByDriverId(
		long driverId, boolean useFinderCache) {

		return getPersistence().fetchByfindByDriverId(driverId, useFinderCache);
	}

	/**
	 * Removes the driver detail where driverId = &#63; from the database.
	 *
	 * @param driverId the driver ID
	 * @return the driver detail that was removed
	 */
	public static DriverDetail removeByfindByDriverId(long driverId)
		throws ummat.travel.webservice.exception.NoSuchDriverDetailException {

		return getPersistence().removeByfindByDriverId(driverId);
	}

	/**
	 * Returns the number of driver details where driverId = &#63;.
	 *
	 * @param driverId the driver ID
	 * @return the number of matching driver details
	 */
	public static int countByfindByDriverId(long driverId) {
		return getPersistence().countByfindByDriverId(driverId);
	}

	/**
	 * Returns the driver detail where userId = &#63; and companyId = &#63; or throws a <code>NoSuchDriverDetailException</code> if it could not be found.
	 *
	 * @param userId the user ID
	 * @param companyId the company ID
	 * @return the matching driver detail
	 * @throws NoSuchDriverDetailException if a matching driver detail could not be found
	 */
	public static DriverDetail findByFind_DriverDetail(
			long userId, long companyId)
		throws ummat.travel.webservice.exception.NoSuchDriverDetailException {

		return getPersistence().findByFind_DriverDetail(userId, companyId);
	}

	/**
	 * Returns the driver detail where userId = &#63; and companyId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param userId the user ID
	 * @param companyId the company ID
	 * @return the matching driver detail, or <code>null</code> if a matching driver detail could not be found
	 */
	public static DriverDetail fetchByFind_DriverDetail(
		long userId, long companyId) {

		return getPersistence().fetchByFind_DriverDetail(userId, companyId);
	}

	/**
	 * Returns the driver detail where userId = &#63; and companyId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param userId the user ID
	 * @param companyId the company ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching driver detail, or <code>null</code> if a matching driver detail could not be found
	 */
	public static DriverDetail fetchByFind_DriverDetail(
		long userId, long companyId, boolean useFinderCache) {

		return getPersistence().fetchByFind_DriverDetail(
			userId, companyId, useFinderCache);
	}

	/**
	 * Removes the driver detail where userId = &#63; and companyId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param companyId the company ID
	 * @return the driver detail that was removed
	 */
	public static DriverDetail removeByFind_DriverDetail(
			long userId, long companyId)
		throws ummat.travel.webservice.exception.NoSuchDriverDetailException {

		return getPersistence().removeByFind_DriverDetail(userId, companyId);
	}

	/**
	 * Returns the number of driver details where userId = &#63; and companyId = &#63;.
	 *
	 * @param userId the user ID
	 * @param companyId the company ID
	 * @return the number of matching driver details
	 */
	public static int countByFind_DriverDetail(long userId, long companyId) {
		return getPersistence().countByFind_DriverDetail(userId, companyId);
	}

	/**
	 * Caches the driver detail in the entity cache if it is enabled.
	 *
	 * @param driverDetail the driver detail
	 */
	public static void cacheResult(DriverDetail driverDetail) {
		getPersistence().cacheResult(driverDetail);
	}

	/**
	 * Caches the driver details in the entity cache if it is enabled.
	 *
	 * @param driverDetails the driver details
	 */
	public static void cacheResult(List<DriverDetail> driverDetails) {
		getPersistence().cacheResult(driverDetails);
	}

	/**
	 * Creates a new driver detail with the primary key. Does not add the driver detail to the database.
	 *
	 * @param driverId the primary key for the new driver detail
	 * @return the new driver detail
	 */
	public static DriverDetail create(long driverId) {
		return getPersistence().create(driverId);
	}

	/**
	 * Removes the driver detail with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param driverId the primary key of the driver detail
	 * @return the driver detail that was removed
	 * @throws NoSuchDriverDetailException if a driver detail with the primary key could not be found
	 */
	public static DriverDetail remove(long driverId)
		throws ummat.travel.webservice.exception.NoSuchDriverDetailException {

		return getPersistence().remove(driverId);
	}

	public static DriverDetail updateImpl(DriverDetail driverDetail) {
		return getPersistence().updateImpl(driverDetail);
	}

	/**
	 * Returns the driver detail with the primary key or throws a <code>NoSuchDriverDetailException</code> if it could not be found.
	 *
	 * @param driverId the primary key of the driver detail
	 * @return the driver detail
	 * @throws NoSuchDriverDetailException if a driver detail with the primary key could not be found
	 */
	public static DriverDetail findByPrimaryKey(long driverId)
		throws ummat.travel.webservice.exception.NoSuchDriverDetailException {

		return getPersistence().findByPrimaryKey(driverId);
	}

	/**
	 * Returns the driver detail with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param driverId the primary key of the driver detail
	 * @return the driver detail, or <code>null</code> if a driver detail with the primary key could not be found
	 */
	public static DriverDetail fetchByPrimaryKey(long driverId) {
		return getPersistence().fetchByPrimaryKey(driverId);
	}

	/**
	 * Returns all the driver details.
	 *
	 * @return the driver details
	 */
	public static List<DriverDetail> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the driver details.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DriverDetailModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of driver details
	 * @param end the upper bound of the range of driver details (not inclusive)
	 * @return the range of driver details
	 */
	public static List<DriverDetail> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the driver details.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DriverDetailModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of driver details
	 * @param end the upper bound of the range of driver details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of driver details
	 */
	public static List<DriverDetail> findAll(
		int start, int end, OrderByComparator<DriverDetail> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the driver details.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DriverDetailModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of driver details
	 * @param end the upper bound of the range of driver details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of driver details
	 */
	public static List<DriverDetail> findAll(
		int start, int end, OrderByComparator<DriverDetail> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the driver details from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of driver details.
	 *
	 * @return the number of driver details
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static DriverDetailPersistence getPersistence() {
		return _persistence;
	}

	private static volatile DriverDetailPersistence _persistence;

}