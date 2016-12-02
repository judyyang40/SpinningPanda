import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * 
 * 
 * @author Judy Yang
 */
public class IslandLeaf extends Actor implements IslandWorldComponent
{
    private String name;
    private boolean hasTreasure = false;
    private IslandLeaf choiceA = null;
    private IslandLeaf choiceB = null;
    
    public IslandLeaf(String name, String filename) {
        this.name = name;
        setImage(filename);
    }
    
    public String getName() {
        return name;
    }
        
    public void setDestinations(IslandLeaf a, IslandLeaf b) {
        choiceA = a;
        choiceB = b;
    }
    
    public IslandLeaf getA() {
        return choiceA;
    }
    
    public IslandLeaf getB() {
        return choiceB;
    }
    
    public void setTreasure() {
        assert (choiceA == null && choiceB == null);
        hasTreasure = true;
    }
    
    public boolean isTreasure(){ 
        return hasTreasure;
    }
    
    public void act() {} 
    
    public IslandWorldComponent getChildIsland(int i){
        return null;
    }
    
    public void addChildIsland(IslandWorldComponent c){}
    
    public void removeChildIsland(IslandWorldComponent c){}
}
