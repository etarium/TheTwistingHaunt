package gui.classes;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class NewGameWindow extends GameWindow{

	public NewGameWindow() {
		JFrame window = new JFrame("New Game");
		window.setSize(WINDOW_DIM);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setBackground(backgroundColor);
		window.setLayout(null);
		Container con = window.getContentPane();

		
		
		//panels to be affixed in container
		JPanel titleNamePanel = new JPanel();
		titleSetter(titleNamePanel, "New Game");
		con.add(titleNamePanel);
		
		JPanel playerHolderPanel = new JPanel();
		int playerSelectionWidthBuffer = (int)(WINDOW_HEIGHT/3);
		int playerSelectionHeight = (int)(playerSelectionWidthBuffer/2);
		
		
		playerHolderPanel.setBounds(0, playerSelectionWidthBuffer, WINDOW_WIDTH, playerSelectionHeight);
		playerHolderPanel.setBackground(textColor);
		playerHolderPanel.setLayout(null);
		con.add(playerHolderPanel);

		
		
		JPanel magePanel = new JPanel();
		JPanel warriorPanel  = new JPanel();
		JPanel thiefPanel  = new JPanel();
		
		
		int playerSelectionWidth = WINDOW_WIDTH / 7;
		magePanel.setBounds(playerSelectionWidth, playerSelectionWidthBuffer, playerSelectionWidth, playerSelectionHeight);
		magePanel.setBackground(Color.blue);
		magePanel.setLayout(null);
		playerHolderPanel.add(magePanel);
		

		
		
		playerHolderPanel.add(magePanel);
		playerHolderPanel.add(warriorPanel);
		playerHolderPanel.add(thiefPanel);
		
		
		
		JPanel outputPanel = new JPanel();
		
		JPanel backButtonPanel = new JPanel();
		JPanel startButtonPanel = new JPanel();
		
		
		//buttons to be placed in panels
		JButton mageButton = new JButton();
		JButton warriorButton = new JButton();
		JButton thiefButton = new JButton();
		
		JButton backButton = new JButton();
		JButton startButton = new JButton();
		
		

		
		
		window.setResizable(false);
		window.setVisible(true);
		
		
	}//end constructor
	
	
}
