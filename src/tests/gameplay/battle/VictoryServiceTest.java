package tests.gameplay.battle;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import gameplay.battle.VictoryService;
import pojos.entity.EnemyEntity;
import pojos.entity.Entity;
import tests.SetupStaticValues;
import uiView.UIMain;

public class VictoryServiceTest {

	VictoryService service = new VictoryService();

	int originalLevel;
	int originalXP;
	int originalSize;

	@Before
	public void setUp() {
		UIMain.player = SetupStaticValues.setUpPlayer();
		//this toggle is in a different service, so simulating data
		UIMain.player.setIsInEncounter(true);
		originalLevel = UIMain.player.getLevel();
		originalXP = UIMain.player.getXp();
		originalSize = 0;
	}

	@Test
	public void isVictoryYes() {
		//given that there are no enemies remaining in the cell
		boolean isVictory = service.isVictory();
		//then there should be victory
		assertTrue(isVictory);
	}

	@Test
	public void isVictoryNo() {
		//given that there are still enemies in the cell
		UIMain.player.currentCell.setEnemies(SetupStaticValues.setUpMultipleEnemies());
		boolean isVictory = service.isVictory();
		//then there is not victory
		assertFalse(isVictory);
	}

	@Test
	public void victoryProcessLevelUp() {
		//given that there was a victory
		//and the xp earned was sufficient
		service.trackXP(100,  2);
		service.victory();
		//then the player should be 1 level higher
		assertTrue(UIMain.player.getLevel() == originalLevel + 1);
		//and the player's total xp has increased
		assertTrue(UIMain.player.getXp() > originalXP);
		//and the player should no longer be in combat
		assertFalse(UIMain.player.isInEncounter);
	}

	@Test
	public void victoryProcessWithoutLevelUp() {
		//given that there was a victory
		//and the xp earned was insufficient
		service.trackXP(10,  2);
		service.victory();
		//then the player should be the same level
		assertTrue(UIMain.player.getLevel() == originalLevel);
		//and the player's total xp has increased
		assertTrue(UIMain.player.getXp() > originalXP);
		//and the player should no longer be in combat
		assertFalse(UIMain.player.isInEncounter);
	}

	@Test
	public void lastEnemyDefeated() {

		for(EnemyEntity enemy : SetupStaticValues.setUpMultipleEnemies()) {
			UIMain.player.currentCell.getEnemies().remove(enemy); 
		}
		UIMain.player.currentCell.setEnemies(SetupStaticValues.setUpOneEnemy());
		for(Entity enemy : UIMain.player.currentCell.getEnemies()) {
			UIMain.battleOrder.add(enemy);
		}
		EnemyEntity enemyToRemove = UIMain.player.currentCell.getEnemies().get(0);
		//given an enemy was defeated
		//and was the last enemy in the cell
		service.defeatedEnemy(enemyToRemove);
		//there should be zero enemies remaining
		assertTrue(UIMain.player.currentCell.getEnemies().size() == 0);
		//the player should not be in an encounter
		assertFalse(UIMain.player.isInEncounter);
	}

	@Test
	public void notLastEnemyDefeated() {
		UIMain.player.currentCell.setEnemies(SetupStaticValues.setUpMultipleEnemies());
		for(Entity enemy : UIMain.player.currentCell.getEnemies()) {
			UIMain.battleOrder.add(enemy);
		}
		originalSize = UIMain.battleOrder.size();
		EnemyEntity enemyToRemove = UIMain.player.currentCell.getEnemies().get(0);
		//given an enemy was defeated
		//but was not the last enemy in the cell
		service.defeatedEnemy(enemyToRemove);
		//there should be 1 less enemy in the battle rotation
		assertTrue(originalSize == UIMain.battleOrder.size() + 1);
		//the player should still be in an encounter
		assertTrue(UIMain.player.isInEncounter);
	}
}
