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
 * The Blob model class for lazy loading the imageFour column in MatriUserImage.
 *
 * @author Brian Wing Shun Chan
 * @see MatriUserImage
 * @generated
 */
public class MatriUserImageImageFourBlobModel {

	public MatriUserImageImageFourBlobModel() {
	}

	public MatriUserImageImageFourBlobModel(long MatriImageId) {
		_MatriImageId = MatriImageId;
	}

	public MatriUserImageImageFourBlobModel(
		long MatriImageId, Blob imageFourBlob) {

		_MatriImageId = MatriImageId;
		_imageFourBlob = imageFourBlob;
	}

	public long getMatriImageId() {
		return _MatriImageId;
	}

	public void setMatriImageId(long MatriImageId) {
		_MatriImageId = MatriImageId;
	}

	public Blob getImageFourBlob() {
		return _imageFourBlob;
	}

	public void setImageFourBlob(Blob imageFourBlob) {
		_imageFourBlob = imageFourBlob;
	}

	private long _MatriImageId;
	private Blob _imageFourBlob;

}