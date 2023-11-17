-- https://ddowiki.com/page/Augment_Slot#Augment_Slot
-- Augment Types
insert into augment_type(name) values('Colorless');
insert into augment_type_alias(alias, augment_type) values('Colorless Augment Slot: Empty', 'Colorless');
insert into augment_type_alias(alias, augment_type) values('Colorless Augment Slot:', 'Colorless');
insert into augment_type_alias(alias, augment_type) values('Colorless Augment Slot', 'Colorless');
insert into augment_type(name) values('Blue');
insert into augment_type_alias(alias, augment_type) values('Blue Augment Slot: Empty', 'Blue');
insert into augment_type_alias(alias, augment_type) values('Blue Augment Slot:', 'Blue');
insert into augment_type_alias(alias, augment_type) values('Blue Augment Slot', 'Blue');
insert into augment_type(name) values('Yellow');
insert into augment_type_alias(alias, augment_type) values('Yellow Augment Slot: Empty', 'Yellow');
insert into augment_type_alias(alias, augment_type) values('Yellow Augment Slot:', 'Yellow');
insert into augment_type_alias(alias, augment_type) values('Yellow Augment Slot', 'Yellow');
insert into augment_type(name) values('Red');
insert into augment_type_alias(alias, augment_type) values('Red Augment Slot: Empty', 'Red');
insert into augment_type_alias(alias, augment_type) values('Red Augment Slot:', 'Red');
insert into augment_type_alias(alias, augment_type) values('Red Augment Slot', 'Red');
insert into augment_type(name) values('Green');
insert into augment_type_alias(alias, augment_type) values('Green Augment Slot: Empty', 'Green');
insert into augment_type_alias(alias, augment_type) values('Green Augment Slot:', 'Green');
insert into augment_type_alias(alias, augment_type) values('Green Augment Slot', 'Green');
insert into augment_type(name) values('Purple');
insert into augment_type_alias(alias, augment_type) values('Purple Augment Slot: Empty', 'Purple');
insert into augment_type_alias(alias, augment_type) values('Purple Augment Slot:', 'Purple');
insert into augment_type_alias(alias, augment_type) values('Purple Augment Slot', 'Purple');
insert into augment_type(name) values('Orange');
insert into augment_type_alias(alias, augment_type) values('Orange Augment Slot: Empty', 'Orange');
insert into augment_type_alias(alias, augment_type) values('Orange Augment Slot:', 'Orange');
insert into augment_type_alias(alias, augment_type) values('Orange Augment Slot', 'Orange');
-- Colorless
-- stat +1 ml 1
insert into augment(name, augment_type, ml) values('Diamond of Strength +1', 'Colorless', 1);
insert into augment_effect(id, augment_name, effect, effect_type, effect_value) values(augment_effect_sequence.nextval, 'Diamond of Strength +1', 'Strength', 'Enhancement', 1);
insert into augment(name, augment_type, ml) values('Diamond of Dexterity +1', 'Colorless', 1);
insert into augment_effect(id, augment_name, effect, effect_type, effect_value) values(augment_effect_sequence.nextval, 'Diamond of Dexterity +1', 'Dexterity', 'Enhancement', 1);
insert into augment(name, augment_type, ml) values('Diamond of Constitution +1', 'Colorless', 1);
insert into augment_effect(id, augment_name, effect, effect_type, effect_value) values(augment_effect_sequence.nextval, 'Diamond of Constitution +1', 'Constitution', 'Enhancement', 1);
insert into augment(name, augment_type, ml) values('Diamond of Intelligence +1', 'Colorless', 1);
insert into augment_effect(id, augment_name, effect, effect_type, effect_value) values(augment_effect_sequence.nextval, 'Diamond of Intelligence +1', 'Intelligence', 'Enhancement', 1);
insert into augment(name, augment_type, ml) values('Diamond of Wisdom +1', 'Colorless', 1);
insert into augment_effect(id, augment_name, effect, effect_type, effect_value) values(augment_effect_sequence.nextval, 'Diamond of Wisdom +1', 'Wisdom', 'Enhancement', 1);
insert into augment(name, augment_type, ml) values('Diamond of Charisma +1', 'Colorless', 1);
insert into augment_effect(id, augment_name, effect, effect_type, effect_value) values(augment_effect_sequence.nextval, 'Diamond of Charisma +1', 'Charisma', 'Enhancement', 1);
-- stats +3 ml 4
insert into augment(name, augment_type, ml) values('Diamond of Strength +3', 'Colorless', 4);
insert into augment_effect(id, augment_name, effect, effect_type, effect_value) values(augment_effect_sequence.nextval, 'Diamond of Strength +3', 'Strength', 'Enhancement', 3);
insert into augment(name, augment_type, ml) values('Diamond of Dexterity +3', 'Colorless', 4);
insert into augment_effect(id, augment_name, effect, effect_type, effect_value) values(augment_effect_sequence.nextval, 'Diamond of Dexterity +3', 'Dexterity', 'Enhancement', 3);
insert into augment(name, augment_type, ml) values('Diamond of Constitution +3', 'Colorless', 4);
insert into augment_effect(id, augment_name, effect, effect_type, effect_value) values(augment_effect_sequence.nextval, 'Diamond of Constitution +3', 'Constitution', 'Enhancement', 3);
insert into augment(name, augment_type, ml) values('Diamond of Intelligence +3', 'Colorless', 4);
insert into augment_effect(id, augment_name, effect, effect_type, effect_value) values(augment_effect_sequence.nextval, 'Diamond of Intelligence +3', 'Intelligence', 'Enhancement', 3);
insert into augment(name, augment_type, ml) values('Diamond of Wisdom +3', 'Colorless', 4);
insert into augment_effect(id, augment_name, effect, effect_type, effect_value) values(augment_effect_sequence.nextval, 'Diamond of Wisdom +3', 'Wisdom', 'Enhancement', 3);
insert into augment(name, augment_type, ml) values('Diamond of Charisma +3', 'Colorless', 4);
insert into augment_effect(id, augment_name, effect, effect_type, effect_value) values(augment_effect_sequence.nextval, 'Diamond of Charisma +3', 'Charisma', 'Enhancement', 3);
-- stats +5 ml 8
insert into augment(name, augment_type, ml) values('Diamond of Strength +5', 'Colorless', 8);
insert into augment_effect(id, augment_name, effect, effect_type, effect_value) values(augment_effect_sequence.nextval, 'Diamond of Strength +5', 'Strength', 'Enhancement', 5);
insert into augment(name, augment_type, ml) values('Diamond of Dexterity +5', 'Colorless', 8);
insert into augment_effect(id, augment_name, effect, effect_type, effect_value) values(augment_effect_sequence.nextval, 'Diamond of Dexterity +5', 'Dexterity', 'Enhancement', 5);
insert into augment(name, augment_type, ml) values('Diamond of Constitution +5', 'Colorless', 8);
insert into augment_effect(id, augment_name, effect, effect_type, effect_value) values(augment_effect_sequence.nextval, 'Diamond of Constitution +5', 'Constitution', 'Enhancement', 5);
insert into augment(name, augment_type, ml) values('Diamond of Intelligence +5', 'Colorless', 8);
insert into augment_effect(id, augment_name, effect, effect_type, effect_value) values(augment_effect_sequence.nextval, 'Diamond of Intelligence +5', 'Intelligence', 'Enhancement', 5);
insert into augment(name, augment_type, ml) values('Diamond of Wisdom +5', 'Colorless', 8);
insert into augment_effect(id, augment_name, effect, effect_type, effect_value) values(augment_effect_sequence.nextval, 'Diamond of Wisdom +5', 'Wisdom', 'Enhancement', 5);
insert into augment(name, augment_type, ml) values('Diamond of Charisma +5', 'Colorless', 8);
insert into augment_effect(id, augment_name, effect, effect_type, effect_value) values(augment_effect_sequence.nextval, 'Diamond of Charisma +5', 'Charisma', 'Enhancement', 5);
-- Blue ml 1
insert into augment(name, augment_type, ml) values('Sapphire of Natural Armor +1', 'Blue', 1);
insert into augment_effect(id, augment_name, effect, effect_type, effect_value) values(augment_effect_sequence.nextval, 'Sapphire of Natural Armor +1', 'Armor Bonus', 'Natural', 1);
insert into augment(name, augment_type, ml) values('Sapphire of Protection +1', 'Blue', 1);
insert into augment_effect(id, augment_name, effect, effect_type, effect_value) values(augment_effect_sequence.nextval, 'Sapphire of Protection +1', 'Armor Bonus', 'Deflection', 1);
insert into augment(name, augment_type, ml) values('Sapphire of Resistance +1', 'Blue', 1);
insert into augment_effect(id, augment_name, effect, effect_type, effect_value) values(augment_effect_sequence.nextval, 'Sapphire of Resistance +1', 'Resistance', 'Enhancement', 1);
insert into augment(name, augment_type, ml) values('Sapphire of Sheltering 3', 'Blue', 1);
insert into augment_effect(id, augment_name, effect, effect_type, effect_value) values(augment_effect_sequence.nextval, 'Sapphire of Sheltering 3', 'Physical Sheltering', 'Enhancement', 3);
insert into augment_effect(id, augment_name, effect, effect_type, effect_value) values(augment_effect_sequence.nextval, 'Sapphire of Sheltering 3', 'Magical Sheltering', 'Enhancement', 3);
insert into augment(name, augment_type, ml) values('Sapphire of Light Fortification', 'Blue', 1);
insert into augment_effect(id, augment_name, effect, effect_type, effect_value) values(augment_effect_sequence.nextval, 'Sapphire of Light Fortification', 'Fortification', 'Enhancement', 25);
insert into augment(name, augment_type, ml) values('Sapphire of False Life +4', 'Blue', 1);
insert into augment_effect(id, augment_name, effect, effect_type, effect_value) values(augment_effect_sequence.nextval, 'Sapphire of False Life +4', 'Hit Points', 'Enhancement', 4);
insert into augment(name, augment_type, ml) values('Sapphire of Dodge +1', 'Blue', 1);
insert into augment_effect(id, augment_name, effect, effect_type, effect_value) values(augment_effect_sequence.nextval, 'Sapphire of Dodge +1', 'Dodge', 'Enhancement', 1);
insert into augment(name, augment_type, ml) values('Sapphire of Stunning +2', 'Blue', 1);
insert into augment_effect(id, augment_name, effect, effect_type, effect_value) values(augment_effect_sequence.nextval, 'Sapphire of Stunning +2', 'Stunning', 'Enhancement', 2);
insert into augment(name, augment_type, ml) values('Sapphire of Sunder +2', 'Blue', 1);
insert into augment_effect(id, augment_name, effect, effect_type, effect_value) values(augment_effect_sequence.nextval, 'Sapphire of Sunder +2', 'Sunder', 'Enhancement', 2);
insert into augment(name, augment_type, ml) values('Sapphire of Trip +2', 'Blue', 1);
insert into augment_effect(id, augment_name, effect, effect_type, effect_value) values(augment_effect_sequence.nextval, 'Sapphire of Trip +2', 'Trip', 'Enhancement', 2);
insert into augment(name, augment_type, ml) values('Sapphire of Accuracy +2', 'Blue', 1);
insert into augment_effect(id, augment_name, effect, effect_type, effect_value) values(augment_effect_sequence.nextval, 'Sapphire of Accuracy +2', 'Accuracy', 'Competence', 2);
insert into augment(name, augment_type, ml) values('Sapphire of Healing Amplification +3', 'Blue', 1);
insert into augment_effect(id, augment_name, effect, effect_type, effect_value) values(augment_effect_sequence.nextval, 'Sapphire of Healing Amplification +3', 'Healing Amplification', 'Competence', 3);
insert into augment(name, augment_type, ml) values('Sapphire of Repair Amplification +3', 'Blue', 1);
insert into augment_effect(id, augment_name, effect, effect_type, effect_value) values(augment_effect_sequence.nextval, 'Sapphire of Repair Amplification +3', 'Repair Amplification', 'Enhancement', 3);
insert into augment(name, augment_type, ml) values('Sapphire of Negative Amplification +3', 'Blue', 1);
insert into augment_effect(id, augment_name, effect, effect_type, effect_value) values(augment_effect_sequence.nextval, 'Sapphire of Negative Amplification +3', 'Negative Amplification', 'Profane', 3);
-- Yellow ml 1
insert into augment(name, augment_type, ml) values('Topaz of Fire Resistance', 'Yellow', 1);
insert into augment_effect(id, augment_name, effect, effect_type, effect_value) values(augment_effect_sequence.nextval, 'Topaz of Fire Resistance', 'Fire Resistance', 'Enhancement', 5);
insert into augment(name, augment_type, ml) values('Topaz of Cold Resistance', 'Yellow', 1);
insert into augment_effect(id, augment_name, effect, effect_type, effect_value) values(augment_effect_sequence.nextval, 'Topaz of Cold Resistance', 'Cold Resistance', 'Enhancement', 5);
insert into augment(name, augment_type, ml) values('Topaz of Acid Resistance', 'Yellow', 1);
insert into augment_effect(id, augment_name, effect, effect_type, effect_value) values(augment_effect_sequence.nextval, 'Topaz of Acid Resistance', 'Acid Resistance', 'Enhancement', 5);
insert into augment(name, augment_type, ml) values('Topaz of Electric Resistance', 'Yellow', 1);
insert into augment_effect(id, augment_name, effect, effect_type, effect_value) values(augment_effect_sequence.nextval, 'Topaz of Electric Resistance', 'Electric Resistance', 'Enhancement', 5);
insert into augment(name, augment_type, ml) values('Topaz of Sonic Resistance', 'Yellow', 1);
insert into augment_effect(id, augment_name, effect, effect_type, effect_value) values(augment_effect_sequence.nextval, 'Topaz of Sonic Resistance', 'Sonic Resistance', 'Enhancement', 5);
insert into augment(name, augment_type, ml) values('Topaz of Spell Points +19', 'Yellow', 1);
insert into augment_effect(id, augment_name, effect, effect_type, effect_value) values(augment_effect_sequence.nextval, 'Topaz of Spell Points +19', 'Wizardry', 'Enhancement', 19);
insert into augment(name, augment_type, ml) values('Topaz of Striding 10', 'Yellow', 1);
insert into augment_effect(id, augment_name, effect, effect_type, effect_value) values(augment_effect_sequence.nextval, 'Topaz of Striding 10', 'Striding', 'Enhancement', 10);
insert into augment(name, augment_type, ml) values('Topaz of Spell Penetration +1', 'Yellow', 1);
insert into augment_effect(id, augment_name, effect, effect_type, effect_value) values(augment_effect_sequence.nextval, 'Topaz of Spell Penetration +1', 'Spell Penetration', 'Equipment', 1);
insert into augment(name, augment_type, ml) values('Topaz of Deadly +1', 'Yellow', 1);
insert into augment_effect(id, augment_name, effect, effect_type, effect_value) values(augment_effect_sequence.nextval, 'Topaz of Deadly +1', 'Deadly', 'Competence', 1);
