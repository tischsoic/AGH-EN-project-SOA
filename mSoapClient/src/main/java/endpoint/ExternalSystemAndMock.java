
package endpoint;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "ExternalSystemAndMock", targetNamespace = "http://placeservice/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface ExternalSystemAndMock {


    /**
     * 
     * @param arg0
     * @return
     *     returns TicketDTO
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getTicket", targetNamespace = "http://placeservice/", className = "GetTicket")
    @ResponseWrapper(localName = "getTicketResponse", targetNamespace = "http://placeservice/", className = "GetTicketResponse")
    public TicketDTO getTicket(
        @WebParam(name = "arg0", targetNamespace = "")
        Long arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns boolean
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "insertOccupancy", targetNamespace = "http://placeservice/", className = "InsertOccupancy")
    @ResponseWrapper(localName = "insertOccupancyResponse", targetNamespace = "http://placeservice/", className = "InsertOccupancyResponse")
    public boolean insertOccupancy(
        @WebParam(name = "arg0", targetNamespace = "")
        OccupancyDTO arg0);

    /**
     * 
     * @return
     *     returns java.util.List<TicketDTO>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getAllTickets", targetNamespace = "http://placeservice/", className = "GetAllTickets")
    @ResponseWrapper(localName = "getAllTicketsResponse", targetNamespace = "http://placeservice/", className = "GetAllTicketsResponse")
    public List<TicketDTO> getAllTickets();

}