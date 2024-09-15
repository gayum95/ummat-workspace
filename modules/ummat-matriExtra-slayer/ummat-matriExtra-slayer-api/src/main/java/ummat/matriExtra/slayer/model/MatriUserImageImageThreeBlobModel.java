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

import java.sql.Blob;

/**
 * The Blob model class for lazy loading the imageThree column in MatriUserImage.
 *
 * @author Brian Wing Shun Chan
 * @see MatriUserImage
 * @generated
 */
public class MatriUserImageImageThreeBlobModel {

	public MatriUserImageImageThreeBlobModel() {
	}

	public MatriUserImageImageThreeBlobModel(long MatriImageId) {
		_MatriImageId = MatriImageId;
	}

	public MatriUserImageImageThreeBlobModel(
		long MatriImageId, Blob imageThreeBlob) {

		_MatriImageId = MatriImageId;
		_imageThreeBlob = imageThreeBlob;
	}

	public long getMatriImageId() {
		return _MatriImageId;
	}

	public void setMatriImageId(long MatriImageId) {
		_MatriImageId = MatriImageId;
	}

	public Blob getImageThreeBlob() {
		return _imageThreeBlob;
	}

	public void setImageThreeBlob(Blob imageThreeBlob) {
		_imageThreeBlob = imageThreeBlob;
	}

	private long _MatriImageId;
	private Blob _imageThreeBlob;

}