/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author qn4795oh
 */
public class StatBlock {
    
    
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
    
    public StatBlock() {
    }

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

    public int getCurrentHealth() {
        return currentHealth;
    }

    public void setCurrentHealth(int currentHealth) {
        this.currentHealth = currentHealth;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public int getSpecPoints() {
        return specPoints;
    }

    public void setSpecPoints(int specialPoints) {
        this.specPoints = specialPoints;
    }
    
    

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    public int getPhysDef() {
        return physDef;
    }

    public void setPhysDef(int physDef) {
        this.physDef = physDef;
    }

    public int getEvasion() {
        return evasion;
    }

    public void setEvasion(int evasion) {
        this.evasion = evasion;
    }

    public int getPhysAtt() {
        return physAtt;
    }

    public void setPhysAtt(int physAtt) {
        this.physAtt = physAtt;
    }

    public int getInitiative() {
        return initiative;
    }

    public void setInitiative(int initiative) {
        this.initiative = initiative;
    }
    
    //member methods
    
    public double healthPercentage(){
        return (double)currentHealth/maxHealth;
    }
    
    public boolean isAlive() {
        return currentHealth > 0;
    }
    
    public void decrementSpecPoints(){
        this.setSpecPoints(specPoints - 1);
    }
    
}
