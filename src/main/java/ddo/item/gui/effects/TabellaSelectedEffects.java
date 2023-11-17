package ddo.item.gui.effects;

import java.util.Map.Entry;

import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;

import com.dufler.swt.utils.dialog.DialogApribile;
import com.dufler.swt.utils.elements.Etichettatore;
import com.dufler.swt.utils.elements.ModificatoreValoriCelle;
import com.dufler.swt.utils.elements.Ordinatore;
import com.dufler.swt.utils.elements.TabellaCRUD;
import com.dufler.swt.utils.elements.table.filter.CriteriFiltraggioSoloTesto;
import com.dufler.swt.utils.elements.table.filter.FiltroTabella;

import ddo.item.logic.EquippedItems;

public class TabellaSelectedEffects extends TabellaCRUD<SelectedEffect, CriteriFiltraggioSoloTesto> {
	
	private EquippedItems effectsManager = EquippedItems.getInstance();
			
	public TabellaSelectedEffects(Composite parent) {
		super(parent);
	}

	@Override
	protected void aggiungiColonne() {
		aggiungiColonna("Effect", 200, 0);
		aggiungiColonna("Total Bonus", 300, 1);
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
		return null;
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
			}
			return testo;
		}

		@Override
		public String getTestoTooltip(SelectedEffect oggetto, int colonna) {
			String testo = null;
			switch (colonna) {
				case 0 : testo = oggetto.getName(); break;
				case 1 : testo = getDescrizione(oggetto); break;
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
	protected boolean isPermesso() {
		return false;
	}
	
	@Override
	protected boolean isPermessoDelete() {
		return true;
	}

	@Override
	protected DialogApribile creaDialog(SelectedEffect elemento) {
		return null;
	}

	@Override
	protected boolean eliminaElemento(SelectedEffect elemento) {
		return effectsManager.getSelectedEffects().remove(elemento.getName()) != null;
	}

}
