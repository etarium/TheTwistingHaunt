package game;

/*
 * The Twisting Haunt
 * Emily Clark
 * 4-10-18
 * List of commonly queried items to return as a string for prepared statements.
 */
public class QueryDB {

	private String query;
	
	//get cell description query stored as string
	public String getCell()
	{
		 query = "SELECT Xcoord, YCoord, ZCoord, Description, Encounters, Items, KeyItems, ReqItem\n"
		    		+ "FROM thaunt_test.Cell\n"
		    		+ "WHERE XCoord = ? AND YCoord = ? AND ZCoord = ? ; ";
		 return query;
	}
	
	public String getCellInst()
	{
		query = "SELECT * \n"
				+ "FROM thaunt_test.Cell\n"
				+ "WHERE Instance = ? ;";
		return query;
	}
	
	public String getEncounterInst()
	{
		query = "SELECT * \n" + 
				"\n" + 
				"FROM\n" + 
				"( \n" + 
				"	SELECT *\n" + 
				"    FROM thaunt_test.Encounters\n" + 
				"    JOIN\n" + 
				"	(\n" + 
				"		SELECT *\n" + 
				"        FROM thaunt_test.Entities\n" + 
				"	) as entityList USING (EntID)\n" + 
				"    JOIN\n" + 
				"    (\n" + 
				"		SELECT *\n" + 
				"        FROM thaunt_test.BaseStats\n" + 
				"	) as entityState USING (BaseStats)\n" + 
				") as EntityObject \n"
				+ "WHERE EncounterID = ? ;";
		return query;
	}
	
	public String getHPUsableInst()
	{
		query = "SELECT Potency, ItemName, ItemDescription, ItemID\n" + 
				"FROM thaunt_test.Useables\n" + 
				"WHERE ItemID = ? AND StatAffected = 'HP' ;";
		
		return query;
	}
	
	public String getSPUsableInst()
	{
		query = "SELECT Potency, ItemName, ItemDescription, ItemID\n" + 
				"FROM thaunt_test.Useables\n" + 
				"WHERE ItemID = ? AND StatAffected = 'MP' ;";
		
		return query;
	}
	
	public String getEquipableInst()
	{
		query = "SELECT *\n" + 
				"FROM thaunt_test.Equipables\n" + 
				"WHERE ItemID = ?;";
		return query;
	}
	//get Cell items query stored as string
	public String getUseable()
	{
		 query = "SELECT Potency, ItemName, ItemDescription\n"
		    		+ "FROM thaunt_test.Useables\n"
		    		+ "WHERE ItemID = ? ";
		 return query;
	}
	
	public String getEquipable()
	{
		 query = "SELECT Potency, ItemName, ItemDescription\n"
		    		+ "FROM thaunt_test.Equipables\n"
		    		+ "WHERE ItemID = ? ";
		 return query;
	}
	
	public String getKeyItems()
	{
		query = "SELECT ItemName, ItemDescription, KeyItemID\n"
	    		+ "FROM thaunt_test.KeyItems\n"
	    		+ "WHERE KeyItemID = ? ";
		
		return query;
	}
	
	public String getEncounterTeam()
	{
		query = "SELECT NPC1, NPC2, NPC3, NPC4, NPC5\n"
	    		+ "FROM thaunt_test.Encounters\n"
	    		+ "WHERE EncounterID = ? ";
		
		return query;
	}
	
	public String getAggroEntity()
	{
		String query = "SELECT EntID, EntName, EntDescription, BaseStats\n"
	    		+ "FROM thaunt_test.Entities\n"
	    		+ "WHERE EntID = ? ";
		
		return query;
	}
	
	public String getAggroEntType()
	{
		String query = "SELECT EntName, EntDescription\n"
	    		+ "FROM thaunt_test.EntType\n"
	    		+ "WHERE TypeID = ? ";
		
		return query;
	}
	
	public String getStatBlock()
	{
		String query = "SELECT CURHP, HP, MP, DEF, EVA, ATK, INIT\n"
	    		+ "FROM thaunt_test.BaseStats\n"
	    		+ "WHERE StatBlockID = ? ";
		
		return query;
	}

}
