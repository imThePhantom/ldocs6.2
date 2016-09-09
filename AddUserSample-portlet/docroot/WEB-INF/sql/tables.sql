create table PT_UserInfo (
	uuid_ VARCHAR(75) null,
	groupId LONG,
	companyId LONG,
	creatorId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	userId LONG,
	code_ VARCHAR(75) not null primary key,
	username VARCHAR(75) null,
	email VARCHAR(75) null,
	phone VARCHAR(75) null
);