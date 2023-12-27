-- Weapon Procs
insert into effect(name, effect_type) values ('Absolute Chaos', 'weapon_proc');
insert into effect(name, effect_type) values ('True Chaos', 'weapon_proc');
insert into effect(name, effect_type) values ('Absolute Law', 'weapon_proc');
insert into effect(name, effect_type) values ('True Law', 'weapon_proc');
insert into effect(name, effect_type) values ('Supreme Law', 'weapon_proc');
insert into effect(name, effect_type) values ('Supreme Good', 'weapon_proc');
insert into effect(name, effect_type) values ('Pure Good', 'weapon_proc');

insert into effect(name, effect_type) values ('Anarchic', 'weapon_proc');
insert into effect(name, effect_type) values ('Anarchic Blast', 'weapon_proc');
insert into effect(name, effect_type) values ('Anarchic Burst', 'weapon_proc');
insert into effect(name, effect_type) values ('Axiomatic', 'weapon_proc');
insert into effect(name, effect_type) values ('Axiomatic Blast', 'weapon_proc');
insert into effect(name, effect_type) values ('Axiomatic Burst', 'weapon_proc');

insert into effect(name, effect_type) values ('Acid', 'weapon_proc');
insert into effect(name, effect_type) values ('Acid Blast', 'weapon_proc');
insert into effect(name, effect_type) values ('Acid Burst', 'weapon_proc');
insert into effect(name, effect_type) values ('Acid Touch', 'weapon_proc');
insert into effect(name, effect_type) values ('Acid Vulnerability', 'weapon_proc');

insert into effect(name, effect_type) values ('Evil Blast', 'weapon_proc');

insert into effect(name, effect_type) values ('Fire Touch', 'weapon_proc');
insert into effect(name, effect_type) values ('Fire Vulnerability', 'weapon_proc');
insert into effect(name, effect_type) values ('Flaming', 'weapon_proc');
insert into effect(name, effect_type) values ('Flaming Blast', 'weapon_proc');
insert into effect(name, effect_type) values ('Flaming Burst', 'weapon_proc');
insert into effect(name, effect_type) values ('Greater Flaming Blast', 'weapon_proc');
insert into effect(name, effect_type) values ('Minor Flaming', 'weapon_proc');

insert into effect(name, effect_type) values ('Impactful', 'weapon_proc');
insert into effect(name, effect_type) values ('Force', 'weapon_proc');
insert into effect(name, effect_type) values ('Force Blast', 'weapon_proc');
insert into effect(name, effect_type) values ('Force Burst', 'weapon_proc');
insert into effect(name, effect_type) values ('Superior Force Burst', 'weapon_proc');
insert into effect(name, effect_type) values ('Gashing', 'weapon_proc');
insert into effect(name, effect_type) values ('Impellent', 'weapon_proc');

insert into effect(name, effect_type) values ('Frost', 'weapon_proc');
insert into effect(name, effect_type) values ('Icy Blast', 'weapon_proc');
insert into effect(name, effect_type) values ('Icy Burst', 'weapon_proc');
insert into effect(name, effect_type) values ('Cold Touch', 'weapon_proc');
insert into effect(name, effect_type) values ('Cold Vulnerability', 'weapon_proc');

insert into effect(name, effect_type) values ('Shock', 'weapon_proc');
insert into effect(name, effect_type) values ('Shocking Blast', 'weapon_proc');
insert into effect(name, effect_type) values ('Shocking Burst', 'weapon_proc');
insert into effect(name, effect_type) values ('Shocking Touch', 'weapon_proc');
insert into effect(name, effect_type) values ('Electric Vulnerability', 'weapon_proc');
insert into effect(name, effect_type) values ('Jolting', 'weapon_proc');

insert into effect(name, effect_type) values ('Screaming', 'weapon_proc');
insert into effect(name, effect_type) values ('Roaring', 'weapon_proc');
insert into effect(name, effect_type) values ('Sonic Blast', 'weapon_proc');
insert into effect(name, effect_type) values ('Reverberating', 'weapon_proc');
insert into effect(name, effect_type) values ('Screeching', 'weapon_proc');
insert into effect(name, effect_type) values ('Shrieking', 'weapon_proc');
insert into effect(name, effect_type) values ('Wailing', 'weapon_proc');

