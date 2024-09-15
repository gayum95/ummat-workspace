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

import ummat.travel.webservice.model.TravelUser;

/**
 * The cache model class for representing TravelUser in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class TravelUserCacheModel
	implements CacheModel<TravelUser>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof TravelUserCacheModel)) {
			return false;
		}

		TravelUserCacheModel travelUserCacheModel =
			(TravelUserCacheModel)object;

		if (travelUserId == travelUserCacheModel.travelUserId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, travelUserId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(37);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", travelUserId=");
		sb.append(travelUserId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", travelUserName=");
		sb.append(travelUserName);
		sb.append(", travelUserEmail=");
		sb.append(travelUserEmail);
		sb.append(", travelUserPhoneNumber=");
		sb.append(travelUserPhoneNumber);
		sb.append(", travelUserGender=");
		sb.append(travelUserGender);
		sb.append(", travelUserAddress=");
		sb.append(travelUserAddress);
		sb.append(", travelUserProfile=");
		sb.append(travelUserProfile);
		sb.append(", travelUserPassword=");
		sb.append(travelUserPassword);
		sb.append(", country=");
		sb.append(country);
		sb.append(", state=");
		sb.append(state);
		sb.append(", district=");
		sb.append(district);
		sb.append(", area=");
		sb.append(area);
		sb.append(", pincode=");
		sb.append(pincode);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public TravelUser toEntityModel() {
		TravelUserImpl travelUserImpl = new TravelUserImpl();

		if (uuid == null) {
			travelUserImpl.setUuid("");
		}
		else {
			travelUserImpl.setUuid(uuid);
		}

		travelUserImpl.setTravelUserId(travelUserId);
		travelUserImpl.setUserId(userId);
		travelUserImpl.setCompanyId(companyId);

		if (travelUserName == null) {
			travelUserImpl.setTravelUserName("");
		}
		else {
			travelUserImpl.setTravelUserName(travelUserName);
		}

		if (travelUserEmail == null) {
			travelUserImpl.setTravelUserEmail("");
		}
		else {
			travelUserImpl.setTravelUserEmail(travelUserEmail);
		}

		if (travelUserPhoneNumber == null) {
			travelUserImpl.setTravelUserPhoneNumber("");
		}
		else {
			travelUserImpl.setTravelUserPhoneNumber(travelUserPhoneNumber);
		}

		if (travelUserGender == null) {
			travelUserImpl.setTravelUserGender("");
		}
		else {
			travelUserImpl.setTravelUserGender(travelUserGender);
		}

		if (travelUserAddress == null) {
			travelUserImpl.setTravelUserAddress("");
		}
		else {
			travelUserImpl.setTravelUserAddress(travelUserAddress);
		}

		if (travelUserProfile == null) {
			travelUserImpl.setTravelUserProfile("");
		}
		else {
			travelUserImpl.setTravelUserProfile(travelUserProfile);
		}

		if (travelUserPassword == null) {
			travelUserImpl.setTravelUserPassword("");
		}
		else {
			travelUserImpl.setTravelUserPassword(travelUserPassword);
		}

		travelUserImpl.setCountry(country);

		if (state == null) {
			travelUserImpl.setState("");
		}
		else {
			travelUserImpl.setState(state);
		}

		travelUserImpl.setDistrict(district);

		if (area == null) {
			travelUserImpl.setArea("");
		}
		else {
			travelUserImpl.setArea(area);
		}

		travelUserImpl.setPincode(pincode);

		if (createDate == Long.MIN_VALUE) {
			travelUserImpl.setCreateDate(null);
		}
		else {
			travelUserImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			travelUserImpl.setModifiedDate(null);
		}
		else {
			travelUserImpl.setModifiedDate(new Date(modifiedDate));
		}

		travelUserImpl.resetOriginalValues();

		return travelUserImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		travelUserId = objectInput.readLong();

		userId = objectInput.readLong();

		companyId = objectInput.readLong();
		travelUserName = objectInput.readUTF();
		travelUserEmail = objectInput.readUTF();
		travelUserPhoneNumber = objectInput.readUTF();
		travelUserGender = objectInput.readUTF();
		travelUserAddress = objectInput.readUTF();
		travelUserProfile = objectInput.readUTF();
		travelUserPassword = objectInput.readUTF();

		country = objectInput.readLong();
		state = objectInput.readUTF();

		district = objectInput.readLong();
		area = objectInput.readUTF();

		pincode = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(travelUserId);

		objectOutput.writeLong(userId);

		objectOutput.writeLong(companyId);

		if (travelUserName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(travelUserName);
		}

		if (travelUserEmail == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(travelUserEmail);
		}

		if (travelUserPhoneNumber == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(travelUserPhoneNumber);
		}

		if (travelUserGender == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(travelUserGender);
		}

		if (travelUserAddress == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(travelUserAddress);
		}

		if (travelUserProfile == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(travelUserProfile);
		}

		if (travelUserPassword == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(travelUserPassword);
		}

		objectOutput.writeLong(country);

		if (state == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(state);
		}

		objectOutput.writeLong(district);

		if (area == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(area);
		}

		objectOutput.writeLong(pincode);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);
	}

	public String uuid;
	public long travelUserId;
	public long userId;
	public long companyId;
	public String travelUserName;
	public String travelUserEmail;
	public String travelUserPhoneNumber;
	public String travelUserGender;
	public String travelUserAddress;
	public String travelUserProfile;
	public String travelUserPassword;
	public long country;
	public String state;
	public long district;
	public String area;
	public long pincode;
	public long createDate;
	public long modifiedDate;

}