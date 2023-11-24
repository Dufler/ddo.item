package ddo.item.gui.effects;

import java.util.Map.Entry;

import org.eclipse.swt.graphics.Image;

import com.dufler.swt.utils.elements.Etichettatore;

public class EtichettatoreSE extends Etichettatore<SelectedEffect> {

	@Override
	public String getTesto(SelectedEffect oggetto, int colonna) {
		String testo = null;
		switch (colonna) {
			case 0 : testo = oggetto.getName(); break;
			case 1 : testo = oggetto.isUserSelected() ? "Yes" : "No"; break;
			case 2 : testo = oggetto.getPriority() != null ? Integer.toString(oggetto.getPriority()) : ""; break;
			case 3 : testo = Integer.toString(oggetto.getTotalBonus()); break;
			case 4 : testo = Integer.toString(oggetto.getBonusByType("Enhancement")); break;
			case 5 : testo = Integer.toString(oggetto.getBonusByType("Insightful")); break;
			case 6 : testo = Integer.toString(oggetto.getBonusByType("Quality")); break;
			case 7 : testo = Integer.toString(oggetto.getOtherBonus()); break;
			default : testo = "NA";
		}
		return testo;
	}

	@Override
	public String getTestoTooltip(SelectedEffect oggetto, int colonna) {
		String testo = null;
		switch (colonna) {
			case 0 : testo = oggetto.getName(); break;
			case 1 : testo = oggetto.isUserSelected() ? "Yes" : "No"; break;
			case 2 : testo = oggetto.getPriority() != null ? Integer.toString(oggetto.getPriority()) : ""; break;
			case 3 : testo = getDescrizione(oggetto); break;
			default : testo = "NA";
		}
		return testo;
	}
	
	private String getDescrizione(SelectedEffect oggetto) {
		StringBuilder sb = new StringBuilder();
		for (Entry<String, Integer> e : oggetto.getBonuses().entrySet()) {
			sb.append(e.getKey() != null ? e.getKey() : "<missing>");
			if (e.getValue() != null) {
				sb.append(": ");
				sb.append(e.getValue());
			}				
			sb.append("\r\n");
		}
		return sb.toString();
	}

	@Override
	public Image getIcona(SelectedEffect oggetto, int colonna) {
		return null;
	}

}
