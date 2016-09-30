import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * 
 * 
 * @author Judy Yang
 */
public class TreasureIsland extends Island implements IIsland
{
   private String name = "Treasure Island";
    private boolean hasTreasure = true;
    private Island choiceA = null;
    private Island choiceB = null;
    
    public void goToA() {
    }
    
    public void goToB() {
    }
    
    public int getLocationX() {
        return getX();
    }
    
    public int getLocationY() {
        return getY();
    }
    
    public String getName() {
        return name;
    }
    
    public void act() 
    {
        // Add your action code here.
        getImage().setTransparency(0);
    }    
}
