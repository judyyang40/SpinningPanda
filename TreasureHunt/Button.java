import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Button class
 * 
 * @Qi Li
 * @1.0
 */
public class Button extends Actor
{
    String name;
    int x;
    int y;
    int width;
    int height;
    
    public Button(String _name, int _x, int _y)
    {
        this.name = _name;
        if(this.name.equals("a"))
        {
            setImage("button_a1.jpg");
        }else
        {
            setImage("button_b1.jpg");
        }
        this.x = _x;
        this.y = _y;
    }
    
    public void click()
    {
        if(Greenfoot.mouseClicked(this) && this.name.equals("a"))
        {
            MyWorld world = getWorld();
            world.getCurrentShip().gotoA();
        }
        if(Greenfoot.mouseClicked(this) && this.name.equals("b"))
        {
            MyWorld world = getWorld();
            world.getCurrentShip().gotoB();
        }
    }
    public void act() 
    {
        // Add your action code here.
    }    
}
