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
        // return new JacksonRepresentation<GumballMachine>( machine );
    }


    @Post
    public Representation post(JsonRepresentation jsonRep) {

        JSONObject json = jsonRep.getJsonObject() ;
        String action = json.getString("action") ;
        System.out.println( "action: " + action ) ;
        GMObject gmObject = new GMObject();
        try {
            synchronized(machine) {
                if ( action.equals( "insert-quarter") ) {
                    while (!machine.getStateString().equals("waiting for quarter")) {
                        machine.wait();
                    }
                    machine.insertQuarter() ;
                    machine.notifyAll();
                }
                if ( action.equals( "turn-crank") ) {
                    while (!machine.getStateString().equals("waiting for turn of crank")) {
                        machine.wait();
                    }
                    machine.turnCrank();
                    machine.notifyAll();
                }

                gmObject.setBanner(machine.toString());
                gmObject.setCount(machine.getCount());
                gmObject.setState(machine.getStateString());
            }
        } catch (Exception e) {

        }
        return new JacksonRepresentation<GMObject> ( gmObject ) ;
    }
}

