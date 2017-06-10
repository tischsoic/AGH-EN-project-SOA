package beans;

import dao.DashboardDAO;
import models.Ticket;
import util.SessionUtils;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.util.List;

@ManagedBean
@RequestScoped
public class Dashboard {
    private List<Ticket> ticketsToDisplay;

    @PostConstruct
    public void init() {
        ticketsToDisplay = DashboardDAO.getTickets(SessionUtils.getUserId(), SessionUtils.getIsAdmin());
    }

    public List<Ticket> getTicketsToDisplay() {
        return ticketsToDisplay;
    }

    public void setTicketsToDisplay(List<Ticket> ticketsToDisplay) {
        this.ticketsToDisplay = ticketsToDisplay;
    }
}
