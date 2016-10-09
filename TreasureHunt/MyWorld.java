import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    Island[] islands;
    Ship ship;
    Button buttonA;
    Button buttonB;
    
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
    
    public Ship getCurrentShip() {
        return ship;
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        String[] islandName = new String[]{"Ship Wreck Bay",
            "Dead Man's Island",
            "Pirate's Island",
            "Musket Hill",
            "Mutineer's Island",
            "Smuggler's Cove",
            "Treasure Island"};
        String[] fileName = new String[]{"Shipwreck_bay.JPG", 
            "Deadman_island.JPG", 
            "Pirates_island.JPG", 
            "Musket_hill.JPG", 
            "Mutineers_island.JPG", 
            "Smugglers_cove.JPG", 
            "Treasure_island.JPG"};
        int[] destA = new int[]{3, 3, 0, 2, 5, 2, -1};
        int[] destB = new int[]{1, 0, 3, 4, 1, 6, -1};
        int[] x = new int[]{150, 450, 185, 350, 550, 800, 800};
        int[] y = new int[]{100, 100, 330, 580, 410, 305, 100};
        
        islands = new Island[7];
        final int n = 7;
        for (int i = 0; i < n; ++i) {
            islands[i] = new Island(islandName[i], fileName[i]);
            addObject(islands[i], x[i], y[i]);
        }

        for (int i = 0; i < n; ++i) {
            Island dA = destA[i] == -1 ? null : islands[destA[i]];
            Island dB = destB[i] == -1 ? null : islands[destB[i]];
            islands[i].setDestinations(dA, dB);
        }
        islands[n - 1].setTreasure();
        
        ship = new Ship(islands[2], "ship.JPG"); // All ships start from Pirate's Island

        buttonA = new Button("a", 400, 610);
        buttonB = new Button("b", 600, 610);
        addObject(buttonA, 600, 610);
        addObject(buttonB, 800, 610);
    }
}
