
package endpoint;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the endpoint package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GetTicket_QNAME = new QName("http://placeservice/", "getTicket");
    private final static QName _InsertOccupancyResponse_QNAME = new QName("http://placeservice/", "insertOccupancyResponse");
    private final static QName _GetTicketResponse_QNAME = new QName("http://placeservice/", "getTicketResponse");
    private final static QName _GetAllTicketsResponse_QNAME = new QName("http://placeservice/", "getAllTicketsResponse");
    private final static QName _InsertOccupancy_QNAME = new QName("http://placeservice/", "insertOccupancy");
    private final static QName _GetAllTickets_QNAME = new QName("http://placeservice/", "getAllTickets");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: endpoint
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link InsertOccupancy }
     * 
     */
    public InsertOccupancy createInsertOccupancy() {
        return new InsertOccupancy();
    }

    /**
     * Create an instance of {@link GetAllTickets }
     * 
     */
    public GetAllTickets createGetAllTickets() {
        return new GetAllTickets();
    }

    /**
     * Create an instance of {@link GetAllTicketsResponse }
     * 
     */
    public GetAllTicketsResponse createGetAllTicketsResponse() {
        return new GetAllTicketsResponse();
    }

    /**
     * Create an instance of {@link GetTicketResponse }
     * 
     */
    public GetTicketResponse createGetTicketResponse() {
        return new GetTicketResponse();
    }

    /**
     * Create an instance of {@link GetTicket }
     * 
     */
    public GetTicket createGetTicket() {
        return new GetTicket();
    }

    /**
     * Create an instance of {@link InsertOccupancyResponse }
     * 
     */
    public InsertOccupancyResponse createInsertOccupancyResponse() {
        return new InsertOccupancyResponse();
    }

    /**
     * Create an instance of {@link TicketDTO }
     * 
     */
    public TicketDTO createTicketDTO() {
        return new TicketDTO();
    }

    /**
     * Create an instance of {@link OccupancyDTO }
     * 
     */
    public OccupancyDTO createOccupancyDTO() {
        return new OccupancyDTO();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetTicket }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://placeservice/", name = "getTicket")
    public JAXBElement<GetTicket> createGetTicket(GetTicket value) {
        return new JAXBElement<GetTicket>(_GetTicket_QNAME, GetTicket.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InsertOccupancyResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://placeservice/", name = "insertOccupancyResponse")
    public JAXBElement<InsertOccupancyResponse> createInsertOccupancyResponse(InsertOccupancyResponse value) {
        return new JAXBElement<InsertOccupancyResponse>(_InsertOccupancyResponse_QNAME, InsertOccupancyResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetTicketResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://placeservice/", name = "getTicketResponse")
    public JAXBElement<GetTicketResponse> createGetTicketResponse(GetTicketResponse value) {
        return new JAXBElement<GetTicketResponse>(_GetTicketResponse_QNAME, GetTicketResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllTicketsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://placeservice/", name = "getAllTicketsResponse")
    public JAXBElement<GetAllTicketsResponse> createGetAllTicketsResponse(GetAllTicketsResponse value) {
        return new JAXBElement<GetAllTicketsResponse>(_GetAllTicketsResponse_QNAME, GetAllTicketsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InsertOccupancy }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://placeservice/", name = "insertOccupancy")
    public JAXBElement<InsertOccupancy> createInsertOccupancy(InsertOccupancy value) {
        return new JAXBElement<InsertOccupancy>(_InsertOccupancy_QNAME, InsertOccupancy.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllTickets }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://placeservice/", name = "getAllTickets")
    public JAXBElement<GetAllTickets> createGetAllTickets(GetAllTickets value) {
        return new JAXBElement<GetAllTickets>(_GetAllTickets_QNAME, GetAllTickets.class, null, value);
    }

}
