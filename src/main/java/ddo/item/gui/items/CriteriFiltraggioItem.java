package ddo.item.gui.items;

import com.dufler.swt.utils.elements.table.filter.CriteriFiltraggio;

import ddo.item.model.BodySlot;
import lombok.Getter;

@Getter
public class CriteriFiltraggioItem extends CriteriFiltraggio {
	
	private final String testo;
	private final BodySlot slot;

	public CriteriFiltraggioItem(String testo, BodySlot slot) {
		this.testo = testo;
		this.slot = slot;
	}	

}
