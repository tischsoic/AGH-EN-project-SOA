//import endpoint.placeservice.HelloWorld;
//import endpoint.placeservice.HelloWorldService;

import endpoint.placeservice.HelloWorld;
import endpoint.placeservice.HelloWorldService;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Stateless;
import javax.faces.application.FacesMessage;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.xml.ws.WebServiceRef;
import java.util.List;


@Stateless
@RequestScoped
@Named("formsoapclient")
public class FormSoapClientBean {

//    @WebServiceRef(wsdlLocation = "http://localhost:8080/mSoapServer/HelloWorld?wsdl")
//    private HelloWorldService service;

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

    public FormSoapClientBean() {
    }


    public void sendTicket() {
        HelloWorld port = new HelloWorldService().getHelloWorldPort();
//
        FacesMessage facesMessage = new FacesMessage("Book title: " + port.getMsg("Moj arg"));
        FacesContext.getCurrentInstance().addMessage(null, facesMessage);
    }

}
