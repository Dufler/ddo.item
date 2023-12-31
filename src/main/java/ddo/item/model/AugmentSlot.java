package ddo.item.model;

import lombok.Data;

@Data
public class AugmentSlot {
	
	private final String item;
	private final String type;
	private Augment augment;
	
	public AugmentSlot(String item, String type) {
		this.item = item;
		this.type = type;
	}
	
	public AugmentSlot copy() {
		AugmentSlot as = new AugmentSlot(item, type);
		return as;
	}
	
	@Override
	public String toString() {
		String e;
		if (augment == null) {
			e = "Empty";
		} else {
			StringBuilder sb = new StringBuilder();
			for (Effect f : augment.getEffects()) {
				sb.append(f.toString());
				sb.append(", ");
			}
			if (sb.length() >= 2) {
				sb.delete(sb.length() - 2, sb.length());
			}
			e = sb.toString();
		}
		return String.format("%s: %s", type, e);
	}

}
