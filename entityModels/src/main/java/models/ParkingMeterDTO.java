package models;

import java.io.Serializable;
import java.util.Date;

public class ParkingMeterDTO implements Serializable {
    private Long parking_meter_id;
    private Long zone_id;

    public Long getParking_meter_id() {
        return parking_meter_id;
    }

    public void setParking_meter_id(Long parking_meter_id) {
        this.parking_meter_id = parking_meter_id;
    }

    public Long getZone_id() {
        return zone_id;
    }

    public void setZone_id(Long zone_id) {
        this.zone_id = zone_id;
    }
}
