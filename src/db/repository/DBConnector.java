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

import pojos.entity.EntityClassObject;
import pojos.entity.enums.EntityClassEnum;
import pojos.environment.Cell;
import utilities.Logs;

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
		Logs.LOGGER.info("Connected to database " + dbName);
		
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
				Logs.LOGGER.severe("Reading Cells into Cell Object failed.");
				e.printStackTrace();
			}
		});
		return activeCells;
	}
	
	public List<EntityClassObject> getAllAvailableClasses() {
		List<EntityClassObject> activeClasses = new ArrayList();
		MongoCollection<Document> classesCollection = database.getCollection("Classes");
		Iterable<Document> classDocuments = classesCollection.find();
		classDocuments.forEach(classes -> {
			try {
				EntityClassObject tempClass = mapper.readValue(classes.toJson(), EntityClassObject.class);
				activeClasses.add(tempClass);
				
			} catch (IOException e) {
				Logs.LOGGER.severe("Reading Cells into Cell Object failed.");
				e.printStackTrace();
			}
		});
		return activeClasses;
	}
	
	public EntityClassObject getClassByName(EntityClassEnum className) {
		MongoCollection<Document> classCollection = database.getCollection("Classes");
		Document classDocument = classCollection.find(eq("name", className.toString())).first();
		try {
			EntityClassObject entityClassObject = mapper.readValue(classDocument.toJson(), EntityClassObject.class);
			return entityClassObject;
		} catch (IOException e) {
			Logs.LOGGER.severe("Reading Entity Class Objects has failed.");
			e.printStackTrace();
		}
		return null;
	}
}
