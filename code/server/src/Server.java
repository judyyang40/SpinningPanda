package api;

import org.json.* ;
//import org.restlet.representation.* ;
//import org.restlet.ext.json.* ;
//import org.restlet.resource.* ;

public class Server {
	
	private State waitState;
	private State playState;
	private State finishState;
	
	private State state;

	public static final int player_max_num = 5; 
	public static final String initIsland = "Pirates’ Island";
	public static final String treaIsland = "Treasure Island";
	private JSONObject[] player;
	private int player_num;     //the number of players
	private int winner_No;
	
	private static Server serverInstance = null;
	
	public static synchronized Server getInstance() {
		if (serverInstance == null) {
			serverInstance = new Server();
		}
		return serverInstance;
	}

	private Server()
	{
	}
	
	public void init()
	{
		int i = 0;
		this.player_num = 0;
		this.winner_No = 0;

		this.player =  new JSONObject[player_max_num];
		Server.getInstance();
		this.waitState = new WaitState("Wait State", serverInstance);
		this.playState = new PlayState("Play State", serverInstance);
		this.finishState = new FinishState("Finish State", serverInstance);
		setState(waitState);
		
		for (i = 0; i < player_max_num; i++)
		{
			this.player[i] = new JSONObject();
			this.player[i].put("mac", "");
			this.player[i].put("location", "");
		}
		
	}
	
	public String[] getAllLocation()
	{
		String[] location = new String[player_max_num];
		int i = 0;
		
		for (i = 0; i < player_max_num; i++) { location[i] = player[i].getString("location");}
		
		return location;
	}
	
	public void setLocation(int player_No, String location) { this.player[player_No - 1].put("location", location); }
	
	public JSONObject request(String mac) 
	{
		JSONObject res = new JSONObject();
		
		System.out.println("request mac:" + mac);
		res = state.request(mac);
		System.out.println(res);
		
		return res;
	}
	
	public JSONObject update(String mac, String location) 
	{
        JSONObject res = new JSONObject();
		
		System.out.println("update mac:" + mac + "update location:" + location);
		res = state.update(mac, location);
		System.out.println(res);
	    	
		return res;
	}
	
	
	public int addPlayer(String mac)
	{
        int i = 0;
	    
	    for (i = 0; i < player_max_num; i++)
	    {
	    	if (mac.equals(player[i].get("mac"))) { return i + 1; }
	    	if ("".equals(player[i].get("mac")))
	    	{
	    		player[i].put("mac", mac);
	    		player[i].put("location", initIsland);
	    		player_num++;
	    		return i + 1;
	    	}
	    }
	    
	    return -1;
	}
	
	public int getPlayer(String mac)
	{
        int i = 0;
	    
	    for (i = 0; i < player_num; i++)
	    {
	    	if (mac.equals(player[i].get("mac")))  { return i + 1;}
	    }
	    
	    return -1;
	}
	
	public State getWaitState() { return this.waitState;}
	public State getPlayState() { return this.playState;}
	public State getFinishState() {return this.finishState;}
	
	public void setWinnerNo(int winner_No) 
	{
		if (winner_No >= player_max_num) { return; }
		this.winner_No = winner_No;
	}
	
	public int getWinnerNo() { return this.winner_No;}
	
	public int getPlayerNum() {return this.player_num;}
	
	public void setState(State state) 
	{
		state.entry();
		this.state = state;
	}
	
	public void timeOut() 
	{
		System.out.println("Time Out!");
		state.timeOut();
	}
	

}
