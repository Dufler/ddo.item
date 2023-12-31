package ddo.item.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="augment")
public class EAugment implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "name")
	private String name;
	
	@Column(name = "augment_type")
	private String type;
	
	@Column(name = "ml")
	private Integer minimumLevel;

}
