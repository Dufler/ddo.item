create table item (
	name varchar(200) not null,
	slot varchar(20) not null,
	ml numeric(3,0) not null
);
alter table item add constraint pk_item primary key (name);

create sequence item_effects_sequence;
create table item_effects (
	id numeric(10,0) not null,
	item_name varchar(200) not null,
	effect varchar(100) not null,
	effect_type varchar(20),
	effect_value numeric(3,0)
	
);
alter table item_effects add constraint pk_item_effects primary key (id);
alter table item_effects add constraint fk_item_effects foreign key (item_name) references item(name) on delete cascade;

create view effect as select distinct effect from item_effects;