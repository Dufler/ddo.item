package ddo.item.logic;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ddo.item.entity.EGearSetup;
import ddo.item.entity.EGearSetupItem;
import ddo.item.entity.EItem;
import ddo.item.entity.EItemEffects;
import ddo.item.gui.effects.SelectedEffect;
import ddo.item.gui.effects.TabellaSelectedEffects;
import ddo.item.gui.items.TabellaEquippedItems;
import ddo.item.gui.set.SelectedSet;
import ddo.item.gui.set.TabellaSelectedSets;
import ddo.item.model.AugmentSlot;
import ddo.item.model.BodySlot;
import ddo.item.model.Effect;
import ddo.item.model.GearSetup;
import ddo.item.model.Item;
import ddo.item.repository.EGearSetupItemRepository;
import ddo.item.repository.EGearSetupRepository;
import ddo.item.repository.EItemEffectsRepository;
import ddo.item.repository.EItemRepository;

@Component
public class EquippedItems {
	
	private static EquippedItems singleton;
	
	@Autowired private EItemRepository repositoryItems;
	@Autowired private EItemEffectsRepository repositoryEffects;
	@Autowired private EGearSetupRepository repositorySetup;
	@Autowired private EGearSetupItemRepository repositorySetupItem;
	
	private final Set<String> effects;
	private final Map<String, SelectedEffect> selectedEffects;
	private final Map<String, Item> items;
	private final Set<AugmentSlot> augments;
	
	private GearSetup setup;
	private Map<BodySlot, Item> equippedItems;
	
	// Tabelle da aggiornare
	private TabellaSelectedEffects tableEffects;
	private TabellaSelectedSets tableSets;
	private TabellaEquippedItems tableItems;
	
	private EquippedItems() {
		setup = new GearSetup();
		setup.setName("");
		setup.setDescription("");
		equippedItems = setup.getItems();
		for (BodySlot slot : BodySlot.values()) {
			equippedItems.put(slot, null);
		}
		effects = new HashSet<>();
		selectedEffects = new HashMap<>();
		items = new HashMap<>();
		augments = new HashSet<>();
		// Di questo se ne occupa spring.
		singleton = this;
	}
	
	public static EquippedItems getInstance() {
		return singleton;
	}
	
	public GearSetup getSetup() {
		return setup;
	}
 	
	public void reloadData() {
		effects.clear();
		items.clear();
		augments.clear();
		loadItems();
	}
	
	@PostConstruct
	private void loadItems() {
		List<EItem> itemList = repositoryItems.findAll();
		for (EItem e : itemList) {
			Item i = trasforma(e);
			items.put(i.getName(), i);
		}
		List<EItemEffects> effectList = repositoryEffects.findAll();
		for (EItemEffects e : effectList) {
			Item i = items.get(e.getItemName());
			effects.add(e.getEffect());
			Effect f = trasforma(e);
			i.addEffect(f);
		}
	}
	
	public void setItemTable(TabellaEquippedItems t) {
		tableItems = t;
	}
	
	public void setEffectTable(TabellaSelectedEffects t) {
		tableEffects = t;
	}
	
	public void setSetsTable(TabellaSelectedSets t) {
		tableSets = t;
	}
	
	private Item trasforma(EItem e) {
		Item i = new Item(e.getSlot(), e.getName());
		// Non c'è bisogno di aggiungere i set, vengono aggiunti dopo dal SetManager al caricamento dei set.
		// Aggiungo gli augment
		for (String a : e.getAugments()) {
			AugmentSlot as = new AugmentSlot(e.getName(), a);
			i.addAugment(as);
		}		
		return i;
	}
	
	private Effect trasforma(EItemEffects e) {
		Effect f = new Effect();
		f.setName(e.getEffect());
		f.setType(e.getType());
		f.setValue(e.getValue());
		return f;
	}
	
	public void equip(BodySlot slot, Item item) {
		// Se avevo già qualcosa su quello slot devo rimuovere gli augment
		Item old = equippedItems.get(slot);
		if (old != null) {
			for (AugmentSlot a :old.getAugments()) {
				augments.remove(a);
			}
		}
		equippedItems.put(slot, item);
		// Aggiorno i bonus
		updateSelectedEffects();
	}

