
import java.util.ArrayList;

/**
 *
 * @author Jason Richter, Samuel Fiscus
 */
public interface EntityADT {
    
    /**
     * Returns StatBlock object representing Entity's core attributes.
     * @return StatBlock representing Entity's core attributes.
     */
    public StatBlock getStats();

    /**
     * Assigns StatBlock object representing Entity's core attributes to Entity's stats field.
     * @param stats StatBlock representing Entity's core attributes
     * @require stats != null
     */
    public void setStats(StatBlock stats);

    /**
     * Returns String representing Entity's name
     * @return String representing Entity's name
     * @ensure name != null
     */
    public String getName();

    /**
     * Assigns String representing Entity's name to Entity's name field
     * @param name String representing Entity's name
     * @require name != null
     */
    public void setName(String name);

    /**
     * Returns ArrayList of Usables belonging to Entity.
     * @return ArrayList&lt;Usable&gt; representing the list of Usables that an Entity posseses.
     * @ensure getItemList() != null
     */
    public ArrayList<Usable> getItemList();

    /**
     * Assigns ArrayList of Usables to Entity's itemList field.
     * @param itemList ArrayList&lt;Usable&gt; representing the list of Usables that an Entity posseses
     * @require itemList != null
     */
    public void setItemList(ArrayList<Usable> itemList);

    /**
     * Returns ArrayList of SpecAttack belonging to Entity.
     * @return ArrayList&lt;specAttack&gt; representing the list of SpecAttacks that an Entity posseses
     * @ensure getSpecAttackList() != null
     */
    public ArrayList<SpecAttack> getSpecAttackList();

    /**
     * Assigns ArrayList of SpecAttack to Entity's specAttackList field.
     * @param specAttackList ArrayList&lt;specAttack&gt; representing the list of SpecAttacks that an Entity posseses
     * @require specAttackList != null
     */
    public void setSpecAttackList(ArrayList<SpecAttack> specAttackList);
    
    /**
     * Returns Integer representing Entity's team
     * @return Integer representing Entity's team
     */
    public int getTeamId();

    /**
     * Assigns Integer representing Entity's team to teamID field
     * @param teamId Integer representing Entity's team
     */
    public void setTeamId(int teamId);

    /**
     * Returns Equipable_Armor object representing Entity's worn armor.
     * @return Equipable_Armor object representing Entity's worn armor.
     * @ensure getWornArmor != null
     */
    public Equipable_Armor getWornArmor();

    /**
     * Assigns an Equipable_Armor object representing Entity's wornArmor to wornArmor field
     * @param wornArmor Equipable_Armor object representing Entity's worn armor
     */
    public void setWornArmor(Equipable_Armor wornArmor);

    /**
     * Returns Equipable_Weapon object representing Entity's used weapon.
     * @return Equipable_Weapon object representing Entity's used weapon.
     * @ensure getWornArmor != null
     */
    public Equipable_Weapon getUsedWeapon();

    /**
     * Assigns an Equipable_Weapon object representing Entity's used weapon to usedWeapon field
     * @param usedWeapon Equipable_Weapon object representing Entity's used weapon
     */
    public void setUsedWeapon(Equipable_Weapon usedWeapon);
    
    //class methods
    /**
     * Basic attack method against target Entity.
     * @param enemy Entity to be the target of attack
     * @return Integer representing damage generated from attack
     * @require enemy != null
     * @ensure this.attack(enemy) &gt;= 0
     */
    public int attack(Entity enemy);
    
    /**
     * Basic defend method receiving damageValue returned from attack method.
     * @param damageValue Integer representing damage generated from an Entity's attack
     * @return Integer representing modified damage after reductions from armor, etc.
     */
    public int defend(int damageValue);
    
    /**
     * Returns a list of all living Entity enemies.
     * @param list ArrayList&lt;Entity&gt; containing all Entities from current Encounter
     * @return ArrayList&lt;Entity&gt; containing all living enemies
     */
    public ArrayList<Entity> getTargetList(ArrayList<Entity> list);
        
    /**
     * Returns randomly chosen Entity from passed ArrayList of target Entities
     * @param targetList ArrayList&lt;Entity&gt; containing all living enemies from current Encounter
     * @return Randomly chosen Entity to be passed as target
     */
    public Entity chooseTarget(ArrayList<Entity> targetList);
    
    /**
     * Generates String output from selection structure based off of passed damage.
     * @param damageValue Integer representing damage dealt to target Entity
     * @param target Entity receiving damage
     */
    public void combatDialog(int damageValue, Entity target);
    
    @Override
    public String toString();
    
}
