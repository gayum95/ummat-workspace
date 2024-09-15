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

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

import ummat.travel.webservice.model.DriverDetail;

/**
 * The cache model class for representing DriverDetail in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class DriverDetailCacheModel
	implements CacheModel<DriverDetail>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof DriverDetailCacheModel)) {
			return false;
		}

		DriverDetailCacheModel driverDetailCacheModel =
			(DriverDetailCacheModel)object;

		if (driverId == driverDetailCacheModel.driverId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, driverId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(29);

		sb.append("{driverId=");
		sb.append(driverId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", driverName=");
		sb.append(driverName);
		sb.append(", age=");
		sb.append(age);
		sb.append(", Password=");
		sb.append(Password);
		sb.append(", mobileNumber=");
		sb.append(mobileNumber);
		sb.append(", email=");
		sb.append(email);
		sb.append(", gender=");
		sb.append(gender);
		sb.append(", driverPhoto=");
		sb.append(driverPhoto);
		sb.append(", aadharNumber=");
		sb.append(aadharNumber);
		sb.append(", drivingLicenceId=");
		sb.append(drivingLicenceId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public DriverDetail toEntityModel() {
		DriverDetailImpl driverDetailImpl = new DriverDetailImpl();

		driverDetailImpl.setDriverId(driverId);
		driverDetailImpl.setUserId(userId);
		driverDetailImpl.setCompanyId(companyId);

		if (driverName == null) {
			driverDetailImpl.setDriverName("");
		}
		else {
			driverDetailImpl.setDriverName(driverName);
		}

		if (age == null) {
			driverDetailImpl.setAge("");
		}
		else {
			driverDetailImpl.setAge(age);
		}

		if (Password == null) {
			driverDetailImpl.setPassword("");
		}
		else {
			driverDetailImpl.setPassword(Password);
		}

		if (mobileNumber == null) {
			driverDetailImpl.setMobileNumber("");
		}
		else {
			driverDetailImpl.setMobileNumber(mobileNumber);
		}

		if (email == null) {
			driverDetailImpl.setEmail("");
		}
		else {
			driverDetailImpl.setEmail(email);
		}

		if (gender == null) {
			driverDetailImpl.setGender("");
		}
		else {
			driverDetailImpl.setGender(gender);
		}

		if (driverPhoto == null) {
			driverDetailImpl.setDriverPhoto("");
		}
		else {
			driverDetailImpl.setDriverPhoto(driverPhoto);
		}

		if (aadharNumber == null) {
			driverDetailImpl.setAadharNumber("");
		}
		else {
			driverDetailImpl.setAadharNumber(aadharNumber);
		}

		if (drivingLicenceId == null) {
			driverDetailImpl.setDrivingLicenceId("");
		}
		else {
			driverDetailImpl.setDrivingLicenceId(drivingLicenceId);
		}

		if (createDate == Long.MIN_VALUE) {
			driverDetailImpl.setCreateDate(null);
		}
		else {
			driverDetailImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			driverDetailImpl.setModifiedDate(null);
		}
		else {
			driverDetailImpl.setModifiedDate(new Date(modifiedDate));
		}

		driverDetailImpl.resetOriginalValues();

		return driverDetailImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		driverId = objectInput.readLong();

		userId = objectInput.readLong();

		companyId = objectInput.readLong();
		driverName = objectInput.readUTF();
		age = objectInput.readUTF();
		Password = objectInput.readUTF();
		mobileNumber = objectInput.readUTF();
		email = objectInput.readUTF();
		gender = objectInput.readUTF();
		driverPhoto = objectInput.readUTF();
		aadharNumber = objectInput.readUTF();
		drivingLicenceId = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(driverId);

		objectOutput.writeLong(userId);

		objectOutput.writeLong(companyId);

		if (driverName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(driverName);
		}

		if (age == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(age);
		}

		if (Password == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(Password);
		}

		if (mobileNumber == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(mobileNumber);
		}

		if (email == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(email);
		}

		if (gender == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(gender);
		}

		if (driverPhoto == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(driverPhoto);
		}

		if (aadharNumber == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(aadharNumber);
		}

		if (drivingLicenceId == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(drivingLicenceId);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);
	}

	public long driverId;
	public long userId;
	public long companyId;
	public String driverName;
	public String age;
	public String Password;
	public String mobileNumber;
	public String email;
	public String gender;
	public String driverPhoto;
	public String aadharNumber;
	public String drivingLicenceId;
	public long createDate;
	public long modifiedDate;

}