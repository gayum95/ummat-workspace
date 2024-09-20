create index IX_B9F7BF29 on District (regionCode[$COLUMN_LENGTH:75$]);
create index IX_39BE5557 on District (regionId);
create index IX_A7C054E8 on District (uuid_[$COLUMN_LENGTH:75$], companyId);

create index IX_BCBDA086 on Locality (districtId);
create index IX_DED8E23D on Locality (uuid_[$COLUMN_LENGTH:75$], companyId);

create index IX_EBB640F on MatriImages (userId);
create index IX_F5EF8789 on MatriImages (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_BB965C4B on MatriImages (uuid_[$COLUMN_LENGTH:75$], groupId);