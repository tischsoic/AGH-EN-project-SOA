package dao;

import models.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class MiscellaneousDAO {
    public static List<User> getManagedUsers(boolean isAdmin, Long userId) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("entityManager");
        EntityManager em = emf.createEntityManager();

        String hql = isAdmin ? "from User" : "from User where user_id = :userId";
        Query query = em.createQuery(hql);

        if (!isAdmin) {
            query.setParameter("userId", userId);
        }

        List<User> users = query.getResultList();

        em.close();
        emf.close();

        return users;
    }
}
