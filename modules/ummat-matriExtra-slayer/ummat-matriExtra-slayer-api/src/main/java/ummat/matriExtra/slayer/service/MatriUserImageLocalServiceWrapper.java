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

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link MatriUserImageLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see MatriUserImageLocalService
 * @generated
 */
public class MatriUserImageLocalServiceWrapper
	implements MatriUserImageLocalService,
			   ServiceWrapper<MatriUserImageLocalService> {

	public MatriUserImageLocalServiceWrapper() {
		this(null);
	}

	public MatriUserImageLocalServiceWrapper(
		MatriUserImageLocalService matriUserImageLocalService) {

		_matriUserImageLocalService = matriUserImageLocalService;
	}

	@Override
	public ummat.matriExtra.slayer.model.MatriUserImage addMatriUserImage(
			long userId, String userName, long matriUserId,
			java.io.InputStream imageOne, java.io.InputStream imageTwo,
			java.io.InputStream imageThree, java.io.InputStream imageFour)
		throws Exception {

		return _matriUserImageLocalService.addMatriUserImage(
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
	@Override
	public ummat.matriExtra.slayer.model.MatriUserImage addMatriUserImage(
		ummat.matriExtra.slayer.model.MatriUserImage matriUserImage) {

		return _matriUserImageLocalService.addMatriUserImage(matriUserImage);
	}

	/**
	 * Creates a new matri user image with the primary key. Does not add the matri user image to the database.
	 *
	 * @param MatriImageId the primary key for the new matri user image
	 * @return the new matri user image
	 */
	@Override
	public ummat.matriExtra.slayer.model.MatriUserImage createMatriUserImage(
		long MatriImageId) {

		return _matriUserImageLocalService.createMatriUserImage(MatriImageId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _matriUserImageLocalService.createPersistedModel(primaryKeyObj);
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
	@Override
	public ummat.matriExtra.slayer.model.MatriUserImage deleteMatriUserImage(
			long MatriImageId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _matriUserImageLocalService.deleteMatriUserImage(MatriImageId);
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
	@Override
	public ummat.matriExtra.slayer.model.MatriUserImage deleteMatriUserImage(
		ummat.matriExtra.slayer.model.MatriUserImage matriUserImage) {

		return _matriUserImageLocalService.deleteMatriUserImage(matriUserImage);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _matriUserImageLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _matriUserImageLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _matriUserImageLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _matriUserImageLocalService.dynamicQuery();
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

		return _matriUserImageLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _matriUserImageLocalService.dynamicQuery(
			dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _matriUserImageLocalService.dynamicQuery(
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

		return _matriUserImageLocalService.dynamicQueryCount(dynamicQuery);
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

		return _matriUserImageLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public ummat.matriExtra.slayer.model.MatriUserImage fetchMatriUserImage(
		long MatriImageId) {

		return _matriUserImageLocalService.fetchMatriUserImage(MatriImageId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _matriUserImageLocalService.getActionableDynamicQuery();
	}

	@Override
	public ummat.matriExtra.slayer.model.MatriUserImageImageFourBlobModel
		getImageFourBlobModel(java.io.Serializable primaryKey) {

		return _matriUserImageLocalService.getImageFourBlobModel(primaryKey);
	}

	@Override
	public ummat.matriExtra.slayer.model.MatriUserImageImageOneBlobModel
		getImageOneBlobModel(java.io.Serializable primaryKey) {

		return _matriUserImageLocalService.getImageOneBlobModel(primaryKey);
	}

	@Override
	public ummat.matriExtra.slayer.model.MatriUserImageImageThreeBlobModel
		getImageThreeBlobModel(java.io.Serializable primaryKey) {

		return _matriUserImageLocalService.getImageThreeBlobModel(primaryKey);
	}

	@Override
	public ummat.matriExtra.slayer.model.MatriUserImageImageTwoBlobModel
		getImageTwoBlobModel(java.io.Serializable primaryKey) {

		return _matriUserImageLocalService.getImageTwoBlobModel(primaryKey);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _matriUserImageLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the matri user image with the primary key.
	 *
	 * @param MatriImageId the primary key of the matri user image
	 * @return the matri user image
	 * @throws PortalException if a matri user image with the primary key could not be found
	 */
	@Override
	public ummat.matriExtra.slayer.model.MatriUserImage getMatriUserImage(
			long MatriImageId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _matriUserImageLocalService.getMatriUserImage(MatriImageId);
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
	@Override
	public java.util.List<ummat.matriExtra.slayer.model.MatriUserImage>
		getMatriUserImages(int start, int end) {

		return _matriUserImageLocalService.getMatriUserImages(start, end);
	}

	/**
	 * Returns the number of matri user images.
	 *
	 * @return the number of matri user images
	 */
	@Override
	public int getMatriUserImagesCount() {
		return _matriUserImageLocalService.getMatriUserImagesCount();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _matriUserImageLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _matriUserImageLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public java.io.InputStream openImageFourInputStream(long MatriImageId) {
		return _matriUserImageLocalService.openImageFourInputStream(
			MatriImageId);
	}

	@Override
	public java.io.InputStream openImageOneInputStream(long MatriImageId) {
		return _matriUserImageLocalService.openImageOneInputStream(
			MatriImageId);
	}

	@Override
	public java.io.InputStream openImageThreeInputStream(long MatriImageId) {
		return _matriUserImageLocalService.openImageThreeInputStream(
			MatriImageId);
	}

	@Override
	public java.io.InputStream openImageTwoInputStream(long MatriImageId) {
		return _matriUserImageLocalService.openImageTwoInputStream(
			MatriImageId);
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
	@Override
	public ummat.matriExtra.slayer.model.MatriUserImage updateMatriUserImage(
		ummat.matriExtra.slayer.model.MatriUserImage matriUserImage) {

		return _matriUserImageLocalService.updateMatriUserImage(matriUserImage);
	}

	@Override
	public MatriUserImageLocalService getWrappedService() {
		return _matriUserImageLocalService;
	}

	@Override
	public void setWrappedService(
		MatriUserImageLocalService matriUserImageLocalService) {

		_matriUserImageLocalService = matriUserImageLocalService;
	}

	private MatriUserImageLocalService _matriUserImageLocalService;

}