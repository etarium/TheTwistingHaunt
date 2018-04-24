package game;

import java.io.Serializable;

/**
 *
 * @author Jason Richter, Samuel Fiscus
 */

import java.util.ArrayList;
import java.util.Scanner;

public class Player extends Entity implements PlayerADT, Serializable{
    
    

	/**
	 * 
	 */
	private static final long serialVersionUID = -5644858544197164093L;

	
    
    private Location location;
    
    //constructor
    /**
     * Empty constructor for Player
     */
    public Player() {
        location = new Location();
        this.instantiateEmptyLists();
    }

    /**
     * Filled constructor for Player
     * @param stats StatBlock with core values that represent Player's attributes.
     * @param name String representing Player's name
     * @param teamId Integer representing Player's team
     */
    public Player(StatBlock stats, String name, String description, String teamId) {
        super(stats, name, description, teamId);
        this.instantiateEmptyLists();
    }
    
    private void instantiateEmptyLists() {
    		this.setItemList(new ArrayList<Usable>());
    		this.setKeyItemsList(new ArrayList<KeyItems>());
    		this.setSpecAttackList(new ArrayList<SpecAttack>());
    }
    
    public Cell getCurrentCell(Cell[][][] cellList) {
    		Location temp = this.getLocation();
    		return cellList[temp.getX()][temp.getY()][temp.getZ()];
    }
    
    
       
    //Player methods
    @Override
    public String displayMenu(){
        
        //outputs player's current health
        String menu = "You are at " + getStats().getCurrentHealth() + " HP...\n"
                    + "Select choice for " + getName() + ":\n"
                    + "&----------------------------&\n"
                    + "| 1 --- Attack               |\n"
                    + "| 2 --- Special Attack       |\n"
                    + "| 3 --- Use Item             |\n"
                    + "|                            |\n"
                    + "&----------------------------&\n"
                    + "| 0 --- Nothing              |\n"
                    + "&----------------------------&\n\n"
                    + "Make your selection: \n"
                    + ">";
        System.out.print(menu);
        return menu;
    }//end displayMenu()
    
    @Override
    public void playerRun(Encounter enc){
        
    		Scanner console = new Scanner(System.in);
    	
        //becomes false on conditions where player's turn has concluded
        boolean run = true;
        while(run){
            displayMenu();
            //menu-driven selection
            String selection = console.next();
            
            switch(selection){
                case "1":   //attack
                    Entity target = selectEntity(enc);
                    //may be null if exited
                    if(target != null){
                        int damage = this.attack(target);
                        this.combatDialog(damage, target);
                        run = false;
                    }
                    break;
                case "2":   //special attacks
                    //must have specPoints in order to use specAttacks
                    if (this.getStats().getSpecPoints() > 0) {
                        if (!this.getSpecAttackList().isEmpty()) {
                            SpecAttack spec = selectSpecAttack();
                            //may be null if exited
                            if (spec != null) {

                                if (spec.useSpecAttack(enc, this)) {
                                    //specPoints--
                                    this.getStats().decrementSpecPoints();
                                    run = false;
                                }
                            }
                        }
                        else
                            System.out.println("No special attacks.");
                    }
                    else 
                        System.out.println("No Special Attack Points left!");
                    break;
                case "3":   //items
                    if (!this.getItemList().isEmpty()) {
                        Usable item = selectUsable();
                        //may be null if exited
                        if (item != null) {

                            if (item.useItem(enc, this)) {
                                //item is consumed
                                this.getItemList().remove(item);
                                run = false;
                            }
                        }
                    }
                    else
                        System.out.println("No items.");
                    break;
                    
                case "0":   //do nothing
                    run = false;
                    break;
                    
                default:
                    System.out.println("Invalid input. Try again.");
            }
        
        }
        console.close();
        
    }//end playerRun()
    
    @Override
    public Entity selectEntity(Encounter enc) {
    		Scanner console = new Scanner(System.in);
        ArrayList<Entity> list = enc.getCombatants();
        //runs until some selection is made, even if null
        while (true) {
            try {
                
                Entity target = null;
                printCombatants(enc);
                System.out.print("Choose a combatant to select (or 0 to exit) :\n>");
                int selection = console.nextInt() - 1; //account for indexing
                
                //exit, return null
                if(selection == -1){
                		console.close();
                    return target;
                }

                target = list.get(selection);
                
                //target self?
                if(target instanceof Player){
                    while(true){
                        System.out.print("Are you sure you want to choose yourself (Y or N)?\n"
                                   + ">");
                        String input = console.next();
                        String val = "";
                        val += input.charAt(0);
                        
                        if (val.toLowerCase().equals("y")) {
                        		console.close();
                            return target;
                        } else if (val.toLowerCase().equals("n")) {
                            break;
                        } else
                        {
                            System.out.println("Invalid input.\n");
                        }
                    }//end loop
                }//end self-targetting
                //target ally?
                else if (target.getTeamId() == this.getTeamId()) {        
                    while(true){
                        System.out.print("Are you sure you want to choose a friendly target (Y or N)?\n"
                                   + ">");
                        String input = console.next();
                        String val = "";
                        val += input.charAt(0);
                        
                        if (val.toLowerCase().equals("y")) {
                        		console.close();
                        		return target;
                        } else if (val.toLowerCase().equals("n")) {
                            break;
                        } else
                        {
                            System.out.println("Invalid input.\n");
                        }
                    }//end loop

                }//end friendly target
                else{
                		console.close();
                		return target;
                }

            } catch (Exception e) {
                System.out.println("Invalid selection. Please try again.\n");
                console.next();
            }
        }//end while
    }//end selectEntity()
    
