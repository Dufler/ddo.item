package ddo.item.gui.set;

import java.util.Collection;
import java.util.Set;

import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Menu;

import com.dufler.swt.utils.elements.Etichettatore;
import com.dufler.swt.utils.elements.ModificatoreValoriCelle;
import com.dufler.swt.utils.elements.Ordinatore;
import com.dufler.swt.utils.elements.Tabella;
import com.dufler.swt.utils.elements.table.filter.CriteriFiltraggioSoloTesto;
import com.dufler.swt.utils.elements.table.filter.FiltroTabella;

import ddo.item.logic.SetManager;
import ddo.item.model.Effect;
import ddo.item.model.NamedSet;

public class TabellaSet extends Tabella<NamedSet, CriteriFiltraggioSoloTesto> {
	
	public TabellaSet(Composite parent) {
		super(parent);
	}

	@Override
	protected void aggiungiColonne() {
		aggiungiColonna("Name", 150, 0);
		aggiungiColonna("Effects", 300, 1);
	}

	@Override
	protected Ordinatore<NamedSet> creaOrdinatore() {
		return new OrdinatoreNamedSet();
	}

	@Override
	protected Etichettatore<NamedSet> creaEtichettatore() {
		return new EtichettatoreNamedSet();
	}

	@Override
	protected ModificatoreValoriCelle<NamedSet> creaModificatore() {
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
	protected Collection<NamedSet> elaboraContenutoInAutonomia() {
		return SetManager.getInstance().getNamedSets();
	}

	@Override
	protected FiltroTabella<NamedSet, CriteriFiltraggioSoloTesto> creaFiltro() {
		return new FiltroNamedSet();
	}
	
	private class OrdinatoreNamedSet extends Ordinatore<NamedSet> {

		@Override
		protected int compare(NamedSet t1, NamedSet t2, int property) {
			return t1.getName().compareTo(t2.getName());
		}
		
	}
	
	private class EtichettatoreNamedSet extends Etichettatore<NamedSet> {

		@Override
		public String getTesto(NamedSet oggetto, int colonna) {
			String testo;
			switch (colonna) {
				case 0 : testo = oggetto.getName(); break;
				case 1 : testo = printEffects(oggetto.getEffects()); break;
				default : testo = "";
			}
			return testo;
		}

		@Override
		public String getTestoTooltip(NamedSet oggetto, int colonna) {
			return getTesto(oggetto, colonna);
		}

		@Override
		public Image getIcona(NamedSet oggetto, int colonna) {
			return null;
		}
		
		private String printEffects(Set<Effect> effects) {
			StringBuilder sb = new StringBuilder();
			for (Effect e : effects) {
				sb.append(e.toString());
				sb.append(", ");
			}
			if (sb.length() >= 2) {
				sb.delete(sb.length() - 2, sb.length());
			}
			return sb.toString();
		}
		
	}
	
	private class FiltroNamedSet extends FiltroTabella<NamedSet, CriteriFiltraggioSoloTesto> {

		@Override
		protected boolean checkElemento(NamedSet item) {
			return item.getName().contains(criteri.getTesto());
		}
		
	}

}
