package ddo.item.gui.gearsetp;

import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Menu;

import com.dufler.swt.utils.elements.Etichettatore;
import com.dufler.swt.utils.elements.ModificatoreValoriCelle;
import com.dufler.swt.utils.elements.Ordinatore;
import com.dufler.swt.utils.elements.Tabella;
import com.dufler.swt.utils.elements.table.filter.CriteriFiltraggioSoloTesto;
import com.dufler.swt.utils.elements.table.filter.FiltroTabella;

import ddo.item.model.GearSetup;

public class TabellaGearSetup extends Tabella<GearSetup, CriteriFiltraggioSoloTesto> {

	public TabellaGearSetup(Composite parent) {
		super(parent);
	}

	@Override
	protected void aggiungiColonne() {
		aggiungiColonna("Name", 100, 0);
		aggiungiColonna("Last Saved", 100, 1);
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
	protected void aggiungiMenu(Menu menu) {}

	@Override
	protected FiltroTabella<GearSetup, CriteriFiltraggioSoloTesto> creaFiltro() {
		return null;
	}
	
	private class EtichettatoreGearSetup extends Etichettatore<GearSetup> {

		@Override
		public String getTesto(GearSetup oggetto, int colonna) {
			String testo;
			switch (colonna) {
				case 0 : testo = oggetto.getName(); break;
				case 1 : testo = oggetto.getLastSaved().toString(); break;
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

}
