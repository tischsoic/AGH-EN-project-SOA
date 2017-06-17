package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class RaportDAO {
    public static List<Object[]> getNMostPopularTickets(Integer n) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("entityManager");
        EntityManager em = emf.createEntityManager();

        String hql = "select t.tic_duration, count(t.ticket_id) as c from Ticket t group by t.tic_duration order by count(t.ticket_id) desc ";
//        String hql = isAdmin ? "select count(*) from Ticket t where " : "select count(*) from Ticket t " +
//                "left join t.parkingMeter pm " +
//                "left join pm.zone z " +
//                "left join z.guard u " +
//                "where u.user_id = :userId and ";
//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:00");
//        Date ticketsFromDate = new Date(System.currentTimeMillis() - 10 * 60 * 1000);
//        Calendar cal = Calendar.getInstance();
//        cal.add(Calendar.MINUTE, -10);
//        hql += " t.tic_end > :endBefore ";
        System.out.println(hql);
        Query query = em.createQuery(hql);
//        query.setParameter("endBefore", ticketsFromDate);
//        System.out.println("DashboardDAO.getTickets: " + dateFormat.format(ticketsFromDate));
        query.setMaxResults(n);

//        if (!isAdmin) {
//            query.setParameter("userId", userId);
//        }



        List<Object[]> tickets = query.getResultList();

        System.out.println("!!!!!!!!!!!!!!!!! Rapoty DAO !!!!!!!!!!!");
        for (Object[] o : tickets) {
            System.out.println("0: " + o[0] + "1: " + o[1]);
        }

//        Long ticketsNumber = tickets.get(0);
        em.close();
        emf.close();

        return tickets;
    }

    public static Long getTicketsNumber(Long userId, boolean isAdmin) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("entityManager");
        EntityManager em = emf.createEntityManager();

        String hql = isAdmin ? "select count(*) from Ticket t where " : "select count(*) from Ticket t " +
                "left join t.parkingMeter pm " +
                "left join pm.zone z " +
                "left join z.guard u " +
                "where u.user_id = :userId and ";
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:00");
        Date ticketsFromDate = new Date(System.currentTimeMillis() - 10 * 60 * 1000);
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MINUTE, -10);
        hql += " t.tic_end > :endBefore ";
        System.out.println(hql);
        Query query = em.createQuery(hql);
        query.setParameter("endBefore", ticketsFromDate);
        System.out.println("DashboardDAO.getTickets: " + dateFormat.format(ticketsFromDate));

        if (!isAdmin) {
            query.setParameter("userId", userId);
        }

        List<Long> tickets = query.getResultList();

        Long ticketsNumber = tickets.get(0);
        em.close();
        emf.close();

        return ticketsNumber;
    }


    public static List<Object[]> getParkingSpaces(Long userId, boolean isAdmin) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("entityManager");
        EntityManager em = emf.createEntityManager();

        String hql = "select z.zone_id, ps.parking_space_id, count(o.occupancy_id) from ParkingSpace ps " +
                " left join ps.occupancies o with o.occ_end > current_timestamp() " +
                " left join ps.zone z " +
                " left join z.guard u ";
        hql += isAdmin ? " " :
                "where u.user_id = :userId ";
        hql += " group by z.zone_id, ps.parking_space_id, o.occupancy_id";
        System.out.println(hql);
        Query query = em.createQuery(hql);

        if (!isAdmin) {
            query.setParameter("userId", userId);
        }

        List<Object[]> parkingSpaces = query.getResultList();

        em.close();
        emf.close();

//        for (Object[] o : parkingSpaces) {
//            System.out.println("0: " + o[0] + "1: " + o[1]);
//        }

        return parkingSpaces;
    }

}
