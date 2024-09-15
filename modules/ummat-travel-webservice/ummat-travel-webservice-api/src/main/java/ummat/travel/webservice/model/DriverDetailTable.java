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

package ummat.travel.webservice.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

import java.util.Date;

/**
 * The table class for the &quot;UMMATLife_DriverDetail&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see DriverDetail
 * @generated
 */
public class DriverDetailTable extends BaseTable<DriverDetailTable> {

	public static final DriverDetailTable INSTANCE = new DriverDetailTable();

	public final Column<DriverDetailTable, Long> driverId = createColumn(
		"driverId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<DriverDetailTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DriverDetailTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DriverDetailTable, String> driverName = createColumn(
		"driverName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DriverDetailTable, String> age = createColumn(
		"age", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DriverDetailTable, String> Password = createColumn(
		"Password", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DriverDetailTable, String> mobileNumber = createColumn(
		"mobileNumber", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DriverDetailTable, String> email = createColumn(
		"email", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DriverDetailTable, String> gender = createColumn(
		"gender", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DriverDetailTable, String> driverPhoto = createColumn(
		"driverPhoto", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DriverDetailTable, String> aadharNumber = createColumn(
		"aadharNumber", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DriverDetailTable, String> drivingLicenceId =
		createColumn(
			"drivingLicenceId", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<DriverDetailTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<DriverDetailTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);

	private DriverDetailTable() {
		super("UMMATLife_DriverDetail", DriverDetailTable::new);
	}

}