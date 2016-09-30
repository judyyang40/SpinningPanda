import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * 
 * 
 * @author Judy Yang
 */
public class DeadMansIsland extends Island implements IIsland
{
   private String name = "Dead Man's Island";
    private boolean hasTreasure = false;
    private Island choiceA = null;
    private Island choiceB;
    private Location location = new Location(100, 25);
    
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
        choiceB = getWorld().getObjects(ShipwreckBay.class).get(0);
    }    
}
