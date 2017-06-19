package beans;

import dao.ChangePasswordDAO;
import models.User;
import util.SessionUtils;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@ManagedBean
@SessionScoped
public class ChangePassword {
    private Map<String, Object> usersToChangePasswordsMenu;
    private List<User> usersToChangePassword;
    private String newPassword;
    private String username;
    private User selectedUser;

    @EJB
    ChangePasswordEJB changePasswordEJB;

    @PostConstruct
    public void init() {
        usersToChangePassword = changePasswordEJB.getUsersToChangePassword();

        usersToChangePasswordsMenu = new LinkedHashMap<String, Object>();
        for (User user : usersToChangePassword) {
            usersToChangePasswordsMenu.put(user.getUsername(), user);
        }
    }

    public String changePassword() {
        System.out.println("username: '" + username + "'");
        Iterator it = usersToChangePasswordsMenu.entrySet().iterator();
        User userToChangePassword = null;
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            String key = (String) pair.getKey();
            if (key.trim().equals(username)) {
                userToChangePassword = (User) pair.getValue();
            }
            System.out.println("'" + pair.getKey() + "'" + " = " + pair.getValue());
            it.remove(); // avoids a ConcurrentModificationException

        }
        System.out.println("uTCP: " + userToChangePassword.toString());
        if (userToChangePassword != null) {
            System.out.println("change password to: " + newPassword);
            changePasswordEJB.changePassword(userToChangePassword.getUser_id(), newPassword);
        }
        return "change_password";
    }

    public Map<String, Object> getUsersToChangePasswordsMenu() {
        return usersToChangePasswordsMenu;
    }

    public void setUsersToChangePasswordsMenu(Map<String, Object> usersToChangePasswordsMenu) {
        this.usersToChangePasswordsMenu = usersToChangePasswordsMenu;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public User getSelectedUser() {
        return selectedUser;
    }

    public void setSelectedUser(User selectedUser) {
        this.selectedUser = selectedUser;
    }

    public List<User> getUsersToChangePassword() {
        return usersToChangePassword;
    }

    public void setUsersToChangePassword(List<User> usersToChangePassword) {
        this.usersToChangePassword = usersToChangePassword;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
