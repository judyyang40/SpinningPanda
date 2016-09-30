import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * 
 * 
 * @author Judy Yang
 */
public class Island extends Actor implements IIsland
{
    private String name;
    private boolean hasTreasure = false;
    private Island choiceA = null;
    private Island choiceB = null;
    
    public Island(String name, String filename) {
        this.name = name;
        setImage(filename);
    }
        
    
    public void goToA() {
        goTo(choiceA);
    }
    
    public void goToB() {
        goTo(choiceB);
    }
    
    public void goTo(Island choice) {
        if (choice == null) {
            return;
        }
        for (int i = 0; i < 2; ++i) {
            choice.getImage().setTransparency(0);
            Greenfoot.delay(1000);
            choice.getImage().setTransparency(100);
            Greenfoot.delay(1000);
        }

    }
    
    public String getName() {
        return name;
    }
        
    public void setDestinations(Island a, Island b) {
        choiceA = a;
        choiceB = b;
    }
    
    public void setTreasure() {
        assert (choiceA == null && choiceB == null);
        hasTreasure = true;
    }
    
    public void act() 
    {
        // Add your action code here.
        getImage().setTransparency(50);
        goToA();
        Greenfoot.delay(1000);
        goToB();
        Greenfoot.delay(1000);
        getImage().setTransparency(50);
    } 
}
