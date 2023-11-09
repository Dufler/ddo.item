package ddo.item.gui.items;

import org.eclipse.swt.widgets.Composite;

import com.dufler.swt.utils.elements.Etichettatore;
import com.dufler.swt.utils.elements.ModificatoreValoriCelle;
import com.dufler.swt.utils.elements.Ordinatore;
import com.dufler.swt.utils.elements.TabellaCheckBoxConFiltro;
import com.dufler.swt.utils.elements.table.filter.CriteriFiltraggioSoloTesto;
import com.dufler.swt.utils.elements.table.filter.FiltroTabella;

import ddo.item.logic.EquippedItems;
import ddo.item.model.Item;

public class TabellaItem extends TabellaCheckBoxConFiltro<Item, CriteriFiltraggioSoloTesto> {
	
	private EquippedItems itemsManager;

	public TabellaItem(Composite parent, EquippedItems itemsManager) {
		super(parent, STILE_SELEZIONE_SINGOLA);
		this.itemsManager = itemsManager;
		aggiornaContenuto();
	}

	@Override
	protected FiltroTabella<Item, CriteriFiltraggioSoloTesto> creaFiltro() {
		return new FiltroEffetti();
	}

	@Override
	protected void aggiungiColonne() {
		aggiungiColonna("Name", 200, 0);
		aggiungiColonna("Slot", 80, 1);
		aggiungiColonna("Effetti", 300, 1);
	}

	@Override
	public void aggiornaContenuto() {
		if (itemsManager != null)
			setElementi(itemsManager.getItems());		
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
	
	private class FiltroEffetti extends FiltroTabella<Item, CriteriFiltraggioSoloTesto> {
		
		@Override
		protected boolean checkElemento(Item item) {
			return item.getName().toLowerCase().contains(criteri.getTesto().toLowerCase());
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
