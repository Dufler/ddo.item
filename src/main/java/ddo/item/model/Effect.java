package ddo.item.model;

import java.util.Objects;

import lombok.Data;

@Data
public class Effect {
	
	private String name;
	private String type;
	private Integer value;
	
	@Override
	public String toString() {
		String t = type != null ? type : "";
		String v = value != null ? value.toString() : "";
		return String.format("%s%s%s", t, name, v);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Effect other = (Effect) obj;
		return Objects.equals(name, other.name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name);
	}
	
}
