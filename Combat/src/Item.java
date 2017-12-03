/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author qn4795oh
 */
public abstract class Item {
    
    //data members
    private int potency;
    private String name;
    private String description;
   
    
    
    //constructors
    public Item() {
    }
    
    public Item(int potency, String name) {
        this.potency = potency;
        this.name = name;
    }
    
    public Item(int potency, String name, String description) {
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
    
    //class methods
    
    //
    //still considering what to return
    //should we return anything at all? damage done, etc?
    //what about for multitargeted ones? should we also have dialog here?
    //
    
    public abstract void singleTarget(Entity x);
    
    public abstract void multiTarget(Entity[] group);
    
    public abstract void omniTarget(Encounter enc);
    
}//end Item
