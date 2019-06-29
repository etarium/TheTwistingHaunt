package uiView.classes;

import java.awt.Container;
import java.awt.GridBagLayout;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import pojos.entity.PlayerEntity;
import pojos.environment.Cell;
import uiView.UIMain;
import utilities.ConfigReader;
import utilities.Logs;

public class LoadGameWindow extends GameWindow{

	static JFrame window;
	static JScrollPane loadListScroller;
	static ArrayList<String> saveGameList = new ArrayList<>();;
	ConfigReader config = new ConfigReader();
	ObjectMapper mapper = new ObjectMapper();
	String selected;

	public LoadGameWindow() {
		String title = "Load Game";
		JFrame window = configureWindow(title);
		Container con = window.getContentPane();
		JPanel windowBorder = setWindowBorder();
		con.add(windowBorder);

		//panels to be affixed in container
		JPanel titleNamePanel = new JPanel();
		titleSetter(titleNamePanel, title);
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


		JPanel viewport = listAvailableSaves(loadListWidth);

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
				backButtonPressed(backButtonPanel, backLabel);
			}
		});

		startButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				startButtonPressed(startButtonPanel, startLabel);
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
		Logs.LOGGER.info("Back Button Pressed.");

		window.setVisible(false);
		if(!window.isVisible()) {
			panel.setBackground(backgroundColor);
			label.setForeground(textColor);
		}
	}

	private void startButtonPressed(JPanel panel, JLabel label) {
		panel.setBackground(textColor);
		label.setForeground(backgroundColor);
		Logs.LOGGER.info("Start Button Pressed.");

		loadGame(selected);
		window.setVisible(false);
		if(!window.isVisible()) {
			panel.setBackground(backgroundColor);
			label.setForeground(textColor);
		}
	}

	private String saveFilePressed(List<JPanel> panelList, List<JLabel> labelList, JPanel panel, JLabel label) {
		for(JPanel unusedPanel : panelList) {
			unusedPanel.setBackground(textColor);
		}
		for(JLabel unusedLabel : labelList) {
			unusedLabel.setForeground(backgroundColor);
		}
		panel.setBackground(backgroundColor);
		label.setForeground(textColor);
		Logs.LOGGER.info(label.getText() + " Pressed.");
		return label.getText();
	}

	private JPanel listAvailableSaves(int loadListWidth) {
		//individual saved games in scrollpane
		JPanel viewport = new JPanel();
		viewport.setBackground(backgroundColor);
		viewport.setLayout(null);

		int savedGameHeight = (int)(WINDOW_HEIGHT * .2 / 2);
		int savedGameWidth = loadListWidth;

		int viewportWidth = loadListWidth;
		int viewportHeight = 0;

		String rootPath = System.getProperty("user.dir");
		String saveLoc = config.getProperty("save.location");
		File dir = new File(rootPath+saveLoc);

		//do not show any hidden files
		File[] directoryListing = dir.listFiles(file -> !file.isHidden());
		List<JPanel> panelList = new ArrayList<JPanel>();
		List<JLabel> labelList = new ArrayList<JLabel>();
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
				iButton.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						selected = saveFilePressed(panelList, labelList, iPanel, iLabel);
					}
				});

				viewportHeight += savedGameHeight;

				iPanel.add(iLabel);
				viewport.add(iPanel);
				viewport.add(iButton);
				panelList.add(iPanel);
				labelList.add(iLabel);
			}
		} else {
			// Handle the case where dir is not really a directory.
			// Checking dir.isDirectory() above would not be sufficient
			// to avoid race conditions with another process that deletes
			// directories.
		}
		viewport.setSize(viewportWidth,viewportHeight);

		return viewport;
	}

	private void loadGame(String selected) {
		selected = "/"+selected;
		String rootPath = System.getProperty("user.dir");
		String saveLoc = config.getProperty("save.location");
		File dir = new File(rootPath+saveLoc+selected);
		try {
			Logs.LOGGER.info("Opening Save " + dir); 
			
			File playerFile = new File (dir+"/player-save.txt");
			File cellsFile = new File (dir+"/cells-save.txt");
			
			UIMain.player = mapper.readValue(playerFile,  PlayerEntity.class);
			UIMain.cells = mapper.readValue(cellsFile, new TypeReference<List<Cell>>(){});

			Logs.LOGGER.info("Loaded player-save from " + selected);
			Logs.LOGGER.info("Loaded cell-save from " + dir);
			
		} catch (IOException e ){
			Logs.LOGGER.severe("Could not load save " + dir);
		}
	}
}
