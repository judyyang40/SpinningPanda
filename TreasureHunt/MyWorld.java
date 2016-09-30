import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    Island shipWreckBay;
    Island deadMansIsland;
    Island piratesIsland;
    Island musketHill;
    Island mutineersIsland;
    Island smugglersCove;
    Island treasureIsland;
    
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
        shipWreckBay = new Island("Ship Wreck Bay", "Shipwreck_bay.JPG");
        deadMansIsland = new Island("Dead Man's Island", "Deadman_island.JPG");
        piratesIsland = new Island("Pirate's Island", "Pirates_island.JPG");
        musketHill = new Island("Musket Hill", "Musket_hill.JPG");
        mutineersIsland = new Island("Mutineer's Island", "Mutineers_island.JPG");
        smugglersCove = new Island("Smuggler's Cove", "Smugglers_cove.JPG");
        treasureIsland = new Island("Treasure Island", "Treasure_island.JPG");
        
        shipWreckBay.setDestinations(musketHill, deadMansIsland);
        deadMansIsland.setDestinations(null, shipWreckBay);
        piratesIsland.setDestinations(shipWreckBay, musketHill);
        musketHill.setDestinations(piratesIsland, mutineersIsland);
        mutineersIsland.setDestinations(smugglersCove, deadMansIsland);
        smugglersCove.setDestinations(piratesIsland, treasureIsland);
        treasureIsland.setTreasure();
        
        addObject( shipWreckBay, 150, 100 );
        addObject( deadMansIsland, 450, 100 );
        addObject( piratesIsland, 185, 330 );
        addObject( musketHill, 350, 580 );
        addObject( mutineersIsland, 550, 410 );
        addObject( smugglersCove, 800, 305 );
        addObject( treasureIsland, 800, 100);
    }
}
