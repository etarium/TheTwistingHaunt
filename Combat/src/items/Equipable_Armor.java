package items;

/**
 *
 * @author Jason Richter, Samuel Fiscus, Emily Clark
 */
public class Equipable_Armor extends Equipable{
    
    /**
     * Empty constructor for Armor item.
     */
    public Equipable_Armor() {
    }

    /**
     * Partial constructor for Armor item.
     * @param potency Integer representing potency of Armor
     * @param name String representing name of Armor
     */
    public Equipable_Armor(int potency, String name) {
        super(potency, name);
    }

    /**
     * Filled constructor for Armor item.
     * @param potency Integer representing potency of Armor
     * @param name String representing name of Armor
     * @param description String representing description of Armor
     */
    public Equipable_Armor(int potency, String name, String description) {
        super(potency, name, description);
    }
    
    /**
     * Filled constructor for Armor item.
     * @param potency Integer representing potency of Armor
     * @param name String representing name of Armor
     * @param description String representing description of Armor
     * id String representing the primary key within the database for Equipable object.
     */
    public Equipable_Armor(int potency, String name, String description, String id) {
        super(potency, name, description, id);
    }
    
    /*
     * @Override toString
     */
    public String toString()
    {
    		String stat = "Stat: DEF";
    	    String formatString = "* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *\n\n"
    	    		+ "   " + this.getName() + "             " + stat + "\n"
    	    		+ "\n"
    	    		+ this.getDescription() + "\n\n"
    	    		+ "   Potency: " + this.getPotency() + "\n"
    	    		+ "\n"
    	    		+ "* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *\n";
    		
    		return formatString;
    			
    }
}
