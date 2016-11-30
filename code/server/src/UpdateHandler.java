package api ;

import org.json.* ;
import org.restlet.representation.* ;
import org.restlet.ext.json.* ;
import org.restlet.resource.* ;

public class UpdateHandler extends ServerResource {

    Server server = Server.getInstance() ;

    @Post
    public Representation post(JsonRepresentation jsonRep) {

        JSONObject json = jsonRep.getJsonObject() ;
        System.out.println("update " + json) ;
        String mac = json.getString("mac") ;
        String location = json.getString("location");
        

        JSONObject result = server.update(mac, location);
        System.out.println("return " + result);

        return new JsonRepresentation ( result ) ;

    }
}

