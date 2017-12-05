
/**
 *
 * @author Jason Richter, Samuel Fiscus
 */
public abstract class Equipable {
    //data members

    protected int potency;
    private String name;
    private String description;

    //constructors
    public Equipable() {
    }

    public Equipable(int potency, String name) {
        this.potency = potency;
        this.name = name;
    }

    public Equipable(int potency, String name, String description) {
        this.potency = potency;
        this.name = name;
        this.description = description;
    }

    //getters
    public int getPotency() {
        return potency;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

}
