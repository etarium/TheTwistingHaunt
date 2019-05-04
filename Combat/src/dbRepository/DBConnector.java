package dbRepository;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoDatabase;

public class DBConnector {

	public MongoDatabase getDatabase() {
		PropertiesConfiguration config = new PropertiesConfiguration();
		try {
			config.load("/application.properties");
		} catch (ConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String user = config.getString("user");
		String pass = config.getString("password");
		String dbName = config.getString("database");
		
		MongoClientURI uri = new MongoClientURI(
				"mongodb+srv://"+user+":"+pass+"@thetwistinghaunt-hh6b2.mongodb.net/test?retryWrites=true");

		MongoClient mongoClient = new MongoClient(uri);
		MongoDatabase database = mongoClient.getDatabase(dbName);

		return database;
	}
}
