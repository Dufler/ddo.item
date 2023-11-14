package ddo.item.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="named_set")
public class ESet implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "name")
	private String name;
	
	@Column(name = "pieces")
	private Integer pieces;
	
	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name = "named_set_item", joinColumns = @JoinColumn(name = "set_name"))
	@Column(name = "item_name")
	private Set<String> items;

}
