package com.oocl.web.sampleWebApp.domain;
import javax.persistence.*;

@Entity
@Table(name = "parking_lot")
public class ParkingLot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "parking_lot__id", length = 64, unique = true, nullable = false)
    private String parkingLotId;

    private Integer capacity;

    public ParkingLot() {
    }

    public ParkingLot(String parkingLotId, Integer capacity) {
        this.parkingLotId = parkingLotId;
        this.capacity = capacity;
    }

    public String getParkingLotId() {
        return parkingLotId;
    }

    public void setParkingLotId(String parkingLotId) {
        this.parkingLotId = parkingLotId;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }
}
