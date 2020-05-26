package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import uiView.classes.GameWindow;

public class ConfigReader
{	

	public Properties setUpConfig() throws FileNotFoundException, IOException {

//	String rootPath = System.getProperty("user.dir");
//	String appConfigPath = rootPath + "/src/resources/application.properties";
		//InputStream input = ConfigReader.class.getResourceAsStream("/resources/application.properties");

	Properties appProps = new Properties();
	appProps.load(ConfigReader.class.getResourceAsStream("/resources/application.properties"));

		return appProps;
	}
	
	public String getProperty(String key) {
		Properties appProps;
		try {
			appProps = setUpConfig();
			return appProps.getProperty(key);
		} catch (IOException e) {
			Logs.LOGGER.severe("IOException caught in ConfigReader " + e);
		}
		
		return null;
	}
}
