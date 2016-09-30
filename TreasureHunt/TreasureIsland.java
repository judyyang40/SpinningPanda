import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * 
 * 
 * @author Judy Yang
 */
public class TreasureIsland extends Island implements IIsland
{
   private String name = "Treasure Island";
    private boolean hasTreasure = false;
    private Island choiceA = null;
    private Island choiceB = null;
    private Location location = new Location(800, 100);
    
    public void goToA() {
    }
    
    public void goToB() {
    }
    
    public int getLocationX() {
        return location.getLocationX();
    }
    
    public int getLocationY() {
        return location.getLocationY();
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
