package uiView.classes;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Insets;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import pojos.environment.Cell;

public class PlayWindow extends GameWindow{

	
	private static final boolean TESTING = true;
	JFrame window;
	Container con;
	JPanel bounds;
	JPanel mapArea, out, in;
	static JTextArea output;
	static JTextField input;
	
	private List<Cell> cellList;
	public MapCell[][] map;

	
	static boolean enterPressed = false;
	
	
	public PlayWindow() {
		
		window = new JFrame("The Twisting Haunt");
		window.setPreferredSize(SCREEN_DIM);
		window.setSize(SCREEN_DIM);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setLayout(null);
		window.setMaximumSize(window.getSize());
			
		
		con = window.getContentPane();
		con.setLayout(null);
		JPanel orig_bounds = new JPanel();
		orig_bounds.setBackground(backgroundColor);
		orig_bounds.setBounds(0,0, SCREEN_WIDTH, SCREEN_HEIGHT);
		orig_bounds.setBorder(thiccLineBorder);
		orig_bounds.setLayout(null);
		con.add(orig_bounds);
		
		JPanel bounds = new JPanel();
		int half_buffer = (int)(BUFFER / 2);
		bounds.setBounds(half_buffer, half_buffer, SCREEN_WIDTH - BUFFER, SCREEN_HEIGHT -  BUFFER - BUFFER);
		bounds.setBackground(backgroundColor);
		bounds.setBorder(thinLineBorder);
		bounds.setLayout(null);
		orig_bounds.add(bounds);
		
		int bounds_WIDTH = bounds.getWidth();
		int bounds_HEIGHT = bounds.getHeight();		

		mapArea = new JPanel();
		bounds.add(mapArea);

		int mapWidth = (int)(bounds_WIDTH * .75);
		int mapHeight = (int)(bounds_HEIGHT * .375);
		int mapBufferWidth = (int)((bounds_WIDTH - mapWidth)/2);
		int mapBufferHeight = 0;

		mapArea.setBounds(mapBufferWidth,mapBufferHeight, mapWidth, mapHeight);
		mapArea.setBackground(backgroundColor);
		mapArea.setBorder(thiccLineBorder);
		
		out = new JPanel();
		bounds.add(out);

		int outWidth = (int)(bounds_WIDTH * .875);
		int outHeight = (int)(bounds_HEIGHT * .5625);
		int outBufferWidth = (int)((bounds_WIDTH - outWidth)/2);
		int outBufferHeight = mapBufferHeight + mapHeight;

		out.setBounds(outBufferWidth,outBufferHeight,outWidth, outHeight);
		out.setPreferredSize(out.getSize());
		out.setBackground(backgroundColor);
		out.setBorder(medLineBorder);
		
		
		in = new JPanel();
		bounds.add(in);

		int inHeight = (int)(bounds_HEIGHT * .0625);
		int inBufferHeight = outBufferHeight + outHeight;

		in.setBounds(outBufferWidth,inBufferHeight,outWidth, inHeight);
		in.setBackground(backgroundColor);
		in.setBorder(medLineBorder);
		
		
		output = new JTextArea();
		input = new JTextField("Begin your quest by typing here, hero.");
		
		out.setLayout(new FlowLayout(FlowLayout.LEADING));
		in.setLayout(new FlowLayout(FlowLayout.LEADING));

		
		
		addOutputBox(out, output);
		addInputBox(in,input);
		
		window.setResizable(false);
		window.pack();
		window.setVisible(true);
		

		input.requestFocus();
		
	
		
	}//end PlayWindow initializer
	
