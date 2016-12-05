import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;

public class IslandComposite extends Actor implements IslandWorldComponent 
{
    private ArrayList<IslandWorldComponent> islands = new ArrayList<IslandWorldComponent>();
    
    public void addChildIsland(IslandWorldComponent c){
        islands.add(c);
    }
    
    public void removeChildIsland(IslandWorldComponent c){
        islands.remove(c);
    }
    
    public IslandWorldComponent getChildIsland(int i) {
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
