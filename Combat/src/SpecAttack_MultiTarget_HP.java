
import java.util.ArrayList;

/**
 *
 * @author Jason Richter, Samuel Fiscus
 */
public class SpecAttack_MultiTarget_HP extends SpecAttack_MultiTarget{

    
    //constructors
    public SpecAttack_MultiTarget_HP() {
    }

    public SpecAttack_MultiTarget_HP(int potency, String name) {
        super(potency, name);
    }

    public SpecAttack_MultiTarget_HP(int potency, String name, String description) {
        super(potency, name, description);
    }

    
    //class methods

    @Override
    public void multiTarget(ArrayList<Entity> group) {
        
        for (int i = 0; i < group.size(); i++) {
            int oldHP = group.get(i).getStats().getCurrentHealth();
            int maxHP = group.get(i).getStats().getMaxHealth();

            int newHP = oldHP + potency;

            //if newHP greater than maxHP, target at full health
            //otherwise, newHP replaces old value
            int val = (maxHP > newHP) ? newHP : maxHP;

            group.get(i).getStats().setCurrentHealth(val);
        }
        
    }
    
    
}
