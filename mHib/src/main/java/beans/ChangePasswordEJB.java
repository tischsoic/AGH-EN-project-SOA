package beans;

import models.User;

import java.util.List;

public interface ChangePasswordEJB {
    List<User> getUsersToChangePassword();

    boolean changePassword(Long userId, String newPassword);
}
