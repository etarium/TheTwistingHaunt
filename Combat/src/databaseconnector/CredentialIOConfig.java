package databaseconnector;
import java.io.IOException;
import java.io.InputStream;
public class CredentialIOConfig {

	 
		String result = "";
		ConfigReader cfg = new ConfigReader();
		InputStream inputStream;
		
		public String getURL() throws IOException {
			
			String url = cfg.getProperty("url");
			return url;
		}
		
		public int getPort() throws IOException {
			String port = cfg.getProperty("port");
			int portInt = Integer.parseInt(port);
			return portInt;
		}
		
		public String getUser() throws IOException {
			
			String user = cfg.getProperty("user");
			return user;
		}

		public String getPass() throws IOException {
	
			String pass = cfg.getProperty("pass");
			return pass;
		}
	 
}
