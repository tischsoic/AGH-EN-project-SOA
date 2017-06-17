package beans;

import java.util.List;

public interface RaportEJB {

    List<Object[]> getNMostPopularTickets(Integer n);
}
