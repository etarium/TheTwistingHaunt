package uiView.classes.customOverrides;

import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.plaf.basic.BasicScrollBarUI;

import uiView.classes.GameWindow;

public class CustomScrollbar extends BasicScrollBarUI {

	private ImageIcon downArrow, upArrow, leftArrow, rightArrow;

	
	public CustomScrollbar(){
		upArrow = new ImageIcon("src/uiView/resources/buttons/tth_scroll_button_up.png");
		downArrow = new ImageIcon("src/uiView/resources/buttons/tth_scroll_button_down.png");
		leftArrow = new ImageIcon("src/uiView/resources/buttons/tth_scroll_button_left.png");
		rightArrow = new ImageIcon("src/uiView/resources/buttons/tth_scroll_button_right.png");        
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