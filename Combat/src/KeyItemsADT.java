/*
 * authors: Emily Clark
 */
public interface KeyItemsADT {

	/* get Name of important game item
	 * @param none
	 * @return String that shows user-friendly name of object.
	 */
	public String getName();
	
	/* get Description of important game item
	 * @param none
	 * @return String that shows user-friendly description of object.
	 */
	public String getDescription();
	
	/*
	 * get ID of keyItem for game logic
	 * @param none
	 * @return String that shows ID for comparative purposes
	 */
	public String getID();
}//end interface 
