create index IX_82697B28 on PT_UserInfo (code_);
create index IX_78DD6410 on PT_UserInfo (groupId);
create index IX_EE96E414 on PT_UserInfo (userId);
create index IX_451CBA9A on PT_UserInfo (uuid_);
create index IX_41E2854E on PT_UserInfo (uuid_, companyId);
create unique index IX_AD480750 on PT_UserInfo (uuid_, groupId);