
import java.util.ArrayList;


/**
 *
 * @author Jason Richter, Samuel Fiscus
 */
public interface SpecAttackADT {
    
    /**
     * Returns integer value representing potency of special attack.
     * @return Integer value representing potency of special attack. Can be positive or negative.
     */
    public int getPotency();

    /**
     * Returns String representing name of special attack.
     * @return String representing name of special attack.
     */
    public String getName();

    /**
     * Returns String representing description of special attack.
     * @return String representing description of special attack. 
     */
    public String getDescription();

    /**
     * Sets description field to a String representing the special attack's description.
     * @param description String representing the special attack's description
     * @require description != null
     */
    public void setDescription(String description);
    
    /**
     * 
     * @param group
     * @param user
     * @return 
     */
    public boolean useSpecAttack(ArrayList<Entity> group, Player user);
    
    /**
     * 
     * @param target 
     */
    public abstract void singleTarget(Entity target);
    
    /**
     * 
     * @param group 
     */
    public abstract void multiTarget(ArrayList<Entity> group);
    
}
