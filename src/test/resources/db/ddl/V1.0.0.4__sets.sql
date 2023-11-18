create table named_set (
	name varchar(200) not null,
	pieces numeric(3,0) not null
);
alter table named_set add constraint pk_named_set primary key(name);

create table named_set_item (
	set_name varchar(200) not null,
	item_name varchar(200) not null
);
alter table named_set_item add constraint pk_named_set_item primary key (set_name, item_name);
alter table named_set_item add constraint fk_named_set_item_set foreign key (set_name) references named_set(name);
alter table named_set_item add constraint fk_named_set_item_item foreign key (item_name) references item(name);

create sequence named_set_bonus_sequence;
create table named_set_bonus (
	id numeric(10,0) not null,
	set_name varchar(200) not null,
	effect varchar(100) not null,
	effect_type varchar(50),
	effect_value numeric(4,0)
);
alter table named_set_bonus add constraint pk_named_set_bonus primary key (id);
alter table named_set_bonus add constraint fk_named_set_bonus foreign key (set_name) references named_set(name) on delete cascade;
