
/**
 *
 * @author Jason Richter, Samuel Fiscus
 */

import java.util.ArrayList;

public abstract class Usable_SingleTarget extends Usable{

    public Usable_SingleTarget() {
    }

    public Usable_SingleTarget(int potency, String name) {
        super(potency, name);
    }

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
