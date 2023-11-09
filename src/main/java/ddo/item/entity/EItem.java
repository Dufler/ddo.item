package ddo.item.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import ddo.item.model.ItemType;
import lombok.Data;

@Data
@Entity
@Table(name="item")
@SequenceGenerator(name="item_sequence", initialValue = 1, allocationSize = 1)
public class EItem {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO, generator="item_sequence")
	private Integer id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "slot")
	@Enumerated(EnumType.STRING)
	private ItemType slot;

}
