package game;

import java.util.Scanner;

public class SaveAndLoadTester {

	public static void main(String[] args) {
		PlayerClass pc = new PlayerClass();
		Player testPlayer = pc.Mage();
		
		System.out.println(testPlayer);
		System.out.println("\n\n");
		
		String savedTestFilename = PlayerSaveAndLoad.savePlayer(testPlayer, "test");
		
		System.out.println(savedTestFilename);
		
		
		//Scanner console = new Scanner(System.in);
		//System.out.print("Enter player object file: ");
		//String inputFile = console.next();
		System.out.println("\n\n");
		
		Player loadedPlayer = PlayerSaveAndLoad.loadPlayer("test");
		System.out.println(loadedPlayer);
		
	}
}
