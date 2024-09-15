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

package com.ummat.slayer.model;

import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Locality}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Locality
 * @generated
 */
public class LocalityWrapper
	extends BaseModelWrapper<Locality>
	implements Locality, ModelWrapper<Locality> {

	public LocalityWrapper(Locality locality) {
		super(locality);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("localityId", getLocalityId());
		attributes.put("regionId", getRegionId());
		attributes.put("districtId", getDistrictId());
		attributes.put("name", getName());
		attributes.put("active", isActive());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long localityId = (Long)attributes.get("localityId");

		if (localityId != null) {
			setLocalityId(localityId);
		}

		Long regionId = (Long)attributes.get("regionId");

		if (regionId != null) {
			setRegionId(regionId);
		}

		Long districtId = (Long)attributes.get("districtId");

		if (districtId != null) {
			setDistrictId(districtId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		Boolean active = (Boolean)attributes.get("active");

		if (active != null) {
			setActive(active);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}
	}

	@Override
	public Locality cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the active of this locality.
	 *
	 * @return the active of this locality
	 */
	@Override
	public boolean getActive() {
		return model.getActive();
	}

	/**
	 * Returns the company ID of this locality.
	 *
	 * @return the company ID of this locality
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this locality.
	 *
	 * @return the create date of this locality
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the district ID of this locality.
	 *
	 * @return the district ID of this locality
	 */
	@Override
	public long getDistrictId() {
		return model.getDistrictId();
	}

	/**
	 * Returns the locality ID of this locality.
	 *
	 * @return the locality ID of this locality
	 */
	@Override
	public long getLocalityId() {
		return model.getLocalityId();
	}

	/**
	 * Returns the modified date of this locality.
	 *
	 * @return the modified date of this locality
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the name of this locality.
	 *
	 * @return the name of this locality
	 */
	@Override
	public String getName() {
		return model.getName();
	}

	/**
	 * Returns the primary key of this locality.
	 *
	 * @return the primary key of this locality
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the region ID of this locality.
	 *
	 * @return the region ID of this locality
	 */
	@Override
	public long getRegionId() {
		return model.getRegionId();
	}

	/**
	 * Returns the user ID of this locality.
	 *
	 * @return the user ID of this locality
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user uuid of this locality.
	 *
	 * @return the user uuid of this locality
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this locality.
	 *
	 * @return the uuid of this locality
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Returns <code>true</code> if this locality is active.
	 *
	 * @return <code>true</code> if this locality is active; <code>false</code> otherwise
	 */
	@Override
	public boolean isActive() {
		return model.isActive();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets whether this locality is active.
	 *
	 * @param active the active of this locality
	 */
	@Override
	public void setActive(boolean active) {
		model.setActive(active);
	}

	/**
	 * Sets the company ID of this locality.
	 *
	 * @param companyId the company ID of this locality
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this locality.
	 *
	 * @param createDate the create date of this locality
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the district ID of this locality.
	 *
	 * @param districtId the district ID of this locality
	 */
	@Override
	public void setDistrictId(long districtId) {
		model.setDistrictId(districtId);
	}

	/**
	 * Sets the locality ID of this locality.
	 *
	 * @param localityId the locality ID of this locality
	 */
	@Override
	public void setLocalityId(long localityId) {
		model.setLocalityId(localityId);
	}

	/**
	 * Sets the modified date of this locality.
	 *
	 * @param modifiedDate the modified date of this locality
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the name of this locality.
	 *
	 * @param name the name of this locality
	 */
	@Override
	public void setName(String name) {
		model.setName(name);
	}

	/**
	 * Sets the primary key of this locality.
	 *
	 * @param primaryKey the primary key of this locality
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the region ID of this locality.
	 *
	 * @param regionId the region ID of this locality
	 */
	@Override
	public void setRegionId(long regionId) {
		model.setRegionId(regionId);
	}

	/**
	 * Sets the user ID of this locality.
	 *
	 * @param userId the user ID of this locality
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user uuid of this locality.
	 *
	 * @param userUuid the user uuid of this locality
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this locality.
	 *
	 * @param uuid the uuid of this locality
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	@Override
	public String toXmlString() {
		return model.toXmlString();
	}

	@Override
	public StagedModelType getStagedModelType() {
		return model.getStagedModelType();
	}

	@Override
	protected LocalityWrapper wrap(Locality locality) {
		return new LocalityWrapper(locality);
	}

}