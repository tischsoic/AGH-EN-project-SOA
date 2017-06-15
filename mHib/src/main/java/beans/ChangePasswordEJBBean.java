package beans;

import dao.ChangePasswordDAO;
import models.User;
import util.SessionUtils;

import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import java.util.List;

@Stateless
@Remote(ChangePasswordEJB.class)
public class ChangePasswordEJBBean implements ChangePasswordEJB {
    @Lock(LockType.READ)
    public List<User> getUsersToChangePassword() {
        return ChangePasswordDAO.getUsersToChangePassword(SessionUtils.getIsAdmin(), SessionUtils.getUserId());

    }

    @Lock(LockType.READ)
    public boolean changePassword(Long userId, String newPassword) {
        return ChangePasswordDAO.changePassword(userId, newPassword);
    }

}
