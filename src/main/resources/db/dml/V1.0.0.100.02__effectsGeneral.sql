insert into effect(name, effect_type) values ('Striding', 'movement');
insert into effect(name, effect_type) values ('Feather Falling', 'movement');

insert into effect(name, effect_type) values ('Negative Amplification', 'attribute');
insert into effect(name, effect_type) values ('Repair Amplification', 'attribute');
insert into effect(name, effect_type) values ('Healing Amplification', 'attribute');
insert into effect(name, effect_type, description) values ('Regeneration', 'attribute', 'HP per minute');
insert into effect(name, effect_type, description) values ('Auto-Repair', 'attribute', 'HP per minute');
insert into effect(name, effect_type) values ('Unconsciousness Range', 'attribute');
insert into effect(name, effect_type) values ('Hit Points', 'attribute');
insert into effect(name, effect_type) values ('Wizardry', 'attribute');
insert into effect(name, effect_type) values ('Mind Drain', 'attribute');

insert into effect(name, effect_type) values ('True Seeing', 'general');
insert into effect(name, effect_type) values ('Freedom of Movement', 'general');
insert into effect(name, effect_type) values ('Ethereal', 'general');
insert into effect(name, effect_type) values ('Improved Deception', 'general');
insert into effect(name, effect_type) values ('Slippery Surfaces Immunity', 'general');
insert into effect(name, effect_type) values ('Heroic Inspiration', 'general');
insert into effect(name, effect_type) values ('Relentless Fury', 'general');
insert into effect(name, effect_type) values ('Underwater Action', 'general');

-- charges
insert into effect(name, effect_type) values ('Action Boost', 'charges');
insert into effect(name, effect_type) values ('Anger', 'charges');
insert into effect(name, effect_type) values ('Minor Anger', 'charges');
insert into effect(name, effect_type) values ('Anthem', 'charges');
insert into effect(name, effect_type) values ('Alchemical Conservation', 'charges');
insert into effect(name, effect_type) values ('Minor Lesser Dragonmark Enhancement', 'charges');
insert into effect(name, effect_type) values ('Lesser Dragonmark Enhancement', 'charges');
insert into effect(name, effect_type) values ('Major Lesser Dragonmark Enhancement', 'charges');
insert into effect(name, effect_type) values ('Minor Greater Dragonmark Enhancement', 'charges');
--insert into effect(name, effect_type) values ('', 'charges');

-- aggro
insert into effect(name, effect_type) values ('Linguistics', 'general');
insert into effect(name, effect_type) values ('Occultation', 'general');
insert into effect(name, effect_type) values ('Anathema', 'general');
insert into effect(name, effect_type) values ('Subtle Target', 'general');

-- turn undead
insert into effect(name, effect_type) values ('Eternal Faith', 'general');
insert into effect(name, effect_type) values ('Faith', 'general');
insert into effect(name, effect_type) values ('Greater Turning', 'general');
insert into effect(name, effect_type) values ('Sacred', 'general');
insert into effect(name, effect_type) values ('Minor Turning', 'general');
insert into effect(name, effect_type) values ('Lesser Turning', 'general');
insert into effect(name, effect_type) values ('Turning', 'general');
insert into effect(name, effect_type) values ('Hallowed', 'general');
insert into effect(name, effect_type) values ('Silver Flame', 'general');

-- Paladin
insert into effect(name, effect_type) values ('Extra Lay on Hands', 'general');
insert into effect(name, effect_type) values ('Extra Smites', 'general');

-- Monk
insert into effect(name, effect_type) values ('Balanced Ki Strike', 'general');
insert into effect(name, effect_type) values ('Reinforced Fists', 'general');
insert into effect(name, effect_type) values ('Greater Reinforced Fists', 'general');
insert into effect(name, effect_type) values ('Superior Reinforced Fists', 'general');
insert into effect(name, effect_type) values ('Soul of the Elements', 'general');
insert into effect(name, effect_type) values ('Path of the Fire Dragon', 'general');
insert into effect(name, effect_type) values ('Path of the Guarding Stone', 'general');
insert into effect(name, effect_type) values ('The Moral Compass', 'general');

