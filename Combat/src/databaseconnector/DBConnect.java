package databaseconnector;
import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {

	public DBConnect()
	{
		
	}

	public Connection Connect(String user, String pass)
	{
	//connect to DB
	  Connection conn = null;

     try
     {

         String url = "jdbc:mysql://etariumtwistinghaunttest-3-26-18.ckqecz02zmjf.us-east-2.rds.amazonaws.com:3306/thaunt_test"+
 				"?verifyServerCertificate=false"+
 				"&useSSL=true"+
 				"&requireSSL=true";
         Class.forName ("com.mysql.jdbc.Driver");
         conn = DriverManager.getConnection (url, user, pass);
         System.out.println ("Database connection established");
     }
     catch (Exception e)
     {
    	 	System.out.println("Failure to connect.");
         e.printStackTrace();

     }
     return conn;
	}//end Connect
	
	public void Terminate(Connection conn)
	{

	         if (conn != null)
	         {
	             try
	             {
	                 conn.close ();
	                 System.out.println ("Database connection terminated");
	             }
	             catch (Exception e) { /* ignore close errors */ }
	         }
	     }
}
