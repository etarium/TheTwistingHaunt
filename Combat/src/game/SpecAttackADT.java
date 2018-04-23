package game;

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
     * Overarching special attack use method. Uses abstract methods in order to polymorphically carry out special attack code.
     * @param enc Encounter that passed player inhabits.
     * @param user Player who is using this special attack.
     * @return Boolean value representing whether or not special attack was used.
     * @require user.getSpecAttackList.size() &gt; 0 &amp;&amp;
     *          user.getStats().isAlive() &amp;&amp;
     *          enc.getCombatants().size() &gt; 0
     * @ensure user.getStats().decrementSpecPoints()
     */
    public boolean useSpecAttack(Encounter enc, Player user);
    
    /**
     * Abstract method that targets an Entity and performs actions based off of subclass's code.
     * @param target Entity to be the target of special attack.
     * @return 
     * @require target != null
     */
    public abstract String singleTarget(Entity target);
    
    /**
     * Abstract method that targets Entities and performs actions based off of subclass's code.
     * @param group ArrayList&lt;Entity&gt; to be the target of special attack.
     * @require group != null &amp;&amp; group.size() &gt; 0
     */
    public abstract String multiTarget(ArrayList<Entity> group);
    
}
