package util;

import models.Book;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class SessionUtils {
    public static HttpSession getSession() {
        return (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
    }

    public static HttpServletRequest getRequest() {
		return (HttpServletRequest) FacesContext.getCurrentInstance()
				.getExternalContext().getRequest();
	}

	public static String getUserName() {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		return session.getAttribute("username").toString();
	}

	public static Long getUserId() {
		HttpSession session = getSession();

		return session != null ? (Long) session.getAttribute("userId") : null;
	}

	public static Boolean getIsAdmin() {
		HttpSession session = getSession();

		return session != null ? (Boolean) session.getAttribute("isAdmin") : false;
	}
}
