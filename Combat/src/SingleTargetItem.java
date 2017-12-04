
/**
 *
 * @author Jason Richter, Samuel Fiscus
 */
public class SingleTargetItem extends Item{

    @Override
    public void use(Entity[] targetList) {
        targetList[0].
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
    /*
    private void targettingHP(Entity x){
        int currentHP = x.getStats().getCurrentHealth();
        int maxHP = x.getStats().getMaxHealth();
        
        int newHP = currentHP + potency;
        
        //if newHP greater than maxHP, target at full health
        //otherwise, newHP replaces old value
        int val = (maxHP > newHP) ? newHP:maxHP;
        
        x.getStats().setCurrentHealth(val);
    }
*/
    
}//end SingleTargetItem
