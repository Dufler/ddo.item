package ddo.item.gui.items;

import java.util.Map.Entry;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;

import com.dufler.swt.utils.decoration.Immagine;
import com.dufler.swt.utils.elements.Etichettatore;
import com.dufler.swt.utils.elements.ModificatoreValoriCelle;
import com.dufler.swt.utils.elements.Ordinatore;
import com.dufler.swt.utils.elements.Tabella;
import com.dufler.swt.utils.elements.table.filter.CriteriFiltraggioSoloTesto;
import com.dufler.swt.utils.elements.table.filter.FiltroTabella;

import ddo.item.model.BodySlot;
import ddo.item.model.Item;

public class TabellaEquippedItems extends Tabella<Entry<BodySlot, Item>, CriteriFiltraggioSoloTesto> {
	
	protected MenuItem setAugment;
	protected MenuItem setItem;

	public TabellaEquippedItems(Composite parent) {
		super(parent);
	}

	@Override
	protected void aggiungiColonne() {
		aggiungiColonna("Slot", 80, 0);
		aggiungiColonna("Item", 200, 1);
		aggiungiColonna("Effects", 300, 2);
		aggiungiColonna("Augments", 300, 3);
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
	protected void mostraVociSpecificheMenu(Menu menu) {
		if (setAugment != null) setAugment.dispose();
		Entry<BodySlot, Item> riga = getRigaSelezionata();
		if (riga != null && riga.getValue() != null && !riga.getValue().getAugments().isEmpty()) {
			setAugment = new MenuItem(menu, SWT.PUSH);
			setAugment.setText("Set Augment");
			setAugment.setImage(Immagine.COPIA_16X16.getImage());
			setAugment.addListener(SWT.Selection, new Listener() {
		    	public void handleEvent(Event event) {
		    		SetAugmentDialog dialog = new SetAugmentDialog(riga.getValue());
		    		dialog.open();
		    		aggiornaContenuto();
		    	}
		    });
		}
		if (setItem != null) setItem.dispose();
		if (riga != null) {
			setItem = new MenuItem(menu, SWT.PUSH);
			setItem.setText("Set Item");
			setItem.setImage(Immagine.COPIA_16X16.getImage());
			setItem.addListener(SWT.Selection, new Listener() {
		    	public void handleEvent(Event event) {
		    		ChooseItemDialog dialogChooseItem = new ChooseItemDialog();
		    		dialogChooseItem.open(riga.getKey());
		    		aggiornaContenuto();
		    	}
		    });
		}
	}

	@Override
	protected FiltroTabella<Entry<BodySlot, Item>, CriteriFiltraggioSoloTesto> creaFiltro() {
		return null;
	}

}
