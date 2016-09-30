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
        choiceB = getWorld().getObjects(ShipwreckBay.class).get(0);
        getImage().setTransparency(0);
    }    
}
