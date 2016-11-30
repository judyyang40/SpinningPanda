import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class WinAction here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WinActionCreator extends FinalActionCreator
{
    public WinActionCreator(World w) {
        super(w);
    }
    
    public Action getAction() {
        return new WinAction();
    }
 
}
