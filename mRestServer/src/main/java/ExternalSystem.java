import models.*;

import javax.ejb.EJB;
import javax.json.*;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.util.List;

@Path("external")
public class ExternalSystem {
    @EJB
    ExternalSystemRestSoap externalSystemRestSoap;

    @Context
    private UriInfo context;

    @GET
    @Path("/parkingMeters")
    public Response getAllParkingMeters() {
        List<ParkingMeter> parkingMeters = externalSystemRestSoap.getAllParkingMeters();

        JsonArrayBuilder zonesArr = Json.createArrayBuilder();
        for(ParkingMeter pm : parkingMeters) {
            zonesArr.add(parkingMeterToJsonObjBuilder(pm));
        }
        JsonArray json = zonesArr.build();

        return Response.status(200).entity(json).build();
    }

    @GET
    @Path("/parkingMeters/{id}")
    public Response getOneParkingMeter(@PathParam("id") String which) {
        Long parkingMeterId;
        try {
            parkingMeterId = Long.parseLong(which);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return Response.status(400).build();
        }
        ParkingMeter pm = externalSystemRestSoap.getOneParkingMeter(parkingMeterId);

        return pm != null
                ? Response.status(200).entity(parkingMeterToJsonObjBuilder(pm).build()).build()
                : Response.status(404).build();
    }

    @GET
    @Path("/zone/{which}")
    public Response getZone(@PathParam("which") String which) {
        if (which.equals("all")) {
            return getAllZones();
        } else {
            return getOneZone(which);
        }
    }

    private Response getOneZone(String which) {
        Long zoneId;
        try {
            zoneId = Long.parseLong(which);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return Response.status(400).build();
        }
        Zone z = externalSystemRestSoap.getOneZone(zoneId);

        return z != null
                ? Response.status(200).entity(zoneToJsonObjBuilder(z).build()).build()
                : Response.status(404).build();
    }

    private Response getAllZones() {
        List<Zone> zones = externalSystemRestSoap.getAllZones();

        JsonArrayBuilder zonesArr = Json.createArrayBuilder();
        for(Zone z : zones) {
            zonesArr.add(zoneToJsonObjBuilder(z));
        }
        JsonArray json = zonesArr.build();

        return Response.status(200).entity(json).build();
    }

    private JsonObjectBuilder zoneToJsonObjBuilder(Zone z) {
        User guard = z.getGuard();
        Long guardId = guard != null ? guard.getUser_id() : null;
        JsonObjectBuilder jsonObjectBuilder = Json.createObjectBuilder()
                .add("id", z.getZone_id())
                .add("name", z.getName())
                .add("user_id", guardId);

        return jsonObjectBuilder;
    }

    private JsonObjectBuilder parkingMeterToJsonObjBuilder(ParkingMeter pm) {
        Zone zone = pm.getZone();
        Long zoneId = zone != null ? zone.getZone_id() : null;
        JsonObjectBuilder jsonObjectBuilder = Json.createObjectBuilder()
                .add("id", pm.getParking_meter_id())
                .add("zone_id", zoneId);

        return jsonObjectBuilder;
    }

    private JsonObjectBuilder parkingSpaceToJsonObjBuilder(ParkingSpace ps) {
        Zone zone = ps.getZone();
        Long zoneId = zone != null ? zone.getZone_id() : null;
        JsonObjectBuilder jsonObjectBuilder = Json.createObjectBuilder()
                .add("id", ps.getParking_space_id())
                .add("zone_ie", zoneId);

        return jsonObjectBuilder;
    }

    private JsonObjectBuilder occupancyToJsonObjBuilder(Occupancy o) {
        ParkingSpace parkingSpace = o.getParkingSpace();
        Long parkingSpaceId = parkingSpace != null ? parkingSpace.getParking_space_id() : null;

        Ticket ticket = o.getTicket();
        Long ticketId = ticket != null ? ticket.getTicket_id() : null;

        JsonObjectBuilder jsonObjectBuilder = Json.createObjectBuilder()
                .add("id", o.getOccupancy_id())
                .add("occ_start", o.getOcc_start().toString())
                .add("occ_end", o.getOcc_end().toString())
                .add("parking_space_id", parkingSpaceId)
                .add("ticket_id", ticketId);

        return jsonObjectBuilder;
    }

    private JsonObjectBuilder ticketToJsonObjBuilder(Ticket t) {
        ParkingMeter parkingMeter = t.getParkingMeter();
        Long parkingMeterId = parkingMeter != null ? parkingMeter.getParking_meter_id() : null;

        JsonObjectBuilder jsonObjectBuilder = Json.createObjectBuilder()
                .add("id", t.getTicket_id())
                .add("tic_start", t.getTic_start().toString())
                .add("tic_end", t.getTic_end().toString())
                .add("parking_meter_id", parkingMeterId);

        return jsonObjectBuilder;
    }

}
