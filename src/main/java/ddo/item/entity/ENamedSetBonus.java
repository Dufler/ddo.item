package ddo.item.entity;

import java.io.Serializable;

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
@Table(name="named_set_bonus")
@SequenceGenerator(name="named_set_bonus_sequence", initialValue = 1, allocationSize = 1)
public class ENamedSetBonus implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO, generator="named_set_bonus_sequence")
	private Integer id;
	
	@Column(name = "set_name")
	private String set;
	
	@Column(name = "effect")
	private String effect;
	
	@Column(name = "effect_type")
	private String type;
	
	@Column(name = "effect_value")
	private Integer value;
	
}
