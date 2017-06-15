package dao;

import models.User;
import util.MD5HashingUtils;

import javax.persistence.*;
import javax.transaction.TransactionManager;
import javax.transaction.UserTransaction;
import java.security.NoSuchAlgorithmException;
import java.util.List;

public class ChangePasswordDAO {
    public static List<User> getUsersToChangePassword(boolean isAdmin, Long userId) {
        return MiscellaneousDAO.getManagedUsers(isAdmin, userId);
    }

    public static boolean changePassword(Long userId, String newPassword) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("entityManager");
        EntityManager em = emf.createEntityManager();

        EntityTransaction entityTransaction = em.getTransaction();

        entityTransaction.begin();

        System.out.println("new password: " + newPassword + " userId: " + userId);
        Query query = em.createQuery("update User set password = :newPassword where user_id = :userId");
        query.setParameter("userId", userId);
        try {
            query.setParameter("newPassword", MD5HashingUtils.hash(newPassword));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return false;
        }

        int rowsAffected = query.executeUpdate();

        entityTransaction.commit();

        em.close();
        emf.close();

        return rowsAffected == 1;
    }
}
