package test.ddo.item.util;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import ddo.item.logic.ComparisonManager;

@Component
@Profile("test")
public class ComparisonManagerTester extends ComparisonManager {
	
	@Override
	public void refreshTables() {
		// DO NOTHING!
	}

}
