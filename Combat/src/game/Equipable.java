package game;

/**
 *
 * @author Jason Richter, Samuel Fiscus, Emily Clark
 */
public abstract class Equipable implements EquipableADT{
    //data members

    protected int potency;
    private String name;
    private String description;
    private String id;

    //constructors
    /**
     * Empty constructor for Equipable item.
     */
    public Equipable() {
    }

    /**
     * Partial constructor for Equipable item.
     * @param potency Integer representing potency of Equipable
     * @param name String representing name of Equipable
     */
    public Equipable(int potency, String name) {
        this.potency = potency;
        this.name = name;
    }

    /**
     * Filled constructor for Equipable item.
     * @param potency Integer representing potency of Equipable
     * @param name String representing name of Equipable
     * @param description String representing description of Equipable
     */
    public Equipable(int potency, String name, String description) {
        this.potency = potency;
        this.name = name;
        this.description = description;
    }
    
    /**
     * Filled constructor for Equipable item.
     * @param potency Integer representing potency of Equipable
     * @param name String representing name of Equipable
     * @param description String representing description of Equipable
     * @param id String representing the primary key within the database for Equipable object.
     */
    public Equipable(int potency, String name, String description, String id) {
        this.potency = potency;
        this.name = name;
        this.description = description;
        this.id = id;
    }

    
    
    //getters
    @Override
    public int getPotency() {
        return potency;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return description;
    }
    
    public String getID()
    {
    		return id;
    }

}
