/*
 * Author: Emily Clark
 * Purpose: Better organize the different methods being called upon to obtain data from DB.
 */
package querymachine;

import static com.mongodb.client.model.Filters.eq;

import java.io.IOException;
import java.util.ArrayList;

import org.bson.Document;

import com.google.gson.Gson;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.util.JSON.*;

import databaseconnector.DBConnect;
import game.Cell;

public class GetCells {
	private DBConnect connect = new DBConnect();
	private Gson gson = new Gson();
	private MongoDatabase tth;
	private MongoCollection<Document> cellCollection;
	private Cell tempCell = new Cell();
	private ArrayList<Cell> cellArray = new ArrayList<Cell>();
	private Utils utils = new Utils();


	public ArrayList<Cell> getCellArray(String instance_id) throws IOException {
		if(tth == null) {
			tth = connect.enterDB();
		}
		cellCollection = tth.getCollection("Cell");
		MongoCursor<Document> cursor = cellCollection.find().iterator();
		try {
			while (cursor.hasNext()) {
				Document tempDoc = cellCollection.find(eq("instance_id", instance_id)).first();
				String json = com.mongodb.util.JSON.serialize(tempDoc);
				json = utils.removeID(json);
				tempCell = gson.fromJson(json, Cell.class);
				cellArray.add(tempCell);
				cursor.next();
				

				return cellArray;
			}
		} finally {
			cursor.close();
		}
		

		return cellArray;
	}
	
	public Cell[][][] arrangeCells(ArrayList<Cell> cellArray) {
		
		Cell[][][] arrangedCells = new Cell[10][10][4];
        for(int i=0; i<cellArray.size(); i++)
            {
                System.out.print(".");
                int x = cellArray.get(i).getLocation().getX();
                int y = cellArray.get(i).getLocation().getY();
                int z = cellArray.get(i).getLocation().getZ();
                arrangedCells [x][y][z] = cellArray.get(i);
        }
        
        return arrangedCells;
	}
}

