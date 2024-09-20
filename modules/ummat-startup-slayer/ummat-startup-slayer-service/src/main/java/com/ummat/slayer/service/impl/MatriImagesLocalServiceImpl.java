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

package com.ummat.slayer.service.impl;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.aop.AopService;
import com.ummat.slayer.model.MatriImages;
import com.ummat.slayer.service.MatriImagesLocalServiceUtil;
import com.ummat.slayer.service.base.MatriImagesLocalServiceBaseImpl;

import java.util.Date;
import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=com.ummat.slayer.model.MatriImages",
	service = AopService.class
)
public class MatriImagesLocalServiceImpl
	extends MatriImagesLocalServiceBaseImpl {
	
	public List<MatriImages> getImagesByUserId(long userId){
		return matriImagesPersistence.findByuserId(userId);
	}
	
	public void addMatriImages(long groupId,long companyId, long userId, String userName,long dlEntryId) {
		
		MatriImages matriImage = MatriImagesLocalServiceUtil.createMatriImages(CounterLocalServiceUtil.increment());
		matriImage.setGroupId(groupId);
		matriImage.setCompanyId(companyId);
		matriImage.setUserId(userId);
		matriImage.setUserName(userName);
		matriImage.setCreateDate(new Date());
		matriImage.setModifiedDate(new Date());
		matriImage.setDlEntryId(dlEntryId);
		
		MatriImagesLocalServiceUtil.addMatriImages(matriImage);
	}
}