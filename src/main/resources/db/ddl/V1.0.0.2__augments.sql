create table augment_type (
	name varchar(100) not null
);
alter table augment_type add constraint pk_augment_type primary key(name);

create table augment_type_alias (
	alias varchar(500) not null,
	augment_type varchar(100) not null
);
alter table augment_type_alias add constraint pk_augment_type_alias primary key(alias);
alter table augment_type_alias add constraint fk_augment_type_alias foreign key(augment_type) references augment_type(name);

create table augment (
	name varchar(100) not null,
	augment_type varchar(100) not null,
	ml numeric(4,0) not null
);
alter table augment add constraint pk_augment primary key(name);
alter table augment add constraint fk_augment foreign key(augment_type) references augment_type(name);

create sequence augment_effect_sequence;
create table augment_effect (
	id numeric(10,0) not null,
	augment_name varchar(100) not null,
	effect varchar(100) not null,
	effect_type varchar(50),
	effect_value numeric(4,0)
);
alter table augment_effect add constraint pk_augment_effect primary key(id);
alter table augment_effect add constraint fk_augment_effect foreign key(augment_name) references augment(name);
