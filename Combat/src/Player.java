
/**
 *
 * @author Jason Richter, Samuel Fiscus
 */

import java.util.ArrayList;
import java.util.Scanner;
public class Player extends Entity{
    
    Scanner console = new Scanner(System.in);
    
    
    //constructor
    
    public Player() {
    }

    public Player(StatBlock stats, String name, int teamId) {
        super(stats, name, teamId);
    }
    
    
       
    //Player methods
    public void displayMenu(){
        
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
    }
    
    public void playerRun(Encounter enc){
        boolean run = true;
        while(run){
            displayMenu();
            String selection = console.next();
            
            switch(selection){
                case "1":   //attack
                    Entity target = selectEntity(enc);
                    if(target != null){
                        this.attackEntity(target);
                        run = false;
                    }
                    break;
                case "2":   //special attacks
                    if (this.getStats().getSpecPoints() > 0) {
                        if (!this.getSpecAttackList().isEmpty()) {
                            SpecAttack spec = selectSpecAttack();
                            if (spec != null) {

                                if (spec.useSpecAttack(enc, this)) {
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
                        if (item != null) {

                            if (item.useItem(enc, this)) {
                                this.getItemList().remove(item);
                                run = false;
                            }
                        }
                    }
                    else
                        System.out.println("No items.");
                    break;
                    
                case "0":
                    run = false;
                    break;
                    
                default:
                    System.out.println("Invalid input. Try again.");
            }
        
        }
        
    }
    
    public void attackEntity(Entity target){
        int damage = this.attack(target);
        this.combatDialog(damage, target);
    }
    
    public Entity selectEntity(Encounter enc) {
        ArrayList<Entity> list = enc.getCombatants();
        while (true) {
            try {
                
                Entity target = null;
                printCombatants(enc);
                System.out.print("Choose a combatant to select (or 0 to exit) :\n>");
                int selection = console.nextInt() - 1; //account for indexing
                
                if(selection == -1){
                    return target;
                }

                target = list.get(selection);
                
                if(target instanceof Player){
                    while(true){
                        System.out.print("Are you sure you want to choose yourself (Y or N)?\n"
                                   + ">");
                        String input = console.next();
                        String val = "";
                        val += input.charAt(0);
                        
                        if (val.toLowerCase().equals("y")) {
                            return target;
                        } else if (val.toLowerCase().equals("n")) {
                            break;
                        } else
                        {
                            System.out.println("Invalid input.\n");
                        }
                    }//end loop
                }
                else if (target.getTeamId() == this.getTeamId()) {        
                    while(true){
                        System.out.print("Are you sure you want to choose a friendly target (Y or N)?\n"
                                   + ">");
                        String input = console.next();
                        String val = "";
                        val += input.charAt(0);
                        
                        if (val.toLowerCase().equals("y")) {
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
                    return target;
                }

            } catch (Exception e) {
                System.out.println("Invalid selection. Please try again.\n");
                console.next();
            }
        }//end while
        
        
    }
    
    public ArrayList<Entity> selectTeam(Encounter enc){
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
                    return targetList;
                case "2":
                    targetList = new ArrayList<>();
                    for(Entity enemy : list){
                        if(enemy.getTeamId() != this.getTeamId()){
                            targetList.add(enemy);
                        }
                    }
                    return targetList;
                    
                case "0":
                    return targetList;
                    
                default:
                    System.out.println("Invalid input. Try again.");
                        
            }//end switch
        }//end while
    }//end selectTeam()
    
    public Usable selectUsable(){
        
        Usable item = null;
        
        if(this.getItemList().isEmpty()){
            return item;
        }
        
        while(true){
            try{
                printUsables();
                System.out.print("Select an item to use (or 0 to exit) :\n"
                               + ">");
                int selection = console.nextInt() -1;
                
                if(selection == -1){
                    return item;
                }
                
                item = this.getItemList().get(selection);
                return item;
                
                
            }catch(Exception e){
                System.out.println("Invalid input. Try again.");
                console.next();
            }
        }
    }
    
    public SpecAttack selectSpecAttack(){
        
        SpecAttack spec = null;
        
        if(this.getItemList().isEmpty()){
            return spec;
        }
        
        while(true){
            try{
                printSpecAttacks();
                System.out.print("Select a special attack to use (or 0 to exit) :\n"
                               + ">");
                int selection = console.nextInt() -1;
                
                if(selection == -1){
                    return spec;
                }
                
                spec = this.getSpecAttackList().get(selection);
                return spec;
                
                
            }catch(Exception e){
                System.out.println("Invalid input. Try again.");
                console.next();
            }
        }
    }
    
    public void printCombatants(Encounter enc){
        ArrayList<Entity> list = enc.getCombatants();

        
        String output = 
                      "Combatants:\n"
                    + "-----------------\n";
            
            for(int i = 0; i < list.size(); i++){
                Entity temp = list.get(i);
                output += "| " + (i+1) + " --- " + temp.getName();
                if(temp.getTeamId() == this.getTeamId()){
                    output += "(friendly)";
                }
                output += " [" + temp.getStats().currentHealth+"/"+temp.getStats().getMaxHealth()+"]";
                output += "\n";
            }
            output += "-----------------\n";
            
            System.out.println(output);
    }
    
    public void printUsables(){
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
    }
    
    public void printSpecAttacks(){
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
    }
    
    
    
    
}//end player