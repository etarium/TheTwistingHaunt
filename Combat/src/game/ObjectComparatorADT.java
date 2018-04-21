package game;
import java.util.ArrayList;

/*
 * @author Emily Clark
 */
public interface ObjectComparatorADT {
	
	
	/**
	 * Searches the Usable ArrayList for the object listed in Cell at a current location.
	 * @param String item
	 * @param ArrayList usableobj
	 * @return integer listing the index location in Array of desired object.
	 * @return will return -1 if item is not found.
	 */
	public int IsPresentUsable(String item, ArrayList<Usable> usableobj);
	
	
	/**
	 * Searches the Equipable ArrayList for the object listed in Cell at a current location.
	 * @param String item
	 * @param ArrayList equipbj
	 * @return integer listing the index location in Array of desired object.
	 * @return will return -1 if item is not found.
	 */
	public int IsPresentEquipable(String item, ArrayList<Equipable> equipobj);
	
	
	/**
	 * Searches the KeyItems ArrayList for the object listed in Cell at a current location.
	 * @param String item
	 * @param ArrayList keyitemobj
	 * @return integer listing the index location in Array of desired object.
	 * @return will return -1 if item is not found.
	 */
	public int IsPresentKeyItem(String item, ArrayList<KeyItems> keyitemobj);
	
	/**
	 * Returns a Equipable object
	 * @param String item
	 * @param ArrayList equipobj
	 * @return Equipable object
	 */
	public Equipable EquipableItemFound(String item, ArrayList<Equipable> equipobj);
	
	/**
	 * Returns a Usable object
	 * @param String item
	 * @param ArrayList usableobj
	 * @return Usable object
	 */
	public Usable UsableItemFound(String item, ArrayList<Usable> usableobj);
	
	/**
	 * Returns a KeyItems object
	 * @param String item
	 * @param ArrayList keyitemobj
	 * @return KeyItems object
	 */
	public KeyItems KeyItemFound(String item, ArrayList<KeyItems >keyitemobj);
	
}
