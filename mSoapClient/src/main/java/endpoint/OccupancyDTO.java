
package endpoint;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for occupancyDTO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="occupancyDTO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="occ_end" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="occ_start" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="occupancy_id" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="parking_space_id" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
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
@XmlType(name = "occupancyDTO", propOrder = {
    "occEnd",
    "occStart",
    "occupancyId",
    "parkingSpaceId",
    "ticketId"
})
public class OccupancyDTO {

    @XmlElement(name = "occ_end")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar occEnd;
    @XmlElement(name = "occ_start")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar occStart;
    @XmlElement(name = "occupancy_id")
    protected Long occupancyId;
    @XmlElement(name = "parking_space_id")
    protected Long parkingSpaceId;
    @XmlElement(name = "ticket_id")
    protected Long ticketId;

    /**
     * Gets the value of the occEnd property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getOccEnd() {
        return occEnd;
    }

    /**
     * Sets the value of the occEnd property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setOccEnd(XMLGregorianCalendar value) {
        this.occEnd = value;
    }

    /**
     * Gets the value of the occStart property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getOccStart() {
        return occStart;
    }

    /**
     * Sets the value of the occStart property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setOccStart(XMLGregorianCalendar value) {
        this.occStart = value;
    }

    /**
     * Gets the value of the occupancyId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getOccupancyId() {
        return occupancyId;
    }

    /**
     * Sets the value of the occupancyId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setOccupancyId(Long value) {
        this.occupancyId = value;
    }

    /**
     * Gets the value of the parkingSpaceId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getParkingSpaceId() {
        return parkingSpaceId;
    }

    /**
     * Sets the value of the parkingSpaceId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setParkingSpaceId(Long value) {
        this.parkingSpaceId = value;
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
