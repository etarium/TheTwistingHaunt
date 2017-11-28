
/**
 *
 * @author Jason Richter, Samuel Fiscus
 */

import java.util.Random;

public class Entity implements EntityADT{
    
    private StatBlock stats;
    private String name;
    //private ArrayList<Item> itemList;
    //private ArrayList<SpecialAttack> specAttList;
    
    
    public Entity(StatBlock stats, String name){
        this.stats = stats;
        this.name = name;
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
    
    
    
    //class methods
    public int attack(Entity enemy){
        Random rng = new Random();
        
        int attackRoll = rng.nextInt(100) + 1;
        int baseAcc = this.stats.initiative;
        int modifiedRoll = attackRoll + baseAcc ; 
        
        
        if(modifiedRoll < enemy.stats.evasion){
            return -1; //designates miss
        }
        else{
            int randAtt = rng.nextInt(20) + 1;
            return this.stats.physAtt + randAtt;
        }
    }//end attack
    
    
    public void defend(int damageValue) {
        int modifiedDamage = damageValue - this.stats.physDef;
        
        if(modifiedDamage > 0){
            this.stats.setCurrentHealth(this.stats.currentHealth - modifiedDamage);
        }
    }
    
    @Override
    public String toString(){
        return String.format("%s%n"
                           + "Health: %s --- %.0f%%",
                            name, stats.currentHealth, stats.healthPercentage());
    }
}//end Entity
