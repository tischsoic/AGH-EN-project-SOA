import models.TicketDTO;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.jboss.logging.annotations.Pos;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Stateless;
import javax.faces.application.FacesMessage;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


@Stateless
@RequestScoped
@Named("formbean")
public class FormBean {
    protected Client client;
    private String myMessage;
    private Long meterId;
    private String tic_start;
    private Integer tic_duration;

    @PostConstruct
    private void init() {

    }

    @PreDestroy
    private void clean() {

    }

    public FormBean() {
    }

    public void sendTicket() {
        Date d = new Date();
        try {
            SimpleDateFormat format =
                    new SimpleDateFormat("yyyy-MM-dd HH:mm");
            d = format.parse(tic_start);
        } catch (ParseException pe) {
            throw new IllegalArgumentException();
        }
        Calendar c = Calendar.getInstance();
        c.setTime(d);
        c.add(Calendar.MINUTE, tic_duration);
        Date d_end = c.getTime();

        TicketDTO ticket = new TicketDTO();
        ticket.setDuration(tic_duration);
        ticket.setTic_start(d);
        ticket.setTic_end(d_end);
        ticket.setParking_meter_id(meterId);

        client = ClientBuilder.newClient();
        Response res = client.target("http://localhost:8080/mRestServer/pmm/ticket")
                .request(MediaType.APPLICATION_JSON)
                .post(Entity.entity(ticket, MediaType.APPLICATION_JSON));
        client.close();

        FacesMessage facesMessage = new FacesMessage("Response: " + res.getStatus());
        System.out.println(facesMessage.toString());
        FacesContext.getCurrentInstance().addMessage(null, facesMessage);
    }

    public String getMyMessage() {
        return myMessage;
    }

    public void setMyMessage(String myMessage) {
        this.myMessage = myMessage;
    }

    public Long getMeterId() {
        return meterId;
    }

    public void setMeterId(Long meterId) {
        this.meterId = meterId;
    }

    public String getTic_start() {
        return tic_start;
    }

    public void setTic_start(String tic_start) {
        this.tic_start = tic_start;
    }

    public Integer getTic_duration() {
        return tic_duration;
    }

    public void setTic_duration(Integer tic_duration) {
        this.tic_duration = tic_duration;
    }
}
