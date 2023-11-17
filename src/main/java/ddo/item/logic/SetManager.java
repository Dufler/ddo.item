package ddo.item.logic;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ddo.item.entity.ENamedSetBonus;
import ddo.item.entity.ESet;
import ddo.item.gui.set.SelectedSet;
import ddo.item.model.Effect;
import ddo.item.model.Item;
import ddo.item.model.NamedSet;
import ddo.item.repository.ENamedSetBonusRepository;
import ddo.item.repository.ESetRepository;

@Component
public class SetManager {
	
	private static SetManager singleton;
	
	@Autowired private ESetRepository setRepository;
	@Autowired private ENamedSetBonusRepository setBonusRepository;
	@Autowired private EquippedItems itemManager;
	
	private HashMap<String, NamedSet> sets;
	private final HashMap<String, SelectedSet> selectedSets;
	
	private SetManager() {
		selectedSets = new HashMap<>();
		singleton = this;
	}
	
	public static SetManager getInstance() {
		return singleton;
	}
	
	@PostConstruct
	private void loadData() {
		sets = new HashMap<>();
		List<ESet> list = setRepository.findAll();
		for (ESet s : list) {
			NamedSet ns = new NamedSet();
			ns.setName(s.getName());
			ns.setPieces(s.getPieces());
			// Recupero gli oggetti che fanno parte del set e li lego a doppio filo
			for (String i : s.getItems()) {
				Item item = itemManager.getItem(i);
				ns.getItems().add(item);
				item.addSet(ns);
			}
			// Recupero gli effetti del set
			List<ENamedSetBonus> listSetBonus = setBonusRepository.findBySet(s.getName());
			for (ENamedSetBonus e : listSetBonus) {
				Effect f = new Effect();
				f.setName(e.getEffect());
				f.setType(e.getType());
				f.setValue(e.getValue());
				ns.getEffects().add(f);
			}
			sets.put(s.getName(), ns);
		}
	}
	
	public Collection<NamedSet> getNamedSets() {
		return sets.values();
	}
	
	public NamedSet getNamedSet(String name) {
		return sets.get(name);
	}
	
	public Map<String, SelectedSet> getSelectedSet() {
		return selectedSets;
	}
	
	public void updateSelectedSet() {
		Map<String, Integer> conteggioPezziSet = new HashMap<>();
		for (Item i : EquippedItems.getInstance().getEquippedItems().values()) {
			if (i != null) for (NamedSet ns : i.getSets()) {
				if (!selectedSets.containsKey(ns.getName())) {
					SelectedSet ss = new SelectedSet(ns.getName(), ns.getPieces());
					ss.setActualNumberOfPieces(0);
					ss.setUserSelected(false);
					ss.getEffects().addAll(ns.getEffects());
					selectedSets.put(ns.getName(), ss);
				}
				if (!conteggioPezziSet.containsKey(ns.getName())) {
					conteggioPezziSet.put(ns.getName(), 0);
				}
				Integer actual = conteggioPezziSet.get(ns.getName()) + 1;
				conteggioPezziSet.put(ns.getName(), actual);
			}
		}
		// Elimino i set che non sono stati selezionati dall'utente e che hanno 0 pezzi
		for (String set : selectedSets.keySet()) {
			Integer actual = conteggioPezziSet.get(set);
			SelectedSet ss =selectedSets.get(set);
			if (actual == null && !ss.isUserSelected()) {
				selectedSets.remove(set);
			} else {
				ss.setActualNumberOfPieces(actual != null ? actual : 0);
			}
		}
	}
	
}
