package ddo.item.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

import ddo.item.model.BodySlot;
import lombok.Data;

@Data
@Entity
@Table(name="gear_setup_item")
public class EGearSetupItem implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "id_setup")
	private Integer idSetup;
	
	@Id
	@Column(name = "slot")
	@Enumerated(EnumType.STRING)
	private BodySlot slot;

	@Column(name = "item")
	private String item;
	
}
