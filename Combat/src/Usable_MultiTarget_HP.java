
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author qn4795oh
 */
public class Usable_MultiTarget_HP extends Usable_MultiTarget{

    
    //constructors
    /**
     * Empty constructor for Equipable item.
     */
    public Usable_MultiTarget_HP() {
    }

    /**
     * Partial constructor for Usable_MultiTarget_HP item.
     * @param potency Integer representing potency of Usable_MultiTarget_HP
     * @param name String representing name of Usable_MultiTarget_HP
     */
    public Usable_MultiTarget_HP(int potency, String name) {
        super(potency, name);
    }

    /**
     * Filled constructor for Usable_MultiTarget_HP item.
     * @param potency Integer representing potency of Usable_MultiTarget_HP
     * @param name String representing name of Usable_MultiTarget_HP
     * @param description String representing description of Usable_MultiTarget_HP
     */
    public Usable_MultiTarget_HP(int potency, String name, String description) {
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
