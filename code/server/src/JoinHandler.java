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
        String mac = json.getString("mac") ;
        System.out.println(json) ;

        JSONObject result = server.request(mac);
        System.out.println(result);

        return new JsonRepresentation ( result ) ;

    }
}

