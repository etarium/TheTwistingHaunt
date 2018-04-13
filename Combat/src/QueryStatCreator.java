
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import databaseconnector.CredentialIOConfig;
import databaseconnector.DBConnect;

/*
 * The Twisting Haunt
 * Emily Clark
 * 4-10-18
 * Creates objects on behalf of the QueryMachine
 */
public class QueryStatCreator {
	DBConnect dbReader = new DBConnect();
    CredentialIOConfig credIO = new CredentialIOConfig();
    QueryDB generator = new QueryDB();
    ResultSet resultSet = null;
    String res = "";
    String varOne = "";
    
    public QueryStatCreator()
    {
    	//empty constructor
    }

	public StatBlock makeStatBlock(String pkid) throws SQLException, IOException
	{
		StatBlock tempSB = new StatBlock();
		varOne = pkid;
		PreparedStatement pstmt = dbReader.Connect(credIO.getUser(), credIO.getPass()).prepareStatement(generator.getStatBlock());
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
    	 		tempSB = new StatBlock(curhp, hp, mp, def, eva, atk, init);

		}
		return tempSB;
	}//end makeStatBlock
	
}
