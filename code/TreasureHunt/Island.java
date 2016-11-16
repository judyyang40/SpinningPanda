import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * 
 * 
 * @author Judy Yang
 */
public class Island extends Actor
{
    private String name;
    private boolean hasTreasure = false;
    private Island choiceA = null;
    private Island choiceB = null;
    
    public Island(String name, String filename) {
        this.name = name;
        setImage(filename);
    }
    
    public String getName() {
        return name;
    }
        
    public void setDestinations(Island a, Island b) {
        choiceA = a;
        choiceB = b;
    }
    
    public Island getA() {
        return choiceA;
    }
    
    public Island getB() {
        return choiceB;
    }
    
    public void setTreasure() {
        assert (choiceA == null && choiceB == null);
        hasTreasure = true;
    }
    
    public boolean isTreasure(){ 
        return hasTreasure;
    }
    
    public void act() 
    {
        // Add your action code here.
        //getImage().setTransparency(0);
    } 
}
