package gui.classes;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import game.Player;
import game.PlayerClass;
import javafx.scene.layout.Border;

public class NewGameWindow extends GameWindow{

	static JFrame window;
	static JButton mageButton, warriorButton, thiefButton;
	static JPanel magePanel, warriorPanel, thiefPanel;
	static JPanel outputPanel;
	static JTextArea output;
	
	static PlayerClass playerClass;
	
	//static Player mage, warrior, thief;
	
	public NewGameWindow() {
		
		playerClass = new PlayerClass();
		/*
		mage = playerClass.Mage();
		warrior = playerClass.Warrior();
		thief = playerClass.Thief();
		*/
		
		window = new JFrame("New Game");
		window.setSize(WINDOW_DIM);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setBackground(backgroundColor);
		window.setLayout(null);
		
		
		Container con = window.getContentPane();
		JPanel windowBorder = new JPanel();
		windowBorder.setSize(WINDOW_DIM);
		//windowBorder.setBackground(backgroundColor);
		windowBorder.setOpaque(false);
		windowBorder.setBorder(thiccLineBorder);
		con.add(windowBorder);
		

		
		
		//panels to be affixed in container
		JPanel titleNamePanel = new JPanel();
		titleSetter(titleNamePanel, "New Game");
		con.add(titleNamePanel);
		
		
		magePanel = new JPanel();
		warriorPanel  = new JPanel();
		thiefPanel  = new JPanel();
		
		
		outputPanel = new JPanel();
		
		JPanel backButtonPanel = new JPanel();
		JPanel startButtonPanel = new JPanel();
		
		JLabel startLabel = new JLabel("Start");
		JLabel backLabel = new JLabel("Back");
		
		
		//buttons to be placed in panels
		mageButton = new JButton();
		warriorButton = new JButton();
		thiefButton = new JButton();
		
		JButton backButton = new JButton();
		JButton startButton = new JButton();
		
		
		
		playerSelectionAdder(con, magePanel, "M", mageButton, 1);
		playerSelectionAdder(con, warriorPanel, "W", warriorButton, 2);
		playerSelectionAdder(con, thiefPanel, "T", thiefButton, 3);
		
		
		
		addButtonListeners();
		
		
		
		int playerSelectionHeightBuffer = (int)(WINDOW_HEIGHT/3);
		int playerSelectionHeight = (int)(playerSelectionHeightBuffer/2);
		int outputBufferHeight = playerSelectionHeightBuffer + playerSelectionHeight + BUFFER;
		int outputWidth = WINDOW_WIDTH - (2 * BUFFER);
		int outputHeight = (int)(WINDOW_HEIGHT * .2 + 2 * BUFFER);
		
		outputPanel.setBounds(BUFFER, outputBufferHeight, outputWidth, outputHeight);
		outputPanel.setBackground(backgroundColor);
		outputPanel.setBorder(medLineBorder);
		output = new JTextArea();
	
		addOutputBox(outputPanel,output);
		
		
		con.add(outputPanel);
		
		
		
		
		
		window.setResizable(false);
		window.setVisible(true);
		
		
	}//end constructor
	
	private void playerSelectionAdder(Container con, JPanel panel, String labelText, JButton button, int position) {
		
		int playerSelectionHeightBuffer = (int)(WINDOW_HEIGHT/3);
		int playerSelectionHeight = (int)(playerSelectionHeightBuffer/2);
		int playerSelectionWidth = (int)(WINDOW_WIDTH / 7);
		int playerSelectionWidthBuffer = (int)(playerSelectionWidth * (2 * position - 1));

		
		panel.setBounds(playerSelectionWidthBuffer, playerSelectionHeightBuffer, playerSelectionWidth, playerSelectionHeight);
		Rectangle bounds = panel.getBounds();
		panel.setLayout(new GridBagLayout());
		panel.setBackground(textColor);
		
		JLabel label = new JLabel(labelText);
		label.setBounds(bounds);
		label.setForeground(backgroundColor);
		label.setFont(menuFont);
		label.setSize(panel.getSize());
		
		
		button.setBounds(bounds);
		
		
		panel.add(label);		
		
		con.add(panel);
		con.add(button);

	}//end main
	private void addButtonListeners() {
		mageButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				mageButtonPressed();
				
			}
			
		});
		
		warriorButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				warriorButtonPressed();
				
			}
			
		});
		
		thiefButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				thiefButtonPressed();
				
			}
			
		});
		
	}
	private void mageButtonPressed() {
		magePanel.setBackground(textColor.darker());
		warriorPanel.setBackground(textColor);
		thiefPanel.setBackground(textColor);
		
		playerClass.Mage();
		updateText();
	}
	
	private void warriorButtonPressed() {
		magePanel.setBackground(textColor);
		warriorPanel.setBackground(textColor.darker());
		thiefPanel.setBackground(textColor);
		
		playerClass.Warrior();
		updateText();
	}
	
	private void thiefButtonPressed() {
		magePanel.setBackground(textColor);
		warriorPanel.setBackground(textColor);
		thiefPanel.setBackground(textColor.darker());
		
		playerClass.Thief();
		updateText();
	}
	
	private void updateText() {
		output.setText(playerClass.getDesc());
	}
	
	
	private void addOutputBox(Container out, JTextArea box) {
			box.setOpaque(false);
			box.setForeground(textColor);
			box.setFont(gameFont);
			int margin = (int)(BUFFER/2);
			box.setSize(out.getWidth() - BUFFER ,out.getHeight());
			box.setEditable(false);
			box.setHighlighter(null);
			box.setLineWrap(true);
			box.setWrapStyleWord(true);
			
			box.setMargin(new Insets(margin,margin,margin, margin));

					
			String beginningText = 
					"It appears the snarling tendrils of this fantasy world have not yet ensnared you, weary traveler."
				  + "\n\nDo tell, what is your profession?";
			box.setText(beginningText);
			
			
			out.add(box);
		}
	
	
}//end NewGameWindow
