package beans;

import models.ParkingSpace;
import models.Ticket;

import java.util.List;

public interface DashboardEJB {
    Long getTicketsNumber();

    List<Object[]> getParkingSpaces();
}
