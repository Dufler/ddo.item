package ddo.item.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import ddo.item.model.ItemType;
import lombok.Data;

@Data
@Entity
@Table(name="item")
public class EItem implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "name")
	private String name;
	
	@Column(name = "slot")
	@Enumerated(EnumType.STRING)
	private ItemType slot;
	
	@Column(name = "ml")
	private Integer minimumLevel;
	
	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name = "named_set_item", joinColumns = @JoinColumn(name = "item_name"))
	@Column(name = "set_name")
	private Set<String> sets;
	
	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name = "item_augment", joinColumns = @JoinColumn(name = "item_name"))
	@Column(name = "augment_type")
	private Set<String> augments;

}
