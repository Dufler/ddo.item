package ddo.item.gui.items;

import org.eclipse.swt.graphics.Image;

import com.dufler.swt.utils.elements.Etichettatore;

import ddo.item.model.Effect;
import ddo.item.model.Item;

public class EtichettatoreItem extends Etichettatore<Item> {

	@Override
	public String getTesto(Item oggetto, int colonna) {
		String testo = null;
		switch (colonna) {
			case 0 : testo = oggetto.getType().name(); break;
			case 1 : testo = oggetto.getName(); break;
			case 2 : testo = getDescrizioneEffetti(oggetto); break;
		}
		return testo;
	}

	@Override
	public String getTestoTooltip(Item oggetto, int colonna) {
		return getTesto(oggetto, colonna);
	}

	@Override
	public Image getIcona(Item oggetto, int colonna) {
		return null;
	}
	
	private String getDescrizioneEffetti(Item oggetto) {
		StringBuilder sb = new StringBuilder();
		for (Effect e : oggetto.getEffects()) {
			sb.append(e.toString());
			sb.append(", ");
		}
		if (sb.length() >= 2) {
			sb.delete(sb.length() - 2, sb.length());
		}
		return sb.toString();
	}

}
