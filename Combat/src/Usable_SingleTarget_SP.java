
/**
 *
 * @author Emily Clark
 */
public class Usable_SingleTarget_SP extends Usable_SingleTarget{

    //constructors
    /**
     * ESPty constructor for Usable_SingleTarget_HP item.
     */
    public Usable_SingleTarget_SP() {
    }

    /**
     * Partial constructor for Usable_SingleTarget_SP item.
     * @param potency Integer representing potency of Usable_SingleTarget_SP
     * @param name String representing name of Usable_SingleTarget_SP
     */
    public Usable_SingleTarget_SP(int potency, String name) {
        super(potency, name);
    }

    /**
     * Filled constructor for Usable_SingleTarget_SP item.
     * @param potency Integer representing potency of Usable_SingleTarget_SP
     * @param name String representing name of Usable_SingleTarget_SP
     * @param description String representing description of Usable_SingleTarget_SP
     */
    public Usable_SingleTarget_SP(int potency, String name, String description) {
        super(potency, name, description);
    }
    /**
     * Filled constructor for Usable_SingleTarget_SP item.
     * @param potency Integer representing potency of Usable_SingleTarget_SP
     * @param name String representing name of Usable_SingleTarget_SP
     * @param description String representing description of Usable_SingleTarget_SP
     * @param id String representing the primary key within the database for Usable object.
     */
    public Usable_SingleTarget_SP(int potency, String name, String description, String id) {
        super(potency, name, description, id);
    }
    

    
    
    @Override
    public void singleTarget(Entity target) {
        int oldSP = target.getStats().getCurrentSP();
        int maxSP = target.getStats().getSpecPoints();
        int newSP = oldSP + potency;

        //if newSP greater than maxSP, target at full health
        //otherwise, newHP replaces old value
        int val = (maxSP > newSP) ? newSP : maxSP;

        target.getStats().setCurrentHealth(val);
        //outputs "HP [  x --> y  ]"
        System.out.println("MP[  " + oldSP + " --> " + val + "  ]");
        
    }
    
    /*
     * @Override toString
     */
    public String toString()
    {
    		String stat = "Stat: MP";
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