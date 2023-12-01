-- General Combat
insert into effect(name, effect_type) values ('Accuracy', 'general_combat');
insert into effect(name, effect_type) values ('Armor Piercing', 'general_combat');
insert into effect(name, effect_type) values ('Deadly', 'general_combat');
insert into effect(name, effect_type) values ('Seeker', 'general_combat');
insert into effect(name, effect_type) values ('Deception', 'general_combat');
insert into effect(name, effect_type) values ('Dodge Bypass', 'general_combat');
insert into effect(name, effect_type) values ('Bonus to damage vs. helpless', 'general_combat');
insert into effect(name, effect_type) values ('Sneak Attack Dice', 'general_combat');
insert into effect(name, effect_type) values ('Fortification Bypass', 'general_combat');
insert into effect(name, effect_type) values ('Speed', 'general_combat');
--insert into effect(name, effect_type) values ('', 'general_combat');

-- DR Bypass
insert into effect(name, effect_type) values ('Adamantine', 'dr_bypass');
insert into effect(name, effect_type) values ('Byeshk', 'dr_bypass');
insert into effect(name, effect_type) values ('Cold Iron', 'dr_bypass');
insert into effect(name, effect_type) values ('Crystal', 'dr_bypass');
insert into effect(name, effect_type) values ('Flametouched Iron', 'dr_bypass');
insert into effect(name, effect_type) values ('Silver', 'dr_bypass');
insert into effect(name, effect_type) values ('Aligned', 'dr_bypass');
insert into effect(name, effect_type) values ('Metalline', 'dr_bypass');
insert into effect(name, effect_type, description) values ('Righteous', 'dr_bypass', 'This weapon is imbued with holy power, giving it an additional +2 to attack bonus and damage against any evil creature. This power makes the weapon good-aligned.');

-- Tactical
insert into effect(name, effect_type) values ('Assassinate', 'tactical');
insert into effect(name, effect_type) values ('Breath Weapon Focus', 'tactical');
insert into effect(name, effect_type) values ('Dazing', 'tactical');
insert into effect(name, effect_type) values ('Stunning', 'tactical');
insert into effect(name, effect_type) values ('Vertigo', 'tactical');
insert into effect(name, effect_type) values ('Shatter', 'tactical');
insert into effect(name, effect_type) values ('Combat Mastery', 'tactical');

-- Melee
insert into effect(name, effect_type) values ('Incite', 'general_combat');
insert into effect(name, effect_type) values ('Diversion', 'melee_combat');
insert into effect(name, effect_type) values ('Melee Alacrity', 'melee_combat');
insert into effect(name, effect_type) values ('Melee Power', 'melee_combat');
insert into effect(name, effect_type) values ('Doublestrike', 'melee_combat');

-- Ranged
insert into effect(name, effect_type, description) values ('Ranged Power', 'ranged_combat', 'Increase the damage of ranged attacks');
insert into effect(name, effect_type, description) values ('Distant Diversion', 'ranged_combat', 'ranged treath reduction');
insert into effect(name, effect_type, description) values ('Ranged Alacrity', 'ranged_combat', 'Ranged attack speed');
insert into effect(name, effect_type, description) values ('Doubleshot', 'ranged_combat', 'chanche to make another ranged attack');

insert into effect(name, effect_type, description) values ('Venomed Ammunition', 'ranged_combat', 'Adds venom damage to ranged attacks');
insert into effect(name, effect_type, description) values ('Burning Ammunition', 'ranged_combat', 'Adds fire damage to ranged attacks');
insert into effect(name, effect_type, description) values ('Blunted Ammunition', 'ranged_combat', 'Adds blunt to damage types to ranged attacks');

-- Threat range
insert into effect(name, effect_type) values ('Elasticity', 'ranged_combat');
insert into effect(name, effect_type) values ('Impact', 'general_combat');
insert into effect(name, effect_type) values ('Keen', 'general_combat');

-- Special Weapon Procs that buffs
insert into effect(name, effect_type) values ('Cannith Combat Infusion', 'weapon_proc');
insert into effect(name, effect_type) values ('Enhanced Bloodrage', 'weapon_proc');
insert into effect(name, effect_type) values ('Enhanced Ki', 'weapon_proc');
insert into effect(name, effect_type) values ('Feeding', 'weapon_proc');

