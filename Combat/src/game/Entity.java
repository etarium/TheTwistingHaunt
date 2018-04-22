package game;

/**
 *
 * @author Jason Richter, Samuel Fiscus
 */

import java.util.Random;
import java.io.Serializable;
import java.util.ArrayList;

public class Entity implements EntityADT, Serializable{
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 87412221688282868L;
	private StatBlock stats;
    private String name;
    private String description;
    private String teamId; //id of entity's team
    private ArrayList<Usable> itemList;
    private ArrayList<SpecAttack> specAttackList;
    private ArrayList<KeyItems> keyItemsList;
    
    private Equipable_Armor wornArmor;
    private Equipable_Weapon usedWeapon;
    
    Random rng = new Random();
    
    /**
     * Empty Entity constructor
     */
    public Entity(){
    }
    
    /**
     * Filled Entity constructor
     * @param stats StatBlock representing Entity's core attributes
     * @param name String representing Entity's name
     * @param teamId  Integer representing Entity's team
     */
    public Entity(StatBlock stats, String name, String description, String teamId){
        this.stats = stats;
        this.name = name;
        this.teamId = teamId;
        this.itemList = new ArrayList<>();
        this.specAttackList = new ArrayList<>();
        this.keyItemsList = new ArrayList<>();
    }
    

    //getters and setters
    @Override
    public StatBlock getStats() {
        return stats;
    }

    @Override
    public void setStats(StatBlock stats) {
        this.stats = stats;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public ArrayList<Usable> getItemList() {
        return itemList;
    }

    @Override
    public void setItemList(ArrayList<Usable> itemList) {
        this.itemList = itemList;
    }

    @Override
    public ArrayList<SpecAttack> getSpecAttackList() {
        return specAttackList;
    }

    @Override
    public void setSpecAttackList(ArrayList<SpecAttack> specAttackList) {
        this.specAttackList = specAttackList;
    }

    public ArrayList<KeyItems> getKeyItemsList() {
		return keyItemsList;
	}

	public void setKeyItemsList(ArrayList<KeyItems> keyItemsList) {
		this.keyItemsList = keyItemsList;
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
    public String getTeamId() {
        return teamId;
    }

    @Override
    public void setTeamId(String teamId) {
        this.teamId = teamId;
    }

    @Override
    public Equipable_Armor getWornArmor() {
        return wornArmor;
    }

    @Override
    public void setWornArmor(Equipable_Armor wornArmor) {
        this.wornArmor = wornArmor;
    }

    @Override
    public Equipable_Weapon getUsedWeapon() {
        return usedWeapon;
    }

    @Override
    public void setUsedWeapon(Equipable_Weapon usedWeapon) {
        this.usedWeapon = usedWeapon;
    }
    
    
    
    
    
    
    //class methods
    @Override
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
    
    @Override
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
    
    @Override
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
        
    @Override
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
    @Override
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
    
    public void printEntityInfo(){  //method formatted for an "inspect" command of some type
        String output =             //or player looking at their stats
                this.getName()+"\n"+
                "***********************************\n"+
                this.getStats().toString();
        System.out.println(output);
    }
    
    @Override
    public String toString(){
        return String.format("%s%n"
                           + "\tHealth: %s --- %3.0f%%",
                            name, stats.currentHealth, 
                            stats.healthPercentage() * 100);
    }
}//end Entity
