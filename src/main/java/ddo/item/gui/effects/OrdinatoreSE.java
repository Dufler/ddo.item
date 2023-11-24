package ddo.item.gui.effects;

import com.dufler.swt.utils.elements.Ordinatore;

public class OrdinatoreSE extends Ordinatore<SelectedEffect> {

	@Override
	protected int compare(SelectedEffect t1, SelectedEffect t2, int property) {
		int compare;
		switch (property) {
			case 0 : compare = t1.getName().compareTo(t2.getName()); break;
			case 1 : compare = Boolean.compare(t1.isUserSelected(), t2.isUserSelected()); break;
			default : compare = t1.getName().compareTo(t2.getName()); break;
		}
		return compare;
	}

}
