package ddo.item.gui.effects;

import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.swt.graphics.Image;

import com.dufler.swt.utils.elements.Etichettatore;

public class EtichettatoreCE extends Etichettatore<CompareSelectedEffect> {

	@Override
	public String getTesto(CompareSelectedEffect oggetto, int colonna) {
		String testo = null;
		switch (colonna) {
			case 0 : testo = oggetto.getName(); break;
//			case 1 : testo = oggetto.isUserSelected() ? "Yes" : "No"; break;
//			case 2 : testo = oggetto.getPriority() != null ? Integer.toString(oggetto.getPriority()) : ""; break;
			case 1 : testo = Integer.toString(oggetto.getTotalBonusFirst()); break;
			case 2 : testo = Integer.toString(oggetto.getTotalBonusSecond()); break;
			default : testo = "NA";
		}
		return testo;
	}

	@Override
	public String getTestoTooltip(CompareSelectedEffect oggetto, int colonna) {
		String testo = null;
		switch (colonna) {
			case 0 : testo = oggetto.getName(); break;
//			case 1 : testo = oggetto.isUserSelected() ? "Yes" : "No"; break;
//			case 2 : testo = oggetto.getPriority() != null ? Integer.toString(oggetto.getPriority()) : ""; break;
			case 1 : testo = getDescrizione(oggetto.getBonusesFirst()); break;
			case 2 : testo = getDescrizione(oggetto.getBonusesSecond()); break;
			default : testo = "NA";
		}
		return testo;
	}
	
	private String getDescrizione(Map<String, Integer> bonuses) {
		StringBuilder sb = new StringBuilder();
		for (Entry<String, Integer> e : bonuses.entrySet()) {
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
	public Image getIcona(CompareSelectedEffect oggetto, int colonna) {
		return null;
	}

}
