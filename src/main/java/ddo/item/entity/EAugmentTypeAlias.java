package ddo.item.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="augment_type_alias")
public class EAugmentTypeAlias implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "alias")
	private String alias;
	
	@Column(name = "augment_type")
	private String type;

}
