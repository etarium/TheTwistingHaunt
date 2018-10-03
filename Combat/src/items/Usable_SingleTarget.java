package items;

/**
 *
 * @author Jason Richter, Samuel Fiscus, Emily Clark
 */

import java.util.ArrayList;

import game.Entity;

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

    /**
     * Filled constructor for Usable_SingleTarget item.
     * @param potency Integer representing potency of Usable_SingleTarget
     * @param name String representing name of Usable_SingleTarget
     * @param description String representing description of Usable_SingleTarget
     * @param id String representing the primary key within the database for Usable object.
     */
    public Usable_SingleTarget(int potency, String name, String description, String id) {
        super(potency, name, description, id);
    }


    
    
    @Override
    public abstract String singleTarget(Entity target);

    @Override
    public String multiTarget(ArrayList<Entity> group) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
}//end SingleTargetItem
