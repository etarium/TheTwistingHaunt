package uiView.classes;

import java.awt.Component;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import gameplay.newGame.NewPlayerPayload;
import gameplay.newGame.PlayerInitializer;
import entity.EntityClassObject;
import entity.PlayerEntity;
import entity.SpeciesObject;
import uiView.UIMain;
import utilities.Logs;

public class CharacterCreateWindow extends GameWindow{	
	static JFrame window;
	Container con;
	JPanel upOut, out, in;
	JTextArea className;
	JTextArea speciesName;
	static JTextArea upperOutput;
	static JTextArea lowerOutput;
	static JTextField input;

	static boolean enterPressed = false;
	int classCounter = 0;
	int speciesCounter = 0;
	String newGameIntroText = "It appears the snarling tendrils of this fantasy world have not yet ensnared you, weary traveler." 
			+ "\n\nDo tell, what is your profession?";

	private PlayerInitializer playerinit = new PlayerInitializer();
	private NewPlayerPayload newPlayerPayload = new NewPlayerPayload();

	public CharacterCreateWindow() {

		window = new JFrame("Character Creation");
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
		input = new JTextField("Type your name to begin your adventure, hero.");

		upOut.setLayout(new GridLayout(2,3));
		out.setLayout(new FlowLayout(FlowLayout.LEADING));
		in.setLayout(new FlowLayout(FlowLayout.LEADING));

		addUpperOutputBox(upOut);
		addOutputBox(out, lowerOutput);
		addInputBox(in,input);

		window.setResizable(false);
		window.pack();
		window.setVisible(true);
		
		input.requestFocus();

	}//end initializer

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

		//initial text
		box.setText(formattedText());

