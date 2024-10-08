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

package ummat.travel.webservice.model.impl;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;
import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringUtil;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.sql.Blob;
import java.sql.Types;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.BiConsumer;
import java.util.function.Function;

import ummat.travel.webservice.model.TravelUser;
import ummat.travel.webservice.model.TravelUserModel;

/**
 * The base model implementation for the TravelUser service. Represents a row in the &quot;UMMATLife_TravelUser&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>TravelUserModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link TravelUserImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TravelUserImpl
 * @generated
 */
@JSON(strict = true)
public class TravelUserModelImpl
	extends BaseModelImpl<TravelUser> implements TravelUserModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a travel user model instance should use the <code>TravelUser</code> interface instead.
	 */
	public static final String TABLE_NAME = "UMMATLife_TravelUser";

	public static final Object[][] TABLE_COLUMNS = {
		{"uuid_", Types.VARCHAR}, {"travelUserId", Types.BIGINT},
		{"userId", Types.BIGINT}, {"companyId", Types.BIGINT},
		{"travelUserName", Types.VARCHAR}, {"travelUserEmail", Types.VARCHAR},
		{"travelUserPhoneNumber", Types.VARCHAR},
		{"travelUserGender", Types.VARCHAR},
		{"travelUserAddress", Types.VARCHAR},
		{"travelUserProfile", Types.VARCHAR},
		{"travelUserPassword", Types.VARCHAR}, {"country", Types.BIGINT},
		{"state_", Types.VARCHAR}, {"district", Types.BIGINT},
		{"area", Types.VARCHAR}, {"pincode", Types.BIGINT},
		{"createDate", Types.TIMESTAMP}, {"modifiedDate", Types.TIMESTAMP}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("travelUserId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("travelUserName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("travelUserEmail", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("travelUserPhoneNumber", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("travelUserGender", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("travelUserAddress", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("travelUserProfile", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("travelUserPassword", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("country", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("state_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("district", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("area", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("pincode", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
	}

	public static final String TABLE_SQL_CREATE =
		"create table UMMATLife_TravelUser (uuid_ VARCHAR(75) null,travelUserId LONG not null primary key,userId LONG,companyId LONG,travelUserName VARCHAR(75) null,travelUserEmail VARCHAR(75) null,travelUserPhoneNumber VARCHAR(75) null,travelUserGender VARCHAR(75) null,travelUserAddress VARCHAR(75) null,travelUserProfile VARCHAR(75) null,travelUserPassword VARCHAR(75) null,country LONG,state_ VARCHAR(75) null,district LONG,area VARCHAR(75) null,pincode LONG,createDate DATE null,modifiedDate DATE null)";

	public static final String TABLE_SQL_DROP =
		"drop table UMMATLife_TravelUser";

	public static final String ORDER_BY_JPQL =
		" ORDER BY travelUser.travelUserId ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY UMMATLife_TravelUser.travelUserId ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long AREA_COLUMN_BITMASK = 1L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long COMPANYID_COLUMN_BITMASK = 2L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long DISTRICT_COLUMN_BITMASK = 4L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long TRAVELUSEREMAIL_COLUMN_BITMASK = 8L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long TRAVELUSERID_COLUMN_BITMASK = 16L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long TRAVELUSERPHONENUMBER_COLUMN_BITMASK = 32L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long USERID_COLUMN_BITMASK = 64L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long UUID_COLUMN_BITMASK = 128L;

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static void setEntityCacheEnabled(boolean entityCacheEnabled) {
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static void setFinderCacheEnabled(boolean finderCacheEnabled) {
	}

	public TravelUserModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _travelUserId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setTravelUserId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _travelUserId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return TravelUser.class;
	}

	@Override
	public String getModelClassName() {
		return TravelUser.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<TravelUser, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<TravelUser, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<TravelUser, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName, attributeGetterFunction.apply((TravelUser)this));
		}

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<TravelUser, Object>> attributeSetterBiConsumers =
			getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<TravelUser, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(TravelUser)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<TravelUser, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<TravelUser, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static final Map<String, Function<TravelUser, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<TravelUser, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<TravelUser, Object>> attributeGetterFunctions =
			new LinkedHashMap<String, Function<TravelUser, Object>>();
		Map<String, BiConsumer<TravelUser, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<TravelUser, ?>>();

		attributeGetterFunctions.put("uuid", TravelUser::getUuid);
		attributeSetterBiConsumers.put(
			"uuid", (BiConsumer<TravelUser, String>)TravelUser::setUuid);
		attributeGetterFunctions.put(
			"travelUserId", TravelUser::getTravelUserId);
		attributeSetterBiConsumers.put(
			"travelUserId",
			(BiConsumer<TravelUser, Long>)TravelUser::setTravelUserId);
		attributeGetterFunctions.put("userId", TravelUser::getUserId);
		attributeSetterBiConsumers.put(
			"userId", (BiConsumer<TravelUser, Long>)TravelUser::setUserId);
		attributeGetterFunctions.put("companyId", TravelUser::getCompanyId);
		attributeSetterBiConsumers.put(
			"companyId",
			(BiConsumer<TravelUser, Long>)TravelUser::setCompanyId);
		attributeGetterFunctions.put(
			"travelUserName", TravelUser::getTravelUserName);
		attributeSetterBiConsumers.put(
			"travelUserName",
			(BiConsumer<TravelUser, String>)TravelUser::setTravelUserName);
		attributeGetterFunctions.put(
			"travelUserEmail", TravelUser::getTravelUserEmail);
		attributeSetterBiConsumers.put(
			"travelUserEmail",
			(BiConsumer<TravelUser, String>)TravelUser::setTravelUserEmail);
		attributeGetterFunctions.put(
			"travelUserPhoneNumber", TravelUser::getTravelUserPhoneNumber);
		attributeSetterBiConsumers.put(
			"travelUserPhoneNumber",
			(BiConsumer<TravelUser, String>)
				TravelUser::setTravelUserPhoneNumber);
		attributeGetterFunctions.put(
			"travelUserGender", TravelUser::getTravelUserGender);
		attributeSetterBiConsumers.put(
			"travelUserGender",
			(BiConsumer<TravelUser, String>)TravelUser::setTravelUserGender);
		attributeGetterFunctions.put(
			"travelUserAddress", TravelUser::getTravelUserAddress);
		attributeSetterBiConsumers.put(
			"travelUserAddress",
			(BiConsumer<TravelUser, String>)TravelUser::setTravelUserAddress);
		attributeGetterFunctions.put(
			"travelUserProfile", TravelUser::getTravelUserProfile);
		attributeSetterBiConsumers.put(
			"travelUserProfile",
			(BiConsumer<TravelUser, String>)TravelUser::setTravelUserProfile);
		attributeGetterFunctions.put(
			"travelUserPassword", TravelUser::getTravelUserPassword);
		attributeSetterBiConsumers.put(
			"travelUserPassword",
			(BiConsumer<TravelUser, String>)TravelUser::setTravelUserPassword);
		attributeGetterFunctions.put("country", TravelUser::getCountry);
		attributeSetterBiConsumers.put(
			"country", (BiConsumer<TravelUser, Long>)TravelUser::setCountry);
		attributeGetterFunctions.put("state", TravelUser::getState);
		attributeSetterBiConsumers.put(
			"state", (BiConsumer<TravelUser, String>)TravelUser::setState);
		attributeGetterFunctions.put("district", TravelUser::getDistrict);
		attributeSetterBiConsumers.put(
			"district", (BiConsumer<TravelUser, Long>)TravelUser::setDistrict);
		attributeGetterFunctions.put("area", TravelUser::getArea);
		attributeSetterBiConsumers.put(
			"area", (BiConsumer<TravelUser, String>)TravelUser::setArea);
		attributeGetterFunctions.put("pincode", TravelUser::getPincode);
		attributeSetterBiConsumers.put(
			"pincode", (BiConsumer<TravelUser, Long>)TravelUser::setPincode);
		attributeGetterFunctions.put("createDate", TravelUser::getCreateDate);
		attributeSetterBiConsumers.put(
			"createDate",
			(BiConsumer<TravelUser, Date>)TravelUser::setCreateDate);
		attributeGetterFunctions.put(
			"modifiedDate", TravelUser::getModifiedDate);
		attributeSetterBiConsumers.put(
			"modifiedDate",
			(BiConsumer<TravelUser, Date>)TravelUser::setModifiedDate);

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@JSON
	@Override
	public String getUuid() {
		if (_uuid == null) {
			return "";
		}
		else {
			return _uuid;
		}
	}

	@Override
	public void setUuid(String uuid) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_uuid = uuid;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public String getOriginalUuid() {
		return getColumnOriginalValue("uuid_");
	}

	@JSON
	@Override
	public long getTravelUserId() {
		return _travelUserId;
	}

	@Override
	public void setTravelUserId(long travelUserId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_travelUserId = travelUserId;
	}

	@Override
	public String getTravelUserUuid() {
		try {
			User user = UserLocalServiceUtil.getUserById(getTravelUserId());

			return user.getUuid();
		}
		catch (PortalException portalException) {
			return "";
		}
	}

	@Override
	public void setTravelUserUuid(String travelUserUuid) {
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalTravelUserId() {
		return GetterUtil.getLong(
			this.<Long>getColumnOriginalValue("travelUserId"));
	}

	@JSON
	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_userId = userId;
	}

	@Override
	public String getUserUuid() {
		try {
			User user = UserLocalServiceUtil.getUserById(getUserId());

			return user.getUuid();
		}
		catch (PortalException portalException) {
			return "";
		}
	}

	@Override
	public void setUserUuid(String userUuid) {
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalUserId() {
		return GetterUtil.getLong(this.<Long>getColumnOriginalValue("userId"));
	}

	@JSON
	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_companyId = companyId;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalCompanyId() {
		return GetterUtil.getLong(
			this.<Long>getColumnOriginalValue("companyId"));
	}

	@JSON
	@Override
	public String getTravelUserName() {
		if (_travelUserName == null) {
			return "";
		}
		else {
			return _travelUserName;
		}
	}

	@Override
	public void setTravelUserName(String travelUserName) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_travelUserName = travelUserName;
	}

	@JSON
	@Override
	public String getTravelUserEmail() {
		if (_travelUserEmail == null) {
			return "";
		}
		else {
			return _travelUserEmail;
		}
	}

	@Override
	public void setTravelUserEmail(String travelUserEmail) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_travelUserEmail = travelUserEmail;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public String getOriginalTravelUserEmail() {
		return getColumnOriginalValue("travelUserEmail");
	}

	@JSON
	@Override
	public String getTravelUserPhoneNumber() {
		if (_travelUserPhoneNumber == null) {
			return "";
		}
		else {
			return _travelUserPhoneNumber;
		}
	}

	@Override
	public void setTravelUserPhoneNumber(String travelUserPhoneNumber) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_travelUserPhoneNumber = travelUserPhoneNumber;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public String getOriginalTravelUserPhoneNumber() {
		return getColumnOriginalValue("travelUserPhoneNumber");
	}

	@JSON
	@Override
	public String getTravelUserGender() {
		if (_travelUserGender == null) {
			return "";
		}
		else {
			return _travelUserGender;
		}
	}

	@Override
	public void setTravelUserGender(String travelUserGender) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_travelUserGender = travelUserGender;
	}

	@JSON
	@Override
	public String getTravelUserAddress() {
		if (_travelUserAddress == null) {
			return "";
		}
		else {
			return _travelUserAddress;
		}
	}

	@Override
	public void setTravelUserAddress(String travelUserAddress) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_travelUserAddress = travelUserAddress;
	}

	@JSON
	@Override
	public String getTravelUserProfile() {
		if (_travelUserProfile == null) {
			return "";
		}
		else {
			return _travelUserProfile;
		}
	}

	@Override
	public void setTravelUserProfile(String travelUserProfile) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_travelUserProfile = travelUserProfile;
	}

	@JSON
	@Override
	public String getTravelUserPassword() {
		if (_travelUserPassword == null) {
			return "";
		}
		else {
			return _travelUserPassword;
		}
	}

	@Override
	public void setTravelUserPassword(String travelUserPassword) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_travelUserPassword = travelUserPassword;
	}

	@JSON
	@Override
	public long getCountry() {
		return _country;
	}

	@Override
	public void setCountry(long country) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_country = country;
	}

	@JSON
	@Override
	public String getState() {
		if (_state == null) {
			return "";
		}
		else {
			return _state;
		}
	}

	@Override
	public void setState(String state) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_state = state;
	}

	@JSON
	@Override
	public long getDistrict() {
		return _district;
	}

	@Override
	public void setDistrict(long district) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_district = district;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalDistrict() {
		return GetterUtil.getLong(
			this.<Long>getColumnOriginalValue("district"));
	}

	@JSON
	@Override
	public String getArea() {
		if (_area == null) {
			return "";
		}
		else {
			return _area;
		}
	}

	@Override
	public void setArea(String area) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_area = area;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public String getOriginalArea() {
		return getColumnOriginalValue("area");
	}

	@JSON
	@Override
	public long getPincode() {
		return _pincode;
	}

	@Override
	public void setPincode(long pincode) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_pincode = pincode;
	}

	@JSON
	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_createDate = createDate;
	}

	@JSON
	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public boolean hasSetModifiedDate() {
		return _setModifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_setModifiedDate = true;

		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_modifiedDate = modifiedDate;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(
			PortalUtil.getClassNameId(TravelUser.class.getName()));
	}

	public long getColumnBitmask() {
		if (_columnBitmask > 0) {
			return _columnBitmask;
		}

		if ((_columnOriginalValues == null) ||
			(_columnOriginalValues == Collections.EMPTY_MAP)) {

			return 0;
		}

		for (Map.Entry<String, Object> entry :
				_columnOriginalValues.entrySet()) {

			if (!Objects.equals(
					entry.getValue(), getColumnValue(entry.getKey()))) {

				_columnBitmask |= _columnBitmasks.get(entry.getKey());
			}
		}

		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(
			getCompanyId(), TravelUser.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public TravelUser toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, TravelUser>
				escapedModelProxyProviderFunction =
					EscapedModelProxyProviderFunctionHolder.
						_escapedModelProxyProviderFunction;

			_escapedModel = escapedModelProxyProviderFunction.apply(
				new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		TravelUserImpl travelUserImpl = new TravelUserImpl();

		travelUserImpl.setUuid(getUuid());
		travelUserImpl.setTravelUserId(getTravelUserId());
		travelUserImpl.setUserId(getUserId());
		travelUserImpl.setCompanyId(getCompanyId());
		travelUserImpl.setTravelUserName(getTravelUserName());
		travelUserImpl.setTravelUserEmail(getTravelUserEmail());
		travelUserImpl.setTravelUserPhoneNumber(getTravelUserPhoneNumber());
		travelUserImpl.setTravelUserGender(getTravelUserGender());
		travelUserImpl.setTravelUserAddress(getTravelUserAddress());
		travelUserImpl.setTravelUserProfile(getTravelUserProfile());
		travelUserImpl.setTravelUserPassword(getTravelUserPassword());
		travelUserImpl.setCountry(getCountry());
		travelUserImpl.setState(getState());
		travelUserImpl.setDistrict(getDistrict());
		travelUserImpl.setArea(getArea());
		travelUserImpl.setPincode(getPincode());
		travelUserImpl.setCreateDate(getCreateDate());
		travelUserImpl.setModifiedDate(getModifiedDate());

		travelUserImpl.resetOriginalValues();

		return travelUserImpl;
	}

	@Override
	public TravelUser cloneWithOriginalValues() {
		TravelUserImpl travelUserImpl = new TravelUserImpl();

		travelUserImpl.setUuid(this.<String>getColumnOriginalValue("uuid_"));
		travelUserImpl.setTravelUserId(
			this.<Long>getColumnOriginalValue("travelUserId"));
		travelUserImpl.setUserId(this.<Long>getColumnOriginalValue("userId"));
		travelUserImpl.setCompanyId(
			this.<Long>getColumnOriginalValue("companyId"));
		travelUserImpl.setTravelUserName(
			this.<String>getColumnOriginalValue("travelUserName"));
		travelUserImpl.setTravelUserEmail(
			this.<String>getColumnOriginalValue("travelUserEmail"));
		travelUserImpl.setTravelUserPhoneNumber(
			this.<String>getColumnOriginalValue("travelUserPhoneNumber"));
		travelUserImpl.setTravelUserGender(
			this.<String>getColumnOriginalValue("travelUserGender"));
		travelUserImpl.setTravelUserAddress(
			this.<String>getColumnOriginalValue("travelUserAddress"));
		travelUserImpl.setTravelUserProfile(
			this.<String>getColumnOriginalValue("travelUserProfile"));
		travelUserImpl.setTravelUserPassword(
			this.<String>getColumnOriginalValue("travelUserPassword"));
		travelUserImpl.setCountry(this.<Long>getColumnOriginalValue("country"));
		travelUserImpl.setState(this.<String>getColumnOriginalValue("state_"));
		travelUserImpl.setDistrict(
			this.<Long>getColumnOriginalValue("district"));
		travelUserImpl.setArea(this.<String>getColumnOriginalValue("area"));
		travelUserImpl.setPincode(this.<Long>getColumnOriginalValue("pincode"));
		travelUserImpl.setCreateDate(
			this.<Date>getColumnOriginalValue("createDate"));
		travelUserImpl.setModifiedDate(
			this.<Date>getColumnOriginalValue("modifiedDate"));

		return travelUserImpl;
	}

	@Override
	public int compareTo(TravelUser travelUser) {
		long primaryKey = travelUser.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof TravelUser)) {
			return false;
		}

		TravelUser travelUser = (TravelUser)object;

		long primaryKey = travelUser.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	@Override
	public boolean isEntityCacheEnabled() {
		return true;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	@Override
	public boolean isFinderCacheEnabled() {
		return true;
	}

	@Override
	public void resetOriginalValues() {
		_columnOriginalValues = Collections.emptyMap();

		_setModifiedDate = false;

		_columnBitmask = 0;
	}

	@Override
	public CacheModel<TravelUser> toCacheModel() {
		TravelUserCacheModel travelUserCacheModel = new TravelUserCacheModel();

		travelUserCacheModel.uuid = getUuid();

		String uuid = travelUserCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			travelUserCacheModel.uuid = null;
		}

		travelUserCacheModel.travelUserId = getTravelUserId();

		travelUserCacheModel.userId = getUserId();

		travelUserCacheModel.companyId = getCompanyId();

		travelUserCacheModel.travelUserName = getTravelUserName();

		String travelUserName = travelUserCacheModel.travelUserName;

		if ((travelUserName != null) && (travelUserName.length() == 0)) {
			travelUserCacheModel.travelUserName = null;
		}

		travelUserCacheModel.travelUserEmail = getTravelUserEmail();

		String travelUserEmail = travelUserCacheModel.travelUserEmail;

		if ((travelUserEmail != null) && (travelUserEmail.length() == 0)) {
			travelUserCacheModel.travelUserEmail = null;
		}

		travelUserCacheModel.travelUserPhoneNumber = getTravelUserPhoneNumber();

		String travelUserPhoneNumber =
			travelUserCacheModel.travelUserPhoneNumber;

		if ((travelUserPhoneNumber != null) &&
			(travelUserPhoneNumber.length() == 0)) {

			travelUserCacheModel.travelUserPhoneNumber = null;
		}

		travelUserCacheModel.travelUserGender = getTravelUserGender();

		String travelUserGender = travelUserCacheModel.travelUserGender;

		if ((travelUserGender != null) && (travelUserGender.length() == 0)) {
			travelUserCacheModel.travelUserGender = null;
		}

		travelUserCacheModel.travelUserAddress = getTravelUserAddress();

		String travelUserAddress = travelUserCacheModel.travelUserAddress;

		if ((travelUserAddress != null) && (travelUserAddress.length() == 0)) {
			travelUserCacheModel.travelUserAddress = null;
		}

		travelUserCacheModel.travelUserProfile = getTravelUserProfile();

		String travelUserProfile = travelUserCacheModel.travelUserProfile;

		if ((travelUserProfile != null) && (travelUserProfile.length() == 0)) {
			travelUserCacheModel.travelUserProfile = null;
		}

		travelUserCacheModel.travelUserPassword = getTravelUserPassword();

		String travelUserPassword = travelUserCacheModel.travelUserPassword;

		if ((travelUserPassword != null) &&
			(travelUserPassword.length() == 0)) {

			travelUserCacheModel.travelUserPassword = null;
		}

		travelUserCacheModel.country = getCountry();

		travelUserCacheModel.state = getState();

		String state = travelUserCacheModel.state;

		if ((state != null) && (state.length() == 0)) {
			travelUserCacheModel.state = null;
		}

		travelUserCacheModel.district = getDistrict();

		travelUserCacheModel.area = getArea();

		String area = travelUserCacheModel.area;

		if ((area != null) && (area.length() == 0)) {
			travelUserCacheModel.area = null;
		}

		travelUserCacheModel.pincode = getPincode();

		Date createDate = getCreateDate();

		if (createDate != null) {
			travelUserCacheModel.createDate = createDate.getTime();
		}
		else {
			travelUserCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			travelUserCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			travelUserCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		return travelUserCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<TravelUser, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 2);

		sb.append("{");

		for (Map.Entry<String, Function<TravelUser, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<TravelUser, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("\"");
			sb.append(attributeName);
			sb.append("\": ");

			Object value = attributeGetterFunction.apply((TravelUser)this);

			if (value == null) {
				sb.append("null");
			}
			else if (value instanceof Blob || value instanceof Date ||
					 value instanceof Map || value instanceof String) {

				sb.append(
					"\"" + StringUtil.replace(value.toString(), "\"", "'") +
						"\"");
			}
			else {
				sb.append(value);
			}

			sb.append(", ");
		}

		if (sb.index() > 1) {
			sb.setIndex(sb.index() - 1);
		}

		sb.append("}");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, TravelUser>
			_escapedModelProxyProviderFunction =
				ProxyUtil.getProxyProviderFunction(
					TravelUser.class, ModelWrapper.class);

	}

	private String _uuid;
	private long _travelUserId;
	private long _userId;
	private long _companyId;
	private String _travelUserName;
	private String _travelUserEmail;
	private String _travelUserPhoneNumber;
	private String _travelUserGender;
	private String _travelUserAddress;
	private String _travelUserProfile;
	private String _travelUserPassword;
	private long _country;
	private String _state;
	private long _district;
	private String _area;
	private long _pincode;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;

	public <T> T getColumnValue(String columnName) {
		columnName = _attributeNames.getOrDefault(columnName, columnName);

		Function<TravelUser, Object> function = _attributeGetterFunctions.get(
			columnName);

		if (function == null) {
			throw new IllegalArgumentException(
				"No attribute getter function found for " + columnName);
		}

		return (T)function.apply((TravelUser)this);
	}

	public <T> T getColumnOriginalValue(String columnName) {
		if (_columnOriginalValues == null) {
			return null;
		}

		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		return (T)_columnOriginalValues.get(columnName);
	}

	private void _setColumnOriginalValues() {
		_columnOriginalValues = new HashMap<String, Object>();

		_columnOriginalValues.put("uuid_", _uuid);
		_columnOriginalValues.put("travelUserId", _travelUserId);
		_columnOriginalValues.put("userId", _userId);
		_columnOriginalValues.put("companyId", _companyId);
		_columnOriginalValues.put("travelUserName", _travelUserName);
		_columnOriginalValues.put("travelUserEmail", _travelUserEmail);
		_columnOriginalValues.put(
			"travelUserPhoneNumber", _travelUserPhoneNumber);
		_columnOriginalValues.put("travelUserGender", _travelUserGender);
		_columnOriginalValues.put("travelUserAddress", _travelUserAddress);
		_columnOriginalValues.put("travelUserProfile", _travelUserProfile);
		_columnOriginalValues.put("travelUserPassword", _travelUserPassword);
		_columnOriginalValues.put("country", _country);
		_columnOriginalValues.put("state_", _state);
		_columnOriginalValues.put("district", _district);
		_columnOriginalValues.put("area", _area);
		_columnOriginalValues.put("pincode", _pincode);
		_columnOriginalValues.put("createDate", _createDate);
		_columnOriginalValues.put("modifiedDate", _modifiedDate);
	}

	private static final Map<String, String> _attributeNames;

	static {
		Map<String, String> attributeNames = new HashMap<>();

		attributeNames.put("uuid_", "uuid");
		attributeNames.put("state_", "state");

		_attributeNames = Collections.unmodifiableMap(attributeNames);
	}

	private transient Map<String, Object> _columnOriginalValues;

	public static long getColumnBitmask(String columnName) {
		return _columnBitmasks.get(columnName);
	}

	private static final Map<String, Long> _columnBitmasks;

	static {
		Map<String, Long> columnBitmasks = new HashMap<>();

		columnBitmasks.put("uuid_", 1L);

		columnBitmasks.put("travelUserId", 2L);

		columnBitmasks.put("userId", 4L);

		columnBitmasks.put("companyId", 8L);

		columnBitmasks.put("travelUserName", 16L);

		columnBitmasks.put("travelUserEmail", 32L);

		columnBitmasks.put("travelUserPhoneNumber", 64L);

		columnBitmasks.put("travelUserGender", 128L);

		columnBitmasks.put("travelUserAddress", 256L);

		columnBitmasks.put("travelUserProfile", 512L);

		columnBitmasks.put("travelUserPassword", 1024L);

		columnBitmasks.put("country", 2048L);

		columnBitmasks.put("state_", 4096L);

		columnBitmasks.put("district", 8192L);

		columnBitmasks.put("area", 16384L);

		columnBitmasks.put("pincode", 32768L);

		columnBitmasks.put("createDate", 65536L);

		columnBitmasks.put("modifiedDate", 131072L);

		_columnBitmasks = Collections.unmodifiableMap(columnBitmasks);
	}

	private long _columnBitmask;
	private TravelUser _escapedModel;

}