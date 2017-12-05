
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
    
    private Player user = new Player();

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
    //
    //still considering what to return
    //should we return anything at all? damage done, etc?
    //what about for multitargeted ones? should we also have dialog here?
    //
    
    //public abstract void useHP(Entity[] targetList);
    
    public boolean useItem(ArrayList<Entity> group){
        if(this instanceof SingleTargetUsable){
            Entity target = user.selectEntity(group);
            
            if(target != null){
                singleTarget(target);
                return true;
            }
        }
        return false;
    }
    public abstract void singleTarget(Entity x);
    
    public abstract void multiTarget(Entity[] group);
    
    public abstract void omniTarget(Encounter enc);
     
    
}//end Item
