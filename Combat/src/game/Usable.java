package game;

import java.io.Serializable;

/**
 *
 * @author Jason Richter, Samuel Fiscus, Emily Clark
 */

import java.util.ArrayList;

import gui.classes.GUI_Client;

public abstract class Usable implements UsableADT, Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = -463963664850379027L;
	//data members
    protected int potency;
    private String name;
    protected String description;
    private String id;
    private String[] statsAffected;
    
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
    
    @Override
    public String getID()
    {
    		return id;
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
    
    public boolean useItem_OOC(Entity user) {
    		gui.classes.PlayWindow play = GUI_Client.getPlayWindow();
    	
    		if(this.potency < 0 && user instanceof Player) {
    			String warning = "Are you really sure you want to use this?  [y/n]";
    			
    			String response = "";
    			
    			while(!response.equals("y") || !response.equals("n")) {
    				play.outGUI(warning);
    				response = play.requestInput();
    				response = response.toLowerCase().charAt(0) + "";
    	
    			}
    			
    			if(response.equals("n")) {
    				return false;
    			}
    		}
    		
    		
    		if(this instanceof Usable_SingleTarget ) {
    			String output = singleTarget(user);
    			play.outGUI(output);
    			play.requestInput();
    			
    			return true;
    		}
    		else if(this instanceof Usable_MultiTarget) {
    			ArrayList<Entity> target = new ArrayList<>();
    			target.add(user);
    			
    			String output = multiTarget(target);
    			play.outGUI(output);
    			play.requestInput();
    			
    			return true;
    		}
    		
    		return false;
    	
    }
    
    @Override
    public String toString()
    {
    		return "* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *\n\n"
    	
		+ "   " + this.getName() + "\n"
		+ "\n"
		+ this.getDescription() + "\n\n"
		+ "* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *\n";
    }
    
    @Override
    public abstract String singleTarget(Entity target);
    
    @Override
    public abstract String multiTarget(ArrayList<Entity> group);     
    
    
    
}//end Item
