create table if not exists configuration (
  serial INT PRIMARY KEY,
  device_name VARCHAR (250) not null,
  hue INT not null,
  sat INT not null,
  bright INT not null,
  state varchar (250) not null,
  status varchar (250) not null,
  room varchar (250) not null,
  device_type varchar (250) not null
);

create table if not exists unassignedDevices (
  serial INT PRIMARY KEY,
  device_type varchar (250) not null
    );

-- drop table configuration;
-- drop table unassignedDevices;

-- drop  table configuration;
--
-- create table if not exists users(
-- id Int auto_increment primary key,
-- login varchar (250) not null,
-- password varchar (250) not null,
-- admin bit not null
-- );
--
-- create table if not exists rooms(
-- id Int auto_increment primary key,
-- room varchar (250) not null,
-- room_type varchar (250) not null,
-- admin bit not null
-- );
--
-- create table if not exists deviceTypes(
-- id Int auto_increment primary key,
-- device_type varchar (250) not null
-- );
