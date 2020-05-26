package utilities;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader
{	

	public Properties setUpConfig() throws FileNotFoundException, IOException {

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
