
/**
 *
 * @author Jason Richter, Samuel Fiscus
 */
public class SingleTargetUsable extends Usable{

    @Override
    public void useHP(Entity[] targetList) {
        int currentHP = targetList[0].getStats().getCurrentHealth();
        int maxHP = targetList[0].getStats().getMaxHealth();
        
        int newHP = currentHP + potency;
        
        //if newHP greater than maxHP, target at full health
        //otherwise, newHP replaces old value
        int val = (maxHP > newHP) ? newHP:maxHP;
        
        targetList[0].getStats().setCurrentHealth(val);
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
    
}//end SingleTargetItem
