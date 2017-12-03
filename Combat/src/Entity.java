
/**
 *
 * @author Jason Richter, Samuel Fiscus
 */

import java.util.Random;

public class Entity implements EntityADT{
    
    private StatBlock stats;
    private String name;
    private int teamId; //id of entity's team
    //private ArrayList<Item> itemList;
    //private ArrayList<SpecialAttack> specAttList;
    
    
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
        Random rng = new Random();
        
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
    }
    
    //dialog methods
    public void combatDialog(int damageValue){
        if (damageValue < 0) {
            System.out.println(name + "'s attack fails to connect. Miss!");
        }
        else if (damageValue == 0){
            System.out.println(name + "'s attack glances off, dealing " + damageValue
                             + " damage.");
        }
        else {
            System.out.println(name + "'s attack deals " + damageValue + " damage.");
        }
    }
    
    @Override
    public String toString(){
        return String.format("%s%n"
                           + "Health: %s --- %3.0f%%",
                            name, stats.currentHealth, 
                            stats.healthPercentage() * 100);
    }
}//end Entity