-- Special Weapon Procs
insert into effect(name, effect_type) values ('Accursed Flame', 'weapon_proc');
insert into effect(name, effect_type) values ('Acid Arrow', 'weapon_proc');
insert into effect(name, effect_type) values ('Alchemical Air Attunement', 'weapon_proc');
insert into effect(name, effect_type) values ('Alchemical Earth Attunement', 'weapon_proc');
insert into effect(name, effect_type) values ('Alchemical Fire Attunement', 'weapon_proc');
insert into effect(name, effect_type) values ('Alchemical Water Attunement', 'weapon_proc');
insert into effect(name, effect_type) values ('Anti-Magic Runes', 'weapon_proc');
insert into effect(name, effect_type) values ('Antimagic Spike', 'weapon_proc');
insert into effect(name, effect_type) values ('Antipodal', 'weapon_proc');
insert into effect(name, effect_type) values ('Banishing', 'weapon_proc');
insert into effect(name, effect_type) values ('Banishing Fists', 'weapon_proc');
insert into effect(name, effect_type) values ('Blinding Embers', 'weapon_proc');
insert into effect(name, effect_type) values ('Blunt Trauma', 'weapon_proc');
insert into effect(name, effect_type) values ('Bodyfeeder', 'weapon_proc');
insert into effect(name, effect_type) values ('Boneshatter', 'weapon_proc');
insert into effect(name, effect_type) values ('Bonesplitter', 'weapon_proc');
insert into effect(name, effect_type) values ('Brazen Brilliance', 'weapon_proc');
insert into effect(name, effect_type) values ('Cacophony', 'weapon_proc');
insert into effect(name, effect_type) values ('Cloudburst', 'weapon_proc');
insert into effect(name, effect_type) values ('Conflagrating', 'weapon_proc');
insert into effect(name, effect_type) values ('Corrosive Salt', 'weapon_proc');
insert into effect(name, effect_type) values ('Crushing Wave', 'weapon_proc');
insert into effect(name, effect_type) values ('Cursed Maelstrom', 'weapon_proc');
insert into effect(name, effect_type) values ('Disease: Unholy Tear', 'weapon_proc');
insert into effect(name, effect_type) values ('Disintegration', 'weapon_proc');
insert into effect(name, effect_type) values ('Disruption', 'weapon_proc');
insert into effect(name, effect_type) values ('Dripping with Magma', 'weapon_proc');
insert into effect(name, effect_type) values ('Felling the Oak', 'weapon_proc');
insert into effect(name, effect_type) values ('Earthgrab', 'weapon_proc');
insert into effect(name, effect_type) values ('Entropic', 'weapon_proc');
insert into effect(name, effect_type) values ('Epic Freezing Ice', 'weapon_proc');
insert into effect(name, effect_type) values ('Epic Goldcurse', 'weapon_proc');
insert into effect(name, effect_type) values ('Epic Noxious Venom Spike', 'weapon_proc');
insert into effect(name, effect_type) values ('Epic Telekinetic', 'weapon_proc');
insert into effect(name, effect_type) values ('Epic Trap the Soul', 'weapon_proc');
insert into effect(name, effect_type) values ('Eternal Fire', 'weapon_proc');
insert into effect(name, effect_type) values ('Eternal Holy Burst', 'weapon_proc');
insert into effect(name, effect_type) values ('Fiery Detonation', 'weapon_proc');
insert into effect(name, effect_type) values ('Flamebitten', 'weapon_proc');
insert into effect(name, effect_type) values ('Fracturing', 'weapon_proc');
insert into effect(name, effect_type) values ('Freezing Ice', 'weapon_proc');
insert into effect(name, effect_type) values ('Frostbite', 'weapon_proc');
insert into effect(name, effect_type) values ('Glass Jaw Strike', 'weapon_proc');
insert into effect(name, effect_type) values ('Glass Shards', 'weapon_proc');
insert into effect(name, effect_type) values ('Godly Wrath', 'weapon_proc');
insert into effect(name, effect_type) values ('Goldcurse', 'weapon_proc');
insert into effect(name, effect_type) values ('Greater Acid Arrow', 'weapon_proc');
insert into effect(name, effect_type) values ('Greater Dispelling', 'weapon_proc');
insert into effect(name, effect_type) values ('Greater Disruption', 'weapon_proc');
insert into effect(name, effect_type) values ('Greater Electric Storm', 'weapon_proc');
insert into effect(name, effect_type) values ('Greater Incineration', 'weapon_proc');
insert into effect(name, effect_type) values ('Greater Maiming', 'weapon_proc');
insert into effect(name, effect_type) values ('Greater Shocking Blow', 'weapon_proc');
insert into effect(name, effect_type) values ('Greater Shrieking Bolt', 'weapon_proc');
insert into effect(name, effect_type) values ('Greater Sirocco', 'weapon_proc');
insert into effect(name, effect_type) values ('Greater Stone Prison', 'weapon_proc');
insert into effect(name, effect_type) values ('Greater Sunburst', 'weapon_proc');
insert into effect(name, effect_type) values ('Greater Vorpal', 'weapon_proc');
insert into effect(name, effect_type) values ('Magma Surge', 'weapon_proc');
insert into effect(name, effect_type) values ('Sound and Silence', 'weapon_proc');
insert into effect(name, effect_type) values ('Legendary Electric Storm', 'weapon_proc');
insert into effect(name, effect_type) values ('Scorching Sun', 'weapon_proc');
insert into effect(name, effect_type) values ('Stormreaver''s Thunderclap', 'weapon_proc');
insert into effect(name, effect_type) values ('Sovereign Lightning Strike', 'weapon_proc');
insert into effect(name, effect_type) values ('Manslayer', 'weapon_proc');
insert into effect(name, effect_type) values ('Shadow Spike', 'weapon_proc');
insert into effect(name, effect_type) values ('Noxious Venom Spike', 'weapon_proc');
insert into effect(name, effect_type) values ('Thunderstruck', 'weapon_proc');
insert into effect(name, effect_type) values ('The Golden Curse', 'weapon_proc');
insert into effect(name, effect_type) values ('Spiked', 'weapon_proc');
insert into effect(name, effect_type) values ('Minor Freezing Ice', 'weapon_proc');
insert into effect(name, effect_type) values ('Staggering Blow', 'weapon_proc');
insert into effect(name, effect_type) values ('Unstoppable Staggering Blow', 'weapon_proc');
insert into effect(name, effect_type) values ('Maiming', 'weapon_proc');
insert into effect(name, effect_type) values ('Vampirism', 'weapon_proc');
insert into effect(name, effect_type) values ('Hardened Spikes', 'weapon_proc');
insert into effect(name, effect_type, description) values ('Vile Grip of the Hidden Hand', 'weapon_proc', 'Attacks and offensive spells have a small chance to deal massive evil damage.');
insert into effect(name, effect_type, description) values ('Legendary Vile Grip of the Hidden Hand', 'weapon_proc', 'Attacks and offensive spells have a small chance to deal massive evil damage.');
insert into effect(name, effect_type) values ('Tidal', 'weapon_proc');
insert into effect(name, effect_type) values ('Mortal Strike', 'weapon_proc');
insert into effect(name, effect_type) values ('Mother Night''s Embrace', 'weapon_proc');
insert into effect(name, effect_type) values ('Stone Prison', 'weapon_proc');
insert into effect(name, effect_type, description) values ('Telekinetic', 'weapon_proc', 'Targets that suffer a critical hit from a Telekinetic weapon must make a DC 17 Balance check or be knocked down.');
insert into effect(name, effect_type, description) values ('Slicing Winds', 'weapon_proc', 'This weapon stores the cyclonic might of a windstorm within. When this weapon is used, this power can come to the surface as a series of rushing, cutting winds that deal slashing damage to the target over several seconds.');
insert into effect(name, effect_type, description) values ('Shockwave', 'weapon_proc', 'On Vorpal, this weapon triggers a Shockwave, striking its target with bludgeoning damage and dealing damage to surrounding enemies.');
insert into effect(name, effect_type) values ('Incineration', 'weapon_proc');
insert into effect(name, effect_type, description) values ('Rockslide', 'weapon_proc', 'This weapon stores the power of a volatile rockslide deep within. On hit, there is a chance to do massive bludgeoning damage to your enemy.');
insert into effect(name, effect_type) values ('Transmuted Platinum (Epic)', 'weapon_proc');
insert into effect(name, effect_type) values ('Lightning Strike', 'weapon_proc');
insert into effect(name, effect_type) values ('Improved Banishing', 'weapon_proc');
insert into effect(name, effect_type, description) values ('Spear of the Hunter', 'weapon_proc', 'On hit, this weapon has a chance to put down a falling star upon your foes, dealing 90d6 Fire Damage and 30d6 Bludgeoning Damage to enemies caught within the blast. This blast is so powerful it has a chance to knock nearby enemies down upon impact.');
insert into effect(name, effect_type, description) values ('Thrill of the Hunt', 'weapon_proc', 'On Hit: You have a small chance to attempt to hold a monster in place. Even if the Hold is unsuccessful, their will saves will be reduced by 5.');
insert into effect(name, effect_type) values ('Sovereign Vorpal', 'weapon_proc');
insert into effect(name, effect_type) values ('Touch of the Mournlands', 'weapon_proc');
insert into effect(name, effect_type) values ('Inflict Blight', 'weapon_proc');
--insert into effect(name, effect_type) values ('', 'weapon_proc');

-- Keeper
insert into effect(name, effect_type) values ('First Litany of the Crimson Covenant', 'special');
insert into effect(name, effect_type) values ('Second Litany of the Crimson Covenant', 'special');
insert into effect(name, effect_type) values ('Third Litany of the Crimson Covenant', 'special');
insert into effect(name, effect_type) values ('Final Litany of the Crimson Covenant', 'special');

