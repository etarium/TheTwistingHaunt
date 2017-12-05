
/**
 *
 * @author Jason Richter, Samuel Fiscus
 */

import java.util.ArrayList;

public abstract class Usable {

    //data members
    protected int potency;
    private String name;
    private String description;
    
    //private Player user = new Player();

    //constructors
    public Usable() {
    }
    
    public Usable(int potency, String name) {
        this.potency = potency;
        this.name = name;
    }

    public Usable(int potency, String name, String description) {
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
       
    public boolean useItem(Encounter enc, Player user){
        if(this instanceof Usable_SingleTarget){
            Entity target = user.selectEntity(enc);
            
            if(target != null){
                singleTarget(target);
                return true;
            }
        }
        else if(this instanceof Usable_MultiTarget){
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
    
}//end Item
