package dao;

import models.User;
import models.Book;
import util.MD5HashingUtils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.security.NoSuchAlgorithmException;
import java.util.List;

public class LoginDao {
    public static LoginValidation validate(String username, String password) {
        LoginValidation ret = new LoginValidation();
        ret.setSuccess(false);
        ret.setAdmin(false);

        EntityManagerFactory emf = Persistence.createEntityManagerFactory( "entityManager" );
        EntityManager em = emf.createEntityManager();

        Query q2 = em.createQuery("from User");
        System.out.println(q2.toString());
        List<User> us = q2.getResultList();
        System.out.println(us);
        String hashedPassword = "";
        try {
            hashedPassword = MD5HashingUtils.hash(password);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return ret;
        }

        Query query = em.createQuery("FROM User where username = :username and password = :password");
        List<User> users = query.setParameter("username", username)
                .setParameter("password", hashedPassword).getResultList();

        if (users.size() != 0) {
            User user = users.get(0);
            ret.setSuccess(true);
            ret.setAdmin(user.isAdmin());
            ret.setUserId(user.getUser_id());
            System.out.println(user.getZones().toString());
        }

        em.close();
        emf.close();

        return ret;
    }
}
