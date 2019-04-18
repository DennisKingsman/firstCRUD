drop table if exists f_autos;
drop table if exists f_users;


create table f_users
(
	user_id SERIAL,
	user_name varchar(30),
	user_age int,
	primary key(user_id)
);

create table f_autos
(
	auto_id SERIAL,
	auto_model varchar(40),
	auto_color varchar(30),
	a_user_id integer,
	primary key(auto_id),
	foreign key(a_user_id) references f_users(user_id) on delete restrict
);