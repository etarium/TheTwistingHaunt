package pojos.items;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import pojos.items.enums.ArmorMaterial;
import pojos.items.enums.ArmorType;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ArmorItem extends Item {
	ArmorType armorType;
	ArmorMaterial armorMaterial;
	
}
