package ddo.item.gui.items;

import java.util.Map.Entry;

import org.eclipse.swt.graphics.Image;

import com.dufler.swt.utils.elements.Etichettatore;

import ddo.item.model.AugmentSlot;
import ddo.item.model.BodySlot;
import ddo.item.model.Effect;
import ddo.item.model.Item;

public class EtichettatoreEntry extends Etichettatore<Entry<BodySlot, Item>> {

	@Override
	public String getTesto(Entry<BodySlot, Item> oggetto, int colonna) {
		String testo = null;
		switch (colonna) {
			case 0 : testo = oggetto.getKey().toString(); break;
			case 1 : testo = oggetto.getValue() != null ? oggetto.getValue().getName() : "<equip something!>"; break;
			case 2 : testo = getDescrizioneEffetti(oggetto.getValue()); break;
			case 3 : testo = getDescrizioneAugments(oggetto.getValue()); break;
		}
		return testo;
	}

	@Override
	public String getTestoTooltip(Entry<BodySlot, Item> oggetto, int colonna) {
		return getTesto(oggetto, colonna);
	}

	@Override
	public Image getIcona(Entry<BodySlot, Item> oggetto, int colonna) {
		return null;
	}
	
	private String getDescrizioneEffetti(Item oggetto) {
		StringBuilder sb = new StringBuilder();
		if (oggetto != null) for (Effect e : oggetto.getEffects()) {
			sb.append(e.toString());
			sb.append(", ");
		}
		if (sb.length() >= 2) {
			sb.delete(sb.length() - 2, sb.length());
		}
		return sb.toString();
	}
	
	private String getDescrizioneAugments(Item oggetto) {
		StringBuilder sb = new StringBuilder();
		if (oggetto != null) for (AugmentSlot a: oggetto.getAugments()) {
			sb.append(a.toString());
			sb.append(", ");
		}
		if (sb.length() >= 2) {
			sb.delete(sb.length() - 2, sb.length());
		}
		return sb.toString();
	}

}
