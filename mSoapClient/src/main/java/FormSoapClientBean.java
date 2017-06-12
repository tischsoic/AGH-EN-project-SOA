import endpoint.ExternalSystemAndMock;
import endpoint.ExternalSystemAndMockService;
import endpoint.OccupancyDTO;
import endpoint.TicketDTO;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Stateless;
import javax.faces.application.FacesMessage;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;


@Stateless
@RequestScoped
@Named("formsoapclient")
public class FormSoapClientBean {
    private Client client;
    private Long parkingSpaceId;
    private String parkingStart;
    private String parkingEnd;
    private String myMessage;

    @PostConstruct
    private void init() {
        client = ClientBuilder.newClient();
    }

    @PreDestroy
    private void clean() {
        client.close();
    }

    public FormSoapClientBean() {
    }


    public void sendTicket() {
        ExternalSystemAndMock port = new ExternalSystemAndMockService().getExternalSystemAndMockPort();

        Date dateStart;
        Date dateEnd;
        try {
            SimpleDateFormat format =
                    new SimpleDateFormat("yyyy-MM-dd HH:mm");
            dateStart = format.parse(parkingStart);
            dateEnd = format.parse(parkingEnd);
        } catch (ParseException pe) {
            throw new IllegalArgumentException();
        }

        XMLGregorianCalendar dateStartXGC = null;
        XMLGregorianCalendar dateEndXGC = null;

        GregorianCalendar c = new GregorianCalendar();
        try {
            c.setTime(dateStart);
            dateStartXGC = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
            c.setTime(dateEnd);
            dateEndXGC = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
        } catch (DatatypeConfigurationException e) {
            e.printStackTrace();
        }

        OccupancyDTO occupancyDTO = new OccupancyDTO();
        occupancyDTO.setOccEnd(dateEndXGC);
        occupancyDTO.setOccStart(dateStartXGC);
        occupancyDTO.setParkingSpaceId(parkingSpaceId);

        boolean success = port.insertOccupancy(occupancyDTO);

        String message = success ? "success!\n" : "unsuccess!\n";

        TicketDTO ticketDTO = port.getTicket(1L);
        message += "Ticket start: " + ticketDTO.getTicStart().toString();

        FacesMessage facesMessage = new FacesMessage(message);
        FacesContext.getCurrentInstance().addMessage(null, facesMessage);
    }

    public Long getParkingSpaceId() {
        return parkingSpaceId;
    }

    public void setParkingSpaceId(Long parkingSpaceId) {
        this.parkingSpaceId = parkingSpaceId;
    }

    public String getParkingStart() {
        return parkingStart;
    }

    public void setParkingStart(String parkingStart) {
        this.parkingStart = parkingStart;
    }

    public String getParkingEnd() {
        return parkingEnd;
    }

    public void setParkingEnd(String parkingEnd) {
        this.parkingEnd = parkingEnd;
    }

    public String getMyMessage() {
        return myMessage;
    }

    public void setMyMessage(String myMessage) {
        this.myMessage = myMessage;
    }
}
