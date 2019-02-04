
select * from USER;

select username from USER;

delete from `USER` where id=1;

# inner join
select * 
from `timerecord` 
inner join `user` on `timerecord`.`user` = `user`.userId;  

# left join
select * 
from `timerecord` 
left join `user` on `timerecord`.`user` = `user`.userId;  

# right join
select * 
from `timerecord` 
right join `user` on `timerecord`.`user` = `user`.userId;  

select idRecord, record, type, username
from `timerecord` 
inner join `user` on `timerecord`.`user` = `user`.userId;  

select * from `timerecord` ;

select t.idRecord, t.record, t.type, t.user, u.username 
from TIMERECORD t, `USER` u 
where t.user = u.userId 
and userId = 1;


create table if not exists `TIMERECORD` (
	`idRecord` int not null primary key auto_increment,
    `record` datetime not null,
    `type` ENUM('ENTRY','EXIT') not null, 
    # Only possible value  is ENTRY or EXIT 
    `user` int not null,
    foreign key(`user`) references `USER`(`userId`)
);

SELECT * FROM TIMERECORD;

delete from TIMERECORD where idRecord = 4;

insert into `TIMERECORD`(`record`, `type`, `user`) 
VALUES(now(), 'ENTRY', '1');

insert into `TIMERECORD`(`record`, `type`, `user`) 
VALUES(now(), 'EXIT', '1');



