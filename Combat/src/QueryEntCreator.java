
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
public class QueryEntCreator {
	
	DBConnect dbReader = new DBConnect();
    CredentialIOConfig credIO = new CredentialIOConfig();
    QueryDB generator = new QueryDB();
    ResultSet resultSet = null;
    String res = "";
    String varOne = "";
	public QueryEntCreator()
	{
		//empty constructor
	}
	
	//does not return built object, returns array params to make object.
	public String[] makeEntities(String pkid) throws SQLException, IOException
	{
		String[] entParam = new String[4];
		varOne = pkid;
		PreparedStatement pstmt = dbReader.Connect(credIO.getUser(), credIO.getPass()).prepareStatement(generator.getAggroEntity());
		pstmt.setString( 1, varOne);
		resultSet = pstmt.executeQuery();
		while(resultSet.next())
		{
			String entID = resultSet.getString("EntID");
			String entName = resultSet.getString("EntName");
			String entDesc = resultSet.getString("EntDescription");
			String baseStat = resultSet.getString("BaseStats");
			
			
			entParam = new String[] {baseStat, entName, entDesc, entID};
			
		}
		return entParam;
	}
}
