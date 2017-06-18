package system;

import models.Occupancy;
import models.OccupancyDTO;

public interface Checker {
    void checkIfTicketBought(Occupancy o);
}
