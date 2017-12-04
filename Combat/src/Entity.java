
/**
 *
 * @author Jason Richter, Samuel Fiscus
 */

import java.util.Random;
import java.util.ArrayList;

public class Entity implements EntityADT{
    
    private StatBlock stats;
    private String name;
    private int teamId; //id of entity's team
    //private ArrayList<Item> itemList;
    //private ArrayList<SpecialAttack> specAttList;
    
    Random rng = new Random();
    
    
    public Entity(StatBlock stats, String name, int teamId){
        this.stats = stats;
        this.name = name;
        this.teamId = teamId;
    }

    //getters and setters
    public StatBlock getStats() {
        return stats;
    }

    public void setStats(StatBlock stats) {
        this.stats = stats;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }
    
    
    
    
    //class methods
    public int attack(Entity enemy){
        
        int attackRoll = rng.nextInt(100) + 1;
        int baseAcc = this.stats.initiative;
        int modifiedRoll = attackRoll + baseAcc ; 
        
        int totalDamage = -1;
        
        if(modifiedRoll >= enemy.stats.evasion){
            int randAtt = rng.nextInt(20) + 1;
            int damageValue = this.stats.physAtt + randAtt;
            totalDamage = enemy.defend(damageValue);
        }
        
        return totalDamage;
    }//end attack
    
    public int defend(int damageValue) {
        int modifiedDamage = damageValue - this.stats.physDef;
        
        if(modifiedDamage > 0){
            this.stats.setCurrentHealth(this.stats.currentHealth - modifiedDamage);
        }
        else {
            modifiedDamage = 0;
        }
        return modifiedDamage;
    }//end defend()
    
    public ArrayList<Entity> getTargetList(ArrayList<Entity> list){
        ArrayList<Entity> targetList = new ArrayList<>();
        for(Entity targ : list){
            //target must be an enemy and alive
            if (targ.getTeamId() != this.getTeamId() && targ.getStats().isAlive() ){
                targetList.add(targ);
            }
        }
        
        return targetList;
    }
        
    public Entity chooseTarget(ArrayList<Entity> targetList){
        int size = targetList.size();
        Entity target = null;
        
        if(size > 0){
            int selection = rng.nextInt(targetList.size());
            target = targetList.get(selection);
        }
        return target;
    }
    
    //dialog methods
    public void combatDialog(int damageValue, Entity target){
        
       String targName = target.name; 
        
       if (damageValue < 0) {
            System.out.println(name + "'s attack fails to connect. Miss!");
        }
        else if (damageValue == 0){
            System.out.println(name + "'s attack glances off, dealing " + damageValue
                             + " damage to " + targName + ".");
        }
        else {
            System.out.println(name + "'s attack deals " + damageValue 
                             + " damage to " + targName + ".");
        }
    }
    
    @Override
    public String toString(){
        return String.format("%s%n"
                           + "\tHealth: %s --- %3.0f%%",
                            name, stats.currentHealth, 
                            stats.healthPercentage() * 100);
    }
}//end Entity
