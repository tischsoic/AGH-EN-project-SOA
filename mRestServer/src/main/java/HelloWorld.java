import models.TicketDTO;
import system.ParkingMeterMockRest;

import javax.ejb.EJB;
//import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
//import javax.persistence.Persistence;
//import javax.persistence.Query;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;
import java.util.LinkedList;
import java.util.List;

@Path("helloworld")
public class HelloWorld {
    @EJB
    ParkingMeterMockRest parkingMeter;

    @Context
    private UriInfo context;
//    private EntityManagerFactory emf;
//    private EntityManager em;

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public List<TicketDTO> getMsg() {
        TicketDTO t = new TicketDTO();
        LinkedList<TicketDTO> l = new LinkedList<TicketDTO>();
        l.add(t);

        return l;
//        List<Ticket> tickets = parkingMeter.getAllTickets();
//        List<TicketDTO> ticketDTOS = new LinkedList<TicketDTO>();
//
//        for (Ticket t : tickets) {
//            TicketDTO td = new TicketDTO();
//            td.parking_meter_id = t.getParkingMeter() != null ? t.getParkingMeter().getParking_meter_id() : null;
//            td.tic_end = t.getTic_end();
//            td.tic_start = t.getTic_start();
//            td.ticket_id = t.getTicket_id();
//
//            ticketDTOS.add(td);
//        }
//
//        return ticketDTOS;

//        emf = Persistence.createEntityManagerFactory( "entityManager" );
//        em = emf.createEntityManager();
//
//        String hql = "from Book";
//        Query query = em.createQuery(hql);
//        List<Book> books = query.getResultList();
////        return query.getResultList();
//        System.out.println(books.size());
//        System.out.println(books.toString());
//        em.close();
//        emf.close();
//        return books;

//        MyResp mr = new MyResp();
//        mr.setMsg("asd");
//        mr.setNumber(12);
//
//        return mr;
    }
}
