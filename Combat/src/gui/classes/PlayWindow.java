package gui.classes;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

import java.io.*;

public class PlayWindow extends GameWindow{

	
	JFrame window;
	Container con;
	JPanel bounds;
	JPanel map, out, in;
	static JTextArea output;
	static JTextField input;

	
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
		
		window.setResizable(false);
		window.pack();
		window.setVisible(true);
		

		input.requestFocus();
		
		
		
	}//end PlayWindow initializer
	
	/*
	private void addMap(Container map,) {
		
	}
	*/
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
				
		
		
		//sample text
		/*
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
			*/
		
		
		//testing lineWrap
	
		
		
		  box.setText("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor "
		 
				+ "incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud "
				+ "exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure "
				+ "dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. "
				+ "Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt "
				+ "mollit anim id est laborum.");
		
			
		
		//intro text
		//box.setText(" placeholder text");
		
		
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
