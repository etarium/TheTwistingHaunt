/**
 *
 * @author Jason Richter, Samuel Fiscus
 */
public class SpecAttack_SingleTarget_HP extends SpecAttack_SingleTarget{

    
    //constructors
    /**
     * Empty constructor for SpecAttack_SingleTarget_HP item.
     */
    public SpecAttack_SingleTarget_HP() {
    }

    /**
     * Partial constructor for SpecAttack_SingleTarget_HP item.
     * @param potency Integer representing potency of SpecAttack_SingleTarget_HP
     * @param name String representing name of SpecAttack_SingleTarget_HP
     */
    public SpecAttack_SingleTarget_HP(int potency, String name) {
        super(potency, name);
    }

    /**
     * Filled constructor for SpecAttack_SingleTarget_HP item.
     * @param potency Integer representing potency of SpecAttack_SingleTarget_HP
     * @param name String representing name of SpecAttack_SingleTarget_HP
     * @param description String representing description of SpecAttack_SingleTarget_HP
     */
    public SpecAttack_SingleTarget_HP(int potency, String name, String description) {
        super(potency, name, description);
    }

    
    
    //class methods
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
