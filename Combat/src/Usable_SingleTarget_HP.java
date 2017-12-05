/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author qn4795oh
 */
public class Usable_SingleTarget_HP extends Usable_SingleTarget{

    //constructors
    /**
     * Empty constructor for Usable_SingleTarget_HP item.
     */
    public Usable_SingleTarget_HP() {
    }

    /**
     * Partial constructor for Usable_SingleTarget_HP item.
     * @param potency Integer representing potency of Usable_SingleTarget_HP
     * @param name String representing name of Usable_SingleTarget_HP
     */
    public Usable_SingleTarget_HP(int potency, String name) {
        super(potency, name);
    }

    /**
     * Filled constructor for Usable_SingleTarget_HP item.
     * @param potency Integer representing potency of Usable_SingleTarget_HP
     * @param name String representing name of Usable_SingleTarget_HP
     * @param description String representing description of Usable_SingleTarget_HP
     */
    public Usable_SingleTarget_HP(int potency, String name, String description) {
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
