package api;

import org.restlet.*;
import org.restlet.data.Protocol;
import org.restlet.routing.Router;

public class IslandServer extends Application {

    public static void main(String[] args) throws Exception {
        Server.getInstance().init();
        Component server = new Component() ;
        server.getServers().add(Protocol.HTTP, 8080) ;
        server.getDefaultHost().attach(new IslandServer()) ;
        server.start();
    }

    @Override
    public Restlet createInboundRoot() {
        Router router = new Router(getContext()) ;
        router.attach("/join", JoinHandler.class);
        router.attach("/update", UpdateHandler.class);        
        return router;
    }


}

