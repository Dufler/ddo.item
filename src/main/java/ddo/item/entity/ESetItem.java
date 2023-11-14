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
@Table(name="named_set_item")
@IdClass(ESetItemPK.class)
public class ESetItem implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "set_name")
	private String set;
	
	@Id
	@Column(name = "item_name")
	private String item;

}
