package dao;

import models.*;
import util.MD5HashingUtils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class DashboardDAO {
    public static List<Ticket> getTickets(Long userId, boolean isAdmin) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory( "entityManager" );
        EntityManager em = emf.createEntityManager();

        String hql = isAdmin ? "from Ticket t where " : "from Ticket t " +
                "left join t.parkingMeter pm " +
                "left join pm.zone z " +
                "left join z.guard u " +
                "where u.user_id = :userId and ";
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:00");
        Date ticketsFromDate = new Date(System.currentTimeMillis() - 10 * 60 * 1000);
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MINUTE, -10);
        hql += " hour(t.tic_end) > 20 and  t.tic_end > :endBefore ";
        System.out.println(hql);
        Query query = em.createQuery(hql);
        query.setParameter("endBefore", ticketsFromDate);
        System.out.println(dateFormat.format(ticketsFromDate));
//        query.setParameter("endBefore", dateFormat.format(ticketsFromDate));

        if (!isAdmin) {
            query.setParameter("userId", userId);
        }

        List<Ticket> tickets = query.getResultList();

        em.close();
        emf.close();

        return tickets;
    }

    public static List<ParkingSpace> getParkingSpaces(Long userId, boolean isAdmin) {
        List<ParkingSpace> parkingSpaces = new ArrayList<ParkingSpace>();

        return parkingSpaces;
    }

}
