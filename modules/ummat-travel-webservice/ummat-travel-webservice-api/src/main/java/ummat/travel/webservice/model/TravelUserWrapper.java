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

package ummat.travel.webservice.model;

import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link TravelUser}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TravelUser
 * @generated
 */
public class TravelUserWrapper
	extends BaseModelWrapper<TravelUser>
	implements ModelWrapper<TravelUser>, TravelUser {

	public TravelUserWrapper(TravelUser travelUser) {
		super(travelUser);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("travelUserId", getTravelUserId());
		attributes.put("userId", getUserId());
		attributes.put("companyId", getCompanyId());
		attributes.put("travelUserName", getTravelUserName());
		attributes.put("travelUserEmail", getTravelUserEmail());
		attributes.put("travelUserPhoneNumber", getTravelUserPhoneNumber());
		attributes.put("travelUserGender", getTravelUserGender());
		attributes.put("travelUserAddress", getTravelUserAddress());
		attributes.put("travelUserProfile", getTravelUserProfile());
		attributes.put("travelUserPassword", getTravelUserPassword());
		attributes.put("country", getCountry());
		attributes.put("state", getState());
		attributes.put("district", getDistrict());
		attributes.put("area", getArea());
		attributes.put("pincode", getPincode());
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

		Long travelUserId = (Long)attributes.get("travelUserId");

		if (travelUserId != null) {
			setTravelUserId(travelUserId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		String travelUserName = (String)attributes.get("travelUserName");

		if (travelUserName != null) {
			setTravelUserName(travelUserName);
		}

		String travelUserEmail = (String)attributes.get("travelUserEmail");

		if (travelUserEmail != null) {
			setTravelUserEmail(travelUserEmail);
		}

		String travelUserPhoneNumber = (String)attributes.get(
			"travelUserPhoneNumber");

		if (travelUserPhoneNumber != null) {
			setTravelUserPhoneNumber(travelUserPhoneNumber);
		}

		String travelUserGender = (String)attributes.get("travelUserGender");

		if (travelUserGender != null) {
			setTravelUserGender(travelUserGender);
		}

		String travelUserAddress = (String)attributes.get("travelUserAddress");

		if (travelUserAddress != null) {
			setTravelUserAddress(travelUserAddress);
		}

		String travelUserProfile = (String)attributes.get("travelUserProfile");

		if (travelUserProfile != null) {
			setTravelUserProfile(travelUserProfile);
		}

		String travelUserPassword = (String)attributes.get(
			"travelUserPassword");

		if (travelUserPassword != null) {
			setTravelUserPassword(travelUserPassword);
		}

		Long country = (Long)attributes.get("country");

		if (country != null) {
			setCountry(country);
		}

		String state = (String)attributes.get("state");

		if (state != null) {
			setState(state);
		}

		Long district = (Long)attributes.get("district");

		if (district != null) {
			setDistrict(district);
		}

		String area = (String)attributes.get("area");

		if (area != null) {
			setArea(area);
		}

		Long pincode = (Long)attributes.get("pincode");

		if (pincode != null) {
			setPincode(pincode);
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
	public TravelUser cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the area of this travel user.
	 *
	 * @return the area of this travel user
	 */
	@Override
	public String getArea() {
		return model.getArea();
	}

	/**
	 * Returns the company ID of this travel user.
	 *
	 * @return the company ID of this travel user
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the country of this travel user.
	 *
	 * @return the country of this travel user
	 */
	@Override
	public long getCountry() {
		return model.getCountry();
	}

	/**
	 * Returns the create date of this travel user.
	 *
	 * @return the create date of this travel user
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the district of this travel user.
	 *
	 * @return the district of this travel user
	 */
	@Override
	public long getDistrict() {
		return model.getDistrict();
	}

	/**
	 * Returns the modified date of this travel user.
	 *
	 * @return the modified date of this travel user
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the pincode of this travel user.
	 *
	 * @return the pincode of this travel user
	 */
	@Override
	public long getPincode() {
		return model.getPincode();
	}

	/**
	 * Returns the primary key of this travel user.
	 *
	 * @return the primary key of this travel user
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the state of this travel user.
	 *
	 * @return the state of this travel user
	 */
	@Override
	public String getState() {
		return model.getState();
	}

	/**
	 * Returns the travel user address of this travel user.
	 *
	 * @return the travel user address of this travel user
	 */
	@Override
	public String getTravelUserAddress() {
		return model.getTravelUserAddress();
	}

	/**
	 * Returns the travel user email of this travel user.
	 *
	 * @return the travel user email of this travel user
	 */
	@Override
	public String getTravelUserEmail() {
		return model.getTravelUserEmail();
	}

	/**
	 * Returns the travel user gender of this travel user.
	 *
	 * @return the travel user gender of this travel user
	 */
	@Override
	public String getTravelUserGender() {
		return model.getTravelUserGender();
	}

	/**
	 * Returns the travel user ID of this travel user.
	 *
	 * @return the travel user ID of this travel user
	 */
	@Override
	public long getTravelUserId() {
		return model.getTravelUserId();
	}

	/**
	 * Returns the travel user name of this travel user.
	 *
	 * @return the travel user name of this travel user
	 */
	@Override
	public String getTravelUserName() {
		return model.getTravelUserName();
	}

	/**
	 * Returns the travel user password of this travel user.
	 *
	 * @return the travel user password of this travel user
	 */
	@Override
	public String getTravelUserPassword() {
		return model.getTravelUserPassword();
	}

	/**
	 * Returns the travel user phone number of this travel user.
	 *
	 * @return the travel user phone number of this travel user
	 */
	@Override
	public String getTravelUserPhoneNumber() {
		return model.getTravelUserPhoneNumber();
	}

	/**
	 * Returns the travel user profile of this travel user.
	 *
	 * @return the travel user profile of this travel user
	 */
	@Override
	public String getTravelUserProfile() {
		return model.getTravelUserProfile();
	}

	/**
	 * Returns the travel user uuid of this travel user.
	 *
	 * @return the travel user uuid of this travel user
	 */
	@Override
	public String getTravelUserUuid() {
		return model.getTravelUserUuid();
	}

	/**
	 * Returns the user ID of this travel user.
	 *
	 * @return the user ID of this travel user
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user uuid of this travel user.
	 *
	 * @return the user uuid of this travel user
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this travel user.
	 *
	 * @return the uuid of this travel user
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the area of this travel user.
	 *
	 * @param area the area of this travel user
	 */
	@Override
	public void setArea(String area) {
		model.setArea(area);
	}

	/**
	 * Sets the company ID of this travel user.
	 *
	 * @param companyId the company ID of this travel user
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the country of this travel user.
	 *
	 * @param country the country of this travel user
	 */
	@Override
	public void setCountry(long country) {
		model.setCountry(country);
	}

	/**
	 * Sets the create date of this travel user.
	 *
	 * @param createDate the create date of this travel user
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the district of this travel user.
	 *
	 * @param district the district of this travel user
	 */
	@Override
	public void setDistrict(long district) {
		model.setDistrict(district);
	}

	/**
	 * Sets the modified date of this travel user.
	 *
	 * @param modifiedDate the modified date of this travel user
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the pincode of this travel user.
	 *
	 * @param pincode the pincode of this travel user
	 */
	@Override
	public void setPincode(long pincode) {
		model.setPincode(pincode);
	}

	/**
	 * Sets the primary key of this travel user.
	 *
	 * @param primaryKey the primary key of this travel user
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the state of this travel user.
	 *
	 * @param state the state of this travel user
	 */
	@Override
	public void setState(String state) {
		model.setState(state);
	}

	/**
	 * Sets the travel user address of this travel user.
	 *
	 * @param travelUserAddress the travel user address of this travel user
	 */
	@Override
	public void setTravelUserAddress(String travelUserAddress) {
		model.setTravelUserAddress(travelUserAddress);
	}

	/**
	 * Sets the travel user email of this travel user.
	 *
	 * @param travelUserEmail the travel user email of this travel user
	 */
	@Override
	public void setTravelUserEmail(String travelUserEmail) {
		model.setTravelUserEmail(travelUserEmail);
	}

	/**
	 * Sets the travel user gender of this travel user.
	 *
	 * @param travelUserGender the travel user gender of this travel user
	 */
	@Override
	public void setTravelUserGender(String travelUserGender) {
		model.setTravelUserGender(travelUserGender);
	}

	/**
	 * Sets the travel user ID of this travel user.
	 *
	 * @param travelUserId the travel user ID of this travel user
	 */
	@Override
	public void setTravelUserId(long travelUserId) {
		model.setTravelUserId(travelUserId);
	}

	/**
	 * Sets the travel user name of this travel user.
	 *
	 * @param travelUserName the travel user name of this travel user
	 */
	@Override
	public void setTravelUserName(String travelUserName) {
		model.setTravelUserName(travelUserName);
	}

	/**
	 * Sets the travel user password of this travel user.
	 *
	 * @param travelUserPassword the travel user password of this travel user
	 */
	@Override
	public void setTravelUserPassword(String travelUserPassword) {
		model.setTravelUserPassword(travelUserPassword);
	}

	/**
	 * Sets the travel user phone number of this travel user.
	 *
	 * @param travelUserPhoneNumber the travel user phone number of this travel user
	 */
	@Override
	public void setTravelUserPhoneNumber(String travelUserPhoneNumber) {
		model.setTravelUserPhoneNumber(travelUserPhoneNumber);
	}

	/**
	 * Sets the travel user profile of this travel user.
	 *
	 * @param travelUserProfile the travel user profile of this travel user
	 */
	@Override
	public void setTravelUserProfile(String travelUserProfile) {
		model.setTravelUserProfile(travelUserProfile);
	}

	/**
	 * Sets the travel user uuid of this travel user.
	 *
	 * @param travelUserUuid the travel user uuid of this travel user
	 */
	@Override
	public void setTravelUserUuid(String travelUserUuid) {
		model.setTravelUserUuid(travelUserUuid);
	}

	/**
	 * Sets the user ID of this travel user.
	 *
	 * @param userId the user ID of this travel user
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user uuid of this travel user.
	 *
	 * @param userUuid the user uuid of this travel user
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this travel user.
	 *
	 * @param uuid the uuid of this travel user
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
	protected TravelUserWrapper wrap(TravelUser travelUser) {
		return new TravelUserWrapper(travelUser);
	}

}