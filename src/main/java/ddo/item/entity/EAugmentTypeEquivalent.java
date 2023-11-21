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
@Table(name="augment_type_equivalent")
@IdClass(EAugmentTypeEquivalentPK.class)
public class EAugmentTypeEquivalent implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "base")
	private String base;
	
	@Id
	@Column(name = "usable")
	private String usable;

}
