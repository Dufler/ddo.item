package ddo.item.gui.effects;

import java.util.Collection;
import java.util.Collections;
import java.util.Set;

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

import ddo.item.gui.items.ChooseItemDialog;
import ddo.item.gui.items.CriteriFiltraggioItem;
import ddo.item.logic.EquippedItems;

public class TabellaSelectedEffects extends Tabella<SelectedEffect, CriteriFiltraggioSoloTesto> {
	
	protected MenuItem searchItem;
				
	public TabellaSelectedEffects(Composite parent) {
		super(parent);
	}

	@Override
	protected void aggiungiColonne() {
		aggiungiColonna("Effect", 200, 0);
		aggiungiColonna("Selected", 50, 1);
		aggiungiColonna("Priority", 50, 2);
		aggiungiColonna("Total Bonus", 300, 3);
		aggiungiColonna("Enhancement", 50, 4);
		aggiungiColonna("Insightful", 50, 5);
		aggiungiColonna("Quality", 50, 6);
		aggiungiColonna("Other", 50, 7);
	}
	
	@Override
	protected Collection<SelectedEffect> elaboraContenutoInAutonomia() {
		return EquippedItems.getInstance() != null ? EquippedItems.getInstance().getSelectedEffects().values() : Collections.emptyList();
	}

	@Override
	protected Ordinatore<SelectedEffect> creaOrdinatore() {
		return new OrdinatoreSE();
	}

	@Override
	protected Etichettatore<SelectedEffect> creaEtichettatore() {
		return new EtichettatoreSE();
	}

	@Override
	protected ModificatoreValoriCelle<SelectedEffect> creaModificatore() {
		return new ModificatoreValoriSE(this);
	}

	@Override
	protected FiltroTabella<SelectedEffect, CriteriFiltraggioSoloTesto> creaFiltro() {
		return null;
	}

	@Override
	protected void aggiungiListener() {}

	@Override
	protected void aggiungiMenu(Menu menu) {}

	@Override
	protected void mostraVociSpecificheMenu(Menu menu) {
		if (searchItem != null) searchItem.dispose();
		SelectedEffect riga = getRigaSelezionata();
		if (riga != null) {
			searchItem = new MenuItem(menu, SWT.PUSH);
			searchItem.setText("Search Item");
			searchItem.setImage(Immagine.COPIA_16X16.getImage());
			searchItem.addListener(SWT.Selection, new Listener() {
		    	public void handleEvent(Event event) {
		    		CriteriFiltraggioItem c = new CriteriFiltraggioItem();
		    		c.setEffect(riga.getName());
		    		Set<String> types = riga.getBonusesNotPresent();	    		
		    		c.setEffectType(types);
		    		ChooseItemDialog dialogChooseItem = new ChooseItemDialog();
		    		dialogChooseItem.open(c);
		    		aggiornaContenuto();
		    	}
		    });
		}
	}
	
}
