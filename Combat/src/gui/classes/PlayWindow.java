package gui.classes;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

public class PlayWindow extends GameWindow{

	
	

	protected float gameFontSize = 0.5625f * SCREEN_WIDTH / 50;
	protected Font gameFont = defaultFont.deriveFont(gameFontSize);


	

	
	
	
	JFrame window;
	Container con;
	JPanel bounds;
	JPanel map, out, in;
	static JTextArea output;
	//static JTextPane output;
	static JTextField input;
	//how the fuck even am I going to do the map???
	
	
	
	public PlayWindow() {
		/*
		System.out.println("SCREEN : " + SCREEN_WIDTH + "," + SCREEN_HEIGHT);
		System.out.println("WINDOW : " + WINDOW_WIDTH + "," + WINDOW_HEIGHT);
		System.out.println("Width Ratio: " + (double)WINDOW_WIDTH/SCREEN_WIDTH);
		System.out.println("Height Ratio: " + (double)WINDOW_HEIGHT/SCREEN_HEIGHT);
		*/

		
		window = new JFrame("The Twisted Haunt");
		window.setPreferredSize(SCREEN_DIM);
		window.setSize(SCREEN_DIM);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setLayout(null);
		
		
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
		
		
		
		
		map = new JPanel();
		bounds.add(map);

		int mapWidth = (int)(bounds_WIDTH * .75);
		int mapHeight = (int)(bounds_HEIGHT * .375);
		int mapBufferWidth = (int)((bounds_WIDTH - mapWidth)/2);
		int mapBufferHeight = 0;

		map.setBounds(mapBufferWidth,mapBufferHeight, mapWidth, mapHeight);
		map.setBackground(backgroundColor);
		map.setBorder(thiccLineBorder);
		
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
		//output = new JTextPane();
		input = new JTextField("Begin your quest by typing here, hero.");
		
		out.setLayout(new FlowLayout(FlowLayout.LEADING));
		in.setLayout(new FlowLayout(FlowLayout.LEADING));

		
		
		addOutputBox(out, output);
		addInputBox(in,input);
		
		
		
		
		
		window.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				input.requestFocus();
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			

			
		});
		
		
		
		
		window.pack();
		//input.requestFocus();
		window.setVisible(true);
		
		
		
	}//end PlayWindow initializer
	
	/*
	private void addMap(Container map,) {
		
	}
	*/
	private void addOutputBox(Container out, JTextArea box) {
	//private void addOutputBox(Container out, JTextPane box) {
		box.setOpaque(false);
		box.setForeground(textColor);
		box.setFont(gameFont);
		int margin = BUFFER/2;
		box.setSize(out.getSize());
		box.setMaximumSize(out.getSize());
		box.setMargin(new Insets(margin,margin,margin, margin));
		box.setEditable(false);
		box.setHighlighter(null);
		box.setLineWrap(true);
		box.setWrapStyleWord(true);
				
		
		
		//sample text
		box.setText("Márgarét, áre you gríeving \n" + 
				"Over Goldengrove unleaving? \n" + 
				"Leáves like the things of man, you\n" + 
				"With your fresh thoughts care for, can you? \n" + 
				"Ah! ás the heart grows older \n" + 
				"It will come to such sights colder \n" + 
				"By and by, nor spare a sigh \n" + 
				"Though worlds of wanwood leafmeal lie; \n" + 
				"And yet you wíll weep and know why. \n" + 
				"Now no matter, child, the name: \n" + 
				"Sórrow’s spríngs áre the same. \n" + 
				"Nor mouth had, no nor mind, expressed \n" + 
				"What heart heard of, ghost guessed: \n" + 
				"It ís the blight man was born for, \n" + 
				"It is Margaret you mourn for.");
		
		
		//testing lineWrap
		/*
		box.setText("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor "
				+ "incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud "
				+ "exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure "
				+ "dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. "
				+ "Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt "
				+ "mollit anim id est laborum.");
		*/
		
		
		out.add(box);
	}
	
	private void addInputBox(Container in, JTextField box) {
		//in.setLayout(new GridBagLayout());
		box.setOpaque(false);
		box.setBorder(null);
		box.setForeground(textColor);
		box.setFont(gameFont);
		box.setHighlighter(null);
		box.setPreferredSize(in.getSize());
		
		
		
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
	
	public void exitGame() {
		window.dispose();
	}
	
	
}//end class
