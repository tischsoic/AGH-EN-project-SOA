package models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Ticket implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ticket_id;

    @Temporal(TemporalType.TIMESTAMP)
    private Date tic_start;

    @Temporal(TemporalType.TIMESTAMP)
    private Date tic_end;

    private Integer tic_duration;

    @ManyToOne
    @JoinColumn(name = "parking_meter_id")
    private ParkingMeter parkingMeter;

    public Long getTicket_id() {
        return ticket_id;
    }

    public void setTicket_id(Long ticket_id) {
        this.ticket_id = ticket_id;
    }

    public Date getTic_start() {
        return tic_start;
    }

    public void setTic_start(Date tic_start) {
        this.tic_start = tic_start;
    }

    public Date getTic_end() {
        return tic_end;
    }

    public void setTic_end(Date tic_end) {
        this.tic_end = tic_end;
    }

    public ParkingMeter getParkingMeter() {
        return parkingMeter;
    }

    public void setParkingMeter(ParkingMeter parkingMeter) {
        this.parkingMeter = parkingMeter;
    }

    public Integer getTic_duration() {
        return tic_duration;
    }

    public void setTic_duration(Integer duration) {
        this.tic_duration = duration;
    }
}
