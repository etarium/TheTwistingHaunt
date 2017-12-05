
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jason Richter, Samuel Fiscus
 */
public interface UsableADT {
    /**
     * Returns integer value representing potency of usable.
     * @return Integer value representing potency of usable. Can be positive or negative.
     */
    public int getPotency();

    /**
     * Returns String representing name of usable.
     * @return String representing name of usable.
     */
    public String getName();

    /**
     * Returns String representing description of usable.
     * @return String representing description of usable. 
     */
    public String getDescription();

    /**
     * Sets description field to a String representing the usable's description.
     * @param description String representing the usable's description
     * @require description != null
     */
    public void setDescription(String description);
    
    /**
     * Overarching usable use method. Uses abstract methods in order to polymorphically carry out usable code. Will narrow down targets from passed Encounter.
     * @param enc Encounter that passed player inhabits.
     * @param user Player who is using this usable.
     * @return Boolean value representing whether or not usable was used.
     * @require user.getItemList.size() &gt; 0 &amp;&amp; 
     *          user.getStats().isAlive() &amp;&amp;
     *          enc.getCombatants().size() &gt; 0
     * @ensure new_user.getItemList.size() = old_user.getItemList.size() -1
     */
    public boolean useItem(Encounter enc, Player user);
    
    /**
     * Abstract method that targets an Entity and performs actions based off of subclass's code.
     * @param target Entity to be the target of usable.
     * @require target != null
     */
    public abstract void singleTarget(Entity target);
    
    /**
     * Abstract method that targets Entities and performs actions based off of subclass's code.
     * @param group ArrayList&lt;Entity&gt; to be the target of special attack.
     * @require group != null &amp;&amp; group.size() &gt; 0
     */
    public abstract void multiTarget(ArrayList<Entity> group);
}
