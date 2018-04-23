package querymachine;
/*
 * The Twisting Haunt
 * Emily Clark
 * 4-10-18
 * Does the heavy lifting utilizing database package and is class that is directly called upon in game logic.
 */
import java.util.ArrayList;

import javax.swing.JTextArea;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import databaseconnector.CredentialIOConfig;
import databaseconnector.DBConnect;
import game.Cell;
import game.Encounter;
import game.Entity;
import game.Equipable;
import game.Equipable_Armor;
import game.KeyItems;
import game.StatBlock;
import game.Usable;
import game.Usable_SingleTarget_HP;
import game.Usable_SingleTarget_SP;

public class QueryMachine implements QueryMachineADT
{
	protected DBConnect dbReader = new DBConnect();
    protected CredentialIOConfig credIO = new CredentialIOConfig();
    protected QueryDB generator = new QueryDB();
    protected ResultSet resultSet = null;
    private String varOne = "";
    protected JTextArea output;


    
    public QueryMachine()
    {
    	//empty constructor
    	//this.output = output;
    }
    
    /**
	 * Generates the entire instance of cells as an arraylist of completed objects.
	 * @param String instanceID
	 * @param above values is the primary key for the instance within the DB.
	 * @return ArrayList<Cell>
	 */	
    public ArrayList<Cell> getCellInstance(String instance) throws SQLException, IOException
    {
    		ArrayList<Cell> cellInst = new ArrayList<Cell>();
    		
		varOne = instance;
		PreparedStatement pstmt = dbReader.Connect(credIO.getUser(), credIO.getPass()).prepareStatement(generator.getCellInst());
		pstmt.setString( 1, varOne);

		resultSet = pstmt.executeQuery();
		while(resultSet.next())
		{
			// this part here will allow items that query lists to populate
			
			String xString = resultSet.getString("XCoord");
			String yString = resultSet.getString("YCoord");
			String zString = resultSet.getString("ZCoord");
			String instanceID = resultSet.getString("Instance");
			String description = resultSet.getString("Description");
			String encounters = resultSet.getString("Encounters");
			String items = resultSet.getString("Items");
			String keyItems = resultSet.getString("KeyItems");
			String reqItem = resultSet.getString("ReqItem");
			String canN = resultSet.getString("N");
			String canS = resultSet.getString("S");
			String canE = resultSet.getString("E");
			String canW = resultSet.getString("W");
			
			int x = Integer.parseInt(xString);
			int y = Integer.parseInt(yString);
			int z = Integer.parseInt(zString);
			boolean tempN = Boolean.parseBoolean(canN);
			boolean tempS = Boolean.parseBoolean(canS);
			boolean tempE = Boolean.parseBoolean(canE);
			boolean tempW = Boolean.parseBoolean(canW);
			Cell tempCell = new Cell(x, y, z, description, instanceID, encounters, items, keyItems, reqItem, tempN, tempS, tempE, tempW );
			cellInst.add(tempCell);
			//System.out.print(".");
			output.append(".");
			
		}//end while
		
		return cellInst;
    	
    }
   
    /*
     * Parses the Cell ArrayList from the DB into a 3D array for navigational purposes.
     * @param ArrayList<Cell>
     * @return Cell[][][]
     */
    public Cell[][][] getCellArray(ArrayList<Cell> cellobj)
    {
            Cell[][][] cellArray = new Cell[10][10][10];
        for(int i=0; i<cellobj.size(); i++)
            {
                System.out.print(".");
                int x = cellobj.get(i).getLocation().getX();
                int y = cellobj.get(i).getLocation().getY();
                int z = cellobj.get(i).getLocation().getZ();
                cellArray [x][y][z] = cellobj.get(i);
        }
        
        return cellArray;
    }
    
