package ddo.item.gui.set;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dufler.swt.utils.elements.table.filter.CriteriFiltraggioSoloTesto;

import ddo.item.logic.SetManager;
import ddo.item.model.NamedSet;

@Component
public class ChooseSetDialog {
	
	@Autowired private SetManager setManager;
	
	protected Shell shlChooseEffects;
	private Text filterText;
	private TabellaSet tabella;
	
	/**
	 * Create the dialog.
	 * @param parent
	 * @param style
	 */
	public ChooseSetDialog() {
		
	}

	/**
	 * Open the dialog.
	 * @return the result
	 */
	public void open() {
		createContents();
		shlChooseEffects.open();
		shlChooseEffects.layout();
		Display display = Display.getDefault();
		while (!shlChooseEffects.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the dialog.
	 * @wbp.parser.entryPoint
	 */
	private void createContents() {
		shlChooseEffects = new Shell();
		shlChooseEffects.setText("Choose Sets");
		shlChooseEffects.setSize(450, 300);
		shlChooseEffects.setLayout(new GridLayout(1, false));
		
		Composite filterComposite = new Composite(shlChooseEffects, SWT.NONE);
		filterComposite.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		filterComposite.setLayout(new RowLayout(SWT.HORIZONTAL));
		
		Label filterLabel = new Label(filterComposite, SWT.NONE);
		filterLabel.setText("Filter: ");
		
		filterText = new Text(filterComposite, SWT.BORDER);
		filterText.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				CriteriFiltraggioSoloTesto c = new CriteriFiltraggioSoloTesto(filterText.getText().toLowerCase());
				tabella.filtra(c);
			}
		});
		filterText.setLayoutData(new RowData(100, SWT.DEFAULT));
		
		Button btnClear = new Button(filterComposite, SWT.NONE);
		btnClear.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				filterText.setText("");
				tabella.annullaFiltro();
			}
		});
		btnClear.setText("clear");
		
		Composite effectsComposite = new Composite(shlChooseEffects, SWT.NONE);
		effectsComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		effectsComposite.setLayout(new GridLayout(1, false));
		
		tabella = new TabellaSet(effectsComposite);
		
		Composite buttonComposite = new Composite(shlChooseEffects, SWT.NONE);
		buttonComposite.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		buttonComposite.setBounds(0, 0, 64, 64);
		buttonComposite.setLayout(new RowLayout(SWT.HORIZONTAL));
		
		Button okButton = new Button(buttonComposite, SWT.NONE);
		okButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				for (NamedSet ns : tabella.getRigheSelezionate()) {
					if (!setManager.getSelectedSet().containsKey(ns.getName())) {
						SelectedSet ss = new SelectedSet(ns.getName(), ns.getPieces());
						ss.setActualNumberOfPieces(0);
						ss.getEffects().addAll(ns.getEffects());
						ss.setUserSelected(true);
						setManager.getSelectedSet().put(ns.getName(), ss);
					}
				}
				shlChooseEffects.close();
			}
		});
		okButton.setText("Ok");
		
		Button cancelButton = new Button(buttonComposite, SWT.NONE);
		cancelButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shlChooseEffects.close();
			}
		});
		cancelButton.setText("Cancel");
		
	}	

}
