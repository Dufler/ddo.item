package ddo.item.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

import ddo.item.model.ItemType;
import lombok.Data;

@Data
@Entity
@Table(name="item")
public class EItem {
	
	@Id
	@Column(name = "name")
	private String name;
	
	@Column(name = "slot")
	@Enumerated(EnumType.STRING)
	private ItemType slot;
	
	@Column(name = "ml")
	private Integer minimumLevel;

}