    /**
	 * Generates the entire instance of cells as an arraylist of completed objects.
	 * @param ArrayList<Cell>
	 * @param Cell Instance MUST be created prior to searching for any items within the instance!
	 * Once both have been received, please use comparator logic to appropriately utilize objects "within" the cells.
	 * @return ArrayList<Encounter>
	 */
    public ArrayList<Encounter> getEncounterInstance(ArrayList<Cell> cellobj) throws SQLException, IOException
    {
    		ArrayList<Encounter> encounterInst = new ArrayList<Encounter>();
    		ArrayList<Entity> battleList = new ArrayList<Entity>();
    		Encounter tempEnc = new Encounter();
    		//loops. connects to database multiple times.
    		for(int i=0; i<cellobj.size(); i++)
    		{
    			
    		varOne = cellobj.get(i).getEncounter();
    		if(varOne.equalsIgnoreCase(""))
    		{
    			//do nothing but iterate one more in loop
    		}
    		else
    		{
		
		PreparedStatement pstmt = dbReader.Connect(credIO.getUser(), credIO.getPass()).prepareStatement(generator.getEncounterInst());
		pstmt.setString( 1, varOne);

		resultSet = pstmt.executeQuery();
		while(resultSet.next())
		{
			// this part here will allow items that query lists to populate
			int curhp = Integer.parseInt(resultSet.getString("CURHP"));
	 		int hp = Integer.parseInt(resultSet.getString("HP"));
	 		int mp = Integer.parseInt(resultSet.getString("MP"));
	 		int def = Integer.parseInt(resultSet.getString("DEF"));
	 		int eva = Integer.parseInt(resultSet.getString("EVA"));
	 		int atk = Integer.parseInt(resultSet.getString("ATK"));
	 		int init = Integer.parseInt(resultSet.getString("INIT"));
	 		int currentsp = mp;
	 		StatBlock tempSB = new StatBlock(curhp, hp, mp, def, eva, atk, init, currentsp);
	 		String name = resultSet.getString("EntName");
			String description = resultSet.getString("EntDescription");
			String teamID = resultSet.getString("EncounterID");
			
			Entity tempEntity = new Entity(tempSB, name, description, teamID);
			battleList.add(tempEntity);
			
			System.out.print(".");
		}//end while
			tempEnc = new Encounter(battleList);
			encounterInst.add(tempEnc);
			battleList.clear();
			System.out.print("...");
    		}
    		
    		
    		} //end for loop
		return encounterInst;
    	
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
 
    public ArrayList<Usable> getHPUsableInstance(ArrayList<Cell> cellobj) throws SQLException, IOException
	{
    		ArrayList<Usable> usableInst = new ArrayList<Usable>();
    		Usable_SingleTarget_HP tempUsable = new Usable_SingleTarget_HP();
		//loops. connects to database multiple times.
		for(int i=0; i<cellobj.size(); i++)
		{
			varOne = cellobj.get(i).getItem();
			System.out.print(".");
			
			if(varOne.equalsIgnoreCase(""))
			{
				//do nothing but iterate one more in loop
			}
			else
			{
	
				PreparedStatement pstmt = dbReader.Connect(credIO.getUser(), credIO.getPass()).prepareStatement(generator.getHPUsableInst());
				pstmt.setString( 1, varOne);

				resultSet = pstmt.executeQuery();
				while(resultSet.next())
				{
					// this part here will allow items that query lists to populate
					
					String potencyString = resultSet.getString("Potency");
					String name = resultSet.getString("ItemName");
					String description = resultSet.getString("ItemDescription");
					String id = resultSet.getString("ItemID");
			
					int potency = Integer.parseInt(potencyString);
			
					tempUsable = new Usable_SingleTarget_HP(potency, name, description, id);
					usableInst.add(tempUsable);
					
				}
			}
		}
		return usableInst;
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
   public ArrayList<Usable> getSPUsableInstance(ArrayList<Cell> cellobj, ArrayList<Usable> usableInst) throws SQLException, IOException
   {
    
	Usable_SingleTarget_SP tempUsable = new Usable_SingleTarget_SP();
	//loops. connects to database multiple times.
	for(int i=0; i<cellobj.size(); i++)
	{
		
		varOne = cellobj.get(i).getItem();
		System.out.print(".");
	
		if(varOne.equalsIgnoreCase(""))
		{
		//do nothing but iterate one more in loop
		}
		else if(varOne.startsWith("HP"))
		{
			//do nothing but iterate one more. This is to prevent connections to db for anything other than SP.
		}
		else
		{

			PreparedStatement pstmt = dbReader.Connect(credIO.getUser(), credIO.getPass()).prepareStatement(generator.getSPUsableInst());
			pstmt.setString( 1, varOne);

			resultSet = pstmt.executeQuery();
			while(resultSet.next())
			{
				// this part here will allow items that query lists to populate
			
				String potencyString = resultSet.getString("Potency");
				String name = resultSet.getString("ItemName");
				String description = resultSet.getString("ItemDescription");
				String id = resultSet.getString("ItemID");
	
				int potency = Integer.parseInt(potencyString);
	
				tempUsable = new Usable_SingleTarget_SP(potency, name, description, id);
				usableInst.add(tempUsable);
				
			}
		}
	}
	return usableInst;
   }
	/**
	 * Generates the entire instance of cells as an arraylist of completed objects.
	 * @param ArrayList<Cell>
	 * @param Cell Instance MUST be created prior to searching for any items within the instance!
	 * Once both have been received, please use comparator logic to appropriately utilize objects "within" the cells.
	 * @return ArrayList<Equipable>
	 */
	public ArrayList<Equipable> getArmorInstance(ArrayList<Cell> cellobj) throws SQLException, IOException
	{
		ArrayList<Equipable> equipInst = new ArrayList<Equipable>();
		Equipable_Armor tempEquipable = new Equipable_Armor();
		//loops. connects to database multiple times.
		for(int i=0; i<cellobj.size(); i++)
		{
			varOne = cellobj.get(i).getItem();
			System.out.print(".");
		
			if(varOne.equalsIgnoreCase(""))
			{
			//do nothing but iterate one more in loop
			}
			else if(varOne.startsWith("HP"))
			{
				//do nothing but iterate one more. This is to prevent connections to db for anything other than armor.
			}
			else if(varOne.startsWith("MP"))
			{
				//do nothing but iterate one more. This is to prevent connections to db for anything other than armor.
			}
			else
			{

				PreparedStatement pstmt = dbReader.Connect(credIO.getUser(), credIO.getPass()).prepareStatement(generator.getEquipableInst());
				pstmt.setString( 1, varOne);

				resultSet = pstmt.executeQuery();
				while(resultSet.next())
				{
					// this part here will allow items that query lists to populate
				
					String potencyString = resultSet.getString("Potency");
					String name = resultSet.getString("ItemName");
					String description = resultSet.getString("ItemDescription");
					String id = resultSet.getString("ItemID");
		
					int potency = Integer.parseInt(potencyString);
		
					tempEquipable = new Equipable_Armor(potency, name, description, id);
					equipInst.add(tempEquipable);
					
				}
			}
		}
		return equipInst;
	}

	/**
	 * Generates the entire instance of Key Items as an arraylist of completed objects.
	 * @param ArrayList<Cell>
	 * @param Cell Instance MUST be created prior to searching for any items within the instance!
	 * Once both have been received, please use comparator logic to appropriately utilize objects "within" the cells.
	 * @return ArrayList<KeyITems>
	 */
	public ArrayList<KeyItems> getKeyItemsInstance(ArrayList<Cell> cellobj) throws SQLException, IOException
	{
		ArrayList<KeyItems> keyItemsInst = new ArrayList<KeyItems>();
		KeyItems tempKeyItem = new KeyItems();
	//loops. connects to database multiple times.
	for(int i=0; i<cellobj.size(); i++)
	{
		varOne = cellobj.get(i).getKeyItem();
		System.out.print(".");
		
		if(varOne.equalsIgnoreCase(""))
		{
			//do nothing but iterate one more in loop
		}
		else
		{

			PreparedStatement pstmt = dbReader.Connect(credIO.getUser(), credIO.getPass()).prepareStatement(generator.getKeyItems());
			pstmt.setString( 1, varOne);

			resultSet = pstmt.executeQuery();
			while(resultSet.next())
			{
				// this part here will allow items that query lists to populate
				
				String name = resultSet.getString("ItemName");
				String description = resultSet.getString("ItemDescription");
				String id = resultSet.getString("KeyItemID");
		
				tempKeyItem = new KeyItems(name, description, id);
				keyItemsInst.add(tempKeyItem);
				
			}
		}
	}
	return keyItemsInst;
	}
	
}//end class