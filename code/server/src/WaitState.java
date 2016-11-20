package api;
    
import org.json.* ;
//import org.restlet.representation.* ;
//import org.restlet.ext.json.* ;
//import org.restlet.resource.* ;

public class WaitState implements State {
	
	private String name;
	private Server server;

	public WaitState(String name, Server server)
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
    		player_No = server.addPlayer(mac);
    		player_num = server.getPlayerNum();
            res.put("you", player_No);
            res.put("total", player_num);
            
    		if (server.player_max_num == player_num)
    		{
    			res.put("status", "ready");
    			server.setState(server.getPlayState());
    		}
    		else
    		{
    			res.put("status", "wait");
    		}
    	}
    	else
    	{
    		res.put("status", "ready");
			res.put("you", player_No);
			res.put("total", player_num);
    	}
    	
    	return res;
    }
    
	
	public JSONObject update(String mac, String location) 
	{ 
		JSONObject res = new JSONObject();
		
		res.put("err", "type_err");
		
		return res;
	}
	
	public void timeOut() { return; }
	
	public void entry() 
	{
		// server.init();
		// return; 
	}
	
	public String getName() { return this.name;}

}
