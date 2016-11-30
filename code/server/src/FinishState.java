package api;

import java.util.Timer;

import org.json.JSONObject;
//import org.restlet.ext.json.JsonRepresentation;
//import org.restlet.representation.Representation;

public class FinishState implements State {
	private static final int time = 3000;
	private String name;
	private Server server;
	private Timer timer;
	
	
	public FinishState(String name, Server server)
	{
		this.name = name;
		this.server = server;
	}
	
	public JSONObject request(String mac)
    {
		int player_No = server.getPlayer(mac);  // get the player No.
    	JSONObject res = new JSONObject();
    	
    	if (-1 == player_No)
    	{
    		res.put("status", "refuse");
    	}
    	else
    	{
    		res.put("finish", true);
			res.put("winner", server.getWinnerNo());
    	}
    	
    	return res;
    }
	
	public JSONObject update(String mac, String location)
	{
		JSONObject res = new JSONObject();
		
		int play_No = server.getPlayer(mac);
		
		if (-1 == play_No)
		{
			res.put("err", "mac_err");
		}
		else
		{
		    res.put("finish", true);
		    res.put("winner", server.getWinnerNo());
		}
		
		return res;
		
	}
	
	public String getName() {return this.name;}
	
	public void timeOut() { server.setState(server.getWaitState()); }
	
	public void entry()
	{
		timer = new Timer();
		timer.schedule(new TimerOut(server), time);
	}
    
    public void finish()
    {
        server.init();
    }
}
