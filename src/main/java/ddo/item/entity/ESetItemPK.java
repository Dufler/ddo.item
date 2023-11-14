package ddo.item.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;

import lombok.Data;

@Data
@Embeddable
public class ESetItemPK implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String set;
	private String item;

}
