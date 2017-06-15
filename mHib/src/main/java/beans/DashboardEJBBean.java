package beans;

import dao.DashboardDAO;
import models.ParkingSpace;
import models.Ticket;
import util.SessionUtils;

import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import java.util.List;

@Stateless
@Remote(DashboardEJB.class)
public class DashboardEJBBean implements DashboardEJB {
    @Lock(LockType.READ)
    public List<Ticket> getTickets() {
        return DashboardDAO.getTickets(SessionUtils.getUserId(), SessionUtils.getIsAdmin());
    }

    @Lock(LockType.READ)
    public List<ParkingSpace> getParkingSpaces() {
        return DashboardDAO.getParkingSpaces(SessionUtils.getUserId(), SessionUtils.getIsAdmin());
    }

}
