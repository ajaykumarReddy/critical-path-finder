create table project_data
(
   id integer not null,
   name varchar(255) not null,
   descrption varchar(255) not null,
   primary key(id)
);

create table task_data
(
	id integer not null,
	project_id integer not null, 
	name varchar(255) not null,
	duration integer not null,
	prerequisites varchar(255),
	primary key(id)
);