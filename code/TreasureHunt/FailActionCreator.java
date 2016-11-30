import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class FailAction here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FailActionCreator extends FinalActionCreator
{
    public FailActionCreator(World w) {
        super(w);
    }
    
    public  Action getAction() {
        return new FailAction();
    }  
}
