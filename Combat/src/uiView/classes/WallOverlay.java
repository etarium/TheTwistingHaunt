package uiView.classes;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

public class WallOverlay {

	//class members
	private boolean north;
	private boolean east;
	private boolean south;
	private boolean west;
	
	private int smallDim;
	private int bigDim;
	private int offset;
	
	private JPanel[] walls = new JPanel[4];
	private JPanel[] columns = new JPanel[4];
	
	
	//constructors
	public WallOverlay() {
		this.north = false;
		this.south = false;
		this.east = false;
		this.west = false;
		
		this.walls = null;
		
	}
	public WallOverlay(MapCell cell) {
		this.north = cell.getCell().isNorth();
		this.south = cell.getCell().isSouth();
		this.east = cell.getCell().isEast();
		this.west = cell.getCell().isWest();
		
		this.bigDim = cell.getCellPanel().getWidth();
		this.smallDim = bigDim /4;
		this.offset = bigDim - smallDim;
		
		this.buildWalls();
		this.createColumns();
	}
	
	//setters and getters
	
	public JPanel[] getWalls() {
		return walls;
	}
	
	public JPanel[] getColumns() {
		return columns;
	}
	
	
	//class methods
	public void buildWalls() {
		if(!north) {
			walls[0] = buildNorthWall();
		}
		if(!east) {
			walls[1] = buildEastWall();
		}
		if(!south) {
			walls[2] = buildSouthWall();
		}
		if(!west) {
			walls[3] = buildWestWall();
		}
	}
	
	private JPanel buildNorthWall() {
		
		int xBuffer = 0;
		int yBuffer = 0;
		int width = bigDim;
		int height = smallDim;
		
		JPanel wallPanel = this.createWall(xBuffer, yBuffer, width, height);
		return wallPanel;
	}
	
	private JPanel buildEastWall() {
		
		int xBuffer = offset;
		int yBuffer = 0;
		int width = smallDim;
		int height = bigDim;
		
		JPanel wallPanel = this.createWall(xBuffer, yBuffer, width, height);
		return wallPanel;
	}
	
	private JPanel buildSouthWall() {
		
		int xBuffer = 0;
		int yBuffer = offset;
		int width = bigDim;
		int height = smallDim;
		
		JPanel wallPanel = this.createWall(xBuffer, yBuffer, width, height);
		return wallPanel;
	}
	
	private JPanel buildWestWall() {
		
		int xBuffer = 0;
		int yBuffer = 0;
		int width = smallDim;
		int height = bigDim;
		
		JPanel wallPanel = this.createWall(xBuffer, yBuffer, width, height);
		return wallPanel;
	}
	
	
	
	private JPanel createWall(int x, int y, int width, int height) {
		JPanel temp = new JPanel();
		temp.setBounds(x, y, width, height);
		temp.setBackground(GameWindow.backgroundColor.brighter());
		temp.setPreferredSize(new Dimension(width, height));
		
		return temp;
	}
	
	private void createColumns() {
		JPanel column1, column2, column3, column4;
		
		column1 = new JPanel();
		column2 = new JPanel();
		column3 = new JPanel();
		column4 = new JPanel();
		
		column1.setBounds(0, 0, 0, 0);
		column2.setBounds(offset, 0, 0, 0);
		column3.setBounds(offset, offset, 0, 0);
		column4.setBounds(0, offset, 0, 0);
		
		JPanel[] columnList = {column1, column2, column3, column4};
		Dimension columnSize = new Dimension(smallDim, smallDim);
		
		for(JPanel column : columnList) {
			column.setBackground(GameWindow.backgroundColor);
			column.setSize(columnSize);
			column.setPreferredSize(columnSize);
		}
		
		this.columns = columnList;
	}
}//end class
