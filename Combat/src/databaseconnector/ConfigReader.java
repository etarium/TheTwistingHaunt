package databaseconnector;
import java.util.Properties;
 
public class ConfigReader
{
   Properties configFile;
   public ConfigReader()
   {
	configFile = new java.util.Properties();
	try {
	  configFile.load(this.getClass().getClassLoader().
	  getResourceAsStream("config.properties"));
	}catch(Exception eta){
	    eta.printStackTrace();
	}
   }
 
   public String getProperty(String key)
   {
	String value = this.configFile.getProperty(key);
	return value;
   }
}
