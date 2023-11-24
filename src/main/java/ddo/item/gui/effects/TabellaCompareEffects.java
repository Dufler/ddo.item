package ddo.item.gui.effects;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Menu;

import com.dufler.swt.utils.elements.Etichettatore;
import com.dufler.swt.utils.elements.ModificatoreValoriCelle;
import com.dufler.swt.utils.elements.Ordinatore;
import com.dufler.swt.utils.elements.Tabella;
import com.dufler.swt.utils.elements.table.filter.CriteriFiltraggioSoloTesto;
import com.dufler.swt.utils.elements.table.filter.FiltroTabella;

public class TabellaCompareEffects extends Tabella<SelectedEffect, CriteriFiltraggioSoloTesto> {
	
	public TabellaCompareEffects(Composite parent) {
		super(parent);
	}

	@Override
	protected void aggiungiColonne() {
		aggiungiColonna("Effect", 200, 0);
		aggiungiColonna("Total Bonus", 300, 3);
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

	@Override
	protected void aggiungiListener() {}

	@Override
	protected void aggiungiMenu(Menu menu) {}

}
