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

package ummat.matriExtra.slayer.service.base;

import com.liferay.petra.io.AutoDeleteFileInputStream;
import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.dao.db.DB;
import com.liferay.portal.kernel.dao.db.DBManagerUtil;
import com.liferay.portal.kernel.dao.db.DBType;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DefaultActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.io.unsync.UnsyncByteArrayInputStream;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.module.framework.service.IdentifiableOSGiService;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalServiceImpl;
import com.liferay.portal.kernel.service.PersistedModelLocalService;
import com.liferay.portal.kernel.service.persistence.BasePersistence;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.File;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PortalUtil;

import java.io.InputStream;
import java.io.Serializable;

import java.lang.reflect.Field;

import java.sql.Blob;

import java.util.List;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

import ummat.matriExtra.slayer.model.MatriUserImage;
import ummat.matriExtra.slayer.model.MatriUserImageImageFourBlobModel;
import ummat.matriExtra.slayer.model.MatriUserImageImageOneBlobModel;
import ummat.matriExtra.slayer.model.MatriUserImageImageThreeBlobModel;
import ummat.matriExtra.slayer.model.MatriUserImageImageTwoBlobModel;
import ummat.matriExtra.slayer.service.MatriUserImageLocalService;
import ummat.matriExtra.slayer.service.MatriUserImageLocalServiceUtil;
import ummat.matriExtra.slayer.service.persistence.MatriUserImagePersistence;

/**
 * Provides the base implementation for the matri user image local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link ummat.matriExtra.slayer.service.impl.MatriUserImageLocalServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ummat.matriExtra.slayer.service.impl.MatriUserImageLocalServiceImpl
 * @generated
 */
