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

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

import java.util.Date;

/**
 * The table class for the &quot;TNUMMAT_MatriUser&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see MatriUser
 * @generated
 */
public class MatriUserTable extends BaseTable<MatriUserTable> {

	public static final MatriUserTable INSTANCE = new MatriUserTable();

	public final Column<MatriUserTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<MatriUserTable, Long> id = createColumn(
		"id_", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<MatriUserTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<MatriUserTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<MatriUserTable, String> education = createColumn(
		"education", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<MatriUserTable, Long> country = createColumn(
		"country", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<MatriUserTable, String> state = createColumn(
		"state_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<MatriUserTable, Long> district = createColumn(
		"district", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<MatriUserTable, String> area = createColumn(
		"area", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<MatriUserTable, String> jamath = createColumn(
		"jamath", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<MatriUserTable, String> maritalStatus = createColumn(
		"maritalStatus", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<MatriUserTable, Double> height = createColumn(
		"height", Double.class, Types.DOUBLE, Column.FLAG_DEFAULT);
	public final Column<MatriUserTable, Double> weight = createColumn(
		"weight", Double.class, Types.DOUBLE, Column.FLAG_DEFAULT);
	public final Column<MatriUserTable, String> primaryId = createColumn(
		"primaryId", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<MatriUserTable, Long> imageId = createColumn(
		"imageId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<MatriUserTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<MatriUserTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<MatriUserTable, String> color = createColumn(
		"color", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<MatriUserTable, String> bio = createColumn(
		"bio", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<MatriUserTable, String> malechild = createColumn(
		"malechild", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<MatriUserTable, String> femalechild = createColumn(
		"femalechild", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<MatriUserTable, String> MothertongueLanguage =
		createColumn(
			"MothertongueLanguage", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<MatriUserTable, String> LivingPlace = createColumn(
		"LivingPlace", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<MatriUserTable, Double> Monthlyincome = createColumn(
		"Monthlyincome", Double.class, Types.DOUBLE, Column.FLAG_DEFAULT);

	private MatriUserTable() {
		super("TNUMMAT_MatriUser", MatriUserTable::new);
	}

}