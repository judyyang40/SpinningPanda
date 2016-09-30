import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 650, 1); 
        prepare();
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        addObject( new ShipwreckBay(), 150, 100 );
        addObject( new DeadMansIsland(), 450, 100 );
        addObject( new PiratesIsland(), 185, 330 );
        addObject( new MusketHill(), 350, 580 );
        addObject( new MutineersIsland(), 550, 410 );
        addObject( new SmugglersCove(), 800, 305 );
        addObject( new TreasureIsland(), 800, 100);
    }
}
