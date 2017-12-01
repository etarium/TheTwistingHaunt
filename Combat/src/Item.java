/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author qn4795oh
 */
public class Item {
    
    //data members
    private int potency;
   
    
    //constructors
    public Item() {
    }
    public Item(int potency) {
        this.potency = potency;
    }
    
    //getter
    public int getPotency() {
        return potency;
    }

    
    
    
    //class methods
    public void targettingHP(Entity x){
        int currentHP = x.getStats().getCurrentHealth();
        int maxHP = x.getStats().getMaxHealth();
        int newHP = currentHP + potency;
        
        int val = (maxHP > newHP) ? maxHP:newHP;
        
        x.getStats().setCurrentHealth(val);
    }
    public void targettingHP(Entity[] x){
        
    }
    
}
