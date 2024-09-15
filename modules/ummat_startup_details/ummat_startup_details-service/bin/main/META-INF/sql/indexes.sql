create index IX_E8B88DD8 on TNUMMAT_MatriUser (area[$COLUMN_LENGTH:75$]);
create index IX_419CD69A on TNUMMAT_MatriUser (district, area[$COLUMN_LENGTH:75$]);
create index IX_CC61B077 on TNUMMAT_MatriUser (userId, companyId);
create index IX_6214B80B on TNUMMAT_MatriUser (uuid_[$COLUMN_LENGTH:75$], companyId);