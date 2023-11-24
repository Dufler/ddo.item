package ddo.item.gui.items;

import com.dufler.swt.utils.elements.table.filter.FiltroTabella;

import ddo.item.model.BodySlot;
import ddo.item.model.Effect;
import ddo.item.model.Item;
import ddo.item.model.NamedSet;

public class FiltroItem extends FiltroTabella<Item, CriteriFiltraggioItem> {
	
	@Override
	protected boolean checkElemento(Item item) {
		return checkSlot(item) && checkName(item) && checkEffect(item) && checkSet(item);
	}
	
	private boolean checkName(Item item) {
		boolean check = false;
		if (criteri.getTesto() != null && !criteri.getTesto().isBlank()) {
			check = item.getName().toLowerCase().contains(criteri.getTesto());
		} else {
			check = true;
		}
		return check;
	}
	
	private boolean checkSlot(Item item) {
		boolean check = false;
		if (criteri.getSlot() != null) {
			for (BodySlot bs : item.getType().getSlot()) {
				if (bs == criteri.getSlot()) {
					check = true;
					break;
				}
			}
		} else {
			check = true;
		}
		return check;
	}
	
	private boolean checkEffect(Item item) {
		boolean check = false;
		if (criteri.getEffect() != null) {
			for (Effect f : item.getEffects()) {
				if (f.getName().equalsIgnoreCase(criteri.getEffect())) {
					if (criteri.getEffectType() != null && !criteri.getEffectType().isEmpty()) {
						check = criteri.getEffectType().contains(f.getType());
					} else {
						check = true;
					}
				}
			}
		} else {
			check = true;
		}
		return check;
	}
	
	private boolean checkSet(Item item) {
		boolean check = false;
		if (criteri.getSet() != null) {
			for (NamedSet ns : item.getSets()) {
				if (ns.getName().equalsIgnoreCase(criteri.getSet())) {
					check = true;
					break;
				}
			}
		} else {
			check = true;
		}
		return check;
	}

}
