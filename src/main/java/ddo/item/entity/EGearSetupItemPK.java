package ddo.item.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;

import ddo.item.model.BodySlot;
import lombok.Data;

@Data
@Embeddable
public class EGearSetupItemPK implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Integer idSetup;
	private BodySlot slot;

}
