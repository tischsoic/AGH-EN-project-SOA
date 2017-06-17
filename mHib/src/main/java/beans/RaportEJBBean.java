package beans;

import dao.RaportDAO;

import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import java.util.List;

@Stateless
@Remote(RaportEJB.class)
public class RaportEJBBean implements RaportEJB {

    @Lock(LockType.READ)
    public List<Object[]> getNMostPopularTickets(Integer n) {
        return RaportDAO.getNMostPopularTickets(n);
    }
}
