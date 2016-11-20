package api;

import org.json.* ;
//import org.restlet.representation.* ;
//import org.restlet.ext.json.* ;
//import org.restlet.resource.* ;
import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.Test;

public class ServerTest {

	@Test
	public void test() {
		Server server = Server.getInstance();
		JSONObject json = new JSONObject();
		String[] location;
		
		json = server.request("11-11-11-11-11-11");
		assertEquals("wait", json.get("status"));
		assertEquals(1, json.get("you"));
		assertEquals(1, json.get("total"));
		
		json = server.request("22-22-22-22-22-22");
		assertEquals("wait", json.get("status"));
		assertEquals(2, json.get("you"));
		assertEquals(2, json.get("total"));
		
		json = server.request("33-33-33-33-33-33");
		assertEquals("wait", json.get("status"));
		assertEquals(3, json.get("you"));
		assertEquals(3, json.get("total"));
		
		json = server.request("44-44-44-44-44-44");
		assertEquals("ready", json.get("status"));
		assertEquals(4, json.get("you"));
		assertEquals(4, json.get("total"));
		
		json = server.request("55-55-55-55-55-55");
		assertEquals("refuse", json.get("status"));
		
		json = server.update("11-11-11-11-11-11", "aa");
		assertEquals(false, json.get("finish"));
		assertEquals(false, json.has("winner"));
		location = (String[]) json.get("location");
		assertEquals("aa", location[0]);
		assertEquals(server.initIsland, location[1]);
		assertEquals(server.initIsland, location[2]);
		assertEquals(server.initIsland, location[3]);
		
		
		json = server.update("22-22-22-22-22-22", "bb");
		assertEquals(false, json.get("finish"));
		assertEquals(false, json.has("winner"));
		location = (String[]) json.get("location");
		assertEquals("aa", location[0]);
		assertEquals("bb", location[1]);
		assertEquals(server.initIsland, location[2]);
		assertEquals(server.initIsland, location[3]);
		
		json = server.request("66-66-66-66-66-66");
		assertEquals("refuse", json.get("status"));
		
		json = server.update("66-66-66-66-66-66", "aa");
		assertEquals("mac_err", json.get("err"));
		
		
		json = server.request("11-11-11-11-11-11");
		assertEquals(false, json.get("finish"));
		assertEquals(false, json.has("winner"));
		location = (String[]) json.get("location");
		assertEquals("aa", location[0]);
		assertEquals("bb", location[1]);
		assertEquals(server.initIsland, location[2]);
		assertEquals(server.initIsland, location[3]);
		
		json = server.update("33-33-33-33-33-33", server.treaIsland);
		assertEquals(true, json.get("finish"));
		assertEquals(3, json.get("winner"));
		assertEquals(false, json.has("location"));
		
		json = server.update("11-11-11-11-11-11", server.treaIsland);
		assertEquals(true, json.get("finish"));
		assertEquals(3, json.get("winner"));
		assertEquals(false, json.has("location"));
		
		json = server.request("44-44-44-44-44-44");
		assertEquals(true, json.get("finish"));
		assertEquals(3, json.get("winner"));
		assertEquals(false, json.has("location"));
		
		json = server.update("66-66-66-66-66-66", "aa");
		assertEquals("mac_err", json.get("err"));
		
		try {
			TimeUnit.SECONDS.sleep(4);
		} catch (InterruptedException e) {
			
		}
		
		location = server.getAllLocation();
		assertEquals("", location[0]);
		assertEquals("", location[1]);
		assertEquals("", location[2]);
		assertEquals("", location[3]);
		
		json = server.update("33-33-33-33-33-33", server.treaIsland);
		assertEquals("type_err", json.get("err"));
		
		json = server.request("44-44-44-44-44-44");
		assertEquals("wait", json.get("status"));
		assertEquals(1, json.get("you"));
		assertEquals(1, json.get("total"));
		
	}

}
