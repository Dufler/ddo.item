package ddo.item.gui.items;

import org.eclipse.swt.widgets.Composite;

import com.dufler.swt.utils.elements.Etichettatore;
import com.dufler.swt.utils.elements.ModificatoreValoriCelle;
import com.dufler.swt.utils.elements.Ordinatore;
import com.dufler.swt.utils.elements.TabellaCheckBoxConFiltro;
import com.dufler.swt.utils.elements.table.filter.FiltroTabella;

import ddo.item.logic.EquippedItems;
import ddo.item.model.BodySlot;
import ddo.item.model.Item;

public class TabellaItem extends TabellaCheckBoxConFiltro<Item, CriteriFiltraggioItem> {
	
	private EquippedItems itemsManager = EquippedItems.getInstance();

	public TabellaItem(Composite parent) {
		super(parent, STILE_SELEZIONE_SINGOLA);
		aggiornaContenuto();
	}

	@Override
	protected FiltroTabella<Item, CriteriFiltraggioItem> creaFiltro() {
		return new FiltroEffetti();
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
		return new OrdinatoreEffetti();
	}

	@Override
	protected Etichettatore<Item> creaEtichettatore() {
		return new EtichettatoreItem();
	}

	@Override
	protected ModificatoreValoriCelle<Item> creaModificatore() {
		return null;
	}
	
	private class OrdinatoreEffetti extends Ordinatore<Item> {

		@Override
		protected int compare(Item t1, Item t2, int property) {
			return t1.getName().compareTo(t2.getName());
		}
		
	}
	
	private class FiltroEffetti extends FiltroTabella<Item, CriteriFiltraggioItem> {
		
		@Override
		protected boolean checkElemento(Item item) {
			return checkSlot(item) && item.getName().toLowerCase().contains(criteri.getTesto());
		}
		
		private boolean checkSlot(Item item) {
			boolean check = false;
			if (criteri.getSlot() != null) {
				for (BodySlot bs : item.getType().getSlot()) {
					if (bs == criteri.getSlot()) {
						check = true;
						break;
					}
				}
			}
			return check;
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
