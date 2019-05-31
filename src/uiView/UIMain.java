package uiView;

import uiView.classes.CommandListener;

public class UIMain {

	public static void main (String [] args) {
		/* CellAPI apiCaller = new CellAPI();
		
		List<Cell> cells = apiCaller.getCellsFromInstance("Test Instance");
		cells.forEach(cell -> {
			System.out.println(cell.getDescription());
			System.out.println(cell.getInstance());
			System.out.println(cell.getTerrain());
			System.out.println(cell.getEnemies());
			System.out.println(cell.getLocation());
			System.out.println(cell.getItems());
		});
		*/
		CommandListener ear = new CommandListener();
	}
}
