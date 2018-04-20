
/**
 *
 * @author Jason Richter, Samuel Fiscus, Emily Clark
 */

import java.util.ArrayList;

public abstract class Usable implements UsableADT{

    //data members
    protected int potency;
    private String name;
    protected String description;
    private String id;
    
    //constructors
    /**
     * Empty constructor for Usable item.
     */
    public Usable() {
    }
    
    /**
     * Partial constructor for Usable item.
     * @param potency Integer representing potency of Usable
     * @param name String representing name of Usable
     */
    public Usable(int potency, String name) {
        this.potency = potency;
        this.name = name;
    }

    /**
     * Filled constructor for Usable item.
     * @param potency Integer representing potency of Usable
     * @param name String representing name of Usable
     * @param description String representing description of Usable
     */
    public Usable(int potency, String name, String description) {
        this.potency = potency;
        this.name = name;
        this.description = description;
    }
    
    /**
     * Filled constructor for Usable item.
     * @param potency Integer representing potency of Usable
     * @param name String representing name of Usable
     * @param description String representing description of Usable
     * @param id String representing the primary key within the database for Usable object.
     */
    public Usable(int potency, String name, String description, String id) {
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

    @Override
    public void setDescription(String description) {
        this.description = description;
    }
    

    //class methods
       
    @Override
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
    
    
    @Override
    public abstract void singleTarget(Entity target);
    
    @Override
    public abstract void multiTarget(ArrayList<Entity> group);     
    
}//end Item
