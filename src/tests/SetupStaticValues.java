package tests;

import java.util.ArrayList;
import java.util.List;

import pojos.Ability;
import pojos.Statblock;
import pojos.ability.enums.AbilityType;
import pojos.entity.EnemyEntity;
import pojos.entity.EntityClassObject;
import pojos.entity.PlayerEntity;
import pojos.entity.SpeciesObject;
import pojos.entity.enums.EntityClassEnum;
import pojos.environment.Cell;
import pojos.environment.InspectableObjects;
import pojos.environment.Location;
import pojos.items.Item;
import pojos.items.enums.ArmorMaterial;
import pojos.items.enums.WeaponType;

public class SetupStaticValues {

	//this file is used to instantiate the player, cell, and other static values that are persisted throughout the game.
	static Item item = new Item();
	static Item item2 = new Item();

	public static PlayerEntity setUpPlayer() {
		PlayerEntity player = new PlayerEntity();
		player.setName("Test Player");
		player.setCurrentCell(setUpActiveCell());
		player.setLocation(setUpActiveCell().getLocation());
		player.setStats(setUpStatblock());
		player.setSkills(setUpSkills());
		player.setLevel(1);
		player.setXpToNextLevel(50);
		player.setXp(0);
		player.setEntityClass(mockClass());
		player.setSpecies(mockSpecies());
		return player;
	}

	public static Cell setUpActiveCell() {
		item.setName("Test Item 1");
		item2.setName("Test Item 2");

		Cell newCell = new Cell();
		newCell.setLocation(new Location (0,1, 0));
		List<InspectableObjects> listInspectables = new ArrayList<InspectableObjects>();
		listInspectables.add(setUpRecentlyInspectedObject());
		newCell.setInspectableObjects(listInspectables);
		newCell.getItems().add(item);
		newCell.getItems().add(item2);
		newCell.setDescription("cell containing " + listInspectables);
		newCell.setNorth(true);
		newCell.setSouth(true);
		newCell.setEast(true);
		newCell.setWest(true);
		return newCell;
	}

	public static InspectableObjects setUpRecentlyInspectedObject() {
		item.setName("Test Item 1");
		item2.setName("Test Item 2");

		InspectableObjects recentlyOpenedObject = new InspectableObjects();
		recentlyOpenedObject = new InspectableObjects();
		recentlyOpenedObject.setName("Inspectable Object Test");
		recentlyOpenedObject.getItems().add(item);
		recentlyOpenedObject.getItems().add(item2);

		return recentlyOpenedObject;
	}

	public static List<Cell> setUpCells() {
		List<Cell> cells = new ArrayList<Cell>();
		Cell cell1 = setUpActiveCell();
		Cell cell2 = setUpActiveCell();
		Cell cell3 = setUpActiveCell();
		Cell cell4 = setUpActiveCell();
		Cell cell5 = setUpActiveCell();

		cell2.setLocation(new Location(1,1,0));
		cell2.setDescription("Second Cells Desc");
		cell3.setLocation(new Location(0,2,0));
		cell3.setDescription("Third Cells Desc");
		cell4.setLocation(new Location(0,0,0));
		cell4.setDescription("Fourth Cells Desc");
		cell5.setLocation(new Location(-1, 1, 0));
		cell5.setDescription("Fifth Cells Desc");
		cells.add(cell1);
		cells.add(cell2);
		cells.add(cell3);
		cells.add(cell4);
		cells.add(cell5);

		return cells;
	}

	public static List<EnemyEntity> setUpOneEnemy() {
		List<EnemyEntity> listOfEnemies = new ArrayList<EnemyEntity>();
		EnemyEntity enemy = new EnemyEntity();
		enemy.setName("Gormack");
		enemy.setStats(setUpStatblock());
		listOfEnemies.add(enemy);

		return listOfEnemies;
	}

	public static List<EnemyEntity> setUpMultipleEnemies() {
		List<EnemyEntity> listOfEnemies = new ArrayList<EnemyEntity>();
		EnemyEntity enemy = new EnemyEntity();
		enemy.setName("Gormack");
		enemy.setStats(setUpStatblock());
		listOfEnemies.add(enemy);
		enemy.setName("Romula");
		enemy.setStats(setUpStatblock());
		listOfEnemies.add(enemy);
		enemy.setName("Fortran 46");
		enemy.setStats(setUpStatblock());
		listOfEnemies.add(enemy);
		enemy.setName("Toranga Leela");
		enemy.setStats(setUpStatblock());
		listOfEnemies.add(enemy);
		return listOfEnemies;

	}
	
	public static List<Ability> setUpSkills() {
		//adds a skill of all 5 types, DAMAGE, HEAL, BUFF, DEBUFF, DRAIN
		List<Ability> listOfSkills = new ArrayList<Ability>();
		Ability attackAbility = new Ability();
		Ability debuffAbility = new Ability();
		Ability drainAbility = new Ability();
		Ability healAbility = new Ability();
		Ability buffAbility = new Ability();
		//0
		attackAbility.setName("Attack Spell");
		attackAbility.setType(AbilityType.DAMAGE);
		listOfSkills.add(attackAbility);
		//1
		debuffAbility.setName("Debuff Spell");
		debuffAbility.setType(AbilityType.DEBUFF);
		listOfSkills.add(debuffAbility);
		//2
		drainAbility.setName("Drain Spell");
		drainAbility.setType(AbilityType.DRAIN);
		listOfSkills.add(drainAbility);
		//3
		healAbility.setName("Heal Spell");
		healAbility.setType(AbilityType.HEAL);
		listOfSkills.add(healAbility);
		//4
		buffAbility.setName("Buff Spell");
		buffAbility.setType(AbilityType.BUFF);
		listOfSkills.add(buffAbility);
		return listOfSkills;
	}
	public static Statblock setUpStatblock() {
		Statblock stats = new Statblock();
		stats.setHp(10);
		stats.setSp(10);
		stats.setAcc(10);
		stats.setAgi(10);
		stats.setAtk(10);
		stats.setCha(10);
		stats.setCurrentHP(10);
		stats.setCurrentSP(10);
		stats.setDef(10);
		stats.setEva(10);
		stats.setSpatk(10);
		stats.setSpdef(10);
		stats.setSta(10);

		return stats;
	}
	
	public static EntityClassObject mockClass() {
		EntityClassObject mockClass = new EntityClassObject();
		mockClass.setName(EntityClassEnum.MAGE);
		mockClass.setStats(setUpStatblock());
		mockClass.setArmorType(new ArrayList<ArmorMaterial>());
		mockClass.setWeaponType(new ArrayList<WeaponType>());
		
		return mockClass;
	}
	
	public static SpeciesObject mockSpecies() {
		SpeciesObject species = new SpeciesObject();
		species.setName("HUMAN");
		species.setNumOfHands(2);
		species.setStats(setUpStatblock());
		return species;
	}
}
