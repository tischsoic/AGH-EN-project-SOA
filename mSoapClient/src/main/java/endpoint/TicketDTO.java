
package endpoint;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for ticketDTO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ticketDTO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="duration" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="parking_meter_id" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="tic_end" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="tic_start" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="ticket_id" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ticketDTO", propOrder = {
    "duration",
    "parkingMeterId",
    "ticEnd",
    "ticStart",
    "ticketId"
})
public class TicketDTO {

    protected Integer duration;
    @XmlElement(name = "parking_meter_id")
    protected Long parkingMeterId;
    @XmlElement(name = "tic_end")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar ticEnd;
    @XmlElement(name = "tic_start")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar ticStart;
    @XmlElement(name = "ticket_id")
    protected Long ticketId;

    /**
     * Gets the value of the duration property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getDuration() {
        return duration;
    }

    /**
     * Sets the value of the duration property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setDuration(Integer value) {
        this.duration = value;
    }

    /**
     * Gets the value of the parkingMeterId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getParkingMeterId() {
        return parkingMeterId;
    }

    /**
     * Sets the value of the parkingMeterId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setParkingMeterId(Long value) {
        this.parkingMeterId = value;
    }

    /**
     * Gets the value of the ticEnd property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getTicEnd() {
        return ticEnd;
    }

    /**
     * Sets the value of the ticEnd property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setTicEnd(XMLGregorianCalendar value) {
        this.ticEnd = value;
    }

    /**
     * Gets the value of the ticStart property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getTicStart() {
        return ticStart;
    }

    /**
     * Sets the value of the ticStart property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setTicStart(XMLGregorianCalendar value) {
        this.ticStart = value;
    }

    /**
     * Gets the value of the ticketId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getTicketId() {
        return ticketId;
    }

    /**
     * Sets the value of the ticketId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setTicketId(Long value) {
        this.ticketId = value;
    }

}
