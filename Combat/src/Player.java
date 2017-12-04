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
                    + "&----------------------------&\n\n"
                    + "Make your selection: \n"
                    + ">";
        System.out.print(menu);
    }
    
    public void attackEntity(ArrayList<Entity> list){
        Entity target = selectEntity(list);
        int damage = this.attack(target);
        this.combatDialog(damage, target);
    }
    
    public Entity selectEntity(ArrayList<Entity> list) {
        int selection = -1;
        Entity target;

        while (true) {
            try {
                printSelections(list);
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
                            return this;
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
    
    public void printSelections(ArrayList<Entity> list){
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
    
    
    
    
    
}
