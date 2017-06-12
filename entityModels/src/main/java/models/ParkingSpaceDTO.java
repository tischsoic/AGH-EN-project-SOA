package models;

import java.io.Serializable;

public class ParkingSpaceDTO implements Serializable {
    private Long parking_space_id;
    private Long zone_id;

    public Long getParking_space_id() {
        return parking_space_id;
    }

    public void setParking_space_id(Long parking_space_id) {
        this.parking_space_id = parking_space_id;
    }

    public Long getZone_id() {
        return zone_id;
    }

    public void setZone_id(Long zone_id) {
        this.zone_id = zone_id;
    }
}
