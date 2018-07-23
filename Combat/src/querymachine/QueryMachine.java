package querymachine;
import java.io.IOException;
/*
 * The Twisting Haunt
 * Emily Clark
 * 4-10-18
 * Does the heavy lifting utilizing database package and is class that is directly called upon in game logic.
 */
import java.util.ArrayList;

import com.google.gson.Gson;

import game.Cell;
import game.Encounter;

import game.Equipable;

import game.KeyItems;

import game.Usable;


public class QueryMachine
{
	private Gson gson = new Gson();
	

    public QueryMachine()
    {
    	//empty constructor
    }
    
    /**
	 * Generates the entire instance of cells as an arraylist of completed objects.
	 * @param String instanceID
	 * @param above values is the primary key for the instance within the DB.
	 * @return ArrayList<Cell>
	 */	

   
    /*
     * Parses the Cell ArrayList from the DB into a 3D array for navigational purposes.
     * Currently only supports Z values 0-3.
     * @param ArrayList<Cell>
     * @return Cell[][][]
     */

    
    /**
	 * Generates the entire instance of cells as an arraylist of completed objects.
	 * @param ArrayList<Cell>
	 * @param Cell Instance MUST be created prior to searching for any items within the instance!
	 * Once both have been received, please use comparator logic to appropriately utilize objects "within" the cells.
	 * @return ArrayList<Encounter>
	 */
    public ArrayList<Encounter> getEncounterInstance(ArrayList<Cell> cellobj) throws IOException
    {
    	//TODO
    	return null;
    }

    
    /**
	 * Generates the entire instance of cells as an arraylist of completed objects.
	 * @param ArrayList<Cell>
	 * @param Cell Instance MUST be created prior to searching for any items within the instance!
	 * Once both have been received, please use comparator logic to appropriately utilize objects "within" the cells.
	 * This method only searched for items with StatAffected attribute set to 'HP'
	 * Additional methods will need to be run for all additional objects located within map.
	 * @return ArrayList<Usable>
	 */
 
    public ArrayList<Usable> getHPUsableInstance(ArrayList<Cell> cellobj) throws IOException
	{
    	//TODO
    	return null;
	}
    
    /**
	 * Generates the entire instance of cells as an arraylist of completed objects.
	 * @param ArrayList<Cell>
	 * @param ArrayList<Usable>
	 * @param Cell Instance MUST be created prior to searching for any items within the instance!
	 * @param HP Usables MUST be created prior to searching for any SP Usables!
	 * Once both have been received, please use comparator logic to appropriately utilize objects "within" the cells.
	 * @return ArrayList<Usable>
     * @throws IOException 
     * @throws SQLException 
	 */
   public ArrayList<Usable> getSPUsableInstance(ArrayList<Cell> cellobj, ArrayList<Usable> usableInst) throws IOException
   {
	 //TODO
		return null;
   }
	/**
	 * Generates the entire instance of cells as an arraylist of completed objects.
	 * @param ArrayList<Cell>
	 * @param Cell Instance MUST be created prior to searching for any items within the instance!
	 * Once both have been received, please use comparator logic to appropriately utilize objects "within" the cells.
	 * @return ArrayList<Equipable>
	 */
	public ArrayList<Equipable> getArmorInstance(ArrayList<Cell> cellobj) throws IOException
	{
		//TODO
		return null;
	}

	/**
	 * Generates the entire instance of Key Items as an arraylist of completed objects.
	 * @param ArrayList<Cell>
	 * @param Cell Instance MUST be created prior to searching for any items within the instance!
	 * Once both have been received, please use comparator logic to appropriately utilize objects "within" the cells.
	 * @return ArrayList<KeyITems>
	 */
	public ArrayList<KeyItems> getKeyItemsInstance(ArrayList<Cell> cellobj) throws IOException
	{
			//TODO
		return null;
	}

	public ArrayList<Cell> getCellInstance(String instance) {
		// TODO Auto-generated method stub
		return null;
	}
	
}//end class