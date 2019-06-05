package gameplay.commandServices;

import pojos.entity.PlayerEntity;

public class MovementService {
	
	PlayerEntity player;
	
	public MovementService(PlayerEntity player) {
		this.player = player;
	}

	public String movePlayer(char direction) {
		//TODO
		return "";
	}
	
	private boolean canMove(char direction) {
    	/*
		if(player.getCurrentCell(cellList).isNorth()) {
        player.getLocation().setY(player.getLocation().getY() + 1);
        output = cellList[player.getLocation().getX()][player.getLocation().getY()][player.getLocation().getZ()].getDesc();
    } */
		return false;
	}
}
