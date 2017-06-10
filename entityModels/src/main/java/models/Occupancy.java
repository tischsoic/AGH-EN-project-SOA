package models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
public class Occupancy implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long occupancy_id;

    private Date occ_start;
    private Date occ_end;

    @ManyToOne
    @JoinColumn(name="parking_space_id")
    private ParkingSpace parkingSpace;

    @OneToOne
    @JoinColumn(name="ticket_id")
    private Ticket ticket;

    public Long getOccupancy_id() {
        return occupancy_id;
    }

    public void setOccupancy_id(Long occupancy_id) {
        this.occupancy_id = occupancy_id;
    }

    public Date getOcc_start() {
        return occ_start;
    }

    public void setOcc_start(Date occ_start) {
        this.occ_start = occ_start;
    }

    public Date getOcc_end() {
        return occ_end;
    }

    public void setOcc_end(Date occ_end) {
        this.occ_end = occ_end;
    }

    public ParkingSpace getParkingSpace() {
        return parkingSpace;
    }

    public void setParkingSpace(ParkingSpace parkingSpace) {
        this.parkingSpace = parkingSpace;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }
}
