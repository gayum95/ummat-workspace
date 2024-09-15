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
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUID;

import java.io.Serializable;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;

import java.util.Date;
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

import ummat.travel.webservice.exception.NoSuchTravelUserException;
import ummat.travel.webservice.model.TravelUser;
import ummat.travel.webservice.model.TravelUserTable;
import ummat.travel.webservice.model.impl.TravelUserImpl;
import ummat.travel.webservice.model.impl.TravelUserModelImpl;
import ummat.travel.webservice.service.persistence.TravelUserPersistence;
import ummat.travel.webservice.service.persistence.TravelUserUtil;
import ummat.travel.webservice.service.persistence.impl.constants.UMMATLifePersistenceConstants;

/**
 * The persistence implementation for the travel user service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = TravelUserPersistence.class)
public class TravelUserPersistenceImpl
	extends BasePersistenceImpl<TravelUser> implements TravelUserPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>TravelUserUtil</code> to access the travel user persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		TravelUserImpl.class.getName();

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
	 * Returns all the travel users where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching travel users
	 */
	@Override
	public List<TravelUser> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<TravelUser> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
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
	@Override
	public List<TravelUser> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<TravelUser> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
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
	@Override
	public List<TravelUser> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<TravelUser> orderByComparator,
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

		List<TravelUser> list = null;

		if (useFinderCache) {
			list = (List<TravelUser>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (TravelUser travelUser : list) {
					if (!uuid.equals(travelUser.getUuid())) {
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

			sb.append(_SQL_SELECT_TRAVELUSER_WHERE);

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
				sb.append(TravelUserModelImpl.ORDER_BY_JPQL);
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

				list = (List<TravelUser>)QueryUtil.list(
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
	 * Returns the first travel user in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching travel user
	 * @throws NoSuchTravelUserException if a matching travel user could not be found
	 */
	@Override
	public TravelUser findByUuid_First(
			String uuid, OrderByComparator<TravelUser> orderByComparator)
		throws NoSuchTravelUserException {

		TravelUser travelUser = fetchByUuid_First(uuid, orderByComparator);

		if (travelUser != null) {
			return travelUser;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchTravelUserException(sb.toString());
	}

	/**
	 * Returns the first travel user in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching travel user, or <code>null</code> if a matching travel user could not be found
	 */
	@Override
	public TravelUser fetchByUuid_First(
		String uuid, OrderByComparator<TravelUser> orderByComparator) {

		List<TravelUser> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last travel user in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching travel user
	 * @throws NoSuchTravelUserException if a matching travel user could not be found
	 */
	@Override
	public TravelUser findByUuid_Last(
			String uuid, OrderByComparator<TravelUser> orderByComparator)
		throws NoSuchTravelUserException {

		TravelUser travelUser = fetchByUuid_Last(uuid, orderByComparator);

		if (travelUser != null) {
			return travelUser;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchTravelUserException(sb.toString());
	}

	/**
	 * Returns the last travel user in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching travel user, or <code>null</code> if a matching travel user could not be found
	 */
	@Override
	public TravelUser fetchByUuid_Last(
		String uuid, OrderByComparator<TravelUser> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<TravelUser> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public TravelUser[] findByUuid_PrevAndNext(
			long travelUserId, String uuid,
			OrderByComparator<TravelUser> orderByComparator)
		throws NoSuchTravelUserException {

		uuid = Objects.toString(uuid, "");

		TravelUser travelUser = findByPrimaryKey(travelUserId);

		Session session = null;

		try {
			session = openSession();

			TravelUser[] array = new TravelUserImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, travelUser, uuid, orderByComparator, true);

			array[1] = travelUser;

			array[2] = getByUuid_PrevAndNext(
				session, travelUser, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected TravelUser getByUuid_PrevAndNext(
		Session session, TravelUser travelUser, String uuid,
		OrderByComparator<TravelUser> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_TRAVELUSER_WHERE);

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
			sb.append(TravelUserModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(travelUser)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<TravelUser> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the travel users where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (TravelUser travelUser :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(travelUser);
		}
	}

	/**
	 * Returns the number of travel users where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching travel users
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_TRAVELUSER_WHERE);

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
		"travelUser.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(travelUser.uuid IS NULL OR travelUser.uuid = '')";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the travel users where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching travel users
	 */
	@Override
	public List<TravelUser> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<TravelUser> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
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
	@Override
	public List<TravelUser> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<TravelUser> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
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
	@Override
	public List<TravelUser> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<TravelUser> orderByComparator,
		boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByUuid_C;
				finderArgs = new Object[] {uuid, companyId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUuid_C;
			finderArgs = new Object[] {
				uuid, companyId, start, end, orderByComparator
			};
		}

		List<TravelUser> list = null;

		if (useFinderCache) {
			list = (List<TravelUser>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (TravelUser travelUser : list) {
					if (!uuid.equals(travelUser.getUuid()) ||
						(companyId != travelUser.getCompanyId())) {

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
					4 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(4);
			}

			sb.append(_SQL_SELECT_TRAVELUSER_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(TravelUserModelImpl.ORDER_BY_JPQL);
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

				queryPos.add(companyId);

				list = (List<TravelUser>)QueryUtil.list(
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
	 * Returns the first travel user in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching travel user
	 * @throws NoSuchTravelUserException if a matching travel user could not be found
	 */
	@Override
	public TravelUser findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<TravelUser> orderByComparator)
		throws NoSuchTravelUserException {

		TravelUser travelUser = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (travelUser != null) {
			return travelUser;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchTravelUserException(sb.toString());
	}

	/**
	 * Returns the first travel user in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching travel user, or <code>null</code> if a matching travel user could not be found
	 */
	@Override
	public TravelUser fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<TravelUser> orderByComparator) {

		List<TravelUser> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public TravelUser findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<TravelUser> orderByComparator)
		throws NoSuchTravelUserException {

		TravelUser travelUser = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (travelUser != null) {
			return travelUser;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchTravelUserException(sb.toString());
	}

	/**
	 * Returns the last travel user in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching travel user, or <code>null</code> if a matching travel user could not be found
	 */
	@Override
	public TravelUser fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<TravelUser> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<TravelUser> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public TravelUser[] findByUuid_C_PrevAndNext(
			long travelUserId, String uuid, long companyId,
			OrderByComparator<TravelUser> orderByComparator)
		throws NoSuchTravelUserException {

		uuid = Objects.toString(uuid, "");

		TravelUser travelUser = findByPrimaryKey(travelUserId);

		Session session = null;

		try {
			session = openSession();

			TravelUser[] array = new TravelUserImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, travelUser, uuid, companyId, orderByComparator, true);

			array[1] = travelUser;

			array[2] = getByUuid_C_PrevAndNext(
				session, travelUser, uuid, companyId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected TravelUser getByUuid_C_PrevAndNext(
		Session session, TravelUser travelUser, String uuid, long companyId,
		OrderByComparator<TravelUser> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_TRAVELUSER_WHERE);

		boolean bindUuid = false;

		if (uuid.isEmpty()) {
			sb.append(_FINDER_COLUMN_UUID_C_UUID_3);
		}
		else {
			bindUuid = true;

			sb.append(_FINDER_COLUMN_UUID_C_UUID_2);
		}

		sb.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

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
			sb.append(TravelUserModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindUuid) {
			queryPos.add(uuid);
		}

		queryPos.add(companyId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(travelUser)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<TravelUser> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the travel users where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (TravelUser travelUser :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(travelUser);
		}
	}

	/**
	 * Returns the number of travel users where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching travel users
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_TRAVELUSER_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

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

	private static final String _FINDER_COLUMN_UUID_C_UUID_2 =
		"travelUser.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(travelUser.uuid IS NULL OR travelUser.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"travelUser.companyId = ?";

	private FinderPath _finderPathWithPaginationFindByfindByTravelUserId;
	private FinderPath _finderPathWithoutPaginationFindByfindByTravelUserId;
	private FinderPath _finderPathCountByfindByTravelUserId;

	/**
	 * Returns all the travel users where travelUserId = &#63;.
	 *
	 * @param travelUserId the travel user ID
	 * @return the matching travel users
	 */
	@Override
	public List<TravelUser> findByfindByTravelUserId(long travelUserId) {
		return findByfindByTravelUserId(
			travelUserId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<TravelUser> findByfindByTravelUserId(
		long travelUserId, int start, int end) {

		return findByfindByTravelUserId(travelUserId, start, end, null);
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
	@Override
	public List<TravelUser> findByfindByTravelUserId(
		long travelUserId, int start, int end,
		OrderByComparator<TravelUser> orderByComparator) {

		return findByfindByTravelUserId(
			travelUserId, start, end, orderByComparator, true);
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
	@Override
	public List<TravelUser> findByfindByTravelUserId(
		long travelUserId, int start, int end,
		OrderByComparator<TravelUser> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByfindByTravelUserId;
				finderArgs = new Object[] {travelUserId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByfindByTravelUserId;
			finderArgs = new Object[] {
				travelUserId, start, end, orderByComparator
			};
		}

		List<TravelUser> list = null;

		if (useFinderCache) {
			list = (List<TravelUser>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (TravelUser travelUser : list) {
					if (travelUserId != travelUser.getTravelUserId()) {
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

			sb.append(_SQL_SELECT_TRAVELUSER_WHERE);

			sb.append(_FINDER_COLUMN_FINDBYTRAVELUSERID_TRAVELUSERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(TravelUserModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(travelUserId);

				list = (List<TravelUser>)QueryUtil.list(
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
	 * Returns the first travel user in the ordered set where travelUserId = &#63;.
	 *
	 * @param travelUserId the travel user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching travel user
	 * @throws NoSuchTravelUserException if a matching travel user could not be found
	 */
	@Override
	public TravelUser findByfindByTravelUserId_First(
			long travelUserId, OrderByComparator<TravelUser> orderByComparator)
		throws NoSuchTravelUserException {

		TravelUser travelUser = fetchByfindByTravelUserId_First(
			travelUserId, orderByComparator);

		if (travelUser != null) {
			return travelUser;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("travelUserId=");
		sb.append(travelUserId);

		sb.append("}");

		throw new NoSuchTravelUserException(sb.toString());
	}

	/**
	 * Returns the first travel user in the ordered set where travelUserId = &#63;.
	 *
	 * @param travelUserId the travel user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching travel user, or <code>null</code> if a matching travel user could not be found
	 */
	@Override
	public TravelUser fetchByfindByTravelUserId_First(
		long travelUserId, OrderByComparator<TravelUser> orderByComparator) {

		List<TravelUser> list = findByfindByTravelUserId(
			travelUserId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last travel user in the ordered set where travelUserId = &#63;.
	 *
	 * @param travelUserId the travel user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching travel user
	 * @throws NoSuchTravelUserException if a matching travel user could not be found
	 */
	@Override
	public TravelUser findByfindByTravelUserId_Last(
			long travelUserId, OrderByComparator<TravelUser> orderByComparator)
		throws NoSuchTravelUserException {

		TravelUser travelUser = fetchByfindByTravelUserId_Last(
			travelUserId, orderByComparator);

		if (travelUser != null) {
			return travelUser;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("travelUserId=");
		sb.append(travelUserId);

		sb.append("}");

		throw new NoSuchTravelUserException(sb.toString());
	}

	/**
	 * Returns the last travel user in the ordered set where travelUserId = &#63;.
	 *
	 * @param travelUserId the travel user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching travel user, or <code>null</code> if a matching travel user could not be found
	 */
	@Override
	public TravelUser fetchByfindByTravelUserId_Last(
		long travelUserId, OrderByComparator<TravelUser> orderByComparator) {

		int count = countByfindByTravelUserId(travelUserId);

		if (count == 0) {
			return null;
		}

		List<TravelUser> list = findByfindByTravelUserId(
			travelUserId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Removes all the travel users where travelUserId = &#63; from the database.
	 *
	 * @param travelUserId the travel user ID
	 */
	@Override
	public void removeByfindByTravelUserId(long travelUserId) {
		for (TravelUser travelUser :
				findByfindByTravelUserId(
					travelUserId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(travelUser);
		}
	}

	/**
	 * Returns the number of travel users where travelUserId = &#63;.
	 *
	 * @param travelUserId the travel user ID
	 * @return the number of matching travel users
	 */
	@Override
	public int countByfindByTravelUserId(long travelUserId) {
		FinderPath finderPath = _finderPathCountByfindByTravelUserId;

		Object[] finderArgs = new Object[] {travelUserId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_TRAVELUSER_WHERE);

			sb.append(_FINDER_COLUMN_FINDBYTRAVELUSERID_TRAVELUSERID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(travelUserId);

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
		_FINDER_COLUMN_FINDBYTRAVELUSERID_TRAVELUSERID_2 =
			"travelUser.travelUserId = ?";

	private FinderPath
		_finderPathWithPaginationFindByfindByTravelUserPhoneNumber;
	private FinderPath
		_finderPathWithoutPaginationFindByfindByTravelUserPhoneNumber;
	private FinderPath _finderPathCountByfindByTravelUserPhoneNumber;

	/**
	 * Returns all the travel users where travelUserPhoneNumber = &#63;.
	 *
	 * @param travelUserPhoneNumber the travel user phone number
	 * @return the matching travel users
	 */
	@Override
	public List<TravelUser> findByfindByTravelUserPhoneNumber(
		String travelUserPhoneNumber) {

		return findByfindByTravelUserPhoneNumber(
			travelUserPhoneNumber, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<TravelUser> findByfindByTravelUserPhoneNumber(
		String travelUserPhoneNumber, int start, int end) {

		return findByfindByTravelUserPhoneNumber(
			travelUserPhoneNumber, start, end, null);
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
	@Override
	public List<TravelUser> findByfindByTravelUserPhoneNumber(
		String travelUserPhoneNumber, int start, int end,
		OrderByComparator<TravelUser> orderByComparator) {

		return findByfindByTravelUserPhoneNumber(
			travelUserPhoneNumber, start, end, orderByComparator, true);
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
	@Override
	public List<TravelUser> findByfindByTravelUserPhoneNumber(
		String travelUserPhoneNumber, int start, int end,
		OrderByComparator<TravelUser> orderByComparator,
		boolean useFinderCache) {

		travelUserPhoneNumber = Objects.toString(travelUserPhoneNumber, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByfindByTravelUserPhoneNumber;
				finderArgs = new Object[] {travelUserPhoneNumber};
			}
		}
		else if (useFinderCache) {
			finderPath =
				_finderPathWithPaginationFindByfindByTravelUserPhoneNumber;
			finderArgs = new Object[] {
				travelUserPhoneNumber, start, end, orderByComparator
			};
		}

		List<TravelUser> list = null;

		if (useFinderCache) {
			list = (List<TravelUser>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (TravelUser travelUser : list) {
					if (!travelUserPhoneNumber.equals(
							travelUser.getTravelUserPhoneNumber())) {

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

			sb.append(_SQL_SELECT_TRAVELUSER_WHERE);

			boolean bindTravelUserPhoneNumber = false;

			if (travelUserPhoneNumber.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_FINDBYTRAVELUSERPHONENUMBER_TRAVELUSERPHONENUMBER_3);
			}
			else {
				bindTravelUserPhoneNumber = true;

				sb.append(
					_FINDER_COLUMN_FINDBYTRAVELUSERPHONENUMBER_TRAVELUSERPHONENUMBER_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(TravelUserModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindTravelUserPhoneNumber) {
					queryPos.add(travelUserPhoneNumber);
				}

				list = (List<TravelUser>)QueryUtil.list(
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
	 * Returns the first travel user in the ordered set where travelUserPhoneNumber = &#63;.
	 *
	 * @param travelUserPhoneNumber the travel user phone number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching travel user
	 * @throws NoSuchTravelUserException if a matching travel user could not be found
	 */
	@Override
	public TravelUser findByfindByTravelUserPhoneNumber_First(
			String travelUserPhoneNumber,
			OrderByComparator<TravelUser> orderByComparator)
		throws NoSuchTravelUserException {

		TravelUser travelUser = fetchByfindByTravelUserPhoneNumber_First(
			travelUserPhoneNumber, orderByComparator);

		if (travelUser != null) {
			return travelUser;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("travelUserPhoneNumber=");
		sb.append(travelUserPhoneNumber);

		sb.append("}");

		throw new NoSuchTravelUserException(sb.toString());
	}

	/**
	 * Returns the first travel user in the ordered set where travelUserPhoneNumber = &#63;.
	 *
	 * @param travelUserPhoneNumber the travel user phone number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching travel user, or <code>null</code> if a matching travel user could not be found
	 */
	@Override
	public TravelUser fetchByfindByTravelUserPhoneNumber_First(
		String travelUserPhoneNumber,
		OrderByComparator<TravelUser> orderByComparator) {

		List<TravelUser> list = findByfindByTravelUserPhoneNumber(
			travelUserPhoneNumber, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last travel user in the ordered set where travelUserPhoneNumber = &#63;.
	 *
	 * @param travelUserPhoneNumber the travel user phone number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching travel user
	 * @throws NoSuchTravelUserException if a matching travel user could not be found
	 */
	@Override
	public TravelUser findByfindByTravelUserPhoneNumber_Last(
			String travelUserPhoneNumber,
			OrderByComparator<TravelUser> orderByComparator)
		throws NoSuchTravelUserException {

		TravelUser travelUser = fetchByfindByTravelUserPhoneNumber_Last(
			travelUserPhoneNumber, orderByComparator);

		if (travelUser != null) {
			return travelUser;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("travelUserPhoneNumber=");
		sb.append(travelUserPhoneNumber);

		sb.append("}");

		throw new NoSuchTravelUserException(sb.toString());
	}

	/**
	 * Returns the last travel user in the ordered set where travelUserPhoneNumber = &#63;.
	 *
	 * @param travelUserPhoneNumber the travel user phone number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching travel user, or <code>null</code> if a matching travel user could not be found
	 */
	@Override
	public TravelUser fetchByfindByTravelUserPhoneNumber_Last(
		String travelUserPhoneNumber,
		OrderByComparator<TravelUser> orderByComparator) {

		int count = countByfindByTravelUserPhoneNumber(travelUserPhoneNumber);

		if (count == 0) {
			return null;
		}

		List<TravelUser> list = findByfindByTravelUserPhoneNumber(
			travelUserPhoneNumber, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public TravelUser[] findByfindByTravelUserPhoneNumber_PrevAndNext(
			long travelUserId, String travelUserPhoneNumber,
			OrderByComparator<TravelUser> orderByComparator)
		throws NoSuchTravelUserException {

		travelUserPhoneNumber = Objects.toString(travelUserPhoneNumber, "");

		TravelUser travelUser = findByPrimaryKey(travelUserId);

		Session session = null;

		try {
			session = openSession();

			TravelUser[] array = new TravelUserImpl[3];

			array[0] = getByfindByTravelUserPhoneNumber_PrevAndNext(
				session, travelUser, travelUserPhoneNumber, orderByComparator,
				true);

			array[1] = travelUser;

			array[2] = getByfindByTravelUserPhoneNumber_PrevAndNext(
				session, travelUser, travelUserPhoneNumber, orderByComparator,
				false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected TravelUser getByfindByTravelUserPhoneNumber_PrevAndNext(
		Session session, TravelUser travelUser, String travelUserPhoneNumber,
		OrderByComparator<TravelUser> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_TRAVELUSER_WHERE);

		boolean bindTravelUserPhoneNumber = false;

		if (travelUserPhoneNumber.isEmpty()) {
			sb.append(
				_FINDER_COLUMN_FINDBYTRAVELUSERPHONENUMBER_TRAVELUSERPHONENUMBER_3);
		}
		else {
			bindTravelUserPhoneNumber = true;

			sb.append(
				_FINDER_COLUMN_FINDBYTRAVELUSERPHONENUMBER_TRAVELUSERPHONENUMBER_2);
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
			sb.append(TravelUserModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindTravelUserPhoneNumber) {
			queryPos.add(travelUserPhoneNumber);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(travelUser)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<TravelUser> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the travel users where travelUserPhoneNumber = &#63; from the database.
	 *
	 * @param travelUserPhoneNumber the travel user phone number
	 */
	@Override
	public void removeByfindByTravelUserPhoneNumber(
		String travelUserPhoneNumber) {

		for (TravelUser travelUser :
				findByfindByTravelUserPhoneNumber(
					travelUserPhoneNumber, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(travelUser);
		}
	}

	/**
	 * Returns the number of travel users where travelUserPhoneNumber = &#63;.
	 *
	 * @param travelUserPhoneNumber the travel user phone number
	 * @return the number of matching travel users
	 */
	@Override
	public int countByfindByTravelUserPhoneNumber(
		String travelUserPhoneNumber) {

		travelUserPhoneNumber = Objects.toString(travelUserPhoneNumber, "");

		FinderPath finderPath = _finderPathCountByfindByTravelUserPhoneNumber;

		Object[] finderArgs = new Object[] {travelUserPhoneNumber};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_TRAVELUSER_WHERE);

			boolean bindTravelUserPhoneNumber = false;

			if (travelUserPhoneNumber.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_FINDBYTRAVELUSERPHONENUMBER_TRAVELUSERPHONENUMBER_3);
			}
			else {
				bindTravelUserPhoneNumber = true;

				sb.append(
					_FINDER_COLUMN_FINDBYTRAVELUSERPHONENUMBER_TRAVELUSERPHONENUMBER_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindTravelUserPhoneNumber) {
					queryPos.add(travelUserPhoneNumber);
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

	private static final String
		_FINDER_COLUMN_FINDBYTRAVELUSERPHONENUMBER_TRAVELUSERPHONENUMBER_2 =
			"travelUser.travelUserPhoneNumber = ?";

	private static final String
		_FINDER_COLUMN_FINDBYTRAVELUSERPHONENUMBER_TRAVELUSERPHONENUMBER_3 =
			"(travelUser.travelUserPhoneNumber IS NULL OR travelUser.travelUserPhoneNumber = '')";

	private FinderPath _finderPathWithPaginationFindByfindByUserEmail;
	private FinderPath _finderPathWithoutPaginationFindByfindByUserEmail;
	private FinderPath _finderPathCountByfindByUserEmail;

	/**
	 * Returns all the travel users where travelUserEmail = &#63;.
	 *
	 * @param travelUserEmail the travel user email
	 * @return the matching travel users
	 */
	@Override
	public List<TravelUser> findByfindByUserEmail(String travelUserEmail) {
		return findByfindByUserEmail(
			travelUserEmail, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<TravelUser> findByfindByUserEmail(
		String travelUserEmail, int start, int end) {

		return findByfindByUserEmail(travelUserEmail, start, end, null);
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
	@Override
	public List<TravelUser> findByfindByUserEmail(
		String travelUserEmail, int start, int end,
		OrderByComparator<TravelUser> orderByComparator) {

		return findByfindByUserEmail(
			travelUserEmail, start, end, orderByComparator, true);
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
	@Override
	public List<TravelUser> findByfindByUserEmail(
		String travelUserEmail, int start, int end,
		OrderByComparator<TravelUser> orderByComparator,
		boolean useFinderCache) {

		travelUserEmail = Objects.toString(travelUserEmail, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByfindByUserEmail;
				finderArgs = new Object[] {travelUserEmail};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByfindByUserEmail;
			finderArgs = new Object[] {
				travelUserEmail, start, end, orderByComparator
			};
		}

		List<TravelUser> list = null;

		if (useFinderCache) {
			list = (List<TravelUser>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (TravelUser travelUser : list) {
					if (!travelUserEmail.equals(
							travelUser.getTravelUserEmail())) {

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

			sb.append(_SQL_SELECT_TRAVELUSER_WHERE);

			boolean bindTravelUserEmail = false;

			if (travelUserEmail.isEmpty()) {
				sb.append(_FINDER_COLUMN_FINDBYUSEREMAIL_TRAVELUSEREMAIL_3);
			}
			else {
				bindTravelUserEmail = true;

				sb.append(_FINDER_COLUMN_FINDBYUSEREMAIL_TRAVELUSEREMAIL_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(TravelUserModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindTravelUserEmail) {
					queryPos.add(travelUserEmail);
				}

				list = (List<TravelUser>)QueryUtil.list(
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
	 * Returns the first travel user in the ordered set where travelUserEmail = &#63;.
	 *
	 * @param travelUserEmail the travel user email
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching travel user
	 * @throws NoSuchTravelUserException if a matching travel user could not be found
	 */
	@Override
	public TravelUser findByfindByUserEmail_First(
			String travelUserEmail,
			OrderByComparator<TravelUser> orderByComparator)
		throws NoSuchTravelUserException {

		TravelUser travelUser = fetchByfindByUserEmail_First(
			travelUserEmail, orderByComparator);

		if (travelUser != null) {
			return travelUser;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("travelUserEmail=");
		sb.append(travelUserEmail);

		sb.append("}");

		throw new NoSuchTravelUserException(sb.toString());
	}

	/**
	 * Returns the first travel user in the ordered set where travelUserEmail = &#63;.
	 *
	 * @param travelUserEmail the travel user email
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching travel user, or <code>null</code> if a matching travel user could not be found
	 */
	@Override
	public TravelUser fetchByfindByUserEmail_First(
		String travelUserEmail,
		OrderByComparator<TravelUser> orderByComparator) {

		List<TravelUser> list = findByfindByUserEmail(
			travelUserEmail, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last travel user in the ordered set where travelUserEmail = &#63;.
	 *
	 * @param travelUserEmail the travel user email
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching travel user
	 * @throws NoSuchTravelUserException if a matching travel user could not be found
	 */
	@Override
	public TravelUser findByfindByUserEmail_Last(
			String travelUserEmail,
			OrderByComparator<TravelUser> orderByComparator)
		throws NoSuchTravelUserException {

		TravelUser travelUser = fetchByfindByUserEmail_Last(
			travelUserEmail, orderByComparator);

		if (travelUser != null) {
			return travelUser;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("travelUserEmail=");
		sb.append(travelUserEmail);

		sb.append("}");

		throw new NoSuchTravelUserException(sb.toString());
	}

	/**
	 * Returns the last travel user in the ordered set where travelUserEmail = &#63;.
	 *
	 * @param travelUserEmail the travel user email
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching travel user, or <code>null</code> if a matching travel user could not be found
	 */
	@Override
	public TravelUser fetchByfindByUserEmail_Last(
		String travelUserEmail,
		OrderByComparator<TravelUser> orderByComparator) {

		int count = countByfindByUserEmail(travelUserEmail);

		if (count == 0) {
			return null;
		}

		List<TravelUser> list = findByfindByUserEmail(
			travelUserEmail, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public TravelUser[] findByfindByUserEmail_PrevAndNext(
			long travelUserId, String travelUserEmail,
			OrderByComparator<TravelUser> orderByComparator)
		throws NoSuchTravelUserException {

		travelUserEmail = Objects.toString(travelUserEmail, "");

		TravelUser travelUser = findByPrimaryKey(travelUserId);

		Session session = null;

		try {
			session = openSession();

			TravelUser[] array = new TravelUserImpl[3];

			array[0] = getByfindByUserEmail_PrevAndNext(
				session, travelUser, travelUserEmail, orderByComparator, true);

			array[1] = travelUser;

			array[2] = getByfindByUserEmail_PrevAndNext(
				session, travelUser, travelUserEmail, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected TravelUser getByfindByUserEmail_PrevAndNext(
		Session session, TravelUser travelUser, String travelUserEmail,
		OrderByComparator<TravelUser> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_TRAVELUSER_WHERE);

		boolean bindTravelUserEmail = false;

		if (travelUserEmail.isEmpty()) {
			sb.append(_FINDER_COLUMN_FINDBYUSEREMAIL_TRAVELUSEREMAIL_3);
		}
		else {
			bindTravelUserEmail = true;

			sb.append(_FINDER_COLUMN_FINDBYUSEREMAIL_TRAVELUSEREMAIL_2);
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
			sb.append(TravelUserModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindTravelUserEmail) {
			queryPos.add(travelUserEmail);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(travelUser)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<TravelUser> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the travel users where travelUserEmail = &#63; from the database.
	 *
	 * @param travelUserEmail the travel user email
	 */
	@Override
	public void removeByfindByUserEmail(String travelUserEmail) {
		for (TravelUser travelUser :
				findByfindByUserEmail(
					travelUserEmail, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(travelUser);
		}
	}

	/**
	 * Returns the number of travel users where travelUserEmail = &#63;.
	 *
	 * @param travelUserEmail the travel user email
	 * @return the number of matching travel users
	 */
	@Override
	public int countByfindByUserEmail(String travelUserEmail) {
		travelUserEmail = Objects.toString(travelUserEmail, "");

		FinderPath finderPath = _finderPathCountByfindByUserEmail;

		Object[] finderArgs = new Object[] {travelUserEmail};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_TRAVELUSER_WHERE);

			boolean bindTravelUserEmail = false;

			if (travelUserEmail.isEmpty()) {
				sb.append(_FINDER_COLUMN_FINDBYUSEREMAIL_TRAVELUSEREMAIL_3);
			}
			else {
				bindTravelUserEmail = true;

				sb.append(_FINDER_COLUMN_FINDBYUSEREMAIL_TRAVELUSEREMAIL_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindTravelUserEmail) {
					queryPos.add(travelUserEmail);
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

	private static final String
		_FINDER_COLUMN_FINDBYUSEREMAIL_TRAVELUSEREMAIL_2 =
			"travelUser.travelUserEmail = ?";

	private static final String
		_FINDER_COLUMN_FINDBYUSEREMAIL_TRAVELUSEREMAIL_3 =
			"(travelUser.travelUserEmail IS NULL OR travelUser.travelUserEmail = '')";

	private FinderPath _finderPathWithPaginationFindByFind_TravelUsers;
	private FinderPath _finderPathWithoutPaginationFindByFind_TravelUsers;
	private FinderPath _finderPathCountByFind_TravelUsers;

	/**
	 * Returns all the travel users where userId = &#63; and companyId = &#63;.
	 *
	 * @param userId the user ID
	 * @param companyId the company ID
	 * @return the matching travel users
	 */
	@Override
	public List<TravelUser> findByFind_TravelUsers(
		long userId, long companyId) {

		return findByFind_TravelUsers(
			userId, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<TravelUser> findByFind_TravelUsers(
		long userId, long companyId, int start, int end) {

		return findByFind_TravelUsers(userId, companyId, start, end, null);
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
	@Override
	public List<TravelUser> findByFind_TravelUsers(
		long userId, long companyId, int start, int end,
		OrderByComparator<TravelUser> orderByComparator) {

		return findByFind_TravelUsers(
			userId, companyId, start, end, orderByComparator, true);
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
	@Override
	public List<TravelUser> findByFind_TravelUsers(
		long userId, long companyId, int start, int end,
		OrderByComparator<TravelUser> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByFind_TravelUsers;
				finderArgs = new Object[] {userId, companyId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByFind_TravelUsers;
			finderArgs = new Object[] {
				userId, companyId, start, end, orderByComparator
			};
		}

		List<TravelUser> list = null;

		if (useFinderCache) {
			list = (List<TravelUser>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (TravelUser travelUser : list) {
					if ((userId != travelUser.getUserId()) ||
						(companyId != travelUser.getCompanyId())) {

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
					4 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(4);
			}

			sb.append(_SQL_SELECT_TRAVELUSER_WHERE);

			sb.append(_FINDER_COLUMN_FIND_TRAVELUSERS_USERID_2);

			sb.append(_FINDER_COLUMN_FIND_TRAVELUSERS_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(TravelUserModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(userId);

				queryPos.add(companyId);

				list = (List<TravelUser>)QueryUtil.list(
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
	 * Returns the first travel user in the ordered set where userId = &#63; and companyId = &#63;.
	 *
	 * @param userId the user ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching travel user
	 * @throws NoSuchTravelUserException if a matching travel user could not be found
	 */
	@Override
	public TravelUser findByFind_TravelUsers_First(
			long userId, long companyId,
			OrderByComparator<TravelUser> orderByComparator)
		throws NoSuchTravelUserException {

		TravelUser travelUser = fetchByFind_TravelUsers_First(
			userId, companyId, orderByComparator);

		if (travelUser != null) {
			return travelUser;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("userId=");
		sb.append(userId);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchTravelUserException(sb.toString());
	}

	/**
	 * Returns the first travel user in the ordered set where userId = &#63; and companyId = &#63;.
	 *
	 * @param userId the user ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching travel user, or <code>null</code> if a matching travel user could not be found
	 */
	@Override
	public TravelUser fetchByFind_TravelUsers_First(
		long userId, long companyId,
		OrderByComparator<TravelUser> orderByComparator) {

		List<TravelUser> list = findByFind_TravelUsers(
			userId, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public TravelUser findByFind_TravelUsers_Last(
			long userId, long companyId,
			OrderByComparator<TravelUser> orderByComparator)
		throws NoSuchTravelUserException {

		TravelUser travelUser = fetchByFind_TravelUsers_Last(
			userId, companyId, orderByComparator);

		if (travelUser != null) {
			return travelUser;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("userId=");
		sb.append(userId);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchTravelUserException(sb.toString());
	}

	/**
	 * Returns the last travel user in the ordered set where userId = &#63; and companyId = &#63;.
	 *
	 * @param userId the user ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching travel user, or <code>null</code> if a matching travel user could not be found
	 */
	@Override
	public TravelUser fetchByFind_TravelUsers_Last(
		long userId, long companyId,
		OrderByComparator<TravelUser> orderByComparator) {

		int count = countByFind_TravelUsers(userId, companyId);

		if (count == 0) {
			return null;
		}

		List<TravelUser> list = findByFind_TravelUsers(
			userId, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public TravelUser[] findByFind_TravelUsers_PrevAndNext(
			long travelUserId, long userId, long companyId,
			OrderByComparator<TravelUser> orderByComparator)
		throws NoSuchTravelUserException {

		TravelUser travelUser = findByPrimaryKey(travelUserId);

		Session session = null;

		try {
			session = openSession();

			TravelUser[] array = new TravelUserImpl[3];

			array[0] = getByFind_TravelUsers_PrevAndNext(
				session, travelUser, userId, companyId, orderByComparator,
				true);

			array[1] = travelUser;

			array[2] = getByFind_TravelUsers_PrevAndNext(
				session, travelUser, userId, companyId, orderByComparator,
				false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected TravelUser getByFind_TravelUsers_PrevAndNext(
		Session session, TravelUser travelUser, long userId, long companyId,
		OrderByComparator<TravelUser> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_TRAVELUSER_WHERE);

		sb.append(_FINDER_COLUMN_FIND_TRAVELUSERS_USERID_2);

		sb.append(_FINDER_COLUMN_FIND_TRAVELUSERS_COMPANYID_2);

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
			sb.append(TravelUserModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(userId);

		queryPos.add(companyId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(travelUser)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<TravelUser> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the travel users where userId = &#63; and companyId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param companyId the company ID
	 */
	@Override
	public void removeByFind_TravelUsers(long userId, long companyId) {
		for (TravelUser travelUser :
				findByFind_TravelUsers(
					userId, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(travelUser);
		}
	}

	/**
	 * Returns the number of travel users where userId = &#63; and companyId = &#63;.
	 *
	 * @param userId the user ID
	 * @param companyId the company ID
	 * @return the number of matching travel users
	 */
	@Override
	public int countByFind_TravelUsers(long userId, long companyId) {
		FinderPath finderPath = _finderPathCountByFind_TravelUsers;

		Object[] finderArgs = new Object[] {userId, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_TRAVELUSER_WHERE);

			sb.append(_FINDER_COLUMN_FIND_TRAVELUSERS_USERID_2);

			sb.append(_FINDER_COLUMN_FIND_TRAVELUSERS_COMPANYID_2);

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

	private static final String _FINDER_COLUMN_FIND_TRAVELUSERS_USERID_2 =
		"travelUser.userId = ? AND ";

	private static final String _FINDER_COLUMN_FIND_TRAVELUSERS_COMPANYID_2 =
		"travelUser.companyId = ?";

	private FinderPath _finderPathWithPaginationFindByUserId;
	private FinderPath _finderPathWithoutPaginationFindByUserId;
	private FinderPath _finderPathCountByUserId;

	/**
	 * Returns all the travel users where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching travel users
	 */
	@Override
	public List<TravelUser> findByUserId(long userId) {
		return findByUserId(userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<TravelUser> findByUserId(long userId, int start, int end) {
		return findByUserId(userId, start, end, null);
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
	@Override
	public List<TravelUser> findByUserId(
		long userId, int start, int end,
		OrderByComparator<TravelUser> orderByComparator) {

		return findByUserId(userId, start, end, orderByComparator, true);
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
	@Override
	public List<TravelUser> findByUserId(
		long userId, int start, int end,
		OrderByComparator<TravelUser> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByUserId;
				finderArgs = new Object[] {userId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUserId;
			finderArgs = new Object[] {userId, start, end, orderByComparator};
		}

		List<TravelUser> list = null;

		if (useFinderCache) {
			list = (List<TravelUser>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (TravelUser travelUser : list) {
					if (userId != travelUser.getUserId()) {
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

			sb.append(_SQL_SELECT_TRAVELUSER_WHERE);

			sb.append(_FINDER_COLUMN_USERID_USERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(TravelUserModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(userId);

				list = (List<TravelUser>)QueryUtil.list(
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
	 * Returns the first travel user in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching travel user
	 * @throws NoSuchTravelUserException if a matching travel user could not be found
	 */
	@Override
	public TravelUser findByUserId_First(
			long userId, OrderByComparator<TravelUser> orderByComparator)
		throws NoSuchTravelUserException {

		TravelUser travelUser = fetchByUserId_First(userId, orderByComparator);

		if (travelUser != null) {
			return travelUser;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("userId=");
		sb.append(userId);

		sb.append("}");

		throw new NoSuchTravelUserException(sb.toString());
	}

	/**
	 * Returns the first travel user in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching travel user, or <code>null</code> if a matching travel user could not be found
	 */
	@Override
	public TravelUser fetchByUserId_First(
		long userId, OrderByComparator<TravelUser> orderByComparator) {

		List<TravelUser> list = findByUserId(userId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last travel user in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching travel user
	 * @throws NoSuchTravelUserException if a matching travel user could not be found
	 */
	@Override
	public TravelUser findByUserId_Last(
			long userId, OrderByComparator<TravelUser> orderByComparator)
		throws NoSuchTravelUserException {

		TravelUser travelUser = fetchByUserId_Last(userId, orderByComparator);

		if (travelUser != null) {
			return travelUser;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("userId=");
		sb.append(userId);

		sb.append("}");

		throw new NoSuchTravelUserException(sb.toString());
	}

	/**
	 * Returns the last travel user in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching travel user, or <code>null</code> if a matching travel user could not be found
	 */
	@Override
	public TravelUser fetchByUserId_Last(
		long userId, OrderByComparator<TravelUser> orderByComparator) {

		int count = countByUserId(userId);

		if (count == 0) {
			return null;
		}

		List<TravelUser> list = findByUserId(
			userId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public TravelUser[] findByUserId_PrevAndNext(
			long travelUserId, long userId,
			OrderByComparator<TravelUser> orderByComparator)
		throws NoSuchTravelUserException {

		TravelUser travelUser = findByPrimaryKey(travelUserId);

		Session session = null;

		try {
			session = openSession();

			TravelUser[] array = new TravelUserImpl[3];

			array[0] = getByUserId_PrevAndNext(
				session, travelUser, userId, orderByComparator, true);

			array[1] = travelUser;

			array[2] = getByUserId_PrevAndNext(
				session, travelUser, userId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected TravelUser getByUserId_PrevAndNext(
		Session session, TravelUser travelUser, long userId,
		OrderByComparator<TravelUser> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_TRAVELUSER_WHERE);

		sb.append(_FINDER_COLUMN_USERID_USERID_2);

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
			sb.append(TravelUserModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(userId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(travelUser)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<TravelUser> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the travel users where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 */
	@Override
	public void removeByUserId(long userId) {
		for (TravelUser travelUser :
				findByUserId(
					userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(travelUser);
		}
	}

	/**
	 * Returns the number of travel users where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching travel users
	 */
	@Override
	public int countByUserId(long userId) {
		FinderPath finderPath = _finderPathCountByUserId;

		Object[] finderArgs = new Object[] {userId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_TRAVELUSER_WHERE);

			sb.append(_FINDER_COLUMN_USERID_USERID_2);

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

	private static final String _FINDER_COLUMN_USERID_USERID_2 =
		"travelUser.userId = ?";

	private FinderPath _finderPathWithPaginationFindByfindByArea;
	private FinderPath _finderPathWithoutPaginationFindByfindByArea;
	private FinderPath _finderPathCountByfindByArea;

	/**
	 * Returns all the travel users where area = &#63;.
	 *
	 * @param area the area
	 * @return the matching travel users
	 */
	@Override
	public List<TravelUser> findByfindByArea(String area) {
		return findByfindByArea(
			area, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<TravelUser> findByfindByArea(String area, int start, int end) {
		return findByfindByArea(area, start, end, null);
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
	@Override
	public List<TravelUser> findByfindByArea(
		String area, int start, int end,
		OrderByComparator<TravelUser> orderByComparator) {

		return findByfindByArea(area, start, end, orderByComparator, true);
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
	@Override
	public List<TravelUser> findByfindByArea(
		String area, int start, int end,
		OrderByComparator<TravelUser> orderByComparator,
		boolean useFinderCache) {

		area = Objects.toString(area, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByfindByArea;
				finderArgs = new Object[] {area};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByfindByArea;
			finderArgs = new Object[] {area, start, end, orderByComparator};
		}

		List<TravelUser> list = null;

		if (useFinderCache) {
			list = (List<TravelUser>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (TravelUser travelUser : list) {
					if (!area.equals(travelUser.getArea())) {
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

			sb.append(_SQL_SELECT_TRAVELUSER_WHERE);

			boolean bindArea = false;

			if (area.isEmpty()) {
				sb.append(_FINDER_COLUMN_FINDBYAREA_AREA_3);
			}
			else {
				bindArea = true;

				sb.append(_FINDER_COLUMN_FINDBYAREA_AREA_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(TravelUserModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindArea) {
					queryPos.add(area);
				}

				list = (List<TravelUser>)QueryUtil.list(
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
	 * Returns the first travel user in the ordered set where area = &#63;.
	 *
	 * @param area the area
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching travel user
	 * @throws NoSuchTravelUserException if a matching travel user could not be found
	 */
	@Override
	public TravelUser findByfindByArea_First(
			String area, OrderByComparator<TravelUser> orderByComparator)
		throws NoSuchTravelUserException {

		TravelUser travelUser = fetchByfindByArea_First(
			area, orderByComparator);

		if (travelUser != null) {
			return travelUser;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("area=");
		sb.append(area);

		sb.append("}");

		throw new NoSuchTravelUserException(sb.toString());
	}

	/**
	 * Returns the first travel user in the ordered set where area = &#63;.
	 *
	 * @param area the area
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching travel user, or <code>null</code> if a matching travel user could not be found
	 */
	@Override
	public TravelUser fetchByfindByArea_First(
		String area, OrderByComparator<TravelUser> orderByComparator) {

		List<TravelUser> list = findByfindByArea(area, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last travel user in the ordered set where area = &#63;.
	 *
	 * @param area the area
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching travel user
	 * @throws NoSuchTravelUserException if a matching travel user could not be found
	 */
	@Override
	public TravelUser findByfindByArea_Last(
			String area, OrderByComparator<TravelUser> orderByComparator)
		throws NoSuchTravelUserException {

		TravelUser travelUser = fetchByfindByArea_Last(area, orderByComparator);

		if (travelUser != null) {
			return travelUser;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("area=");
		sb.append(area);

		sb.append("}");

		throw new NoSuchTravelUserException(sb.toString());
	}

	/**
	 * Returns the last travel user in the ordered set where area = &#63;.
	 *
	 * @param area the area
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching travel user, or <code>null</code> if a matching travel user could not be found
	 */
	@Override
	public TravelUser fetchByfindByArea_Last(
		String area, OrderByComparator<TravelUser> orderByComparator) {

		int count = countByfindByArea(area);

		if (count == 0) {
			return null;
		}

		List<TravelUser> list = findByfindByArea(
			area, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public TravelUser[] findByfindByArea_PrevAndNext(
			long travelUserId, String area,
			OrderByComparator<TravelUser> orderByComparator)
		throws NoSuchTravelUserException {

		area = Objects.toString(area, "");

		TravelUser travelUser = findByPrimaryKey(travelUserId);

		Session session = null;

		try {
			session = openSession();

			TravelUser[] array = new TravelUserImpl[3];

			array[0] = getByfindByArea_PrevAndNext(
				session, travelUser, area, orderByComparator, true);

			array[1] = travelUser;

			array[2] = getByfindByArea_PrevAndNext(
				session, travelUser, area, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected TravelUser getByfindByArea_PrevAndNext(
		Session session, TravelUser travelUser, String area,
		OrderByComparator<TravelUser> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_TRAVELUSER_WHERE);

		boolean bindArea = false;

		if (area.isEmpty()) {
			sb.append(_FINDER_COLUMN_FINDBYAREA_AREA_3);
		}
		else {
			bindArea = true;

			sb.append(_FINDER_COLUMN_FINDBYAREA_AREA_2);
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
			sb.append(TravelUserModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindArea) {
			queryPos.add(area);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(travelUser)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<TravelUser> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the travel users where area = &#63; from the database.
	 *
	 * @param area the area
	 */
	@Override
	public void removeByfindByArea(String area) {
		for (TravelUser travelUser :
				findByfindByArea(
					area, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(travelUser);
		}
	}

	/**
	 * Returns the number of travel users where area = &#63;.
	 *
	 * @param area the area
	 * @return the number of matching travel users
	 */
	@Override
	public int countByfindByArea(String area) {
		area = Objects.toString(area, "");

		FinderPath finderPath = _finderPathCountByfindByArea;

		Object[] finderArgs = new Object[] {area};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_TRAVELUSER_WHERE);

			boolean bindArea = false;

			if (area.isEmpty()) {
				sb.append(_FINDER_COLUMN_FINDBYAREA_AREA_3);
			}
			else {
				bindArea = true;

				sb.append(_FINDER_COLUMN_FINDBYAREA_AREA_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindArea) {
					queryPos.add(area);
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

	private static final String _FINDER_COLUMN_FINDBYAREA_AREA_2 =
		"travelUser.area = ?";

	private static final String _FINDER_COLUMN_FINDBYAREA_AREA_3 =
		"(travelUser.area IS NULL OR travelUser.area = '')";

	private FinderPath _finderPathWithPaginationFindByfindByDistrict;
	private FinderPath _finderPathWithoutPaginationFindByfindByDistrict;
	private FinderPath _finderPathCountByfindByDistrict;

	/**
	 * Returns all the travel users where district = &#63;.
	 *
	 * @param district the district
	 * @return the matching travel users
	 */
	@Override
	public List<TravelUser> findByfindByDistrict(long district) {
		return findByfindByDistrict(
			district, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<TravelUser> findByfindByDistrict(
		long district, int start, int end) {

		return findByfindByDistrict(district, start, end, null);
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
	@Override
	public List<TravelUser> findByfindByDistrict(
		long district, int start, int end,
		OrderByComparator<TravelUser> orderByComparator) {

		return findByfindByDistrict(
			district, start, end, orderByComparator, true);
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
	@Override
	public List<TravelUser> findByfindByDistrict(
		long district, int start, int end,
		OrderByComparator<TravelUser> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByfindByDistrict;
				finderArgs = new Object[] {district};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByfindByDistrict;
			finderArgs = new Object[] {district, start, end, orderByComparator};
		}

		List<TravelUser> list = null;

		if (useFinderCache) {
			list = (List<TravelUser>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (TravelUser travelUser : list) {
					if (district != travelUser.getDistrict()) {
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

			sb.append(_SQL_SELECT_TRAVELUSER_WHERE);

			sb.append(_FINDER_COLUMN_FINDBYDISTRICT_DISTRICT_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(TravelUserModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(district);

				list = (List<TravelUser>)QueryUtil.list(
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
	 * Returns the first travel user in the ordered set where district = &#63;.
	 *
	 * @param district the district
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching travel user
	 * @throws NoSuchTravelUserException if a matching travel user could not be found
	 */
	@Override
	public TravelUser findByfindByDistrict_First(
			long district, OrderByComparator<TravelUser> orderByComparator)
		throws NoSuchTravelUserException {

		TravelUser travelUser = fetchByfindByDistrict_First(
			district, orderByComparator);

		if (travelUser != null) {
			return travelUser;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("district=");
		sb.append(district);

		sb.append("}");

		throw new NoSuchTravelUserException(sb.toString());
	}

	/**
	 * Returns the first travel user in the ordered set where district = &#63;.
	 *
	 * @param district the district
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching travel user, or <code>null</code> if a matching travel user could not be found
	 */
	@Override
	public TravelUser fetchByfindByDistrict_First(
		long district, OrderByComparator<TravelUser> orderByComparator) {

		List<TravelUser> list = findByfindByDistrict(
			district, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last travel user in the ordered set where district = &#63;.
	 *
	 * @param district the district
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching travel user
	 * @throws NoSuchTravelUserException if a matching travel user could not be found
	 */
	@Override
	public TravelUser findByfindByDistrict_Last(
			long district, OrderByComparator<TravelUser> orderByComparator)
		throws NoSuchTravelUserException {

		TravelUser travelUser = fetchByfindByDistrict_Last(
			district, orderByComparator);

		if (travelUser != null) {
			return travelUser;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("district=");
		sb.append(district);

		sb.append("}");

		throw new NoSuchTravelUserException(sb.toString());
	}

	/**
	 * Returns the last travel user in the ordered set where district = &#63;.
	 *
	 * @param district the district
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching travel user, or <code>null</code> if a matching travel user could not be found
	 */
	@Override
	public TravelUser fetchByfindByDistrict_Last(
		long district, OrderByComparator<TravelUser> orderByComparator) {

		int count = countByfindByDistrict(district);

		if (count == 0) {
			return null;
		}

		List<TravelUser> list = findByfindByDistrict(
			district, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public TravelUser[] findByfindByDistrict_PrevAndNext(
			long travelUserId, long district,
			OrderByComparator<TravelUser> orderByComparator)
		throws NoSuchTravelUserException {

		TravelUser travelUser = findByPrimaryKey(travelUserId);

		Session session = null;

		try {
			session = openSession();

			TravelUser[] array = new TravelUserImpl[3];

			array[0] = getByfindByDistrict_PrevAndNext(
				session, travelUser, district, orderByComparator, true);

			array[1] = travelUser;

			array[2] = getByfindByDistrict_PrevAndNext(
				session, travelUser, district, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected TravelUser getByfindByDistrict_PrevAndNext(
		Session session, TravelUser travelUser, long district,
		OrderByComparator<TravelUser> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_TRAVELUSER_WHERE);

		sb.append(_FINDER_COLUMN_FINDBYDISTRICT_DISTRICT_2);

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
			sb.append(TravelUserModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(district);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(travelUser)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<TravelUser> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the travel users where district = &#63; from the database.
	 *
	 * @param district the district
	 */
	@Override
	public void removeByfindByDistrict(long district) {
		for (TravelUser travelUser :
				findByfindByDistrict(
					district, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(travelUser);
		}
	}

	/**
	 * Returns the number of travel users where district = &#63;.
	 *
	 * @param district the district
	 * @return the number of matching travel users
	 */
	@Override
	public int countByfindByDistrict(long district) {
		FinderPath finderPath = _finderPathCountByfindByDistrict;

		Object[] finderArgs = new Object[] {district};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_TRAVELUSER_WHERE);

			sb.append(_FINDER_COLUMN_FINDBYDISTRICT_DISTRICT_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(district);

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

	private static final String _FINDER_COLUMN_FINDBYDISTRICT_DISTRICT_2 =
		"travelUser.district = ?";

	private FinderPath _finderPathWithPaginationFindByfindByDistricAndAreat;
	private FinderPath _finderPathWithoutPaginationFindByfindByDistricAndAreat;
	private FinderPath _finderPathCountByfindByDistricAndAreat;

	/**
	 * Returns all the travel users where district = &#63; and area = &#63;.
	 *
	 * @param district the district
	 * @param area the area
	 * @return the matching travel users
	 */
	@Override
	public List<TravelUser> findByfindByDistricAndAreat(
		long district, String area) {

		return findByfindByDistricAndAreat(
			district, area, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<TravelUser> findByfindByDistricAndAreat(
		long district, String area, int start, int end) {

		return findByfindByDistricAndAreat(district, area, start, end, null);
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
	@Override
	public List<TravelUser> findByfindByDistricAndAreat(
		long district, String area, int start, int end,
		OrderByComparator<TravelUser> orderByComparator) {

		return findByfindByDistricAndAreat(
			district, area, start, end, orderByComparator, true);
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
	@Override
	public List<TravelUser> findByfindByDistricAndAreat(
		long district, String area, int start, int end,
		OrderByComparator<TravelUser> orderByComparator,
		boolean useFinderCache) {

		area = Objects.toString(area, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByfindByDistricAndAreat;
				finderArgs = new Object[] {district, area};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByfindByDistricAndAreat;
			finderArgs = new Object[] {
				district, area, start, end, orderByComparator
			};
		}

		List<TravelUser> list = null;

		if (useFinderCache) {
			list = (List<TravelUser>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (TravelUser travelUser : list) {
					if ((district != travelUser.getDistrict()) ||
						!area.equals(travelUser.getArea())) {

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
					4 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(4);
			}

			sb.append(_SQL_SELECT_TRAVELUSER_WHERE);

			sb.append(_FINDER_COLUMN_FINDBYDISTRICANDAREAT_DISTRICT_2);

			boolean bindArea = false;

			if (area.isEmpty()) {
				sb.append(_FINDER_COLUMN_FINDBYDISTRICANDAREAT_AREA_3);
			}
			else {
				bindArea = true;

				sb.append(_FINDER_COLUMN_FINDBYDISTRICANDAREAT_AREA_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(TravelUserModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(district);

				if (bindArea) {
					queryPos.add(area);
				}

				list = (List<TravelUser>)QueryUtil.list(
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
	 * Returns the first travel user in the ordered set where district = &#63; and area = &#63;.
	 *
	 * @param district the district
	 * @param area the area
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching travel user
	 * @throws NoSuchTravelUserException if a matching travel user could not be found
	 */
	@Override
	public TravelUser findByfindByDistricAndAreat_First(
			long district, String area,
			OrderByComparator<TravelUser> orderByComparator)
		throws NoSuchTravelUserException {

		TravelUser travelUser = fetchByfindByDistricAndAreat_First(
			district, area, orderByComparator);

		if (travelUser != null) {
			return travelUser;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("district=");
		sb.append(district);

		sb.append(", area=");
		sb.append(area);

		sb.append("}");

		throw new NoSuchTravelUserException(sb.toString());
	}

	/**
	 * Returns the first travel user in the ordered set where district = &#63; and area = &#63;.
	 *
	 * @param district the district
	 * @param area the area
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching travel user, or <code>null</code> if a matching travel user could not be found
	 */
	@Override
	public TravelUser fetchByfindByDistricAndAreat_First(
		long district, String area,
		OrderByComparator<TravelUser> orderByComparator) {

		List<TravelUser> list = findByfindByDistricAndAreat(
			district, area, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public TravelUser findByfindByDistricAndAreat_Last(
			long district, String area,
			OrderByComparator<TravelUser> orderByComparator)
		throws NoSuchTravelUserException {

		TravelUser travelUser = fetchByfindByDistricAndAreat_Last(
			district, area, orderByComparator);

		if (travelUser != null) {
			return travelUser;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("district=");
		sb.append(district);

		sb.append(", area=");
		sb.append(area);

		sb.append("}");

		throw new NoSuchTravelUserException(sb.toString());
	}

	/**
	 * Returns the last travel user in the ordered set where district = &#63; and area = &#63;.
	 *
	 * @param district the district
	 * @param area the area
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching travel user, or <code>null</code> if a matching travel user could not be found
	 */
	@Override
	public TravelUser fetchByfindByDistricAndAreat_Last(
		long district, String area,
		OrderByComparator<TravelUser> orderByComparator) {

		int count = countByfindByDistricAndAreat(district, area);

		if (count == 0) {
			return null;
		}

		List<TravelUser> list = findByfindByDistricAndAreat(
			district, area, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public TravelUser[] findByfindByDistricAndAreat_PrevAndNext(
			long travelUserId, long district, String area,
			OrderByComparator<TravelUser> orderByComparator)
		throws NoSuchTravelUserException {

		area = Objects.toString(area, "");

		TravelUser travelUser = findByPrimaryKey(travelUserId);

		Session session = null;

		try {
			session = openSession();

			TravelUser[] array = new TravelUserImpl[3];

			array[0] = getByfindByDistricAndAreat_PrevAndNext(
				session, travelUser, district, area, orderByComparator, true);

			array[1] = travelUser;

			array[2] = getByfindByDistricAndAreat_PrevAndNext(
				session, travelUser, district, area, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected TravelUser getByfindByDistricAndAreat_PrevAndNext(
		Session session, TravelUser travelUser, long district, String area,
		OrderByComparator<TravelUser> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_TRAVELUSER_WHERE);

		sb.append(_FINDER_COLUMN_FINDBYDISTRICANDAREAT_DISTRICT_2);

		boolean bindArea = false;

		if (area.isEmpty()) {
			sb.append(_FINDER_COLUMN_FINDBYDISTRICANDAREAT_AREA_3);
		}
		else {
			bindArea = true;

			sb.append(_FINDER_COLUMN_FINDBYDISTRICANDAREAT_AREA_2);
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
			sb.append(TravelUserModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(district);

		if (bindArea) {
			queryPos.add(area);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(travelUser)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<TravelUser> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the travel users where district = &#63; and area = &#63; from the database.
	 *
	 * @param district the district
	 * @param area the area
	 */
	@Override
	public void removeByfindByDistricAndAreat(long district, String area) {
		for (TravelUser travelUser :
				findByfindByDistricAndAreat(
					district, area, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(travelUser);
		}
	}

	/**
	 * Returns the number of travel users where district = &#63; and area = &#63;.
	 *
	 * @param district the district
	 * @param area the area
	 * @return the number of matching travel users
	 */
	@Override
	public int countByfindByDistricAndAreat(long district, String area) {
		area = Objects.toString(area, "");

		FinderPath finderPath = _finderPathCountByfindByDistricAndAreat;

		Object[] finderArgs = new Object[] {district, area};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_TRAVELUSER_WHERE);

			sb.append(_FINDER_COLUMN_FINDBYDISTRICANDAREAT_DISTRICT_2);

			boolean bindArea = false;

			if (area.isEmpty()) {
				sb.append(_FINDER_COLUMN_FINDBYDISTRICANDAREAT_AREA_3);
			}
			else {
				bindArea = true;

				sb.append(_FINDER_COLUMN_FINDBYDISTRICANDAREAT_AREA_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(district);

				if (bindArea) {
					queryPos.add(area);
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

	private static final String
		_FINDER_COLUMN_FINDBYDISTRICANDAREAT_DISTRICT_2 =
			"travelUser.district = ? AND ";

	private static final String _FINDER_COLUMN_FINDBYDISTRICANDAREAT_AREA_2 =
		"travelUser.area = ?";

	private static final String _FINDER_COLUMN_FINDBYDISTRICANDAREAT_AREA_3 =
		"(travelUser.area IS NULL OR travelUser.area = '')";

	public TravelUserPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");
		dbColumnNames.put("state", "state_");

		setDBColumnNames(dbColumnNames);

		setModelClass(TravelUser.class);

		setModelImplClass(TravelUserImpl.class);
		setModelPKClass(long.class);

		setTable(TravelUserTable.INSTANCE);
	}

	/**
	 * Caches the travel user in the entity cache if it is enabled.
	 *
	 * @param travelUser the travel user
	 */
	@Override
	public void cacheResult(TravelUser travelUser) {
		entityCache.putResult(
			TravelUserImpl.class, travelUser.getPrimaryKey(), travelUser);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the travel users in the entity cache if it is enabled.
	 *
	 * @param travelUsers the travel users
	 */
	@Override
	public void cacheResult(List<TravelUser> travelUsers) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (travelUsers.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (TravelUser travelUser : travelUsers) {
			if (entityCache.getResult(
					TravelUserImpl.class, travelUser.getPrimaryKey()) == null) {

				cacheResult(travelUser);
			}
		}
	}

	/**
	 * Clears the cache for all travel users.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(TravelUserImpl.class);

		finderCache.clearCache(TravelUserImpl.class);
	}

	/**
	 * Clears the cache for the travel user.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(TravelUser travelUser) {
		entityCache.removeResult(TravelUserImpl.class, travelUser);
	}

	@Override
	public void clearCache(List<TravelUser> travelUsers) {
		for (TravelUser travelUser : travelUsers) {
			entityCache.removeResult(TravelUserImpl.class, travelUser);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(TravelUserImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(TravelUserImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new travel user with the primary key. Does not add the travel user to the database.
	 *
	 * @param travelUserId the primary key for the new travel user
	 * @return the new travel user
	 */
	@Override
	public TravelUser create(long travelUserId) {
		TravelUser travelUser = new TravelUserImpl();

		travelUser.setNew(true);
		travelUser.setPrimaryKey(travelUserId);

		String uuid = _portalUUID.generate();

		travelUser.setUuid(uuid);

		travelUser.setCompanyId(CompanyThreadLocal.getCompanyId());

		return travelUser;
	}

	/**
	 * Removes the travel user with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param travelUserId the primary key of the travel user
	 * @return the travel user that was removed
	 * @throws NoSuchTravelUserException if a travel user with the primary key could not be found
	 */
	@Override
	public TravelUser remove(long travelUserId)
		throws NoSuchTravelUserException {

		return remove((Serializable)travelUserId);
	}

	/**
	 * Removes the travel user with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the travel user
	 * @return the travel user that was removed
	 * @throws NoSuchTravelUserException if a travel user with the primary key could not be found
	 */
	@Override
	public TravelUser remove(Serializable primaryKey)
		throws NoSuchTravelUserException {

		Session session = null;

		try {
			session = openSession();

			TravelUser travelUser = (TravelUser)session.get(
				TravelUserImpl.class, primaryKey);

			if (travelUser == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchTravelUserException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(travelUser);
		}
		catch (NoSuchTravelUserException noSuchEntityException) {
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
	protected TravelUser removeImpl(TravelUser travelUser) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(travelUser)) {
				travelUser = (TravelUser)session.get(
					TravelUserImpl.class, travelUser.getPrimaryKeyObj());
			}

			if (travelUser != null) {
				session.delete(travelUser);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (travelUser != null) {
			clearCache(travelUser);
		}

		return travelUser;
	}

	@Override
	public TravelUser updateImpl(TravelUser travelUser) {
		boolean isNew = travelUser.isNew();

		if (!(travelUser instanceof TravelUserModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(travelUser.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(travelUser);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in travelUser proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom TravelUser implementation " +
					travelUser.getClass());
		}

		TravelUserModelImpl travelUserModelImpl =
			(TravelUserModelImpl)travelUser;

		if (Validator.isNull(travelUser.getUuid())) {
			String uuid = _portalUUID.generate();

			travelUser.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (travelUser.getCreateDate() == null)) {
			if (serviceContext == null) {
				travelUser.setCreateDate(date);
			}
			else {
				travelUser.setCreateDate(serviceContext.getCreateDate(date));
			}
		}

		if (!travelUserModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				travelUser.setModifiedDate(date);
			}
			else {
				travelUser.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(travelUser);
			}
			else {
				travelUser = (TravelUser)session.merge(travelUser);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			TravelUserImpl.class, travelUserModelImpl, false, true);

		if (isNew) {
			travelUser.setNew(false);
		}

		travelUser.resetOriginalValues();

		return travelUser;
	}

	/**
	 * Returns the travel user with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the travel user
	 * @return the travel user
	 * @throws NoSuchTravelUserException if a travel user with the primary key could not be found
	 */
	@Override
	public TravelUser findByPrimaryKey(Serializable primaryKey)
		throws NoSuchTravelUserException {

		TravelUser travelUser = fetchByPrimaryKey(primaryKey);

		if (travelUser == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchTravelUserException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return travelUser;
	}

	/**
	 * Returns the travel user with the primary key or throws a <code>NoSuchTravelUserException</code> if it could not be found.
	 *
	 * @param travelUserId the primary key of the travel user
	 * @return the travel user
	 * @throws NoSuchTravelUserException if a travel user with the primary key could not be found
	 */
	@Override
	public TravelUser findByPrimaryKey(long travelUserId)
		throws NoSuchTravelUserException {

		return findByPrimaryKey((Serializable)travelUserId);
	}

	/**
	 * Returns the travel user with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param travelUserId the primary key of the travel user
	 * @return the travel user, or <code>null</code> if a travel user with the primary key could not be found
	 */
	@Override
	public TravelUser fetchByPrimaryKey(long travelUserId) {
		return fetchByPrimaryKey((Serializable)travelUserId);
	}

	/**
	 * Returns all the travel users.
	 *
	 * @return the travel users
	 */
	@Override
	public List<TravelUser> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<TravelUser> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<TravelUser> findAll(
		int start, int end, OrderByComparator<TravelUser> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<TravelUser> findAll(
		int start, int end, OrderByComparator<TravelUser> orderByComparator,
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

		List<TravelUser> list = null;

		if (useFinderCache) {
			list = (List<TravelUser>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_TRAVELUSER);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_TRAVELUSER;

				sql = sql.concat(TravelUserModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<TravelUser>)QueryUtil.list(
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
	 * Removes all the travel users from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (TravelUser travelUser : findAll()) {
			remove(travelUser);
		}
	}

	/**
	 * Returns the number of travel users.
	 *
	 * @return the number of travel users
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_TRAVELUSER);

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
		return "travelUserId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_TRAVELUSER;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return TravelUserModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the travel user persistence.
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

		_finderPathWithPaginationFindByUuid_C = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"uuid_", "companyId"}, true);

		_finderPathWithoutPaginationFindByUuid_C = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "companyId"}, true);

		_finderPathCountByUuid_C = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "companyId"}, false);

		_finderPathWithPaginationFindByfindByTravelUserId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByfindByTravelUserId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"travelUserId"}, true);

		_finderPathWithoutPaginationFindByfindByTravelUserId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByfindByTravelUserId", new String[] {Long.class.getName()},
			new String[] {"travelUserId"}, true);

		_finderPathCountByfindByTravelUserId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByfindByTravelUserId", new String[] {Long.class.getName()},
			new String[] {"travelUserId"}, false);

		_finderPathWithPaginationFindByfindByTravelUserPhoneNumber =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
				"findByfindByTravelUserPhoneNumber",
				new String[] {
					String.class.getName(), Integer.class.getName(),
					Integer.class.getName(), OrderByComparator.class.getName()
				},
				new String[] {"travelUserPhoneNumber"}, true);

		_finderPathWithoutPaginationFindByfindByTravelUserPhoneNumber =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"findByfindByTravelUserPhoneNumber",
				new String[] {String.class.getName()},
				new String[] {"travelUserPhoneNumber"}, true);

		_finderPathCountByfindByTravelUserPhoneNumber = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByfindByTravelUserPhoneNumber",
			new String[] {String.class.getName()},
			new String[] {"travelUserPhoneNumber"}, false);

		_finderPathWithPaginationFindByfindByUserEmail = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByfindByUserEmail",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"travelUserEmail"}, true);

		_finderPathWithoutPaginationFindByfindByUserEmail = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByfindByUserEmail",
			new String[] {String.class.getName()},
			new String[] {"travelUserEmail"}, true);

		_finderPathCountByfindByUserEmail = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByfindByUserEmail",
			new String[] {String.class.getName()},
			new String[] {"travelUserEmail"}, false);

		_finderPathWithPaginationFindByFind_TravelUsers = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByFind_TravelUsers",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"userId", "companyId"}, true);

		_finderPathWithoutPaginationFindByFind_TravelUsers = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByFind_TravelUsers",
			new String[] {Long.class.getName(), Long.class.getName()},
			new String[] {"userId", "companyId"}, true);

		_finderPathCountByFind_TravelUsers = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByFind_TravelUsers",
			new String[] {Long.class.getName(), Long.class.getName()},
			new String[] {"userId", "companyId"}, false);

		_finderPathWithPaginationFindByUserId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUserId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"userId"}, true);

		_finderPathWithoutPaginationFindByUserId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUserId",
			new String[] {Long.class.getName()}, new String[] {"userId"}, true);

		_finderPathCountByUserId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUserId",
			new String[] {Long.class.getName()}, new String[] {"userId"},
			false);

		_finderPathWithPaginationFindByfindByArea = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByfindByArea",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"area"}, true);

		_finderPathWithoutPaginationFindByfindByArea = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByfindByArea",
			new String[] {String.class.getName()}, new String[] {"area"}, true);

		_finderPathCountByfindByArea = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByfindByArea",
			new String[] {String.class.getName()}, new String[] {"area"},
			false);

		_finderPathWithPaginationFindByfindByDistrict = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByfindByDistrict",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"district"}, true);

		_finderPathWithoutPaginationFindByfindByDistrict = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByfindByDistrict",
			new String[] {Long.class.getName()}, new String[] {"district"},
			true);

		_finderPathCountByfindByDistrict = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByfindByDistrict",
			new String[] {Long.class.getName()}, new String[] {"district"},
			false);

		_finderPathWithPaginationFindByfindByDistricAndAreat = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByfindByDistricAndAreat",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"district", "area"}, true);

		_finderPathWithoutPaginationFindByfindByDistricAndAreat =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"findByfindByDistricAndAreat",
				new String[] {Long.class.getName(), String.class.getName()},
				new String[] {"district", "area"}, true);

		_finderPathCountByfindByDistricAndAreat = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByfindByDistricAndAreat",
			new String[] {Long.class.getName(), String.class.getName()},
			new String[] {"district", "area"}, false);

		_setTravelUserUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setTravelUserUtilPersistence(null);

		entityCache.removeCache(TravelUserImpl.class.getName());
	}

	private void _setTravelUserUtilPersistence(
		TravelUserPersistence travelUserPersistence) {

		try {
			Field field = TravelUserUtil.class.getDeclaredField("_persistence");

			field.setAccessible(true);

			field.set(null, travelUserPersistence);
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

	private static final String _SQL_SELECT_TRAVELUSER =
		"SELECT travelUser FROM TravelUser travelUser";

	private static final String _SQL_SELECT_TRAVELUSER_WHERE =
		"SELECT travelUser FROM TravelUser travelUser WHERE ";

	private static final String _SQL_COUNT_TRAVELUSER =
		"SELECT COUNT(travelUser) FROM TravelUser travelUser";

	private static final String _SQL_COUNT_TRAVELUSER_WHERE =
		"SELECT COUNT(travelUser) FROM TravelUser travelUser WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "travelUser.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No TravelUser exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No TravelUser exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		TravelUserPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid", "state"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private PortalUUID _portalUUID;

}