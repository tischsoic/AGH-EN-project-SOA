package models;

import java.io.Serializable;
import java.util.Date;

public class OccupancyDTO implements Serializable {
    private Long occupancy_id;
    private Date occ_start;
    private Date occ_end;
    private Long parking_space_id;
    private Long ticket_id;

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

    public Long getParking_space_id() {
        return parking_space_id;
    }

    public void setParking_space_id(Long parking_space_id) {
        this.parking_space_id = parking_space_id;
    }

    public Long getTicket_id() {
        return ticket_id;
    }

    public void setTicket_id(Long ticket_id) {
        this.ticket_id = ticket_id;
    }
}
