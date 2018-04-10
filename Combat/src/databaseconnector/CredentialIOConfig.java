package databaseconnector;
import java.io.IOException;
	import java.io.InputStream;
public class CredentialIOConfig {

	 
		String result = "";
		ConfigReader cfg = new ConfigReader();
		InputStream inputStream;
		
		public String getUser() throws IOException {
			
			String user = cfg.getProperty("user");
			return user;
		}
		
		public String getPass() throws IOException {
			String pass = cfg.getProperty("pass");	
			return pass;
		}
	 
}
