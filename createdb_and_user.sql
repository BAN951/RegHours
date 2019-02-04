drop database if exists REGHOURS;
create database if not exists REGHOURS;
use REGHOURS;

drop table if exists `TIMERECORD`;
drop table if exists `USER`;

create table if not exists `USER` (
	`userId` int not null auto_increment primary key,
	`username` varchar(32) not null unique,
    `firstname` varchar(48) not null,
    `lastname` varchar(90) not null, 
    `email` varchar(68) not null,
    `passwd` varchar(64) not null #sha256 encoded password
);

create table if not exists `TIMERECORD` (
	`idRecord` int not null primary key auto_increment,
    `record` datetime not null,
    `type` ENUM('ENTRY','EXIT') not null, 
    # Only possible value  is ENTRY or EXIT 
    `user` int not null,
    foreign key(`user`) references `USER`(`userId`)
);

create user if not exists 'reghours'@'localhost' 
identified by 'reghourspasswd';

grant select, insert, update, delete
	on REGHOURS.*
    to 'reghours'@'localhost';
       