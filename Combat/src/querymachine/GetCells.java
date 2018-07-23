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

import databaseconnector.DBConnect;
import game.Cell;

public class GetCells {
	private DBConnect connect = new DBConnect();
	private Gson gson = new Gson();
	private MongoDatabase tth;
	private MongoCollection<Document> cellCollection;
	private ArrayList<String> cellStringArray = new ArrayList<String>();

	private ArrayList<String> getCellStringArray(String instance_id) throws IOException {
		if(tth == null) {
			tth = connect.enterDB();
		}
		cellCollection = tth.getCollection("Cell");
		MongoCursor<Document> cursor = cellCollection.find().iterator();
		try {
			while (cursor.hasNext()) {
				String tempDoc = "" + cellCollection.find(eq("instance_id", instance_id)).first();
				cursor.next();
				cellStringArray.add(tempDoc);

				return cellStringArray;
			}
		} finally {
			cursor.close();
		}

		return cellStringArray;
	}

	private ArrayList<Cell> getAllCellsFromInstance(ArrayList<String> cellStringArray)
	{
		ArrayList<Cell> cellObjArray = new ArrayList<Cell>();
		for(int i=0; i < cellStringArray.size(); i++) {
			Cell tempCellObj = gson.fromJson(cellStringArray.get(i), Cell.class);
			cellObjArray.add(tempCellObj);
			System.out.println( cellStringArray.get(i).toString() );
		}
		return cellObjArray;
	}

	private Cell[][][] getCellMovementArray(ArrayList<Cell> cellObjArray)
	{
		Cell[][][] cellMovementArray = new Cell[10][10][4];
		for(int i=0; i<cellObjArray.size(); i++)
		{
			System.out.print(".");
			int x = cellObjArray.get(i).getLocation().getX();
			int y = cellObjArray.get(i).getLocation().getY();
			int z = cellObjArray.get(i).getLocation().getZ();
			cellMovementArray [x][y][z] = cellObjArray.get(i);
		}

		return cellMovementArray;
	}

	public Cell[][][] getCells (String instance_id) throws IOException {
		ArrayList<String> param1 = new ArrayList<String>();
		ArrayList<Cell> param2 = new ArrayList<Cell>();
		Cell[][][] output = new Cell[10][10][4];
		param1 = getCellStringArray(instance_id);
		param2 = getAllCellsFromInstance(param1);
		output = getCellMovementArray(param2);

		//test console log pls delete//
		for(int i = 0; i < param2.size(); i++) {
			System.out.println(param2.get(i));
		}
		return output;
	}
}

