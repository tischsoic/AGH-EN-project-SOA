package beans;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.util.List;

@ManagedBean
@RequestScoped
public class Raport {
    private List<Object[]> mostPopularTickets;

    @EJB
    RaportEJB raportEJB;

    @PostConstruct
    public void init() {
        mostPopularTickets = raportEJB.getNMostPopularTickets(10);
    }

    public List<Object[]> getMostPopularTickets() {
        return mostPopularTickets;
    }

    public void setMostPopularTickets(List<Object[]> mostPopularTickets) {
        this.mostPopularTickets = mostPopularTickets;
    }

}
