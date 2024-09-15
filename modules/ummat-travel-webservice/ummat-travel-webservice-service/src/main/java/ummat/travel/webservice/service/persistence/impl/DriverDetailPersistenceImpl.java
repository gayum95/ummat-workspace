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

package ummat.travel.webservice.service.persistence.impl;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.auth.CompanyThreadLocal;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringUtil;

import java.io.Serializable;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

import ummat.travel.webservice.exception.NoSuchDriverDetailException;
import ummat.travel.webservice.model.DriverDetail;
import ummat.travel.webservice.model.DriverDetailTable;
import ummat.travel.webservice.model.impl.DriverDetailImpl;
import ummat.travel.webservice.model.impl.DriverDetailModelImpl;
import ummat.travel.webservice.service.persistence.DriverDetailPersistence;
import ummat.travel.webservice.service.persistence.DriverDetailUtil;
import ummat.travel.webservice.service.persistence.impl.constants.UMMATLifePersistenceConstants;

/**
 * The persistence implementation for the driver detail service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = DriverDetailPersistence.class)
public class DriverDetailPersistenceImpl
	extends BasePersistenceImpl<DriverDetail>
	implements DriverDetailPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>DriverDetailUtil</code> to access the driver detail persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		DriverDetailImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathFetchByfindByDriverId;
	private FinderPath _finderPathCountByfindByDriverId;

	/**
	 * Returns the driver detail where driverId = &#63; or throws a <code>NoSuchDriverDetailException</code> if it could not be found.
	 *
	 * @param driverId the driver ID
	 * @return the matching driver detail
	 * @throws NoSuchDriverDetailException if a matching driver detail could not be found
	 */
	@Override
	public DriverDetail findByfindByDriverId(long driverId)
		throws NoSuchDriverDetailException {

		DriverDetail driverDetail = fetchByfindByDriverId(driverId);

		if (driverDetail == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("driverId=");
			sb.append(driverId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchDriverDetailException(sb.toString());
		}

		return driverDetail;
	}

	/**
	 * Returns the driver detail where driverId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param driverId the driver ID
	 * @return the matching driver detail, or <code>null</code> if a matching driver detail could not be found
	 */
	@Override
	public DriverDetail fetchByfindByDriverId(long driverId) {
		return fetchByfindByDriverId(driverId, true);
	}

	/**
	 * Returns the driver detail where driverId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param driverId the driver ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching driver detail, or <code>null</code> if a matching driver detail could not be found
	 */
	@Override
	public DriverDetail fetchByfindByDriverId(
		long driverId, boolean useFinderCache) {

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {driverId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByfindByDriverId, finderArgs, this);
		}

		if (result instanceof DriverDetail) {
			DriverDetail driverDetail = (DriverDetail)result;

			if (driverId != driverDetail.getDriverId()) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_DRIVERDETAIL_WHERE);

			sb.append(_FINDER_COLUMN_FINDBYDRIVERID_DRIVERID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(driverId);

				List<DriverDetail> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByfindByDriverId, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {driverId};
							}

							_log.warn(
								"DriverDetailPersistenceImpl.fetchByfindByDriverId(long, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					DriverDetail driverDetail = list.get(0);

					result = driverDetail;

					cacheResult(driverDetail);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (DriverDetail)result;
		}
	}

	/**
	 * Removes the driver detail where driverId = &#63; from the database.
	 *
	 * @param driverId the driver ID
	 * @return the driver detail that was removed
	 */
	@Override
	public DriverDetail removeByfindByDriverId(long driverId)
		throws NoSuchDriverDetailException {

		DriverDetail driverDetail = findByfindByDriverId(driverId);

		return remove(driverDetail);
	}

	/**
	 * Returns the number of driver details where driverId = &#63;.
	 *
	 * @param driverId the driver ID
	 * @return the number of matching driver details
	 */
	@Override
	public int countByfindByDriverId(long driverId) {
		FinderPath finderPath = _finderPathCountByfindByDriverId;

		Object[] finderArgs = new Object[] {driverId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_DRIVERDETAIL_WHERE);

			sb.append(_FINDER_COLUMN_FINDBYDRIVERID_DRIVERID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(driverId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_FINDBYDRIVERID_DRIVERID_2 =
		"driverDetail.driverId = ?";

	private FinderPath _finderPathFetchByFind_DriverDetail;
	private FinderPath _finderPathCountByFind_DriverDetail;

	/**
	 * Returns the driver detail where userId = &#63; and companyId = &#63; or throws a <code>NoSuchDriverDetailException</code> if it could not be found.
	 *
	 * @param userId the user ID
	 * @param companyId the company ID
	 * @return the matching driver detail
	 * @throws NoSuchDriverDetailException if a matching driver detail could not be found
	 */
	@Override
	public DriverDetail findByFind_DriverDetail(long userId, long companyId)
		throws NoSuchDriverDetailException {

		DriverDetail driverDetail = fetchByFind_DriverDetail(userId, companyId);

		if (driverDetail == null) {
			StringBundler sb = new StringBundler(6);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("userId=");
			sb.append(userId);

			sb.append(", companyId=");
			sb.append(companyId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchDriverDetailException(sb.toString());
		}

		return driverDetail;
	}

	/**
	 * Returns the driver detail where userId = &#63; and companyId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param userId the user ID
	 * @param companyId the company ID
	 * @return the matching driver detail, or <code>null</code> if a matching driver detail could not be found
	 */
	@Override
	public DriverDetail fetchByFind_DriverDetail(long userId, long companyId) {
		return fetchByFind_DriverDetail(userId, companyId, true);
	}

	/**
	 * Returns the driver detail where userId = &#63; and companyId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param userId the user ID
	 * @param companyId the company ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching driver detail, or <code>null</code> if a matching driver detail could not be found
	 */
	@Override
	public DriverDetail fetchByFind_DriverDetail(
		long userId, long companyId, boolean useFinderCache) {

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {userId, companyId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByFind_DriverDetail, finderArgs, this);
		}

		if (result instanceof DriverDetail) {
			DriverDetail driverDetail = (DriverDetail)result;

			if ((userId != driverDetail.getUserId()) ||
				(companyId != driverDetail.getCompanyId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_DRIVERDETAIL_WHERE);

			sb.append(_FINDER_COLUMN_FIND_DRIVERDETAIL_USERID_2);

			sb.append(_FINDER_COLUMN_FIND_DRIVERDETAIL_COMPANYID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(userId);

				queryPos.add(companyId);

				List<DriverDetail> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByFind_DriverDetail, finderArgs,
							list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {userId, companyId};
							}

							_log.warn(
								"DriverDetailPersistenceImpl.fetchByFind_DriverDetail(long, long, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					DriverDetail driverDetail = list.get(0);

					result = driverDetail;

					cacheResult(driverDetail);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (DriverDetail)result;
		}
	}

	/**
	 * Removes the driver detail where userId = &#63; and companyId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param companyId the company ID
	 * @return the driver detail that was removed
	 */
	@Override
	public DriverDetail removeByFind_DriverDetail(long userId, long companyId)
		throws NoSuchDriverDetailException {

		DriverDetail driverDetail = findByFind_DriverDetail(userId, companyId);

		return remove(driverDetail);
	}

	/**
	 * Returns the number of driver details where userId = &#63; and companyId = &#63;.
	 *
	 * @param userId the user ID
	 * @param companyId the company ID
	 * @return the number of matching driver details
	 */
	@Override
	public int countByFind_DriverDetail(long userId, long companyId) {
		FinderPath finderPath = _finderPathCountByFind_DriverDetail;

		Object[] finderArgs = new Object[] {userId, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_DRIVERDETAIL_WHERE);

			sb.append(_FINDER_COLUMN_FIND_DRIVERDETAIL_USERID_2);

			sb.append(_FINDER_COLUMN_FIND_DRIVERDETAIL_COMPANYID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(userId);

				queryPos.add(companyId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_FIND_DRIVERDETAIL_USERID_2 =
		"driverDetail.userId = ? AND ";

	private static final String _FINDER_COLUMN_FIND_DRIVERDETAIL_COMPANYID_2 =
		"driverDetail.companyId = ?";

	public DriverDetailPersistenceImpl() {
		setModelClass(DriverDetail.class);

		setModelImplClass(DriverDetailImpl.class);
		setModelPKClass(long.class);

		setTable(DriverDetailTable.INSTANCE);
	}

	/**
	 * Caches the driver detail in the entity cache if it is enabled.
	 *
	 * @param driverDetail the driver detail
	 */
	@Override
	public void cacheResult(DriverDetail driverDetail) {
		entityCache.putResult(
			DriverDetailImpl.class, driverDetail.getPrimaryKey(), driverDetail);

		finderCache.putResult(
			_finderPathFetchByfindByDriverId,
			new Object[] {driverDetail.getDriverId()}, driverDetail);

		finderCache.putResult(
			_finderPathFetchByFind_DriverDetail,
			new Object[] {
				driverDetail.getUserId(), driverDetail.getCompanyId()
			},
			driverDetail);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the driver details in the entity cache if it is enabled.
	 *
	 * @param driverDetails the driver details
	 */
	@Override
	public void cacheResult(List<DriverDetail> driverDetails) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (driverDetails.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (DriverDetail driverDetail : driverDetails) {
			if (entityCache.getResult(
					DriverDetailImpl.class, driverDetail.getPrimaryKey()) ==
						null) {

				cacheResult(driverDetail);
			}
		}
	}

	/**
	 * Clears the cache for all driver details.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(DriverDetailImpl.class);

		finderCache.clearCache(DriverDetailImpl.class);
	}

	/**
	 * Clears the cache for the driver detail.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(DriverDetail driverDetail) {
		entityCache.removeResult(DriverDetailImpl.class, driverDetail);
	}

	@Override
	public void clearCache(List<DriverDetail> driverDetails) {
		for (DriverDetail driverDetail : driverDetails) {
			entityCache.removeResult(DriverDetailImpl.class, driverDetail);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(DriverDetailImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(DriverDetailImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		DriverDetailModelImpl driverDetailModelImpl) {

		Object[] args = new Object[] {driverDetailModelImpl.getDriverId()};

		finderCache.putResult(
			_finderPathCountByfindByDriverId, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByfindByDriverId, args, driverDetailModelImpl);

		args = new Object[] {
			driverDetailModelImpl.getUserId(),
			driverDetailModelImpl.getCompanyId()
		};

		finderCache.putResult(
			_finderPathCountByFind_DriverDetail, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByFind_DriverDetail, args, driverDetailModelImpl);
	}

	/**
	 * Creates a new driver detail with the primary key. Does not add the driver detail to the database.
	 *
	 * @param driverId the primary key for the new driver detail
	 * @return the new driver detail
	 */
	@Override
	public DriverDetail create(long driverId) {
		DriverDetail driverDetail = new DriverDetailImpl();

		driverDetail.setNew(true);
		driverDetail.setPrimaryKey(driverId);

		driverDetail.setCompanyId(CompanyThreadLocal.getCompanyId());

		return driverDetail;
	}

	/**
	 * Removes the driver detail with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param driverId the primary key of the driver detail
	 * @return the driver detail that was removed
	 * @throws NoSuchDriverDetailException if a driver detail with the primary key could not be found
	 */
	@Override
	public DriverDetail remove(long driverId)
		throws NoSuchDriverDetailException {

		return remove((Serializable)driverId);
	}

	/**
	 * Removes the driver detail with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the driver detail
	 * @return the driver detail that was removed
	 * @throws NoSuchDriverDetailException if a driver detail with the primary key could not be found
	 */
	@Override
	public DriverDetail remove(Serializable primaryKey)
		throws NoSuchDriverDetailException {

		Session session = null;

		try {
			session = openSession();

			DriverDetail driverDetail = (DriverDetail)session.get(
				DriverDetailImpl.class, primaryKey);

			if (driverDetail == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchDriverDetailException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(driverDetail);
		}
		catch (NoSuchDriverDetailException noSuchEntityException) {
			throw noSuchEntityException;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected DriverDetail removeImpl(DriverDetail driverDetail) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(driverDetail)) {
				driverDetail = (DriverDetail)session.get(
					DriverDetailImpl.class, driverDetail.getPrimaryKeyObj());
			}

			if (driverDetail != null) {
				session.delete(driverDetail);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (driverDetail != null) {
			clearCache(driverDetail);
		}

		return driverDetail;
	}

	@Override
	public DriverDetail updateImpl(DriverDetail driverDetail) {
		boolean isNew = driverDetail.isNew();

		if (!(driverDetail instanceof DriverDetailModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(driverDetail.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					driverDetail);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in driverDetail proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom DriverDetail implementation " +
					driverDetail.getClass());
		}

		DriverDetailModelImpl driverDetailModelImpl =
			(DriverDetailModelImpl)driverDetail;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (driverDetail.getCreateDate() == null)) {
			if (serviceContext == null) {
				driverDetail.setCreateDate(date);
			}
			else {
				driverDetail.setCreateDate(serviceContext.getCreateDate(date));
			}
		}

		if (!driverDetailModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				driverDetail.setModifiedDate(date);
			}
			else {
				driverDetail.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(driverDetail);
			}
			else {
				driverDetail = (DriverDetail)session.merge(driverDetail);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			DriverDetailImpl.class, driverDetailModelImpl, false, true);

		cacheUniqueFindersCache(driverDetailModelImpl);

		if (isNew) {
			driverDetail.setNew(false);
		}

		driverDetail.resetOriginalValues();

		return driverDetail;
	}

	/**
	 * Returns the driver detail with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the driver detail
	 * @return the driver detail
	 * @throws NoSuchDriverDetailException if a driver detail with the primary key could not be found
	 */
	@Override
	public DriverDetail findByPrimaryKey(Serializable primaryKey)
		throws NoSuchDriverDetailException {

		DriverDetail driverDetail = fetchByPrimaryKey(primaryKey);

		if (driverDetail == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchDriverDetailException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return driverDetail;
	}

	/**
	 * Returns the driver detail with the primary key or throws a <code>NoSuchDriverDetailException</code> if it could not be found.
	 *
	 * @param driverId the primary key of the driver detail
	 * @return the driver detail
	 * @throws NoSuchDriverDetailException if a driver detail with the primary key could not be found
	 */
	@Override
	public DriverDetail findByPrimaryKey(long driverId)
		throws NoSuchDriverDetailException {

		return findByPrimaryKey((Serializable)driverId);
	}

	/**
	 * Returns the driver detail with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param driverId the primary key of the driver detail
	 * @return the driver detail, or <code>null</code> if a driver detail with the primary key could not be found
	 */
	@Override
	public DriverDetail fetchByPrimaryKey(long driverId) {
		return fetchByPrimaryKey((Serializable)driverId);
	}

	/**
	 * Returns all the driver details.
	 *
	 * @return the driver details
	 */
	@Override
	public List<DriverDetail> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<DriverDetail> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<DriverDetail> findAll(
		int start, int end, OrderByComparator<DriverDetail> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<DriverDetail> findAll(
		int start, int end, OrderByComparator<DriverDetail> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindAll;
				finderArgs = FINDER_ARGS_EMPTY;
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<DriverDetail> list = null;

		if (useFinderCache) {
			list = (List<DriverDetail>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_DRIVERDETAIL);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_DRIVERDETAIL;

				sql = sql.concat(DriverDetailModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<DriverDetail>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the driver details from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (DriverDetail driverDetail : findAll()) {
			remove(driverDetail);
		}
	}

	/**
	 * Returns the number of driver details.
	 *
	 * @return the number of driver details
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_DRIVERDETAIL);

				count = (Long)query.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "driverId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_DRIVERDETAIL;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return DriverDetailModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the driver detail persistence.
	 */
	@Activate
	public void activate() {
		_valueObjectFinderCacheListThreshold = GetterUtil.getInteger(
			PropsUtil.get(PropsKeys.VALUE_OBJECT_FINDER_CACHE_LIST_THRESHOLD));

		_finderPathWithPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathCountAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0], new String[0], false);

		_finderPathFetchByfindByDriverId = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByfindByDriverId",
			new String[] {Long.class.getName()}, new String[] {"driverId"},
			true);

		_finderPathCountByfindByDriverId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByfindByDriverId",
			new String[] {Long.class.getName()}, new String[] {"driverId"},
			false);

		_finderPathFetchByFind_DriverDetail = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByFind_DriverDetail",
			new String[] {Long.class.getName(), Long.class.getName()},
			new String[] {"userId", "companyId"}, true);

		_finderPathCountByFind_DriverDetail = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByFind_DriverDetail",
			new String[] {Long.class.getName(), Long.class.getName()},
			new String[] {"userId", "companyId"}, false);

		_setDriverDetailUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setDriverDetailUtilPersistence(null);

		entityCache.removeCache(DriverDetailImpl.class.getName());
	}

	private void _setDriverDetailUtilPersistence(
		DriverDetailPersistence driverDetailPersistence) {

		try {
			Field field = DriverDetailUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, driverDetailPersistence);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	@Override
	@Reference(
		target = UMMATLifePersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = UMMATLifePersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = UMMATLifePersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_DRIVERDETAIL =
		"SELECT driverDetail FROM DriverDetail driverDetail";

	private static final String _SQL_SELECT_DRIVERDETAIL_WHERE =
		"SELECT driverDetail FROM DriverDetail driverDetail WHERE ";

	private static final String _SQL_COUNT_DRIVERDETAIL =
		"SELECT COUNT(driverDetail) FROM DriverDetail driverDetail";

	private static final String _SQL_COUNT_DRIVERDETAIL_WHERE =
		"SELECT COUNT(driverDetail) FROM DriverDetail driverDetail WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "driverDetail.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No DriverDetail exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No DriverDetail exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		DriverDetailPersistenceImpl.class);

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}