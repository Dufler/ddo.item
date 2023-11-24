package ddo.item.gui.items;

import org.eclipse.swt.widgets.Composite;

import com.dufler.swt.utils.elements.Etichettatore;
import com.dufler.swt.utils.elements.ModificatoreValoriCelle;
import com.dufler.swt.utils.elements.Ordinatore;
import com.dufler.swt.utils.elements.TabellaCheckBoxConFiltro;
import com.dufler.swt.utils.elements.table.filter.FiltroTabella;

import ddo.item.logic.EquippedItems;
import ddo.item.model.Item;

public class TabellaItem extends TabellaCheckBoxConFiltro<Item, CriteriFiltraggioItem> {
	
	private EquippedItems itemsManager = EquippedItems.getInstance();

	public TabellaItem(Composite parent) {
		super(parent, STILE_SELEZIONE_SINGOLA);
		aggiornaContenuto();
	}

	@Override
	protected FiltroTabella<Item, CriteriFiltraggioItem> creaFiltro() {
		return new FiltroItem();
	}

	@Override
	protected void aggiungiColonne() {
		aggiungiColonna("Name", 200, 0);
		aggiungiColonna("Slot", 80, 1);
		aggiungiColonna("Effetti", 300, 2);
	}

	@Override
	public void aggiornaContenuto() {
		if (itemsManager != null)
			setElementi(itemsManager.getItems());
		refresh();
	}

	@Override
	protected Ordinatore<Item> creaOrdinatore() {
		return new OrdinatoreItem();
	}

	@Override
	protected Etichettatore<Item> creaEtichettatore() {
		return new EtichettatoreItem();
	}

	@Override
	protected ModificatoreValoriCelle<Item> creaModificatore() {
		return null;
	}
	
	private class OrdinatoreItem extends Ordinatore<Item> {

		@Override
		protected int compare(Item t1, Item t2, int property) {
			int compare;
			switch (property) {
				case 0 : compare = t1.getName().compareTo(t2.getName()); break;
				case 1 : compare = t1.getType().compareTo(t2.getType()); break;
				default : compare = 0;
			}
			return compare;
		}
		
	}

	@Override
	public void apriDialog(Item item) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void apriDialogElimina(Item item) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void duplicaElemento(Item item) {
		// TODO Auto-generated method stub
		
	}

}
