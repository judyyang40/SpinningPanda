import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Interface for Islands
 * 
 * @author Judy Yang
 */
public interface IIslandWorldComponent
{
    void addChildIsland(IIslandWorldComponent c);
    void removeChildIsland(IIslandWorldComponent c);
    IIslandWorldComponent getChildIsland(int i);
    
    public String getName();
    public void setDestinations(IslandLeaf a, IslandLeaf b);
    public IslandLeaf getA();
    public IslandLeaf getB();
    public void setTreasure();
    public boolean isTreasure();
}
