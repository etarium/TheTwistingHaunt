package gameplay.newGame;

import java.util.ArrayList;
import java.util.List;

import db.api.DbAPI;
import entity.EntityClassObject;
import entity.SpeciesObject;
import entity.enums.EntityClassEnum;
import entity.enums.SpeciesEnum;
import environment.Location;
import items.ArmorItem;
import items.WeaponItem;

public class NewPlayerPayload {

	private DbAPI dbApi = new DbAPI();
	
	String name = "";
	SpeciesEnum species;
	SpeciesObject speciesObject = new SpeciesObject();
	EntityClassObject className = new EntityClassObject();
	int level = 1;
	int xp = 0;
	int xpToNextLevel = 50;
	Location playerLocation = new Location(0, 1, 0);
	List<ArmorItem> equippedArmor = new ArrayList();
	List<WeaponItem> equippedWeapons = new ArrayList();
	
	
	
	public Location getPlayerLocation() {
		return playerLocation;
	}

	public void setPlayerLocation(Location playerLocation) {
		this.playerLocation = playerLocation;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public SpeciesObject getSpecies() {
		return speciesObject;
	}

	public void setSpecies(SpeciesEnum species) {
		this.species = species;
		speciesObject = dbApi.getSelectedSpecies(species);
	}

	public void setClassName(EntityClassEnum classEnum) {
		className = dbApi.getSelectedClass(classEnum);
	}
	
	public EntityClassObject getClassName() {
		return className;
	}
}
