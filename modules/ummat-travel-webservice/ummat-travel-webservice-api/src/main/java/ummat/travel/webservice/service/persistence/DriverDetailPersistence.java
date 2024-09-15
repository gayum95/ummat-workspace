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

import ummat.travel.webservice.exception.NoSuchDriverDetailException;
import ummat.travel.webservice.model.DriverDetail;

/**
 * The persistence interface for the driver detail service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DriverDetailUtil
 * @generated
 */
@ProviderType
public interface DriverDetailPersistence extends BasePersistence<DriverDetail> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link DriverDetailUtil} to access the driver detail persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns the driver detail where driverId = &#63; or throws a <code>NoSuchDriverDetailException</code> if it could not be found.
	 *
	 * @param driverId the driver ID
	 * @return the matching driver detail
	 * @throws NoSuchDriverDetailException if a matching driver detail could not be found
	 */
	public DriverDetail findByfindByDriverId(long driverId)
		throws NoSuchDriverDetailException;

	/**
	 * Returns the driver detail where driverId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param driverId the driver ID
	 * @return the matching driver detail, or <code>null</code> if a matching driver detail could not be found
	 */
	public DriverDetail fetchByfindByDriverId(long driverId);

	/**
	 * Returns the driver detail where driverId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param driverId the driver ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching driver detail, or <code>null</code> if a matching driver detail could not be found
	 */
	public DriverDetail fetchByfindByDriverId(
		long driverId, boolean useFinderCache);

	/**
	 * Removes the driver detail where driverId = &#63; from the database.
	 *
	 * @param driverId the driver ID
	 * @return the driver detail that was removed
	 */
	public DriverDetail removeByfindByDriverId(long driverId)
		throws NoSuchDriverDetailException;

	/**
	 * Returns the number of driver details where driverId = &#63;.
	 *
	 * @param driverId the driver ID
	 * @return the number of matching driver details
	 */
	public int countByfindByDriverId(long driverId);

	/**
	 * Returns the driver detail where userId = &#63; and companyId = &#63; or throws a <code>NoSuchDriverDetailException</code> if it could not be found.
	 *
	 * @param userId the user ID
	 * @param companyId the company ID
	 * @return the matching driver detail
	 * @throws NoSuchDriverDetailException if a matching driver detail could not be found
	 */
	public DriverDetail findByFind_DriverDetail(long userId, long companyId)
		throws NoSuchDriverDetailException;

	/**
	 * Returns the driver detail where userId = &#63; and companyId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param userId the user ID
	 * @param companyId the company ID
	 * @return the matching driver detail, or <code>null</code> if a matching driver detail could not be found
	 */
	public DriverDetail fetchByFind_DriverDetail(long userId, long companyId);

	/**
	 * Returns the driver detail where userId = &#63; and companyId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param userId the user ID
	 * @param companyId the company ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching driver detail, or <code>null</code> if a matching driver detail could not be found
	 */
	public DriverDetail fetchByFind_DriverDetail(
		long userId, long companyId, boolean useFinderCache);

	/**
	 * Removes the driver detail where userId = &#63; and companyId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param companyId the company ID
	 * @return the driver detail that was removed
	 */
	public DriverDetail removeByFind_DriverDetail(long userId, long companyId)
		throws NoSuchDriverDetailException;

	/**
	 * Returns the number of driver details where userId = &#63; and companyId = &#63;.
	 *
	 * @param userId the user ID
	 * @param companyId the company ID
	 * @return the number of matching driver details
	 */
	public int countByFind_DriverDetail(long userId, long companyId);

	/**
	 * Caches the driver detail in the entity cache if it is enabled.
	 *
	 * @param driverDetail the driver detail
	 */
	public void cacheResult(DriverDetail driverDetail);

	/**
	 * Caches the driver details in the entity cache if it is enabled.
	 *
	 * @param driverDetails the driver details
	 */
	public void cacheResult(java.util.List<DriverDetail> driverDetails);

	/**
	 * Creates a new driver detail with the primary key. Does not add the driver detail to the database.
	 *
	 * @param driverId the primary key for the new driver detail
	 * @return the new driver detail
	 */
	public DriverDetail create(long driverId);

	/**
	 * Removes the driver detail with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param driverId the primary key of the driver detail
	 * @return the driver detail that was removed
	 * @throws NoSuchDriverDetailException if a driver detail with the primary key could not be found
	 */
	public DriverDetail remove(long driverId)
		throws NoSuchDriverDetailException;

	public DriverDetail updateImpl(DriverDetail driverDetail);

	/**
	 * Returns the driver detail with the primary key or throws a <code>NoSuchDriverDetailException</code> if it could not be found.
	 *
	 * @param driverId the primary key of the driver detail
	 * @return the driver detail
	 * @throws NoSuchDriverDetailException if a driver detail with the primary key could not be found
	 */
	public DriverDetail findByPrimaryKey(long driverId)
		throws NoSuchDriverDetailException;

	/**
	 * Returns the driver detail with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param driverId the primary key of the driver detail
	 * @return the driver detail, or <code>null</code> if a driver detail with the primary key could not be found
	 */
	public DriverDetail fetchByPrimaryKey(long driverId);

	/**
	 * Returns all the driver details.
	 *
	 * @return the driver details
	 */
	public java.util.List<DriverDetail> findAll();

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
	public java.util.List<DriverDetail> findAll(int start, int end);

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
	public java.util.List<DriverDetail> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DriverDetail>
			orderByComparator);

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
	public java.util.List<DriverDetail> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DriverDetail>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the driver details from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of driver details.
	 *
	 * @return the number of driver details
	 */
	public int countAll();

}