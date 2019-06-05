
package uiView.classes;

import java.awt.Container;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import db.api.DbAPI;
import gameplay.newGame.NewPlayerPayload;
import pojos.entity.EntityClassObject;
import pojos.entity.PlayerEntity;

import pojos.entity.enums.EntityClassEnum;
import pojos.environment.Location;
import utilities.Logs;
public class NewGameWindow extends GameWindow{

	static JFrame window;
	static JButton mageButton, warriorButton, thiefButton;
	static JPanel magePanel, warriorPanel, thiefPanel;
	static JPanel outputPanel;
	static JTextArea output;

	private NewPlayerPayload newPlayerPayload = new NewPlayerPayload();
	private boolean button;

	private DbAPI dbApi = new DbAPI();

	public NewGameWindow() {

		window = new JFrame("New Game");
		window.setSize(WINDOW_DIM);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setBackground(backgroundColor);
		window.setLayout(null);

		Container con = window.getContentPane();
		JPanel windowBorder = new JPanel();
		windowBorder.setSize(WINDOW_DIM.width, WINDOW_DIM.height-23);
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

		JLabel backLabel = new JLabel("Back");
		JLabel startLabel = new JLabel("Start");

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

		int buttonsBufferHeight = outputBufferHeight + outputHeight + BUFFER;
		int backButtonBuffer = BUFFER * 2;
		int startButtonBuffer = WINDOW_WIDTH - (int)(WINDOW_WIDTH/7) - backButtonBuffer;

		buttonSetup(con, backButtonPanel, backLabel, backButton, backButtonBuffer, buttonsBufferHeight);
		buttonSetup(con, startButtonPanel, startLabel, startButton, startButtonBuffer, buttonsBufferHeight);

		bsSetup(backButton, backButtonPanel, backLabel, startButton, startButtonPanel, startLabel);

		window.setResizable(false);
		window.setVisible(true);
		button = true;
		while(button){
			System.out.print("");
		}
	}//end constructor

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
		
		newPlayerPayload.setClassName(EntityClassEnum.MAGE);
		updateText();
	}

	private void warriorButtonPressed() {
		magePanel.setBackground(textColor);
		warriorPanel.setBackground(textColor.darker());
		thiefPanel.setBackground(textColor);

		newPlayerPayload.setClassName(EntityClassEnum.WARRIOR);
		updateText();
	}

	private void thiefButtonPressed() {
		magePanel.setBackground(textColor);
		warriorPanel.setBackground(textColor);
		thiefPanel.setBackground(textColor.darker());

		newPlayerPayload.setClassName(EntityClassEnum.THIEF);
		updateText();
	}

	private void updateText() {		
		output.setText(newPlayerPayload.getClassName().getDescription());
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

		button = false;
		try {
			Thread.sleep(300);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		window.dispose();
		//new PlayWindow();

	}

	private void bsSetup(JButton back, JPanel panelB, JLabel labelB, JButton start, JPanel panelS, JLabel labelS) {
		back.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				backButtonPressed(panelB, labelB);
			}

		});

		start.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				panelS.setBackground(textColor);
				labelS.setForeground(backgroundColor);

				String loadText = "Ah, " + newPlayerPayload.getClassName().getName() + ", I'm afraid I cannot hold you much longer... "
						+ "Prepare yourself! Don't give up against the ---\n\n ";

				output.setText(loadText);

			}

			@Override
			public void mouseReleased(MouseEvent e) {
				try {
					Thread.sleep(4500);

				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				startButtonPressed(panelS, labelS);

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

	}

	public JTextArea getOutputBox() {
		return output;
	}
}//end NewGameWindow
