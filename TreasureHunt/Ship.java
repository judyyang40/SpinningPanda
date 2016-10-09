import greenfoot.*;

/**
 * Write a description of class Ship here.
 * 
 * @Tao Geng 
 * @10/5/2016
 */
public class Ship extends Actor
{
    Island currentIsland;
    
    public Ship(Island island, String filename) {
        currentIsland = island;
        setImage(filename);
    }
    
    public void gotoA(){
        currentIsland = currentIsland.getA();
    }
    
    public void gotoB(){
        currentIsland = currentIsland.getB();
    }
    
    public void moveTo(Island island){
        currentIsland = island;
    }
}
