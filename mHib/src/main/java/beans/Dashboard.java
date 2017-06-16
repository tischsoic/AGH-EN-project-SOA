package beans;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.util.List;

@ManagedBean
@RequestScoped
public class Dashboard {
    private Long ticketsNumber;
    private List<Object[]> parkingSpaces;

    @EJB
    DashboardEJB dashboardEJB;

    @PostConstruct
    public void init() {
        ticketsNumber = dashboardEJB.getTicketsNumber();
        parkingSpaces = dashboardEJB.getParkingSpaces();
    }

    public Long getTicketsNumber() {
        return ticketsNumber;
    }

    public void setTicketsNumber(Long ticketsNumber) {
        this.ticketsNumber = ticketsNumber;
    }

    public List<Object[]> getParkingSpaces() {
        return parkingSpaces;
    }

    public void setParkingSpaces(List<Object[]> parkingSpaces) {
        this.parkingSpaces = parkingSpaces;
    }

}
