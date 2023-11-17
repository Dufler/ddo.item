package ddo.item.gui.set;

import java.util.Collection;
import java.util.Collections;

import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;

import com.dufler.swt.utils.dialog.DialogApribile;
import com.dufler.swt.utils.elements.Etichettatore;
import com.dufler.swt.utils.elements.ModificatoreValoriCelle;
import com.dufler.swt.utils.elements.Ordinatore;
import com.dufler.swt.utils.elements.TabellaCRUD;
import com.dufler.swt.utils.elements.table.filter.CriteriFiltraggioSoloTesto;
import com.dufler.swt.utils.elements.table.filter.FiltroTabella;

import ddo.item.logic.SetManager;

public class TabellaSelectedSets extends TabellaCRUD<SelectedSet, CriteriFiltraggioSoloTesto> {
	
	private SetManager setManager = SetManager.getInstance();

	public TabellaSelectedSets(Composite parent) {
		super(parent);
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
	protected DialogApribile creaDialog(SelectedSet elemento) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected boolean eliminaElemento(SelectedSet elemento) {
		return setManager.getSelectedSet().remove(elemento.getName()) != null;
	}

	@Override
	protected void aggiungiColonne() {
		aggiungiColonna("Name", 150, 0);
		aggiungiColonna("Pieces", 100, 1);
		aggiungiColonna("Selected", 50, 2);
	}
	
	@Override
	protected Collection<SelectedSet> elaboraContenutoInAutonomia() {
		return setManager != null ? setManager.getSelectedSet().values() : Collections.emptyList();
	}

	@Override
	protected Ordinatore<SelectedSet> creaOrdinatore() {
		return new OrdinatoreSelectedSet();
	}

	@Override
	protected Etichettatore<SelectedSet> creaEtichettatore() {
		return new EtichettatoreSelectedSet();
	}

	@Override
	protected ModificatoreValoriCelle<SelectedSet> creaModificatore() {
		return null;
	}

	@Override
	protected FiltroTabella<SelectedSet, CriteriFiltraggioSoloTesto> creaFiltro() {
		return null;
	}
	
	private class OrdinatoreSelectedSet extends Ordinatore<SelectedSet> {

		@Override
		protected int compare(SelectedSet t1, SelectedSet t2, int property) {
			return t1.getName().compareTo(t2.getName());
		}
		
	}
	
	private class EtichettatoreSelectedSet extends Etichettatore<SelectedSet> {

		@Override
		public String getTesto(SelectedSet oggetto, int colonna) {
			String testo;
			switch (colonna) {
				case 0 : testo = oggetto.getName(); break;
				case 1 : testo = String.format("%d/%d", oggetto.getActualNumberOfPieces(), oggetto.getMaxNumberOfPieces()); break;
				case 2 : testo = oggetto.isUserSelected() ? "Yes" : "No"; break;
				default : testo = "";
			}
			return testo;
		}

		@Override
		public String getTestoTooltip(SelectedSet oggetto, int colonna) {
			return getTesto(oggetto, colonna);
		}

		@Override
		public Image getIcona(SelectedSet oggetto, int colonna) {
			return null;
		}
		
	}

}
