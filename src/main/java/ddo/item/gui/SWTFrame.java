package ddo.item.gui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
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
import org.eclipse.swt.widgets.Text;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dufler.swt.utils.dialog.DialogMessaggio;
import com.dufler.swt.utils.input.ComboBox;

import ddo.item.gui.effects.ChooseEffectsDialog;
import ddo.item.gui.effects.TabellaSelectedEffects;
import ddo.item.gui.gearsetp.DialogLoadGearSetup;
import ddo.item.gui.gearsetp.DialogSaveGearSetup;
import ddo.item.gui.items.ChooseItemDialog;
import ddo.item.gui.items.CriteriFiltraggioItem;
import ddo.item.gui.items.TabellaEquippedItems;
import ddo.item.gui.items.TabellaItem;
import ddo.item.gui.set.ChooseSetDialog;
import ddo.item.gui.set.TabellaSelectedSets;
import ddo.item.logic.EquippedItems;
import ddo.item.logic.SetManager;
import ddo.item.model.BodySlot;
import ddo.item.model.ItemType;
import ddo.item.wiki.WikiParser;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class SWTFrame {
	
	@Autowired private WikiParser wp;
	@Autowired private EquippedItems equippedItems;
	@Autowired private SetManager setManager;
	
	@Autowired private ChooseEffectsDialog dialogChooseEffects;
	@Autowired private ChooseItemDialog dialogChooseItem;
	@Autowired private ChooseSetDialog dialogChooseSet;

	protected Shell shlDdoGearOptimizer;
	
	private TabFolder tabFolder;
	
	private Composite compositeOptimizer;
	
	private TabellaSelectedEffects effectsTable;
	private TabellaEquippedItems equipmentTable;
	private TabellaItem itemTable;
	private TabellaSelectedSets setsTable;
	
	private Text textFilterItem;
	private ComboBox<BodySlot> comboSlotFilter;

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
		
		tabFolder = new TabFolder(shlDdoGearOptimizer, SWT.NONE);
		tabFolder.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		
		addTabOptimizer();		
		addTabItems();
		
		tabFolder.pack();
		
		// Aggiungo i riferimenti al manager
		equippedItems.setEffectTable(effectsTable);
		equippedItems.setItemTable(equipmentTable);
		equippedItems.setSetsTable(setsTable);
	}
	
	private void addTabOptimizer() {
		TabItem tabOptimizer = new TabItem(tabFolder, SWT.NONE);
		tabOptimizer.setText("Optimizer");
		
		compositeOptimizer = new Composite(tabFolder, SWT.NONE);
		tabOptimizer.setControl(compositeOptimizer);
		compositeOptimizer.setLayout(new GridLayout(2, false));
		
		addCompositeUserFunctions();
		
		addCompositeEffects();
		
		addCompositeEquipment();
		
		addCompositeSet();
	}
	
	private void addCompositeUserFunctions() {
		Composite compositeUserFunctions = new Composite(compositeOptimizer, SWT.NONE);
		compositeUserFunctions.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));
		compositeUserFunctions.setLayout(new GridLayout(4, false));
		
		Button btnBuildSetup = new Button(compositeUserFunctions, SWT.NONE);
		btnBuildSetup.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				String message = "This button will open a wizard that will let you choose a basic setup for your build (e.g. melee, ranged, DC caster, ...)\r\nThose info will be used to optmize gear selection.";
				DialogMessaggio m = new DialogMessaggio(shlDdoGearOptimizer, "Build Setup Wizard", null, message, DialogMessaggio.INFORMATION, 0, "Ok");
				m.open();
			}
		});
		btnBuildSetup.setBounds(0, 0, 75, 25);
		btnBuildSetup.setText("Build Setup");
		
		Button btnOptimize = new Button(compositeUserFunctions, SWT.NONE);
		btnOptimize.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				String message = "This button will start a process of automatic gear selection.";
				DialogMessaggio m = new DialogMessaggio(shlDdoGearOptimizer, "Build Optimization", null, message, DialogMessaggio.INFORMATION, 0, "Ok");
				m.open();
			}
		});
		btnOptimize.setBounds(0, 0, 75, 25);
		btnOptimize.setText("Optimize");
		
		Button btnSave = new Button(compositeUserFunctions, SWT.NONE);
		btnSave.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				DialogSaveGearSetup dialog = new DialogSaveGearSetup();
				dialog.open();
			}
		});
		btnSave.setText("Save");
		
		Button btnLoad = new Button(compositeUserFunctions, SWT.NONE);
		btnLoad.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				DialogLoadGearSetup dialog = new DialogLoadGearSetup();
				dialog.open();
			}
		});
		btnLoad.setText("Load");
	}
	
	private void addCompositeEquipment() {
		Composite compositeEquipment = new Composite(compositeOptimizer, SWT.NONE);
		compositeEquipment.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 2));
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
	}
	
	private void addCompositeEffects() {
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
		
		effectsTable = new TabellaSelectedEffects(compositeEffects);
	}
	
	private void addCompositeSet() {
		Composite compositeSet = new Composite(compositeOptimizer, SWT.NONE);
		compositeSet.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		compositeSet.setLayout(new GridLayout(1, false));
		
		Composite compositeSetControl = new Composite(compositeSet, SWT.NONE);
		compositeSetControl.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1));
		compositeSetControl.setLayout(new GridLayout(2, false));
		
		Label lblSet = new Label(compositeSetControl, SWT.NONE);
		lblSet.setText("Set");
		
		Button btnAddSet = new Button(compositeSetControl, SWT.NONE);
		btnAddSet.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				addSet();
			}
		});
		btnAddSet.setText("Add Set");
		
		setsTable = new TabellaSelectedSets(compositeSet);
	}
	
	private void addTabItems() {
		TabItem tabItems = new TabItem(tabFolder, SWT.NONE);
		tabItems.setText("Items");
		
		Composite compositeItems = new Composite(tabFolder, SWT.NONE);
		tabItems.setControl(compositeItems);
		compositeItems.setLayout(new GridLayout(1, false));
		
		Composite compositeItemControl = new Composite(compositeItems, SWT.NONE);
		compositeItemControl.setLayout(new GridLayout(5, false));
		compositeItemControl.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false, 1, 1));
		
		Label lblFiltraItem = new Label(compositeItemControl, SWT.NONE);
		lblFiltraItem.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblFiltraItem.setBounds(0, 0, 55, 15);
		lblFiltraItem.setText("Filtra:");
		
		textFilterItem = new Text(compositeItemControl, SWT.BORDER);
		textFilterItem.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String text = textFilterItem.getText();
				if (text != null && text.length() > 2) {
					text = text.toLowerCase();
					CriteriFiltraggioItem c = new CriteriFiltraggioItem();
					c.setTesto(text);
					c.setSlot(comboSlotFilter.getSelectedValue());
					itemTable.filtra(c);
				}
				
			}
		});
		textFilterItem.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		comboSlotFilter = new ComboBox<BodySlot>(compositeItemControl);
		comboSlotFilter.setItems(BodySlot.values());
		comboSlotFilter.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				CriteriFiltraggioItem c = new CriteriFiltraggioItem();
				c.setTesto(textFilterItem.getText().toLowerCase());
				c.setSlot(comboSlotFilter.getSelectedValue());
				itemTable.filtra(c);
			}
		});
		
		Button btnClearItemFilter = new Button(compositeItemControl, SWT.NONE);
		btnClearItemFilter.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				textFilterItem.setText("");
				itemTable.annullaFiltro();
			}
		});
		btnClearItemFilter.setText("Clear");
		
		Button btnReloadItem = new Button(compositeItemControl, SWT.NONE);
		btnReloadItem.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				parseItems();
				EquippedItems.getInstance().reloadData();
				itemTable.aggiornaContenuto();
			}
		});
		btnReloadItem.setText("Update Items Database");
		//btnReloadItem.setEnabled(false);
		
		Composite compositeItemTable = new Composite(compositeItems, SWT.NONE);
		compositeItemTable.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		compositeItemTable.setLayout(new GridLayout(1, false));
		
		itemTable = new TabellaItem(compositeItemTable);
	}
	
	private void addEffect() {
		dialogChooseEffects.open();
		effectsTable.aggiornaContenuto();	
	}
	
	private void addItem() {
		dialogChooseItem.open(null);
		equipmentTable.aggiornaContenuto();
	}
	
	private void addSet() {
		dialogChooseSet.open();
		setsTable.aggiornaContenuto();
	}
	
	private void parseItems() {
		log.info("Parsing degli oggetti");
		try {
			for (ItemType type : ItemType.values()) {
				// Per le quiver ho uno script di insert
				if (type == ItemType.QUIVER)
					continue;
				String resource = String.format("src/main/resources/pages/%s.html", type.name().toLowerCase());
				wp.updateItems(resource, type);
			}
		} catch(Exception e) {
			log.error(e.getMessage(), e);
		}	
	}
}
