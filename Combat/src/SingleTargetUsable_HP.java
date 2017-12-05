/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author qn4795oh
 */
public class SingleTargetUsable_HP extends SingleTargetUsable{

    public SingleTargetUsable_HP() {
    }

    public SingleTargetUsable_HP(int potency, String name) {
        super(potency, name);
    }

    public SingleTargetUsable_HP(int potency, String name, String description) {
        super(potency, name, description);
    }

    

    
    
    @Override
    public void singleTarget(Entity target) {
        int oldHP = target.getStats().getCurrentHealth();
        int maxHP = target.getStats().getMaxHealth();

        int newHP = oldHP + potency;

        //if newHP greater than maxHP, target at full health
        //otherwise, newHP replaces old value
        int val = (maxHP > newHP) ? newHP : maxHP;

        target.getStats().setCurrentHealth(val);
        //outputs "HP [  x --> y  ]"
        System.out.println("HP[  " + oldHP + " --> " + val + "  ]");
        
    }
    
}
