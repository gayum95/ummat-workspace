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

package ummat_startup_details.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

import ummat_startup_details.model.MatriUser;

/**
 * The cache model class for representing MatriUser in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class MatriUserCacheModel
	implements CacheModel<MatriUser>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof MatriUserCacheModel)) {
			return false;
		}

		MatriUserCacheModel matriUserCacheModel = (MatriUserCacheModel)object;

		if (id == matriUserCacheModel.id) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, id);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(49);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", id=");
		sb.append(id);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", education=");
		sb.append(education);
		sb.append(", country=");
		sb.append(country);
		sb.append(", state=");
		sb.append(state);
		sb.append(", district=");
		sb.append(district);
		sb.append(", area=");
		sb.append(area);
		sb.append(", jamath=");
		sb.append(jamath);
		sb.append(", maritalStatus=");
		sb.append(maritalStatus);
		sb.append(", height=");
		sb.append(height);
		sb.append(", weight=");
		sb.append(weight);
		sb.append(", primaryId=");
		sb.append(primaryId);
		sb.append(", imageId=");
		sb.append(imageId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", color=");
		sb.append(color);
		sb.append(", bio=");
		sb.append(bio);
		sb.append(", malechild=");
		sb.append(malechild);
		sb.append(", femalechild=");
		sb.append(femalechild);
		sb.append(", MothertongueLanguage=");
		sb.append(MothertongueLanguage);
		sb.append(", LivingPlace=");
		sb.append(LivingPlace);
		sb.append(", Monthlyincome=");
		sb.append(Monthlyincome);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public MatriUser toEntityModel() {
		MatriUserImpl matriUserImpl = new MatriUserImpl();

		if (uuid == null) {
			matriUserImpl.setUuid("");
		}
		else {
			matriUserImpl.setUuid(uuid);
		}

		matriUserImpl.setId(id);
		matriUserImpl.setUserId(userId);
		matriUserImpl.setCompanyId(companyId);

		if (education == null) {
			matriUserImpl.setEducation("");
		}
		else {
			matriUserImpl.setEducation(education);
		}

		matriUserImpl.setCountry(country);

		if (state == null) {
			matriUserImpl.setState("");
		}
		else {
			matriUserImpl.setState(state);
		}

		matriUserImpl.setDistrict(district);

		if (area == null) {
			matriUserImpl.setArea("");
		}
		else {
			matriUserImpl.setArea(area);
		}

		if (jamath == null) {
			matriUserImpl.setJamath("");
		}
		else {
			matriUserImpl.setJamath(jamath);
		}

		if (maritalStatus == null) {
			matriUserImpl.setMaritalStatus("");
		}
		else {
			matriUserImpl.setMaritalStatus(maritalStatus);
		}

		matriUserImpl.setHeight(height);
		matriUserImpl.setWeight(weight);

		if (primaryId == null) {
			matriUserImpl.setPrimaryId("");
		}
		else {
			matriUserImpl.setPrimaryId(primaryId);
		}

		matriUserImpl.setImageId(imageId);

		if (createDate == Long.MIN_VALUE) {
			matriUserImpl.setCreateDate(null);
		}
		else {
			matriUserImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			matriUserImpl.setModifiedDate(null);
		}
		else {
			matriUserImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (color == null) {
			matriUserImpl.setColor("");
		}
		else {
			matriUserImpl.setColor(color);
		}

		if (bio == null) {
			matriUserImpl.setBio("");
		}
		else {
			matriUserImpl.setBio(bio);
		}

		if (malechild == null) {
			matriUserImpl.setMalechild("");
		}
		else {
			matriUserImpl.setMalechild(malechild);
		}

		if (femalechild == null) {
			matriUserImpl.setFemalechild("");
		}
		else {
			matriUserImpl.setFemalechild(femalechild);
		}

		if (MothertongueLanguage == null) {
			matriUserImpl.setMothertongueLanguage("");
		}
		else {
			matriUserImpl.setMothertongueLanguage(MothertongueLanguage);
		}

		if (LivingPlace == null) {
			matriUserImpl.setLivingPlace("");
		}
		else {
			matriUserImpl.setLivingPlace(LivingPlace);
		}

		matriUserImpl.setMonthlyincome(Monthlyincome);

		matriUserImpl.resetOriginalValues();

		return matriUserImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		id = objectInput.readLong();

		userId = objectInput.readLong();

		companyId = objectInput.readLong();
		education = objectInput.readUTF();

		country = objectInput.readLong();
		state = objectInput.readUTF();

		district = objectInput.readLong();
		area = objectInput.readUTF();
		jamath = objectInput.readUTF();
		maritalStatus = objectInput.readUTF();

		height = objectInput.readDouble();

		weight = objectInput.readDouble();
		primaryId = objectInput.readUTF();

		imageId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		color = objectInput.readUTF();
		bio = objectInput.readUTF();
		malechild = objectInput.readUTF();
		femalechild = objectInput.readUTF();
		MothertongueLanguage = objectInput.readUTF();
		LivingPlace = objectInput.readUTF();

		Monthlyincome = objectInput.readDouble();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(id);

		objectOutput.writeLong(userId);

		objectOutput.writeLong(companyId);

		if (education == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(education);
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

		if (jamath == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(jamath);
		}

		if (maritalStatus == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(maritalStatus);
		}

		objectOutput.writeDouble(height);

		objectOutput.writeDouble(weight);

		if (primaryId == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(primaryId);
		}

		objectOutput.writeLong(imageId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		if (color == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(color);
		}

		if (bio == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(bio);
		}

		if (malechild == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(malechild);
		}

		if (femalechild == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(femalechild);
		}

		if (MothertongueLanguage == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(MothertongueLanguage);
		}

		if (LivingPlace == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(LivingPlace);
		}

		objectOutput.writeDouble(Monthlyincome);
	}

	public String uuid;
	public long id;
	public long userId;
	public long companyId;
	public String education;
	public long country;
	public String state;
	public long district;
	public String area;
	public String jamath;
	public String maritalStatus;
	public double height;
	public double weight;
	public String primaryId;
	public long imageId;
	public long createDate;
	public long modifiedDate;
	public String color;
	public String bio;
	public String malechild;
	public String femalechild;
	public String MothertongueLanguage;
	public String LivingPlace;
	public double Monthlyincome;

}