-- bard
insert into effect(name, effect_type) values ('Anthem Melody: La Victoria!', 'general');
insert into effect(name, effect_type) values ('Songblade', 'general');
insert into effect(name, effect_type) values ('Melody: Bulwark', 'general');
insert into effect(name, effect_type, description) values ('Melody: Imperial Resonance', 'general', 'This powerful item is attuned to your ability to perform musical magic. If you have 15 or more bonus effective Bard levels from Feats, additional Bard songs, or enhancements, it provides 30 Exceptional Sonic Spell Power and 15% Exceptional Sonic Spell Lore.');
insert into effect(name, effect_type, description) values ('Inspiring Echoes', 'general', 'When a bard wields this item, Anthem abilities that restore Bard songs over time restore them 40% faster (for example, an ability that restores a Song every 5 minutes would restore one song per 3 minutes instead).');

-- Barbarian
insert into effect(name, effect_type) values ('Raging Strength', 'ability');
insert into effect(name, effect_type) values ('Raging Resilience', 'saves');
insert into effect(name, effect_type, description) values ('Raging Focus', 'saves', 'While Raged, +4 Rage Bonus to Saves vs. Enchantments.');
insert into effect(name, effect_type, description) values ('Raging Inferno', 'special', 'Your True Rage effects (such as Barbarian or Bestial Rage) light you on fire, as if you were under the effects of a Fire Shield. This ability also protects you from Energy Drain for the duration.');

-- Rune arm
insert into effect(name, effect_type) values ('Rune Arm Focus', 'tactical');
insert into effect(name, effect_type) values ('Rune Arm Charge Rate', 'general');

-- Materials
insert into effect(name, effect_type) values ('Densewood', 'material');
insert into effect(name, effect_type) values ('Mithral', 'material');

-- Upgrades
insert into effect(name, effect_type) values ('Alchemical (Prototype)', 'upgrade');
insert into effect(name, effect_type) values ('Attuned to Heroism', 'upgrade');
insert into effect(name, effect_type) values ('Battle-Scarred', 'upgrade');
insert into effect(name, effect_type) values ('Craftable', 'upgrade');
insert into effect(name, effect_type) values ('Dampened', 'upgrade');
insert into effect(name, effect_type) values ('Dragontouched', 'upgrade');
insert into effect(name, effect_type) values ('Flawed Shadowscale Armor', 'upgrade');
insert into effect(name, effect_type) values ('Fragmented', 'upgrade');
insert into effect(name, effect_type) values ('Fusible', 'upgrade');
insert into effect(name, effect_type) values ('Green Steel', 'upgrade');
insert into effect(name, effect_type) values ('Incredible Potential', 'upgrade');
insert into effect(name, effect_type) values ('Legendary Alchemical Crafting (Prototype)', 'upgrade');
insert into effect(name, effect_type) values ('Legendary Green Steel', 'upgrade');
insert into effect(name, effect_type) values ('Lost Purpose', 'upgrade');
insert into effect(name, effect_type) values ('Malleable', 'upgrade');
insert into effect(name, effect_type) values ('Nearly Finished', 'upgrade');
insert into effect(name, effect_type) values ('Planar Searing', 'upgrade');
insert into effect(name, effect_type) values ('Upgradeable Item (Black Abbot)', 'upgrade');
insert into effect(name, effect_type) values ('Upgradeable Item (Stormreaver)', 'upgrade');
insert into effect(name, effect_type) values ('Upgradeable Item (Temple of Elemental Evil)', 'upgrade');
insert into effect(name, effect_type) values ('Suppressed Power', 'upgrade');
insert into effect(name, effect_type) values ('Legendary Taint of Shavarath', 'upgrade');
insert into effect(name, effect_type) values ('Unraveling Enchantments', 'upgrade');
insert into effect(name, effect_type) values ('Upgradeable - Tier', 'upgrade');
insert into effect(name, effect_type) values ('Taint of Shavarath', 'upgrade');
insert into effect(name, effect_type) values ('Trace of Madness', 'upgrade');
insert into effect(name, effect_type) values ('Treasure of Crystal Cove Hat Upgrades', 'upgrade');
insert into effect(name, effect_type) values ('Thunder-Forged (Tier )', 'upgrade');
insert into effect(name, effect_type) values ('Zhentarim Attuned', 'upgrade');


--insert into effect(name, effect_type) values ('', 'general');