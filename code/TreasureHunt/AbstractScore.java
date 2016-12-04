import greenfoot.*; 
import org.restlet.resource.*;
import org.restlet.representation.*;
import org.restlet.ext.json.*;
import org.restlet.data.*;
import java.net.InetAddress;
import java.net.NetworkInterface;
import org.json.*;
import java.util.*;
abstract class AbstractScore  
{
    
    abstract void playing(MyWorld w);
    public void end(MyWorld mw, JSONObject msg) throws Exception
    {
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
}
