/**
 *
 * @author Jason Richter, Samuel Fiscus
 */
public class Weapon extends Equipable{
    public Weapon() {
    }

    public Weapon(int potency, String name) {
        super(potency, name);
    }

    public Weapon(int potency, String name, String description) {
        super(potency, name, description);
    }
    
    
    //TO-DO: add a special attack function
}
