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
        setLocation(currentIsland.getX(), currentIsland.getY());
        setImage(filename);
    }
    
    public void gotoA(){
        currentIsland = currentIsland.getA();
        setLocation(currentIsland.getX(), currentIsland.getY());
        if(currentIsland.isTreasure()){
           ((MyWorld)getWorld()).setState(3);
           //((MyWorld)getWorld()).win();
        }
    }
    
    public void gotoB(){
        currentIsland = currentIsland.getB();
        setLocation(currentIsland.getX(), currentIsland.getY());
        if(currentIsland.isTreasure()){
           ((MyWorld)getWorld()).setState(3);
           //((MyWorld)getWorld()).win();
        }
    }
    
    public void moveTo(Island island){
        currentIsland = island;
        setLocation(currentIsland.getX(), currentIsland.getY());
        if(currentIsland.isTreasure()){
           ((MyWorld)getWorld()).setState(3);
           //((MyWorld)getWorld()).win();
        }
    }
    public Island getCurrentIsland()
    {
        return currentIsland;
    }
    
    public void act() 
    {
        //getImage().setTransparency(0);
    } 
}