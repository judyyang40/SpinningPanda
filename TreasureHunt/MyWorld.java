import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{

    TreasureIsland tIsland;
    ShipwreckBay sBay;
    MutineersIsland mIsland;
    PiratesIsland pIsland;
    SmugglersCove sCove;
    DeadMansIsland dmIsland;
    MusketHill mHill;
    java.util.Set<Integer> set;
    Integer[] index;
    
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
        tIsland = new TreasureIsland();
        sBay = new ShipwreckBay();
        mIsland = new MutineersIsland();
        pIsland = new PiratesIsland();
        sCove = new SmugglersCove();
        dmIsland = new DeadMansIsland();
        mHill = new MusketHill();
        java.util.List list = new java.util.ArrayList();
        list.add(tIsland);
        list.add(sBay);
        list.add(mIsland);
        list.add(pIsland);
        list.add(sCove);
        list.add(dmIsland);
        list.add(mHill);
        
        generateRIsland();
        addObject( (Actor)list.get(index[0]), 150, 100 );
        addObject( (Actor)list.get(index[1]), 450, 100 );
        addObject( (Actor)list.get(index[2]), 185, 330 );
        addObject( (Actor)list.get(index[3]), 350, 580 );
        addObject( (Actor)list.get(index[4]), 550, 410 );
        addObject( (Actor)list.get(index[5]), 800, 305 );
        addObject( (Actor)list.get(index[6]), 800, 100);
    }
    
    public void generateRIsland()
    {
       java.util.Random ran = new java.util.Random();
       set = new java.util.LinkedHashSet<Integer>();
       while(set.size() < 7){
           set.add(ran.nextInt(7));
        }
        index = set.toArray(new Integer[set.size()]);
    }
    
    public TreasureIsland getTreasureIsland()
    {
        return tIsland;
    }
    public ShipwreckBay getShipwreckBay()
    {
        return sBay;
    }
    public MutineersIsland getMutineersIsland()
    {
        return mIsland;
    }
    public PiratesIsland getPiratesIsland()
    {
        return pIsland;
    }
    public SmugglersCove getSmugglersCove()
    {
        return sCove;
    }
    public DeadMansIsland getDeadMansIsland()
    {
        return dmIsland;
    }
    public MusketHill getMusketHill()
    {
        return mHill;
    }
}