	public void updateSelectedEffects() {
		// Aggiorno i set
		SetManager.getInstance().updateSelectedSet();
		// resetto la mappa degli effetti lasciando solo quelli selezionati dall'utente
		clearEffectsNotSelectedbyUser();
		// per ogni oggetto inserisco gli effetti
		for (BodySlot slot : equippedItems.keySet()) {
			// Se c'è un oggetto equipaggiato nello slot ne aggiungo gli effetti
			Item item = equippedItems.get(slot);
			if (item != null) {
				// Aggiungo gli effetti propri dell'oggetto
				for (Effect e : item.getEffects()) {
					addEffect(e);
				}
				// Aggiungo gli effetti degli augment, se presenti
				for (AugmentSlot a : item.getAugments()) {
					for (Effect f : a.getEffects()) {
						addEffect(f);
					}
				}
			}
		}
		// per ogni set completo inserisco gli effetti
		Map<String, SelectedSet> setMap = SetManager.getInstance().getSelectedSet();
		for (SelectedSet ss : setMap.values()) {
			// se ho abbastanza pezzi aggiungo gli effetti del set
			if (ss.getActualNumberOfPieces() >= ss.getMaxNumberOfPieces()) {
				for (Effect e : ss.getEffects()) {
					addEffect(e);
				}
			}
		}
		// refresho le tabelle
		refreshTables();
	}
	
	private void refreshTables() {
		tableEffects.aggiornaContenuto();
		tableItems.aggiornaContenuto();
		tableSets.aggiornaContenuto();
	}
	
	private void clearEffectsNotSelectedbyUser() {
		Iterator<Entry<String, SelectedEffect>> iterator = selectedEffects.entrySet().iterator();
		while (iterator.hasNext()) {
			Entry<String, SelectedEffect> entry = iterator.next();
			SelectedEffect se = entry.getValue();
			if (!se.isUserSelected()) {
				iterator.remove();
			} else {
				// resetto i bonus che poi ricalcolerò
				se.getBonuses().clear();
			}
		}
	}
	
	private void addEffect(Effect e) {
		if (e.getType() != null && e.getType().equalsIgnoreCase("Clickie")) {
			// TODO - Aggiungi il clikie alla lista
		} else {
			if (!selectedEffects.containsKey(e.getName())) {
				SelectedEffect se = new SelectedEffect();
				se.setName(e.getName());
				se.setUserSelected(false);
				selectedEffects.put(e.getName(), se);
			}
			SelectedEffect se = selectedEffects.get(e.getName());
			Map<String, Integer> mappaBonus = se.getBonuses();
			Integer actualValue = mappaBonus.get(e.getType());
			if (actualValue == null || actualValue < e.getValue()) {
				mappaBonus.put(e.getType(), e.getValue());
			}
		}		
	}
	
	public Map<BodySlot, Item> getEquippedItems() {
		return equippedItems;
	}
	
	public List<Item> getItems() {
		return new ArrayList<>(items.values());
	}
	
	public Set<String> getEffects() {
		return Collections.unmodifiableSet(effects);
	}
	
	public Map<String, SelectedEffect> getSelectedEffects() {
		return selectedEffects;
	}

	public Item getItem(String name) {
		return items.get(name);
	}
	
	public void saveGearSetup() {
		EGearSetup eSetup = new EGearSetup();
		eSetup.setId(setup.getId());
		eSetup.setName(setup.getName());
		eSetup.setDescription(setup.getDescription());
		repositorySetup.save(eSetup);
		for (Entry<BodySlot, Item> entry : equippedItems.entrySet()) {
			EGearSetupItem item = new EGearSetupItem();
			item.setIdSetup(eSetup.getId());
			item.setItem(entry.getValue() != null ? entry.getValue().getName() : null);
			item.setSlot(entry.getKey());
			repositorySetupItem.save(item);
		}
	}
	
	public void loadGearSetup(Integer id) {
		EGearSetup eSetup = repositorySetup.findById(id).get();
		setup = new GearSetup();
		setup.setId(eSetup.getId());
		setup.setName(eSetup.getName());
		setup.setDescription(eSetup.getDescription());
		setup.setLastSaved(eSetup.getLastSaved());
		List<EGearSetupItem> itemList = repositorySetupItem.findByIdSetup(id);
		equippedItems = setup.getItems();
		for (EGearSetupItem item : itemList) {
			Item i = items.get(item.getItem());
			equippedItems.put(item.getSlot(), i);
		}
		updateSelectedEffects();
	}

	public Collection<GearSetup> getAllSetups() {
		List<GearSetup> result = new LinkedList<>();
		List<EGearSetup> setupList = repositorySetup.findAll();
		for (EGearSetup eSetup : setupList) {
			GearSetup setup = new GearSetup();
			setup.setId(eSetup.getId());
			setup.setName(eSetup.getName());
			setup.setDescription(eSetup.getDescription());
			setup.setLastSaved(eSetup.getLastSaved());
			result.add(setup);
		}
		return result;
	}

	public void deleteGearSetup(Integer id) {
		repositorySetup.deleteById(id);
	}

}
