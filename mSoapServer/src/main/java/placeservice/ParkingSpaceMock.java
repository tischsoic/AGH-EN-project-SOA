package placeservice;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import java.util.List;

@WebService
public class ParkingSpaceMock {
    @Context
    private UriInfo context;
    private EntityManagerFactory emf;
    private EntityManager em;

    public ParkingSpaceMock() {

    }

    @WebMethod
    public List<Book> getMsg(String name) {
        emf = Persistence.createEntityManagerFactory( "entityManager" );
        em = emf.createEntityManager();

        String hql = "from Book";
        Query query = em.createQuery(hql);
        List<Book> books = query.getResultList();
//        return query.getResultList();
        System.out.println("" + books.size());
        System.out.println(books.toString());
        em.close();
        emf.close();
        return books;
    }
}
