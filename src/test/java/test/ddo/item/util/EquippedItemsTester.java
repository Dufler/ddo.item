package test.ddo.item.util;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import ddo.item.logic.EquippedItems;

@Component
@Profile("test")
public class EquippedItemsTester extends EquippedItems {
	
	@Override
	protected void refreshTables() {
		// DO NOTHING!
	}

}
