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
    
    public Ship(Island island) {
        currentIsland = island;
    }
    
    public void gotoA(){
        currentIsland = currIsland.getA();
    }
    
    public void gotoB(){
        currentIsland = currIsland.getB();
    }
    
    public void moveTo(Island island){
        currentIsland = island;
    }
}
