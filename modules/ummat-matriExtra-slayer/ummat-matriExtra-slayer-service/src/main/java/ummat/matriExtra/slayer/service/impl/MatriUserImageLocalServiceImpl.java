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

package ummat.matriExtra.slayer.service.impl;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.InputStream;
import java.sql.Blob;
import java.util.List;

import javax.sql.rowset.serial.SerialBlob;

import org.osgi.service.component.annotations.Component;

import ummat.matriExtra.slayer.exception.NoSuchMatriUserImageException;
import ummat.matriExtra.slayer.model.MatriUserImage;
import ummat.matriExtra.slayer.service.base.MatriUserImageLocalServiceBaseImpl;

/**
 * @author Brian Wing Shun Chan
 */
@Component(property = "model.class.name=ummat.matriExtra.slayer.model.MatriUserImage", service = AopService.class)
public class MatriUserImageLocalServiceImpl extends MatriUserImageLocalServiceBaseImpl {
	
	
	public MatriUserImage addMatriUserImage(long userId, String userName, long matriUserId, InputStream imageOne,
			InputStream imageTwo, InputStream imageThree, InputStream imageFour) throws Exception {
		
		long matriImageId = counterLocalService.increment();
		MatriUserImage matriUserImage = matriUserImagePersistence.create(matriImageId);

		matriUserImage.setUserId(userId);
		matriUserImage.setUserName(userName);
		matriUserImage.setMatriUserId(matriUserId);
		  matriUserImage.setImageOne(convertToBlob(imageOne));
	        matriUserImage.setImageTwo(convertToBlob(imageTwo));
	        matriUserImage.setImageThree(convertToBlob(imageThree));
	        matriUserImage.setImageFour(convertToBlob(imageFour));


		return matriUserImagePersistence.update(matriUserImage);
	}
	
	 private Blob convertToBlob(InputStream inputStream) throws Exception {
	        if (inputStream == null) {
	            return null;
	        }
	        byte[] bytes = inputStream.readAllBytes();
	        return new SerialBlob(bytes);
	    }

	public MatriUserImage getMatriUserImage(long matriImageId) {
		try {
			return matriUserImagePersistence.findByPrimaryKey(matriImageId);
		} catch (NoSuchMatriUserImageException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public List<MatriUserImage> getMatriUserImages(int start, int end) {
		return matriUserImagePersistence.findAll(start, end);
	}

	public MatriUserImage deleteMatriUserImage(long matriImageId) {
		try {
			matriUserImagePersistence.remove(matriImageId);
		} catch (NoSuchMatriUserImageException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/*
	 * public List<MatriUserImage> findByMatriExtraImages(long matriUserId) throws
	 * Exception { return matriUserImagePersistence.findByMatriUserId(matriUserId);
	 * }
	 * 
	 * public List<MatriUserImage> findByMatriExtraImagesUserId(long userId) throws
	 * Exception { return matriUserImagePersistence.findByUserId(userId); }
	 */
}