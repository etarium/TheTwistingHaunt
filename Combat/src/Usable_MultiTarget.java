
/**
 *
 * @author Jason Richter, Samuel Fiscus
 */

import java.util.ArrayList;

public abstract class Usable_MultiTarget extends Usable {

    //constructors
    public Usable_MultiTarget() {
    }

    public Usable_MultiTarget(int potency, String name) {
        super(potency, name);
    }

    public Usable_MultiTarget(int potency, String name, String description) {
        super(potency, name, description);
    }

    //class methods
    @Override
    public void singleTarget(Entity target) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public abstract void multiTarget(ArrayList<Entity> group);
     
}
