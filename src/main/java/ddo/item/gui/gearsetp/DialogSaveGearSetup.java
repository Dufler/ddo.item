package ddo.item.gui.gearsetp;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import ddo.item.logic.EquippedItems;
import ddo.item.model.GearSetup;

import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class DialogSaveGearSetup {
	
	private EquippedItems itemManager = EquippedItems.getInstance();

	private Shell simpleShell;
	private Text textName;
	private Text textDescription;
	
	public void open() {
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
	 * @wbp.parser.entryPoint
	 */
	private void createContents() {
		simpleShell = new Shell();
		simpleShell.setText("Save Gear Setup");
		simpleShell.setSize(450, 300);
		simpleShell.setLayout(new GridLayout(1, false));
		
		Composite compositeInfo = new Composite(simpleShell, SWT.NONE);
		compositeInfo.setLayout(new GridLayout(2, false));
		compositeInfo.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		
		Label lblName = new Label(compositeInfo, SWT.NONE);
		lblName.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblName.setBounds(0, 0, 55, 15);
		lblName.setText("Name:");
		
		textName = new Text(compositeInfo, SWT.BORDER);
		textName.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false, 1, 1));
		
		Label lblDescription = new Label(compositeInfo, SWT.NONE);
		lblDescription.setLayoutData(new GridData(SWT.RIGHT, SWT.TOP, false, false, 1, 1));
		lblDescription.setBounds(0, 0, 55, 15);
		lblDescription.setText("Description:");
		
		textDescription = new Text(compositeInfo, SWT.BORDER);
		textDescription.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		
		Composite compositeButtons = new Composite(simpleShell, SWT.NONE);
		compositeButtons.setLayout(new GridLayout(2, false));
		compositeButtons.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false, 1, 1));
		
		Button btnSave = new Button(compositeButtons, SWT.NONE);
		btnSave.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				GearSetup setup = itemManager.getSetup();
				setup.setName(textName.getText());
				setup.setDescription(textDescription.getText());
				itemManager.saveGearSetup();
				simpleShell.close();
			}
		});
		btnSave.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, true, false, 1, 1));
		btnSave.setBounds(0, 0, 75, 25);
		btnSave.setText("Save");
		
		Button btnCancel = new Button(compositeButtons, SWT.NONE);
		btnCancel.setText("Cancel");
		
		// Carico i dati
		GearSetup setup = itemManager.getSetup();
		textName.setText(setup.getName());
		textDescription.setText(setup.getDescription());
	}

}
