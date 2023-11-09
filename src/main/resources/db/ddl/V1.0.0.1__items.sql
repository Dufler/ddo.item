create sequence item_sequence;
create sequence item_effects_sequence;
create table item (
	id numeric(10,0) not null,
	name varchar(200) not null,
	slot varchar(20) not null
);
alter table item add constraint pk_item primary key (id);
create table item_effects (
	id numeric(10,0) not null,
	item_id numeric(10,0) not null,
	effect varchar(100) not null,
	effect_type varchar(20),
	effect_value numeric(3,0)
	
);
alter table item_effects add constraint pk_item_effects primary key (id);
alter table item_effects add constraint fk_item_effects foreign key (item_id) references item(id) on delete cascade;