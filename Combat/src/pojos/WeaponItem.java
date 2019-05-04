package pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import pojos.enums.WeaponType;
@JsonIgnoreProperties
public class WeaponItem extends Item {
	WeaponType weaponType;
	int numOfHands;
}
