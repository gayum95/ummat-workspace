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

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

import ummat.travel.webservice.exception.NoSuchTravelUserException;
import ummat.travel.webservice.model.TravelUser;

/**
 * The persistence interface for the travel user service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TravelUserUtil
 * @generated
 */
@ProviderType
public interface TravelUserPersistence extends BasePersistence<TravelUser> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link TravelUserUtil} to access the travel user persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the travel users where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching travel users
	 */
	public java.util.List<TravelUser> findByUuid(String uuid);

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
	public java.util.List<TravelUser> findByUuid(
		String uuid, int start, int end);

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
	public java.util.List<TravelUser> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TravelUser>
			orderByComparator);

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
	public java.util.List<TravelUser> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TravelUser>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first travel user in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching travel user
	 * @throws NoSuchTravelUserException if a matching travel user could not be found
	 */
	public TravelUser findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<TravelUser>
				orderByComparator)
		throws NoSuchTravelUserException;

	/**
	 * Returns the first travel user in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching travel user, or <code>null</code> if a matching travel user could not be found
	 */
	public TravelUser fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<TravelUser>
			orderByComparator);

	/**
	 * Returns the last travel user in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching travel user
	 * @throws NoSuchTravelUserException if a matching travel user could not be found
	 */
	public TravelUser findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<TravelUser>
				orderByComparator)
		throws NoSuchTravelUserException;

	/**
	 * Returns the last travel user in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching travel user, or <code>null</code> if a matching travel user could not be found
	 */
	public TravelUser fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<TravelUser>
			orderByComparator);

	/**
	 * Returns the travel users before and after the current travel user in the ordered set where uuid = &#63;.
	 *
	 * @param travelUserId the primary key of the current travel user
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next travel user
	 * @throws NoSuchTravelUserException if a travel user with the primary key could not be found
	 */
	public TravelUser[] findByUuid_PrevAndNext(
			long travelUserId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<TravelUser>
				orderByComparator)
		throws NoSuchTravelUserException;

	/**
	 * Removes all the travel users where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of travel users where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching travel users
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns all the travel users where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching travel users
	 */
	public java.util.List<TravelUser> findByUuid_C(String uuid, long companyId);

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
	public java.util.List<TravelUser> findByUuid_C(
		String uuid, long companyId, int start, int end);

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
	public java.util.List<TravelUser> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TravelUser>
			orderByComparator);

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
	public java.util.List<TravelUser> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TravelUser>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first travel user in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching travel user
	 * @throws NoSuchTravelUserException if a matching travel user could not be found
	 */
	public TravelUser findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<TravelUser>
				orderByComparator)
		throws NoSuchTravelUserException;

	/**
	 * Returns the first travel user in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching travel user, or <code>null</code> if a matching travel user could not be found
	 */
	public TravelUser fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<TravelUser>
			orderByComparator);

	/**
	 * Returns the last travel user in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching travel user
	 * @throws NoSuchTravelUserException if a matching travel user could not be found
	 */
	public TravelUser findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<TravelUser>
				orderByComparator)
		throws NoSuchTravelUserException;

	/**
	 * Returns the last travel user in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching travel user, or <code>null</code> if a matching travel user could not be found
	 */
	public TravelUser fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<TravelUser>
			orderByComparator);

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
	public TravelUser[] findByUuid_C_PrevAndNext(
			long travelUserId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<TravelUser>
				orderByComparator)
		throws NoSuchTravelUserException;

	/**
	 * Removes all the travel users where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of travel users where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching travel users
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the travel users where travelUserId = &#63;.
	 *
	 * @param travelUserId the travel user ID
	 * @return the matching travel users
	 */
	public java.util.List<TravelUser> findByfindByTravelUserId(
		long travelUserId);

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
	public java.util.List<TravelUser> findByfindByTravelUserId(
		long travelUserId, int start, int end);

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
	public java.util.List<TravelUser> findByfindByTravelUserId(
		long travelUserId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TravelUser>
			orderByComparator);

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
	public java.util.List<TravelUser> findByfindByTravelUserId(
		long travelUserId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TravelUser>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first travel user in the ordered set where travelUserId = &#63;.
	 *
	 * @param travelUserId the travel user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching travel user
	 * @throws NoSuchTravelUserException if a matching travel user could not be found
	 */
	public TravelUser findByfindByTravelUserId_First(
			long travelUserId,
			com.liferay.portal.kernel.util.OrderByComparator<TravelUser>
				orderByComparator)
		throws NoSuchTravelUserException;

	/**
	 * Returns the first travel user in the ordered set where travelUserId = &#63;.
	 *
	 * @param travelUserId the travel user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching travel user, or <code>null</code> if a matching travel user could not be found
	 */
	public TravelUser fetchByfindByTravelUserId_First(
		long travelUserId,
		com.liferay.portal.kernel.util.OrderByComparator<TravelUser>
			orderByComparator);

	/**
	 * Returns the last travel user in the ordered set where travelUserId = &#63;.
	 *
	 * @param travelUserId the travel user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching travel user
	 * @throws NoSuchTravelUserException if a matching travel user could not be found
	 */
	public TravelUser findByfindByTravelUserId_Last(
			long travelUserId,
			com.liferay.portal.kernel.util.OrderByComparator<TravelUser>
				orderByComparator)
		throws NoSuchTravelUserException;

	/**
	 * Returns the last travel user in the ordered set where travelUserId = &#63;.
	 *
	 * @param travelUserId the travel user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching travel user, or <code>null</code> if a matching travel user could not be found
	 */
	public TravelUser fetchByfindByTravelUserId_Last(
		long travelUserId,
		com.liferay.portal.kernel.util.OrderByComparator<TravelUser>
			orderByComparator);

	/**
	 * Removes all the travel users where travelUserId = &#63; from the database.
	 *
	 * @param travelUserId the travel user ID
	 */
	public void removeByfindByTravelUserId(long travelUserId);

	/**
	 * Returns the number of travel users where travelUserId = &#63;.
	 *
	 * @param travelUserId the travel user ID
	 * @return the number of matching travel users
	 */
	public int countByfindByTravelUserId(long travelUserId);

	/**
	 * Returns all the travel users where travelUserPhoneNumber = &#63;.
	 *
	 * @param travelUserPhoneNumber the travel user phone number
	 * @return the matching travel users
	 */
	public java.util.List<TravelUser> findByfindByTravelUserPhoneNumber(
		String travelUserPhoneNumber);

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
	public java.util.List<TravelUser> findByfindByTravelUserPhoneNumber(
		String travelUserPhoneNumber, int start, int end);

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
	public java.util.List<TravelUser> findByfindByTravelUserPhoneNumber(
		String travelUserPhoneNumber, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TravelUser>
			orderByComparator);

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
	public java.util.List<TravelUser> findByfindByTravelUserPhoneNumber(
		String travelUserPhoneNumber, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TravelUser>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first travel user in the ordered set where travelUserPhoneNumber = &#63;.
	 *
	 * @param travelUserPhoneNumber the travel user phone number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching travel user
	 * @throws NoSuchTravelUserException if a matching travel user could not be found
	 */
	public TravelUser findByfindByTravelUserPhoneNumber_First(
			String travelUserPhoneNumber,
			com.liferay.portal.kernel.util.OrderByComparator<TravelUser>
				orderByComparator)
		throws NoSuchTravelUserException;

	/**
	 * Returns the first travel user in the ordered set where travelUserPhoneNumber = &#63;.
	 *
	 * @param travelUserPhoneNumber the travel user phone number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching travel user, or <code>null</code> if a matching travel user could not be found
	 */
	public TravelUser fetchByfindByTravelUserPhoneNumber_First(
		String travelUserPhoneNumber,
		com.liferay.portal.kernel.util.OrderByComparator<TravelUser>
			orderByComparator);

	/**
	 * Returns the last travel user in the ordered set where travelUserPhoneNumber = &#63;.
	 *
	 * @param travelUserPhoneNumber the travel user phone number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching travel user
	 * @throws NoSuchTravelUserException if a matching travel user could not be found
	 */
	public TravelUser findByfindByTravelUserPhoneNumber_Last(
			String travelUserPhoneNumber,
			com.liferay.portal.kernel.util.OrderByComparator<TravelUser>
				orderByComparator)
		throws NoSuchTravelUserException;

	/**
	 * Returns the last travel user in the ordered set where travelUserPhoneNumber = &#63;.
	 *
	 * @param travelUserPhoneNumber the travel user phone number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching travel user, or <code>null</code> if a matching travel user could not be found
	 */
	public TravelUser fetchByfindByTravelUserPhoneNumber_Last(
		String travelUserPhoneNumber,
		com.liferay.portal.kernel.util.OrderByComparator<TravelUser>
			orderByComparator);

	/**
	 * Returns the travel users before and after the current travel user in the ordered set where travelUserPhoneNumber = &#63;.
	 *
	 * @param travelUserId the primary key of the current travel user
	 * @param travelUserPhoneNumber the travel user phone number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next travel user
	 * @throws NoSuchTravelUserException if a travel user with the primary key could not be found
	 */
	public TravelUser[] findByfindByTravelUserPhoneNumber_PrevAndNext(
			long travelUserId, String travelUserPhoneNumber,
			com.liferay.portal.kernel.util.OrderByComparator<TravelUser>
				orderByComparator)
		throws NoSuchTravelUserException;

	/**
	 * Removes all the travel users where travelUserPhoneNumber = &#63; from the database.
	 *
	 * @param travelUserPhoneNumber the travel user phone number
	 */
	public void removeByfindByTravelUserPhoneNumber(
		String travelUserPhoneNumber);

	/**
	 * Returns the number of travel users where travelUserPhoneNumber = &#63;.
	 *
	 * @param travelUserPhoneNumber the travel user phone number
	 * @return the number of matching travel users
	 */
	public int countByfindByTravelUserPhoneNumber(String travelUserPhoneNumber);

	/**
	 * Returns all the travel users where travelUserEmail = &#63;.
	 *
	 * @param travelUserEmail the travel user email
	 * @return the matching travel users
	 */
	public java.util.List<TravelUser> findByfindByUserEmail(
		String travelUserEmail);

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
	public java.util.List<TravelUser> findByfindByUserEmail(
		String travelUserEmail, int start, int end);

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
	public java.util.List<TravelUser> findByfindByUserEmail(
		String travelUserEmail, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TravelUser>
			orderByComparator);

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
	public java.util.List<TravelUser> findByfindByUserEmail(
		String travelUserEmail, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TravelUser>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first travel user in the ordered set where travelUserEmail = &#63;.
	 *
	 * @param travelUserEmail the travel user email
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching travel user
	 * @throws NoSuchTravelUserException if a matching travel user could not be found
	 */
	public TravelUser findByfindByUserEmail_First(
			String travelUserEmail,
			com.liferay.portal.kernel.util.OrderByComparator<TravelUser>
				orderByComparator)
		throws NoSuchTravelUserException;

	/**
	 * Returns the first travel user in the ordered set where travelUserEmail = &#63;.
	 *
	 * @param travelUserEmail the travel user email
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching travel user, or <code>null</code> if a matching travel user could not be found
	 */
	public TravelUser fetchByfindByUserEmail_First(
		String travelUserEmail,
		com.liferay.portal.kernel.util.OrderByComparator<TravelUser>
			orderByComparator);

	/**
	 * Returns the last travel user in the ordered set where travelUserEmail = &#63;.
	 *
	 * @param travelUserEmail the travel user email
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching travel user
	 * @throws NoSuchTravelUserException if a matching travel user could not be found
	 */
	public TravelUser findByfindByUserEmail_Last(
			String travelUserEmail,
			com.liferay.portal.kernel.util.OrderByComparator<TravelUser>
				orderByComparator)
		throws NoSuchTravelUserException;

	/**
	 * Returns the last travel user in the ordered set where travelUserEmail = &#63;.
	 *
	 * @param travelUserEmail the travel user email
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching travel user, or <code>null</code> if a matching travel user could not be found
	 */
	public TravelUser fetchByfindByUserEmail_Last(
		String travelUserEmail,
		com.liferay.portal.kernel.util.OrderByComparator<TravelUser>
			orderByComparator);

	/**
	 * Returns the travel users before and after the current travel user in the ordered set where travelUserEmail = &#63;.
	 *
	 * @param travelUserId the primary key of the current travel user
	 * @param travelUserEmail the travel user email
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next travel user
	 * @throws NoSuchTravelUserException if a travel user with the primary key could not be found
	 */
	public TravelUser[] findByfindByUserEmail_PrevAndNext(
			long travelUserId, String travelUserEmail,
			com.liferay.portal.kernel.util.OrderByComparator<TravelUser>
				orderByComparator)
		throws NoSuchTravelUserException;

	/**
	 * Removes all the travel users where travelUserEmail = &#63; from the database.
	 *
	 * @param travelUserEmail the travel user email
	 */
	public void removeByfindByUserEmail(String travelUserEmail);

	/**
	 * Returns the number of travel users where travelUserEmail = &#63;.
	 *
	 * @param travelUserEmail the travel user email
	 * @return the number of matching travel users
	 */
	public int countByfindByUserEmail(String travelUserEmail);

	/**
	 * Returns all the travel users where userId = &#63; and companyId = &#63;.
	 *
	 * @param userId the user ID
	 * @param companyId the company ID
	 * @return the matching travel users
	 */
	public java.util.List<TravelUser> findByFind_TravelUsers(
		long userId, long companyId);

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
	public java.util.List<TravelUser> findByFind_TravelUsers(
		long userId, long companyId, int start, int end);

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
	public java.util.List<TravelUser> findByFind_TravelUsers(
		long userId, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TravelUser>
			orderByComparator);

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
	public java.util.List<TravelUser> findByFind_TravelUsers(
		long userId, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TravelUser>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first travel user in the ordered set where userId = &#63; and companyId = &#63;.
	 *
	 * @param userId the user ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching travel user
	 * @throws NoSuchTravelUserException if a matching travel user could not be found
	 */
	public TravelUser findByFind_TravelUsers_First(
			long userId, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<TravelUser>
				orderByComparator)
		throws NoSuchTravelUserException;

	/**
	 * Returns the first travel user in the ordered set where userId = &#63; and companyId = &#63;.
	 *
	 * @param userId the user ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching travel user, or <code>null</code> if a matching travel user could not be found
	 */
	public TravelUser fetchByFind_TravelUsers_First(
		long userId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<TravelUser>
			orderByComparator);

	/**
	 * Returns the last travel user in the ordered set where userId = &#63; and companyId = &#63;.
	 *
	 * @param userId the user ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching travel user
	 * @throws NoSuchTravelUserException if a matching travel user could not be found
	 */
	public TravelUser findByFind_TravelUsers_Last(
			long userId, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<TravelUser>
				orderByComparator)
		throws NoSuchTravelUserException;

	/**
	 * Returns the last travel user in the ordered set where userId = &#63; and companyId = &#63;.
	 *
	 * @param userId the user ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching travel user, or <code>null</code> if a matching travel user could not be found
	 */
	public TravelUser fetchByFind_TravelUsers_Last(
		long userId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<TravelUser>
			orderByComparator);

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
	public TravelUser[] findByFind_TravelUsers_PrevAndNext(
			long travelUserId, long userId, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<TravelUser>
				orderByComparator)
		throws NoSuchTravelUserException;

	/**
	 * Removes all the travel users where userId = &#63; and companyId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param companyId the company ID
	 */
	public void removeByFind_TravelUsers(long userId, long companyId);

	/**
	 * Returns the number of travel users where userId = &#63; and companyId = &#63;.
	 *
	 * @param userId the user ID
	 * @param companyId the company ID
	 * @return the number of matching travel users
	 */
	public int countByFind_TravelUsers(long userId, long companyId);

	/**
	 * Returns all the travel users where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching travel users
	 */
	public java.util.List<TravelUser> findByUserId(long userId);

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
	public java.util.List<TravelUser> findByUserId(
		long userId, int start, int end);

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
	public java.util.List<TravelUser> findByUserId(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TravelUser>
			orderByComparator);

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
	public java.util.List<TravelUser> findByUserId(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TravelUser>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first travel user in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching travel user
	 * @throws NoSuchTravelUserException if a matching travel user could not be found
	 */
	public TravelUser findByUserId_First(
			long userId,
			com.liferay.portal.kernel.util.OrderByComparator<TravelUser>
				orderByComparator)
		throws NoSuchTravelUserException;

	/**
	 * Returns the first travel user in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching travel user, or <code>null</code> if a matching travel user could not be found
	 */
	public TravelUser fetchByUserId_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator<TravelUser>
			orderByComparator);

	/**
	 * Returns the last travel user in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching travel user
	 * @throws NoSuchTravelUserException if a matching travel user could not be found
	 */
	public TravelUser findByUserId_Last(
			long userId,
			com.liferay.portal.kernel.util.OrderByComparator<TravelUser>
				orderByComparator)
		throws NoSuchTravelUserException;

	/**
	 * Returns the last travel user in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching travel user, or <code>null</code> if a matching travel user could not be found
	 */
	public TravelUser fetchByUserId_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator<TravelUser>
			orderByComparator);

	/**
	 * Returns the travel users before and after the current travel user in the ordered set where userId = &#63;.
	 *
	 * @param travelUserId the primary key of the current travel user
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next travel user
	 * @throws NoSuchTravelUserException if a travel user with the primary key could not be found
	 */
	public TravelUser[] findByUserId_PrevAndNext(
			long travelUserId, long userId,
			com.liferay.portal.kernel.util.OrderByComparator<TravelUser>
				orderByComparator)
		throws NoSuchTravelUserException;

	/**
	 * Removes all the travel users where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 */
	public void removeByUserId(long userId);

	/**
	 * Returns the number of travel users where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching travel users
	 */
	public int countByUserId(long userId);

	/**
	 * Returns all the travel users where area = &#63;.
	 *
	 * @param area the area
	 * @return the matching travel users
	 */
	public java.util.List<TravelUser> findByfindByArea(String area);

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
	public java.util.List<TravelUser> findByfindByArea(
		String area, int start, int end);

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
	public java.util.List<TravelUser> findByfindByArea(
		String area, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TravelUser>
			orderByComparator);

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
	public java.util.List<TravelUser> findByfindByArea(
		String area, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TravelUser>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first travel user in the ordered set where area = &#63;.
	 *
	 * @param area the area
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching travel user
	 * @throws NoSuchTravelUserException if a matching travel user could not be found
	 */
	public TravelUser findByfindByArea_First(
			String area,
			com.liferay.portal.kernel.util.OrderByComparator<TravelUser>
				orderByComparator)
		throws NoSuchTravelUserException;

	/**
	 * Returns the first travel user in the ordered set where area = &#63;.
	 *
	 * @param area the area
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching travel user, or <code>null</code> if a matching travel user could not be found
	 */
	public TravelUser fetchByfindByArea_First(
		String area,
		com.liferay.portal.kernel.util.OrderByComparator<TravelUser>
			orderByComparator);

	/**
	 * Returns the last travel user in the ordered set where area = &#63;.
	 *
	 * @param area the area
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching travel user
	 * @throws NoSuchTravelUserException if a matching travel user could not be found
	 */
	public TravelUser findByfindByArea_Last(
			String area,
			com.liferay.portal.kernel.util.OrderByComparator<TravelUser>
				orderByComparator)
		throws NoSuchTravelUserException;

	/**
	 * Returns the last travel user in the ordered set where area = &#63;.
	 *
	 * @param area the area
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching travel user, or <code>null</code> if a matching travel user could not be found
	 */
	public TravelUser fetchByfindByArea_Last(
		String area,
		com.liferay.portal.kernel.util.OrderByComparator<TravelUser>
			orderByComparator);

	/**
	 * Returns the travel users before and after the current travel user in the ordered set where area = &#63;.
	 *
	 * @param travelUserId the primary key of the current travel user
	 * @param area the area
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next travel user
	 * @throws NoSuchTravelUserException if a travel user with the primary key could not be found
	 */
	public TravelUser[] findByfindByArea_PrevAndNext(
			long travelUserId, String area,
			com.liferay.portal.kernel.util.OrderByComparator<TravelUser>
				orderByComparator)
		throws NoSuchTravelUserException;

	/**
	 * Removes all the travel users where area = &#63; from the database.
	 *
	 * @param area the area
	 */
	public void removeByfindByArea(String area);

	/**
	 * Returns the number of travel users where area = &#63;.
	 *
	 * @param area the area
	 * @return the number of matching travel users
	 */
	public int countByfindByArea(String area);

	/**
	 * Returns all the travel users where district = &#63;.
	 *
	 * @param district the district
	 * @return the matching travel users
	 */
	public java.util.List<TravelUser> findByfindByDistrict(long district);

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
	public java.util.List<TravelUser> findByfindByDistrict(
		long district, int start, int end);

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
	public java.util.List<TravelUser> findByfindByDistrict(
		long district, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TravelUser>
			orderByComparator);

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
	public java.util.List<TravelUser> findByfindByDistrict(
		long district, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TravelUser>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first travel user in the ordered set where district = &#63;.
	 *
	 * @param district the district
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching travel user
	 * @throws NoSuchTravelUserException if a matching travel user could not be found
	 */
	public TravelUser findByfindByDistrict_First(
			long district,
			com.liferay.portal.kernel.util.OrderByComparator<TravelUser>
				orderByComparator)
		throws NoSuchTravelUserException;

	/**
	 * Returns the first travel user in the ordered set where district = &#63;.
	 *
	 * @param district the district
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching travel user, or <code>null</code> if a matching travel user could not be found
	 */
	public TravelUser fetchByfindByDistrict_First(
		long district,
		com.liferay.portal.kernel.util.OrderByComparator<TravelUser>
			orderByComparator);

	/**
	 * Returns the last travel user in the ordered set where district = &#63;.
	 *
	 * @param district the district
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching travel user
	 * @throws NoSuchTravelUserException if a matching travel user could not be found
	 */
	public TravelUser findByfindByDistrict_Last(
			long district,
			com.liferay.portal.kernel.util.OrderByComparator<TravelUser>
				orderByComparator)
		throws NoSuchTravelUserException;

	/**
	 * Returns the last travel user in the ordered set where district = &#63;.
	 *
	 * @param district the district
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching travel user, or <code>null</code> if a matching travel user could not be found
	 */
	public TravelUser fetchByfindByDistrict_Last(
		long district,
		com.liferay.portal.kernel.util.OrderByComparator<TravelUser>
			orderByComparator);

	/**
	 * Returns the travel users before and after the current travel user in the ordered set where district = &#63;.
	 *
	 * @param travelUserId the primary key of the current travel user
	 * @param district the district
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next travel user
	 * @throws NoSuchTravelUserException if a travel user with the primary key could not be found
	 */
	public TravelUser[] findByfindByDistrict_PrevAndNext(
			long travelUserId, long district,
			com.liferay.portal.kernel.util.OrderByComparator<TravelUser>
				orderByComparator)
		throws NoSuchTravelUserException;

	/**
	 * Removes all the travel users where district = &#63; from the database.
	 *
	 * @param district the district
	 */
	public void removeByfindByDistrict(long district);

	/**
	 * Returns the number of travel users where district = &#63;.
	 *
	 * @param district the district
	 * @return the number of matching travel users
	 */
	public int countByfindByDistrict(long district);

	/**
	 * Returns all the travel users where district = &#63; and area = &#63;.
	 *
	 * @param district the district
	 * @param area the area
	 * @return the matching travel users
	 */
	public java.util.List<TravelUser> findByfindByDistricAndAreat(
		long district, String area);

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
	public java.util.List<TravelUser> findByfindByDistricAndAreat(
		long district, String area, int start, int end);

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
	public java.util.List<TravelUser> findByfindByDistricAndAreat(
		long district, String area, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TravelUser>
			orderByComparator);

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
	public java.util.List<TravelUser> findByfindByDistricAndAreat(
		long district, String area, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TravelUser>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first travel user in the ordered set where district = &#63; and area = &#63;.
	 *
	 * @param district the district
	 * @param area the area
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching travel user
	 * @throws NoSuchTravelUserException if a matching travel user could not be found
	 */
	public TravelUser findByfindByDistricAndAreat_First(
			long district, String area,
			com.liferay.portal.kernel.util.OrderByComparator<TravelUser>
				orderByComparator)
		throws NoSuchTravelUserException;

	/**
	 * Returns the first travel user in the ordered set where district = &#63; and area = &#63;.
	 *
	 * @param district the district
	 * @param area the area
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching travel user, or <code>null</code> if a matching travel user could not be found
	 */
	public TravelUser fetchByfindByDistricAndAreat_First(
		long district, String area,
		com.liferay.portal.kernel.util.OrderByComparator<TravelUser>
			orderByComparator);

	/**
	 * Returns the last travel user in the ordered set where district = &#63; and area = &#63;.
	 *
	 * @param district the district
	 * @param area the area
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching travel user
	 * @throws NoSuchTravelUserException if a matching travel user could not be found
	 */
	public TravelUser findByfindByDistricAndAreat_Last(
			long district, String area,
			com.liferay.portal.kernel.util.OrderByComparator<TravelUser>
				orderByComparator)
		throws NoSuchTravelUserException;

	/**
	 * Returns the last travel user in the ordered set where district = &#63; and area = &#63;.
	 *
	 * @param district the district
	 * @param area the area
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching travel user, or <code>null</code> if a matching travel user could not be found
	 */
	public TravelUser fetchByfindByDistricAndAreat_Last(
		long district, String area,
		com.liferay.portal.kernel.util.OrderByComparator<TravelUser>
			orderByComparator);

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
	public TravelUser[] findByfindByDistricAndAreat_PrevAndNext(
			long travelUserId, long district, String area,
			com.liferay.portal.kernel.util.OrderByComparator<TravelUser>
				orderByComparator)
		throws NoSuchTravelUserException;

	/**
	 * Removes all the travel users where district = &#63; and area = &#63; from the database.
	 *
	 * @param district the district
	 * @param area the area
	 */
	public void removeByfindByDistricAndAreat(long district, String area);

	/**
	 * Returns the number of travel users where district = &#63; and area = &#63;.
	 *
	 * @param district the district
	 * @param area the area
	 * @return the number of matching travel users
	 */
	public int countByfindByDistricAndAreat(long district, String area);

	/**
	 * Caches the travel user in the entity cache if it is enabled.
	 *
	 * @param travelUser the travel user
	 */
	public void cacheResult(TravelUser travelUser);

	/**
	 * Caches the travel users in the entity cache if it is enabled.
	 *
	 * @param travelUsers the travel users
	 */
	public void cacheResult(java.util.List<TravelUser> travelUsers);

	/**
	 * Creates a new travel user with the primary key. Does not add the travel user to the database.
	 *
	 * @param travelUserId the primary key for the new travel user
	 * @return the new travel user
	 */
	public TravelUser create(long travelUserId);

	/**
	 * Removes the travel user with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param travelUserId the primary key of the travel user
	 * @return the travel user that was removed
	 * @throws NoSuchTravelUserException if a travel user with the primary key could not be found
	 */
	public TravelUser remove(long travelUserId)
		throws NoSuchTravelUserException;

	public TravelUser updateImpl(TravelUser travelUser);

	/**
	 * Returns the travel user with the primary key or throws a <code>NoSuchTravelUserException</code> if it could not be found.
	 *
	 * @param travelUserId the primary key of the travel user
	 * @return the travel user
	 * @throws NoSuchTravelUserException if a travel user with the primary key could not be found
	 */
	public TravelUser findByPrimaryKey(long travelUserId)
		throws NoSuchTravelUserException;

	/**
	 * Returns the travel user with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param travelUserId the primary key of the travel user
	 * @return the travel user, or <code>null</code> if a travel user with the primary key could not be found
	 */
	public TravelUser fetchByPrimaryKey(long travelUserId);

	/**
	 * Returns all the travel users.
	 *
	 * @return the travel users
	 */
	public java.util.List<TravelUser> findAll();

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
	public java.util.List<TravelUser> findAll(int start, int end);

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
	public java.util.List<TravelUser> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TravelUser>
			orderByComparator);

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
	public java.util.List<TravelUser> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TravelUser>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the travel users from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of travel users.
	 *
	 * @return the number of travel users
	 */
	public int countAll();

}