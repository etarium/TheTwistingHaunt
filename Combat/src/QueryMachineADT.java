import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

/*
 * QueryMachineADT
 * The Twisting Haunt
 * Emily Clark
 * 4-10-18
 * Documentation for how to use the QueryMachine class within the game.
 */
public interface QueryMachineADT 
{
	/**
	 * Generates the entire instance of cells as an arraylist of completed objects.
	 * @param String instanceID
	 * @param above values is the primary key for the instance within the DB.
	 * @return ArrayList<Cell>
	 */	
	public ArrayList<Cell> getCellInstance(String instance) throws SQLException, IOException;
	
	
	/**
	 * Generates the entire instance of HP Usables as an arraylist of completed objects.
	 * @param ArrayList<Cell>
	 * @param Cell Instance MUST be created prior to searching for any items within the instance!
	 * Once both have been received, please use comparator logic to appropriately utilize objects "within" the cells.
	 * @return ArrayList<Usable>
	 */
	public ArrayList<Usable> getHPUsableInstance(ArrayList<Cell> cellobj) throws SQLException, IOException;
	
	/**
	 * Generates the entire instance of SP Usables as an arraylist of completed objects.
	 * @param ArrayList<Cell>
	 * @param ArrayList<Usable>
	 * @param Cell Instance MUST be created prior to searching for any items within the instance!
	 * @param HP Usables MUST be created prior to searching for any SP Usables!
	 * SP Usables will Add onto ArrayList<Usable> that was generated from HPUSable() !
	 * Once both have been received, please use comparator logic to appropriately utilize objects "within" the cells.
	 * @return ArrayList<Usable>
	 */
	public ArrayList<Usable> getSPUsableInstance(ArrayList<Cell> cellobj, ArrayList<Usable> usableobj) throws SQLException, IOException;
	
	/**
	 * Generates the entire instance of Equipable Armor as an arraylist of completed objects.
	 * @param ArrayList<Cell>
	 * @param Cell Instance MUST be created prior to searching for any items within the instance!
	 * Once both have been received, please use comparator logic to appropriately utilize objects "within" the cells.
	 * @return ArrayList<Equipable>
	 */
	public ArrayList<Equipable> getArmorInstance(ArrayList<Cell> cellobj) throws SQLException, IOException;
	
	
	/**
	 * Generates the entire instance of Encounters as an arraylist of completed objects.
	 * @param ArrayList<Cell>
	 * @param Cell Instance MUST be created prior to searching for any items within the instance!
	 * Once both have been received, please use comparator logic to appropriately utilize objects "within" the cells.
	 * @return ArrayList<Encounter>
	 */
	public ArrayList<Encounter> getEncounterInstance(ArrayList<Cell> cellobj) throws SQLException, IOException;
	
	/**
	 * Generates the entire instance of Key Items as an arraylist of completed objects.
	 * @param ArrayList<Cell>
	 * @param Cell Instance MUST be created prior to searching for any items within the instance!
	 * Once both have been received, please use comparator logic to appropriately utilize objects "within" the cells.
	 * @return ArrayList<KeyITems>
	 */
	public ArrayList<KeyItems> getKeyItemsInstance(ArrayList<Cell> cellobj) throws SQLException, IOException;

}//end interface

/**
 * * * * * HOW TO USE * * * * *
 * As you can see, all above methods declared return ArrayLists of items.
 * You will want to run all of these methods when loading any new instance.
 * 'Instances' are defined here based on a RDBMS that contains a table called Instance that sorts
 * various locations and areas of in-game activity.
 * Run in order of ADT and you will have a good time. The only required order is "Cell" and then "HP Usables".
 * Above requirement is due to some objects piggy-backing off attributes found within the first two methods.
 * Appropriate Getters & Setters exist for every individual object that is generated from this class. Please
 * refer to their documentation for how to use.
 * I strongly recommend using a string comparator for many of the interactions you may have with these ArrayLists
 * if you do not plan on serializing the objects and using as-is.
 * 
 * These series of methods are made with the expectation of latency from a remote server and designed appropriately.
 * * * * * * * * * * * * * * * *
 * 
 * Thank you, have a nice day!
 * Emily Clark
 */
