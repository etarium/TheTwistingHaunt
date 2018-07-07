package game;

import java.io.Serializable;

/*
 * authors: Emily Clark
 */
public class KeyItems implements KeyItemsADT, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1167088786121038693L;
	private String name;
	private String description;
	private String id;
	private int reqQuantity;
	
	public KeyItems()
	{
		//empty constructor
	}
	
	/*
	 * @overload constructor
	 */
	public KeyItems(String name, String description, String id, int reqQuantity)
	{
		this.name = name;
		this.description = description;
		this.id = id;
		reqQuantity = 0;
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
