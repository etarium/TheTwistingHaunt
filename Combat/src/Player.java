/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author qn4795oh
 */
public class Player extends Entity{
    
    public Player(StatBlock stats, String name, int teamId) {
        super(stats, name, teamId);
    }
    
    
    
    
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
    
    public void attackEntity(){
        
    }
    
    
    
    
    
}
