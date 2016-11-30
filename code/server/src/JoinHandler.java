package api ;

import org.json.* ;
import org.restlet.representation.* ;
import org.restlet.ext.json.* ;
import org.restlet.resource.* ;

public class JoinHandler extends ServerResource {

    Server server = Server.getInstance() ;

    @Post
    public Representation post(JsonRepresentation jsonRep) {

        JSONObject json = jsonRep.getJsonObject() ;
        System.out.println("Join " + json) ;
        String mac = json.getString("mac") ;
        JSONObject result = server.request(mac);
        System.out.println("return " + result);

        return new JsonRepresentation ( result ) ;

    }
}

