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
