package pojos.entity;

import java.util.List;

import pojos.Skill;
import pojos.Statblock;
import pojos.entity.enums.EntityClassEnum;
import pojos.items.enums.ArmorType;
import pojos.items.enums.WeaponType;

public class EntityClassObject {
	EntityClassEnum name;
	String description;
	List<ArmorType> armorType;
	List<WeaponType> weaponType;
	List<Skill> skills;
	Statblock stats;
}
