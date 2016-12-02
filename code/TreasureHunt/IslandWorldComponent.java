import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Interface for Islands
 * 
 * @author Judy Yang
 */
public interface IslandWorldComponent
{
    void addChildIsland(IslandWorldComponent c);
    void removeChildIsland(IslandWorldComponent c);
    IslandWorldComponent getChildIsland(int i);
    
    public String getName();
    public void setDestinations(IslandLeaf a, IslandLeaf b);
    public IslandLeaf getA();
    public IslandLeaf getB();
    public void setTreasure();
    public boolean isTreasure();
}
