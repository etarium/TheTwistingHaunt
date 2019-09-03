package pojos.entity;

import java.util.List;
import java.util.Map;

import pojos.Quest;
import pojos.Ability;
import pojos.Statblock;
import pojos.entity.enums.Faction;
import pojos.environment.Cell;
import pojos.environment.Location;
import pojos.items.ArmorItem;
import pojos.items.WeaponItem;
import pojos.items.enums.ArmorMaterial;
import pojos.items.enums.WeaponType;

public class PlayerEntity extends Entity{
	
	EntityClassObject entityClass;
	SpeciesObject speciesObject = new SpeciesObject();
	int numOfHands;
	List<ArmorMaterial> armorType;
	List<WeaponType> weaponType;
	List<Ability> skills;
	List<Quest> quests;
	List<ArmorItem> equippedArmor;
	List<WeaponItem> equippedWeapons;
	Map<Faction, Integer> factionLevel;
	int xp;
	int xpToNextLevel;
	Location location;
	public Cell currentCell;
	public boolean isInEncounter = false;
	
	
	public SpeciesObject getSpeciesObject() {
		return speciesObject;
	}
	
	public void setSpecies(SpeciesObject speciesObject) {
		this.speciesObject = speciesObject;
	}
	
	public Location getLocation() {
		return location;
	}
	
	public void setLocation(Location location) {
		this.location = location;
	}
	
	public EntityClassObject getEntityClass() {
		return entityClass;
	}
	
	public void setEntityClass(EntityClassObject entityClass) {
		this.entityClass = entityClass;
	}
	
	public int getNumOfHands() {
		return numOfHands;
	}
	
	public void setNumOfHands(int numOfHands) {
		this.numOfHands = numOfHands;
	}
	
	public List<ArmorMaterial> getArmorType() {
		return armorType;
	}
	
	public void setArmorType(List<ArmorMaterial> list) {
		this.armorType = list;
	}
	
	public List<WeaponType> getWeaponType() {
		return weaponType;
	}
	
	public void setWeaponType(List<WeaponType> weaponType) {
		this.weaponType = weaponType;
	}
	
	public List<Ability> getSkills() {
		return skills;
	}
	
	public void setSkills(List<Ability> skills) {
		this.skills = skills;
	}
	
	public List<Quest> getQuests() {
		return quests;
	}
	
	public void setQuests(List<Quest> quests) {
		this.quests = quests;
	}
	
	public List<ArmorItem> getEquippedArmor() {
		return equippedArmor;
	}
	
	public void setEquippedArmor(List<ArmorItem> equippedArmor) {
		this.equippedArmor = equippedArmor;
	}
	
	public List<WeaponItem> getEquippedWeapons() {
		return equippedWeapons;
	}
	
	public void setEquippedWeapons(List<WeaponItem> equippedWeapons) {
		this.equippedWeapons = equippedWeapons;
	}
	
	public Map<Faction, Integer> getFactionLevel() {
		return factionLevel;
	}
	
	public void setFactionLevel(Map<Faction, Integer> factionLevel) {
		this.factionLevel = factionLevel;
	}
	
	public int getXp() {
		return xp;
	}
	
	public void setXp(int xp) {
		this.xp = xp;
	}
	
	public int getXpToNextLevel() {
		return xpToNextLevel;
	}
	
	public void setXpToNextLevel(int xpToNextLevel) {
		this.xpToNextLevel = xpToNextLevel;
	}
	
	public Cell getCurrentCell() {
		return currentCell;
	}
	
	public void setCurrentCell(Cell currentCell) {
		this.currentCell = currentCell;
	}
	
	public void setIsInEncounter(boolean isInEncounter) {
		this.isInEncounter = isInEncounter;
	}
	
	@Override
	public String toString() {
		return "PlayerEntity [entityClass=" + entityClass + ", speciesObject=" + speciesObject + ", numOfHands="
				+ numOfHands + ", stats=" + stats + ", armorType=" + armorType + ", weaponType=" + weaponType
				+ ", skills=" + skills + ", quests=" + quests + ", equippedArmor=" + equippedArmor
				+ ", equippedWeapons=" + equippedWeapons + ", factionLevel=" + factionLevel + ", xp=" + xp
				+ ", xpToNextLevel=" + xpToNextLevel + ", location=" + location + ", currentCell=" + currentCell
				+ ", isInEncounter=" + isInEncounter + ", name=" + name + ", description=" + description
				+ ", temperament=" + temperament + ", species=" + species + ", inventory=" + inventory + ", level="
				+ level + "]";
	}
}