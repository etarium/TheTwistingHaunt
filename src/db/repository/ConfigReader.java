package db.repository;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import utilities.Logs;

public class ConfigReader
{	

	public Properties setUpConfig() throws FileNotFoundException, IOException {

	String rootPath = System.getProperty("user.dir");
	String appConfigPath = rootPath + "/resources/application.properties";

	Properties appProps = new Properties();
	appProps.load(new FileInputStream(appConfigPath));

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
