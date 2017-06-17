package system;

import models.Occupancy;
import models.OccupancyDTO;
import models.ParkingSpace;
import org.hibernate.Session;

import javax.ejb.*;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@Stateless
@Local(Checker.class)
public class CheckerBean implements Checker {

    @Asynchronous
    public void checkIfTicketBought() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!! ParkingSpaceMockSoapBean");
    }

}
