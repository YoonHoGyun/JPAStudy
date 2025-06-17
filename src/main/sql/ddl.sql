create table user(
	email varchar(200) not null primary key,
	name varchar(50) not null,
	address1 varchar(200),
	address2 varchar(200),
	zipcode varchar(100),
	create_date datetime
);
