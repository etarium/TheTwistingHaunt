package pojos.items;

import java.util.List;

import pojos.enums.Attribute;
import pojos.items.enums.WeaponHand;
import pojos.items.enums.WeaponType;

public class WeaponItem extends Item {
	Attribute attribute;
	WeaponType weaponType;
	List<WeaponHand> weaponHand;
	int numOfHands;
	
	public Attribute getAttribute() {
		return attribute;
	}
	public void setAttribute(Attribute attribute) {
		this.attribute = attribute;
	}
	public WeaponType getWeaponType() {
		return weaponType;
	}
	public void setWeaponType(WeaponType weaponType) {
		this.weaponType = weaponType;
	}
	public List<WeaponHand> getWeaponHand() {
		return weaponHand;
	}
	public void setWeaponHand(List<WeaponHand> weaponHand) {
		this.weaponHand = weaponHand;
	}
	public int getNumOfHands() {
		return numOfHands;
	}
	public void setNumOfHands(int numOfHands) {
		this.numOfHands = numOfHands;
	}
	
	@Override
	public String toString() {
		return "WeaponItem [attribute=" + attribute + ", weaponType=" + weaponType + ", weaponHand=" + weaponHand
				+ ", numOfHands=" + numOfHands + ", name=" + name + ", type=" + type + ", description=" + description
				+ ", usedDescription=" + usedDescription + ", stats=" + stats + ", minLevel=" + minLevel + "]";
	}
	
}
