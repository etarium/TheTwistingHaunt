
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
	 * Generates the entire instance of cells as an arraylist of completed objects.
	 * @param ArrayList<Cell>
	 * @param Cell Instance MUST be created prior to searching for any items within the instance!
	 * Once both have been received, please use comparator logic to appropriately utilize objects "within" the cells.
	 * @return ArrayList<Usable>
	 */
	public ArrayList<Usable> getHPUsableInstance(ArrayList<Cell> cellobj) throws SQLException, IOException;
	
	/**
	 * Generates the entire instance of cells as an arraylist of completed objects.
	 * @param ArrayList<Cell>
	 * @param ArrayList<Usable>
	 * @param Cell Instance MUST be created prior to searching for any items within the instance!
	 * @param HP Usables MUST be created prior to searching for any SP Usables!
	 * Once both have been received, please use comparator logic to appropriately utilize objects "within" the cells.
	 * @return ArrayList<Usable>
	 */
	public ArrayList<Usable> getSPUsableInstance(ArrayList<Cell> cellobj, ArrayList<Usable> usableobj) throws SQLException, IOException;
	
	/**
	 * Generates the entire instance of cells as an arraylist of completed objects.
	 * @param ArrayList<Cell>
	 * @param Cell Instance MUST be created prior to searching for any items within the instance!
	 * Once both have been received, please use comparator logic to appropriately utilize objects "within" the cells.
	 * @return ArrayList<Equipable>
	 */
	public ArrayList<Equipable> getArmorInstance(ArrayList<Cell> cellobj) throws SQLException, IOException;
	
	
	/**
	 * Generates the entire instance of cells as an arraylist of completed objects.
	 * @param ArrayList<Cell>
	 * @param Cell Instance MUST be created prior to searching for any items within the instance!
	 * Once both have been received, please use comparator logic to appropriately utilize objects "within" the cells.
	 * @return ArrayList<Encounter>
	 */
	public ArrayList<Encounter> getEncounterInstance(ArrayList<Cell> cellobj) throws SQLException, IOException;
}