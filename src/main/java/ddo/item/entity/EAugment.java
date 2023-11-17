package ddo.item.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="augment")
public class EAugment {
	
	@Id
	@Column(name = "name")
	private String name;
	
	@Column(name = "augment_type")
	private String type;
	
	@Column(name = "ml")
	private Integer minimumLevel;

}
