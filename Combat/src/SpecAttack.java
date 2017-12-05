
import java.util.ArrayList;

/**
 *
 * @author Jason Richter, Samuel Fiscus
 */
public abstract class SpecAttack {
    
    
    //data members
    protected int potency;
    private String name;
    private String description;
    
    //private Player user = new Player();

    //constructors
    public SpecAttack() {
    }
    
    public SpecAttack(int potency, String name) {
        this.potency = potency;
        this.name = name;
    }

    public SpecAttack(int potency, String name, String description) {
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

    public void setDescription(String description) {
        this.description = description;
    }
    

    //class methods
       
    public boolean useSpecAttack(Encounter enc, Player user){
        if(this instanceof SpecAttack_SingleTarget){
            Entity target = user.selectEntity(enc);
            
            if(target != null){
                singleTarget(target);
                return true;
            }
        }
        else if(this instanceof SpecAttack_MultiTarget){
            ArrayList<Entity> targetList = user.selectTeam(enc);
            
            if(targetList != null){
                multiTarget(targetList);
                return true;
            }
        }
        return false;
    }
    
    
    public abstract void singleTarget(Entity target);
    
    public abstract void multiTarget(ArrayList<Entity> group);   
    
}
