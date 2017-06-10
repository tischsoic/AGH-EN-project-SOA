package beans;

import dao.ChangePasswordDAO;
import models.User;
import util.SessionUtils;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@ManagedBean
@SessionScoped
public class ChangePassword {
    private Map<String, Object> usersToChangePasswordsMenu;
    private String newPassword;
    private User selectedUser;

    @PostConstruct
    public void init() {
        System.out.println("!!!!!!!! post construct ChangePAssword");
        List<User> usersToChangePassword = ChangePasswordDAO.getUsersToChangePassword(
                SessionUtils.getIsAdmin(),
                SessionUtils.getUserId()
        );

        usersToChangePasswordsMenu = new LinkedHashMap<String, Object>();
        for (User user : usersToChangePassword) {
            usersToChangePasswordsMenu.put(user.getUsername(), user);
        }
    }

    public String changePassword() {
        System.out.println("!!!!!!!!!! change password CHANgePassword managed bean");
        ChangePasswordDAO.changePassword(selectedUser.getUser_id(), newPassword);
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
}
