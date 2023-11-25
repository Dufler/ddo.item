package ddo.item.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="item_skippable")
public class ESkippableItem implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "name")
	private String name;

}
