package system;

import models.Occupancy;
import models.OccupancyDTO;
import models.TicketDTO;

public interface ParkingSpaceMockSoap {
    boolean insertOccupancy(OccupancyDTO o);
}
