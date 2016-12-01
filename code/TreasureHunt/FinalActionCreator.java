import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class FinalAction here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class FinalActionCreator
{
    private World myWorld;
    
    public FinalActionCreator(World w) {
        myWorld = w;
    }
    
    public abstract Action getAction();

    public void exec(Button buttonA, Button buttonB) 
    {
        myWorld.removeObject(buttonA);
        myWorld.removeObject(buttonB);
        getAction().ExtraAction(((MyWorld)myWorld).getCurrentShip());
        Button button = new Button(getAction().getFinalResult(), 320, 280);
        myWorld.addObject(button, 520, 280);
        Greenfoot.delay(300);
        Button buttonGameOver = new Button("gameover", 320, 280);
        myWorld.addObject(buttonGameOver, 520, 280);
    }    
}
