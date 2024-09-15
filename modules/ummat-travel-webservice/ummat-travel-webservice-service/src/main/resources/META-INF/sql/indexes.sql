create index IX_4B7A1654 on UMMATLife_DriverDetail (userId, companyId);

create index IX_BE7F0F07 on UMMATLife_TravelUser (area[$COLUMN_LENGTH:75$]);
create index IX_ABF2E909 on UMMATLife_TravelUser (district, area[$COLUMN_LENGTH:75$]);
create index IX_968C0281 on UMMATLife_TravelUser (travelUserEmail[$COLUMN_LENGTH:75$]);
create index IX_A68B1C3C on UMMATLife_TravelUser (travelUserPhoneNumber[$COLUMN_LENGTH:75$]);
create index IX_42ACD3A8 on UMMATLife_TravelUser (userId, companyId);
create index IX_8F2FEABA on UMMATLife_TravelUser (uuid_[$COLUMN_LENGTH:75$], companyId);