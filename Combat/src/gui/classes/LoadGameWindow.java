package gui.classes;

import java.awt.Container;
import java.awt.GridBagLayout;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import game.PlayerSaveAndLoad;

public class LoadGameWindow extends GameWindow{

	static JFrame window;
	static JScrollPane loadListScroller;
	static ArrayList<String> saveGameList = new ArrayList<>();;
	
	public LoadGameWindow() {
		window = new JFrame("Load Game");
		window.setSize(WINDOW_DIM);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setBackground(backgroundColor);
		window.setLayout(null);
		
		
		Container con = window.getContentPane();
		JPanel windowBorder = new JPanel();
		windowBorder.setSize(WINDOW_DIM);
		windowBorder.setOpaque(false);
		windowBorder.setBorder(thiccLineBorder);
		con.add(windowBorder);
		

		
		
		//panels to be affixed in container
		JPanel titleNamePanel = new JPanel();
		titleSetter(titleNamePanel, "Load Game");
		con.add(titleNamePanel);
		
		
		int standardWidth = (int)(WINDOW_WIDTH / 7);
		int loadListWidth = standardWidth * 5;
		int loadListBufferHeight = (int)(WINDOW_HEIGHT / 3);
		int loadListBufferWidth = standardWidth;
		int loadListHeight = (int)(WINDOW_HEIGHT / 6) + BUFFER + (int)(WINDOW_HEIGHT * .2 + 2 * BUFFER);
		
		
		loadListScroller = new JScrollPane();
		loadListScroller.setBounds(loadListBufferWidth, loadListBufferHeight, loadListWidth, loadListHeight);
		loadListScroller.setBackground(backgroundColor);
		loadListScroller.setForeground(backgroundColor);
		loadListScroller.setBorder(medLineBorder);
		
		
		//individual saved games in scrollpane
		JPanel viewport = new JPanel();
		viewport.setBackground(backgroundColor);
		viewport.setLayout(null);
		
		int savedGameHeight = (int)(WINDOW_HEIGHT * .2 / 2);
		int savedGameWidth = loadListWidth;
		
		int viewportWidth = loadListWidth;
		int viewportHeight = 0;
		
		
		File dir = new File(PlayerSaveAndLoad.getSaveDirectory());
		File[] directoryListing = dir.listFiles();
		
		if (directoryListing != null) {
			for (File saveGame : directoryListing) {
				String saveGameName = saveGame.getName();
				saveGameList.add(saveGameName);


				
				
				JPanel iPanel = new JPanel();
				iPanel.setBackground(textColor);
				iPanel.setBounds(0, viewportHeight, savedGameWidth, savedGameHeight);
				Rectangle bounds = iPanel.getBounds();
				iPanel.setLayout(new GridBagLayout());
				
				JLabel iLabel = new JLabel(saveGameName);
				iLabel.setBounds(bounds);
				iLabel.setForeground(backgroundColor);
				iLabel.setFont(gameFont);
				
				JButton iButton = new JButton();
				iButton.setBounds(bounds);
				
				
				viewportHeight += savedGameHeight;
				
				
				iPanel.add(iLabel);
				viewport.add(iPanel);
				viewport.add(iButton);
				



			}
		} else {
			// Handle the case where dir is not really a directory.
			// Checking dir.isDirectory() above would not be sufficient
			// to avoid race conditions with another process that deletes
			// directories.
		}
		viewport.setSize(viewportWidth,viewportHeight);

		//
		loadListScroller.setViewportView(viewport);
		con.add(loadListScroller);
		
		JPanel backButtonPanel = new JPanel();
		JPanel startButtonPanel = new JPanel();
		
		JLabel backLabel = new JLabel("Back");
		JLabel startLabel = new JLabel("Start");
		
		JButton backButton = new JButton();
		JButton startButton = new JButton();
		
		int buttonsBufferHeight = loadListBufferHeight  + loadListHeight + BUFFER;
		int backButtonBuffer = BUFFER * 2;
		int startButtonBuffer = WINDOW_WIDTH - (int)(WINDOW_WIDTH/7) - backButtonBuffer;
		
		buttonSetup(con, backButtonPanel, backLabel, backButton, backButtonBuffer, buttonsBufferHeight);
		buttonSetup(con, startButtonPanel, startLabel, startButton, startButtonBuffer, buttonsBufferHeight);
		
		
		backButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		
		
		window.setResizable(false);
		window.setVisible(true);
	}
	
private void buttonSetup(Container con, JPanel panel, JLabel label, JButton button, int wBuffer, int hBuffer) {
		
		int buttonWidth = (int)(WINDOW_WIDTH/7);
		int buttonHeight = BUFFER * 2;
		
		panel.setBounds(wBuffer, hBuffer, buttonWidth, buttonHeight);
		Rectangle bounds = panel.getBounds();
		panel.setLayout(new GridBagLayout());
		panel.setBackground(backgroundColor);
		panel.setBorder(thinLineBorder);

		
		label.setBounds(bounds);
		label.setForeground(textColor);
		label.setFont(gameFont);		
		
		button.setBounds(bounds);
		button.setOpaque(false);
		
		
		panel.add(label);		
		
		con.add(panel);
		con.add(button);
		
		
	}

private void backButtonPressed(JPanel panel, JLabel label) {
	
	panel.setBackground(textColor);
	label.setForeground(backgroundColor);
	//new MainMenu();
	window.dispose();
        System.exit(0);
}

	
	
}
