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

package ummat_startup_details.model;

import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link MatriUser}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see MatriUser
 * @generated
 */
public class MatriUserWrapper
	extends BaseModelWrapper<MatriUser>
	implements MatriUser, ModelWrapper<MatriUser> {

	public MatriUserWrapper(MatriUser matriUser) {
		super(matriUser);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("id", getId());
		attributes.put("userId", getUserId());
		attributes.put("companyId", getCompanyId());
		attributes.put("education", getEducation());
		attributes.put("country", getCountry());
		attributes.put("state", getState());
		attributes.put("district", getDistrict());
		attributes.put("area", getArea());
		attributes.put("jamath", getJamath());
		attributes.put("maritalStatus", getMaritalStatus());
		attributes.put("height", getHeight());
		attributes.put("weight", getWeight());
		attributes.put("primaryId", getPrimaryId());
		attributes.put("imageId", getImageId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("color", getColor());
		attributes.put("bio", getBio());
		attributes.put("malechild", getMalechild());
		attributes.put("femalechild", getFemalechild());
		attributes.put("MothertongueLanguage", getMothertongueLanguage());
		attributes.put("LivingPlace", getLivingPlace());
		attributes.put("Monthlyincome", getMonthlyincome());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		String education = (String)attributes.get("education");

		if (education != null) {
			setEducation(education);
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

		String jamath = (String)attributes.get("jamath");

		if (jamath != null) {
			setJamath(jamath);
		}

		String maritalStatus = (String)attributes.get("maritalStatus");

		if (maritalStatus != null) {
			setMaritalStatus(maritalStatus);
		}

		Double height = (Double)attributes.get("height");

		if (height != null) {
			setHeight(height);
		}

		Double weight = (Double)attributes.get("weight");

		if (weight != null) {
			setWeight(weight);
		}

		String primaryId = (String)attributes.get("primaryId");

		if (primaryId != null) {
			setPrimaryId(primaryId);
		}

		Long imageId = (Long)attributes.get("imageId");

		if (imageId != null) {
			setImageId(imageId);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String color = (String)attributes.get("color");

		if (color != null) {
			setColor(color);
		}

		String bio = (String)attributes.get("bio");

		if (bio != null) {
			setBio(bio);
		}

		String malechild = (String)attributes.get("malechild");

		if (malechild != null) {
			setMalechild(malechild);
		}

		String femalechild = (String)attributes.get("femalechild");

		if (femalechild != null) {
			setFemalechild(femalechild);
		}

		String MothertongueLanguage = (String)attributes.get(
			"MothertongueLanguage");

		if (MothertongueLanguage != null) {
			setMothertongueLanguage(MothertongueLanguage);
		}

		String LivingPlace = (String)attributes.get("LivingPlace");

		if (LivingPlace != null) {
			setLivingPlace(LivingPlace);
		}

		Double Monthlyincome = (Double)attributes.get("Monthlyincome");

		if (Monthlyincome != null) {
			setMonthlyincome(Monthlyincome);
		}
	}

	@Override
	public MatriUser cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the area of this matri user.
	 *
	 * @return the area of this matri user
	 */
	@Override
	public String getArea() {
		return model.getArea();
	}

	/**
	 * Returns the bio of this matri user.
	 *
	 * @return the bio of this matri user
	 */
	@Override
	public String getBio() {
		return model.getBio();
	}

	/**
	 * Returns the color of this matri user.
	 *
	 * @return the color of this matri user
	 */
	@Override
	public String getColor() {
		return model.getColor();
	}

	/**
	 * Returns the company ID of this matri user.
	 *
	 * @return the company ID of this matri user
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the country of this matri user.
	 *
	 * @return the country of this matri user
	 */
	@Override
	public long getCountry() {
		return model.getCountry();
	}

	/**
	 * Returns the create date of this matri user.
	 *
	 * @return the create date of this matri user
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the district of this matri user.
	 *
	 * @return the district of this matri user
	 */
	@Override
	public long getDistrict() {
		return model.getDistrict();
	}

	/**
	 * Returns the education of this matri user.
	 *
	 * @return the education of this matri user
	 */
	@Override
	public String getEducation() {
		return model.getEducation();
	}

	/**
	 * Returns the femalechild of this matri user.
	 *
	 * @return the femalechild of this matri user
	 */
	@Override
	public String getFemalechild() {
		return model.getFemalechild();
	}

	/**
	 * Returns the height of this matri user.
	 *
	 * @return the height of this matri user
	 */
	@Override
	public Double getHeight() {
		return model.getHeight();
	}

	/**
	 * Returns the ID of this matri user.
	 *
	 * @return the ID of this matri user
	 */
	@Override
	public long getId() {
		return model.getId();
	}

	/**
	 * Returns the image ID of this matri user.
	 *
	 * @return the image ID of this matri user
	 */
	@Override
	public long getImageId() {
		return model.getImageId();
	}

	/**
	 * Returns the jamath of this matri user.
	 *
	 * @return the jamath of this matri user
	 */
	@Override
	public String getJamath() {
		return model.getJamath();
	}

	/**
	 * Returns the living place of this matri user.
	 *
	 * @return the living place of this matri user
	 */
	@Override
	public String getLivingPlace() {
		return model.getLivingPlace();
	}

	/**
	 * Returns the malechild of this matri user.
	 *
	 * @return the malechild of this matri user
	 */
	@Override
	public String getMalechild() {
		return model.getMalechild();
	}

	/**
	 * Returns the marital status of this matri user.
	 *
	 * @return the marital status of this matri user
	 */
	@Override
	public String getMaritalStatus() {
		return model.getMaritalStatus();
	}

	/**
	 * Returns the modified date of this matri user.
	 *
	 * @return the modified date of this matri user
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the monthlyincome of this matri user.
	 *
	 * @return the monthlyincome of this matri user
	 */
	@Override
	public double getMonthlyincome() {
		return model.getMonthlyincome();
	}

	/**
	 * Returns the mothertongue language of this matri user.
	 *
	 * @return the mothertongue language of this matri user
	 */
	@Override
	public String getMothertongueLanguage() {
		return model.getMothertongueLanguage();
	}

	/**
	 * Returns the primary ID of this matri user.
	 *
	 * @return the primary ID of this matri user
	 */
	@Override
	public String getPrimaryId() {
		return model.getPrimaryId();
	}

	/**
	 * Returns the primary key of this matri user.
	 *
	 * @return the primary key of this matri user
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the state of this matri user.
	 *
	 * @return the state of this matri user
	 */
	@Override
	public String getState() {
		return model.getState();
	}

	/**
	 * Returns the user ID of this matri user.
	 *
	 * @return the user ID of this matri user
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user uuid of this matri user.
	 *
	 * @return the user uuid of this matri user
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this matri user.
	 *
	 * @return the uuid of this matri user
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Returns the weight of this matri user.
	 *
	 * @return the weight of this matri user
	 */
	@Override
	public double getWeight() {
		return model.getWeight();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the area of this matri user.
	 *
	 * @param area the area of this matri user
	 */
	@Override
	public void setArea(String area) {
		model.setArea(area);
	}

	/**
	 * Sets the bio of this matri user.
	 *
	 * @param bio the bio of this matri user
	 */
	@Override
	public void setBio(String bio) {
		model.setBio(bio);
	}

	/**
	 * Sets the color of this matri user.
	 *
	 * @param color the color of this matri user
	 */
	@Override
	public void setColor(String color) {
		model.setColor(color);
	}

	/**
	 * Sets the company ID of this matri user.
	 *
	 * @param companyId the company ID of this matri user
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the country of this matri user.
	 *
	 * @param country the country of this matri user
	 */
	@Override
	public void setCountry(long country) {
		model.setCountry(country);
	}

	/**
	 * Sets the create date of this matri user.
	 *
	 * @param createDate the create date of this matri user
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the district of this matri user.
	 *
	 * @param district the district of this matri user
	 */
	@Override
	public void setDistrict(long district) {
		model.setDistrict(district);
	}

	/**
	 * Sets the education of this matri user.
	 *
	 * @param education the education of this matri user
	 */
	@Override
	public void setEducation(String education) {
		model.setEducation(education);
	}

	/**
	 * Sets the femalechild of this matri user.
	 *
	 * @param femalechild the femalechild of this matri user
	 */
	@Override
	public void setFemalechild(String femalechild) {
		model.setFemalechild(femalechild);
	}

	/**
	 * Sets the height of this matri user.
	 *
	 * @param height the height of this matri user
	 */
	@Override
	public void setHeight(Double height) {
		model.setHeight(height);
	}

	/**
	 * Sets the ID of this matri user.
	 *
	 * @param id the ID of this matri user
	 */
	@Override
	public void setId(long id) {
		model.setId(id);
	}

	/**
	 * Sets the image ID of this matri user.
	 *
	 * @param imageId the image ID of this matri user
	 */
	@Override
	public void setImageId(long imageId) {
		model.setImageId(imageId);
	}

	/**
	 * Sets the jamath of this matri user.
	 *
	 * @param jamath the jamath of this matri user
	 */
	@Override
	public void setJamath(String jamath) {
		model.setJamath(jamath);
	}

	/**
	 * Sets the living place of this matri user.
	 *
	 * @param LivingPlace the living place of this matri user
	 */
	@Override
	public void setLivingPlace(String LivingPlace) {
		model.setLivingPlace(LivingPlace);
	}

	/**
	 * Sets the malechild of this matri user.
	 *
	 * @param malechild the malechild of this matri user
	 */
	@Override
	public void setMalechild(String malechild) {
		model.setMalechild(malechild);
	}

	/**
	 * Sets the marital status of this matri user.
	 *
	 * @param maritalStatus the marital status of this matri user
	 */
	@Override
	public void setMaritalStatus(String maritalStatus) {
		model.setMaritalStatus(maritalStatus);
	}

	/**
	 * Sets the modified date of this matri user.
	 *
	 * @param modifiedDate the modified date of this matri user
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the monthlyincome of this matri user.
	 *
	 * @param Monthlyincome the monthlyincome of this matri user
	 */
	@Override
	public void setMonthlyincome(double Monthlyincome) {
		model.setMonthlyincome(Monthlyincome);
	}

	/**
	 * Sets the mothertongue language of this matri user.
	 *
	 * @param MothertongueLanguage the mothertongue language of this matri user
	 */
	@Override
	public void setMothertongueLanguage(String MothertongueLanguage) {
		model.setMothertongueLanguage(MothertongueLanguage);
	}

	/**
	 * Sets the primary ID of this matri user.
	 *
	 * @param primaryId the primary ID of this matri user
	 */
	@Override
	public void setPrimaryId(String primaryId) {
		model.setPrimaryId(primaryId);
	}

	/**
	 * Sets the primary key of this matri user.
	 *
	 * @param primaryKey the primary key of this matri user
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the state of this matri user.
	 *
	 * @param state the state of this matri user
	 */
	@Override
	public void setState(String state) {
		model.setState(state);
	}

	/**
	 * Sets the user ID of this matri user.
	 *
	 * @param userId the user ID of this matri user
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user uuid of this matri user.
	 *
	 * @param userUuid the user uuid of this matri user
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this matri user.
	 *
	 * @param uuid the uuid of this matri user
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	/**
	 * Sets the weight of this matri user.
	 *
	 * @param weight the weight of this matri user
	 */
	@Override
	public void setWeight(double weight) {
		model.setWeight(weight);
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
	protected MatriUserWrapper wrap(MatriUser matriUser) {
		return new MatriUserWrapper(matriUser);
	}

}