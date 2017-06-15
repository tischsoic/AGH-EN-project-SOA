package beans;

import dao.DashboardDAO;
import models.Ticket;
import util.SessionUtils;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.util.List;

@ManagedBean
@RequestScoped
public class Dashboard {
    private List<Ticket> ticketsToDisplay;
    @EJB
    DashboardEJB dashboardEJB;

    @PostConstruct
    public void init() {
        ticketsToDisplay = dashboardEJB.getTickets();
    }

    public List<Ticket> getTicketsToDisplay() {
        return ticketsToDisplay;
    }

    public void setTicketsToDisplay(List<Ticket> ticketsToDisplay) {
        this.ticketsToDisplay = ticketsToDisplay;
    }
}
