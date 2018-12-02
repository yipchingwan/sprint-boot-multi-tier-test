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


}
