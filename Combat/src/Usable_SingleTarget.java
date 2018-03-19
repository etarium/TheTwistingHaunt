
/**
 *
 * @author Jason Richter, Samuel Fiscus
 */

import java.util.ArrayList;

public abstract class Usable_SingleTarget extends Usable{

    //constructor
    /**
     * Empty constructor for Usable_SingleTarget item.
     */
    public Usable_SingleTarget() {
    }

    /**
     * Partial constructor for Usable_SingleTarget item.
     * @param potency Integer representing potency of Usable_SingleTarget
     * @param name String representing name of Usable_SingleTarget
     */
    public Usable_SingleTarget(int potency, String name) {
        super(potency, name);
    }

    /**
     * Filled constructor for Usable_SingleTarget item.
     * @param potency Integer representing potency of Usable_SingleTarget
     * @param name String representing name of Usable_SingleTarget
     * @param description String representing description of Usable_SingleTarget
     */
    public Usable_SingleTarget(int potency, String name, String description) {
        super(potency, name, description);
    }

    

    
    
    @Override
    public abstract void singleTarget(Entity target);

    @Override
    public void multiTarget(ArrayList<Entity> group) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
}//end SingleTargetItem
