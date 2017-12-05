
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
    private ArrayList<Usable> itemList;
    private ArrayList<SpecAttack> specAttackList;
    
    private Equipable_Armor wornArmor;
    private Equipable_Weapon usedWeapon;
    
    Random rng = new Random();
    
    public Entity(){
    }
    public Entity(StatBlock stats, String name, int teamId){
        this.stats = stats;
        this.name = name;
        this.teamId = teamId;
        this.itemList = new ArrayList<>();
        this.specAttackList = new ArrayList<>();
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

    public ArrayList<Usable> getItemList() {
        return itemList;
    }

    public void setItemList(ArrayList<Usable> itemList) {
        this.itemList = itemList;
    }

    public ArrayList<SpecAttack> getSpecAttackList() {
        return specAttackList;
    }

    public void setSpecAttackList(ArrayList<SpecAttack> specAttackList) {
        this.specAttackList = specAttackList;
    }
    
    

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    public Equipable_Armor getWornArmor() {
        return wornArmor;
    }

    public void setWornArmor(Equipable_Armor wornArmor) {
        this.wornArmor = wornArmor;
    }

    public Equipable_Weapon getUsedWeapon() {
        return usedWeapon;
    }

    public void setUsedWeapon(Equipable_Weapon usedWeapon) {
        this.usedWeapon = usedWeapon;
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
            if(this.getUsedWeapon() != null){
                damageValue += usedWeapon.getPotency();
            }
            totalDamage = enemy.defend(damageValue);
        }
        
        return totalDamage;
    }//end attack
    
    public int defend(int damageValue) {
        int modifiedDamage = damageValue - this.stats.physDef;
        if(this.getWornArmor() != null){
            modifiedDamage -= wornArmor.getPotency();
        }
        
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
