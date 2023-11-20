package ddo.item.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="gear_setup")
@SequenceGenerator(name="gear_setup_sequence", initialValue = 1, allocationSize = 1)
public class EGearSetup implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO, generator="gear_setup_sequence")
	private Integer id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "last_saved")
	private Date lastSaved;
	
	@PrePersist
	@PreUpdate
	private void prePersist() {
		lastSaved = new Date();
		if (name == null) name = String.format("%d", lastSaved.getTime());
	}

}
