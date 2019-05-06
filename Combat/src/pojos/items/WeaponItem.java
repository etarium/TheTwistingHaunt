package pojos.items;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import pojos.enums.Attribute;
import pojos.items.enums.WeaponHand;
import pojos.items.enums.WeaponType;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WeaponItem extends Item {
	Attribute attribute;
	WeaponType weaponType;
	List<WeaponHand> weaponHand;
	int numOfHands;
}
