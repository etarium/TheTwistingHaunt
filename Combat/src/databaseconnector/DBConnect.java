package databaseconnector;
import java.io.IOException;
import java.util.ArrayList;

import org.bson.Document;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import querymachine.QueryMachine;

import static com.mongodb.client.model.Filters.*;

import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

import com.mongodb.client.MongoCursor;

import static com.mongodb.client.model.Filters.eq;


public class DBConnect {
	public DBConnect() {
		//empty constructor
	}

	public QueryMachine objectCreator = new QueryMachine();
	public MongoClient connect;
	public MongoDatabase tth;
	public MongoCollection<Document> instanceCollection;
	public MongoCollection<Document> entityCollection;
	public MongoCollection<Document> itemCollection;


	private ArrayList<String> itemStringArray = new ArrayList<String>();



	public MongoClient connectToDB() throws IOException {
		CodecRegistry pojoCodecRegistry = fromRegistries(MongoClient.getDefaultCodecRegistry(),
				fromProviders(PojoCodecProvider.builder().automatic(true).build()));

		CredentialIOConfig cfgRead = new CredentialIOConfig();	
		String url = "";
		int port = 0;
		String user = "";
		String pass = "";	
		String host = "";
		url = cfgRead.getURL();
		port = cfgRead.getPort();
		user = cfgRead.getUser();
		pass = cfgRead.getPass();
		host = url+port;
		connect = new MongoClient(url, MongoClientOptions.builder().codecRegistry(pojoCodecRegistry).build());

		return connect;
	}

	public MongoDatabase enterDB() throws IOException {
		if(connect == null) {
			connect = connectToDB();
		}
		tth = connect.getDatabase("TTH_Local");

		return tth;
	}

	public String getInstance(String instanceID) throws IOException {
		instanceCollection = tth.getCollection("Instance");
		Document instance = instanceCollection.find(eq("instance_id", instanceID)).first();
		String instanceString = "" + instance;
		return instanceString;
	}

	public ArrayList<Document> getAllInstances() throws IOException {
		instanceCollection = tth.getCollection("Instance");
		ArrayList<Document> instanceArray = new ArrayList<Document>();
		MongoCursor<Document> cursor = instanceCollection.find().iterator();
		try {
			while (cursor.hasNext()) {
				Document tempDoc = instanceCollection.find().first();
				cursor.next();
				instanceArray.add(tempDoc);
			}
		} finally {
			cursor.close();
		}
		for(int i = 0; i<instanceArray.size(); i++) {
			System.out.println("for");
			System.out.print(instanceArray.get(i));
		}
		return instanceArray;

	}

	public void getEntity() throws IOException {

	}

	public ArrayList<String> getItem() throws IOException {
		return itemStringArray;
	}
	
	public void closeDB() {
		
	}
}
