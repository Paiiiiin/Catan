drop database if exists catan;
create database catan;
use catan;

create table player(
player_id int auto_increment primary key not null,
stone int,
grain int,
wood int,
sheep int,
ore int,
knight int,
monopoly int,
invention int,
freeRoads int,
victoryPointsVisible int,
victoryPoints int
);

insert into player
values (
1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);

insert into player
values (
2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);

insert into player
values (
3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);

insert into player
values (
4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);

