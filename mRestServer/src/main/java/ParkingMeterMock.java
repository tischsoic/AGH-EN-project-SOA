import models.*;

import javax.ejb.EJB;
import javax.json.*;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

@Path("pmm")
public class ParkingMeterMock {
    @EJB
    ParkingMeterMockRest parkingMeterMockRest;

    @Context
    private UriInfo context;

    @POST
    @Path("/ticket")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response postTicket(TicketDTO ticketDTO) {
        boolean success = parkingMeterMockRest.insertTicket(ticketDTO);

        JsonObject json = Json.createObjectBuilder()
                .add("success", success).build();

        return Response.status(200).entity(json).build();
    }

}