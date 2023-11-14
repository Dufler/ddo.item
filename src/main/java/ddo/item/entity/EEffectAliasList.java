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
@Table(name="effect_alias_list")
@SequenceGenerator(name="effect_alias_list_sequence", initialValue = 1, allocationSize = 1)
public class EEffectAliasList {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO, generator="effect_alias_list_sequence")
	private Integer id;
	
	@Column(name = "effect_name")
	private String alias;
	
	@Column(name = "effect")
	private String effect;
	
	@Column(name = "effect_type")
	private String type;
	
	@Column(name = "effect_value")
	private Integer value;

}
