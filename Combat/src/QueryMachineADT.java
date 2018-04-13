
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
	 * Gets all parameters necessary to create a Cell object and returns parameters as array.
	 * @param int x
	 * @param int y
	 * @param int z
	 * @param above values are coordinates for Cell location.
	 * @return String [7]
	 * Will require parsing location 0, 1, 2 to int once called.
	 * Does NOT create the object.
	 * Connects to a remote database, queries data, parses into array, returns array.
	 */
	public String[] getCell(int x, int y, int z) throws SQLException, IOException;
	
	/**
	 * Gets all parameters necessary to create a Useable object and returns parameters as array.
	 * @param String pkid
	 * @param above value is primary key id that is retrieved from cell array, location 5
	 * @return String [3]
	 * Will require parsing location 0 to int once called.
	 * Does NOT create the object.
	 * Connects to a remote database, queries data, parses into array, returns array.
	 */
	public String[] getUseable(String pkid) throws SQLException, IOException;
	
	/**
	 * Gets all parameters necessary to create a Equipable object and returns parameters as array.
	 * @param String pkid
	 * @param above value is primary key id that is retrieved from cell array, location 5
	 * @return String [3]
	 * Will require parsing location 0 to int once called.
	 * Does NOT create the object.
	 * Connects to a remote database, queries data, parses into array, returns array.
	 */
	public String[] getEquipable(String pkid) throws SQLException, IOException;
	
	/**
	 * Gets all parameters necessary to create a KeyItem object and returns parameters as array.
	 * @param String pkid
	 * @param above value is primary key id that is retrieved from cell array, location 6.
	 * @return String [2]
	 * Does NOT create the object.
	 * Connects to a remote database, queries data, parses into array, returns array.
	 */
	
	public String[] getKeyItem(String pkid) throws SQLException, IOException;
	
	/**
	 * Gets all parameters necessary to create Entity objects, creates the objects, then passes them as an array
	 * @param String pkid
	 * @param above value is primary key id that is retrieved from cell array, location 4.
	 * @return ArrayList<Entity>
	 * DOES create StatBlock objects in order to construct Entity objects.
	 * DOES create Entity objects to populate arrayList.
	 * Connects to a remote database, queries data, creates object, parses into array, returns array.
	 */
	public ArrayList<Entity> getEncounter(String pkid) throws SQLException, IOException;
	
	/**
	 * Gets all parameters necessary to create Entity objects, creates the objects, then passes them as an array
	 * @param String pkid
	 * @param above value is primary key id that is retrieved from cell array, location 4.
	 * @return ArrayList<Entity>
	 * DOES create StatBlock objects in order to construct Entity objects.
	 * DOES create Entity objects to populate arrayList.
	 * Connects to a remote database, queries data, creates object, parses into array, returns array.
	 */
	public ArrayList<Entity> getEncounter2(String pkid) throws SQLException, IOException;
}
