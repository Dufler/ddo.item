package ddo.item.gui.effects;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map.Entry;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
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
	
	private EquippedItems effectsManager = EquippedItems.getInstance();
			
	public TabellaSelectedEffects(Composite parent) {
		super(parent);
	}

	@Override
	protected void aggiungiColonne() {
		aggiungiColonna("Effect", 200, 0);
		aggiungiColonna("Total Bonus", 300, 1);
		aggiungiColonna("Selected", 50, 2);
		aggiungiColonna("Priority", 50, 3);
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
	
	private class OrdinatoreSE extends Ordinatore<SelectedEffect> {

		@Override
		protected int compare(SelectedEffect t1, SelectedEffect t2, int property) {
			return t1.getName().compareTo(t2.getName());
		}
		
	}
	
	private class EtichettatoreSE extends Etichettatore<SelectedEffect> {

		@Override
		public String getTesto(SelectedEffect oggetto, int colonna) {
			String testo = null;
			switch (colonna) {
				case 0 : testo = oggetto.getName(); break;
				case 1 : testo = Integer.toString(oggetto.getTotalBonus()); break;
				case 2 : testo = oggetto.isUserSelected() ? "Yes" : "No"; break;
				case 3 : testo = oggetto.getPriority() != null ? Integer.toString(oggetto.getPriority()) : ""; break;
				default : testo = "NA";
			}
			return testo;
		}

		@Override
		public String getTestoTooltip(SelectedEffect oggetto, int colonna) {
			String testo = null;
			switch (colonna) {
				case 0 : testo = oggetto.getName(); break;
				case 1 : testo = getDescrizione(oggetto); break;
				case 2 : testo = oggetto.isUserSelected() ? "Yes" : "No"; break;
				case 3 : testo = oggetto.getPriority() != null ? Integer.toString(oggetto.getPriority()) : ""; break;
				default : testo = "NA";
			}
			return testo;
		}
		
		private String getDescrizione(SelectedEffect oggetto) {
			StringBuilder sb = new StringBuilder();
			for (Entry<String, Integer> e : oggetto.getBonuses().entrySet()) {
				sb.append(e.getKey() != null ? e.getKey() : "<missing>");
				if (e.getValue() != null) {
					sb.append(": ");
					sb.append(e.getValue());
				}				
				sb.append("\r\n");
			}
			return sb.toString();
		}

		@Override
		public Image getIcona(SelectedEffect oggetto, int colonna) {
			return null;
		}
		
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
			searchItem.setText("Set Item");
			searchItem.setImage(Immagine.COPIA_16X16.getImage());
			searchItem.addListener(SWT.Selection, new Listener() {
		    	public void handleEvent(Event event) {
		    		CriteriFiltraggioItem c = new CriteriFiltraggioItem();
		    		c.setEffect(riga.getName());
		    		HashSet<String> types = new HashSet<>();
		    		types.add("Insightful");
		    		types.add("Quality");
		    		types.add("Profane");
		    		types.add("Sacred");
		    		types.add("Sacred");
		    		types.add("Enhancement");
		    		for (String bonusType : riga.getBonuses().keySet()) {
		    			types.remove(bonusType);
		    		}
		    		c.setEffectType(types);
		    		ChooseItemDialog dialogChooseItem = new ChooseItemDialog();
		    		dialogChooseItem.open(c);
		    		aggiornaContenuto();
		    	}
		    });
		}
	}
	
}
