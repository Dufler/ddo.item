package ddo.item.gui;

import java.util.Set;

import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.TableItem;

import com.dufler.swt.utils.elements.Etichettatore;
import com.dufler.swt.utils.elements.ModificatoreValoriCelle;
import com.dufler.swt.utils.elements.Ordinatore;
import com.dufler.swt.utils.elements.TabellaCheckBoxConFiltro;
import com.dufler.swt.utils.elements.table.filter.CriteriFiltraggioSoloTesto;
import com.dufler.swt.utils.elements.table.filter.FiltroTabella;

import ddo.item.logic.Effects;

public class TabellaEffects extends TabellaCheckBoxConFiltro<String, CriteriFiltraggioSoloTesto> {
	
	private Effects effectsManager;

	public TabellaEffects(Composite parent, Effects effectsManager) {
		super(parent, STILE_SELEZIONE_SINGOLA);
		this.effectsManager = effectsManager;
		selezionaEffettiGiaScelti();
		aggiornaContenuto();
	}

	@Override
	public void apriDialog(String item) {}

	@Override
	public void apriDialogElimina(String item) {}

	@Override
	public void duplicaElemento(String item) {}

	@Override
	protected FiltroTabella<String, CriteriFiltraggioSoloTesto> creaFiltro() {
		return new FiltroEffetti();
	}

	@Override
	protected void aggiungiColonne() {
		aggiungiColonna("Effect", 300, 0);		
	}

	@Override
	public void aggiornaContenuto() {
		if (effectsManager != null)
			setElementi(effectsManager.getEffects());		
	}
	
	private void selezionaEffettiGiaScelti() {
		Set<String> selected = effectsManager.getSelectedEffects();
		TableItem[] children = getTable().getItems();
		for (TableItem item : children) {
			String effect = (String) item.getData();
			if (effect != null) {
				boolean seleziona = selected.contains(effect);
				item.setChecked(seleziona);
			}
		}	
	}

	@Override
	protected Ordinatore<String> creaOrdinatore() {
		return new OrdinatoreEffetti();
	}

	@Override
	protected Etichettatore<String> creaEtichettatore() {
		return new EtichettatoreEffetti();
	}

	@Override
	protected ModificatoreValoriCelle<String> creaModificatore() {
		return null;
	}
	
	private class OrdinatoreEffetti extends Ordinatore<String> {

		@Override
		protected int compare(String t1, String t2, int property) {
			return t1.compareTo(t2);
		}
		
	}
	
	private class EtichettatoreEffetti extends Etichettatore<String> {

		@Override
		public String getTesto(String oggetto, int colonna) {
			return oggetto;
		}

		@Override
		public String getTestoTooltip(String oggetto, int colonna) {
			return oggetto;
		}

		@Override
		public Image getIcona(String oggetto, int colonna) {
			return null;
		}
		
	}
	
	private class FiltroEffetti extends FiltroTabella<String, CriteriFiltraggioSoloTesto> {
		
		@Override
		protected boolean checkElemento(String item) {
			return item.contains(criteri.getTesto());
		}
		
	} 

}
