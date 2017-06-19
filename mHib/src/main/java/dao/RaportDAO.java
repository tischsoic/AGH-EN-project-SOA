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
        System.out.println(hql);
        Query query = em.createQuery(hql);
        query.setMaxResults(n);

        List<Object[]> tickets = query.getResultList();

//        System.out.println("!!!!!!!!!!!!!!!!! Rapoty DAO !!!!!!!!!!!");
//        for (Object[] o : tickets) {
//            System.out.println("0: " + o[0] + "1: " + o[1]);
//        }

        em.close();
        emf.close();

        return tickets;
    }

}
