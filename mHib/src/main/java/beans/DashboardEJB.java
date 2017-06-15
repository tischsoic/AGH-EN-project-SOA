package beans;

import models.ParkingSpace;
import models.Ticket;

import java.util.List;

public interface DashboardEJB {
    List<Ticket> getTickets();

    List<ParkingSpace> getParkingSpaces();
}
