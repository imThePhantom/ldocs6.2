create index IX_F5591FB6 on GB_Entry (groupId, guestbookId);
<<<<<<< HEAD
create index IX_B00E4EF5 on GB_Entry (groupId, guestbookId, name);
=======
>>>>>>> 31b57708474fe8479443b578524d0d8a8e3c6565
create index IX_3BD8D300 on GB_Entry (uuid_);
create index IX_B5EF5128 on GB_Entry (uuid_, companyId);
create unique index IX_C1EA01AA on GB_Entry (uuid_, groupId);

create index IX_9294AD47 on GB_Guestbook (groupId);
<<<<<<< HEAD
create index IX_FA13ABC6 on GB_Guestbook (groupId, name);
=======
>>>>>>> 31b57708474fe8479443b578524d0d8a8e3c6565
create index IX_ABB2E591 on GB_Guestbook (uuid_);
create index IX_9314A9F7 on GB_Guestbook (uuid_, companyId);
create unique index IX_EDD4239 on GB_Guestbook (uuid_, groupId);