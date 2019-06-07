package uiView.classes;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Insets;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import uiView.UIMain;

public class PlayWindow extends GameWindow{

	
	static JFrame window;
	Container con;
	JPanel bounds;
	JPanel upOut, out, in;
	static JTextArea upperOutput;
	static JTextArea lowerOutput;
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

		upOut = new JPanel();
		bounds.add(upOut);

		int upperOutWidth = (int)(bounds_WIDTH * .75);
		int upperOutHeight = (int)(bounds_HEIGHT * .375);
		int upperOutBufferWidth = (int)((bounds_WIDTH - upperOutWidth)/2);
		int upperOutBufferHeight = 0;

		upOut.setBounds(upperOutBufferWidth,upperOutBufferHeight, upperOutWidth, upperOutHeight);
		upOut.setBackground(backgroundColor);
		upOut.setBorder(thiccLineBorder);
		
		out = new JPanel();
		bounds.add(out);

		int outWidth = (int)(bounds_WIDTH * .875);
		int outHeight = (int)(bounds_HEIGHT * .5625);
		int outBufferWidth = (int)((bounds_WIDTH - outWidth)/2);
		int outBufferHeight = upperOutBufferHeight + upperOutHeight;

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
		
		upperOutput = new JTextArea();
		lowerOutput = new JTextArea();
		input = new JTextField("Begin your quest by typing here, hero.");
		
		upOut.setLayout(new FlowLayout(FlowLayout.LEADING));
		out.setLayout(new FlowLayout(FlowLayout.LEADING));
		in.setLayout(new FlowLayout(FlowLayout.LEADING));

		addUpperOutputBox(upOut, upperOutput);
		addOutputBox(out, lowerOutput);
		addInputBox(in,input);
		
		window.setResizable(false);
		window.pack();
		window.setVisible(true);
		

		input.requestFocus();
		
	
		
	}//end PlayWindow initializer

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
		  		+ "of is home to the undead. The villagers cried about the evil lurking within. "
		  		+ "You had heard of it as the 'Blue Lich' before. Truly, a "
		  		+ "fearsome beast lies ahead...");
		
		out.add(box);
	}
	
	private void addUpperOutputBox(Container out, JTextArea box) {
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
		while(UIMain.player.currentCell == null) {
			box.setText("Database loading...");
		}
		box.setText(UIMain.player.currentCell.getDescription());
		
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
	
	public JTextArea getUpperOutputBox() {
		return upperOutput;
	}
	
	public JTextArea getOutputBox() {
		return lowerOutput;
	}
	
	public JTextField getInputBox() {
		return input;
	}
	
	public void outGUI(String outputString) {
		JTextArea outputBox = getOutputBox();
		outputBox.setText(outputString);
	}
	
	public void outTopGUI(String upperOutputString) {
		JTextArea upperOutputBox = getUpperOutputBox();
		upperOutputBox.setText(upperOutputString);
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
