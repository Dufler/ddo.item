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
@Table(name="gear_setup_augment")
@IdClass(EGearSetupAugmentPK.class)
public class EGearSetupAugment implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "id_setup")
	private Integer idSetup;
	
	@Id
	@Column(name = "item")
	private String item;
	
	@Id
	@Column(name = "augment_type")
	private String augmentType;
	
	@Column(name = "augment")
	private String augment;

}
