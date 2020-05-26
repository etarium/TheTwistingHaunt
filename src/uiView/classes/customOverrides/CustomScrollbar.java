package uiView.classes.customOverrides;

import java.awt.Dimension;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.plaf.basic.BasicScrollBarUI;

import uiView.classes.GameWindow;
import utilities.Logs;

public class CustomScrollbar extends BasicScrollBarUI {

	private ImageIcon downArrow, upArrow, leftArrow, rightArrow;


	public CustomScrollbar(){
		try {
			upArrow = new ImageIcon(ImageIO.read(CustomScrollbar.class.getResourceAsStream("/resources/buttons/tth_scroll_button_up.png")));
		} catch (IOException e) {
			Logs.LOGGER.warning("Could not find Up Arrow in resources.");
			e.printStackTrace();
		}
		try {
			downArrow = new ImageIcon(ImageIO.read(CustomScrollbar.class.getResourceAsStream("/resources/buttons/tth_scroll_button_down.png")));
		} catch (IOException e) {
			Logs.LOGGER.warning("Could not find Down Arrow in resources.");
			e.printStackTrace();
		}
	}

	@Override
	protected JButton createDecreaseButton(int orientation) {
		JButton decreaseButton = new JButton(getAppropriateIcon(orientation)){
			@Override
			public Dimension getPreferredSize() {
				return new Dimension(30, 17);
			}
		};
		return decreaseButton;
	}

	@Override
	protected JButton createIncreaseButton(int orientation) {
		JButton increaseButton = new JButton(getAppropriateIcon(orientation)){
			@Override
			public Dimension getPreferredSize() {
				return new Dimension(30, 17);
			}
		};
		return increaseButton;
	}

	private ImageIcon getAppropriateIcon(int orientation){
		switch(orientation){
		case SwingConstants.SOUTH: return downArrow;
		case SwingConstants.NORTH: return upArrow;
		case SwingConstants.EAST: return rightArrow;
		default: return leftArrow;
		}
	}

	@Override
	protected void configureScrollBarColors() {
		this.thumbColor = GameWindow.textColor.darker();
		this.scrollBarWidth = 30;
	}
}    