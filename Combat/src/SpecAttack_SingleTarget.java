
import java.util.ArrayList;

/**
 *
 * @author Jason Richter, Samuel Fiscus
 */
public abstract class SpecAttack_SingleTarget extends SpecAttack{

    public SpecAttack_SingleTarget() {
    }

    public SpecAttack_SingleTarget(int potency, String name) {
        super(potency, name);
    }

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
