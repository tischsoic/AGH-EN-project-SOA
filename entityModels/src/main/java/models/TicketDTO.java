package models;

import java.io.Serializable;
import java.util.Date;

public class TicketDTO implements Serializable {
    private Long ticket_id;
    private Date tic_start;
    private Date tic_end;
    private Long parking_meter_id;
    private Integer duration;

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

    public Long getParking_meter_id() {
        return parking_meter_id;
    }

    public void setParking_meter_id(Long parking_meter_id) {
        this.parking_meter_id = parking_meter_id;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }
}
