package gui.classes;

import java.awt.AWTEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextPane;

public class HelpWindow extends GameWindow{
	
	public HelpWindow() {
		
		JFrame help = new JFrame("Help");
		help.setSize(WINDOW_DIM);		

		JButton exitButton = new JButton();
		exitButton.setBackground(null);
		exitButton.setSize(WINDOW_DIM);
		
		exitButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				// delegate to event handler method
				exitButtonPressed(evt, help);
			
		}});
		
		
		help.addKeyListener(new KeyListener() {
			@Override
			public void keyPressed(KeyEvent e) {
				exitButtonPressed(e, help);
			}

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				exitButtonPressed(e, help);

			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				exitButtonPressed(e, help);

			}
		});
		help.add(exitButton);
		
		
		
		
		String dir = "src/gui/resources/";
		String fileName = "help_instructions.txt";
		String filePath = dir + fileName + "";
		JTextPane helpText = new JTextPane();
		
		try {
		    FileReader fr = new FileReader(filePath);
		    BufferedReader reader = new BufferedReader(fr);
		    while(reader.ready()) {
		    		helpText.read(reader,null);
		    }
		}
		catch (IOException ioe) {
		    System.err.println(ioe);
		    System.exit(1);
		}
		helpText.setBackground(backgroundColor);
		helpText.setFont(helpFont);
		helpText.setForeground(textColor);
		helpText.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		helpText.setEditable(false);
		help.add(helpText);
		
		
		help.setVisible(true);
		help.setFocusable(true);
		
	}
		
	private void exitButtonPressed(AWTEvent evt, JFrame window) {
		window.dispose();
	}
	

}
