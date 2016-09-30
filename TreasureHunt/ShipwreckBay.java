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
        choiceA = getWorld().getObjects(MusketHill.class).get(0);
        choiceB = getWorld().getObjects(DeadMansIsland.class).get(0);
        getImage().setTransparency(0);
    }    
}
