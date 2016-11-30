import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import org.restlet.resource.*;
import org.restlet.representation.*;
import org.restlet.ext.json.*;
import org.restlet.data.*;
import org.json.JSONObject;
import java.net.NetworkInterface;
import java.util.Enumeration;

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
    Actor waitmsg = new Actor(){};
    
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
        if(Greenfoot.mouseClicked(this) && this.name.equals("a") && ((MyWorld)getWorld()).getState().name.equals("Playing"))
        {
            MyWorld world = (MyWorld) getWorld();
            world.getCurrentShip().gotoA();
        }
        if(Greenfoot.mouseClicked(this) && this.name.equals("b") && ((MyWorld)getWorld()).getState().name.equals("Playing"))
        {
            MyWorld world = (MyWorld) getWorld();
            world.getCurrentShip().gotoB();
        }
        if(Greenfoot.mouseClicked(this) && this.name.equals("ready") && ((MyWorld)getWorld()).getState().name.equals("Init"))
        {
            MyWorld world = (MyWorld) getWorld();
            world.setState(1);
            GreenfootImage img = getImage();
            img.scale(1, 2);
            setImage(img);
        }
    }
    public void act() 
    {
        // Add your action code here.
        click();
        if(((MyWorld)getWorld()).getState().name.equals("Ready")) {//make requests to server and receive response
            
            JSONObject req = new JSONObject();
            req.put("mac", ((MyWorld)getWorld()).getMac());
            
            System.out.println("Join from button: " + req.get("mac"));
            
            ClientResource client = new ClientResource("http://island-c595ac2d.ee19226d.svc.dockerapp.io:3000/join");
            Representation result = client.post(new JsonRepresentation(req), MediaType.APPLICATION_JSON);
            
            try {
                JSONObject msg = new JSONObject(result.getText());
                /*msg.put("status", "ready");
                msg.put("status", "wait");
                msg.put("you", 2);
                msg.put("total", 4);*/
                
                if(msg.get("status").equals("wait")) {
                    waitmsg.setImage(new GreenfootImage("Waiting... Number of Players: " + msg.get("total").toString(), 25, java.awt.Color.BLACK, java.awt.Color.WHITE));
                    ((MyWorld)getWorld()).addObject(waitmsg, 800, 545);
                    Actor playermsg = new Actor(){};
                    playermsg.setImage(new GreenfootImage("Player" + msg.get("you").toString(), 40, java.awt.Color.BLACK, java.awt.Color.WHITE));
                    ((MyWorld)getWorld()).setNum(msg.get("you").toString());
                    ((MyWorld)getWorld()).addObject(playermsg, 600, 610);
                }
                else if(msg.get("status").equals("ready")) {
                    ((MyWorld)getWorld()).removeObject(waitmsg);
                    ((MyWorld)getWorld()).setState(2);
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        } 
    }
}
