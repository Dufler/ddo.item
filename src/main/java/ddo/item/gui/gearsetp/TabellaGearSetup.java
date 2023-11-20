package ddo.item.gui.gearsetp;

import java.util.Collection;
import java.util.Collections;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;

import com.dufler.swt.utils.decoration.Immagine;
import com.dufler.swt.utils.dialog.DialogMessaggio;
import com.dufler.swt.utils.elements.Etichettatore;
import com.dufler.swt.utils.elements.ModificatoreValoriCelle;
import com.dufler.swt.utils.elements.Ordinatore;
import com.dufler.swt.utils.elements.Tabella;
import com.dufler.swt.utils.elements.table.filter.CriteriFiltraggioSoloTesto;
import com.dufler.swt.utils.elements.table.filter.FiltroTabella;

import ddo.item.logic.EquippedItems;
import ddo.item.model.GearSetup;

public class TabellaGearSetup extends Tabella<GearSetup, CriteriFiltraggioSoloTesto> {
	
	protected MenuItem delete;

	public TabellaGearSetup(Composite parent) {
		super(parent);
	}

	@Override
	protected void aggiungiColonne() {
		aggiungiColonna("ID", 100, 0);
		aggiungiColonna("Name", 100, 1);
		aggiungiColonna("Last Saved", 100, 2);
	}
	
	@Override
	protected Collection<GearSetup> elaboraContenutoInAutonomia() {
		return EquippedItems.getInstance() != null ? EquippedItems.getInstance().getAllSetups() : Collections.emptyList();
	}

	@Override
	protected Ordinatore<GearSetup> creaOrdinatore() {
		return null;
	}

	@Override
	protected Etichettatore<GearSetup> creaEtichettatore() {
		return new EtichettatoreGearSetup();
	}

	@Override
	protected ModificatoreValoriCelle<GearSetup> creaModificatore() {
		return null;
	}

	@Override
	protected void aggiungiListener() {}

	@Override
	protected void aggiungiMenu(Menu menu) {
		aggiungiVoceMenuElimina();
	}

	@Override
	protected FiltroTabella<GearSetup, CriteriFiltraggioSoloTesto> creaFiltro() {
		return null;
	}
	
	private class EtichettatoreGearSetup extends Etichettatore<GearSetup> {

		@Override
		public String getTesto(GearSetup oggetto, int colonna) {
			String testo;
			switch (colonna) {
				case 0 : testo = Integer.toString(oggetto.getId()); break;
				case 1 : testo = oggetto.getName(); break;
				case 2 : testo = oggetto.getLastSaved().toString(); break;
				default : testo = "NA";
			}
			return testo;
		}

		@Override
		public String getTestoTooltip(GearSetup oggetto, int colonna) {
			return getTesto(oggetto, colonna);
		}

		@Override
		public Image getIcona(GearSetup oggetto, int colonna) {
			return null;
		}
		
	}
	
	protected void aggiungiVoceMenuElimina() {
		delete = new MenuItem(menuPopup, SWT.PUSH);
	    delete.setText("Delete");
	    delete.setImage(Immagine.CESTINO_16X16.getImage());
	    delete.addListener(SWT.Selection, new Listener() {
	    	public void handleEvent(Event event) {
	    		GearSetup elemento = getRigaSelezionata();
	    		if (elemento != null)
	    			apriDialogElimina(elemento);
	    	}
	    });
	}
	
	public void apriDialogElimina(GearSetup elemento) {
		boolean scelta = DialogMessaggio.openConfirm("Deletion", "Are you sure that you want to delete this gear setup?");
		if (scelta) {
			EquippedItems.getInstance().deleteGearSetup(elemento.getId());
			aggiornaContenuto();
		}
	}

}
