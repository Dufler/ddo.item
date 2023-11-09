package ddo.item.gui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ddo.item.logic.Effects;

@Component
public class SWTFrame {
	
	@Autowired private Effects effectsManager;
	
	@Autowired private ChooseEffectsDialog dialogChooseEffects;

	protected Shell shlDdoGearOptimizer;
	private Table effectsTable;
	private Table equipmentTable;

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shlDdoGearOptimizer.open();
		shlDdoGearOptimizer.layout();
		while (!shlDdoGearOptimizer.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 * @wbp.parser.entryPoint
	 */
	protected void createContents() {
		shlDdoGearOptimizer = new Shell();
		shlDdoGearOptimizer.setSize(450, 300);
		shlDdoGearOptimizer.setText("DDO Gear Optimizer");
		shlDdoGearOptimizer.setLayout(new GridLayout(1, false));
		
		TabFolder tabFolder = new TabFolder(shlDdoGearOptimizer, SWT.NONE);
		tabFolder.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		
		TabItem tabOptimizer = new TabItem(tabFolder, SWT.NONE);
		tabOptimizer.setText("Optimizer");
		
		Composite compositeOptimizer = new Composite(tabFolder, SWT.NONE);
		tabOptimizer.setControl(compositeOptimizer);
		compositeOptimizer.setLayout(new GridLayout(2, false));
		
		Composite compositeEffects = new Composite(compositeOptimizer, SWT.NONE);
		compositeEffects.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		compositeEffects.setLayout(new GridLayout(1, false));
		compositeEffects.setBounds(0, 0, 64, 64);
		
		Composite compositeControlEffects = new Composite(compositeEffects, SWT.NONE);
		compositeControlEffects.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		compositeControlEffects.setLayout(new GridLayout(2, false));
		
		Label effectsLabel = new Label(compositeControlEffects, SWT.NONE);
		effectsLabel.setText("Effects");
		
		Button btnAddEffect = new Button(compositeControlEffects, SWT.NONE);
		btnAddEffect.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		btnAddEffect.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				addEffect();
			}
		});
		btnAddEffect.setText("Add Effect");
		
		effectsTable = new Table(compositeEffects, SWT.BORDER | SWT.FULL_SELECTION);
		effectsTable.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		effectsTable.setBounds(0, 0, 85, 45);
		effectsTable.setHeaderVisible(true);
		effectsTable.setLinesVisible(true);
		
		TableColumn effectNameColumn = new TableColumn(effectsTable, SWT.NONE);
		effectNameColumn.setWidth(100);
		effectNameColumn.setText("Effect");
		
		TableColumn effectTotalColumn = new TableColumn(effectsTable, SWT.NONE);
		effectTotalColumn.setWidth(100);
		effectTotalColumn.setText("Total");
		
		TabItem tabItems = new TabItem(tabFolder, SWT.NONE);
		tabItems.setText("Items");
		
		Composite compositeEquipment = new Composite(compositeOptimizer, SWT.NONE);
		compositeEquipment.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		compositeEquipment.setLayout(new GridLayout(1, false));
		compositeEquipment.setBounds(0, 0, 64, 64);
		
		Composite compositeControlEquipment = new Composite(compositeEquipment, SWT.NONE);
		compositeControlEquipment.setLayout(new GridLayout(2, false));
		compositeControlEquipment.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label equipmentLabel = new Label(compositeControlEquipment, SWT.NONE);
		equipmentLabel.setText("Equipment");
		
		Button btnAddEquip = new Button(compositeControlEquipment, SWT.NONE);
		btnAddEquip.setText("Add Item");
		
		equipmentTable = new Table(compositeEquipment, SWT.BORDER | SWT.FULL_SELECTION);
		equipmentTable.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		equipmentTable.setBounds(0, 0, 85, 45);
		equipmentTable.setHeaderVisible(true);
		equipmentTable.setLinesVisible(true);
		
		TableColumn equipmentSlotColumn = new TableColumn(equipmentTable, SWT.NONE);
		equipmentSlotColumn.setWidth(100);
		equipmentSlotColumn.setText("Slot");
		
		TableColumn itemNameColumn = new TableColumn(equipmentTable, SWT.NONE);
		itemNameColumn.setWidth(100);
		itemNameColumn.setText("Item");
		
		tabFolder.pack();
	}
	
	private void addEffect() {
		dialogChooseEffects.open();
		refreshEffectsTable();		
	}
	
	private void refreshEffectsTable() {
		for (String effect : effectsManager.getSelectedEffects()) {
			TableItem item = new TableItem(effectsTable, SWT.NULL);
			item.setText(effect);
			item.setText(0, effect);
			item.setText(1, "0");
		}
	}
}
