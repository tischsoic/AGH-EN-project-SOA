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
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import java.util.List;


@Stateless
@RequestScoped
@Named("formbean")
public class FormBean {

    public String getMyMessage() {
        return myMessage;
    }

    public void setMyMessage(String myMessage) {
        this.myMessage = myMessage;
    }

    protected Client client;
    private String myMessage;

    public Integer getMeterId() {
        return meterId;
    }

    public void setMeterId(Integer meterId) {
        this.meterId = meterId;
    }

    private Integer meterId;

    @PostConstruct
    private void init() {
        client = ClientBuilder.newClient();
    }

    @PreDestroy
    private void clean() {
        client.close();
    }

    public FormBean() {
    }


    public void sendTicket() {
        List<Book> books = client.target("http://localhost:8080/mRestServer/helloworld")
                .request(MediaType.APPLICATION_JSON)
                .get(new GenericType<List<Book>>() {

                });

        FacesMessage facesMessage = new FacesMessage("Book title: " + books.get(0).getTitle());
        FacesContext.getCurrentInstance().addMessage(null, facesMessage);
    }

}
