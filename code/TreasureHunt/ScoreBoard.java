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
            JSONObject req = new JSONObject();
            req.put("mac", mw.getMac());
            
            Island curr = mw.getCurrentShip().getCurrentIsland();
            req.put("location", curr.getName());
            //System.out.println(req.toString());
            ClientResource client = new ClientResource("http://island-c595ac2d.ee19226d.svc.dockerapp.io:3000/update");
            Representation result = client.post(new JsonRepresentation(req), MediaType.APPLICATION_JSON);
            try {
                JSONObject msg = new JSONObject(result.getText());
                /*msg.put("status", "ready");
                msg.put("status", "wait");
                msg.put("you", 2);
                msg.put("total", 4);*/
                if(!msg.get("finish").toString().equals("true")){
                ArrayList<String> list = new ArrayList<String>();     
                JSONArray jsonArray = (JSONArray)msg.get("location"); 
                if (jsonArray != null) { 
                    int len = jsonArray.length();
                    for (int i=0;i<len;i++){ 
                        list.add(jsonArray.get(i).toString());
                        Actor playermsg = new Actor(){};
                        playermsg.setImage(new GreenfootImage("Player"+i+": " + list.get(i), 10, java.awt.Color.BLACK, java.awt.Color.WHITE));
                        mw.addObject(playermsg, 800, 600 + 10*i);
                    } 
                } 
            }else{
                mw.setState(3);
                System.out.println(msg.get("winner").toString());
                if(msg.get("winner").toString().equals(mw.getNum()))
                {
                    mw.win();
                }
                else{
                    mw.fail();
                }
            }
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }    
}
