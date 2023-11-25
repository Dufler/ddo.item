package ddo.item.gui.effects;

import com.dufler.swt.utils.elements.Ordinatore;

public class OrdinatoreCE extends Ordinatore<CompareSelectedEffect> {

	@Override
	protected int compare(CompareSelectedEffect t1, CompareSelectedEffect t2, int property) {
		int compare;
		switch (property) {
			case 0 : compare = t1.getName().compareTo(t2.getName()); break;
			case 1 : compare = Integer.compare(t1.getTotalBonusFirst(), t2.getTotalBonusFirst()); break;
			case 2 : compare = Integer.compare(t1.getTotalBonusSecond(), t2.getTotalBonusSecond()); break;
			default : compare = t1.getName().compareTo(t2.getName()); break;
		}
		return compare;
	}

}
