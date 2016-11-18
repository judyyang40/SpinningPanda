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
        }else if(this.name.equals("b"))
        {
            setImage("button_b1.jpg");
        }else if (this.name.equals("ready"))
        {
            setImage("button_ready.png");
        } else if (this.name.equals("gameover")) {
            setImage("Game_over.png");
        } else if (this.name.equals("win")) {
            setImage("win.jpg");  
        } else if (this.name.equals("fail")) {
            setImage("fail.jpg");
        }
        this.x = _x;
        this.y = _y;
    }
    
    public void click()
    {
        if(Greenfoot.mouseClicked(this) && this.name.equals("a"))
        {
            MyWorld world = (MyWorld) getWorld();
            world.getCurrentShip().gotoA();
        }
        if(Greenfoot.mouseClicked(this) && this.name.equals("b"))
        {
            MyWorld world = (MyWorld) getWorld();
            world.getCurrentShip().gotoB();
        }
        if(Greenfoot.mouseClicked(this) && this.name.equals("ready") && ((MyWorld)getWorld()).getState().name.equals("Init"))
        {
            MyWorld world = (MyWorld) getWorld();
            world.setState(1);
            world.removeObject(this);
        }
    }
    public void act() 
    {
        // Add your action code here.
        click();
    }    
}
