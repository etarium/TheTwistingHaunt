package databaseconnector;
import java.io.IOException;
import java.util.ArrayList;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.eq;

 
public class DBConnect {
	public DBConnect() {
		//empty constructor
	}
	
	private MongoClient connect;
	private MongoDatabase tth;
	private MongoCollection<Document> cellCollection;
	private MongoCollection<Document> instanceCollection;
	private MongoCollection<Document> entityCollection;
	private MongoCollection<Document> itemCollection;
	
	public MongoClient connectToDB() throws IOException {
		CredentialIOConfig cfgRead = new CredentialIOConfig();	
		String url = "";
		int port = 0;
		String user = "";
		String pass = "";		
		url = cfgRead.getURL();
		port = cfgRead.getPort();
		user = cfgRead.getUser();
		pass = cfgRead.getPass();
		connect = new MongoClient(url, port);
		System.out.println(user + " this was a connection test.");
		
		return connect;
	}
	
	public MongoDatabase enterDB() throws IOException {
		tth = connect.getDatabase("TTH_Local");
		System.out.println(tth);
		
		return tth;
	}
	
	public Document getInstance(String instanceID) throws IOException {
		instanceCollection = tth.getCollection("Instance");
		Document instance = instanceCollection.find(eq("instance_id", instanceID)).first();
		System.out.println("for");
		System.out.print(instance);
		return instance;
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
	
	public ArrayList<Document> getCells() throws IOException {
			cellCollection = tth.getCollection("Cell");
			ArrayList<Document> cellArray = new ArrayList<Document>();
			MongoCursor<Document> cursor = cellCollection.find().iterator();
			try {
			    while (cursor.hasNext()) {
			    		Document tempDoc = cellCollection.find(eq("instance_id", "DN001")).first();
			    		cursor.next();
			    		cellArray.add(tempDoc);
			    }
			} finally {
			    cursor.close();
			}
			for(int i = 0; i<cellArray.size(); i++) {
				System.out.println("for");
				System.out.print(cellArray.get(i));
			}
			return cellArray;
		
	}
	
	public void getItem() throws IOException {
		
	}
	
	public void loadInstance(String instanceID) throws IOException {
		connectToDB();
		enterDB();
		getInstance(instanceID);
		getCells();
		getEntity();
		getItem();
		
	}
}
