package system;

import models.Occupancy;
import models.Ticket;
import models.OccupancyDTO;
import models.ParkingSpace;
import org.apache.commons.lang.WordUtils;
import org.hibernate.Session;

import javax.ejb.*;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

@Stateless
@Local(Checker.class)
public class CheckerBean implements Checker {

    @Asynchronous
    public void checkIfTicketBought(Occupancy o) {
        try {
            Thread.sleep(1 * 15 * 1000);
            manageTicket(o);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void manageTicket(Occupancy o) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("entityManager");
        EntityManager em = emf.createEntityManager();
        Session session = em.unwrap(Session.class);

        session.beginTransaction();

        String hqlOccupancyZoneId = "select z.zone_id from Occupancy o " +
                " left join o.parkingSpace ps" +
                " left join ps.zone z" +
                " where o.occupancy_id = :oId";
        Query occupancyZoneIdQuery = em.createQuery(hqlOccupancyZoneId);
        occupancyZoneIdQuery.setParameter("oId", o.getOccupancy_id());
        occupancyZoneIdQuery.setMaxResults(1);

        List<Long> occupancyZoneIds = occupancyZoneIdQuery.getResultList();
        Long occupancyZoneId = occupancyZoneIds.get(0);

        String hql = "select t.ticket_id from Ticket t" +
                " left join t.parkingMeter pm" +
                " left join pm.zone z" +
                " where z.zone_id = :zId and t.tic_start > :occupancyStart" +
                " order by t.tic_start desc";
        System.out.println(hql);
        Query query = em.createQuery(hql);
        query.setParameter("occupancyStart", o.getOcc_start());
        query.setParameter("zId", occupancyZoneId);
        query.setMaxResults(1);

        List<Long> ticketsIds = query.getResultList();
        Long ticketId = ticketsIds.size() != 0 ? ticketsIds.get(0) : null;

        if (ticketId != null) {
            Ticket occupancyTicket = new Ticket();
            occupancyTicket.setTicket_id(ticketId);

            o.setTicket(occupancyTicket);

            session.update(o);
        } else {
            System.out.println("Bilet nie został zakupiony!");
        }

        session.getTransaction().commit();

        em.close();
        emf.close();
    }
}
