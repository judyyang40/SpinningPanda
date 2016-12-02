import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.net.NetworkInterface;
import java.util.Enumeration;

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    //Island[] islands;
    IslandWorldComponent islandWorld;
    Ship ship;
    Button buttonA;
    Button buttonB;
    Button buttonReady;
    State[] states = new State[4];
    State currentState;
    String num = "-1";
    ScoreBoard score;
    String mac;
    Message waitmsg;
    
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
        int[] y = new int[]{100, 100, 330, 580, 380, 305, 100};
        
        islandWorld = new IslandWorldComponent();
        final int n = 7;
        for (int i = 0; i < n; ++i) {
            IslandLeaf leaf = new IslandLeaf(islandName[i], fileName[i]);
            islandWorld.addChildIsland(leaf);
            addObject(leaf, x[i], y[i]);
        }
    
        for (int i = 0; i < n; ++i) {
            IslandLeaf dA = destA[i] == -1 ? null : (IslandLeaf)islandWorld.getChildIsland(destA[i]);
            IslandLeaf dB = destB[i] == -1 ? null : (IslandLeaf)islandWorld.getChildIsland(destB[i]);
            islandWorld.getChildIsland(i).setDestinations(dA, dB);
        }
        islandWorld.getChildIsland(n-1).setTreasure();
        
        ship = new Ship((IslandLeaf)islandWorld.getChildIsland(2), "ship.JPG"); // All ships start from Pirate's Island
        
        addObject(ship, 450, 100);
    
        buttonA = new Button("a", 750, 610);
        buttonB = new Button("b", 920, 610);
        buttonReady = new Button("ready", 320, 280);
        score = new ScoreBoard();
        waitmsg = new Message();
        
        states[0] = new State("Init");
        states[1] = new State("Ready");
        states[2] = new State("Playing");
        states[3] = new State("Finished");
        setState(0);
        
        addObject(buttonReady, 520, 280);
        addObject(score, 750, 550);
        addObject(buttonA, 750, 610);
        addObject(buttonB, 920, 610);
        
        try{
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            byte[] mac = null;
            while(mac == null && networkInterfaces.hasMoreElements())
            {
                NetworkInterface network = networkInterfaces.nextElement();
                System.out.println("network : " + network);
                mac = network.getHardwareAddress();
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < mac.length; i++){
                sb.append(String.format("%02X%s", mac[i],(i< mac.length - 1)?"-":""));
            }
            this.mac = sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public State getState() {
        return currentState;
    }
    public void setState(int index) {
        currentState = states[index];
        System.out.println("Set Current State to " + currentState.getStateName());
    }
    
    public void win() {
        FinalActionCreator action = new WinActionCreator(this);
        action.exec(buttonA, buttonB);
    }
    
    public void fail() {
        FinalActionCreator action = new FailActionCreator(this);
        action.exec(buttonA, buttonB);
    }

    public void setNum (String _num)
    {
        this.num = _num;
    }

    public String getNum()
    {
        return this.num;
    }
    public ScoreBoard getScoreboard()
    {
        return score;
    }
    
    public String getMac()
    {
        return mac;
    }
    
    public void updateWaitMsg(int total) {
        waitmsg.setImage(new GreenfootImage("Waiting... Number of Players: " + total, 25, java.awt.Color.BLACK, java.awt.Color.WHITE));
        addObject(waitmsg, 800, 545);
    }
    
    public void removeWaitMsg() {
        removeObject(waitmsg);
    }
}
