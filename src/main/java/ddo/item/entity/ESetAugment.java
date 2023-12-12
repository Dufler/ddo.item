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
@Table(name="named_set_augment")
@IdClass(ESetAugmentPK.class)
public class ESetAugment implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "set_name")
	private String set;
	
	@Id
	@Column(name = "augment_name")
	private String augment;

}
