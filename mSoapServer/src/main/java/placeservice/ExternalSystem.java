package placeservice;

import models.Ticket;
import models.TicketDTO;
import system.ExternalSystemRestSoap;

import javax.ejb.EJB;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import java.util.LinkedList;
import java.util.List;

@WebService
public class ExternalSystem {
    @Context
    private UriInfo context;
    @EJB
    private ExternalSystemRestSoap externalSystemRestSoap;

    public ExternalSystem() {

    }

    @WebMethod
    public List<TicketDTO> getMsg(String name) {
        List<Ticket> ts = externalSystemRestSoap.getAllTickets();
        List<TicketDTO> dto = new LinkedList<>();
        Ticket fst = ts.get(0);
        TicketDTO td = new TicketDTO();
        td.setDuration(fst.getTic_duration());
        td.setTic_end(fst.getTic_end());
        td.setTic_start(fst.getTic_start());
        dto.add(td);
        System.out.println("!!!!!!!!!!!!! sending ticketDTO by SOAP!!");
        List<String> stl = new LinkedList<>();
        stl.add("asdf");
        return dto;
    }
}
