import models.Ticket;
import models.TicketDTO;

import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

@Stateless
@Remote(ParkingMeterMockRest.class)
public class ParkingMeterMockRestBean implements ParkingMeterMockRest {
    @Lock(LockType.READ)
    public List<Ticket> getAllTickets() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory( "entityManager" );
        EntityManager em = emf.createEntityManager();

        Query query = em.createQuery("from Ticket");
        List<Ticket> tickets = query.getResultList();

        em.close();
        emf.close();

        return tickets;
    }
}
