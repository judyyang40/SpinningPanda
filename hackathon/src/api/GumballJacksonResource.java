package api ;

import org.json.* ;
import org.restlet.representation.* ;
import org.restlet.ext.json.* ;
import org.restlet.ext.jackson.* ;
import org.restlet.resource.* ;
import gumball.GumballMachine ;

public class GumballJacksonResource extends ServerResource {

    GumballMachine machine = GumballMachine.getInstance() ;

    @Get
    public Representation get() throws JSONException {
        GMObject gmObject = new GMObject();
        gmObject.setBanner(machine.toString());
        gmObject.setCount(machine.getCount());
        gmObject.setState(machine.getStateString());
        return new JacksonRepresentation<GMObject> ( gmObject ) ;
    }


    @Post
    public Representation post(JsonRepresentation jsonRep) {

        JSONObject json = jsonRep.getJsonObject() ;
        String action = json.getString("action") ;
        System.out.println( "action: " + action ) ;

        if ( action.equals( "insert-quarter") )
            synchronized(machine) {
                machine.insertQuarter() ;
            }
        if ( action.equals( "turn-crank") )
            synchronized(machine) {
                machine.turnCrank();
            }

        return new JacksonRepresentation<GumballMachine> ( machine ) ;

    }
}

