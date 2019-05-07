package uiView.classes;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javax.swing.BorderFactory;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class GameWindow{

	protected final Dimension SCREEN_DIM = Toolkit.getDefaultToolkit().getScreenSize();
	private JDialog dialog = new JDialog();
	private Insets scnMax = Toolkit.getDefaultToolkit().getScreenInsets(dialog.getGraphicsConfiguration());
	protected final int totalInset = scnMax.bottom + scnMax.top;
	protected final int SCREEN_WIDTH = SCREEN_DIM.width;
	protected final int SCREEN_HEIGHT = SCREEN_DIM.height - totalInset;
	protected final int BUFFER = scnMax.top;
	
	
	private final double WIDTH_RATIO = 0.5625;
	private final double HEIGHT_RATIO = 0.8033240997229917;
	
	 
	protected  final int WINDOW_WIDTH = (int)(WIDTH_RATIO * SCREEN_WIDTH);
	protected final int WINDOW_HEIGHT = (int)(HEIGHT_RATIO * SCREEN_HEIGHT);
	protected  Dimension WINDOW_DIM = new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT);
	
	public static Color backgroundColor = new Color(26,23,1);
	public static Color textColor = new Color(107,93,3);
	
	protected float gameFontSize = 0.5625f * SCREEN_WIDTH / 50;
	protected float titleFontSize = WINDOW_WIDTH/25;
	protected float menuFontSize = (float)(titleFontSize * (.8));
	protected float helpFontSize = (float)(titleFontSize / 3.5);
	
	private String dir = "src/gui/resources/fonts/";
	private String fontFile = "Px437_IBM_Conv.ttf";
	private String fontPath = dir + fontFile;
	
	protected Font defaultFont = this.defineFont(fontPath);
	
	public Font gameFont = defaultFont.deriveFont(gameFontSize);
	public Font titleFont = defaultFont.deriveFont(titleFontSize);
	public Font menuFont = defaultFont.deriveFont(menuFontSize);
	public Font helpFont = defaultFont.deriveFont(helpFontSize);
	
	
	protected static final int THICC = 4;
	protected static final int MED = 2;
	protected static final int THIN = 1;
	
	public static Border thiccLineBorder = BorderFactory.createLineBorder(textColor, THICC);
	public static Border medLineBorder = BorderFactory.createLineBorder(textColor, MED);
	public static Border thinLineBorder = BorderFactory.createLineBorder(textColor, THIN);	
	
	
	private Font defineFont(String filePath) {
		Font defaultFont = null;
		try {
			File newFile = new File(filePath);
			FileInputStream fis = new FileInputStream(newFile);
			BufferedInputStream bis = new BufferedInputStream(fis);
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			
			defaultFont = Font.createFont(Font.TRUETYPE_FONT, bis);
			ge.registerFont(defaultFont);
			
		} catch(FileNotFoundException e) {
			System.out.println("File not found.");
		}
		catch(Exception e) {
			System.out.println(e);
			
		}
		
		return defaultFont;
	}
	
public void titleSetter(JPanel panel, String text) {
		
		int titleWidth = (int)(WINDOW_WIDTH * .75);
		int titleHeight = (int)(WINDOW_HEIGHT * .2);
		int titleBufferWidth = (WINDOW_WIDTH - titleWidth)/2;

		panel.setBounds(titleBufferWidth,BUFFER,titleWidth, titleHeight);
		panel.setBackground(textColor);
		panel.setLayout(new GridBagLayout());
		
		JLabel panelLabel = new JLabel(text);
		panelLabel.setForeground(backgroundColor);
		panelLabel.setFont(titleFont);

		panel.add(panelLabel);
	}

	
}//end GameWindow class


