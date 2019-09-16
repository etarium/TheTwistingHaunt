package test.gameplay.newGame;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import db.api.DbAPI;
import gameplay.StatModMethods.PlayerStatMethods;
import gameplay.newGame.PlayerInitializer;

public class PlayerInitializerTest {
	
	@Mock
	DbAPI cellAPI = Mockito.mock(DbAPI.class);
	
	@Mock
	PlayerStatMethods statMethods = Mockito.mock(PlayerStatMethods.class);
	
	@InjectMocks
	PlayerInitializer init = new PlayerInitializer();

	@Before
	public void setUpPlayerPayload() {
		
	}
	
	@Test
	public void playerIsInitialized() {
		//given a player payload
		
		//the player object should not be null
		
		//the player should have defined armor types
		
		//the player should have defined weapon types
		
		//the player should have a statblock
		
		//the player's inventory should be empty
		
		//the player should have nothing equipped
		
		//the player should be level 1
		
		//the player should have no XP
		
		//the player should have a set of skills
	}
}