public abstract class MatriUserImageLocalServiceBaseImpl
	extends BaseLocalServiceImpl
	implements AopService, IdentifiableOSGiService, MatriUserImageLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Use <code>MatriUserImageLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>MatriUserImageLocalServiceUtil</code>.
	 */

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
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public MatriUserImage addMatriUserImage(MatriUserImage matriUserImage) {
		matriUserImage.setNew(true);

		return matriUserImagePersistence.update(matriUserImage);
	}

	/**
	 * Creates a new matri user image with the primary key. Does not add the matri user image to the database.
	 *
	 * @param MatriImageId the primary key for the new matri user image
	 * @return the new matri user image
	 */
	@Override
	@Transactional(enabled = false)
	public MatriUserImage createMatriUserImage(long MatriImageId) {
		return matriUserImagePersistence.create(MatriImageId);
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
	@Indexable(type = IndexableType.DELETE)
	@Override
	public MatriUserImage deleteMatriUserImage(long MatriImageId)
		throws PortalException {

		return matriUserImagePersistence.remove(MatriImageId);
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
	@Indexable(type = IndexableType.DELETE)
	@Override
	public MatriUserImage deleteMatriUserImage(MatriUserImage matriUserImage) {
		return matriUserImagePersistence.remove(matriUserImage);
	}

	@Override
	public <T> T dslQuery(DSLQuery dslQuery) {
		return matriUserImagePersistence.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(DSLQuery dslQuery) {
		Long count = dslQuery(dslQuery);

		return count.intValue();
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(
			MatriUserImage.class, clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return matriUserImagePersistence.findWithDynamicQuery(dynamicQuery);
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
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return matriUserImagePersistence.findWithDynamicQuery(
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
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator) {

		return matriUserImagePersistence.findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return matriUserImagePersistence.countWithDynamicQuery(dynamicQuery);
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
		DynamicQuery dynamicQuery, Projection projection) {

		return matriUserImagePersistence.countWithDynamicQuery(
			dynamicQuery, projection);
	}

	@Override
	public MatriUserImage fetchMatriUserImage(long MatriImageId) {
		return matriUserImagePersistence.fetchByPrimaryKey(MatriImageId);
	}

	/**
	 * Returns the matri user image with the primary key.
	 *
	 * @param MatriImageId the primary key of the matri user image
	 * @return the matri user image
	 * @throws PortalException if a matri user image with the primary key could not be found
	 */
	@Override
	public MatriUserImage getMatriUserImage(long MatriImageId)
		throws PortalException {

		return matriUserImagePersistence.findByPrimaryKey(MatriImageId);
	}

	@Override
	public ActionableDynamicQuery getActionableDynamicQuery() {
		ActionableDynamicQuery actionableDynamicQuery =
			new DefaultActionableDynamicQuery();

		actionableDynamicQuery.setBaseLocalService(matriUserImageLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(MatriUserImage.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("MatriImageId");

		return actionableDynamicQuery;
	}

	@Override
	public IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		IndexableActionableDynamicQuery indexableActionableDynamicQuery =
			new IndexableActionableDynamicQuery();

		indexableActionableDynamicQuery.setBaseLocalService(
			matriUserImageLocalService);
		indexableActionableDynamicQuery.setClassLoader(getClassLoader());
		indexableActionableDynamicQuery.setModelClass(MatriUserImage.class);

		indexableActionableDynamicQuery.setPrimaryKeyPropertyName(
			"MatriImageId");

		return indexableActionableDynamicQuery;
	}

	protected void initActionableDynamicQuery(
		ActionableDynamicQuery actionableDynamicQuery) {

		actionableDynamicQuery.setBaseLocalService(matriUserImageLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(MatriUserImage.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("MatriImageId");
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel createPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return matriUserImagePersistence.create(
			((Long)primaryKeyObj).longValue());
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException {

		if (_log.isWarnEnabled()) {
			_log.warn(
				"Implement MatriUserImageLocalServiceImpl#deleteMatriUserImage(MatriUserImage) to avoid orphaned data");
		}

		return matriUserImageLocalService.deleteMatriUserImage(
			(MatriUserImage)persistedModel);
	}

	@Override
	public BasePersistence<MatriUserImage> getBasePersistence() {
		return matriUserImagePersistence;
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return matriUserImagePersistence.findByPrimaryKey(primaryKeyObj);
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
	public List<MatriUserImage> getMatriUserImages(int start, int end) {
		return matriUserImagePersistence.findAll(start, end);
	}

	/**
	 * Returns the number of matri user images.
	 *
	 * @return the number of matri user images
	 */
	@Override
	public int getMatriUserImagesCount() {
		return matriUserImagePersistence.countAll();
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
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public MatriUserImage updateMatriUserImage(MatriUserImage matriUserImage) {
		return matriUserImagePersistence.update(matriUserImage);
	}

	@Override
	public MatriUserImageImageOneBlobModel getImageOneBlobModel(
		Serializable primaryKey) {

		Session session = null;

		try {
			session = matriUserImagePersistence.openSession();

			return (MatriUserImageImageOneBlobModel)session.get(
				MatriUserImageImageOneBlobModel.class, primaryKey);
		}
		catch (Exception exception) {
			throw matriUserImagePersistence.processException(exception);
		}
		finally {
			matriUserImagePersistence.closeSession(session);
		}
	}

	@Override
	@Transactional(readOnly = true)
	public InputStream openImageOneInputStream(long MatriImageId) {
		try {
			MatriUserImageImageOneBlobModel MatriUserImageImageOneBlobModel =
				getImageOneBlobModel(MatriImageId);

			Blob blob = MatriUserImageImageOneBlobModel.getImageOneBlob();

			if (blob == null) {
				return _EMPTY_INPUT_STREAM;
			}

			InputStream inputStream = blob.getBinaryStream();

			if (_useTempFile) {
				inputStream = new AutoDeleteFileInputStream(
					_file.createTempFile(inputStream));
			}

			return inputStream;
		}
		catch (Exception exception) {
			throw new SystemException(exception);
		}
	}

	@Override
	public MatriUserImageImageTwoBlobModel getImageTwoBlobModel(
		Serializable primaryKey) {

		Session session = null;

		try {
			session = matriUserImagePersistence.openSession();

			return (MatriUserImageImageTwoBlobModel)session.get(
				MatriUserImageImageTwoBlobModel.class, primaryKey);
		}
		catch (Exception exception) {
			throw matriUserImagePersistence.processException(exception);
		}
		finally {
			matriUserImagePersistence.closeSession(session);
		}
	}

	@Override
	@Transactional(readOnly = true)
	public InputStream openImageTwoInputStream(long MatriImageId) {
		try {
			MatriUserImageImageTwoBlobModel MatriUserImageImageTwoBlobModel =
				getImageTwoBlobModel(MatriImageId);

			Blob blob = MatriUserImageImageTwoBlobModel.getImageTwoBlob();

			if (blob == null) {
				return _EMPTY_INPUT_STREAM;
			}

			InputStream inputStream = blob.getBinaryStream();

			if (_useTempFile) {
				inputStream = new AutoDeleteFileInputStream(
					_file.createTempFile(inputStream));
			}

			return inputStream;
		}
		catch (Exception exception) {
			throw new SystemException(exception);
		}
	}

	@Override
	public MatriUserImageImageThreeBlobModel getImageThreeBlobModel(
		Serializable primaryKey) {

		Session session = null;

		try {
			session = matriUserImagePersistence.openSession();

			return (MatriUserImageImageThreeBlobModel)session.get(
				MatriUserImageImageThreeBlobModel.class, primaryKey);
		}
		catch (Exception exception) {
			throw matriUserImagePersistence.processException(exception);
		}
		finally {
			matriUserImagePersistence.closeSession(session);
		}
	}

	@Override
	@Transactional(readOnly = true)
	public InputStream openImageThreeInputStream(long MatriImageId) {
		try {
			MatriUserImageImageThreeBlobModel
				MatriUserImageImageThreeBlobModel = getImageThreeBlobModel(
					MatriImageId);

			Blob blob = MatriUserImageImageThreeBlobModel.getImageThreeBlob();

			if (blob == null) {
				return _EMPTY_INPUT_STREAM;
			}

			InputStream inputStream = blob.getBinaryStream();

			if (_useTempFile) {
				inputStream = new AutoDeleteFileInputStream(
					_file.createTempFile(inputStream));
			}

			return inputStream;
		}
		catch (Exception exception) {
			throw new SystemException(exception);
		}
	}

	@Override
	public MatriUserImageImageFourBlobModel getImageFourBlobModel(
		Serializable primaryKey) {

		Session session = null;

		try {
			session = matriUserImagePersistence.openSession();

			return (MatriUserImageImageFourBlobModel)session.get(
				MatriUserImageImageFourBlobModel.class, primaryKey);
		}
		catch (Exception exception) {
			throw matriUserImagePersistence.processException(exception);
		}
		finally {
			matriUserImagePersistence.closeSession(session);
		}
	}

	@Override
	@Transactional(readOnly = true)
	public InputStream openImageFourInputStream(long MatriImageId) {
		try {
			MatriUserImageImageFourBlobModel MatriUserImageImageFourBlobModel =
				getImageFourBlobModel(MatriImageId);

			Blob blob = MatriUserImageImageFourBlobModel.getImageFourBlob();

			if (blob == null) {
				return _EMPTY_INPUT_STREAM;
			}

			InputStream inputStream = blob.getBinaryStream();

			if (_useTempFile) {
				inputStream = new AutoDeleteFileInputStream(
					_file.createTempFile(inputStream));
			}

			return inputStream;
		}
		catch (Exception exception) {
			throw new SystemException(exception);
		}
	}

	@Activate
	protected void activate() {
		DB db = DBManagerUtil.getDB();

		if ((db.getDBType() != DBType.DB2) &&
			(db.getDBType() != DBType.MYSQL) &&
			(db.getDBType() != DBType.MARIADB) &&
			(db.getDBType() != DBType.SYBASE)) {

			_useTempFile = true;
		}
	}

	@Deactivate
	protected void deactivate() {
		_setLocalServiceUtilService(null);
	}

	@Override
	public Class<?>[] getAopInterfaces() {
		return new Class<?>[] {
			MatriUserImageLocalService.class, IdentifiableOSGiService.class,
			PersistedModelLocalService.class
		};
	}

	@Override
	public void setAopProxy(Object aopProxy) {
		matriUserImageLocalService = (MatriUserImageLocalService)aopProxy;

		_setLocalServiceUtilService(matriUserImageLocalService);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return MatriUserImageLocalService.class.getName();
	}

	protected Class<?> getModelClass() {
		return MatriUserImage.class;
	}

	protected String getModelClassName() {
		return MatriUserImage.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource = matriUserImagePersistence.getDataSource();

			DB db = DBManagerUtil.getDB();

			sql = db.buildSQL(sql);
			sql = PortalUtil.transformSQL(sql);

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(
				dataSource, sql);

			sqlUpdate.update();
		}
		catch (Exception exception) {
			throw new SystemException(exception);
		}
	}

	private void _setLocalServiceUtilService(
		MatriUserImageLocalService matriUserImageLocalService) {

		try {
			Field field = MatriUserImageLocalServiceUtil.class.getDeclaredField(
				"_service");

			field.setAccessible(true);

			field.set(null, matriUserImageLocalService);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	protected MatriUserImageLocalService matriUserImageLocalService;

	@Reference
	protected MatriUserImagePersistence matriUserImagePersistence;

	@Reference
	protected com.liferay.counter.kernel.service.CounterLocalService
		counterLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.ClassNameLocalService
		classNameLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.ResourceLocalService
		resourceLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.UserLocalService
		userLocalService;

	private static final Log _log = LogFactoryUtil.getLog(
		MatriUserImageLocalServiceBaseImpl.class);

	@Reference
	protected File _file;

	private static final InputStream _EMPTY_INPUT_STREAM =
		new UnsyncByteArrayInputStream(new byte[0]);

	private boolean _useTempFile;

}