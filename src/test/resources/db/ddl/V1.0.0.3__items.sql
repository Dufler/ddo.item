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
	effect_type varchar(50),
	effect_value numeric(4,0)
	
);
alter table item_effects add constraint pk_item_effects primary key (id);
alter table item_effects add constraint fk_item_effects_item foreign key (item_name) references item(name) on delete cascade;
alter table item_effects add constraint fk_item_effects_name foreign key (effect) references effect(name) on delete cascade;

create table item_augment (
	item_name varchar(200) not null,
	augment_type varchar(100) not null
);
alter table item_augment add constraint pk_item_augment primary key (item_name,augment_type);
alter table item_augment add constraint fk_item_augment_item foreign key (item_name) references item(name) on delete cascade;
alter table item_augment add constraint fk_item_augment_augment foreign key (augment_type) references augment_type(name) on delete cascade;

create table item_skippable (
	name varchar(200) not null
);
alter table item_skippable add constraint pk_item_skippable primary key (name);
