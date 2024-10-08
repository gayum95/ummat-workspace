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

package ummat.matriExtra.slayer.service.persistence.impl;

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
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUID;

import java.io.Serializable;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

import ummat.matriExtra.slayer.exception.NoSuchMatriUserImageException;
import ummat.matriExtra.slayer.model.MatriUserImage;
import ummat.matriExtra.slayer.model.MatriUserImageTable;
import ummat.matriExtra.slayer.model.impl.MatriUserImageImpl;
import ummat.matriExtra.slayer.model.impl.MatriUserImageModelImpl;
import ummat.matriExtra.slayer.service.persistence.MatriUserImagePersistence;
import ummat.matriExtra.slayer.service.persistence.MatriUserImageUtil;
import ummat.matriExtra.slayer.service.persistence.impl.constants.MatriExtraPersistenceConstants;

/**
 * The persistence implementation for the matri user image service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = MatriUserImagePersistence.class)
public class MatriUserImagePersistenceImpl
	extends BasePersistenceImpl<MatriUserImage>
	implements MatriUserImagePersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>MatriUserImageUtil</code> to access the matri user image persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		MatriUserImageImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByUuid;
	private FinderPath _finderPathWithoutPaginationFindByUuid;
	private FinderPath _finderPathCountByUuid;

	/**
	 * Returns all the matri user images where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching matri user images
	 */
	@Override
	public List<MatriUserImage> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<MatriUserImage> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
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
	@Override
	public List<MatriUserImage> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<MatriUserImage> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
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
	@Override
	public List<MatriUserImage> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<MatriUserImage> orderByComparator,
		boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByUuid;
				finderArgs = new Object[] {uuid};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUuid;
			finderArgs = new Object[] {uuid, start, end, orderByComparator};
		}

		List<MatriUserImage> list = null;

		if (useFinderCache) {
			list = (List<MatriUserImage>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (MatriUserImage matriUserImage : list) {
					if (!uuid.equals(matriUserImage.getUuid())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_MATRIUSERIMAGE_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(MatriUserImageModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				list = (List<MatriUserImage>)QueryUtil.list(
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
	 * Returns the first matri user image in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching matri user image
	 * @throws NoSuchMatriUserImageException if a matching matri user image could not be found
	 */
	@Override
	public MatriUserImage findByUuid_First(
			String uuid, OrderByComparator<MatriUserImage> orderByComparator)
		throws NoSuchMatriUserImageException {

		MatriUserImage matriUserImage = fetchByUuid_First(
			uuid, orderByComparator);

		if (matriUserImage != null) {
			return matriUserImage;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchMatriUserImageException(sb.toString());
	}

	/**
	 * Returns the first matri user image in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching matri user image, or <code>null</code> if a matching matri user image could not be found
	 */
	@Override
	public MatriUserImage fetchByUuid_First(
		String uuid, OrderByComparator<MatriUserImage> orderByComparator) {

		List<MatriUserImage> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last matri user image in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching matri user image
	 * @throws NoSuchMatriUserImageException if a matching matri user image could not be found
	 */
	@Override
	public MatriUserImage findByUuid_Last(
			String uuid, OrderByComparator<MatriUserImage> orderByComparator)
		throws NoSuchMatriUserImageException {

		MatriUserImage matriUserImage = fetchByUuid_Last(
			uuid, orderByComparator);

		if (matriUserImage != null) {
			return matriUserImage;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchMatriUserImageException(sb.toString());
	}

	/**
	 * Returns the last matri user image in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching matri user image, or <code>null</code> if a matching matri user image could not be found
	 */
	@Override
	public MatriUserImage fetchByUuid_Last(
		String uuid, OrderByComparator<MatriUserImage> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<MatriUserImage> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public MatriUserImage[] findByUuid_PrevAndNext(
			long MatriImageId, String uuid,
			OrderByComparator<MatriUserImage> orderByComparator)
		throws NoSuchMatriUserImageException {

		uuid = Objects.toString(uuid, "");

		MatriUserImage matriUserImage = findByPrimaryKey(MatriImageId);

		Session session = null;

		try {
			session = openSession();

			MatriUserImage[] array = new MatriUserImageImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, matriUserImage, uuid, orderByComparator, true);

			array[1] = matriUserImage;

			array[2] = getByUuid_PrevAndNext(
				session, matriUserImage, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected MatriUserImage getByUuid_PrevAndNext(
		Session session, MatriUserImage matriUserImage, String uuid,
		OrderByComparator<MatriUserImage> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_MATRIUSERIMAGE_WHERE);

		boolean bindUuid = false;

		if (uuid.isEmpty()) {
			sb.append(_FINDER_COLUMN_UUID_UUID_3);
		}
		else {
			bindUuid = true;

			sb.append(_FINDER_COLUMN_UUID_UUID_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(MatriUserImageModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindUuid) {
			queryPos.add(uuid);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						matriUserImage)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<MatriUserImage> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the matri user images where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (MatriUserImage matriUserImage :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(matriUserImage);
		}
	}

	/**
	 * Returns the number of matri user images where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching matri user images
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_MATRIUSERIMAGE_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

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

	private static final String _FINDER_COLUMN_UUID_UUID_2 =
		"matriUserImage.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(matriUserImage.uuid IS NULL OR matriUserImage.uuid = '')";

	private FinderPath _finderPathFetchByFindByMatriExtraImages;
	private FinderPath _finderPathCountByFindByMatriExtraImages;

	/**
	 * Returns the matri user image where MatriUserId = &#63; or throws a <code>NoSuchMatriUserImageException</code> if it could not be found.
	 *
	 * @param MatriUserId the matri user ID
	 * @return the matching matri user image
	 * @throws NoSuchMatriUserImageException if a matching matri user image could not be found
	 */
	@Override
	public MatriUserImage findByFindByMatriExtraImages(long MatriUserId)
		throws NoSuchMatriUserImageException {

		MatriUserImage matriUserImage = fetchByFindByMatriExtraImages(
			MatriUserId);

		if (matriUserImage == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("MatriUserId=");
			sb.append(MatriUserId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchMatriUserImageException(sb.toString());
		}

		return matriUserImage;
	}

	/**
	 * Returns the matri user image where MatriUserId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param MatriUserId the matri user ID
	 * @return the matching matri user image, or <code>null</code> if a matching matri user image could not be found
	 */
	@Override
	public MatriUserImage fetchByFindByMatriExtraImages(long MatriUserId) {
		return fetchByFindByMatriExtraImages(MatriUserId, true);
	}

	/**
	 * Returns the matri user image where MatriUserId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param MatriUserId the matri user ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching matri user image, or <code>null</code> if a matching matri user image could not be found
	 */
	@Override
	public MatriUserImage fetchByFindByMatriExtraImages(
		long MatriUserId, boolean useFinderCache) {

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {MatriUserId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByFindByMatriExtraImages, finderArgs, this);
		}

		if (result instanceof MatriUserImage) {
			MatriUserImage matriUserImage = (MatriUserImage)result;

			if (MatriUserId != matriUserImage.getMatriUserId()) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_MATRIUSERIMAGE_WHERE);

			sb.append(_FINDER_COLUMN_FINDBYMATRIEXTRAIMAGES_MATRIUSERID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(MatriUserId);

				List<MatriUserImage> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByFindByMatriExtraImages,
							finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {MatriUserId};
							}

							_log.warn(
								"MatriUserImagePersistenceImpl.fetchByFindByMatriExtraImages(long, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					MatriUserImage matriUserImage = list.get(0);

					result = matriUserImage;

					cacheResult(matriUserImage);
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
			return (MatriUserImage)result;
		}
	}

	/**
	 * Removes the matri user image where MatriUserId = &#63; from the database.
	 *
	 * @param MatriUserId the matri user ID
	 * @return the matri user image that was removed
	 */
	@Override
	public MatriUserImage removeByFindByMatriExtraImages(long MatriUserId)
		throws NoSuchMatriUserImageException {

		MatriUserImage matriUserImage = findByFindByMatriExtraImages(
			MatriUserId);

		return remove(matriUserImage);
	}

	/**
	 * Returns the number of matri user images where MatriUserId = &#63;.
	 *
	 * @param MatriUserId the matri user ID
	 * @return the number of matching matri user images
	 */
	@Override
	public int countByFindByMatriExtraImages(long MatriUserId) {
		FinderPath finderPath = _finderPathCountByFindByMatriExtraImages;

		Object[] finderArgs = new Object[] {MatriUserId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_MATRIUSERIMAGE_WHERE);

			sb.append(_FINDER_COLUMN_FINDBYMATRIEXTRAIMAGES_MATRIUSERID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(MatriUserId);

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

	private static final String
		_FINDER_COLUMN_FINDBYMATRIEXTRAIMAGES_MATRIUSERID_2 =
			"matriUserImage.MatriUserId = ?";

	private FinderPath _finderPathFetchByFindByMatriExtraImagesUserId;
	private FinderPath _finderPathCountByFindByMatriExtraImagesUserId;

	/**
	 * Returns the matri user image where userId = &#63; or throws a <code>NoSuchMatriUserImageException</code> if it could not be found.
	 *
	 * @param userId the user ID
	 * @return the matching matri user image
	 * @throws NoSuchMatriUserImageException if a matching matri user image could not be found
	 */
	@Override
	public MatriUserImage findByFindByMatriExtraImagesUserId(long userId)
		throws NoSuchMatriUserImageException {

		MatriUserImage matriUserImage = fetchByFindByMatriExtraImagesUserId(
			userId);

		if (matriUserImage == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("userId=");
			sb.append(userId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchMatriUserImageException(sb.toString());
		}

		return matriUserImage;
	}

	/**
	 * Returns the matri user image where userId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param userId the user ID
	 * @return the matching matri user image, or <code>null</code> if a matching matri user image could not be found
	 */
	@Override
	public MatriUserImage fetchByFindByMatriExtraImagesUserId(long userId) {
		return fetchByFindByMatriExtraImagesUserId(userId, true);
	}

	/**
	 * Returns the matri user image where userId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param userId the user ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching matri user image, or <code>null</code> if a matching matri user image could not be found
	 */
	@Override
	public MatriUserImage fetchByFindByMatriExtraImagesUserId(
		long userId, boolean useFinderCache) {

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {userId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByFindByMatriExtraImagesUserId, finderArgs,
				this);
		}

		if (result instanceof MatriUserImage) {
			MatriUserImage matriUserImage = (MatriUserImage)result;

			if (userId != matriUserImage.getUserId()) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_MATRIUSERIMAGE_WHERE);

			sb.append(_FINDER_COLUMN_FINDBYMATRIEXTRAIMAGESUSERID_USERID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(userId);

				List<MatriUserImage> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByFindByMatriExtraImagesUserId,
							finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {userId};
							}

							_log.warn(
								"MatriUserImagePersistenceImpl.fetchByFindByMatriExtraImagesUserId(long, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					MatriUserImage matriUserImage = list.get(0);

					result = matriUserImage;

					cacheResult(matriUserImage);
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
			return (MatriUserImage)result;
		}
	}

	/**
	 * Removes the matri user image where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @return the matri user image that was removed
	 */
	@Override
	public MatriUserImage removeByFindByMatriExtraImagesUserId(long userId)
		throws NoSuchMatriUserImageException {

		MatriUserImage matriUserImage = findByFindByMatriExtraImagesUserId(
			userId);

		return remove(matriUserImage);
	}

	/**
	 * Returns the number of matri user images where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching matri user images
	 */
	@Override
	public int countByFindByMatriExtraImagesUserId(long userId) {
		FinderPath finderPath = _finderPathCountByFindByMatriExtraImagesUserId;

		Object[] finderArgs = new Object[] {userId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_MATRIUSERIMAGE_WHERE);

			sb.append(_FINDER_COLUMN_FINDBYMATRIEXTRAIMAGESUSERID_USERID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(userId);

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

	private static final String
		_FINDER_COLUMN_FINDBYMATRIEXTRAIMAGESUSERID_USERID_2 =
			"matriUserImage.userId = ?";

	public MatriUserImagePersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(MatriUserImage.class);

		setModelImplClass(MatriUserImageImpl.class);
		setModelPKClass(long.class);

		setTable(MatriUserImageTable.INSTANCE);
	}

	/**
	 * Caches the matri user image in the entity cache if it is enabled.
	 *
	 * @param matriUserImage the matri user image
	 */
	@Override
	public void cacheResult(MatriUserImage matriUserImage) {
		entityCache.putResult(
			MatriUserImageImpl.class, matriUserImage.getPrimaryKey(),
			matriUserImage);

		finderCache.putResult(
			_finderPathFetchByFindByMatriExtraImages,
			new Object[] {matriUserImage.getMatriUserId()}, matriUserImage);

		finderCache.putResult(
			_finderPathFetchByFindByMatriExtraImagesUserId,
			new Object[] {matriUserImage.getUserId()}, matriUserImage);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the matri user images in the entity cache if it is enabled.
	 *
	 * @param matriUserImages the matri user images
	 */
	@Override
	public void cacheResult(List<MatriUserImage> matriUserImages) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (matriUserImages.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (MatriUserImage matriUserImage : matriUserImages) {
			if (entityCache.getResult(
					MatriUserImageImpl.class, matriUserImage.getPrimaryKey()) ==
						null) {

				cacheResult(matriUserImage);
			}
		}
	}

	/**
	 * Clears the cache for all matri user images.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(MatriUserImageImpl.class);

		finderCache.clearCache(MatriUserImageImpl.class);
	}

	/**
	 * Clears the cache for the matri user image.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(MatriUserImage matriUserImage) {
		entityCache.removeResult(MatriUserImageImpl.class, matriUserImage);
	}

	@Override
	public void clearCache(List<MatriUserImage> matriUserImages) {
		for (MatriUserImage matriUserImage : matriUserImages) {
			entityCache.removeResult(MatriUserImageImpl.class, matriUserImage);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(MatriUserImageImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(MatriUserImageImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		MatriUserImageModelImpl matriUserImageModelImpl) {

		Object[] args = new Object[] {matriUserImageModelImpl.getMatriUserId()};

		finderCache.putResult(
			_finderPathCountByFindByMatriExtraImages, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByFindByMatriExtraImages, args,
			matriUserImageModelImpl);

		args = new Object[] {matriUserImageModelImpl.getUserId()};

		finderCache.putResult(
			_finderPathCountByFindByMatriExtraImagesUserId, args,
			Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByFindByMatriExtraImagesUserId, args,
			matriUserImageModelImpl);
	}

	/**
	 * Creates a new matri user image with the primary key. Does not add the matri user image to the database.
	 *
	 * @param MatriImageId the primary key for the new matri user image
	 * @return the new matri user image
	 */
	@Override
	public MatriUserImage create(long MatriImageId) {
		MatriUserImage matriUserImage = new MatriUserImageImpl();

		matriUserImage.setNew(true);
		matriUserImage.setPrimaryKey(MatriImageId);

		String uuid = _portalUUID.generate();

		matriUserImage.setUuid(uuid);

		return matriUserImage;
	}

	/**
	 * Removes the matri user image with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param MatriImageId the primary key of the matri user image
	 * @return the matri user image that was removed
	 * @throws NoSuchMatriUserImageException if a matri user image with the primary key could not be found
	 */
	@Override
	public MatriUserImage remove(long MatriImageId)
		throws NoSuchMatriUserImageException {

		return remove((Serializable)MatriImageId);
	}

	/**
	 * Removes the matri user image with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the matri user image
	 * @return the matri user image that was removed
	 * @throws NoSuchMatriUserImageException if a matri user image with the primary key could not be found
	 */
	@Override
	public MatriUserImage remove(Serializable primaryKey)
		throws NoSuchMatriUserImageException {

		Session session = null;

		try {
			session = openSession();

			MatriUserImage matriUserImage = (MatriUserImage)session.get(
				MatriUserImageImpl.class, primaryKey);

			if (matriUserImage == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchMatriUserImageException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(matriUserImage);
		}
		catch (NoSuchMatriUserImageException noSuchEntityException) {
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
	protected MatriUserImage removeImpl(MatriUserImage matriUserImage) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(matriUserImage)) {
				matriUserImage = (MatriUserImage)session.get(
					MatriUserImageImpl.class,
					matriUserImage.getPrimaryKeyObj());
			}

			if (matriUserImage != null) {
				session.delete(matriUserImage);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (matriUserImage != null) {
			clearCache(matriUserImage);
		}

		return matriUserImage;
	}

	@Override
	public MatriUserImage updateImpl(MatriUserImage matriUserImage) {
		boolean isNew = matriUserImage.isNew();

		if (!(matriUserImage instanceof MatriUserImageModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(matriUserImage.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					matriUserImage);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in matriUserImage proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom MatriUserImage implementation " +
					matriUserImage.getClass());
		}

		MatriUserImageModelImpl matriUserImageModelImpl =
			(MatriUserImageModelImpl)matriUserImage;

		if (Validator.isNull(matriUserImage.getUuid())) {
			String uuid = _portalUUID.generate();

			matriUserImage.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(matriUserImage);
			}
			else {
				session.evict(
					MatriUserImageImpl.class,
					matriUserImage.getPrimaryKeyObj());

				session.saveOrUpdate(matriUserImage);
			}

			session.flush();
			session.clear();
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			MatriUserImageImpl.class, matriUserImageModelImpl, false, true);

		cacheUniqueFindersCache(matriUserImageModelImpl);

		if (isNew) {
			matriUserImage.setNew(false);
		}

		matriUserImage.resetOriginalValues();

		return matriUserImage;
	}

	/**
	 * Returns the matri user image with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the matri user image
	 * @return the matri user image
	 * @throws NoSuchMatriUserImageException if a matri user image with the primary key could not be found
	 */
	@Override
	public MatriUserImage findByPrimaryKey(Serializable primaryKey)
		throws NoSuchMatriUserImageException {

		MatriUserImage matriUserImage = fetchByPrimaryKey(primaryKey);

		if (matriUserImage == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchMatriUserImageException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return matriUserImage;
	}

	/**
	 * Returns the matri user image with the primary key or throws a <code>NoSuchMatriUserImageException</code> if it could not be found.
	 *
	 * @param MatriImageId the primary key of the matri user image
	 * @return the matri user image
	 * @throws NoSuchMatriUserImageException if a matri user image with the primary key could not be found
	 */
	@Override
	public MatriUserImage findByPrimaryKey(long MatriImageId)
		throws NoSuchMatriUserImageException {

		return findByPrimaryKey((Serializable)MatriImageId);
	}

	/**
	 * Returns the matri user image with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param MatriImageId the primary key of the matri user image
	 * @return the matri user image, or <code>null</code> if a matri user image with the primary key could not be found
	 */
	@Override
	public MatriUserImage fetchByPrimaryKey(long MatriImageId) {
		return fetchByPrimaryKey((Serializable)MatriImageId);
	}

	/**
	 * Returns all the matri user images.
	 *
	 * @return the matri user images
	 */
	@Override
	public List<MatriUserImage> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<MatriUserImage> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<MatriUserImage> findAll(
		int start, int end,
		OrderByComparator<MatriUserImage> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<MatriUserImage> findAll(
		int start, int end, OrderByComparator<MatriUserImage> orderByComparator,
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

		List<MatriUserImage> list = null;

		if (useFinderCache) {
			list = (List<MatriUserImage>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_MATRIUSERIMAGE);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_MATRIUSERIMAGE;

				sql = sql.concat(MatriUserImageModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<MatriUserImage>)QueryUtil.list(
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
	 * Removes all the matri user images from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (MatriUserImage matriUserImage : findAll()) {
			remove(matriUserImage);
		}
	}

	/**
	 * Returns the number of matri user images.
	 *
	 * @return the number of matri user images
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_MATRIUSERIMAGE);

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
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "MatriImageId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_MATRIUSERIMAGE;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return MatriUserImageModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the matri user image persistence.
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

		_finderPathWithPaginationFindByUuid = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"uuid_"}, true);

		_finderPathWithoutPaginationFindByUuid = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] {String.class.getName()}, new String[] {"uuid_"},
			true);

		_finderPathCountByUuid = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] {String.class.getName()}, new String[] {"uuid_"},
			false);

		_finderPathFetchByFindByMatriExtraImages = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByFindByMatriExtraImages",
			new String[] {Long.class.getName()}, new String[] {"MatriUserId"},
			true);

		_finderPathCountByFindByMatriExtraImages = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByFindByMatriExtraImages",
			new String[] {Long.class.getName()}, new String[] {"MatriUserId"},
			false);

		_finderPathFetchByFindByMatriExtraImagesUserId = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByFindByMatriExtraImagesUserId",
			new String[] {Long.class.getName()}, new String[] {"userId"}, true);

		_finderPathCountByFindByMatriExtraImagesUserId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByFindByMatriExtraImagesUserId",
			new String[] {Long.class.getName()}, new String[] {"userId"},
			false);

		_setMatriUserImageUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setMatriUserImageUtilPersistence(null);

		entityCache.removeCache(MatriUserImageImpl.class.getName());
	}

	private void _setMatriUserImageUtilPersistence(
		MatriUserImagePersistence matriUserImagePersistence) {

		try {
			Field field = MatriUserImageUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, matriUserImagePersistence);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	@Override
	@Reference(
		target = MatriExtraPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = MatriExtraPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = MatriExtraPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_MATRIUSERIMAGE =
		"SELECT matriUserImage FROM MatriUserImage matriUserImage";

	private static final String _SQL_SELECT_MATRIUSERIMAGE_WHERE =
		"SELECT matriUserImage FROM MatriUserImage matriUserImage WHERE ";

	private static final String _SQL_COUNT_MATRIUSERIMAGE =
		"SELECT COUNT(matriUserImage) FROM MatriUserImage matriUserImage";

	private static final String _SQL_COUNT_MATRIUSERIMAGE_WHERE =
		"SELECT COUNT(matriUserImage) FROM MatriUserImage matriUserImage WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "matriUserImage.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No MatriUserImage exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No MatriUserImage exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		MatriUserImagePersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private PortalUUID _portalUUID;

}