package models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="parking_space")
public class ParkingSpace implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long parking_space_id;

    @ManyToOne
    @JoinColumn(name = "zone_id")
    private Zone zone;

    public Long getParking_space_id() {
        return parking_space_id;
    }

    public void setParking_space_id(Long parking_space_id) {
        this.parking_space_id = parking_space_id;
    }

    public Zone getZone() {
        return zone;
    }

    public void setZone(Zone zone) {
        this.zone = zone;
    }
}
