package ddo.item.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="effect_alias")
public class EEffectAlias implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "effect")
	private String effect;
	
	@Column(name = "description")
	private String description;

}
