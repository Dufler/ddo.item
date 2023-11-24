package ddo.item.gui.items;

import java.util.Set;

import com.dufler.swt.utils.elements.table.filter.CriteriFiltraggio;

import ddo.item.model.BodySlot;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CriteriFiltraggioItem extends CriteriFiltraggio {
	
	private String testo;
	private BodySlot slot;
	private String effect;
	private Set<String> effectType;
	private String set;

	public CriteriFiltraggioItem() {}

}
