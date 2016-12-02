import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;

public class IslandWorldComponent extends Actor implements IIslandWorldComponent 
{
    ArrayList<IIslandWorldComponent> islands = new ArrayList<IIslandWorldComponent>();
    
    public void addChildIsland(IIslandWorldComponent c){
        islands.add(c);
    }
    
    public void removeChildIsland(IIslandWorldComponent c){
        islands.remove(c);
    }
    
    public IIslandWorldComponent getChildIsland(int i) {
        return islands.get(i);
    }
    
    public String getName(){
        return "IslandWorld";
    }
    
    public void setDestinations(IslandLeaf a, IslandLeaf b){}
    
    public IslandLeaf getA(){
        return null;
    }
    
    public IslandLeaf getB(){
        return null;
    }
    
    public void setTreasure(){}
    
    public boolean isTreasure(){
        return false;
    }
}
