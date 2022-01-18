create table income
(
    id          bigint         not null auto_increment,
    description varchar(50)    not null,
    value       decimal(10, 2) not null,
    date        datetime(6) not null,
    primary key (id)
) engine=InnoDB default charset=utf8;

create table outgoing
(
    id          bigint         not null auto_increment,
    description varchar(50)    not null,
    value       decimal(10, 2) not null,
    date        datetime(6) not null,
    primary key (id)
) engine=InnoDB default charset=utf8;

