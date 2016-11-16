package api;

import java.util.TimerTask;

public class TimerOut extends TimerTask{
	
	Server server;
	
	public TimerOut(Server server) { this.server = server; }
    
	public void run() {server.timeOut();}
}
