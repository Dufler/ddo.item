package ddo.item.gui.effects;

import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.swt.graphics.Image;

import com.dufler.swt.utils.elements.Etichettatore;

public class EtichettatoreCE extends Etichettatore<CompareSelectedEffect> {

	@Override
	public String getTesto(CompareSelectedEffect oggetto, int colonna) {
		String testo = null;
		switch (oggetto.getType().getShow()) {
			case numeric : testo = getNumericDescription(oggetto, colonna); break;
			case none : case not_numeric : testo = getNonNumericDescription(oggetto, colonna); break;
			default : testo = "NA";
		}
		return testo;
	}

	private String getNonNumericDescription(CompareSelectedEffect oggetto, int colonna) {
		String testo = null;
		switch (colonna) {
			case 0 : testo = oggetto.getName(); break;
			case 1 : testo = oggetto.getType().name(); break;
			case 2 : testo = oggetto.isFirstPresent() ? "X" : ""; break;
			case 3 : testo = oggetto.isSecondPresent() ? "X" : ""; break;
			default : testo = "NA";
		}
		return testo;
	}

	private String getNumericDescription(CompareSelectedEffect oggetto, int colonna) {
		String testo = null;
		switch (colonna) {
			case 0 : testo = oggetto.getName(); break;
			case 1 : testo = oggetto.getType().name(); break;
			case 2 : testo = Integer.toString(oggetto.getTotalBonusFirst()); break;
			case 3 : testo = Integer.toString(oggetto.getTotalBonusSecond()); break;
			default : testo = "NA";
		}
		return testo;
	}

	@Override
	public String getTestoTooltip(CompareSelectedEffect oggetto, int colonna) {
		String testo = null;
		switch (colonna) {
			case 0 : testo = oggetto.getName(); break;
			case 1 : testo = oggetto.getType().name(); break;
			case 2 : testo = getDescrizione(oggetto.getBonusesFirst()); break;
			case 3 : testo = getDescrizione(oggetto.getBonusesSecond()); break;
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
