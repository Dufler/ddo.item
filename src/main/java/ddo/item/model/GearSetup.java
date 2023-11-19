package ddo.item.model;

import java.util.Date;
import java.util.Map;

import lombok.Data;

@Data
public class GearSetup {
	
	private Integer id;
	private String name;
	private String description;
	private Date lastSaved;
	private Map<BodySlot, Item> items;

}
