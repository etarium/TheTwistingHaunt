package game;

public class PlayerClass {

	protected String desc = "";
	protected String name = "";
	protected StatBlock selectClass = new StatBlock();
	protected String teamId = "0";
	
	public PlayerClass()
	{
	//empty constructor	
	}
	
	public Player Mage()
	{
		name = "Mage";
		desc = "A skilled caster. Fast and versatile. Wandering the countryside with a worn staff,"
				+ " the Mage is a force to be reckoned with.";
		selectClass = new StatBlock(80, 80, 80, 25, 20, 20, 40, 80);
		Player player = new Player(selectClass, name, desc, teamId );
   		
   		return player;
	}
	
	public Player Warrior()
	{
		selectClass = new StatBlock(120, 120, 20, 40, 10, 60, 30, 20);
		name = "Warrior";
		desc = "Armed with a quality blade and exceptional courage, the Warrior is ready to charge headfirst toward any quest.";
   		Player player = new Player(selectClass, name, desc, teamId );
   		
   		return player;
	}
	
	public Player Thief()
	{
		selectClass = new StatBlock(100, 100, 20, 20, 45, 40, 50, 20);
		name = "Thief";
		desc = "From the shadows the Thief watches. He works efficiently, making quick work of any task before him.";
   		Player player = new Player(selectClass, name, desc, teamId );
   		
   		return player;
	}
	
}
