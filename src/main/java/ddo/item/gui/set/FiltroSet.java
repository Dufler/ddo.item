package ddo.item.gui.set;

import com.dufler.swt.utils.elements.table.filter.CriteriFiltraggioSoloTesto;
import com.dufler.swt.utils.elements.table.filter.FiltroTabella;

import ddo.item.model.NamedSet;

public class FiltroSet extends FiltroTabella<NamedSet, CriteriFiltraggioSoloTesto> {

	@Override
	protected boolean checkElemento(NamedSet item) {
		return checkName(item);
	}
	
	private boolean checkName(NamedSet item) {
		boolean check = false;
		if (criteri.getTesto() != null && !criteri.getTesto().isBlank()) {
			check = item.getName().toLowerCase().contains(criteri.getTesto());
		} else {
			check = true;
		}
		return check;
	}

}
