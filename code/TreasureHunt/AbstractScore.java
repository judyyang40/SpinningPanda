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
    Representation re = null;
    abstract void playing(MyWorld w);
    public void end(MyWorld mw) throws Exception
    {
        JSONObject msg = new JSONObject(getResult().getText());
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
    public Representation getResult()
    {
        return this.re;
    }
    public void setResult(Representation r)
    {
        this.re = r;
    }
}
