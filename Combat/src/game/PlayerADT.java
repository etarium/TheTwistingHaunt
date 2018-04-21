package game;

import java.util.ArrayList;



/**
 *
 * @author Jason Richter, Samuel Fiscus
 */
public interface PlayerADT {
    
    /**
     * Prints menu of allowable Player actions.
     */ 
    public void displayMenu();
    
    /**
     * Selection structure method for non-automated Player input and control during Encounter.
     * @param enc Encounter that Player inhabits.
     */
    public void playerRun(Encounter enc);
    
    /**
     * Returns one Entity, from enc.getCombatants(), to be passed as a target.
     * @param enc Encounter that combatant inhabits.
     * @return Entity to be passed as a target.
     */
    public Entity selectEntity(Encounter enc);
    
    /**
     * Returns an ArrayList&lt;Entity&gt;, narrowed from enc.getCombatants(), to be passed as a target.
     * @param enc Encounter that combatants inhabit.
     * @return ArrayList&lt;Entity&gt; to be passed as a target.
     */
    public ArrayList<Entity> selectTeam(Encounter enc);
    
    /**
     * Returns usable to be executed.
     * @return Usable from this.getItemList() to be used
     */
    public Usable selectUsable();
    
    /**
     * Returns special attack to be executed.
     * @return SpecAttack from this.getSpecAttackList() to be executed
     */
    public SpecAttack selectSpecAttack();
    
    /**
     * Prints out list of Entites from enc.getCombatants()
     * @param enc Encounter that combatants inhabit
     */
    public void printCombatants(Encounter enc);
    
    /**
     * Prints out list of usables from this.getItemList()
     */
    public void printUsables();
    
    /**
     * Prints out list of special attacks from this.getSpecAttackList()
     */
    public void printSpecAttacks();
    
}
