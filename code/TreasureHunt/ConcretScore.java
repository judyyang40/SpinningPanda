import org.restlet.resource.*;
import org.restlet.representation.*;
import org.restlet.ext.json.*;
import org.restlet.data.*;
import java.net.InetAddress;
import java.net.NetworkInterface;
import org.json.*;
import java.util.*;
import greenfoot.*; 
public class ConcretScore extends AbstractScore
{
    public void playing(MyWorld mw)
    {
        JSONObject req = new JSONObject();
            try {
                req.put("mac", mw.getMac());
            
                IslandLeaf curr = mw.getCurrentShip().getCurrentIsland();
                req.put("location", curr.getName());
                //System.out.println(req.toString());
                ClientResource client = new ClientResource("http://island-c595ac2d.ee19226d.svc.dockerapp.io:3000/update");
                Representation result = client.post(new JsonRepresentation(req), MediaType.APPLICATION_JSON);
                super.setResult(result);
                JSONObject msg = new JSONObject(result.getText());
                if(!msg.get("finish").toString().equals("true")){
                ArrayList<String> list = new ArrayList<String>();     
                JSONArray jsonArray = (JSONArray)msg.get("location"); 
                if (jsonArray != null) { 
                    int len = jsonArray.length();
                    for (int i=0;i<len;i++){ 
                        list.add(jsonArray.get(i).toString());
                        Actor playermsg = new Actor(){};
                        int u = i+1;
                        playermsg.setImage(new GreenfootImage("Player"+u+": " + list.get(i), 10, java.awt.Color.BLACK, java.awt.Color.WHITE));
                        mw.addObject(playermsg, 700, 475 + 10*i);
                    } 
                } 
            }
        } catch (Exception e) {
                System.out.println(e);
            }
    }
}
