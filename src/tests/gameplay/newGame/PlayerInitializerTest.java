package tests.gameplay.newGame;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import db.api.DbAPI;
import gameplay.StatModMethods.PlayerStatMethods;
import gameplay.newGame.NewPlayerPayload;
import gameplay.newGame.PlayerInitializer;
import entity.enums.EntityClassEnum;
import entity.enums.SpeciesEnum;
import environment.Location;
import tests.SetupStaticValues;
import uiView.UIMain;

public class PlayerInitializerTest {

	@Mock
	DbAPI cellAPI = Mockito.mock(DbAPI.class);

	@Mock
	PlayerStatMethods statMethods = Mockito.mock(PlayerStatMethods.class);
	@InjectMocks
	NewPlayerPayload payload = new NewPlayerPayload();
	
	@InjectMocks
	PlayerInitializer init = new PlayerInitializer();

	@Before
	public void setUpPlayerPayload() {
		//mock the database call for cells
		Mockito.when(cellAPI.getCellsFromInstance("Test Instance")).thenReturn(SetupStaticValues.setUpCells());

		//mock the database call for the class
		Mockito.when(cellAPI.getSelectedClass(EntityClassEnum.MAGE)).thenReturn(SetupStaticValues.mockClass());
		
		//mock the database call for the species
		Mockito.when(cellAPI.getSelectedSpecies(SpeciesEnum.HUMAN)).thenReturn(SetupStaticValues.mockSpecies());
		//mock the stat method calculations
		Mockito.when(statMethods.calculateBaseStats()).thenReturn(SetupStaticValues.setUpStatblock());

		//make a player payload
		payload.setName("Test Player");
		payload.setSpecies(SpeciesEnum.HUMAN);
		payload.setClassName(EntityClassEnum.MAGE);
		payload.setPlayerLocation(new Location(0,1,0));
	}

	@Test
	public void playerIsInitialized() {
		//given a player payload, and that it is a new game
		UIMain.player = init.initializePlayer(true, payload);
		//the player object should not be null
		assertNotNull(UIMain.player);

		//the player should have defined armor types
		assertNotNull(UIMain.player.getArmorType());

		//the player should have defined weapon types
		assertNotNull(UIMain.player.getWeaponType());

		//the player should have a set of skills
		assertNotNull(UIMain.player.getSkills());

		//the player should have a statblock
		assertNotNull(UIMain.player.getStats());

		//the player's inventory should be empty
		assertTrue(UIMain.player.getInventory().size() == 0);

		//the player should have nothing equipped
		assertTrue(UIMain.player.getEquippedArmor().size() == 0);

		//the player should be level 1
		assertTrue(UIMain.player.getLevel() == 1);

		//the player should have zero XP
		assertTrue(UIMain.player.getXp() == 0);

	}
}
