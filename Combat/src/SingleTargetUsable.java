
/**
 *
 * @author Jason Richter, Samuel Fiscus
 */

import java.util.ArrayList;

public abstract class SingleTargetUsable extends Usable{

    public SingleTargetUsable() {
    }

    public SingleTargetUsable(int potency, String name) {
        super(potency, name);
    }

    public SingleTargetUsable(int potency, String name, String description) {
        super(potency, name, description);
    }

    

    
    
    @Override
    public abstract void singleTarget(Entity x);

    @Override
    public void multiTarget(ArrayList<Entity> group) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void omniTarget(Encounter enc) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}//end SingleTargetItem
