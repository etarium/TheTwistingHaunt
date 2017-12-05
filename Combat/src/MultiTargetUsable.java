
/**
 *
 * @author Jason Richter, Samuel Fiscus
 */

import java.util.ArrayList;

public abstract class MultiTargetUsable extends Usable {

    public MultiTargetUsable() {
    }

    public MultiTargetUsable(int potency, String name) {
        super(potency, name);
    }

    public MultiTargetUsable(int potency, String name, String description) {
        super(potency, name, description);
    }

    
    
    /*
    @Override
    public void useHP(Entity[] targetList) {
        for (int i = 0; i < targetList.length; i++) {
            int currentHP = targetList[i].getStats().getCurrentHealth();
            int maxHP = targetList[i].getStats().getMaxHealth();

            int newHP = currentHP + potency;

            //if newHP greater than maxHP, target at full health
            //otherwise, newHP replaces old value
            int val = (maxHP > newHP) ? newHP : maxHP;

            targetList[i].getStats().setCurrentHealth(val);
        }
    }
*/

    
    @Override
    public void singleTarget(Entity x) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public abstract void multiTarget(ArrayList<Entity> group);

    @Override
    public void omniTarget(Encounter enc) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
     
}
