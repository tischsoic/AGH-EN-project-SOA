import models.TicketDTO;
import system.ParkingMeterMockRest;

import javax.ejb.EJB;
//import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
//import javax.persistence.Persistence;
//import javax.persistence.Query;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;
import java.util.LinkedList;
import java.util.List;

@Path("helloworld")
public class HelloWorld {
    @EJB
    ParkingMeterMockRest parkingMeter;

    @Context
    private UriInfo context;

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public List<TicketDTO> getMsg() {
        TicketDTO t = new TicketDTO();
        LinkedList<TicketDTO> l = new LinkedList<TicketDTO>();
        l.add(t);

        return l;
    }
}
