package gui.classes;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.Insets;
import java.awt.Toolkit;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javax.swing.BorderFactory;
import javax.swing.JDialog;
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
	
	protected Color backgroundColor = new Color(26,23,1);
	protected Color textColor = new Color(107,93,3);
	
	protected float titleFontSize = WINDOW_WIDTH/25;
	protected float menuFontSize = (float)(titleFontSize * (.8));
	protected float helpFontSize = (float)titleFontSize / 3;
	
	private String dir = "src/gui/resources/fonts/";
	private String fontFile = "Px437_IBM_Conv.ttf";
	private String fontPath = dir + fontFile;
	
	protected Font defaultFont = this.defineFont(fontPath);
	
	
	protected Font titleFont = defaultFont.deriveFont(titleFontSize);
	protected Font menuFont = defaultFont.deriveFont(menuFontSize);
	protected Font helpFont = defaultFont.deriveFont(helpFontSize);
	
	//protected Font titleFont = new Font(fontFamily, Font.PLAIN, titleFontSize);
	//protected Font menuFont = new Font(fontFamily, Font.BOLD, normalFontSize);
	
	
	protected final int THICC = 4;
	protected final int MED = 2;
	protected final int THIN = 1;
	
	protected Border thiccLineBorder = BorderFactory.createLineBorder(textColor, THICC);
	protected Border medLineBorder = BorderFactory.createLineBorder(textColor, MED);
	protected Border thinLineBorder = BorderFactory.createLineBorder(textColor, THIN);	
	
	
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
	
}//end GameWindow class


