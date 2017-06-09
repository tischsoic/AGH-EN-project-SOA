import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;
import java.util.List;

@Path("helloworld")
public class HelloWorld {
    @Context
    private UriInfo context;
    private EntityManagerFactory emf;
    private EntityManager em;

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public List<Book> getMsg() {
        emf = Persistence.createEntityManagerFactory( "entityManager" );
        em = emf.createEntityManager();

        String hql = "from Book";
        Query query = em.createQuery(hql);
        List<Book> books = query.getResultList();
//        return query.getResultList();
        System.out.println(books.size());
        System.out.println(books.toString());
        em.close();
        emf.close();
        return books;

//        MyResp mr = new MyResp();
//        mr.setMsg("asd");
//        mr.setNumber(12);
//
//        return mr;
    }
}
