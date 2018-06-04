package gui.classes;

import javax.swing.*;

import game.Location;

import java.awt.*;

public class MapCell{
	
	private JPanel cellPanel;
	private game.Cell cell;
	private final int CELL_BUFFER = 2;
	private final int MAP_HEIGHT = 9;
	private WallOverlay walls;
	
	 
	
	
	//constructors
	public MapCell() {
		this.cellPanel = new JPanel();
		this.cell = new game.Cell();
	}
	
	public MapCell(JPanel cellPanel) {
		this.cellPanel = cellPanel;
		this.cell = null;
	}
	
	public MapCell(game.Cell cell) {
		this.cell = cell;
		this.cellPanel = new JPanel();
	}
	
	public MapCell(JPanel cellPanel, game.Cell cell) {
		this.cellPanel = cellPanel;
		this.cell= cell;
	}

	
	//setters and getters
	public JPanel getCellPanel() {
		return cellPanel;
	}

	public void setCellPanel(JPanel cellPanel) {
		this.cellPanel = cellPanel;
	}

	public game.Cell getCell() {
		return cell;
	}

	public void setCell(game.Cell cell) {
		this.cell = cell;
	}
	
	public void setWallOverlay() {
		this.walls = new WallOverlay(this);
	}
	
	public WallOverlay getWalls() {
		return walls;
	}
	
	
	
	
	//class methods

	public void highlightCurrentPosition(MapCell currentMapCell) {
		currentMapCell.getCellPanel().setBackground(Color.YELLOW);
		currentMapCell.setWallOverlay();
		currentMapCell.paintWalls();
		currentMapCell.getCellPanel().setBorder(GameWindow.thinLineBorder);
	}
	
	public void unHighlightPreviousPosition(MapCell previousCell) {
		previousCell.getCellPanel().setBackground(GameWindow.textColor.brighter());
	}
	
	public void discoverCells(MapCell currentMapCell, MapCell[][] map) {
		game.Cell currentCell = currentMapCell.getCell();
		
		MapCell cellNorth = null,cellSouth = null,cellWest = null, cellEast = null;
		
		
		if(currentCell.isNorth()) {
			cellNorth = this.getNorthCell(currentMapCell, map);
		}
		if(currentCell.isEast()) {
			cellEast = this.getEastCell(currentMapCell, map);
		}
		if(currentCell.isSouth()) {
			cellSouth = this.getSouthCell(currentMapCell, map);
		}
		if(currentCell.isWest()) {
			cellWest = this.getWestCell(currentMapCell, map);
		}
		
		MapCell[] cellArray = new MapCell[] {cellNorth, cellSouth, cellWest, cellEast};
		
		for(MapCell temp : cellArray) {
			if(temp != null) {
				unHighlightPreviousPosition(temp);
			}
		}
		
	}
	public void updateMap(game.Player player, MapCell[][] map) {
		MapCell currentMapCell = getPlayersMapCell(player, map);
		
		this.discoverCells(currentMapCell, map);
		this.highlightCurrentPosition(currentMapCell);
	}
	private MapCell getPlayersMapCell(game.Player player, MapCell[][] map) {
		Location loc = player.getLocation();
		
		//initial should be [0][3]
		int x = this.getMapCellX(loc);
		int y = this.getMapCellY(loc);
		//int z = location.getZ();
		
		//initial should be [2][8]
		MapCell playersCell = map[x][y];
		
		return playersCell;
	}
	
	private MapCell getNorthCell(MapCell currentMapCell, MapCell[][] map) {
		game.Cell currentCell = currentMapCell.getCell();
		
		Location loc = currentCell.getLocation();
		
		int x = this.getMapCellX(loc);
		int y = this.getMapCellY(loc) - 1;
		
		MapCell newCell = map[x][y];
		return newCell;
		
	}
	private MapCell getEastCell(MapCell currentMapCell, MapCell[][] map) {
		game.Cell currentCell = currentMapCell.getCell();
		
		Location loc = currentCell.getLocation();
		
		int x = this.getMapCellX(loc) + 1;
		int y = this.getMapCellY(loc);
		
		MapCell newCell = map[x][y];
		return newCell;
		
	}
	private MapCell getSouthCell(MapCell currentMapCell, MapCell[][] map) {
		game.Cell currentCell = currentMapCell.getCell();
		
		Location loc = currentCell.getLocation();
		
		int x = this.getMapCellX(loc);
		int y = this.getMapCellY(loc) + 1;
		
		MapCell newCell = map[x][y];
		return newCell;
		
	}
	private MapCell getWestCell(MapCell currentMapCell, MapCell[][] map) {
		game.Cell currentCell = currentMapCell.getCell();
		
		Location loc = currentCell.getLocation();
		
		int x = this.getMapCellX(loc) - 1;
		int y = this.getMapCellY(loc);
		
		MapCell newCell = map[x][y];
		return newCell;
		
	}
	
	private void paintWalls() {
			for (JPanel wall : this.walls.getWalls()) {
				if(wall != null) {
					this.cellPanel.add(wall);
				}
			}
			
			for(JPanel column : this.walls.getColumns()) {
				if(column != null) {
					this.cellPanel.add(column);
				}
			}
	}
	
	private int getMapCellX(Location loc) {
		return loc.getX() + CELL_BUFFER;
	}
	
	private int getMapCellY(Location loc) {
		return (MAP_HEIGHT - loc.getY()) + CELL_BUFFER;
	}
	

}
