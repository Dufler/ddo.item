-- https://ddowiki.com/page/Category:Named_augments
insert into augment(name, augment_type, ml) values('Facet of Psionic Intrusion', 'Orange', 32);
insert into augment_effect(id, augment_name, effect, effect_type, effect_value) values(augment_effect_sequence.nextval, 'Facet of Psionic Intrusion', 'Impulse', 'Equipment', 153);
insert into augment_effect(id, augment_name, effect, effect_type, effect_value) values(augment_effect_sequence.nextval, 'Facet of Psionic Intrusion', 'Domination Immunity', NULL, NULL);
insert into augment(name, augment_type, ml) values('Ravil''s Book of Legendary Recipes', 'Colorless', 32);
insert into augment_effect(id, augment_name, effect, effect_type, effect_value) values(augment_effect_sequence.nextval, 'Ravil''s Book of Legendary Recipes', 'Hit Points', 'Vitality', 48);
insert into augment(name, augment_type, ml) values('Legendary Swordcrossed Topaz', 'Yellow', 30);
insert into augment_effect(id, augment_name, effect, effect_type, effect_value) values(augment_effect_sequence.nextval, 'Legendary Swordcrossed Topaz', 'Doublestrike', 'Enhancement', 15);
insert into augment(name, augment_type, ml) values('Legendary Arrowbound Topaz', 'Yellow', 30);
insert into augment_effect(id, augment_name, effect, effect_type, effect_value) values(augment_effect_sequence.nextval, 'Legendary Arrowbound Topaz', 'Doubleshot', 'Enhancement', 8);


--insert into augment(name, augment_type, ml) values('', 'Yellow', 30);
--insert into augment_effect(id, augment_name, effect, effect_type, effect_value) values(augment_effect_sequence.nextval, '', '', 'Enhancement', 15);
