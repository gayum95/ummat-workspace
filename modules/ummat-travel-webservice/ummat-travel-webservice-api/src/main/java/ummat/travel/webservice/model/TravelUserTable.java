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
 * The table class for the &quot;UMMATLife_TravelUser&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see TravelUser
 * @generated
 */
public class TravelUserTable extends BaseTable<TravelUserTable> {

	public static final TravelUserTable INSTANCE = new TravelUserTable();

	public final Column<TravelUserTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<TravelUserTable, Long> travelUserId = createColumn(
		"travelUserId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<TravelUserTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<TravelUserTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<TravelUserTable, String> travelUserName = createColumn(
		"travelUserName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<TravelUserTable, String> travelUserEmail = createColumn(
		"travelUserEmail", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<TravelUserTable, String> travelUserPhoneNumber =
		createColumn(
			"travelUserPhoneNumber", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<TravelUserTable, String> travelUserGender =
		createColumn(
			"travelUserGender", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<TravelUserTable, String> travelUserAddress =
		createColumn(
			"travelUserAddress", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<TravelUserTable, String> travelUserProfile =
		createColumn(
			"travelUserProfile", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<TravelUserTable, String> travelUserPassword =
		createColumn(
			"travelUserPassword", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<TravelUserTable, Long> country = createColumn(
		"country", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<TravelUserTable, String> state = createColumn(
		"state_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<TravelUserTable, Long> district = createColumn(
		"district", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<TravelUserTable, String> area = createColumn(
		"area", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<TravelUserTable, Long> pincode = createColumn(
		"pincode", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<TravelUserTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<TravelUserTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);

	private TravelUserTable() {
		super("UMMATLife_TravelUser", TravelUserTable::new);
	}

}