package ddo.item.gui.items;

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
import org.springframework.stereotype.Component;

import com.dufler.swt.utils.input.ComboBox;

import ddo.item.logic.EquippedItems;
import ddo.item.model.BodySlot;
import ddo.item.model.Item;

@Component
public class ChooseItemDialog {
		
	protected Shell simpleShell;
	private Text filterText;
	private ComboBox<BodySlot> comboSlot;
	private TabellaItem tabella;
	
	private CriteriFiltraggioItem filtro;
	
	/**
	 * Create the dialog.
	 * @param parent
	 * @param style
	 */
	public ChooseItemDialog() {
		
	}

	/**
	 * Open the dialog.
	 * @return the result
	 */
	public void open(CriteriFiltraggioItem filter) {
		filtro = filter != null ? filter : new CriteriFiltraggioItem();
		createContents();
		simpleShell.open();
		simpleShell.layout();
		Display display = Display.getDefault();
		while (!simpleShell.isDisposed()) {
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
		simpleShell = new Shell();
		simpleShell.setText("Choose effects");
		simpleShell.setSize(450, 300);
		simpleShell.setLayout(new GridLayout(1, false));
		
		Composite filterComposite = new Composite(simpleShell, SWT.NONE);
		filterComposite.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		filterComposite.setLayout(new RowLayout(SWT.HORIZONTAL));
		
		Label filterLabel = new Label(filterComposite, SWT.NONE);
		filterLabel.setText("Filter: ");
		
		filterText = new Text(filterComposite, SWT.BORDER);
		filterText.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String text = filterText.getText();
				if (text != null && text.length() > 2) {
					filtro.setTesto(text.toLowerCase());
					filtro.setSlot(comboSlot.getSelectedValue());
					tabella.filtra(filtro);
				}				
			}
		});
		filterText.setLayoutData(new RowData(100, SWT.DEFAULT));
		
		comboSlot = new ComboBox<BodySlot>(filterComposite);
		comboSlot.setItems(BodySlot.values());
		comboSlot.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				filtro.setTesto(filterText.getText().toLowerCase());
				filtro.setSlot(comboSlot.getSelectedValue());
				tabella.filtra(filtro);
			}
		});
		
		Button btnClear = new Button(filterComposite, SWT.NONE);
		btnClear.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				filterText.setText("");
				comboSlot.setSelectedValue(null);
				tabella.annullaFiltro();
			}
		});
		btnClear.setText("clear");
		
		Composite effectsComposite = new Composite(simpleShell, SWT.NONE);
		effectsComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		effectsComposite.setLayout(new GridLayout(1, false));
		
		tabella = new TabellaItem(effectsComposite);
		
		Composite buttonComposite = new Composite(simpleShell, SWT.NONE);
		buttonComposite.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		buttonComposite.setBounds(0, 0, 64, 64);
		buttonComposite.setLayout(new RowLayout(SWT.HORIZONTAL));
		
		Button okButton = new Button(buttonComposite, SWT.NONE);
		okButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Item item = tabella.getRigaSelezionata();
				if (item != null) {
					BodySlot bs = filtro != null && filtro.getSlot() != null ? filtro.getSlot() : item.getType().getSlot()[0]; 
					EquippedItems.getInstance().equip(bs, item);
				}
				simpleShell.close();
			}
		});
		okButton.setText("Equip");
		
		Button cancelButton = new Button(buttonComposite, SWT.NONE);
		cancelButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				simpleShell.close();
			}
		});
		cancelButton.setText("Cancel");
		
		if (filtro != null) {
			if (filtro.getSlot() != null) {
				comboSlot.setSelectedValue(filtro.getSlot());
			}
			tabella.filtra(filtro);
		}
	}	
	
}
