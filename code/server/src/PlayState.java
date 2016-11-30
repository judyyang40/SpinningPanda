package api;

import org.json.JSONObject;
//import org.restlet.ext.json.JsonRepresentation;
//import org.restlet.representation.Representation;

public class PlayState implements State {
    
	private String name;
	private Server server;
	
	public PlayState(String name, Server server)
	{
		this.name = name;
		this.server = server;
	}
	
	public JSONObject request(String mac)
    {
		int player_No = server.getPlayer(mac);  // get the player No.
        int player_num = server.getPlayerNum(); //get the number of players
    	JSONObject res = new JSONObject();
    	
    	if (-1 == player_No)
    	{
    		res.put("status", "refuse");
    	}
    	else
    	{
    		res.put("you", player_No);
            res.put("total", player_num);
            res.put("status", "ready");
    	}
    	
    	return res;
    }
	
	public JSONObject update(String mac, String location)
	{
		JSONObject res = new JSONObject();
		int player_No = server.getPlayer(mac);
		if (-1 == player_No)
		{
			res.put("err", "mac_err");
		}
		else if (location.equals(server.treaIsland))
		{
             server.setWinnerNo(player_No);
             server.setLocation(player_No, location);
             
             server.setState(server.getFinishState());
             
             res.put("finish", true);
             res.put("winner", player_No);
		}
		else
		{
			server.setLocation(player_No, location);
			res.put("finish", false);
			res.put("location", server.getAllLocation());
		}
		
		return res;
		
	}
	
	public String getName() { return this.name;}
	
	public void timeOut() { return; }
	
	public void entry() { return; }
}
