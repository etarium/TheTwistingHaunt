/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author qn4795oh
 */
public class SingleTargetItem extends Item{

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
