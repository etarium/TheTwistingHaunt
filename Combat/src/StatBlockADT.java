/**
 *
 * @author Jason Richter, Samuel Fiscus
 */
public interface StatBlockADT {
    
    /**
     * Returns Integer representing Entity's current health
     * @return Integer representing Entity's current health
     */
    public int getCurrentHealth();

    /**
     * Sets Entity's currentHealth field to Integer represented by passed value.
     * @param currentHealth Integer representing Entity's current health
     */
    public void setCurrentHealth(int currentHealth);

    /**
     * Returns Integer representing Entity's maximum health
     * @return Integer representing Entity's maximum health
     * @ensure getMaxHealth() &gt; 0
     */
    public int getMaxHealth();
    
    /**
     * Sets Entity's maxHealth field to Integer represented by passed value.
     * @param maxHealth Integer representing Entity's maximum health
     * @require maxHealth &gt; 0
     */
    public void setMaxHealth(int maxHealth);

    /**
     * Returns Integer representing Entity's special attack points
     * @return Integer representing Entity's special attack points
     */
    public int getSpecPoints();

    /**
     * Sets Entity's specPoints field to Integer represented by passed value.
     * @param specialPoints Integer representing Entity's special attack points
     * @require specialPoints &gt; 0
     */
    public void setSpecPoints(int specialPoints);

    
    /**
     * Returns Integer representing Entity's physical defense value
     * @return Integer representing Entity's physical defense value
     */
    public int getPhysDef();

    /**
     * Sets Entity's physDef field to Integer represented by passed value.
     * @param physDef Integer representing Entity's physical defense value
     */
    public void setPhysDef(int physDef);

    /**
     * Returns Integer representing Entity's evasion value
     * @return Integer representing Entity's evasion value
     */
    public int getEvasion();

    /**
     * Sets Entity's evasion field to Integer represented by passed value.
     * @param evasion Integer representing Entity's evasion value
     */
    public void setEvasion(int evasion);

    /**
     * Returns Integer representing Entity's physical attack value
     * @return Integer representing Entity's physical attack value
     */
    public int getPhysAtt();

    /**
     * Sets Entity's physAtt field to Integer represented by passed value.
     * @param physAtt Integer representing Entity's physical attack value
     */
    public void setPhysAtt(int physAtt);

    /**
     * Returns Integer representing Entity's initiative value
     * @return Integer representing Entity's initiative value
     */
    public int getInitiative();

    /**
     * Sets Entity's initiative field to Integer represented by passed value.
     * @param initiative Integer representing Entity's initiative value
     */
    public void setInitiative(int initiative);
    
    //member methods
    
    /**
     * Returns Double representing Entity's current health as a percentage of its maximum health.
     * @return Double representing Entity's current health as a percentage of its maximum health
     * @ensure healthPercentage() &lt;= 1
     */
    public double healthPercentage();
    
    /**
     * Returns boolean value representing whether Entity is alive, or if their current health is positive.
     * @return this.getCurrentHealth() &gt; 0
     */
    public boolean isAlive();
    
    /**
     * Decrements specPoint value after specAttack is used.
     * @ensure new.getSpecPoints() == old.getSpecPoints() - 1
     */
    public void decrementSpecPoints();
    
    /**
     * Provides a string representing the stats of an Entity formatted for output
     * @return String of all stats contained in the StatBlock object
     */
    public String toString();
    
}
