
import java.util.ArrayList;

/**
 *
 * @author Jason Richter, Samuel Fiscus
 */
public abstract class SpecAttack_MultiTarget extends SpecAttack{

    /**
     * Empty constructor for SpecAttack_MultiTarget item.
     */
    public SpecAttack_MultiTarget() {
    }

    /**
     * Partial constructor for SpecAttack_MultiTarget item.
     * @param potency Integer representing potency of SpecAttack_MultiTarget
     * @param name String representing name of SpecAttack_MultiTarget
     */
    public SpecAttack_MultiTarget(int potency, String name) {
        super(potency, name);
    }

    /**
     * Filled constructor for SpecAttack_MultiTarget item.
     * @param potency Integer representing potency of SpecAttack_MultiTarget
     * @param name String representing name of SpecAttack_MultiTarget
     * @param description String representing description of SpecAttack_MultiTarget
     */
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
