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

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link DriverDetail}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DriverDetail
 * @generated
 */
public class DriverDetailWrapper
	extends BaseModelWrapper<DriverDetail>
	implements DriverDetail, ModelWrapper<DriverDetail> {

	public DriverDetailWrapper(DriverDetail driverDetail) {
		super(driverDetail);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("driverId", getDriverId());
		attributes.put("userId", getUserId());
		attributes.put("companyId", getCompanyId());
		attributes.put("driverName", getDriverName());
		attributes.put("age", getAge());
		attributes.put("Password", getPassword());
		attributes.put("mobileNumber", getMobileNumber());
		attributes.put("email", getEmail());
		attributes.put("gender", getGender());
		attributes.put("driverPhoto", getDriverPhoto());
		attributes.put("aadharNumber", getAadharNumber());
		attributes.put("drivingLicenceId", getDrivingLicenceId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long driverId = (Long)attributes.get("driverId");

		if (driverId != null) {
			setDriverId(driverId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		String driverName = (String)attributes.get("driverName");

		if (driverName != null) {
			setDriverName(driverName);
		}

		String age = (String)attributes.get("age");

		if (age != null) {
			setAge(age);
		}

		String Password = (String)attributes.get("Password");

		if (Password != null) {
			setPassword(Password);
		}

		String mobileNumber = (String)attributes.get("mobileNumber");

		if (mobileNumber != null) {
			setMobileNumber(mobileNumber);
		}

		String email = (String)attributes.get("email");

		if (email != null) {
			setEmail(email);
		}

		String gender = (String)attributes.get("gender");

		if (gender != null) {
			setGender(gender);
		}

		String driverPhoto = (String)attributes.get("driverPhoto");

		if (driverPhoto != null) {
			setDriverPhoto(driverPhoto);
		}

		String aadharNumber = (String)attributes.get("aadharNumber");

		if (aadharNumber != null) {
			setAadharNumber(aadharNumber);
		}

		String drivingLicenceId = (String)attributes.get("drivingLicenceId");

		if (drivingLicenceId != null) {
			setDrivingLicenceId(drivingLicenceId);
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
	public DriverDetail cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the aadhar number of this driver detail.
	 *
	 * @return the aadhar number of this driver detail
	 */
	@Override
	public String getAadharNumber() {
		return model.getAadharNumber();
	}

	/**
	 * Returns the age of this driver detail.
	 *
	 * @return the age of this driver detail
	 */
	@Override
	public String getAge() {
		return model.getAge();
	}

	/**
	 * Returns the company ID of this driver detail.
	 *
	 * @return the company ID of this driver detail
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this driver detail.
	 *
	 * @return the create date of this driver detail
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the driver ID of this driver detail.
	 *
	 * @return the driver ID of this driver detail
	 */
	@Override
	public long getDriverId() {
		return model.getDriverId();
	}

	/**
	 * Returns the driver name of this driver detail.
	 *
	 * @return the driver name of this driver detail
	 */
	@Override
	public String getDriverName() {
		return model.getDriverName();
	}

	/**
	 * Returns the driver photo of this driver detail.
	 *
	 * @return the driver photo of this driver detail
	 */
	@Override
	public String getDriverPhoto() {
		return model.getDriverPhoto();
	}

	/**
	 * Returns the driving licence ID of this driver detail.
	 *
	 * @return the driving licence ID of this driver detail
	 */
	@Override
	public String getDrivingLicenceId() {
		return model.getDrivingLicenceId();
	}

	/**
	 * Returns the email of this driver detail.
	 *
	 * @return the email of this driver detail
	 */
	@Override
	public String getEmail() {
		return model.getEmail();
	}

	/**
	 * Returns the gender of this driver detail.
	 *
	 * @return the gender of this driver detail
	 */
	@Override
	public String getGender() {
		return model.getGender();
	}

	/**
	 * Returns the mobile number of this driver detail.
	 *
	 * @return the mobile number of this driver detail
	 */
	@Override
	public String getMobileNumber() {
		return model.getMobileNumber();
	}

	/**
	 * Returns the modified date of this driver detail.
	 *
	 * @return the modified date of this driver detail
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the password of this driver detail.
	 *
	 * @return the password of this driver detail
	 */
	@Override
	public String getPassword() {
		return model.getPassword();
	}

	/**
	 * Returns the primary key of this driver detail.
	 *
	 * @return the primary key of this driver detail
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the user ID of this driver detail.
	 *
	 * @return the user ID of this driver detail
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user uuid of this driver detail.
	 *
	 * @return the user uuid of this driver detail
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the aadhar number of this driver detail.
	 *
	 * @param aadharNumber the aadhar number of this driver detail
	 */
	@Override
	public void setAadharNumber(String aadharNumber) {
		model.setAadharNumber(aadharNumber);
	}

	/**
	 * Sets the age of this driver detail.
	 *
	 * @param age the age of this driver detail
	 */
	@Override
	public void setAge(String age) {
		model.setAge(age);
	}

	/**
	 * Sets the company ID of this driver detail.
	 *
	 * @param companyId the company ID of this driver detail
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this driver detail.
	 *
	 * @param createDate the create date of this driver detail
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the driver ID of this driver detail.
	 *
	 * @param driverId the driver ID of this driver detail
	 */
	@Override
	public void setDriverId(long driverId) {
		model.setDriverId(driverId);
	}

	/**
	 * Sets the driver name of this driver detail.
	 *
	 * @param driverName the driver name of this driver detail
	 */
	@Override
	public void setDriverName(String driverName) {
		model.setDriverName(driverName);
	}

	/**
	 * Sets the driver photo of this driver detail.
	 *
	 * @param driverPhoto the driver photo of this driver detail
	 */
	@Override
	public void setDriverPhoto(String driverPhoto) {
		model.setDriverPhoto(driverPhoto);
	}

	/**
	 * Sets the driving licence ID of this driver detail.
	 *
	 * @param drivingLicenceId the driving licence ID of this driver detail
	 */
	@Override
	public void setDrivingLicenceId(String drivingLicenceId) {
		model.setDrivingLicenceId(drivingLicenceId);
	}

	/**
	 * Sets the email of this driver detail.
	 *
	 * @param email the email of this driver detail
	 */
	@Override
	public void setEmail(String email) {
		model.setEmail(email);
	}

	/**
	 * Sets the gender of this driver detail.
	 *
	 * @param gender the gender of this driver detail
	 */
	@Override
	public void setGender(String gender) {
		model.setGender(gender);
	}

	/**
	 * Sets the mobile number of this driver detail.
	 *
	 * @param mobileNumber the mobile number of this driver detail
	 */
	@Override
	public void setMobileNumber(String mobileNumber) {
		model.setMobileNumber(mobileNumber);
	}

	/**
	 * Sets the modified date of this driver detail.
	 *
	 * @param modifiedDate the modified date of this driver detail
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the password of this driver detail.
	 *
	 * @param Password the password of this driver detail
	 */
	@Override
	public void setPassword(String Password) {
		model.setPassword(Password);
	}

	/**
	 * Sets the primary key of this driver detail.
	 *
	 * @param primaryKey the primary key of this driver detail
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the user ID of this driver detail.
	 *
	 * @param userId the user ID of this driver detail
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user uuid of this driver detail.
	 *
	 * @param userUuid the user uuid of this driver detail
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	@Override
	public String toXmlString() {
		return model.toXmlString();
	}

	@Override
	protected DriverDetailWrapper wrap(DriverDetail driverDetail) {
		return new DriverDetailWrapper(driverDetail);
	}

}