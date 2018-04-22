package game;

//import java.util.Scanner;

public class SaveAndLoadTester {

	public static void main(String[] args) {
		PlayerClass pc = new PlayerClass();
		Player testPlayer = pc.Mage();
		
		fleshOutTestPlayer(testPlayer);
	
		
		//System.out.println(testPlayer);
		//System.out.println("\n\n");
		
		String savedTestFilename = PlayerSaveAndLoad.savePlayer(testPlayer, "test");
		
		//System.out.println(savedTestFilename);
		
		
		//Scanner console = new Scanner(System.in);
		//System.out.print("Enter player object file: ");
		//String inputFile = console.next();
		//System.out.println("\n\n");
		
		Player loadedPlayer = PlayerSaveAndLoad.loadPlayer("test");
		System.out.println(loadedPlayer);
		System.out.println(loadedPlayer.getItemList());
		System.out.println(loadedPlayer.getKeyItemsList());
		System.out.println(loadedPlayer.getWornArmor());
		System.out.println(loadedPlayer.getUsedWeapon());
		System.out.println(loadedPlayer.getSpecAttackList());
		
	}
	
	
	private static void fleshOutTestPlayer(Player testPlayer) {
		//TEST ADDING ITEMS 
		Usable_SingleTarget_HP potion = new Usable_SingleTarget_HP(50, "Potion");
		potion.setDescription("This potion heals " + Math.abs(potion.getPotency()) + " HP");
		testPlayer.getItemList().add(potion);

		Usable_SingleTarget_HP dart = new Usable_SingleTarget_HP(-25, "Throwing Dart");
		dart.setDescription("This throwing dart hits for  " + Math.abs(dart.getPotency()) + " HP");
		testPlayer.getItemList().add(dart);

		Usable_MultiTarget_HP grenade = new Usable_MultiTarget_HP(-75, "Grenade");
		grenade.setDescription("This grenade blasts everyone for  " + Math.abs(grenade.getPotency()) + " HP");
		testPlayer.getItemList().add(grenade);

		//TEST ADDING SPEC_ATTACKS
		SpecAttack_MultiTarget_HP fireball = new SpecAttack_MultiTarget_HP(-75, "Fireball");
		fireball.setDescription("This Fireball blasts everyone for  " + Math.abs(fireball.getPotency()) + " HP");
		testPlayer.getSpecAttackList().add(fireball);

		Equipable_Weapon axe = new Equipable_Weapon(15, "Axe");
		Equipable_Armor shield = new Equipable_Armor(15, "Shield");
		testPlayer.setUsedWeapon(axe);
		testPlayer.setWornArmor(shield);



		KeyItems testKeyItem = new KeyItems("testName", "testDesc", "testID");
		testPlayer.getKeyItemsList().add(testKeyItem);


		//TEST
	}
}
