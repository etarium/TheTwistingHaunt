
import java.util.ArrayList;

/**
 *
 * @author Jason Richter, Samuel Fiscus
 */
public abstract class SpecAttack_MultiTarget extends SpecAttack{

    public SpecAttack_MultiTarget() {
    }

    public SpecAttack_MultiTarget(int potency, String name) {
        super(potency, name);
    }

    public SpecAttack_MultiTarget(int potency, String name, String description) {
        super(potency, name, description);
    }
    
    

    @Override
    public  void singleTarget(Entity x){
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public abstract void multiTarget(ArrayList<Entity> group); 
    
}
