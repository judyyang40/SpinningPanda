import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * 
 * 
 * @author Judy Yang
 */
public class ShipwreckBay extends Island implements IIsland
{
    private String name = "Shipwreck Bay";
    private boolean hasTreasure = false;
    private Island choiceA;
    private Island choiceB;
    private Location location = new Location(50, 50);
    
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
        choiceB = getWorld().getObjects(DeadMansIsland.class).get(0);
    }    
}
