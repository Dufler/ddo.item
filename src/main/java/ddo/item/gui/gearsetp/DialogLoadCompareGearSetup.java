package ddo.item.gui.gearsetp;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;

import ddo.item.model.GearSetup;

public class DialogLoadCompareGearSetup {

	private Shell simpleShell;
	private TabellaGearSetup tabella;
	private GearSetup setup;
	
	public GearSetup open() {
		createContents();
		simpleShell.open();
		simpleShell.layout();
		Display display = Display.getDefault();
		while (!simpleShell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		return setup;
	}

	/**
	 * @wbp.parser.entryPoint
	 */
	private void createContents() {
		simpleShell = new Shell();
		simpleShell.setText("Compare Gear Setup");
		simpleShell.setSize(450, 300);
		simpleShell.setLayout(new GridLayout(1, false));
		
		Composite compositeTabella = new Composite(simpleShell, SWT.NONE);
		compositeTabella.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		compositeTabella.setLayout(new GridLayout(1, false));
		
		tabella = new TabellaGearSetup(compositeTabella);
		Table table = tabella.getTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDoubleClick(MouseEvent e) {
				caricaGearSetup();
			}
		});
		
		Composite compositeBottoni = new Composite(simpleShell, SWT.NONE);
		compositeBottoni.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		compositeBottoni.setLayout(new GridLayout(2, false));
		
		Button btnLoad = new Button(compositeBottoni, SWT.NONE);
		btnLoad.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				caricaGearSetup();
			}
		});
		btnLoad.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, true, false, 1, 1));
		btnLoad.setBounds(0, 0, 75, 25);
		btnLoad.setText("Load");
		
		Button btnCancel = new Button(compositeBottoni, SWT.NONE);
		btnCancel.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				simpleShell.close();
			}
		});
		btnCancel.setBounds(0, 0, 75, 25);
		btnCancel.setText("Cancel");
		
		tabella.aggiornaContenuto();
	}
	
	private void caricaGearSetup() {
		setup = tabella.getRigaSelezionata();
		if (setup != null) {	
			simpleShell.close();
		}
	}

}