		out.add(box);
	}

	private void addUpperOutputBox(Container out) {

		JButton classLButton = new JButton("<");
		JButton classRButton = new JButton(">");
		JButton speciesLButton = new JButton("<");
		JButton speciesRButton = new JButton(">");
		JButton[] buttonArray = new JButton[] { classLButton, classRButton, speciesLButton, speciesRButton };
		JPanel classPanel = new JPanel();
		JPanel speciesPanel = new JPanel();
		
		className = new JTextArea(""+EntityClassObject.getClasses().get(classCounter));
		speciesName = new JTextArea( ""+SpeciesObject.getSpecies().get(speciesCounter));
		classPanel.setBackground(backgroundColor);
		speciesPanel.setBackground(backgroundColor);
		className.setBackground(backgroundColor);
		className.setForeground(textColor);
		className.setFont(smallMenuFont);
		speciesName.setBackground(backgroundColor);
		speciesName.setForeground(textColor);
		speciesName.setFont(smallMenuFont);

		for(JButton button : buttonArray) {
			button.setForeground(textColor);
			button.setBackground(backgroundColor);
			button.setFont(smallMenuFont);
			button.setOpaque(true);
			button.setBorderPainted(false);	
		}
		addListeners(classLButton, classRButton, speciesLButton, speciesRButton, className, speciesName);

		classPanel.add(classLButton);
		classPanel.add(className);
		classPanel.add(classRButton);

		//species select
		speciesPanel.add(speciesLButton);
		speciesPanel.add(speciesName);
		speciesPanel.add(speciesRButton);

		out.add(classPanel);
		out.add(speciesPanel);
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
			}

			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == e.VK_ENTER) {
					enterPressed = true;
					if(!input.getText().equals("/quit")) {
						newPlayerPayload.setName(input.getText());
						UIMain.player = playerinit.initializePlayer(true, newPlayerPayload);

						Logs.LOGGER.info("Character Creation Character Name: " + UIMain.player.getName());
						window.dispose();
					} else {
						window.dispose();
					}
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
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

	private void updateText() {		
		outGUI(formattedText());
	}
	
	private String formattedText() {
		if(newPlayerPayload.getClassName().getName() == null || newPlayerPayload.getSpecies().getName() == null) {
			newPlayerPayload.setClassName(EntityClassObject.getClasses().get(classCounter));
			newPlayerPayload.setSpecies(SpeciesObject.getSpecies().get(speciesCounter));
		}
		return (newGameIntroText + "\n\n"
				+"**********\n"
				+ newPlayerPayload.getClassName().getName() + ": " + newPlayerPayload.getClassName().getDescription() + "\n\n"
				+"**********\n"
				+ newPlayerPayload.getSpecies().getName() + ": " + newPlayerPayload.getSpecies().getDescription());
	}
	public PlayerEntity getNewPlayer() {
		Logs.LOGGER.info("NewGameWindow.getNewPlayer() " + UIMain.player);
		return UIMain.player;
	}

	public void exitWindow() {
		window.dispose();
	}
	private void addListeners(JButton classLButton, JButton classRButton, JButton speciesLButton, JButton speciesRButton, JTextArea className, JTextArea speciesName) {
		JButton[] buttonArray = new JButton[] { classLButton, classRButton, speciesLButton, speciesRButton };
		
		classLButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				className.setText(backOneClass());
				className.update(className.getGraphics());
			}
		});

		classRButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//move class list forward one
				className.setText(forwardOneClass());
				className.update(className.getGraphics());
			}

		}); 

		speciesLButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				//move species list back one
				speciesName.setText(backOneSpecies());
				speciesName.update(speciesName.getGraphics());
			}

		});

		speciesRButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				//move species list forward one
				speciesName.setText(forwardOneSpecies());
				speciesName.update(speciesName.getGraphics());
			}
		});

		for (JButton button : buttonArray) {
			addChangeListener(button);
		}

	}

	private void addChangeListener(JButton button) {
		button.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				if (button.getModel().isPressed() || button.getModel().isRollover()) {
					button.setForeground(textColor.darker());
					for (Component component : button.getComponents() ) {
						component.setForeground(textColor.darker());
						button.add(component);
					}
				} else {
					button.setForeground(textColor);
					for (Component component : button.getComponents() ) {
						component.setForeground(textColor);
						button.add(component);
					}
				}
			}
		});
	}
	
	public String backOneClass() {
		if(classCounter == 0) {
			classCounter = EntityClassObject.getClasses().size()-1;
		} else {
			classCounter = classCounter -1;
		}
		newPlayerPayload.setClassName(EntityClassObject.getClasses().get(classCounter));
		updateText();
		Logs.LOGGER.info("Back Class Select is " + EntityClassObject.getClasses().get(classCounter).toString());
		
		return EntityClassObject.getClasses().get(classCounter).toString();
	}
	public String forwardOneClass() {
		if(classCounter == EntityClassObject.getClasses().size()-1) {
			classCounter = 0;
		} else {
			classCounter = classCounter + 1;
		}
		newPlayerPayload.setClassName(EntityClassObject.getClasses().get(classCounter));
		updateText();
		Logs.LOGGER.info("Forward Class Select is " + EntityClassObject.getClasses().get(classCounter).toString());		
		return EntityClassObject.getClasses().get(classCounter).toString();
	}
	public String backOneSpecies() {
		if(speciesCounter == 0) {
			speciesCounter = SpeciesObject.getSpecies().size()-1;

		} else {
			speciesCounter = speciesCounter -1;	
		}
		newPlayerPayload.setSpecies(SpeciesObject.getSpecies().get(speciesCounter));
		updateText();
		Logs.LOGGER.info("Back Species Select is " + SpeciesObject.getSpecies().get(speciesCounter).toString());
		return SpeciesObject.getSpecies().get(speciesCounter).toString();
	}
	public String forwardOneSpecies() {
			if(speciesCounter == SpeciesObject.getSpecies().size()-1) {
				speciesCounter = 0;
			} else {
				speciesCounter = speciesCounter + 1;
			}
			newPlayerPayload.setSpecies(SpeciesObject.getSpecies().get(speciesCounter));
			updateText();
			Logs.LOGGER.info("Forward Species Select is " + SpeciesObject.getSpecies().get(speciesCounter).toString());		
			return SpeciesObject.getSpecies().get(speciesCounter).toString();
	}
}
