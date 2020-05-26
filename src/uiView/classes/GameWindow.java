package uiView.classes;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.io.BufferedInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import javax.swing.BorderFactory;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

import uiView.UIMain;
import utilities.Logs;

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

	protected float smallMenuFontSize = 0.5625f * SCREEN_WIDTH / 50;
	protected float gameFontSize = 0.7625f * SCREEN_WIDTH / 50;
	protected float titleFontSize = WINDOW_WIDTH/25;
	protected float menuFontSize = (float)(titleFontSize * (.8));
	protected float helpFontSize = (float)(titleFontSize / 2.5);

	private String dir = "../resources/fonts/";
	private String gameFontFile = "Px437_IBM_VGA9.ttf";
	private String menuFontFile = "Px437_IBM_Conv.ttf";
	//TODO: create an options page that lets a user choose a highly readable font
	//private String fontFile = "SFNSText.ttf";

	protected Font mainMenuFont = this.defineFont(dir, menuFontFile);
	protected Font mainGameFont = this.defineFont(dir, gameFontFile);

	public Font gameFont = mainGameFont.deriveFont(gameFontSize);
	public Font titleFont = mainMenuFont.deriveFont(titleFontSize);
	public Font menuFont = mainMenuFont.deriveFont(menuFontSize);
	public Font helpFont = mainGameFont.deriveFont(helpFontSize);
	public Font smallMenuFont = mainMenuFont.deriveFont(smallMenuFontSize);

	protected static final int THICC = 4;
	protected static final int MED = 2;
	protected static final int THIN = 1;

	public static Border thiccLineBorder = BorderFactory.createLineBorder(textColor, THICC);
	public static Border medLineBorder = BorderFactory.createLineBorder(textColor, MED);
	public static Border thinLineBorder = BorderFactory.createLineBorder(textColor, THIN);	

	private Font defineFont(String dir, String fontFile) {
		Font defaultFont = null;
		try {
			InputStream input = GameWindow.class.getResourceAsStream("/uiView/resources/fonts/"+fontFile);
			BufferedInputStream bis = new BufferedInputStream(input);
			if (input == null) {
				Logs.LOGGER.warning(fontFile + " was not found via ClassLoader. \n"
						+ "Working Directory = " + System.getProperty("user.dir"));
				// this is how we load file within editor (eg eclipse)
				input = GameWindow.class.getResourceAsStream(dir+fontFile);
				bis = new BufferedInputStream(input);
			}

			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();

			defaultFont = Font.createFont(Font.TRUETYPE_FONT, bis);
			ge.registerFont(defaultFont);

		} catch(FileNotFoundException e) {
			Logs.LOGGER.severe("Font File " + defaultFont + " Not Found at path " + dir + fontFile);
		}
		catch(Exception e) {
			Logs.LOGGER.severe("Caught exception in GameWindow " + e);

		}

		return defaultFont;
	}

	public JPanel titleSetter(JPanel panel, String text) {

		int titleWidth = (int)(WINDOW_WIDTH * .75);
		int titleHeight = (int)(WINDOW_HEIGHT * .2);
		int titleBufferWidth = (WINDOW_WIDTH - titleWidth)/2;

		panel.setBounds(titleBufferWidth,BUFFER,titleWidth, titleHeight);
		panel.setBackground(textColor);
		panel.setLayout(new GridLayout());

		JLabel panelLabel = new JLabel(text);
		panelLabel.setOpaque(true);
		panelLabel.setBackground(textColor);
		panelLabel.setForeground(backgroundColor);
		panelLabel.setFont(titleFont);
		panelLabel.setVerticalAlignment(SwingConstants.CENTER);
		panelLabel.setHorizontalAlignment(SwingConstants.CENTER);

		panel.add(panelLabel);

		return panel;
	}

	public JPanel setWindowBorder() {
		JPanel windowBorder = new JPanel();

		if(UIMain.os.contains("Windows")) {
			windowBorder.setSize(WINDOW_DIM.width-7, WINDOW_DIM.height-29);
		} else {
			windowBorder.setSize(WINDOW_DIM.width, WINDOW_DIM.height-23);
		}
		windowBorder.setOpaque(false);
		windowBorder.setBorder(thiccLineBorder);

		return windowBorder;
	}

	public JFrame configureWindow(String title) {
		JFrame window = new JFrame(title);
		window.setSize(WINDOW_DIM);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setBackground(backgroundColor);
		window.setLayout(null);

		window.setResizable(false);
		window.setVisible(true);
		return window;
	}

	public JLabel setMenuLabel(String title) {
		JLabel label = new JLabel(title);
		label.setFont(mainMenuFont);
		label.setForeground(Color.RED);
		label.setBackground(textColor);
		label.setVerticalTextPosition(SwingConstants.CENTER);
		label.setHorizontalAlignment(SwingConstants.CENTER);

		return label;
	}
}//end GameWindow class


