create table effect (
	name varchar(100) not null,
	description varchar(500),
	effect_type varchar(50) not null
);
alter table effect add constraint pk_effect primary key (name);

create table effect_alias (
	name varchar(200) not null,
	description varchar(500) not null
);
alter table effect_alias add constraint pk_effect_alias primary key (name);

create sequence effect_alias_list_sequence;
create table effect_alias_list (
	id numeric(10,0) not null,
	effect_name varchar(200) not null,
	effect varchar(100) not null,
	effect_type varchar(50),
	effect_value numeric(4,0)
);
alter table effect_alias_list add constraint pk_effect_alias_list primary key (id);
alter table effect_alias_list add constraint fk_effect_alias_list_effect foreign key (effect) references effect(name) on delete cascade;
alter table effect_alias_list add constraint fk_effect_alias_list_alias foreign key (effect_name) references effect_alias(name) on delete cascade;
