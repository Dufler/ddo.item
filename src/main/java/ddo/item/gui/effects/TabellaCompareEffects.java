package ddo.item.gui.effects;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Menu;

import com.dufler.swt.utils.elements.Etichettatore;
import com.dufler.swt.utils.elements.ModificatoreValoriCelle;
import com.dufler.swt.utils.elements.Ordinatore;
import com.dufler.swt.utils.elements.Tabella;
import com.dufler.swt.utils.elements.table.filter.CriteriFiltraggioSoloTesto;
import com.dufler.swt.utils.elements.table.filter.FiltroTabella;

public class TabellaCompareEffects extends Tabella<CompareSelectedEffect, CriteriFiltraggioSoloTesto> {
	
	public TabellaCompareEffects(Composite parent) {
		super(parent);
	}

	@Override
	protected void aggiungiColonne() {
		aggiungiColonna("Effect", 200, 0);
		aggiungiColonna("type", 100, 1);
		aggiungiColonna("Total Bonus 1st", 300, 2);
		aggiungiColonna("Total Bonus 2nd", 300, 3);
	}
	
	@Override
	protected Ordinatore<CompareSelectedEffect> creaOrdinatore() {
		return new OrdinatoreCE();
	}

	@Override
	protected Etichettatore<CompareSelectedEffect> creaEtichettatore() {
		return new EtichettatoreCE();
	}

	@Override
	protected ModificatoreValoriCelle<CompareSelectedEffect> creaModificatore() {
		return null;
	}

	@Override
	protected FiltroTabella<CompareSelectedEffect, CriteriFiltraggioSoloTesto> creaFiltro() {
		return null;
	}

	@Override
	protected void aggiungiListener() {}

	@Override
	protected void aggiungiMenu(Menu menu) {}

}
