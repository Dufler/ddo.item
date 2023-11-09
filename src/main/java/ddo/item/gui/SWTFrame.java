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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ddo.item.gui.effects.ChooseEffectsDialog;
import ddo.item.gui.effects.TabellaSelectedEffects;
import ddo.item.gui.items.ChooseItemDialog;
import ddo.item.gui.items.TabellaEquippedItems;
import ddo.item.logic.EquippedItems;

@Component
public class SWTFrame {
	
	@Autowired private EquippedItems equippedItems;
	
	@Autowired private ChooseEffectsDialog dialogChooseEffects;
	@Autowired private ChooseItemDialog dialogChooseItem;

	protected Shell shlDdoGearOptimizer;
	
	private TabellaSelectedEffects effectsTable;
	private TabellaEquippedItems equipmentTable;

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
		
		effectsTable = new TabellaSelectedEffects(compositeEffects, equippedItems);
		refreshEffectsTable();
		
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
		btnAddEquip.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				addItem();
			}
		});
		btnAddEquip.setText("Add Item");
		
		equipmentTable = new TabellaEquippedItems(compositeEquipment);
		refreshEquippedItemsTable();
		
		tabFolder.pack();
	}
	
	private void addEffect() {
		dialogChooseEffects.open();
		refreshEffectsTable();		
	}
	
	private void addItem() {
		dialogChooseItem.open();
		refreshEquippedItemsTable();
		refreshEffectsTable();
	}
	
	private void refreshEffectsTable() {
		effectsTable.setElementi(equippedItems.getSelectedEffects().values());
	}
	
	private void refreshEquippedItemsTable() {
		equipmentTable.setElementi(equippedItems.getEquippedItems().entrySet());
	}
	
}
