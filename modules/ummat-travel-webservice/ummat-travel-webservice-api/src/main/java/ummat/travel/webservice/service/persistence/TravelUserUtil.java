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

import ummat.travel.webservice.model.TravelUser;

/**
 * The persistence utility for the travel user service. This utility wraps <code>ummat.travel.webservice.service.persistence.impl.TravelUserPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TravelUserPersistence
 * @generated
 */
public class TravelUserUtil {

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
	public static void clearCache(TravelUser travelUser) {
		getPersistence().clearCache(travelUser);
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
	public static Map<Serializable, TravelUser> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<TravelUser> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<TravelUser> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<TravelUser> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<TravelUser> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static TravelUser update(TravelUser travelUser) {
		return getPersistence().update(travelUser);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static TravelUser update(
		TravelUser travelUser, ServiceContext serviceContext) {

		return getPersistence().update(travelUser, serviceContext);
	}

	/**
	 * Returns all the travel users where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching travel users
	 */
	public static List<TravelUser> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the travel users where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TravelUserModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of travel users
	 * @param end the upper bound of the range of travel users (not inclusive)
	 * @return the range of matching travel users
	 */
	public static List<TravelUser> findByUuid(String uuid, int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the travel users where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TravelUserModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of travel users
	 * @param end the upper bound of the range of travel users (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching travel users
	 */
	public static List<TravelUser> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<TravelUser> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the travel users where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TravelUserModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of travel users
	 * @param end the upper bound of the range of travel users (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching travel users
	 */
	public static List<TravelUser> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<TravelUser> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first travel user in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching travel user
	 * @throws NoSuchTravelUserException if a matching travel user could not be found
	 */
	public static TravelUser findByUuid_First(
			String uuid, OrderByComparator<TravelUser> orderByComparator)
		throws ummat.travel.webservice.exception.NoSuchTravelUserException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first travel user in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching travel user, or <code>null</code> if a matching travel user could not be found
	 */
	public static TravelUser fetchByUuid_First(
		String uuid, OrderByComparator<TravelUser> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last travel user in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching travel user
	 * @throws NoSuchTravelUserException if a matching travel user could not be found
	 */
	public static TravelUser findByUuid_Last(
			String uuid, OrderByComparator<TravelUser> orderByComparator)
		throws ummat.travel.webservice.exception.NoSuchTravelUserException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last travel user in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching travel user, or <code>null</code> if a matching travel user could not be found
	 */
	public static TravelUser fetchByUuid_Last(
		String uuid, OrderByComparator<TravelUser> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the travel users before and after the current travel user in the ordered set where uuid = &#63;.
	 *
	 * @param travelUserId the primary key of the current travel user
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next travel user
	 * @throws NoSuchTravelUserException if a travel user with the primary key could not be found
	 */
	public static TravelUser[] findByUuid_PrevAndNext(
			long travelUserId, String uuid,
			OrderByComparator<TravelUser> orderByComparator)
		throws ummat.travel.webservice.exception.NoSuchTravelUserException {

		return getPersistence().findByUuid_PrevAndNext(
			travelUserId, uuid, orderByComparator);
	}

	/**
	 * Removes all the travel users where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of travel users where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching travel users
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns all the travel users where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching travel users
	 */
	public static List<TravelUser> findByUuid_C(String uuid, long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the travel users where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TravelUserModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of travel users
	 * @param end the upper bound of the range of travel users (not inclusive)
	 * @return the range of matching travel users
	 */
	public static List<TravelUser> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the travel users where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TravelUserModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of travel users
	 * @param end the upper bound of the range of travel users (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching travel users
	 */
	public static List<TravelUser> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<TravelUser> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the travel users where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TravelUserModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of travel users
	 * @param end the upper bound of the range of travel users (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching travel users
	 */
	public static List<TravelUser> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<TravelUser> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first travel user in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching travel user
	 * @throws NoSuchTravelUserException if a matching travel user could not be found
	 */
	public static TravelUser findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<TravelUser> orderByComparator)
		throws ummat.travel.webservice.exception.NoSuchTravelUserException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first travel user in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching travel user, or <code>null</code> if a matching travel user could not be found
	 */
	public static TravelUser fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<TravelUser> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last travel user in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching travel user
	 * @throws NoSuchTravelUserException if a matching travel user could not be found
	 */
	public static TravelUser findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<TravelUser> orderByComparator)
		throws ummat.travel.webservice.exception.NoSuchTravelUserException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last travel user in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching travel user, or <code>null</code> if a matching travel user could not be found
	 */
	public static TravelUser fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<TravelUser> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the travel users before and after the current travel user in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param travelUserId the primary key of the current travel user
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next travel user
	 * @throws NoSuchTravelUserException if a travel user with the primary key could not be found
	 */
	public static TravelUser[] findByUuid_C_PrevAndNext(
			long travelUserId, String uuid, long companyId,
			OrderByComparator<TravelUser> orderByComparator)
		throws ummat.travel.webservice.exception.NoSuchTravelUserException {

		return getPersistence().findByUuid_C_PrevAndNext(
			travelUserId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the travel users where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of travel users where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching travel users
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the travel users where travelUserId = &#63;.
	 *
	 * @param travelUserId the travel user ID
	 * @return the matching travel users
	 */
	public static List<TravelUser> findByfindByTravelUserId(long travelUserId) {
		return getPersistence().findByfindByTravelUserId(travelUserId);
	}

	/**
	 * Returns a range of all the travel users where travelUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TravelUserModelImpl</code>.
	 * </p>
	 *
	 * @param travelUserId the travel user ID
	 * @param start the lower bound of the range of travel users
	 * @param end the upper bound of the range of travel users (not inclusive)
	 * @return the range of matching travel users
	 */
	public static List<TravelUser> findByfindByTravelUserId(
		long travelUserId, int start, int end) {

		return getPersistence().findByfindByTravelUserId(
			travelUserId, start, end);
	}

	/**
	 * Returns an ordered range of all the travel users where travelUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TravelUserModelImpl</code>.
	 * </p>
	 *
	 * @param travelUserId the travel user ID
	 * @param start the lower bound of the range of travel users
	 * @param end the upper bound of the range of travel users (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching travel users
	 */
	public static List<TravelUser> findByfindByTravelUserId(
		long travelUserId, int start, int end,
		OrderByComparator<TravelUser> orderByComparator) {

		return getPersistence().findByfindByTravelUserId(
			travelUserId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the travel users where travelUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TravelUserModelImpl</code>.
	 * </p>
	 *
	 * @param travelUserId the travel user ID
	 * @param start the lower bound of the range of travel users
	 * @param end the upper bound of the range of travel users (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching travel users
	 */
	public static List<TravelUser> findByfindByTravelUserId(
		long travelUserId, int start, int end,
		OrderByComparator<TravelUser> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByfindByTravelUserId(
			travelUserId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first travel user in the ordered set where travelUserId = &#63;.
	 *
	 * @param travelUserId the travel user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching travel user
	 * @throws NoSuchTravelUserException if a matching travel user could not be found
	 */
	public static TravelUser findByfindByTravelUserId_First(
			long travelUserId, OrderByComparator<TravelUser> orderByComparator)
		throws ummat.travel.webservice.exception.NoSuchTravelUserException {

		return getPersistence().findByfindByTravelUserId_First(
			travelUserId, orderByComparator);
	}

	/**
	 * Returns the first travel user in the ordered set where travelUserId = &#63;.
	 *
	 * @param travelUserId the travel user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching travel user, or <code>null</code> if a matching travel user could not be found
	 */
	public static TravelUser fetchByfindByTravelUserId_First(
		long travelUserId, OrderByComparator<TravelUser> orderByComparator) {

		return getPersistence().fetchByfindByTravelUserId_First(
			travelUserId, orderByComparator);
	}

	/**
	 * Returns the last travel user in the ordered set where travelUserId = &#63;.
	 *
	 * @param travelUserId the travel user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching travel user
	 * @throws NoSuchTravelUserException if a matching travel user could not be found
	 */
	public static TravelUser findByfindByTravelUserId_Last(
			long travelUserId, OrderByComparator<TravelUser> orderByComparator)
		throws ummat.travel.webservice.exception.NoSuchTravelUserException {

		return getPersistence().findByfindByTravelUserId_Last(
			travelUserId, orderByComparator);
	}

	/**
	 * Returns the last travel user in the ordered set where travelUserId = &#63;.
	 *
	 * @param travelUserId the travel user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching travel user, or <code>null</code> if a matching travel user could not be found
	 */
	public static TravelUser fetchByfindByTravelUserId_Last(
		long travelUserId, OrderByComparator<TravelUser> orderByComparator) {

		return getPersistence().fetchByfindByTravelUserId_Last(
			travelUserId, orderByComparator);
	}

	/**
	 * Removes all the travel users where travelUserId = &#63; from the database.
	 *
	 * @param travelUserId the travel user ID
	 */
	public static void removeByfindByTravelUserId(long travelUserId) {
		getPersistence().removeByfindByTravelUserId(travelUserId);
	}

	/**
	 * Returns the number of travel users where travelUserId = &#63;.
	 *
	 * @param travelUserId the travel user ID
	 * @return the number of matching travel users
	 */
	public static int countByfindByTravelUserId(long travelUserId) {
		return getPersistence().countByfindByTravelUserId(travelUserId);
	}

	/**
	 * Returns all the travel users where travelUserPhoneNumber = &#63;.
	 *
	 * @param travelUserPhoneNumber the travel user phone number
	 * @return the matching travel users
	 */
	public static List<TravelUser> findByfindByTravelUserPhoneNumber(
		String travelUserPhoneNumber) {

		return getPersistence().findByfindByTravelUserPhoneNumber(
			travelUserPhoneNumber);
	}

	/**
	 * Returns a range of all the travel users where travelUserPhoneNumber = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TravelUserModelImpl</code>.
	 * </p>
	 *
	 * @param travelUserPhoneNumber the travel user phone number
	 * @param start the lower bound of the range of travel users
	 * @param end the upper bound of the range of travel users (not inclusive)
	 * @return the range of matching travel users
	 */
	public static List<TravelUser> findByfindByTravelUserPhoneNumber(
		String travelUserPhoneNumber, int start, int end) {

		return getPersistence().findByfindByTravelUserPhoneNumber(
			travelUserPhoneNumber, start, end);
	}

	/**
	 * Returns an ordered range of all the travel users where travelUserPhoneNumber = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TravelUserModelImpl</code>.
	 * </p>
	 *
	 * @param travelUserPhoneNumber the travel user phone number
	 * @param start the lower bound of the range of travel users
	 * @param end the upper bound of the range of travel users (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching travel users
	 */
	public static List<TravelUser> findByfindByTravelUserPhoneNumber(
		String travelUserPhoneNumber, int start, int end,
		OrderByComparator<TravelUser> orderByComparator) {

		return getPersistence().findByfindByTravelUserPhoneNumber(
			travelUserPhoneNumber, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the travel users where travelUserPhoneNumber = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TravelUserModelImpl</code>.
	 * </p>
	 *
	 * @param travelUserPhoneNumber the travel user phone number
	 * @param start the lower bound of the range of travel users
	 * @param end the upper bound of the range of travel users (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching travel users
	 */
	public static List<TravelUser> findByfindByTravelUserPhoneNumber(
		String travelUserPhoneNumber, int start, int end,
		OrderByComparator<TravelUser> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByfindByTravelUserPhoneNumber(
			travelUserPhoneNumber, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first travel user in the ordered set where travelUserPhoneNumber = &#63;.
	 *
	 * @param travelUserPhoneNumber the travel user phone number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching travel user
	 * @throws NoSuchTravelUserException if a matching travel user could not be found
	 */
	public static TravelUser findByfindByTravelUserPhoneNumber_First(
			String travelUserPhoneNumber,
			OrderByComparator<TravelUser> orderByComparator)
		throws ummat.travel.webservice.exception.NoSuchTravelUserException {

		return getPersistence().findByfindByTravelUserPhoneNumber_First(
			travelUserPhoneNumber, orderByComparator);
	}

	/**
	 * Returns the first travel user in the ordered set where travelUserPhoneNumber = &#63;.
	 *
	 * @param travelUserPhoneNumber the travel user phone number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching travel user, or <code>null</code> if a matching travel user could not be found
	 */
	public static TravelUser fetchByfindByTravelUserPhoneNumber_First(
		String travelUserPhoneNumber,
		OrderByComparator<TravelUser> orderByComparator) {

		return getPersistence().fetchByfindByTravelUserPhoneNumber_First(
			travelUserPhoneNumber, orderByComparator);
	}

	/**
	 * Returns the last travel user in the ordered set where travelUserPhoneNumber = &#63;.
	 *
	 * @param travelUserPhoneNumber the travel user phone number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching travel user
	 * @throws NoSuchTravelUserException if a matching travel user could not be found
	 */
	public static TravelUser findByfindByTravelUserPhoneNumber_Last(
			String travelUserPhoneNumber,
			OrderByComparator<TravelUser> orderByComparator)
		throws ummat.travel.webservice.exception.NoSuchTravelUserException {

		return getPersistence().findByfindByTravelUserPhoneNumber_Last(
			travelUserPhoneNumber, orderByComparator);
	}

	/**
	 * Returns the last travel user in the ordered set where travelUserPhoneNumber = &#63;.
	 *
	 * @param travelUserPhoneNumber the travel user phone number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching travel user, or <code>null</code> if a matching travel user could not be found
	 */
	public static TravelUser fetchByfindByTravelUserPhoneNumber_Last(
		String travelUserPhoneNumber,
		OrderByComparator<TravelUser> orderByComparator) {

		return getPersistence().fetchByfindByTravelUserPhoneNumber_Last(
			travelUserPhoneNumber, orderByComparator);
	}

	/**
	 * Returns the travel users before and after the current travel user in the ordered set where travelUserPhoneNumber = &#63;.
	 *
	 * @param travelUserId the primary key of the current travel user
	 * @param travelUserPhoneNumber the travel user phone number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next travel user
	 * @throws NoSuchTravelUserException if a travel user with the primary key could not be found
	 */
	public static TravelUser[] findByfindByTravelUserPhoneNumber_PrevAndNext(
			long travelUserId, String travelUserPhoneNumber,
			OrderByComparator<TravelUser> orderByComparator)
		throws ummat.travel.webservice.exception.NoSuchTravelUserException {

		return getPersistence().findByfindByTravelUserPhoneNumber_PrevAndNext(
			travelUserId, travelUserPhoneNumber, orderByComparator);
	}

	/**
	 * Removes all the travel users where travelUserPhoneNumber = &#63; from the database.
	 *
	 * @param travelUserPhoneNumber the travel user phone number
	 */
	public static void removeByfindByTravelUserPhoneNumber(
		String travelUserPhoneNumber) {

		getPersistence().removeByfindByTravelUserPhoneNumber(
			travelUserPhoneNumber);
	}

	/**
	 * Returns the number of travel users where travelUserPhoneNumber = &#63;.
	 *
	 * @param travelUserPhoneNumber the travel user phone number
	 * @return the number of matching travel users
	 */
	public static int countByfindByTravelUserPhoneNumber(
		String travelUserPhoneNumber) {

		return getPersistence().countByfindByTravelUserPhoneNumber(
			travelUserPhoneNumber);
	}

	/**
	 * Returns all the travel users where travelUserEmail = &#63;.
	 *
	 * @param travelUserEmail the travel user email
	 * @return the matching travel users
	 */
	public static List<TravelUser> findByfindByUserEmail(
		String travelUserEmail) {

		return getPersistence().findByfindByUserEmail(travelUserEmail);
	}

	/**
	 * Returns a range of all the travel users where travelUserEmail = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TravelUserModelImpl</code>.
	 * </p>
	 *
	 * @param travelUserEmail the travel user email
	 * @param start the lower bound of the range of travel users
	 * @param end the upper bound of the range of travel users (not inclusive)
	 * @return the range of matching travel users
	 */
	public static List<TravelUser> findByfindByUserEmail(
		String travelUserEmail, int start, int end) {

		return getPersistence().findByfindByUserEmail(
			travelUserEmail, start, end);
	}

	/**
	 * Returns an ordered range of all the travel users where travelUserEmail = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TravelUserModelImpl</code>.
	 * </p>
	 *
	 * @param travelUserEmail the travel user email
	 * @param start the lower bound of the range of travel users
	 * @param end the upper bound of the range of travel users (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching travel users
	 */
	public static List<TravelUser> findByfindByUserEmail(
		String travelUserEmail, int start, int end,
		OrderByComparator<TravelUser> orderByComparator) {

		return getPersistence().findByfindByUserEmail(
			travelUserEmail, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the travel users where travelUserEmail = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TravelUserModelImpl</code>.
	 * </p>
	 *
	 * @param travelUserEmail the travel user email
	 * @param start the lower bound of the range of travel users
	 * @param end the upper bound of the range of travel users (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching travel users
	 */
	public static List<TravelUser> findByfindByUserEmail(
		String travelUserEmail, int start, int end,
		OrderByComparator<TravelUser> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByfindByUserEmail(
			travelUserEmail, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first travel user in the ordered set where travelUserEmail = &#63;.
	 *
	 * @param travelUserEmail the travel user email
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching travel user
	 * @throws NoSuchTravelUserException if a matching travel user could not be found
	 */
	public static TravelUser findByfindByUserEmail_First(
			String travelUserEmail,
			OrderByComparator<TravelUser> orderByComparator)
		throws ummat.travel.webservice.exception.NoSuchTravelUserException {

		return getPersistence().findByfindByUserEmail_First(
			travelUserEmail, orderByComparator);
	}

	/**
	 * Returns the first travel user in the ordered set where travelUserEmail = &#63;.
	 *
	 * @param travelUserEmail the travel user email
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching travel user, or <code>null</code> if a matching travel user could not be found
	 */
	public static TravelUser fetchByfindByUserEmail_First(
		String travelUserEmail,
		OrderByComparator<TravelUser> orderByComparator) {

		return getPersistence().fetchByfindByUserEmail_First(
			travelUserEmail, orderByComparator);
	}

	/**
	 * Returns the last travel user in the ordered set where travelUserEmail = &#63;.
	 *
	 * @param travelUserEmail the travel user email
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching travel user
	 * @throws NoSuchTravelUserException if a matching travel user could not be found
	 */
	public static TravelUser findByfindByUserEmail_Last(
			String travelUserEmail,
			OrderByComparator<TravelUser> orderByComparator)
		throws ummat.travel.webservice.exception.NoSuchTravelUserException {

		return getPersistence().findByfindByUserEmail_Last(
			travelUserEmail, orderByComparator);
	}

	/**
	 * Returns the last travel user in the ordered set where travelUserEmail = &#63;.
	 *
	 * @param travelUserEmail the travel user email
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching travel user, or <code>null</code> if a matching travel user could not be found
	 */
	public static TravelUser fetchByfindByUserEmail_Last(
		String travelUserEmail,
		OrderByComparator<TravelUser> orderByComparator) {

		return getPersistence().fetchByfindByUserEmail_Last(
			travelUserEmail, orderByComparator);
	}

	/**
	 * Returns the travel users before and after the current travel user in the ordered set where travelUserEmail = &#63;.
	 *
	 * @param travelUserId the primary key of the current travel user
	 * @param travelUserEmail the travel user email
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next travel user
	 * @throws NoSuchTravelUserException if a travel user with the primary key could not be found
	 */
	public static TravelUser[] findByfindByUserEmail_PrevAndNext(
			long travelUserId, String travelUserEmail,
			OrderByComparator<TravelUser> orderByComparator)
		throws ummat.travel.webservice.exception.NoSuchTravelUserException {

		return getPersistence().findByfindByUserEmail_PrevAndNext(
			travelUserId, travelUserEmail, orderByComparator);
	}

	/**
	 * Removes all the travel users where travelUserEmail = &#63; from the database.
	 *
	 * @param travelUserEmail the travel user email
	 */
	public static void removeByfindByUserEmail(String travelUserEmail) {
		getPersistence().removeByfindByUserEmail(travelUserEmail);
	}

	/**
	 * Returns the number of travel users where travelUserEmail = &#63;.
	 *
	 * @param travelUserEmail the travel user email
	 * @return the number of matching travel users
	 */
	public static int countByfindByUserEmail(String travelUserEmail) {
		return getPersistence().countByfindByUserEmail(travelUserEmail);
	}

	/**
	 * Returns all the travel users where userId = &#63; and companyId = &#63;.
	 *
	 * @param userId the user ID
	 * @param companyId the company ID
	 * @return the matching travel users
	 */
	public static List<TravelUser> findByFind_TravelUsers(
		long userId, long companyId) {

		return getPersistence().findByFind_TravelUsers(userId, companyId);
	}

	/**
	 * Returns a range of all the travel users where userId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TravelUserModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param companyId the company ID
	 * @param start the lower bound of the range of travel users
	 * @param end the upper bound of the range of travel users (not inclusive)
	 * @return the range of matching travel users
	 */
	public static List<TravelUser> findByFind_TravelUsers(
		long userId, long companyId, int start, int end) {

		return getPersistence().findByFind_TravelUsers(
			userId, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the travel users where userId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TravelUserModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param companyId the company ID
	 * @param start the lower bound of the range of travel users
	 * @param end the upper bound of the range of travel users (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching travel users
	 */
	public static List<TravelUser> findByFind_TravelUsers(
		long userId, long companyId, int start, int end,
		OrderByComparator<TravelUser> orderByComparator) {

		return getPersistence().findByFind_TravelUsers(
			userId, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the travel users where userId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TravelUserModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param companyId the company ID
	 * @param start the lower bound of the range of travel users
	 * @param end the upper bound of the range of travel users (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching travel users
	 */
	public static List<TravelUser> findByFind_TravelUsers(
		long userId, long companyId, int start, int end,
		OrderByComparator<TravelUser> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByFind_TravelUsers(
			userId, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first travel user in the ordered set where userId = &#63; and companyId = &#63;.
	 *
	 * @param userId the user ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching travel user
	 * @throws NoSuchTravelUserException if a matching travel user could not be found
	 */
	public static TravelUser findByFind_TravelUsers_First(
			long userId, long companyId,
			OrderByComparator<TravelUser> orderByComparator)
		throws ummat.travel.webservice.exception.NoSuchTravelUserException {

		return getPersistence().findByFind_TravelUsers_First(
			userId, companyId, orderByComparator);
	}

	/**
	 * Returns the first travel user in the ordered set where userId = &#63; and companyId = &#63;.
	 *
	 * @param userId the user ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching travel user, or <code>null</code> if a matching travel user could not be found
	 */
	public static TravelUser fetchByFind_TravelUsers_First(
		long userId, long companyId,
		OrderByComparator<TravelUser> orderByComparator) {

		return getPersistence().fetchByFind_TravelUsers_First(
			userId, companyId, orderByComparator);
	}

	/**
	 * Returns the last travel user in the ordered set where userId = &#63; and companyId = &#63;.
	 *
	 * @param userId the user ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching travel user
	 * @throws NoSuchTravelUserException if a matching travel user could not be found
	 */
	public static TravelUser findByFind_TravelUsers_Last(
			long userId, long companyId,
			OrderByComparator<TravelUser> orderByComparator)
		throws ummat.travel.webservice.exception.NoSuchTravelUserException {

		return getPersistence().findByFind_TravelUsers_Last(
			userId, companyId, orderByComparator);
	}

	/**
	 * Returns the last travel user in the ordered set where userId = &#63; and companyId = &#63;.
	 *
	 * @param userId the user ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching travel user, or <code>null</code> if a matching travel user could not be found
	 */
	public static TravelUser fetchByFind_TravelUsers_Last(
		long userId, long companyId,
		OrderByComparator<TravelUser> orderByComparator) {

		return getPersistence().fetchByFind_TravelUsers_Last(
			userId, companyId, orderByComparator);
	}

	/**
	 * Returns the travel users before and after the current travel user in the ordered set where userId = &#63; and companyId = &#63;.
	 *
	 * @param travelUserId the primary key of the current travel user
	 * @param userId the user ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next travel user
	 * @throws NoSuchTravelUserException if a travel user with the primary key could not be found
	 */
	public static TravelUser[] findByFind_TravelUsers_PrevAndNext(
			long travelUserId, long userId, long companyId,
			OrderByComparator<TravelUser> orderByComparator)
		throws ummat.travel.webservice.exception.NoSuchTravelUserException {

		return getPersistence().findByFind_TravelUsers_PrevAndNext(
			travelUserId, userId, companyId, orderByComparator);
	}

	/**
	 * Removes all the travel users where userId = &#63; and companyId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param companyId the company ID
	 */
	public static void removeByFind_TravelUsers(long userId, long companyId) {
		getPersistence().removeByFind_TravelUsers(userId, companyId);
	}

	/**
	 * Returns the number of travel users where userId = &#63; and companyId = &#63;.
	 *
	 * @param userId the user ID
	 * @param companyId the company ID
	 * @return the number of matching travel users
	 */
	public static int countByFind_TravelUsers(long userId, long companyId) {
		return getPersistence().countByFind_TravelUsers(userId, companyId);
	}

	/**
	 * Returns all the travel users where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching travel users
	 */
	public static List<TravelUser> findByUserId(long userId) {
		return getPersistence().findByUserId(userId);
	}

	/**
	 * Returns a range of all the travel users where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TravelUserModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of travel users
	 * @param end the upper bound of the range of travel users (not inclusive)
	 * @return the range of matching travel users
	 */
	public static List<TravelUser> findByUserId(
		long userId, int start, int end) {

		return getPersistence().findByUserId(userId, start, end);
	}

	/**
	 * Returns an ordered range of all the travel users where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TravelUserModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of travel users
	 * @param end the upper bound of the range of travel users (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching travel users
	 */
	public static List<TravelUser> findByUserId(
		long userId, int start, int end,
		OrderByComparator<TravelUser> orderByComparator) {

		return getPersistence().findByUserId(
			userId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the travel users where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TravelUserModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of travel users
	 * @param end the upper bound of the range of travel users (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching travel users
	 */
	public static List<TravelUser> findByUserId(
		long userId, int start, int end,
		OrderByComparator<TravelUser> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUserId(
			userId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first travel user in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching travel user
	 * @throws NoSuchTravelUserException if a matching travel user could not be found
	 */
	public static TravelUser findByUserId_First(
			long userId, OrderByComparator<TravelUser> orderByComparator)
		throws ummat.travel.webservice.exception.NoSuchTravelUserException {

		return getPersistence().findByUserId_First(userId, orderByComparator);
	}

	/**
	 * Returns the first travel user in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching travel user, or <code>null</code> if a matching travel user could not be found
	 */
	public static TravelUser fetchByUserId_First(
		long userId, OrderByComparator<TravelUser> orderByComparator) {

		return getPersistence().fetchByUserId_First(userId, orderByComparator);
	}

	/**
	 * Returns the last travel user in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching travel user
	 * @throws NoSuchTravelUserException if a matching travel user could not be found
	 */
	public static TravelUser findByUserId_Last(
			long userId, OrderByComparator<TravelUser> orderByComparator)
		throws ummat.travel.webservice.exception.NoSuchTravelUserException {

		return getPersistence().findByUserId_Last(userId, orderByComparator);
	}

	/**
	 * Returns the last travel user in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching travel user, or <code>null</code> if a matching travel user could not be found
	 */
	public static TravelUser fetchByUserId_Last(
		long userId, OrderByComparator<TravelUser> orderByComparator) {

		return getPersistence().fetchByUserId_Last(userId, orderByComparator);
	}

	/**
	 * Returns the travel users before and after the current travel user in the ordered set where userId = &#63;.
	 *
	 * @param travelUserId the primary key of the current travel user
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next travel user
	 * @throws NoSuchTravelUserException if a travel user with the primary key could not be found
	 */
	public static TravelUser[] findByUserId_PrevAndNext(
			long travelUserId, long userId,
			OrderByComparator<TravelUser> orderByComparator)
		throws ummat.travel.webservice.exception.NoSuchTravelUserException {

		return getPersistence().findByUserId_PrevAndNext(
			travelUserId, userId, orderByComparator);
	}

	/**
	 * Removes all the travel users where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 */
	public static void removeByUserId(long userId) {
		getPersistence().removeByUserId(userId);
	}

	/**
	 * Returns the number of travel users where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching travel users
	 */
	public static int countByUserId(long userId) {
		return getPersistence().countByUserId(userId);
	}

	/**
	 * Returns all the travel users where area = &#63;.
	 *
	 * @param area the area
	 * @return the matching travel users
	 */
	public static List<TravelUser> findByfindByArea(String area) {
		return getPersistence().findByfindByArea(area);
	}

	/**
	 * Returns a range of all the travel users where area = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TravelUserModelImpl</code>.
	 * </p>
	 *
	 * @param area the area
	 * @param start the lower bound of the range of travel users
	 * @param end the upper bound of the range of travel users (not inclusive)
	 * @return the range of matching travel users
	 */
	public static List<TravelUser> findByfindByArea(
		String area, int start, int end) {

		return getPersistence().findByfindByArea(area, start, end);
	}

	/**
	 * Returns an ordered range of all the travel users where area = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TravelUserModelImpl</code>.
	 * </p>
	 *
	 * @param area the area
	 * @param start the lower bound of the range of travel users
	 * @param end the upper bound of the range of travel users (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching travel users
	 */
	public static List<TravelUser> findByfindByArea(
		String area, int start, int end,
		OrderByComparator<TravelUser> orderByComparator) {

		return getPersistence().findByfindByArea(
			area, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the travel users where area = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TravelUserModelImpl</code>.
	 * </p>
	 *
	 * @param area the area
	 * @param start the lower bound of the range of travel users
	 * @param end the upper bound of the range of travel users (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching travel users
	 */
	public static List<TravelUser> findByfindByArea(
		String area, int start, int end,
		OrderByComparator<TravelUser> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByfindByArea(
			area, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first travel user in the ordered set where area = &#63;.
	 *
	 * @param area the area
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching travel user
	 * @throws NoSuchTravelUserException if a matching travel user could not be found
	 */
	public static TravelUser findByfindByArea_First(
			String area, OrderByComparator<TravelUser> orderByComparator)
		throws ummat.travel.webservice.exception.NoSuchTravelUserException {

		return getPersistence().findByfindByArea_First(area, orderByComparator);
	}

	/**
	 * Returns the first travel user in the ordered set where area = &#63;.
	 *
	 * @param area the area
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching travel user, or <code>null</code> if a matching travel user could not be found
	 */
	public static TravelUser fetchByfindByArea_First(
		String area, OrderByComparator<TravelUser> orderByComparator) {

		return getPersistence().fetchByfindByArea_First(
			area, orderByComparator);
	}

	/**
	 * Returns the last travel user in the ordered set where area = &#63;.
	 *
	 * @param area the area
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching travel user
	 * @throws NoSuchTravelUserException if a matching travel user could not be found
	 */
	public static TravelUser findByfindByArea_Last(
			String area, OrderByComparator<TravelUser> orderByComparator)
		throws ummat.travel.webservice.exception.NoSuchTravelUserException {

		return getPersistence().findByfindByArea_Last(area, orderByComparator);
	}

	/**
	 * Returns the last travel user in the ordered set where area = &#63;.
	 *
	 * @param area the area
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching travel user, or <code>null</code> if a matching travel user could not be found
	 */
	public static TravelUser fetchByfindByArea_Last(
		String area, OrderByComparator<TravelUser> orderByComparator) {

		return getPersistence().fetchByfindByArea_Last(area, orderByComparator);
	}

	/**
	 * Returns the travel users before and after the current travel user in the ordered set where area = &#63;.
	 *
	 * @param travelUserId the primary key of the current travel user
	 * @param area the area
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next travel user
	 * @throws NoSuchTravelUserException if a travel user with the primary key could not be found
	 */
	public static TravelUser[] findByfindByArea_PrevAndNext(
			long travelUserId, String area,
			OrderByComparator<TravelUser> orderByComparator)
		throws ummat.travel.webservice.exception.NoSuchTravelUserException {

		return getPersistence().findByfindByArea_PrevAndNext(
			travelUserId, area, orderByComparator);
	}

	/**
	 * Removes all the travel users where area = &#63; from the database.
	 *
	 * @param area the area
	 */
	public static void removeByfindByArea(String area) {
		getPersistence().removeByfindByArea(area);
	}

	/**
	 * Returns the number of travel users where area = &#63;.
	 *
	 * @param area the area
	 * @return the number of matching travel users
	 */
	public static int countByfindByArea(String area) {
		return getPersistence().countByfindByArea(area);
	}

	/**
	 * Returns all the travel users where district = &#63;.
	 *
	 * @param district the district
	 * @return the matching travel users
	 */
	public static List<TravelUser> findByfindByDistrict(long district) {
		return getPersistence().findByfindByDistrict(district);
	}

	/**
	 * Returns a range of all the travel users where district = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TravelUserModelImpl</code>.
	 * </p>
	 *
	 * @param district the district
	 * @param start the lower bound of the range of travel users
	 * @param end the upper bound of the range of travel users (not inclusive)
	 * @return the range of matching travel users
	 */
	public static List<TravelUser> findByfindByDistrict(
		long district, int start, int end) {

		return getPersistence().findByfindByDistrict(district, start, end);
	}

	/**
	 * Returns an ordered range of all the travel users where district = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TravelUserModelImpl</code>.
	 * </p>
	 *
	 * @param district the district
	 * @param start the lower bound of the range of travel users
	 * @param end the upper bound of the range of travel users (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching travel users
	 */
	public static List<TravelUser> findByfindByDistrict(
		long district, int start, int end,
		OrderByComparator<TravelUser> orderByComparator) {

		return getPersistence().findByfindByDistrict(
			district, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the travel users where district = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TravelUserModelImpl</code>.
	 * </p>
	 *
	 * @param district the district
	 * @param start the lower bound of the range of travel users
	 * @param end the upper bound of the range of travel users (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching travel users
	 */
	public static List<TravelUser> findByfindByDistrict(
		long district, int start, int end,
		OrderByComparator<TravelUser> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByfindByDistrict(
			district, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first travel user in the ordered set where district = &#63;.
	 *
	 * @param district the district
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching travel user
	 * @throws NoSuchTravelUserException if a matching travel user could not be found
	 */
	public static TravelUser findByfindByDistrict_First(
			long district, OrderByComparator<TravelUser> orderByComparator)
		throws ummat.travel.webservice.exception.NoSuchTravelUserException {

		return getPersistence().findByfindByDistrict_First(
			district, orderByComparator);
	}

	/**
	 * Returns the first travel user in the ordered set where district = &#63;.
	 *
	 * @param district the district
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching travel user, or <code>null</code> if a matching travel user could not be found
	 */
	public static TravelUser fetchByfindByDistrict_First(
		long district, OrderByComparator<TravelUser> orderByComparator) {

		return getPersistence().fetchByfindByDistrict_First(
			district, orderByComparator);
	}

	/**
	 * Returns the last travel user in the ordered set where district = &#63;.
	 *
	 * @param district the district
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching travel user
	 * @throws NoSuchTravelUserException if a matching travel user could not be found
	 */
	public static TravelUser findByfindByDistrict_Last(
			long district, OrderByComparator<TravelUser> orderByComparator)
		throws ummat.travel.webservice.exception.NoSuchTravelUserException {

		return getPersistence().findByfindByDistrict_Last(
			district, orderByComparator);
	}

	/**
	 * Returns the last travel user in the ordered set where district = &#63;.
	 *
	 * @param district the district
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching travel user, or <code>null</code> if a matching travel user could not be found
	 */
	public static TravelUser fetchByfindByDistrict_Last(
		long district, OrderByComparator<TravelUser> orderByComparator) {

		return getPersistence().fetchByfindByDistrict_Last(
			district, orderByComparator);
	}

	/**
	 * Returns the travel users before and after the current travel user in the ordered set where district = &#63;.
	 *
	 * @param travelUserId the primary key of the current travel user
	 * @param district the district
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next travel user
	 * @throws NoSuchTravelUserException if a travel user with the primary key could not be found
	 */
	public static TravelUser[] findByfindByDistrict_PrevAndNext(
			long travelUserId, long district,
			OrderByComparator<TravelUser> orderByComparator)
		throws ummat.travel.webservice.exception.NoSuchTravelUserException {

		return getPersistence().findByfindByDistrict_PrevAndNext(
			travelUserId, district, orderByComparator);
	}

	/**
	 * Removes all the travel users where district = &#63; from the database.
	 *
	 * @param district the district
	 */
	public static void removeByfindByDistrict(long district) {
		getPersistence().removeByfindByDistrict(district);
	}

	/**
	 * Returns the number of travel users where district = &#63;.
	 *
	 * @param district the district
	 * @return the number of matching travel users
	 */
	public static int countByfindByDistrict(long district) {
		return getPersistence().countByfindByDistrict(district);
	}

	/**
	 * Returns all the travel users where district = &#63; and area = &#63;.
	 *
	 * @param district the district
	 * @param area the area
	 * @return the matching travel users
	 */
	public static List<TravelUser> findByfindByDistricAndAreat(
		long district, String area) {

		return getPersistence().findByfindByDistricAndAreat(district, area);
	}

	/**
	 * Returns a range of all the travel users where district = &#63; and area = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TravelUserModelImpl</code>.
	 * </p>
	 *
	 * @param district the district
	 * @param area the area
	 * @param start the lower bound of the range of travel users
	 * @param end the upper bound of the range of travel users (not inclusive)
	 * @return the range of matching travel users
	 */
	public static List<TravelUser> findByfindByDistricAndAreat(
		long district, String area, int start, int end) {

		return getPersistence().findByfindByDistricAndAreat(
			district, area, start, end);
	}

	/**
	 * Returns an ordered range of all the travel users where district = &#63; and area = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TravelUserModelImpl</code>.
	 * </p>
	 *
	 * @param district the district
	 * @param area the area
	 * @param start the lower bound of the range of travel users
	 * @param end the upper bound of the range of travel users (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching travel users
	 */
	public static List<TravelUser> findByfindByDistricAndAreat(
		long district, String area, int start, int end,
		OrderByComparator<TravelUser> orderByComparator) {

		return getPersistence().findByfindByDistricAndAreat(
			district, area, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the travel users where district = &#63; and area = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TravelUserModelImpl</code>.
	 * </p>
	 *
	 * @param district the district
	 * @param area the area
	 * @param start the lower bound of the range of travel users
	 * @param end the upper bound of the range of travel users (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching travel users
	 */
	public static List<TravelUser> findByfindByDistricAndAreat(
		long district, String area, int start, int end,
		OrderByComparator<TravelUser> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByfindByDistricAndAreat(
			district, area, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first travel user in the ordered set where district = &#63; and area = &#63;.
	 *
	 * @param district the district
	 * @param area the area
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching travel user
	 * @throws NoSuchTravelUserException if a matching travel user could not be found
	 */
	public static TravelUser findByfindByDistricAndAreat_First(
			long district, String area,
			OrderByComparator<TravelUser> orderByComparator)
		throws ummat.travel.webservice.exception.NoSuchTravelUserException {

		return getPersistence().findByfindByDistricAndAreat_First(
			district, area, orderByComparator);
	}

	/**
	 * Returns the first travel user in the ordered set where district = &#63; and area = &#63;.
	 *
	 * @param district the district
	 * @param area the area
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching travel user, or <code>null</code> if a matching travel user could not be found
	 */
	public static TravelUser fetchByfindByDistricAndAreat_First(
		long district, String area,
		OrderByComparator<TravelUser> orderByComparator) {

		return getPersistence().fetchByfindByDistricAndAreat_First(
			district, area, orderByComparator);
	}

	/**
	 * Returns the last travel user in the ordered set where district = &#63; and area = &#63;.
	 *
	 * @param district the district
	 * @param area the area
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching travel user
	 * @throws NoSuchTravelUserException if a matching travel user could not be found
	 */
	public static TravelUser findByfindByDistricAndAreat_Last(
			long district, String area,
			OrderByComparator<TravelUser> orderByComparator)
		throws ummat.travel.webservice.exception.NoSuchTravelUserException {

		return getPersistence().findByfindByDistricAndAreat_Last(
			district, area, orderByComparator);
	}

	/**
	 * Returns the last travel user in the ordered set where district = &#63; and area = &#63;.
	 *
	 * @param district the district
	 * @param area the area
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching travel user, or <code>null</code> if a matching travel user could not be found
	 */
	public static TravelUser fetchByfindByDistricAndAreat_Last(
		long district, String area,
		OrderByComparator<TravelUser> orderByComparator) {

		return getPersistence().fetchByfindByDistricAndAreat_Last(
			district, area, orderByComparator);
	}

	/**
	 * Returns the travel users before and after the current travel user in the ordered set where district = &#63; and area = &#63;.
	 *
	 * @param travelUserId the primary key of the current travel user
	 * @param district the district
	 * @param area the area
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next travel user
	 * @throws NoSuchTravelUserException if a travel user with the primary key could not be found
	 */
	public static TravelUser[] findByfindByDistricAndAreat_PrevAndNext(
			long travelUserId, long district, String area,
			OrderByComparator<TravelUser> orderByComparator)
		throws ummat.travel.webservice.exception.NoSuchTravelUserException {

		return getPersistence().findByfindByDistricAndAreat_PrevAndNext(
			travelUserId, district, area, orderByComparator);
	}

	/**
	 * Removes all the travel users where district = &#63; and area = &#63; from the database.
	 *
	 * @param district the district
	 * @param area the area
	 */
	public static void removeByfindByDistricAndAreat(
		long district, String area) {

		getPersistence().removeByfindByDistricAndAreat(district, area);
	}

	/**
	 * Returns the number of travel users where district = &#63; and area = &#63;.
	 *
	 * @param district the district
	 * @param area the area
	 * @return the number of matching travel users
	 */
	public static int countByfindByDistricAndAreat(long district, String area) {
		return getPersistence().countByfindByDistricAndAreat(district, area);
	}

	/**
	 * Caches the travel user in the entity cache if it is enabled.
	 *
	 * @param travelUser the travel user
	 */
	public static void cacheResult(TravelUser travelUser) {
		getPersistence().cacheResult(travelUser);
	}

	/**
	 * Caches the travel users in the entity cache if it is enabled.
	 *
	 * @param travelUsers the travel users
	 */
	public static void cacheResult(List<TravelUser> travelUsers) {
		getPersistence().cacheResult(travelUsers);
	}

	/**
	 * Creates a new travel user with the primary key. Does not add the travel user to the database.
	 *
	 * @param travelUserId the primary key for the new travel user
	 * @return the new travel user
	 */
	public static TravelUser create(long travelUserId) {
		return getPersistence().create(travelUserId);
	}

	/**
	 * Removes the travel user with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param travelUserId the primary key of the travel user
	 * @return the travel user that was removed
	 * @throws NoSuchTravelUserException if a travel user with the primary key could not be found
	 */
	public static TravelUser remove(long travelUserId)
		throws ummat.travel.webservice.exception.NoSuchTravelUserException {

		return getPersistence().remove(travelUserId);
	}

	public static TravelUser updateImpl(TravelUser travelUser) {
		return getPersistence().updateImpl(travelUser);
	}

	/**
	 * Returns the travel user with the primary key or throws a <code>NoSuchTravelUserException</code> if it could not be found.
	 *
	 * @param travelUserId the primary key of the travel user
	 * @return the travel user
	 * @throws NoSuchTravelUserException if a travel user with the primary key could not be found
	 */
	public static TravelUser findByPrimaryKey(long travelUserId)
		throws ummat.travel.webservice.exception.NoSuchTravelUserException {

		return getPersistence().findByPrimaryKey(travelUserId);
	}

	/**
	 * Returns the travel user with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param travelUserId the primary key of the travel user
	 * @return the travel user, or <code>null</code> if a travel user with the primary key could not be found
	 */
	public static TravelUser fetchByPrimaryKey(long travelUserId) {
		return getPersistence().fetchByPrimaryKey(travelUserId);
	}

	/**
	 * Returns all the travel users.
	 *
	 * @return the travel users
	 */
	public static List<TravelUser> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the travel users.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TravelUserModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of travel users
	 * @param end the upper bound of the range of travel users (not inclusive)
	 * @return the range of travel users
	 */
	public static List<TravelUser> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the travel users.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TravelUserModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of travel users
	 * @param end the upper bound of the range of travel users (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of travel users
	 */
	public static List<TravelUser> findAll(
		int start, int end, OrderByComparator<TravelUser> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the travel users.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TravelUserModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of travel users
	 * @param end the upper bound of the range of travel users (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of travel users
	 */
	public static List<TravelUser> findAll(
		int start, int end, OrderByComparator<TravelUser> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the travel users from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of travel users.
	 *
	 * @return the number of travel users
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static TravelUserPersistence getPersistence() {
		return _persistence;
	}

	private static volatile TravelUserPersistence _persistence;

}