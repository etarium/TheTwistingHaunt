package gui.classes;

public class Navigator {

	//empty constructor
	public Navigator() {
		
	}
	
	public void goToCell() {
		
	}
	
	public boolean canGo(game.Cell target, char direction) {
		
		boolean available = false;
		
		switch(direction) {
		
		case 'n':
			available = target.isNorth();
			break;
			
		case 's':
			available = target.isSouth();
			break;
			
		case 'e':
			available = target.isEast();
			break;
			
		case 'w':
			available = target.isWest();
			break;
			
		default:
			System.out.println("Not implemented yet.");
		}//end switch
		
		return available;
	}
}