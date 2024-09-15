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

package ummat.matriExtra.slayer.service;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.InputStream;
import java.io.Serializable;

import java.util.List;

import ummat.matriExtra.slayer.model.MatriUserImage;

/**
 * Provides the local service utility for MatriUserImage. This utility wraps
 * <code>ummat.matriExtra.slayer.service.impl.MatriUserImageLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see MatriUserImageLocalService
 * @generated
 */
public class MatriUserImageLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>ummat.matriExtra.slayer.service.impl.MatriUserImageLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static MatriUserImage addMatriUserImage(
			long userId, String userName, long matriUserId,
			InputStream imageOne, InputStream imageTwo, InputStream imageThree,
			InputStream imageFour)
		throws Exception {

		return getService().addMatriUserImage(
			userId, userName, matriUserId, imageOne, imageTwo, imageThree,
			imageFour);
	}

	/**
	 * Adds the matri user image to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect MatriUserImageLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param matriUserImage the matri user image
	 * @return the matri user image that was added
	 */
	public static MatriUserImage addMatriUserImage(
		MatriUserImage matriUserImage) {

		return getService().addMatriUserImage(matriUserImage);
	}

	/**
	 * Creates a new matri user image with the primary key. Does not add the matri user image to the database.
	 *
	 * @param MatriImageId the primary key for the new matri user image
	 * @return the new matri user image
	 */
	public static MatriUserImage createMatriUserImage(long MatriImageId) {
		return getService().createMatriUserImage(MatriImageId);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel createPersistedModel(
			Serializable primaryKeyObj)
		throws PortalException {

		return getService().createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the matri user image with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect MatriUserImageLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param MatriImageId the primary key of the matri user image
	 * @return the matri user image that was removed
	 * @throws PortalException if a matri user image with the primary key could not be found
	 */
	public static MatriUserImage deleteMatriUserImage(long MatriImageId)
		throws PortalException {

		return getService().deleteMatriUserImage(MatriImageId);
	}

	/**
	 * Deletes the matri user image from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect MatriUserImageLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param matriUserImage the matri user image
	 * @return the matri user image that was removed
	 */
	public static MatriUserImage deleteMatriUserImage(
		MatriUserImage matriUserImage) {

		return getService().deleteMatriUserImage(matriUserImage);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel deletePersistedModel(
			PersistedModel persistedModel)
		throws PortalException {

		return getService().deletePersistedModel(persistedModel);
	}

	public static <T> T dslQuery(DSLQuery dslQuery) {
		return getService().dslQuery(dslQuery);
	}

	public static int dslQueryCount(DSLQuery dslQuery) {
		return getService().dslQueryCount(dslQuery);
	}

	public static DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	public static <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ummat.matriExtra.slayer.model.impl.MatriUserImageModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ummat.matriExtra.slayer.model.impl.MatriUserImageModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator) {

		return getService().dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static MatriUserImage fetchMatriUserImage(long MatriImageId) {
		return getService().fetchMatriUserImage(MatriImageId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static ummat.matriExtra.slayer.model.MatriUserImageImageFourBlobModel
		getImageFourBlobModel(Serializable primaryKey) {

		return getService().getImageFourBlobModel(primaryKey);
	}

	public static ummat.matriExtra.slayer.model.MatriUserImageImageOneBlobModel
		getImageOneBlobModel(Serializable primaryKey) {

		return getService().getImageOneBlobModel(primaryKey);
	}

	public static
		ummat.matriExtra.slayer.model.MatriUserImageImageThreeBlobModel
			getImageThreeBlobModel(Serializable primaryKey) {

		return getService().getImageThreeBlobModel(primaryKey);
	}

	public static ummat.matriExtra.slayer.model.MatriUserImageImageTwoBlobModel
		getImageTwoBlobModel(Serializable primaryKey) {

		return getService().getImageTwoBlobModel(primaryKey);
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the matri user image with the primary key.
	 *
	 * @param MatriImageId the primary key of the matri user image
	 * @return the matri user image
	 * @throws PortalException if a matri user image with the primary key could not be found
	 */
	public static MatriUserImage getMatriUserImage(long MatriImageId)
		throws PortalException {

		return getService().getMatriUserImage(MatriImageId);
	}

	/**
	 * Returns a range of all the matri user images.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ummat.matriExtra.slayer.model.impl.MatriUserImageModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of matri user images
	 * @param end the upper bound of the range of matri user images (not inclusive)
	 * @return the range of matri user images
	 */
	public static List<MatriUserImage> getMatriUserImages(int start, int end) {
		return getService().getMatriUserImages(start, end);
	}

	/**
	 * Returns the number of matri user images.
	 *
	 * @return the number of matri user images
	 */
	public static int getMatriUserImagesCount() {
		return getService().getMatriUserImagesCount();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	public static InputStream openImageFourInputStream(long MatriImageId) {
		return getService().openImageFourInputStream(MatriImageId);
	}

	public static InputStream openImageOneInputStream(long MatriImageId) {
		return getService().openImageOneInputStream(MatriImageId);
	}

	public static InputStream openImageThreeInputStream(long MatriImageId) {
		return getService().openImageThreeInputStream(MatriImageId);
	}

	public static InputStream openImageTwoInputStream(long MatriImageId) {
		return getService().openImageTwoInputStream(MatriImageId);
	}

	/**
	 * Updates the matri user image in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect MatriUserImageLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param matriUserImage the matri user image
	 * @return the matri user image that was updated
	 */
	public static MatriUserImage updateMatriUserImage(
		MatriUserImage matriUserImage) {

		return getService().updateMatriUserImage(matriUserImage);
	}

	public static MatriUserImageLocalService getService() {
		return _service;
	}

	private static volatile MatriUserImageLocalService _service;

}