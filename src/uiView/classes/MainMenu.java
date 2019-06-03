package uiView.classes;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import utilities.Logs;

public class MainMenu extends GameWindow {

	Container con;
	JFrame window;
	JPanel titleNamePanel, startButtonPanel;
	JLabel titleNameLabel, outputLabel;
	JButton ngButton, lgButton, helpButton, readButton, exitButton;

	static String message;
	public static boolean button;
	public static boolean nGame;

	public MainMenu() {
		window = new JFrame("Menu");
		window.setSize(WINDOW_DIM);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setBackground(backgroundColor);
		window.setLayout(null);


		con = window.getContentPane();

		JPanel windowBorder = new JPanel();
		windowBorder.setSize(WINDOW_DIM.width, WINDOW_DIM.height-23);
		windowBorder.setOpaque(false);
		windowBorder.setBorder(thiccLineBorder);
		con.add(windowBorder);


		titleNamePanel = new JPanel();
		titleSetter(titleNamePanel, "The Twisting Haunt");

		int titleHeight = (int) (WINDOW_HEIGHT * .2);
		int menuWidth = (int) (WINDOW_WIDTH / 3);
		int menuHeight = (int) (WINDOW_HEIGHT / 2);
		int menuBufferWidth = menuWidth;
		int menuBufferHeight = menuHeight - titleHeight;

		JPanel opt1 = new JPanel();
		JPanel opt2 = new JPanel();
		JPanel opt3 = new JPanel();
		JPanel opt4 = new JPanel();
		JPanel opt5 = new JPanel();

		ngButton = new JButton();
		lgButton = new JButton();
		helpButton = new JButton();
		readButton = new JButton();
		exitButton = new JButton();

		JPanel[] menuPanels = {opt1, opt2, opt3, opt4, opt5};
		String[] menuNames = {"New Game", "Load Game", "Help", "Readme", "Exit"};
		JButton[] buttons = {ngButton, lgButton, helpButton, readButton, exitButton};
		int optWidth = menuWidth;
		int optHeight = (menuHeight / 5);

		//programmatic menu button generation

		for (int i = 0; i < menuPanels.length; i++) {
			menuPanels[i].setBounds(menuBufferWidth, menuBufferHeight + (i * optHeight), optWidth, optHeight);
			menuPanels[i].setBackground(textColor);

			JLabel menuLabel = new JLabel(menuNames[i]);
			menuLabel.setForeground(backgroundColor);
			menuLabel.setFont(menuFont);
			menuPanels[i].add(menuLabel);
			menuPanels[i].setLayout(new GridBagLayout());

			Rectangle bounds = menuPanels[i].getBounds();
			buttons[i].setBounds(bounds);

			buttons[i].addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseEntered(java.awt.event.MouseEvent evt) {
					JButton temp = (JButton) evt.getSource();
					int index = -1;

					for (int i = 0; i < buttons.length; i++) {
						if (buttons[i].equals(temp)) {
							index = i;
						}
					}

					menuPanels[index].setBackground(textColor.darker());
				}

				public void mouseExited(java.awt.event.MouseEvent evt) {
					JButton temp = (JButton) evt.getSource();
					int index = -1;

					for (int i = 0; i < buttons.length; i++) {
						if (buttons[i].equals(temp)) {
							index = i;
						}
					}

					menuPanels[index].setBackground(textColor);
				}
			});

			lgButton.setEnabled(false);

			con.add(menuPanels[i]);
			con.add(buttons[i]);
		}//end menu button generation

		ngButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				newGameButtonPressed();
				button = false;
			}

		});

		lgButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				loadGameButtonPressed();
			}

		}); 

		exitButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				// delegate to event handler method
				exitButtonPressed(evt);
			}

		});

		readButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				//delegate to event handler method
				try {
					readmeButtonPressed(evt);
				} catch (Exception e) {
					Logs.LOGGER.severe("Exception caught in MainMenu.readButton " + e);
				}
			}
		});

		helpButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				//delegate to event handler method
				try {
					helpButtonPressed(evt);
				} catch (Exception e) {
					Logs.LOGGER.severe("Exception caught in MainMenu.helpButton " + e);
				}
			}
		});

		con.add(titleNamePanel);

		window.setResizable(false);
		window.setVisible(true);

		nGame = true;
		button = true;
		while(button) {
			System.out.print("");
		}
	}//end Game initializer

	private void loadGameButtonPressed() {
		nGame = false;
		button = false;

		try {
			Thread.sleep(300);
		} catch (InterruptedException e) {
			Logs.LOGGER.severe("InterruptedException caught in MainMenu.loadGameButtonPressed " + e);
		}
		window.dispose();
	}

	private void newGameButtonPressed() {		
		button = false;

		try {
			Thread.sleep(300);
			NewGameWindow.window.setVisible(true);
		} catch (InterruptedException e) {
			Logs.LOGGER.severe("InterruptedException caught in MainMenu.newGameButtonPressed " + e);
		}
		//window.dispose();
	}

	private void exitButtonPressed(ActionEvent evt) {
		window.dispose();
		System.exit(0);
	}

	private void readmeButtonPressed(ActionEvent evt) throws FileNotFoundException {

		JFrame readmeWindow = new JFrame("Readme");
		Container readmeContainer;
		Dimension readmeDimension = new Dimension(600, 400);
		readmeWindow.setBackground(Color.black);

		readmeWindow.setSize(readmeDimension);

		String dir = "src/uiView/resources/";
		String fileName = "readme.txt";
		String filePath = dir + fileName + "";

		JTextArea readmeText = new JTextArea();

		try {
			FileReader fr = new FileReader(filePath);
			BufferedReader reader = new BufferedReader(fr);
			while ((reader.readLine()) != null) {
				readmeText.read(reader, "Readme Text");
			}
		} catch (IOException ioe) {
			System.err.println(ioe);
			System.exit(1);
		}

		JScrollPane readmeScroller = new JScrollPane(readmeText);

		readmeContainer = readmeWindow.getContentPane();
		readmeContainer.add(readmeScroller);
		readmeWindow.setVisible(true);

	}

	private void helpButtonPressed(ActionEvent evt) {
		new HelpWin();
	}

	public boolean getNGame(){
		return nGame;
	}

}//end Game class