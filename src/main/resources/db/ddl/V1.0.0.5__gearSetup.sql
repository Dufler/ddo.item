create sequence gear_setup_sequence;
create table gear_setup (
	id numeric(10,0) not null,
	name varchar(100) not null,
	description varchar(500),
	last_saved datetime not null
);
alter table gear_setup add constraint pk_gear_setup primary key (id);

create table gear_setup_item (
	id_setup numeric(10,0) not null,
	slot varchar(50) not null,
	item varchar(200)
);
alter table gear_setup_item add constraint pk_gear_setup_item primary key (id_setup, slot);
alter table gear_setup_item add constraint fk_gear_setup_item_setup foreign key (id_setup) references gear_setup(id) on delete cascade;
alter table gear_setup_item add constraint fk_gear_setup_item_item foreign key (item) references item(name) on delete cascade;

create table gear_setup_augment (
	id_setup numeric(10,0) not null,
	item varchar(200) not null,
	augment_type varchar(100) not null,
	augment varchar(100)
);
alter table gear_setup_augment add constraint pk_gear_setup_augment primary key (id_setup, item, augment_type);
alter table gear_setup_augment add constraint fk_gear_setup_augment_setup foreign key (id_setup) references gear_setup(id) on delete cascade;
alter table gear_setup_augment add constraint fk_gear_setup_augment_item foreign key (item) references item(name) on delete cascade;