	/*
	public void addMap() {
		
		if(!TESTING) {
		int cellSize = mapArea.getX() / 4;
		JPanel grid = generateGrid(cellSize);
		grid.setLayout(null);
		populateGrid(grid);
		mapArea.add(grid);
		}
		else {
			testMap();
		}
		
		window.pack();
		
	}
	
	
	public void setCellList(List<Cell> cells) {
		this.cellList = cells;
	}
	
	private void setMap(MapCell[][] map) {
		this.map = map;
	}
	
	public MapCell[][] getMap(){
		return this.map;
	}
	
	/* 
	 * private void testMap() {
	 *
		JFrame mapWindow = new JFrame("Map");
		
		int gridSize = cellList.length + 4;
		int cellSize = mapArea.getX()/4;
		int gridWidth = gridSize * cellSize;
		Dimension mapDim = new Dimension(gridWidth, gridWidth);
		
		mapWindow.setPreferredSize(mapDim);
		mapWindow.setSize(mapDim);
		mapWindow.setLayout(null);
		mapWindow.setMaximumSize(window.getSize());
		
		Container container = mapWindow.getContentPane();
		container.setLayout(null);
		
		JPanel grid = generateGrid(cellSize);
		grid.setLayout(null);
		container.add(grid);
		populateGrid(grid);
		
		mapWindow.pack();
		mapWindow.setVisible(true);
	}
	
	
	
	private JPanel generateGrid(int cellSize) {
		JPanel grid = new JPanel();
		
		int mapBufferWidth = 0;
		int mapBufferHeight = 0;
		
		int cellBuffer = 2;
		int gridSize = 2 * cellBuffer + cellList.length ;
		
		int gridWidth = gridSize * cellSize;
		Dimension gridDimension = new Dimension(gridWidth, gridWidth);
		
		grid.setBounds(mapBufferWidth, mapBufferHeight, gridWidth,gridWidth);
		grid.setPreferredSize(gridDimension);
		grid.setBackground(backgroundColor);
		grid.setLayout(new java.awt.GridBagLayout());
		//grid.setBorder(medLineBorder);
		
		setupMap(gridSize, cellSize, grid);
		
		return grid;
	}
	
	private void setupMap(int gridSize, int cellSize, JPanel grid) {
		
		MapCell[][] map = new MapCell[gridSize][gridSize];
		int cellBuffer = (gridSize - cellList.length) / 2;
		int mapBufferWidth = grid.getX();
		int mapBufferHeight = grid.getY();
		
		int mapMax = gridSize - (cellBuffer * 2);
		int tempMax = mapMax - 1;

		
		for(int i = 0; i < map.length; i ++) {
			for(int j = 0; j < map.length; j ++) {
				
				JPanel cellPanel = new JPanel();
				cellPanel.setBounds(mapBufferWidth + (j * cellSize) , mapBufferHeight + (i * cellSize) , cellSize, cellSize);
				cellPanel.setBackground(backgroundColor);
				cellPanel.setBorder(thinLineBorder);
				cellPanel.setPreferredSize(new Dimension(cellSize,cellSize));
				cellPanel.setLayout(null);
				
				map[j][i] = new MapCell(cellPanel);
				
				int cellY = j - cellBuffer;
				int cellX = i - cellBuffer;
				
				
				if(cellY >= 0 && cellY < mapMax) {
					if(cellX >= 0 && cellX < mapMax) {
						
						pojos.environment.Cell presentCell = cellList[cellY][tempMax - cellX][0];
						map[j][i].setCell(presentCell);
						map[j][i].getCellPanel().setBorder(thinLineBorder);
					}
				}
				
			}
		}
		
		this.setMap(map);
	}
	
	*/
//
//	private void populateGrid(Container grid) {
//		
//		for(MapCell[] row : map) {
//			for(MapCell cell : row) {
//				/* TESTING outlines cells in map that aren't null */
//				if(cell.getCell() != null) {
//					cell.getCellPanel().setBackground(textColor.brighter());
//				}
//				
//				grid.add(cell.getCellPanel());
//			}
//		}
//	}

	
	
	private void addOutputBox(Container out, JTextArea box) {
		box.setOpaque(false);
		box.setForeground(textColor);
		box.setFont(gameFont);
		int margin = BUFFER/2 + MED;
		box.setSize(out.getWidth() - BUFFER, out.getHeight());
		box.setMargin(new Insets(margin,margin,margin, margin));
		box.setEditable(false);
		box.setHighlighter(null);
		box.setLineWrap(true);
		box.setWrapStyleWord(true);
				
	
		
		//initial text while database is loading
		box.setText("A group of scared villagers begged for your help. They circled you, crying about "
		  		+ "their deceased. Scared of their deceased -- It seems that this cave you're now in front "
		  		+ "of is home to the undead. The villagers called the evil lurking within 'The Overlord'. "
		  		+ "You had also heard of it as the 'Blue Lich' before. Truly, a "
		  		+ "fearsome beast lies ahead...");
		
		out.add(box);
	}
	
	private void addInputBox(Container in, JTextField box) {
		box.setOpaque(false);
		box.setBorder(null);
		box.setForeground(textColor);
		box.setFont(gameFont);
		box.setHighlighter(null);
		box.setPreferredSize(in.getSize());
		
		
		box.setFocusTraversalKeysEnabled(false);
		box.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == e.VK_ENTER) {
					enterPressed = true;
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}});
		
		
		in.add(box);
	}
	
	public JTextArea getOutputBox() {
		return output;
	}
	
	public JTextField getInputBox() {
		return input;
	}
	
	public void outGUI(String outputString) {
		JTextArea outputBox = getOutputBox();
		outputBox.setText(outputString);
	}
	
	
	public String inGUI() {
		JTextField inputBox = getInputBox();
		String response = inputBox.getText();
		inputBox.setText("");
		
		return response;
	}
	
	public String requestInput() {
		while(!enterPressed) {
			try {
				Thread.sleep(300);       
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		enterPressed = false;
		return inGUI();
		
	}
	
	public void exitGame() {
		window.dispose();
	}
	
}//end class
