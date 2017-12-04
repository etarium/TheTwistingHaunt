
/**
 *
 * @author Jason Richter, Samuel Fiscus
 */
public class MultiTargetItem extends Item {

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

    /*
    @Override
    public void singleTarget(Entity x) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void multiTarget(Entity[] group) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void omniTarget(Encounter enc) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
     */
}
