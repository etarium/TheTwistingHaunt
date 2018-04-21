package game;

import java.util.ArrayList;

/**
 *
 * @author Jason Richter, Samuel Fiscus
 */
public class SpecAttack_MultiTarget_HP extends SpecAttack_MultiTarget{

    
    //constructors
    /**
     * Empty constructor for SpecAttack_MultiTarget_HP item.
     */
    public SpecAttack_MultiTarget_HP() {
    }

    /**
     * Partial constructor for SpecAttack_MultiTarget_HP item.
     * @param potency Integer representing potency of SpecAttack_MultiTarget_HP
     * @param name String representing name of SpecAttack_MultiTarget_HP
     */
    public SpecAttack_MultiTarget_HP(int potency, String name) {
        super(potency, name);
    }

    /**
     * Filled constructor for SpecAttack_MultiTarget_HP item.
     * @param potency Integer representing potency of SpecAttack_MultiTarget_HP
     * @param name String representing name of SpecAttack_MultiTarget_HP
     * @param description String representing description of SpecAttack_MultiTarget_HP
     */
    public SpecAttack_MultiTarget_HP(int potency, String name, String description) {
        super(potency, name, description);
    }

    
    //class methods

    @Override
    public void multiTarget(ArrayList<Entity> group) {
        
        for (int i = 0; i < group.size(); i++) {
            int oldHP = group.get(i).getStats().getCurrentHealth();
            int maxHP = group.get(i).getStats().getMaxHealth();

            int newHP = oldHP + potency;

            //if newHP greater than maxHP, target at full health
            //otherwise, newHP replaces old value
            int val = (maxHP > newHP) ? newHP : maxHP;

            group.get(i).getStats().setCurrentHealth(val);
        }
        
    }
    
    
}
