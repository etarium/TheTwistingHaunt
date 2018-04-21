package game;

import java.util.ArrayList;

/**
 *
 * @author Jason Richter, Samuel Fiscus
 */
public abstract class SpecAttack_SingleTarget extends SpecAttack{

    /**
     * Empty constructor for SpecAttack_SingleTarget item.
     */
    public SpecAttack_SingleTarget() {
    }

    /**
     * Partial constructor for SpecAttack_SingleTarget item.
     * @param potency Integer representing potency of SpecAttack_SingleTarget
     * @param name String representing name of SpecAttack_SingleTarget
     */
    public SpecAttack_SingleTarget(int potency, String name) {
        super(potency, name);
    }

    /**
     * Filled constructor for SpecAttack_SingleTarget item.
     * @param potency Integer representing potency of SpecAttack_SingleTarget
     * @param name String representing name of SpecAttack_SingleTarget
     * @param description String representing description of SpecAttack_SingleTarget
     */
    public SpecAttack_SingleTarget(int potency, String name, String description) {
        super(potency, name, description);
    }
    
    

    @Override
    public abstract void singleTarget(Entity target);

    @Override
    public void multiTarget(ArrayList<Entity> group) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
