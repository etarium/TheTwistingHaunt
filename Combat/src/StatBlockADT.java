/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author qn4795oh
 */
public interface StatBlockADT {
    
    public int getCurrentHealth();

    public void setCurrentHealth(int currentHealth);

    public int getMaxHealth();

    public int getSpecPoints();

    public void setSpecPoints(int specialPoints);
    
    

    public void setMaxHealth(int maxHealth);

    public int getPhysDef();

    public void setPhysDef(int physDef);

    public int getEvasion();

    public void setEvasion(int evasion);

    public int getPhysAtt();

    public void setPhysAtt(int physAtt);

    public int getInitiative();

    public void setInitiative(int initiative);
    
    //member methods
    
    public double healthPercentage();
    
    public boolean isAlive();
    
    public void decrementSpecPoints();
    
}
