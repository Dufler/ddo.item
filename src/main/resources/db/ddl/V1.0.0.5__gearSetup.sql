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
	item varchar(200) not null
);
alter table gear_setup_item add constraint pk_gear_setup_item primary key (id, slot);
alter table gear_setup_item add constraint fk_gear_setup_item_setup foreing key (id_setup) references gear_setup(id);
alter table gear_setup_item add constraint fk_gear_setup_item_item foreing key (item) references item(name);
