
import java.util.ArrayList;

/**
 *
 * @author Jason Richter, Samuel Fiscus
 */
public abstract class SpecAttack implements SpecAttackADT{
    
    
    //data members
    protected int potency;
    private String name;
    private String description;
    
    //private Player user = new Player();

    //constructors
    /**
     * Empty constructor for SpecAttack item.
     */
    public SpecAttack() {
    }
    
    /**
     * Partial constructor for SpecAttack item.
     * @param potency Integer representing potency of SpecAttack
     * @param name String representing name of SpecAttack
     */
    public SpecAttack(int potency, String name) {
        this.potency = potency;
        this.name = name;
    }

    /**
     * Filled constructor for SpecAttack item.
     * @param potency Integer representing potency of SpecAttack
     * @param name String representing name of SpecAttack
     * @param description String representing description of SpecAttack
     */
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
