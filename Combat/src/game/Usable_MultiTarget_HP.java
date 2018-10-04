package game;

import java.util.ArrayList;

/**
 *
 * @author Jason Richter, Samuel Fiscus
 */
public class Usable_MultiTarget_HP extends Usable_MultiTarget{

    
    //constructors
    /**
     * Empty constructor for Equipable item.
     */
    public Usable_MultiTarget_HP() {
    }

    /**
     * Partial constructor for Usable_MultiTarget_HP item.
     * @param potency Integer representing potency of Usable_MultiTarget_HP
     * @param name String representing name of Usable_MultiTarget_HP
     */
    public Usable_MultiTarget_HP(int potency, String name) {
        super(potency, name);
    }

    /**
     * Filled constructor for Usable_MultiTarget_HP item.
     * @param potency Integer representing potency of Usable_MultiTarget_HP
     * @param name String representing name of Usable_MultiTarget_HP
     * @param description String representing description of Usable_MultiTarget_HP
     */
    public Usable_MultiTarget_HP(int potency, String name, String description) {
        super(potency, name, description);
    }
    
    //class methods
    @Override
    public String multiTarget(ArrayList<Entity> group) {
        String output = "";
    		for (int i = 0; i < group.size(); i++) {
            String userName = group.get(i).getName();
    			int oldHP = group.get(i).getStats().getCurrentHealth();
            int maxHP = group.get(i).getStats().getMaxHealth();

            int newHP = oldHP + potency;

            //if newHP greater than maxHP, target at full health
            //otherwise, newHP replaces old value
            int val = (maxHP > newHP) ? newHP : maxHP;

            group.get(i).getStats().setCurrentHealth(val);
            output += userName + " HP[  " + oldHP + " --> " + val + "  ]\n";
        }
    		output +=  "\n\n   Press [ENTER] to continue...";
    		return output;
        
    }
    
    /*
     * @Override toString
     */
    public String toString()
    {
    		String stat = "Stat: HP";
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
