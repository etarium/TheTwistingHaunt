/**
 *
 * @author Jason Richter, Samuel Fiscus
 */
public class StatBlock implements StatBlockADT{
    
    
    //data members
    
    protected int currentHealth;
    private int maxHealth;
    
    protected int specPoints;
    
    protected int physDef;
    protected int physAtt;
    
    //private int specDef;   //to be added later
    //private int specAtt;   //to be added later
    
    protected int evasion;
    protected int initiative;

    
    //constructors
    
    /**
     * Empty constructor for StatBlock.
     */
    public StatBlock() {
    }

    /**
     * Filled constructor for StatBlock.
     * @param currentHealth Integer representing current health
     * @param maxHealth Integer representing maximum health value
     * @param specPoints Integer representing current special attack points
     * @param physDef Integer representing physical defense value
     * @param evasion Integer representing evasion value
     * @param physAtt Integer representing physical attack value
     * @param initiative Integer representing initiative value
     */
    public StatBlock(int currentHealth, int maxHealth, int specPoints, int physDef, 
                        int evasion, int physAtt, int initiative) {
        this.currentHealth = currentHealth;
        this.maxHealth = maxHealth;
        this.specPoints = specPoints;
        this.physDef = physDef;
        this.evasion = evasion;
        this.physAtt = physAtt;
        this.initiative = initiative;
    }
    
    
    //getters and setters

    @Override
    public int getCurrentHealth() {
        return currentHealth;
    }

    @Override
    public void setCurrentHealth(int currentHealth) {
        this.currentHealth = currentHealth;
    }

    @Override
    public int getMaxHealth() {
        return maxHealth;
    }

    @Override
    public int getSpecPoints() {
        return specPoints;
    }

    @Override
    public void setSpecPoints(int specialPoints) {
        this.specPoints = specialPoints;
    }
    
    

    @Override
    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    @Override
    public int getPhysDef() {
        return physDef;
    }

    @Override
    public void setPhysDef(int physDef) {
        this.physDef = physDef;
    }

    @Override
    public int getEvasion() {
        return evasion;
    }

    @Override
    public void setEvasion(int evasion) {
        this.evasion = evasion;
    }

    @Override
    public int getPhysAtt() {
        return physAtt;
    }

    @Override
    public void setPhysAtt(int physAtt) {
        this.physAtt = physAtt;
    }

    @Override
    public int getInitiative() {
        return initiative;
    }

    @Override
    public void setInitiative(int initiative) {
        this.initiative = initiative;
    }
    
    //member methods
    @Override
    public double healthPercentage(){
        return (double)currentHealth/maxHealth;
    }
    
    @Override
    public boolean isAlive() {
        return currentHealth > 0;
    }
    
    @Override
    public void decrementSpecPoints(){
        this.setSpecPoints(specPoints - 1);
    }
    
}//end StatBlock class
