package beans;

import dao.LoginDao;
import dao.LoginValidation;
import util.SessionUtils;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import java.security.NoSuchAlgorithmException;

@ManagedBean
@SessionScoped
public class Login {

    private String username;
    private String password;
    private String msq;

    public String validateLoginData() throws NoSuchAlgorithmException {
        LoginValidation validation = LoginDao.validate(username, password);

        if(validation.isSuccess()) {
            HttpSession session = SessionUtils.getSession();
            session.setAttribute("username", username);

            return "dashboard";
        } else {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN, "Incorrect login data!", "Enter correct data!")
            );
            return "login";
        }
    }

    public String logout() {
		HttpSession session = SessionUtils.getSession();
		session.invalidate();
		return "login";
	}

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMsq() {
        return msq;
    }

    public void setMsq(String msq) {
        this.msq = msq;
    }
}
