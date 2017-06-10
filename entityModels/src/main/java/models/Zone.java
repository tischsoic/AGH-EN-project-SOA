package models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Zone implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long zone_id;
    private String name;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User guard;

    @OneToMany
    @JoinColumn(name="parking_meter_id")
    private List<ParkingMeter> parkingMeters;

    public Long getZone_id() {
        return zone_id;
    }

    public void setZone_id(Long id) {
        this.zone_id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getGuard() {
        return guard;
    }

    public void setGuard(User guard) {
        this.guard = guard;
    }

    public List<ParkingMeter> getParkingMeters() {
        return parkingMeters;
    }

    public void setParkingMeters(List<ParkingMeter> parkingMeter) {
        this.parkingMeters = parkingMeter;
    }
}
