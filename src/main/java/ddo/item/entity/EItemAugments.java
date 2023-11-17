package ddo.item.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="item_augment")
@IdClass(EItemAugmentsPK.class)
public class EItemAugments implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "augment_type")
	private String augment;
	
	@Id
	@Column(name = "item_name")
	private String item;

}
