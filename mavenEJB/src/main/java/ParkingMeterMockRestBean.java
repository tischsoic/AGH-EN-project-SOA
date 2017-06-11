import models.ParkingMeter;
import models.Ticket;
import models.TicketDTO;
import org.hibernate.Session;

import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Date;

@Stateless
@Remote(ParkingMeterMockRest.class)
public class ParkingMeterMockRestBean implements ParkingMeterMockRest {
    @Lock(LockType.WRITE)
    public boolean insertTicket(TicketDTO t) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory( "entityManager" );
        EntityManager em = emf.createEntityManager();
        Session session = em.unwrap(Session.class);

        session.beginTransaction();

        ParkingMeter parkingMeter = new ParkingMeter();
        parkingMeter.setParking_meter_id(t.parking_meter_id);

        Ticket ticket = new Ticket();
        ticket.setTic_start(t.tic_start);
        ticket.setTic_end(t.tic_end);
        ticket.setTic_duration(t.duration);
        ticket.setParkingMeter(parkingMeter);

        session.save(ticket);
        session.getTransaction().commit();

        em.close();
        emf.close();

        return true;
    }
}
