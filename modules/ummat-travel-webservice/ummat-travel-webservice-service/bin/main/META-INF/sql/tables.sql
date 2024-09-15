create table UMMATLife_DriverDetail (
	driverId LONG not null primary key,
	userId LONG,
	companyId LONG,
	driverName VARCHAR(75) null,
	age VARCHAR(75) null,
	Password VARCHAR(75) null,
	mobileNumber VARCHAR(75) null,
	email VARCHAR(75) null,
	gender VARCHAR(75) null,
	driverPhoto VARCHAR(75) null,
	aadharNumber VARCHAR(75) null,
	drivingLicenceId VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null
);

create table UMMATLife_TravelUser (
	uuid_ VARCHAR(75) null,
	travelUserId LONG not null primary key,
	userId LONG,
	companyId LONG,
	travelUserName VARCHAR(75) null,
	travelUserEmail VARCHAR(75) null,
	travelUserPhoneNumber VARCHAR(75) null,
	travelUserGender VARCHAR(75) null,
	travelUserAddress VARCHAR(75) null,
	travelUserProfile VARCHAR(75) null,
	travelUserPassword VARCHAR(75) null,
	country LONG,
	state_ VARCHAR(75) null,
	district LONG,
	area VARCHAR(75) null,
	pincode LONG,
	createDate DATE null,
	modifiedDate DATE null
);