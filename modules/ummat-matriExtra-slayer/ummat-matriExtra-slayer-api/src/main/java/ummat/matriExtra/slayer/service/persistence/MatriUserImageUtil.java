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

package ummat.matriExtra.slayer.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import ummat.matriExtra.slayer.model.MatriUserImage;

/**
 * The persistence utility for the matri user image service. This utility wraps <code>ummat.matriExtra.slayer.service.persistence.impl.MatriUserImagePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see MatriUserImagePersistence
 * @generated
 */
public class MatriUserImageUtil {

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
	public static void clearCache(MatriUserImage matriUserImage) {
		getPersistence().clearCache(matriUserImage);
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
	public static Map<Serializable, MatriUserImage> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<MatriUserImage> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<MatriUserImage> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<MatriUserImage> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<MatriUserImage> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static MatriUserImage update(MatriUserImage matriUserImage) {
		return getPersistence().update(matriUserImage);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static MatriUserImage update(
		MatriUserImage matriUserImage, ServiceContext serviceContext) {

		return getPersistence().update(matriUserImage, serviceContext);
	}

	/**
	 * Returns all the matri user images where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching matri user images
	 */
	public static List<MatriUserImage> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the matri user images where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MatriUserImageModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of matri user images
	 * @param end the upper bound of the range of matri user images (not inclusive)
	 * @return the range of matching matri user images
	 */
	public static List<MatriUserImage> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the matri user images where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MatriUserImageModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of matri user images
	 * @param end the upper bound of the range of matri user images (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching matri user images
	 */
	public static List<MatriUserImage> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<MatriUserImage> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the matri user images where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MatriUserImageModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of matri user images
	 * @param end the upper bound of the range of matri user images (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching matri user images
	 */
	public static List<MatriUserImage> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<MatriUserImage> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first matri user image in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching matri user image
	 * @throws NoSuchMatriUserImageException if a matching matri user image could not be found
	 */
	public static MatriUserImage findByUuid_First(
			String uuid, OrderByComparator<MatriUserImage> orderByComparator)
		throws ummat.matriExtra.slayer.exception.NoSuchMatriUserImageException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first matri user image in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching matri user image, or <code>null</code> if a matching matri user image could not be found
	 */
	public static MatriUserImage fetchByUuid_First(
		String uuid, OrderByComparator<MatriUserImage> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last matri user image in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching matri user image
	 * @throws NoSuchMatriUserImageException if a matching matri user image could not be found
	 */
	public static MatriUserImage findByUuid_Last(
			String uuid, OrderByComparator<MatriUserImage> orderByComparator)
		throws ummat.matriExtra.slayer.exception.NoSuchMatriUserImageException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last matri user image in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching matri user image, or <code>null</code> if a matching matri user image could not be found
	 */
	public static MatriUserImage fetchByUuid_Last(
		String uuid, OrderByComparator<MatriUserImage> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the matri user images before and after the current matri user image in the ordered set where uuid = &#63;.
	 *
	 * @param MatriImageId the primary key of the current matri user image
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next matri user image
	 * @throws NoSuchMatriUserImageException if a matri user image with the primary key could not be found
	 */
	public static MatriUserImage[] findByUuid_PrevAndNext(
			long MatriImageId, String uuid,
			OrderByComparator<MatriUserImage> orderByComparator)
		throws ummat.matriExtra.slayer.exception.NoSuchMatriUserImageException {

		return getPersistence().findByUuid_PrevAndNext(
			MatriImageId, uuid, orderByComparator);
	}

	/**
	 * Removes all the matri user images where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of matri user images where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching matri user images
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the matri user image where MatriUserId = &#63; or throws a <code>NoSuchMatriUserImageException</code> if it could not be found.
	 *
	 * @param MatriUserId the matri user ID
	 * @return the matching matri user image
	 * @throws NoSuchMatriUserImageException if a matching matri user image could not be found
	 */
	public static MatriUserImage findByFindByMatriExtraImages(long MatriUserId)
		throws ummat.matriExtra.slayer.exception.NoSuchMatriUserImageException {

		return getPersistence().findByFindByMatriExtraImages(MatriUserId);
	}

	/**
	 * Returns the matri user image where MatriUserId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param MatriUserId the matri user ID
	 * @return the matching matri user image, or <code>null</code> if a matching matri user image could not be found
	 */
	public static MatriUserImage fetchByFindByMatriExtraImages(
		long MatriUserId) {

		return getPersistence().fetchByFindByMatriExtraImages(MatriUserId);
	}

	/**
	 * Returns the matri user image where MatriUserId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param MatriUserId the matri user ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching matri user image, or <code>null</code> if a matching matri user image could not be found
	 */
	public static MatriUserImage fetchByFindByMatriExtraImages(
		long MatriUserId, boolean useFinderCache) {

		return getPersistence().fetchByFindByMatriExtraImages(
			MatriUserId, useFinderCache);
	}

	/**
	 * Removes the matri user image where MatriUserId = &#63; from the database.
	 *
	 * @param MatriUserId the matri user ID
	 * @return the matri user image that was removed
	 */
	public static MatriUserImage removeByFindByMatriExtraImages(
			long MatriUserId)
		throws ummat.matriExtra.slayer.exception.NoSuchMatriUserImageException {

		return getPersistence().removeByFindByMatriExtraImages(MatriUserId);
	}

	/**
	 * Returns the number of matri user images where MatriUserId = &#63;.
	 *
	 * @param MatriUserId the matri user ID
	 * @return the number of matching matri user images
	 */
	public static int countByFindByMatriExtraImages(long MatriUserId) {
		return getPersistence().countByFindByMatriExtraImages(MatriUserId);
	}

	/**
	 * Returns the matri user image where userId = &#63; or throws a <code>NoSuchMatriUserImageException</code> if it could not be found.
	 *
	 * @param userId the user ID
	 * @return the matching matri user image
	 * @throws NoSuchMatriUserImageException if a matching matri user image could not be found
	 */
	public static MatriUserImage findByFindByMatriExtraImagesUserId(long userId)
		throws ummat.matriExtra.slayer.exception.NoSuchMatriUserImageException {

		return getPersistence().findByFindByMatriExtraImagesUserId(userId);
	}

	/**
	 * Returns the matri user image where userId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param userId the user ID
	 * @return the matching matri user image, or <code>null</code> if a matching matri user image could not be found
	 */
	public static MatriUserImage fetchByFindByMatriExtraImagesUserId(
		long userId) {

		return getPersistence().fetchByFindByMatriExtraImagesUserId(userId);
	}

	/**
	 * Returns the matri user image where userId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param userId the user ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching matri user image, or <code>null</code> if a matching matri user image could not be found
	 */
	public static MatriUserImage fetchByFindByMatriExtraImagesUserId(
		long userId, boolean useFinderCache) {

		return getPersistence().fetchByFindByMatriExtraImagesUserId(
			userId, useFinderCache);
	}

	/**
	 * Removes the matri user image where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @return the matri user image that was removed
	 */
	public static MatriUserImage removeByFindByMatriExtraImagesUserId(
			long userId)
		throws ummat.matriExtra.slayer.exception.NoSuchMatriUserImageException {

		return getPersistence().removeByFindByMatriExtraImagesUserId(userId);
	}

	/**
	 * Returns the number of matri user images where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching matri user images
	 */
	public static int countByFindByMatriExtraImagesUserId(long userId) {
		return getPersistence().countByFindByMatriExtraImagesUserId(userId);
	}

	/**
	 * Caches the matri user image in the entity cache if it is enabled.
	 *
	 * @param matriUserImage the matri user image
	 */
	public static void cacheResult(MatriUserImage matriUserImage) {
		getPersistence().cacheResult(matriUserImage);
	}

	/**
	 * Caches the matri user images in the entity cache if it is enabled.
	 *
	 * @param matriUserImages the matri user images
	 */
	public static void cacheResult(List<MatriUserImage> matriUserImages) {
		getPersistence().cacheResult(matriUserImages);
	}

	/**
	 * Creates a new matri user image with the primary key. Does not add the matri user image to the database.
	 *
	 * @param MatriImageId the primary key for the new matri user image
	 * @return the new matri user image
	 */
	public static MatriUserImage create(long MatriImageId) {
		return getPersistence().create(MatriImageId);
	}

	/**
	 * Removes the matri user image with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param MatriImageId the primary key of the matri user image
	 * @return the matri user image that was removed
	 * @throws NoSuchMatriUserImageException if a matri user image with the primary key could not be found
	 */
	public static MatriUserImage remove(long MatriImageId)
		throws ummat.matriExtra.slayer.exception.NoSuchMatriUserImageException {

		return getPersistence().remove(MatriImageId);
	}

	public static MatriUserImage updateImpl(MatriUserImage matriUserImage) {
		return getPersistence().updateImpl(matriUserImage);
	}

	/**
	 * Returns the matri user image with the primary key or throws a <code>NoSuchMatriUserImageException</code> if it could not be found.
	 *
	 * @param MatriImageId the primary key of the matri user image
	 * @return the matri user image
	 * @throws NoSuchMatriUserImageException if a matri user image with the primary key could not be found
	 */
	public static MatriUserImage findByPrimaryKey(long MatriImageId)
		throws ummat.matriExtra.slayer.exception.NoSuchMatriUserImageException {

		return getPersistence().findByPrimaryKey(MatriImageId);
	}

	/**
	 * Returns the matri user image with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param MatriImageId the primary key of the matri user image
	 * @return the matri user image, or <code>null</code> if a matri user image with the primary key could not be found
	 */
	public static MatriUserImage fetchByPrimaryKey(long MatriImageId) {
		return getPersistence().fetchByPrimaryKey(MatriImageId);
	}

	/**
	 * Returns all the matri user images.
	 *
	 * @return the matri user images
	 */
	public static List<MatriUserImage> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the matri user images.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MatriUserImageModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of matri user images
	 * @param end the upper bound of the range of matri user images (not inclusive)
	 * @return the range of matri user images
	 */
	public static List<MatriUserImage> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the matri user images.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MatriUserImageModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of matri user images
	 * @param end the upper bound of the range of matri user images (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matri user images
	 */
	public static List<MatriUserImage> findAll(
		int start, int end,
		OrderByComparator<MatriUserImage> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the matri user images.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MatriUserImageModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of matri user images
	 * @param end the upper bound of the range of matri user images (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matri user images
	 */
	public static List<MatriUserImage> findAll(
		int start, int end, OrderByComparator<MatriUserImage> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the matri user images from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of matri user images.
	 *
	 * @return the number of matri user images
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static MatriUserImagePersistence getPersistence() {
		return _persistence;
	}

	private static volatile MatriUserImagePersistence _persistence;

}