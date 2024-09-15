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

package ummat.matriExtra.slayer.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.sql.Blob;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link MatriUserImage}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see MatriUserImage
 * @generated
 */
public class MatriUserImageWrapper
	extends BaseModelWrapper<MatriUserImage>
	implements MatriUserImage, ModelWrapper<MatriUserImage> {

	public MatriUserImageWrapper(MatriUserImage matriUserImage) {
		super(matriUserImage);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("MatriImageId", getMatriImageId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("MatriUserId", getMatriUserId());
		attributes.put("imageOne", getImageOne());
		attributes.put("imageTwo", getImageTwo());
		attributes.put("imageThree", getImageThree());
		attributes.put("imageFour", getImageFour());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long MatriImageId = (Long)attributes.get("MatriImageId");

		if (MatriImageId != null) {
			setMatriImageId(MatriImageId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Long MatriUserId = (Long)attributes.get("MatriUserId");

		if (MatriUserId != null) {
			setMatriUserId(MatriUserId);
		}

		Blob imageOne = (Blob)attributes.get("imageOne");

		if (imageOne != null) {
			setImageOne(imageOne);
		}

		Blob imageTwo = (Blob)attributes.get("imageTwo");

		if (imageTwo != null) {
			setImageTwo(imageTwo);
		}

		Blob imageThree = (Blob)attributes.get("imageThree");

		if (imageThree != null) {
			setImageThree(imageThree);
		}

		Blob imageFour = (Blob)attributes.get("imageFour");

		if (imageFour != null) {
			setImageFour(imageFour);
		}
	}

	@Override
	public MatriUserImage cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the image four of this matri user image.
	 *
	 * @return the image four of this matri user image
	 */
	@Override
	public Blob getImageFour() {
		return model.getImageFour();
	}

	/**
	 * Returns the image one of this matri user image.
	 *
	 * @return the image one of this matri user image
	 */
	@Override
	public Blob getImageOne() {
		return model.getImageOne();
	}

	/**
	 * Returns the image three of this matri user image.
	 *
	 * @return the image three of this matri user image
	 */
	@Override
	public Blob getImageThree() {
		return model.getImageThree();
	}

	/**
	 * Returns the image two of this matri user image.
	 *
	 * @return the image two of this matri user image
	 */
	@Override
	public Blob getImageTwo() {
		return model.getImageTwo();
	}

	/**
	 * Returns the matri image ID of this matri user image.
	 *
	 * @return the matri image ID of this matri user image
	 */
	@Override
	public long getMatriImageId() {
		return model.getMatriImageId();
	}

	/**
	 * Returns the matri user ID of this matri user image.
	 *
	 * @return the matri user ID of this matri user image
	 */
	@Override
	public long getMatriUserId() {
		return model.getMatriUserId();
	}

	/**
	 * Returns the matri user uuid of this matri user image.
	 *
	 * @return the matri user uuid of this matri user image
	 */
	@Override
	public String getMatriUserUuid() {
		return model.getMatriUserUuid();
	}

	/**
	 * Returns the primary key of this matri user image.
	 *
	 * @return the primary key of this matri user image
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the user ID of this matri user image.
	 *
	 * @return the user ID of this matri user image
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this matri user image.
	 *
	 * @return the user name of this matri user image
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this matri user image.
	 *
	 * @return the user uuid of this matri user image
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this matri user image.
	 *
	 * @return the uuid of this matri user image
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
	 * Sets the image four of this matri user image.
	 *
	 * @param imageFour the image four of this matri user image
	 */
	@Override
	public void setImageFour(Blob imageFour) {
		model.setImageFour(imageFour);
	}

	/**
	 * Sets the image one of this matri user image.
	 *
	 * @param imageOne the image one of this matri user image
	 */
	@Override
	public void setImageOne(Blob imageOne) {
		model.setImageOne(imageOne);
	}

	/**
	 * Sets the image three of this matri user image.
	 *
	 * @param imageThree the image three of this matri user image
	 */
	@Override
	public void setImageThree(Blob imageThree) {
		model.setImageThree(imageThree);
	}

	/**
	 * Sets the image two of this matri user image.
	 *
	 * @param imageTwo the image two of this matri user image
	 */
	@Override
	public void setImageTwo(Blob imageTwo) {
		model.setImageTwo(imageTwo);
	}

	/**
	 * Sets the matri image ID of this matri user image.
	 *
	 * @param MatriImageId the matri image ID of this matri user image
	 */
	@Override
	public void setMatriImageId(long MatriImageId) {
		model.setMatriImageId(MatriImageId);
	}

	/**
	 * Sets the matri user ID of this matri user image.
	 *
	 * @param MatriUserId the matri user ID of this matri user image
	 */
	@Override
	public void setMatriUserId(long MatriUserId) {
		model.setMatriUserId(MatriUserId);
	}

	/**
	 * Sets the matri user uuid of this matri user image.
	 *
	 * @param MatriUserUuid the matri user uuid of this matri user image
	 */
	@Override
	public void setMatriUserUuid(String MatriUserUuid) {
		model.setMatriUserUuid(MatriUserUuid);
	}

	/**
	 * Sets the primary key of this matri user image.
	 *
	 * @param primaryKey the primary key of this matri user image
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the user ID of this matri user image.
	 *
	 * @param userId the user ID of this matri user image
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this matri user image.
	 *
	 * @param userName the user name of this matri user image
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this matri user image.
	 *
	 * @param userUuid the user uuid of this matri user image
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this matri user image.
	 *
	 * @param uuid the uuid of this matri user image
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
	protected MatriUserImageWrapper wrap(MatriUserImage matriUserImage) {
		return new MatriUserImageWrapper(matriUserImage);
	}

}