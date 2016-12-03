import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import org.restlet.resource.*;
import org.restlet.representation.*;
import org.restlet.ext.json.*;
import org.restlet.data.*;
import java.net.InetAddress;
import java.net.NetworkInterface;
import org.json.*;
import java.util.*;
/**
 * Write a description of class ScoreBoard here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ScoreBoard extends Actor
{
    MyWorld mw = null;
    
    public ScoreBoard()
    {
        mw = (MyWorld)getWorld();
    }
    /**
     * Act - do whatever the ScoreBoard wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        mw = (MyWorld)getWorld();
        if(((MyWorld)getWorld()).getState().name.equals("Playing"))
        {
            if(mw.getObjects(Message.class).size() != 0)
                mw.removeWaitMsg();
            
            //
            mw.play();
            }else{
                //
                try{
                mw.end();
            }catch(java.lang.Exception e)
            {}
            }
          
    }    
}
