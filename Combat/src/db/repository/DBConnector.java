package db.repository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.*;

import pojos.environment.Cell;

public class DBConnector {
	MongoDatabase database;
	ObjectMapper mapper = new ObjectMapper();
	public DBConnector() {
		ConfigReader config;
		config = new ConfigReader();
		String user = config.getProperty("user");
		String pass = config.getProperty("password");
		String dbName = config.getProperty("database");
		MongoClientURI uri = new MongoClientURI(
				"mongodb+srv://"+user+":"+pass+"@thetwistinghaunt-shard-00-01-hh6b2.mongodb.net/admin");

		MongoClient mongoClient = new MongoClient(uri);
		database = mongoClient.getDatabase(dbName);
		
	}
	
	public List<Cell> getAllCellsFromInstance(String instance) {
		List<Cell> activeCells = new ArrayList();
		MongoCollection<Document> cellCollection = database.getCollection("Cells");
		Iterable<Document> cellDocuments = cellCollection.find(eq("instance.name", instance));
		cellDocuments.forEach(cell -> {
			try {
				Cell tempCell = mapper.readValue(cell.toJson(), Cell.class);
				activeCells.add(tempCell);
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("Reading Cells into Cell Object failed.");
				e.printStackTrace();
			}
		});
		return activeCells;
	}
}