    @Override
    public ArrayList<Entity> selectTeam(Encounter enc){
    		Scanner console = new Scanner(System.in);
    		ArrayList<Entity> list = enc.getCombatants();
        while(true){
            ArrayList<Entity> targetList = null;
            System.out.println
                     ("&-----------------&\n"
                    + "| 1 --- Allies    |\n"
                    + "| 2 --- Enemies   |\n"
                    + "&-----------------&\n"
                    + "| 0 --- Back      |\n"
                    + "&-----------------&");
            System.out.print("Select who to use this on (or 0 to exit) :");
            
            String selection = console.next();
            
            switch(selection){
                case "1":   //allies
                    targetList = new ArrayList<>();
                    for(Entity ally : list){
                        if(ally.getTeamId() == this.getTeamId()){
                            targetList.add(ally);
                        }
                    }
                    console.close();
                    return targetList;
                case "2":   //enemies
                    targetList = new ArrayList<>();
                    for(Entity enemy : list){
                        if(enemy.getTeamId() != this.getTeamId()){
                            targetList.add(enemy);
                        }
                    }
                    console.close();
                    return targetList;
                    
                case "0":   //exit, return null
                		console.close();
                		return targetList;
                    
                default:
                    System.out.println("Invalid input. Try again.");
                        
            }//end switch
        }//end while
    }//end selectTeam()
    
    @Override
    public Usable selectUsable(){
    		Scanner console = new Scanner(System.in);
        Usable item = null;
        
        //return null if empty, same as exit
        if(this.getItemList().isEmpty()){
            console.close();
        		return item;
        }
        
        while(true){
            try{
                printUsables();
                System.out.print("Select an item to use (or 0 to exit) :\n"
                               + ">");
                int selection = console.nextInt() -1;
                
                //exit, return null
                if(selection == -1){
                    console.close();
                    return item;
                }
                
                item = this.getItemList().get(selection);
                console.close();
                return item;
                
                
            }catch(Exception e){
                System.out.println("Invalid input. Try again.");
                console.next();
            }
        }//end while
    }//end selectUsable()
    
    @Override
    public SpecAttack selectSpecAttack(){
    		Scanner console = new Scanner(System.in);
        SpecAttack spec = null;
        
        //return null if empty, same as exit
        if(this.getItemList().isEmpty()){
            console.close();
        		return spec;
        }
        
        while(true){
            try{
                printSpecAttacks();
                System.out.print("Select a special attack to use (or 0 to exit) :\n"
                               + ">");
                int selection = console.nextInt() -1;
                
                //exit, return null
                if(selection == -1){
                		console.close();
                    return spec;
                }
                
                spec = this.getSpecAttackList().get(selection);
                console.close();
                return spec;
                
                
            }catch(Exception e){
                System.out.println("Invalid input. Try again.");
                console.next();
            }
        }//end while
    }//end selectSpecAttack()
    
    @Override
    public String printCombatants(Encounter enc){
        ArrayList<Entity> list = enc.getCombatants();
        
        String output = 
                      "Combatants:\n"
                    + "-----------------\n";
            
            for(int i = 0; i < list.size(); i++){
                Entity temp = list.get(i);
                output += "| " + (i+1) + " --- " + temp.getName();
                //adds "(friendly)" to output if on the same team as Player
                if(temp.getTeamId() == this.getTeamId()){
                    output += "(friendly)";
                }
                //tags on combatant's current health status
                output += " [" + temp.getStats().currentHealth+"/"+temp.getStats().getMaxHealth()+"]";
                output += "\n";
            }
            output += "-----------------\n";
            
            System.out.println(output);
            return output;
    }//end printCombatants()
    
    public void setLocation(int x, int y, int z){
        this.location = new Location(x,y,z);
    }
    
    public void setLocation(Location location){
        this.location = location;
    }

    public Location getLocation(){
        return location;
    }
    
    @Override
    public String printUsables(){
        String output = 
                      this.getName() + "'s Items:\n"
                    + "-----------------\n";
            
            for(int i = 0; i < this.getItemList().size(); i++){
                Usable temp = this.getItemList().get(i);
                output += "| " + (i+1) + " --- " + temp.getName();
                output += "\n";
            }
            output += "-----------------\n";
            
            System.out.println(output);
            return output;
    }//end printUsables()
    
    @Override
    public String printSpecAttacks(){
        String output = 
                      
                      "Special Attack Points left: " + this.getStats().getSpecPoints() + "\n"
                    + this.getName() + "'s Special Attacks:\n"
                    + "-----------------\n";
            
            for(int i = 0; i < this.getSpecAttackList().size(); i++){
                SpecAttack temp = this.getSpecAttackList().get(i);
                output += "| " + (i+1) + " --- " + temp.getName();
                output += "\n";
            }
            output += "-----------------\n";
            
            System.out.println(output);
            return output;
    }//end printSpecAttacks()
    
}//end player