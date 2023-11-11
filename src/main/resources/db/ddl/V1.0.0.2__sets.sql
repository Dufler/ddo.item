create sequence item_set_sequence;
create table named_set (
	id numeric(10,0) not null,
	name varchar(100) not null,
	pieces numeric(3,0) not null
);
alter table named_set add constraint pk_named_set primary key(id);

create table namd_set_item (
	named_set_id numeric(10,0) not null,
	item_id numeric(10,0) not null
);
alter table named_set_item add constraint pk_named_set_item primary key (named_set_id, item_id);
alter table named_set_item add constraint fk_named_set_item_set foreign key (named_set_id) references named_set(id);
alter table named_set_item add constraint fk_named_set_item_item foreign key (item_id) references item(id);
