package ddo.item.gui.items;

import java.util.Map.Entry;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Menu;

import com.dufler.swt.utils.elements.Etichettatore;
import com.dufler.swt.utils.elements.ModificatoreValoriCelle;
import com.dufler.swt.utils.elements.Ordinatore;
import com.dufler.swt.utils.elements.Tabella;
import com.dufler.swt.utils.elements.table.filter.CriteriFiltraggioSoloTesto;
import com.dufler.swt.utils.elements.table.filter.FiltroTabella;

import ddo.item.model.BodySlot;
import ddo.item.model.Item;

public class TabellaEquippedItems extends Tabella<Entry<BodySlot, Item>, CriteriFiltraggioSoloTesto> {

	public TabellaEquippedItems(Composite parent) {
		super(parent);
	}

	@Override
	protected void aggiungiColonne() {
		aggiungiColonna("Slot", 80, 0);
		aggiungiColonna("Item", 200, 1);
		aggiungiColonna("Effects", 300, 2);
	}

	@Override
	protected Ordinatore<Entry<BodySlot, Item>> creaOrdinatore() {
		return null;
	}

	@Override
	protected Etichettatore<Entry<BodySlot, Item>> creaEtichettatore() {
		return new EtichettatoreEntry();
	}

	@Override
	protected ModificatoreValoriCelle<Entry<BodySlot, Item>> creaModificatore() {
		return null;
	}

	@Override
	protected void aggiungiListener() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void aggiungiMenu(Menu menu) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected FiltroTabella<Entry<BodySlot, Item>, CriteriFiltraggioSoloTesto> creaFiltro() {
		return null;
	}

}
