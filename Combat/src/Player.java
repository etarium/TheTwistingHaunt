/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author qn4795oh
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
        
        String menu = "Select choice for " + getName() + ":\n"
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
                    Entity target = selectEntity(enc.getCombatants());
                    if(target != null){
                        this.attackEntity(target);
                        run = false;
                    }
                    break;
                case "2":   //special attacks
                    
                    break;
                case "3":   //items
                    Usable item = selectUsable();
                    if(item != null){
                        item.useItem(enc.getCombatants());
                    }
                    break;
            }
        
        }
        
    }
    
    public void attackEntity(Entity target){
        int damage = this.attack(target);
        this.combatDialog(damage, target);
    }
    
    public Entity selectEntity(ArrayList<Entity> list) {
        int selection = -1;
        Entity target;

        while (true) {
            try {
                printCombatants(list);
                System.out.print("Choose a combatant to select:\n>");
                selection = console.nextInt() - 1; //account for indexing

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
    
    public void printCombatants(ArrayList<Entity> list){
        String output = 
                      "Combatants:\n"
                    + "-----------------\n";
            
            for(int i = 0; i < list.size(); i++){
                Entity temp = list.get(i);
                output += "| " + (i+1) + " --- " + temp.getName();
                if(temp.getTeamId() == this.getTeamId()){
                    output += "(friendly)";
                }
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
    
    
    
    
    
}
