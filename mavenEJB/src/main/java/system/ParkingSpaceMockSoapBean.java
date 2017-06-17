package system;

import models.*;
import org.hibernate.Session;

import javax.ejb.*;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@Stateless
@Remote(ParkingSpaceMockSoap.class)
public class ParkingSpaceMockSoapBean implements ParkingSpaceMockSoap {

    @EJB
    Checker checker;

//    @Asynchronous
//    private void checkIfTicketBought() {
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!! ParkingSpaceMockSoapBean");
//    }

    @Lock(LockType.WRITE)
    public boolean insertOccupancy(OccupancyDTO o) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("entityManager");
        EntityManager em = emf.createEntityManager();
        Session session = em.unwrap(Session.class);

        session.beginTransaction();

        ParkingSpace parkingSpace = new ParkingSpace();
        parkingSpace.setParking_space_id(o.getParking_space_id());

        Occupancy occupancy = new Occupancy();
        occupancy.setOcc_start(o.getOcc_start());
        occupancy.setOcc_end(o.getOcc_end());
        occupancy.setParkingSpace(parkingSpace);

        session.save(occupancy);
        session.getTransaction().commit();

        em.close();
        emf.close();

        checker.checkIfTicketBought();

        return true;
    }

}
