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

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Blob;
import java.sql.Types;

/**
 * The table class for the &quot;MatriExtra_MatriUserImage&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see MatriUserImage
 * @generated
 */
public class MatriUserImageTable extends BaseTable<MatriUserImageTable> {

	public static final MatriUserImageTable INSTANCE =
		new MatriUserImageTable();

	public final Column<MatriUserImageTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<MatriUserImageTable, Long> MatriImageId = createColumn(
		"MatriImageId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<MatriUserImageTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<MatriUserImageTable, String> userName = createColumn(
		"userName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<MatriUserImageTable, Long> MatriUserId = createColumn(
		"MatriUserId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<MatriUserImageTable, Blob> imageOne = createColumn(
		"imageOne", Blob.class, Types.BLOB, Column.FLAG_DEFAULT);
	public final Column<MatriUserImageTable, Blob> imageTwo = createColumn(
		"imageTwo", Blob.class, Types.BLOB, Column.FLAG_DEFAULT);
	public final Column<MatriUserImageTable, Blob> imageThree = createColumn(
		"imageThree", Blob.class, Types.BLOB, Column.FLAG_DEFAULT);
	public final Column<MatriUserImageTable, Blob> imageFour = createColumn(
		"imageFour", Blob.class, Types.BLOB, Column.FLAG_DEFAULT);

	private MatriUserImageTable() {
		super("MatriExtra_MatriUserImage", MatriUserImageTable::new);
	}

}