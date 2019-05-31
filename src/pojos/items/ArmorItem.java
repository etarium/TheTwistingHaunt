package pojos.items;

import pojos.items.enums.ArmorMaterial;
import pojos.items.enums.ArmorType;

public class ArmorItem extends Item {
	ArmorType armorType;
	ArmorMaterial armorMaterial;
	
	public ArmorType getArmorType() {
		return armorType;
	}
	public void setArmorType(ArmorType armorType) {
		this.armorType = armorType;
	}
	public ArmorMaterial getArmorMaterial() {
		return armorMaterial;
	}
	public void setArmorMaterial(ArmorMaterial armorMaterial) {
		this.armorMaterial = armorMaterial;
	}
	
	@Override
	public String toString() {
		return "ArmorItem [armorType=" + armorType + ", armorMaterial=" + armorMaterial + ", name=" + name + ", type="
				+ type + ", description=" + description + ", usedDescription=" + usedDescription + ", stats=" + stats
				+ ", minLevel=" + minLevel + "]";
	}
	
}
