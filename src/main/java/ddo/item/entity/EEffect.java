package ddo.item.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

import ddo.item.model.EffectType;
import lombok.Data;

@Data
@Entity
//@Immutable // Per le view
@Table(name="effect")
public class EEffect implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "effect")
	private String effect;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "effect_type")
	@Enumerated(EnumType.STRING)
	private EffectType type;

}
