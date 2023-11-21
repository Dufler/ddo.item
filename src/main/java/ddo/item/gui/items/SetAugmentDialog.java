package ddo.item.gui.items;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.TableEditor;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;

import com.dufler.swt.utils.input.ComboBox;

import ddo.item.logic.AugmentManager;
import ddo.item.logic.EquippedItems;
import ddo.item.model.Augment;
import ddo.item.model.AugmentSlot;
import ddo.item.model.Effect;
import ddo.item.model.Item;

public class SetAugmentDialog {
	
	protected Shell simpleShell;
	
	private Item item;
	private Text textItemName;
	
	public SetAugmentDialog(Item item) {
		this.item = item;
	}
	
	/**
	 * Open the dialog.
	 * @return the result
	 */
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
	 * Create contents of the dialog.
	 * @wbp.parser.entryPoint
	 */
	private void createContents() {
		simpleShell = new Shell();
		simpleShell.setText("Choose Augments");
		simpleShell.setSize(450, 300);
		simpleShell.setLayout(new GridLayout(1, false));
		
		Composite compositeAugment = new Composite(simpleShell, SWT.NONE);
		compositeAugment.setLayout(new GridLayout(1, false));
		compositeAugment.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		
		Composite compositeItemInfo = new Composite(compositeAugment, SWT.NONE);
		compositeItemInfo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		compositeItemInfo.setBounds(0, 0, 64, 64);
		compositeItemInfo.setLayout(new GridLayout(2, false));
		
		Label lblName = new Label(compositeItemInfo, SWT.NONE);
		lblName.setText("Name: ");
		
		textItemName = new Text(compositeItemInfo, SWT.BORDER | SWT.READ_ONLY);
		textItemName.setText(item.getName());
		
		Composite compositeAugmentTable = new Composite(compositeAugment, SWT.NONE);
		compositeAugmentTable.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		compositeAugmentTable.setBounds(0, 0, 64, 64);
		compositeAugmentTable.setLayout(new GridLayout(1, false));
		
		Table table = new Table(compositeAugmentTable, SWT.BORDER | SWT.MULTI);
		table.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
	    table.setLinesVisible(true);
	    table.setHeaderVisible(true);
	    
	    TableColumn columnType = new TableColumn(table, SWT.NONE);
	    columnType.setWidth(100);
	    columnType.setText("Type");
	    
	    TableColumn columnAugment = new TableColumn(table, SWT.NONE);
	    columnAugment.setWidth(100);
	    columnAugment.setText("Augment");
	    
	    TableColumn columnCurrent = new TableColumn(table, SWT.NONE);
	    columnCurrent.setWidth(100);
	    columnCurrent.setText("Current Effects");
	    
	    for (AugmentSlot a : item.getAugments()) {
	    	TableItem ti = new TableItem(table, SWT.NONE);
	    	ti.setData(a);
	    }
	    TableItem[] items = table.getItems();
	    for (int i = 0; i < items.length; i++) {
	    	AugmentSlot as = (AugmentSlot) items[i].getData();
	    	TableEditor editorType = new TableEditor(table);
		    Text textType = new Text(table, SWT.NONE);
		    textType.setText(as.getType());
		    editorType.grabHorizontal = true;
		    editorType.setEditor(textType, items[i], 0);
		    TableEditor editorCombo = new TableEditor(table);
		    ComboAugment combo = new ComboAugment(table);
		    combo.setItems(AugmentManager.getInstance().getAugmentSlottableInType(as.getType()));
		    combo.addSelectionListener(new SelectionListener() {
				@Override
				public void widgetSelected(SelectionEvent e) {
					Augment a = combo.getSelectedValue();
					if (a != null) {
						as.setAugment(a);
					}
				}
				@Override
				public void widgetDefaultSelected(SelectionEvent e) {
									
				}
			});
		    editorCombo.grabHorizontal = true;
		    editorCombo.setEditor(combo, items[i], 1);
		    TableEditor editorCurrentEffects = new TableEditor(table);
		    Text textCurrentEffects = new Text(table, SWT.NONE);
		    textCurrentEffects.setText(getEffectsDescription(as.getAugment()));
		    editorCurrentEffects.grabHorizontal = true;
		    editorCurrentEffects.setEditor(textCurrentEffects, items[i], 2);
	    }
		
		Composite compositeControls = new Composite(simpleShell, SWT.NONE);
		compositeControls.setLayoutData(new GridData(SWT.FILL, SWT.BOTTOM, true, false, 1, 1));
		compositeControls.setLayout(new GridLayout(2, false));
		
		Button btnOk = new Button(compositeControls, SWT.NONE);
		btnOk.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, true, false, 1, 1));
		btnOk.setBounds(0, 0, 75, 25);
		btnOk.setText("Ok");
		btnOk.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				EquippedItems.getInstance().updateSelectedEffects();
				simpleShell.close();
			}
		});
	}
	
	private String getEffectsDescription(Augment a) {
		StringBuilder sb = new StringBuilder();
		if (a != null) for (Effect e : a.getEffects()) {
			sb.append(e.toString());
			sb.append(", ");
		}
		if (sb.length() >= 2) {
			sb.delete(sb.length() -2, sb.length());
		} else {
			sb.append("<empty!>");
		}
		return sb.toString();
	}
	
	private class ComboAugment extends ComboBox<Augment> {

		public ComboAugment(Composite parent) {
			super(parent);
		}
		
	}
}
