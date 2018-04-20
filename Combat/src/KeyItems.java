/*
 * authors: Emily Clark
 */
public class KeyItems implements KeyItemsADT {

	private String name;
	private String description;
	private String id;
	
	public KeyItems()
	{
		//empty constructor
	}
	
	/*
	 * @overload constructor
	 */
	public KeyItems(String name, String description, String id)
	{
		this.name = name;
		this.description = description;
		this.id = id;
	}
	
	/* get Name of important game item
	 * @param none
	 * @return String that shows user-friendly name of object.
	 */
	public String getName()
	{
		return name;
	}
	
	/* get Description of important game item
	 * @param none
	 * @return String that shows user-friendly description of object.
	 */
	public String getDescription()
	{
		return description;
	}
	
	/*
	 * get ID of keyItem for game logic
	 * @param none
	 * @return String that shows ID for comparative purposes
	 */
	public String getID()
	{
		return id;
	}
	
	/*
	 * @override toString
	 */
	public String toString()
	{
	    String formatString = "* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *\n\n"
	    		+ "   " + this.getName() + "\n"
	    		+ "\n"
	    		+ this.getDescription() + "\n\n"
	    		+ "* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *\n";
		
		return formatString;
	}
}//end class
