create table MatriExtra_MatriUserImage (
	uuid_ VARCHAR(75) null,
	MatriImageId LONG not null primary key,
	userId LONG,
	userName VARCHAR(75) null,
	MatriUserId LONG,
	imageOne BLOB,
	imageTwo BLOB,
	imageThree BLOB,
	imageFour BLOB
);