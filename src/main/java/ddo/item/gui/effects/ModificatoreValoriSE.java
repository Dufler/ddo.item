package ddo.item.gui.effects;

import com.dufler.swt.utils.elements.ModificatoreValoriCelle;

public class ModificatoreValoriSE extends ModificatoreValoriCelle<SelectedEffect> {

	public ModificatoreValoriSE(TabellaSelectedEffects tabella) {
		super(tabella);
	}

	@Override
	protected Object getValore(SelectedEffect elemento, int indiceColonna) {
		Object valore;
		switch (indiceColonna) {
		case 2 : valore = elemento.isUserSelected() ? "Yes" : "No"; break;
		case 3 : valore = elemento.getPriority(); break;
		default : valore = null;
		}
		return valore;
	}

	@Override
	protected boolean setValore(SelectedEffect elemento, Object valore, int indiceColonna) {
		boolean set;
		switch (indiceColonna) {
		case 2 : set = setSelezionato(elemento, valore); break;
		case 3 : set = setPriorita(elemento, valore); break;
		default : set = false;
		}
		return set;
	}

	private boolean setPriorita(SelectedEffect elemento, Object valore) {
		boolean set = false;
		if (elemento != null && valore != null) {
			Integer priorita = null;
			try {
				priorita = Integer.parseInt(valore.toString());
			} catch(Exception e) {}
			if (priorita != null && priorita <= 10 && priorita >= 1) {
				elemento.setPriority(priorita);
				set = true;
			}
		}
		return set;
	}

	private boolean setSelezionato(SelectedEffect elemento, Object valore) {
		boolean set = false;
		if (elemento != null && valore != null) {
			String selezionato = valore.toString();
			if (selezionato.equalsIgnoreCase("Yes")) {
				elemento.setUserSelected(true);
				set = true;
			} else if (selezionato.equalsIgnoreCase("No")) {
				elemento.setUserSelected(false);
				set = true;
			}
		}
		return set;
	}

}
