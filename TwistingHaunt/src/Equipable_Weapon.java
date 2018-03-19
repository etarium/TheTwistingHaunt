/**
 *
 * @author Jason Richter, Samuel Fiscus
 */
public class Equipable_Weapon extends Equipable{
    
    /**
     * Empty constructor for Weapon item.
     */
    public Equipable_Weapon() {
    }

    /**
     * Partial constructor for Weapon item.
     * @param potency Integer representing potency of Weapon
     * @param name String representing name of Weapon
     */
    public Equipable_Weapon(int potency, String name) {
        super(potency, name);
    }

    /**
     * Filled constructor for Weapon item.
     * @param potency Integer representing potency of Weapon
     * @param name String representing name of Weapon
     * @param description String representing description of Weapon
     */
    public Equipable_Weapon(int potency, String name, String description) {
        super(potency, name, description);
    }
    
    
    //TO-DO: add a special attack function
}
