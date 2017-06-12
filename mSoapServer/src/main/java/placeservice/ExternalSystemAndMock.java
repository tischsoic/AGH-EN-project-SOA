package placeservice;

import models.*;
import system.ExternalSystemRestSoap;
import system.ParkingSpaceMockSoap;

import javax.ejb.EJB;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import java.util.LinkedList;
import java.util.List;

@WebService
public class ExternalSystemAndMock {
    @Context
    private UriInfo context;
    @EJB
    private ExternalSystemRestSoap externalSystemRestSoap;
    @EJB
    private ParkingSpaceMockSoap parkingSpaceMockSoap;

    public ExternalSystemAndMock() {

    }

    @WebMethod
    public boolean insertOccupancy(OccupancyDTO oDTO) {
        return parkingSpaceMockSoap.insertOccupancy(oDTO);
    }

    @WebMethod
    public List<TicketDTO> getAllTickets() {
        List<Ticket> ts = externalSystemRestSoap.getAllTickets();
        List<TicketDTO> dto = new LinkedList<>();

        for (Ticket t : ts) {
            dto.add(ticketToDTO(t));
        }

        System.out.println("!!!!!!!!!!!!! sending ticketDTO by SOAP!!");

        return dto;
    }

    public TicketDTO getTicket(Long ticketId) {
        return ticketToDTO(externalSystemRestSoap.getOneTicket(ticketId));
    }

    private ZoneDTO zoneToDTO(Zone z) {
        if (z == null) {
            return null;
        }

        User guard = z.getGuard();
        Long guardId = guard != null ? guard.getUser_id() : null;

        ZoneDTO zoneDTO = new ZoneDTO();
        zoneDTO.setName(z.getName());
        zoneDTO.setZone_id(z.getZone_id());
        zoneDTO.setUser_id(guardId);

        return zoneDTO;
    }

    private ParkingMeterDTO parkingMeterToDTO(ParkingMeter pm) {
        if (pm == null) {
            return null;
        }

        Zone zone = pm.getZone();
        Long zoneId = zone != null ? zone.getZone_id() : null;

        ParkingMeterDTO parkingMeterDTO = new ParkingMeterDTO();
        parkingMeterDTO.setZone_id(zoneId);
        parkingMeterDTO.setParking_meter_id(pm.getParking_meter_id());

        return parkingMeterDTO;
    }

    private ParkingSpaceDTO parkingSpaceToDTO(ParkingSpace ps) {
        if (ps == null) {
            return  null;
        }

        Zone zone = ps.getZone();
        Long zoneId = zone != null ? zone.getZone_id() : null;

        ParkingSpaceDTO parkingSpaceDTO = new ParkingSpaceDTO();
        parkingSpaceDTO.setParking_space_id(ps.getParking_space_id());
        parkingSpaceDTO.setZone_id(zoneId);

        return parkingSpaceDTO;
    }

    private OccupancyDTO occupancyToDTO(Occupancy o) {
        if (o == null) {
            return  null;
        }

        ParkingSpace parkingSpace = o.getParkingSpace();
        Long parkingSpaceId = parkingSpace != null ? parkingSpace.getParking_space_id() : null;

        Ticket ticket = o.getTicket();
        Long ticketId = ticket != null ? ticket.getTicket_id() : null;

        OccupancyDTO occupancyDTO = new OccupancyDTO();
        occupancyDTO.setOccupancy_id(o.getOccupancy_id());
        occupancyDTO.setOcc_start(o.getOcc_start());
        occupancyDTO.setOcc_end(o.getOcc_end());
        occupancyDTO.setParking_space_id(parkingSpaceId);
        occupancyDTO.setTicket_id(ticketId);

        return occupancyDTO;
    }

    private TicketDTO ticketToDTO(Ticket t) {
        if (t == null) {
            return  null;
        }

        ParkingMeter parkingMeter = t.getParkingMeter();
        Long parkingMeterId = parkingMeter != null ? parkingMeter.getParking_meter_id() : null;

        TicketDTO ticketDTO = new TicketDTO();
        ticketDTO.setTicket_id(t.getTicket_id());
        ticketDTO.setTic_start(t.getTic_start());
        ticketDTO.setTic_end(t.getTic_end());
        ticketDTO.setParking_meter_id(parkingMeterId);

        return ticketDTO;
    }
}
