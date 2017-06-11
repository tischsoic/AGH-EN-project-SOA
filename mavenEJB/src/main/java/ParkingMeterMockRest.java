import models.Ticket;
import models.TicketDTO;

import java.util.List;

public interface ParkingMeterMockRest {
    List<Ticket> getAllTickets();
}
