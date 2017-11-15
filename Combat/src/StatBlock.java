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
    
    private int currentHealth;
    private int maxHealth;
    private int physDef;
    //private int specDef;   //to be added later
    private int physAtt;
    //private int specAtt;   //to be added later
    private int initiative;

    
    //constructors
    
    public StatBlock() {
    }

    public StatBlock(int currentHealth, int maxHealth, int physDef, int physAtt, int initiative) {
        this.currentHealth = currentHealth;
        this.maxHealth = maxHealth;
        this.physDef = physDef;
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

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    public int getPhysDef() {
        return physDef;
    }

    public void setPhysDef(int physDef) {
        this.physDef = physDef;
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
        return currentHealth/maxHealth;
    }
    
    
}