insert into effect(name, effect_type) values ('Holy', 'weapon_proc');
insert into effect(name, effect_type) values ('Holy Burst', 'weapon_proc');
insert into effect(name, effect_type) values ('Good Blast', 'weapon_proc');
insert into effect(name, effect_type) values ('Greater Good', 'weapon_proc');

insert into effect(name, effect_type) values ('Radiant Blast', 'weapon_proc');

insert into effect(name, effect_type) values ('Unholy', 'weapon_proc');
insert into effect(name, effect_type) values ('Unholy Burst', 'weapon_proc');

insert into effect(name, effect_type) values ('Negativity', 'weapon_proc');
insert into effect(name, effect_type) values ('Negative Blast', 'weapon_proc');

insert into effect(name, effect_type) values ('Poison', 'weapon_proc');
insert into effect(name, effect_type) values ('Poison Blast', 'weapon_proc');
insert into effect(name, effect_type) values ('Poison Burst', 'weapon_proc');
insert into effect(name, effect_type) values ('Poisonous', 'weapon_proc');
insert into effect(name, effect_type) values ('Toxic', 'weapon_proc');

insert into effect(name, effect_type) values ('Blazing', 'weapon_proc');
insert into effect(name, effect_type) values ('Bleeding', 'weapon_proc');
insert into effect(name, effect_type) values ('Bloodletter', 'weapon_proc');
insert into effect(name, effect_type) values ('Bludgeoning', 'weapon_proc');
insert into effect(name, effect_type) values ('Boreal', 'weapon_proc');
insert into effect(name, effect_type) values ('Chilling', 'weapon_proc');
insert into effect(name, effect_type) values ('Coruscating', 'weapon_proc');
insert into effect(name, effect_type) values ('Cosmic', 'weapon_proc');
insert into effect(name, effect_type) values ('Crushing', 'weapon_proc');
insert into effect(name, effect_type) values ('Electrifying', 'weapon_proc');
insert into effect(name, effect_type) values ('Fiery', 'weapon_proc');
insert into effect(name, effect_type) values ('Freezing', 'weapon_proc');
insert into effect(name, effect_type) values ('Voltaic', 'weapon_proc');
insert into effect(name, effect_type) values ('Thundering', 'weapon_proc');


insert into effect(name, effect_type, description) values ('Turbulent Burst', 'weapon_proc', 'This weapon is enchanted with wild, unpredictable energy. It will do 1 to 8 damage of a random energy type (fire/cold/electric/acid) on a successful hit and 3 to 24 damage of a random energy type on critical hits.');

-- Physical
insert into effect(name, effect_type, description) values ('Smashing', 'weapon_proc', 'The edges of this weapon are blunted, dealing an additional Xd6 bludgeoning damage on each critical hit.');
insert into effect(name, effect_type, description) values ('Heartseeker', 'weapon_proc', 'On Critical Hit: Piercing damage scaling with Critical Multiplier.');
insert into effect(name, effect_type, description) values ('Ribcracker', 'weapon_proc', 'On Critical Hit: Bludgeoning damage scaling with Critical Multiplier.');
insert into effect(name, effect_type, description) values ('Piercing', 'weapon_proc', 'The edges of this weapon have serrated edges, dealing an additional Xd6 piercing damage on each hit.');
insert into effect(name, effect_type, description) values ('Slashing', 'weapon_proc', 'The edges of this weapon are sharpened, dealing an additional Xd6 slashing damage on each hit.');
insert into effect(name, effect_type, description) values ('Stabbing', 'weapon_proc', 'The edges of this weapon are serrated, dealing an additional Xd6 piercing damage on each critical hit.');

-- effetti speciali dino weapons, vanno rivisti
insert into effect(name, effect_type, description) values ('Untyped Blast', 'weapon_proc', 'dino');
insert into effect(name, effect_type, description) values ('Curse Untyped DOT', 'weapon_proc', 'dino');
insert into effect(name, effect_type, description) values ('Tar Ooze', 'weapon_proc', 'dino');