
/**
 *
 * @author Jason Richter, Samuel Fiscus, Emily Clark
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
    
    /**
     * Filled constructor for Usable_SingleTarget_HP item.
     * @param potency Integer representing potency of Usable_SingleTarget_HP
     * @param name String representing name of Usable_SingleTarget_HP
     * @param description String representing description of Usable_SingleTarget_HP
     * * @param id String representing the primary key within the database for Usable object.
     */
    public Usable_SingleTarget_HP(int potency, String name, String description, String id) {
        super(potency, name, description, id);
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
