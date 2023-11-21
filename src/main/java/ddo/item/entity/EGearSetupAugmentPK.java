package ddo.item.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;

import lombok.Data;

@Data
@Embeddable
public class EGearSetupAugmentPK implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Integer idSetup;
	private String item;
	private String augmentType;

}
