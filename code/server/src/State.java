package api;

import org.json.* ;
//import org.restlet.representation.* ;
//import org.restlet.ext.json.* ;
//import org.restlet.resource.* ;

public interface State {
	
	
	public JSONObject request(String mac);
	
	public JSONObject update(String mac, String location);
	
	public void timeOut();	
	
	public void entry();

}