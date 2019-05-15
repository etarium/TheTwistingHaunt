
/**
 *
 * @author Jason Richter, Samuel Fiscus
 */
public class Equipable_Armor extends Equipable{
    
    /**
     * Empty constructor for Armor item.
     */
    public Equipable_Armor() {
    }

    /**
     * Partial constructor for Armor item.
     * @param potency Integer representing potency of Armor
     * @param name String representing name of Armor
     */
    public Equipable_Armor(int potency, String name) {
        super(potency, name);
    }

    /**
     * Filled constructor for Armor item.
     * @param potency Integer representing potency of Armor
     * @param name String representing name of Armor
     * @param description String representing description of Armor
     */
    public Equipable_Armor(int potency, String name, String description) {
        super(potency, name, description);
    }
}
