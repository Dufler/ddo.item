package ddo.item.model;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import lombok.Data;

@Data
public class GearSetup {
	
	private Integer id;
	private String name;
	private String description;
	private Date lastSaved;
	private final Map<BodySlot, Item> items;
	
	public GearSetup() {
		items = new HashMap<>();
	}

}
