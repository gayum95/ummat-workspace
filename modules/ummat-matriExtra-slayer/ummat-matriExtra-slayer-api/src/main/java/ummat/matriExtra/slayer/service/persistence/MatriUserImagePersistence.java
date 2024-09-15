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

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

import ummat.matriExtra.slayer.exception.NoSuchMatriUserImageException;
import ummat.matriExtra.slayer.model.MatriUserImage;

/**
 * The persistence interface for the matri user image service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see MatriUserImageUtil
 * @generated
 */
@ProviderType
public interface MatriUserImagePersistence
	extends BasePersistence<MatriUserImage> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link MatriUserImageUtil} to access the matri user image persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the matri user images where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching matri user images
	 */
	public java.util.List<MatriUserImage> findByUuid(String uuid);

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
	public java.util.List<MatriUserImage> findByUuid(
		String uuid, int start, int end);

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
	public java.util.List<MatriUserImage> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MatriUserImage>
			orderByComparator);

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
	public java.util.List<MatriUserImage> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MatriUserImage>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first matri user image in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching matri user image
	 * @throws NoSuchMatriUserImageException if a matching matri user image could not be found
	 */
	public MatriUserImage findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<MatriUserImage>
				orderByComparator)
		throws NoSuchMatriUserImageException;

	/**
	 * Returns the first matri user image in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching matri user image, or <code>null</code> if a matching matri user image could not be found
	 */
	public MatriUserImage fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<MatriUserImage>
			orderByComparator);

	/**
	 * Returns the last matri user image in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching matri user image
	 * @throws NoSuchMatriUserImageException if a matching matri user image could not be found
	 */
	public MatriUserImage findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<MatriUserImage>
				orderByComparator)
		throws NoSuchMatriUserImageException;

	/**
	 * Returns the last matri user image in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching matri user image, or <code>null</code> if a matching matri user image could not be found
	 */
	public MatriUserImage fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<MatriUserImage>
			orderByComparator);

	/**
	 * Returns the matri user images before and after the current matri user image in the ordered set where uuid = &#63;.
	 *
	 * @param MatriImageId the primary key of the current matri user image
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next matri user image
	 * @throws NoSuchMatriUserImageException if a matri user image with the primary key could not be found
	 */
	public MatriUserImage[] findByUuid_PrevAndNext(
			long MatriImageId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<MatriUserImage>
				orderByComparator)
		throws NoSuchMatriUserImageException;

	/**
	 * Removes all the matri user images where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of matri user images where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching matri user images
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the matri user image where MatriUserId = &#63; or throws a <code>NoSuchMatriUserImageException</code> if it could not be found.
	 *
	 * @param MatriUserId the matri user ID
	 * @return the matching matri user image
	 * @throws NoSuchMatriUserImageException if a matching matri user image could not be found
	 */
	public MatriUserImage findByFindByMatriExtraImages(long MatriUserId)
		throws NoSuchMatriUserImageException;

	/**
	 * Returns the matri user image where MatriUserId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param MatriUserId the matri user ID
	 * @return the matching matri user image, or <code>null</code> if a matching matri user image could not be found
	 */
	public MatriUserImage fetchByFindByMatriExtraImages(long MatriUserId);

	/**
	 * Returns the matri user image where MatriUserId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param MatriUserId the matri user ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching matri user image, or <code>null</code> if a matching matri user image could not be found
	 */
	public MatriUserImage fetchByFindByMatriExtraImages(
		long MatriUserId, boolean useFinderCache);

	/**
	 * Removes the matri user image where MatriUserId = &#63; from the database.
	 *
	 * @param MatriUserId the matri user ID
	 * @return the matri user image that was removed
	 */
	public MatriUserImage removeByFindByMatriExtraImages(long MatriUserId)
		throws NoSuchMatriUserImageException;

	/**
	 * Returns the number of matri user images where MatriUserId = &#63;.
	 *
	 * @param MatriUserId the matri user ID
	 * @return the number of matching matri user images
	 */
	public int countByFindByMatriExtraImages(long MatriUserId);

	/**
	 * Returns the matri user image where userId = &#63; or throws a <code>NoSuchMatriUserImageException</code> if it could not be found.
	 *
	 * @param userId the user ID
	 * @return the matching matri user image
	 * @throws NoSuchMatriUserImageException if a matching matri user image could not be found
	 */
	public MatriUserImage findByFindByMatriExtraImagesUserId(long userId)
		throws NoSuchMatriUserImageException;

	/**
	 * Returns the matri user image where userId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param userId the user ID
	 * @return the matching matri user image, or <code>null</code> if a matching matri user image could not be found
	 */
	public MatriUserImage fetchByFindByMatriExtraImagesUserId(long userId);

	/**
	 * Returns the matri user image where userId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param userId the user ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching matri user image, or <code>null</code> if a matching matri user image could not be found
	 */
	public MatriUserImage fetchByFindByMatriExtraImagesUserId(
		long userId, boolean useFinderCache);

	/**
	 * Removes the matri user image where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @return the matri user image that was removed
	 */
	public MatriUserImage removeByFindByMatriExtraImagesUserId(long userId)
		throws NoSuchMatriUserImageException;

	/**
	 * Returns the number of matri user images where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching matri user images
	 */
	public int countByFindByMatriExtraImagesUserId(long userId);

	/**
	 * Caches the matri user image in the entity cache if it is enabled.
	 *
	 * @param matriUserImage the matri user image
	 */
	public void cacheResult(MatriUserImage matriUserImage);

	/**
	 * Caches the matri user images in the entity cache if it is enabled.
	 *
	 * @param matriUserImages the matri user images
	 */
	public void cacheResult(java.util.List<MatriUserImage> matriUserImages);

	/**
	 * Creates a new matri user image with the primary key. Does not add the matri user image to the database.
	 *
	 * @param MatriImageId the primary key for the new matri user image
	 * @return the new matri user image
	 */
	public MatriUserImage create(long MatriImageId);

	/**
	 * Removes the matri user image with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param MatriImageId the primary key of the matri user image
	 * @return the matri user image that was removed
	 * @throws NoSuchMatriUserImageException if a matri user image with the primary key could not be found
	 */
	public MatriUserImage remove(long MatriImageId)
		throws NoSuchMatriUserImageException;

	public MatriUserImage updateImpl(MatriUserImage matriUserImage);

	/**
	 * Returns the matri user image with the primary key or throws a <code>NoSuchMatriUserImageException</code> if it could not be found.
	 *
	 * @param MatriImageId the primary key of the matri user image
	 * @return the matri user image
	 * @throws NoSuchMatriUserImageException if a matri user image with the primary key could not be found
	 */
	public MatriUserImage findByPrimaryKey(long MatriImageId)
		throws NoSuchMatriUserImageException;

	/**
	 * Returns the matri user image with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param MatriImageId the primary key of the matri user image
	 * @return the matri user image, or <code>null</code> if a matri user image with the primary key could not be found
	 */
	public MatriUserImage fetchByPrimaryKey(long MatriImageId);

	/**
	 * Returns all the matri user images.
	 *
	 * @return the matri user images
	 */
	public java.util.List<MatriUserImage> findAll();

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
	public java.util.List<MatriUserImage> findAll(int start, int end);

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
	public java.util.List<MatriUserImage> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MatriUserImage>
			orderByComparator);

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
	public java.util.List<MatriUserImage> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MatriUserImage>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the matri user images from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of matri user images.
	 *
	 * @return the number of matri user images
	 */
	public int countAll();

}