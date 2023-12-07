-- https://ddowiki.com/page/Dinosaur_Bone_crafting
insert into augment_type(name) values('Scale Weapon Slot');
insert into augment_type_alias(alias, augment_type) values('Isle of Dread: Scale Slot (Weapon): Empty', 'Scale Weapon Slot');
insert into augment(name, augment_type, ml) values('Flamescale', 'Scale Weapon Slot', 31);
insert into augment_effect(id, augment_name, effect, effect_type, effect_value) values(augment_effect_sequence.nextval, 'Flamescale', 'DR Bypass', 'Adamantine', NULL);
insert into augment_effect(id, augment_name, effect, effect_type, effect_value) values(augment_effect_sequence.nextval, 'Flamescale', 'Flaming', NULL, 15);
insert into augment(name, augment_type, ml) values('Icescale', 'Scale Weapon Slot', 31);
insert into augment_effect(id, augment_name, effect, effect_type, effect_value) values(augment_effect_sequence.nextval, 'Icescale', 'DR Bypass', 'Cold Iron', NULL);
insert into augment_effect(id, augment_name, effect, effect_type, effect_value) values(augment_effect_sequence.nextval, 'Icescale', 'Frost', NULL, 15);
insert into augment(name, augment_type, ml) values('Sparkscale', 'Scale Weapon Slot', 31);
insert into augment_effect(id, augment_name, effect, effect_type, effect_value) values(augment_effect_sequence.nextval, 'Sparkscale', 'DR Bypass', 'Silver', NULL);
insert into augment_effect(id, augment_name, effect, effect_type, effect_value) values(augment_effect_sequence.nextval, 'Sparkscale', 'Shock', NULL, 15);
insert into augment(name, augment_type, ml) values('Meltscale', 'Scale Weapon Slot', 31);
insert into augment_effect(id, augment_name, effect, effect_type, effect_value) values(augment_effect_sequence.nextval, 'Meltscale', 'DR Bypass', 'Byeshk', NULL);
insert into augment_effect(id, augment_name, effect, effect_type, effect_value) values(augment_effect_sequence.nextval, 'Meltscale', 'Acid', NULL, 15);
insert into augment(name, augment_type, ml) values('Brightscale', 'Scale Weapon Slot', 31);
insert into augment_effect(id, augment_name, effect, effect_type, effect_value) values(augment_effect_sequence.nextval, 'Brightscale', 'Spell Penetration', 'Equipment', 9);
insert into augment_effect(id, augment_name, effect, effect_type, effect_value) values(augment_effect_sequence.nextval, 'Brightscale', 'Spell Focus Mastery', 'Exceptional', 2);
insert into augment(name, augment_type, ml) values('Shadowscale', 'Scale Weapon Slot', 31);
insert into augment_effect(id, augment_name, effect, effect_type, effect_value) values(augment_effect_sequence.nextval, 'Shadowscale', 'Magical Efficiency', 'Enhancement', 10);
insert into augment_effect(id, augment_name, effect, effect_type, effect_value) values(augment_effect_sequence.nextval, 'Shadowscale', 'Spell Focus Mastery', 'Exceptional', 2);
insert into augment(name, augment_type, ml) values('Iridiscent Scale', 'Scale Weapon Slot', 31);
insert into augment_effect(id, augment_name, effect, effect_type, effect_value) values(augment_effect_sequence.nextval, 'Iridiscent Scale', 'Potency', 'Enhancement', 102);
insert into augment_effect(id, augment_name, effect, effect_type, effect_value) values(augment_effect_sequence.nextval, 'Iridiscent Scale', 'Spell Focus Mastery', 'Exceptional', 2);
insert into augment_type(name) values('Fang Weapon Slot');
insert into augment_type_alias(alias, augment_type) values('Isle of Dread: Fang Slot (Weapon): Empty', 'Fang Weapon Slot');
insert into augment(name, augment_type, ml) values('Flamefang', 'Fang Weapon Slot', 31);
insert into augment_effect(id, augment_name, effect, effect_type, effect_value) values(augment_effect_sequence.nextval, 'Flamefang', 'DR Bypass', 'Good', NULL);
insert into augment_effect(id, augment_name, effect, effect_type, effect_value) values(augment_effect_sequence.nextval, 'Flamefang', 'Alchemical Fire Attunement', NULL, NULL);
insert into augment(name, augment_type, ml) values('Icefang', 'Fang Weapon Slot', 31);
insert into augment_effect(id, augment_name, effect, effect_type, effect_value) values(augment_effect_sequence.nextval, 'Icefang', 'DR Bypass', 'Chaotic', NULL);
insert into augment_effect(id, augment_name, effect, effect_type, effect_value) values(augment_effect_sequence.nextval, 'Icefang', 'Alchemical Water Attunement', NULL, NULL);
insert into augment(name, augment_type, ml) values('Sparkfang', 'Fang Weapon Slot', 31);
insert into augment_effect(id, augment_name, effect, effect_type, effect_value) values(augment_effect_sequence.nextval, 'Sparkfang', 'DR Bypass', 'Lawful ', NULL);
insert into augment_effect(id, augment_name, effect, effect_type, effect_value) values(augment_effect_sequence.nextval, 'Sparkfang', 'Alchemical Air Attunement', NULL, NULL);
insert into augment(name, augment_type, ml) values('Meltfang', 'Fang Weapon Slot', 31);
insert into augment_effect(id, augment_name, effect, effect_type, effect_value) values(augment_effect_sequence.nextval, 'Meltfang', 'DR Bypass', 'Evil ', NULL);
insert into augment_effect(id, augment_name, effect, effect_type, effect_value) values(augment_effect_sequence.nextval, 'Meltfang', 'Alchemical Earth Attunement', NULL, NULL);
insert into augment(name, augment_type, ml) values('Brightfang', 'Fang Weapon Slot', 31);
insert into augment_effect(id, augment_name, effect, effect_type, effect_value) values(augment_effect_sequence.nextval, 'Brightfang', 'Untyped Blast', NULL, NULL);
insert into augment(name, augment_type, ml) values('Shadowfang', 'Fang Weapon Slot', 31);
insert into augment_effect(id, augment_name, effect, effect_type, effect_value) values(augment_effect_sequence.nextval, 'Shadowfang', 'Curse Untyped DOT', NULL, NULL);
insert into augment(name, augment_type, ml) values('Iridiscent Fang', 'Fang Weapon Slot', 31);
insert into augment_effect(id, augment_name, effect, effect_type, effect_value) values(augment_effect_sequence.nextval, 'Iridiscent Fang', 'Spell Lore', 'Exceptional', 5);
insert into augment_effect(id, augment_name, effect, effect_type, effect_value) values(augment_effect_sequence.nextval, 'Iridiscent Fang', 'Spell Focus Mastery', 'Equipment', 5);
insert into augment_type(name) values('Claw Weapon Slot');
insert into augment_type_alias(alias, augment_type) values('Isle of Dread: Claw Slot (Weapon): Empty', 'Claw Weapon Slot');
insert into augment(name, augment_type, ml) values('Flameclaw', 'Claw Weapon Slot', 31);
insert into augment_effect(id, augment_name, effect, effect_type, effect_value) values(augment_effect_sequence.nextval, 'Flameclaw', 'Strength', 'Exceptional', 2);
insert into augment(name, augment_type, ml) values('Iceclaw', 'Claw Weapon Slot', 31);
insert into augment_effect(id, augment_name, effect, effect_type, effect_value) values(augment_effect_sequence.nextval, 'Iceclaw', 'Wisdom', 'Exceptional', 2);
insert into augment(name, augment_type, ml) values('Sparkclaw', 'Claw Weapon Slot', 31);
insert into augment_effect(id, augment_name, effect, effect_type, effect_value) values(augment_effect_sequence.nextval, 'Sparkclaw', 'Charisma', 'Exceptional', 2);
insert into augment(name, augment_type, ml) values('Meltclaw', 'Claw Weapon Slot', 31);
insert into augment_effect(id, augment_name, effect, effect_type, effect_value) values(augment_effect_sequence.nextval, 'Meltclaw', 'Constitution', 'Exceptional', 2);
insert into augment(name, augment_type, ml) values('Brightclaw', 'Claw Weapon Slot', 31);
insert into augment_effect(id, augment_name, effect, effect_type, effect_value) values(augment_effect_sequence.nextval, 'Brightclaw', 'Intelligence', 'Exceptional', 2);
insert into augment(name, augment_type, ml) values('Shadowclaw', 'Claw Weapon Slot', 31);
insert into augment_effect(id, augment_name, effect, effect_type, effect_value) values(augment_effect_sequence.nextval, 'Shadowclaw', 'Dexterity', 'Exceptional', 2);
insert into augment(name, augment_type, ml) values('Iridiscent Claw: Acid', 'Claw Weapon Slot', 31);
insert into augment_effect(id, augment_name, effect, effect_type, effect_value) values(augment_effect_sequence.nextval, 'Iridiscent Claw: Acid', 'Corrosion', 'Equipment', 149);
insert into augment(name, augment_type, ml) values('Iridiscent Claw: Cold', 'Claw Weapon Slot', 31);
insert into augment_effect(id, augment_name, effect, effect_type, effect_value) values(augment_effect_sequence.nextval, 'Iridiscent Claw: Cold', 'Glaciation', 'Equipment', 149);
insert into augment(name, augment_type, ml) values('Iridiscent Claw: Electric', 'Claw Weapon Slot', 31);
insert into augment_effect(id, augment_name, effect, effect_type, effect_value) values(augment_effect_sequence.nextval, 'Iridiscent Claw: Electric', 'Magnetism', 'Equipment', 149);
insert into augment(name, augment_type, ml) values('Iridiscent Claw: Fire', 'Claw Weapon Slot', 31);
insert into augment_effect(id, augment_name, effect, effect_type, effect_value) values(augment_effect_sequence.nextval, 'Iridiscent Claw: Fire', 'Combustion', 'Equipment', 149);
insert into augment(name, augment_type, ml) values('Iridiscent Claw: Force', 'Claw Weapon Slot', 31);
insert into augment_effect(id, augment_name, effect, effect_type, effect_value) values(augment_effect_sequence.nextval, 'Iridiscent Claw: Force', 'Impulse', 'Equipment', 149);
insert into augment(name, augment_type, ml) values('Iridiscent Claw: Light', 'Claw Weapon Slot', 31);
insert into augment_effect(id, augment_name, effect, effect_type, effect_value) values(augment_effect_sequence.nextval, 'Iridiscent Claw: Light', 'Radiance', 'Equipment', 149);
insert into augment(name, augment_type, ml) values('Iridiscent Claw: Negative', 'Claw Weapon Slot', 31);
insert into augment_effect(id, augment_name, effect, effect_type, effect_value) values(augment_effect_sequence.nextval, 'Iridiscent Claw: Negative', 'Nullification', 'Equipment', 149);
insert into augment(name, augment_type, ml) values('Iridiscent Claw: Positive', 'Claw Weapon Slot', 31);
insert into augment_effect(id, augment_name, effect, effect_type, effect_value) values(augment_effect_sequence.nextval, 'Iridiscent Claw: Positive', 'Devotion', 'Equipment', 149);
insert into augment(name, augment_type, ml) values('Iridiscent Claw: Repair', 'Claw Weapon Slot', 31);
insert into augment_effect(id, augment_name, effect, effect_type, effect_value) values(augment_effect_sequence.nextval, 'Iridiscent Claw: Repair', 'Reconstruction', 'Equipment', 149);
insert into augment(name, augment_type, ml) values('Iridiscent Claw: Sonic', 'Claw Weapon Slot', 31);
insert into augment_effect(id, augment_name, effect, effect_type, effect_value) values(augment_effect_sequence.nextval, 'Iridiscent Claw: Sonic', 'Resonance', 'Equipment', 149);
insert into augment_type(name) values('Horn Weapon Slot');
insert into augment_type_alias(alias, augment_type) values('Isle of Dread: Horn Slot (Weapon): Empty', 'Horn Weapon Slot');
insert into augment(name, augment_type, ml) values('Flamehorn', 'Horn Weapon Slot', 31);
insert into augment_effect(id, augment_name, effect, effect_type, effect_value) values(augment_effect_sequence.nextval, 'Flamehorn', 'Legendary Ash', NULL, NULL);
insert into augment(name, augment_type, ml) values('Icehorn', 'Horn Weapon Slot', 31);
insert into augment_effect(id, augment_name, effect, effect_type, effect_value) values(augment_effect_sequence.nextval, 'Icehorn', 'Legendary Ice', NULL, NULL);
insert into augment(name, augment_type, ml) values('Sparkhorn', 'Horn Weapon Slot', 31);
insert into augment_effect(id, augment_name, effect, effect_type, effect_value) values(augment_effect_sequence.nextval, 'Sparkhorn', 'Legendary Vacuum', NULL, NULL);
insert into augment(name, augment_type, ml) values('Melthorn', 'Horn Weapon Slot', 31);
insert into augment_effect(id, augment_name, effect, effect_type, effect_value) values(augment_effect_sequence.nextval, 'Melthorn', 'Legendary Dust', NULL, NULL);
insert into augment(name, augment_type, ml) values('Brighthorn', 'Horn Weapon Slot', 31);
insert into augment_effect(id, augment_name, effect, effect_type, effect_value) values(augment_effect_sequence.nextval, 'Brighthorn', 'Legendary Affirmation', NULL, NULL);
insert into augment(name, augment_type, ml) values('Shadowhorn', 'Horn Weapon Slot', 31);
insert into augment_effect(id, augment_name, effect, effect_type, effect_value) values(augment_effect_sequence.nextval, 'Shadowhorn', 'Constricting Nightmare', NULL, NULL);
insert into augment(name, augment_type, ml) values('Aspect of Tar', 'Horn Weapon Slot', 31);
insert into augment_effect(id, augment_name, effect, effect_type, effect_value) values(augment_effect_sequence.nextval, 'Aspect of Tar', 'Constricting Nightmare', NULL, NULL);
insert into augment_effect(id, augment_name, effect, effect_type, effect_value) values(augment_effect_sequence.nextval, 'Aspect of Tar', 'Tar Ooze', NULL, NULL);
insert into augment(name, augment_type, ml) values('Black Sands'' Desire', 'Horn Weapon Slot', 31);
insert into augment_effect(id, augment_name, effect, effect_type, effect_value) values(augment_effect_sequence.nextval, 'Black Sands'' Desire', 'Legendary Salt', NULL, NULL);
insert into augment_type(name) values('Scale Accessory Slot');
insert into augment_type_alias(alias, augment_type) values('Isle of Dread: Scale Slot (Accessory): Empty', 'Scale Accessory Slot');
insert into augment(name, augment_type, ml) values('Scale False Life', 'Scale Accessory Slot', 31);
insert into augment_effect(id, augment_name, effect, effect_type, effect_value) values(augment_effect_sequence.nextval, 'Scale False Life', 'Hit Points', 'Enhancement', 53);
insert into augment(name, augment_type, ml) values('Scale Strength', 'Scale Accessory Slot', 31);
insert into augment_effect(id, augment_name, effect, effect_type, effect_value) values(augment_effect_sequence.nextval, 'Scale Strength', 'Strength', 'Enhancement', 14);
insert into augment(name, augment_type, ml) values('Scale Dexterity', 'Scale Accessory Slot', 31);
insert into augment_effect(id, augment_name, effect, effect_type, effect_value) values(augment_effect_sequence.nextval, 'Scale Dexterity', 'Dexterity', 'Enhancement', 14);
insert into augment(name, augment_type, ml) values('Scale Constitution', 'Scale Accessory Slot', 31);
insert into augment_effect(id, augment_name, effect, effect_type, effect_value) values(augment_effect_sequence.nextval, 'Scale Constitution', 'Constitution', 'Enhancement', 14);
insert into augment(name, augment_type, ml) values('Scale Intelligence', 'Scale Accessory Slot', 31);
insert into augment_effect(id, augment_name, effect, effect_type, effect_value) values(augment_effect_sequence.nextval, 'Scale Intelligence', 'Intelligence', 'Enhancement', 14);
insert into augment(name, augment_type, ml) values('Scale Wisdom', 'Scale Accessory Slot', 31);
insert into augment_effect(id, augment_name, effect, effect_type, effect_value) values(augment_effect_sequence.nextval, 'Scale Wisdom', 'Wisdom', 'Enhancement', 14);
insert into augment(name, augment_type, ml) values('Scale Charisma', 'Scale Accessory Slot', 31);
insert into augment_effect(id, augment_name, effect, effect_type, effect_value) values(augment_effect_sequence.nextval, 'Scale Charisma', 'Charisma', 'Enhancement', 14);
insert into augment(name, augment_type, ml) values('Scale Acid Spell Crit Damage', 'Scale Accessory Slot', 31);
insert into augment_effect(id, augment_name, effect, effect_type, effect_value) values(augment_effect_sequence.nextval, 'Scale Acid Spell Crit Damage', 'Acid Spell Crit Damage', 'Enhancement', 20);
insert into augment(name, augment_type, ml) values('Scale Cold Spell Crit Damage', 'Scale Accessory Slot', 31);
insert into augment_effect(id, augment_name, effect, effect_type, effect_value) values(augment_effect_sequence.nextval, 'Scale Cold Spell Crit Damage', 'Cold Spell Crit Damage', 'Enhancement', 20);
insert into augment(name, augment_type, ml) values('Scale Electric Spell Crit Damage', 'Scale Accessory Slot', 31);
insert into augment_effect(id, augment_name, effect, effect_type, effect_value) values(augment_effect_sequence.nextval, 'Scale Electric Spell Crit Damage', 'Electric Spell Crit Damage', 'Enhancement', 20);
insert into augment(name, augment_type, ml) values('Scale Fire Spell Crit Damage', 'Scale Accessory Slot', 31);
insert into augment_effect(id, augment_name, effect, effect_type, effect_value) values(augment_effect_sequence.nextval, 'Scale Fire Spell Crit Damage', 'Fire Spell Crit Damage', 'Enhancement', 20);
insert into augment(name, augment_type, ml) values('Scale Force Spell Crit Damage', 'Scale Accessory Slot', 31);
insert into augment_effect(id, augment_name, effect, effect_type, effect_value) values(augment_effect_sequence.nextval, 'Scale Force Spell Crit Damage', 'Force Spell Crit Damage', 'Enhancement', 20);
insert into augment(name, augment_type, ml) values('Scale Light Spell Crit Damage', 'Scale Accessory Slot', 31);
insert into augment_effect(id, augment_name, effect, effect_type, effect_value) values(augment_effect_sequence.nextval, 'Scale Light Spell Crit Damage', 'Light Spell Crit Damage', 'Enhancement', 20);
insert into augment(name, augment_type, ml) values('Scale Negative Spell Crit Damage', 'Scale Accessory Slot', 31);
insert into augment_effect(id, augment_name, effect, effect_type, effect_value) values(augment_effect_sequence.nextval, 'Scale Negative Spell Crit Damage', 'Negative Spell Crit Damage', 'Enhancement', 20);
insert into augment(name, augment_type, ml) values('Scale Positive Spell Crit Damage', 'Scale Accessory Slot', 31);
insert into augment_effect(id, augment_name, effect, effect_type, effect_value) values(augment_effect_sequence.nextval, 'Scale Positive Spell Crit Damage', 'Positive Spell Crit Damage', 'Enhancement', 20);
insert into augment(name, augment_type, ml) values('Scale Repair Spell Crit Damage', 'Scale Accessory Slot', 31);
insert into augment_effect(id, augment_name, effect, effect_type, effect_value) values(augment_effect_sequence.nextval, 'Scale Repair Spell Crit Damage', 'Repair Spell Crit Damage', 'Enhancement', 20);
insert into augment(name, augment_type, ml) values('Scale Sonic Spell Crit Damage', 'Scale Accessory Slot', 31);
insert into augment_effect(id, augment_name, effect, effect_type, effect_value) values(augment_effect_sequence.nextval, 'Scale Sonic Spell Crit Damage', 'Sonic Spell Crit Damage', 'Enhancement', 20);
insert into augment_type(name) values('Fang Accessory Slot');
insert into augment_type_alias(alias, augment_type) values('Isle of Dread: Fang Slot (Accessory): Empty', 'Fang Accessory Slot');
insert into augment(name, augment_type, ml) values('Fang Healing Amplification', 'Fang Accessory Slot', 31);
insert into augment_effect(id, augment_name, effect, effect_type, effect_value) values(augment_effect_sequence.nextval, 'Fang Healing Amplification', 'Healing Amplification', 'Competence', 56);
insert into augment(name, augment_type, ml) values('Fang Repair Amplification', 'Fang Accessory Slot', 31);
insert into augment_effect(id, augment_name, effect, effect_type, effect_value) values(augment_effect_sequence.nextval, 'Fang Repair Amplification', 'Repair Amplification', 'Enhancement', 56);
insert into augment(name, augment_type, ml) values('Fang Negative Amplification', 'Fang Accessory Slot', 31);
insert into augment_effect(id, augment_name, effect, effect_type, effect_value) values(augment_effect_sequence.nextval, 'Fang Negative Amplification', 'Negative Amplification', 'Profane', 56);
insert into augment(name, augment_type, ml) values('Fang Accuracy', 'Fang Accessory Slot', 31);
insert into augment_effect(id, augment_name, effect, effect_type, effect_value) values(augment_effect_sequence.nextval, 'Fang Accuracy', 'Accuracy', 'Competence', 21);
insert into augment(name, augment_type, ml) values('Fang Deadly', 'Fang Accessory Slot', 31);
insert into augment_effect(id, augment_name, effect, effect_type, effect_value) values(augment_effect_sequence.nextval, 'Fang Deadly', 'Deadly', 'Competence', 11);
insert into augment(name, augment_type, ml) values('Fang Deception', 'Fang Accessory Slot', 31);
insert into augment_effect(id, augment_name, effect, effect_type, effect_value) values(augment_effect_sequence.nextval, 'Fang Deception', 'Deception', 'Enhancement', 11);
insert into augment(name, augment_type, ml) values('Fang Seeker', 'Fang Accessory Slot', 31);
insert into augment_effect(id, augment_name, effect, effect_type, effect_value) values(augment_effect_sequence.nextval, 'Fang Seeker', 'Seeker', 'Enhancement', 14);
insert into augment(name, augment_type, ml) values('Fang Acid Spell Crit Damage', 'Fang Accessory Slot', 31);
insert into augment_effect(id, augment_name, effect, effect_type, effect_value) values(augment_effect_sequence.nextval, 'Fang Acid Spell Crit Damage', 'Acid Spell Crit Damage', 'Insightful', 10);
insert into augment(name, augment_type, ml) values('Fang Cold Spell Crit Damage', 'Fang Accessory Slot', 31);
insert into augment_effect(id, augment_name, effect, effect_type, effect_value) values(augment_effect_sequence.nextval, 'Fang Cold Spell Crit Damage', 'Cold Spell Crit Damage', 'Insightful', 10);
insert into augment(name, augment_type, ml) values('Fang Electric Spell Crit Damage', 'Fang Accessory Slot', 31);
insert into augment_effect(id, augment_name, effect, effect_type, effect_value) values(augment_effect_sequence.nextval, 'Fang Electric Spell Crit Damage', 'Electric Spell Crit Damage', 'Insightful', 10);
insert into augment(name, augment_type, ml) values('Fang Fire Spell Crit Damage', 'Fang Accessory Slot', 31);
insert into augment_effect(id, augment_name, effect, effect_type, effect_value) values(augment_effect_sequence.nextval, 'Fang Fire Spell Crit Damage', 'Fire Spell Crit Damage', 'Insightful', 10);
insert into augment(name, augment_type, ml) values('Fang Force Spell Crit Damage', 'Fang Accessory Slot', 31);
insert into augment_effect(id, augment_name, effect, effect_type, effect_value) values(augment_effect_sequence.nextval, 'Fang Force Spell Crit Damage', 'Force Spell Crit Damage', 'Insightful', 10);
insert into augment(name, augment_type, ml) values('Fang Light Spell Crit Damage', 'Fang Accessory Slot', 31);
insert into augment_effect(id, augment_name, effect, effect_type, effect_value) values(augment_effect_sequence.nextval, 'Fang Light Spell Crit Damage', 'Light Spell Crit Damage', 'Insightful', 10);
insert into augment(name, augment_type, ml) values('Fang Negative Spell Crit Damage', 'Fang Accessory Slot', 31);
insert into augment_effect(id, augment_name, effect, effect_type, effect_value) values(augment_effect_sequence.nextval, 'Fang Negative Spell Crit Damage', 'Negative Spell Crit Damage', 'Insightful', 10);
insert into augment(name, augment_type, ml) values('Fang Positive Spell Crit Damage', 'Fang Accessory Slot', 31);
insert into augment_effect(id, augment_name, effect, effect_type, effect_value) values(augment_effect_sequence.nextval, 'Fang Positive Spell Crit Damage', 'Positive Spell Crit Damage', 'Insightful', 10);
insert into augment(name, augment_type, ml) values('Fang Repair Spell Crit Damage', 'Fang Accessory Slot', 31);
insert into augment_effect(id, augment_name, effect, effect_type, effect_value) values(augment_effect_sequence.nextval, 'Fang Repair Spell Crit Damage', 'Repair Spell Crit Damage', 'Insightful', 10);
insert into augment(name, augment_type, ml) values('Fang Sonic Spell Crit Damage', 'Fang Accessory Slot', 31);
insert into augment_effect(id, augment_name, effect, effect_type, effect_value) values(augment_effect_sequence.nextval, 'Fang Sonic Spell Crit Damage', 'Sonic Spell Crit Damage', 'Insightful', 10);
insert into augment_type(name) values('Claw Accessory Slot');
insert into augment_type_alias(alias, augment_type) values('Isle of Dread: Claw Slot (Accessory): Empty', 'Claw Accessory Slot');
insert into augment(name, augment_type, ml) values('Claw PRR', 'Claw Accessory Slot', 31);
insert into augment_effect(id, augment_name, effect, effect_type, effect_value) values(augment_effect_sequence.nextval, 'Claw PRR', 'Physical Sheltering', 'Enhancement', 35);
insert into augment(name, augment_type, ml) values('Claw MRR', 'Claw Accessory Slot', 31);
insert into augment_effect(id, augment_name, effect, effect_type, effect_value) values(augment_effect_sequence.nextval, 'Claw MRR', 'Magical Sheltering', 'Enhancement', 35);
insert into augment(name, augment_type, ml) values('Claw Stun', 'Claw Accessory Slot', 31);
insert into augment_effect(id, augment_name, effect, effect_type, effect_value) values(augment_effect_sequence.nextval, 'Claw Stun', 'Stunning', 'Enhancement', 15);
insert into augment(name, augment_type, ml) values('Claw Trip', 'Claw Accessory Slot', 31);
insert into augment_effect(id, augment_name, effect, effect_type, effect_value) values(augment_effect_sequence.nextval, 'Claw Trip', 'Vertigo', 'Enhancement', 15);
insert into augment(name, augment_type, ml) values('Claw Sunder', 'Claw Accessory Slot', 31);
insert into augment_effect(id, augment_name, effect, effect_type, effect_value) values(augment_effect_sequence.nextval, 'Claw Sunder', 'Sunder', 'Enhancement', 15);
insert into augment(name, augment_type, ml) values('Claw Assassinate', 'Claw Accessory Slot', 31);
insert into augment_effect(id, augment_name, effect, effect_type, effect_value) values(augment_effect_sequence.nextval, 'Claw Assassinate', 'Assassinate', 'Enhancement', 15);
insert into augment(name, augment_type, ml) values('Claw Spell Penetration', 'Claw Accessory Slot', 31);
insert into augment_effect(id, augment_name, effect, effect_type, effect_value) values(augment_effect_sequence.nextval, 'Claw Spell Penetration', 'Spell Penetration', 'Equipment', 9);
insert into augment(name, augment_type, ml) values('Claw Acid Spell Crit Damage', 'Claw Accessory Slot', 31);
insert into augment_effect(id, augment_name, effect, effect_type, effect_value) values(augment_effect_sequence.nextval, 'Claw Acid Spell Crit Damage', 'Acid Spell Crit Damage', 'Quality', 5);
insert into augment(name, augment_type, ml) values('Claw Cold Spell Crit Damage', 'Claw Accessory Slot', 31);
insert into augment_effect(id, augment_name, effect, effect_type, effect_value) values(augment_effect_sequence.nextval, 'Claw Cold Spell Crit Damage', 'Cold Spell Crit Damage', 'Quality', 5);
insert into augment(name, augment_type, ml) values('Claw Electric Spell Crit Damage', 'Claw Accessory Slot', 31);
insert into augment_effect(id, augment_name, effect, effect_type, effect_value) values(augment_effect_sequence.nextval, 'Claw Electric Spell Crit Damage', 'Electric Spell Crit Damage', 'Quality', 5);
insert into augment(name, augment_type, ml) values('Claw Fire Spell Crit Damage', 'Claw Accessory Slot', 31);
insert into augment_effect(id, augment_name, effect, effect_type, effect_value) values(augment_effect_sequence.nextval, 'Claw Fire Spell Crit Damage', 'Fire Spell Crit Damage', 'Quality', 5);
insert into augment(name, augment_type, ml) values('Claw Force Spell Crit Damage', 'Claw Accessory Slot', 31);
insert into augment_effect(id, augment_name, effect, effect_type, effect_value) values(augment_effect_sequence.nextval, 'Claw Force Spell Crit Damage', 'Force Spell Crit Damage', 'Quality', 5);
insert into augment(name, augment_type, ml) values('Claw Light Spell Crit Damage', 'Claw Accessory Slot', 31);
insert into augment_effect(id, augment_name, effect, effect_type, effect_value) values(augment_effect_sequence.nextval, 'Claw Light Spell Crit Damage', 'Light Spell Crit Damage', 'Quality', 5);
insert into augment(name, augment_type, ml) values('Claw Negative Spell Crit Damage', 'Claw Accessory Slot', 31);
insert into augment_effect(id, augment_name, effect, effect_type, effect_value) values(augment_effect_sequence.nextval, 'Claw Negative Spell Crit Damage', 'Negative Spell Crit Damage', 'Quality', 5);
insert into augment(name, augment_type, ml) values('Claw Positive Spell Crit Damage', 'Claw Accessory Slot', 31);
insert into augment_effect(id, augment_name, effect, effect_type, effect_value) values(augment_effect_sequence.nextval, 'Claw Positive Spell Crit Damage', 'Positive Spell Crit Damage', 'Quality', 5);
insert into augment(name, augment_type, ml) values('Claw Repair Spell Crit Damage', 'Claw Accessory Slot', 31);
insert into augment_effect(id, augment_name, effect, effect_type, effect_value) values(augment_effect_sequence.nextval, 'Claw Repair Spell Crit Damage', 'Repair Spell Crit Damage', 'Quality', 5);
insert into augment(name, augment_type, ml) values('Claw Sonic Spell Crit Damage', 'Claw Accessory Slot', 31);
insert into augment_effect(id, augment_name, effect, effect_type, effect_value) values(augment_effect_sequence.nextval, 'Claw Sonic Spell Crit Damage', 'Sonic Spell Crit Damage', 'Quality', 5);
insert into augment_type(name) values('Horn Accessory Slot');
insert into augment_type_alias(alias, augment_type) values('Isle of Dread: Horn Slot (Accessory): Empty', 'Horn Accessory Slot');
insert into augment(name, augment_type, ml) values('Horn Resistance', 'Horn Accessory Slot', 31);
insert into augment_effect(id, augment_name, effect, effect_type, effect_value) values(augment_effect_sequence.nextval, 'Horn Resistance', 'Resistance', 'Enhancement', 11);
insert into augment(name, augment_type, ml) values('Horn Enhanced Ghostly', 'Horn Accessory Slot', 31);
insert into augment_effect(id, augment_name, effect, effect_type, effect_value) values(augment_effect_sequence.nextval, 'Horn Enhanced Ghostly', 'Incorporeal', 'Enhancement', 15);
insert into augment(name, augment_type, ml) values('Horn Relentless Fury', 'Horn Accessory Slot', 31);
insert into augment_effect(id, augment_name, effect, effect_type, effect_value) values(augment_effect_sequence.nextval, 'Horn Relentless Fury', 'Relentless Fury', NULL, NULL);
insert into augment(name, augment_type, ml) values('Horn Armor Piercing', 'Horn Accessory Slot', 31);
insert into augment_effect(id, augment_name, effect, effect_type, effect_value) values(augment_effect_sequence.nextval, 'Horn Armor Piercing', 'Armor Piercing', 'Enhancement', 21);
insert into augment(name, augment_type, ml) values('Horn Wizardry', 'Horn Accessory Slot', 31);
insert into augment_effect(id, augment_name, effect, effect_type, effect_value) values(augment_effect_sequence.nextval, 'Horn Wizardry', 'Wizardry', 'Enhancement', 286);
insert into augment(name, augment_type, ml) values('Horn Profane DC', 'Horn Accessory Slot', 31);
insert into augment_effect(id, augment_name, effect, effect_type, effect_value) values(augment_effect_sequence.nextval, 'Horn Profane DC', 'Spell Focus Mastery', 'Profane', 2);
insert into augment(name, augment_type, ml) values('Horn Sacred DC', 'Horn Accessory Slot', 31);
insert into augment_effect(id, augment_name, effect, effect_type, effect_value) values(augment_effect_sequence.nextval, 'Horn Sacred DC', 'Spell Focus Mastery', 'Sacred', 2);
insert into augment(name, augment_type, ml) values('Dimensional Horn', 'Horn Accessory Slot', 31);
insert into augment_effect(id, augment_name, effect, effect_type, effect_value) values(augment_effect_sequence.nextval, 'Dimensional Horn', 'Dodge Bypass', 'Enhancement', 5);
insert into augment(name, augment_type, ml) values('Fossilized Amber', 'Horn Accessory Slot', 31);
insert into augment_effect(id, augment_name, effect, effect_type, effect_value) values(augment_effect_sequence.nextval, 'Fossilized Amber', 'Unconsciousness Range', 'Enhancement', 250);
insert into augment_effect(id, augment_name, effect, effect_type, effect_value) values(augment_effect_sequence.nextval, 'Fossilized Amber', 'Regeneration', 'Enhancement', 20);
insert into augment_type(name) values('Scale Armor Slot');
insert into augment_type_alias(alias, augment_type) values('Isle of Dread: Scale Slot (Armor): Empty','Scale Armor Slot');
insert into augment(name, augment_type, ml) values('Bronzescale', 'Scale Armor Slot', 31);
insert into augment_effect(id, augment_name, effect, effect_type, effect_value) values(augment_effect_sequence.nextval, 'Bronzescale', 'Incorporeal', 'Enhancement', 10);
insert into augment_effect(id, augment_name, effect, effect_type, effect_value) values(augment_effect_sequence.nextval, 'Bronzescale', 'Deathblock', NULL, NULL);
insert into augment(name, augment_type, ml) values('Goldscale', 'Scale Armor Slot', 31);
insert into augment_effect(id, augment_name, effect, effect_type, effect_value) values(augment_effect_sequence.nextval, 'Goldscale', 'Fortification', 'Enhancement', 150);
insert into augment(name, augment_type, ml) values('Silverscale', 'Scale Armor Slot', 31);
insert into augment_effect(id, augment_name, effect, effect_type, effect_value) values(augment_effect_sequence.nextval, 'Silverscale', 'Healing Amplification', 'Competence', 56);
insert into augment_effect(id, augment_name, effect, effect_type, effect_value) values(augment_effect_sequence.nextval, 'Silverscale', 'Repair Amplification', 'Enhancement', 56);
insert into augment_effect(id, augment_name, effect, effect_type, effect_value) values(augment_effect_sequence.nextval, 'Silverscale', 'Negative Amplification', 'Profane', 56);
insert into augment(name, augment_type, ml) values('Voidscale', 'Scale Armor Slot', 31);
insert into augment_effect(id, augment_name, effect, effect_type, effect_value) values(augment_effect_sequence.nextval, 'Voidscale', 'Spell Lore', 'Exceptional', 5);
insert into augment(name, augment_type, ml) values('Fragment of Extraplanar Alignment', 'Scale Armor Slot', 31);
insert into augment_effect(id, augment_name, effect, effect_type, effect_value) values(augment_effect_sequence.nextval, 'Fragment of Extraplanar Alignment', 'Good Absorption', 'Enhancement', 23);
insert into augment_effect(id, augment_name, effect, effect_type, effect_value) values(augment_effect_sequence.nextval, 'Fragment of Extraplanar Alignment', 'Evil Absorption', 'Enhancement', 23);
insert into augment_effect(id, augment_name, effect, effect_type, effect_value) values(augment_effect_sequence.nextval, 'Fragment of Extraplanar Alignment', 'Chaos Absorption', 'Enhancement', 23);
insert into augment_effect(id, augment_name, effect, effect_type, effect_value) values(augment_effect_sequence.nextval, 'Fragment of Extraplanar Alignment', 'Law Absorption', 'Enhancement', 23);
insert into augment(name, augment_type, ml) values('Fragment of Extraplanar Shadow', 'Scale Armor Slot', 31);
insert into augment_effect(id, augment_name, effect, effect_type, effect_value) values(augment_effect_sequence.nextval, 'Fragment of Extraplanar Shadow', 'Doublestrike', 'Profane', 3);
insert into augment_effect(id, augment_name, effect, effect_type, effect_value) values(augment_effect_sequence.nextval, 'Fragment of Extraplanar Shadow', 'Doubleshot', 'Profane', 3);
insert into augment_effect(id, augment_name, effect, effect_type, effect_value) values(augment_effect_sequence.nextval, 'Fragment of Extraplanar Shadow', 'Melee Alacrity', 'Enhancement', 15);
insert into augment_effect(id, augment_name, effect, effect_type, effect_value) values(augment_effect_sequence.nextval, 'Fragment of Extraplanar Shadow', 'Ranged Alacrity', 'Enhancement', 20);
insert into augment_type(name) values('Fang Armor Slot');
insert into augment_type_alias(alias, augment_type) values('Isle of Dread: Fang Slot (Armor): Empty','Fang Armor Slot');
insert into augment(name, augment_type, ml) values('Goldfang', 'Fang Armor Slot', 31);
insert into augment_effect(id, augment_name, effect, effect_type, effect_value) values(augment_effect_sequence.nextval, 'Goldfang', 'Sneak Attack Dice', 'Profane', 2);
insert into augment(name, augment_type, ml) values('Silverfang', 'Fang Armor Slot', 31);
insert into augment_effect(id, augment_name, effect, effect_type, effect_value) values(augment_effect_sequence.nextval, 'Silverfang', 'Spell Focus Mastery', 'Profane', 2);
insert into augment_effect(id, augment_name, effect, effect_type, effect_value) values(augment_effect_sequence.nextval, 'Silverfang', 'Combat Mastery', 'Profane', 2);
insert into augment_effect(id, augment_name, effect, effect_type, effect_value) values(augment_effect_sequence.nextval, 'Silverfang', 'Assassinate', 'Profane', 2);
insert into augment(name, augment_type, ml) values('Voidfang', 'Fang Armor Slot', 31);
insert into augment_effect(id, augment_name, effect, effect_type, effect_value) values(augment_effect_sequence.nextval, 'Voidfang', 'Potency', 'Exceptional', 15);
