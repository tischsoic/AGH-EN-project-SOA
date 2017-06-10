package models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="parking_meter")
public class ParkingMeter implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long parking_meter_id;

    @ManyToOne
    @JoinColumn(name = "zone_id")
    private Zone zone;

    public Long getParking_meter_id() {
        return parking_meter_id;
    }

    public void setParking_meter_id(Long parking_meter_id) {
        this.parking_meter_id = parking_meter_id;
    }

    public Zone getZone() {
        return zone;
    }

    public void setZone(Zone zone) {
        this.zone = zone;
    }
}
