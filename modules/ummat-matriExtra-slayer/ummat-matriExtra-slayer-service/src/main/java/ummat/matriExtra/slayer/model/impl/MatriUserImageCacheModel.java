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

package ummat.matriExtra.slayer.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import ummat.matriExtra.slayer.model.MatriUserImage;

/**
 * The cache model class for representing MatriUserImage in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class MatriUserImageCacheModel
	implements CacheModel<MatriUserImage>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof MatriUserImageCacheModel)) {
			return false;
		}

		MatriUserImageCacheModel matriUserImageCacheModel =
			(MatriUserImageCacheModel)object;

		if (MatriImageId == matriUserImageCacheModel.MatriImageId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, MatriImageId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", MatriImageId=");
		sb.append(MatriImageId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", MatriUserId=");
		sb.append(MatriUserId);

		return sb.toString();
	}

	@Override
	public MatriUserImage toEntityModel() {
		MatriUserImageImpl matriUserImageImpl = new MatriUserImageImpl();

		if (uuid == null) {
			matriUserImageImpl.setUuid("");
		}
		else {
			matriUserImageImpl.setUuid(uuid);
		}

		matriUserImageImpl.setMatriImageId(MatriImageId);
		matriUserImageImpl.setUserId(userId);

		if (userName == null) {
			matriUserImageImpl.setUserName("");
		}
		else {
			matriUserImageImpl.setUserName(userName);
		}

		matriUserImageImpl.setMatriUserId(MatriUserId);

		matriUserImageImpl.resetOriginalValues();

		return matriUserImageImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		MatriImageId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();

		MatriUserId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(MatriImageId);

		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(MatriUserId);
	}

	public String uuid;
	public long MatriImageId;
	public long userId;
	public String userName;
	public long MatriUserId;

}