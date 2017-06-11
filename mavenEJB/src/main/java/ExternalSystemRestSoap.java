import models.*;

import java.util.List;

public interface ExternalSystemRestSoap {
    List<Zone> getAllZones();
    Zone getOneZone(Long zoneId);

    List<ParkingMeter> getAllParkingMeters();
    ParkingMeter getOneParkingMeter(Long parkingMeterId);

    List<ParkingSpace> getAllParkingSpaces();
    ParkingSpace getOneParkingSpace(Long parkingSpaceId);

    List<Occupancy> getAllOccupancies();
    Occupancy getOneOccupancy(Long occupancyId);

    List<Ticket> getAllTickets();
    Ticket getOneTicket(Long ticketId);
}
