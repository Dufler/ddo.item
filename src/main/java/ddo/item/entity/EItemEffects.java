package ddo.item.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="item_effects")
@SequenceGenerator(name="item_effects_sequence", initialValue = 1, allocationSize = 1)
public class EItemEffects {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO, generator="item_effects_sequence")
	private Integer id;
	
	@Column(name = "item_id")
	private Integer itemId;
	
	@Column(name = "effect")
	private String effect;
	
	@Column(name = "effect_type")
	private String type;
	
	@Column(name = "effect_value")
	private Integer value;

}
