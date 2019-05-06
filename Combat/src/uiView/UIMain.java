package uiView;

import db.api.CellAPI;

public class UIMain {

	public static void main (String [] args) {
		System.out.println("Main");
		CellAPI apiCaller = new CellAPI();
		
		System.out.println(apiCaller.getCellsFromInstance("Test Instance"));
	}
}
