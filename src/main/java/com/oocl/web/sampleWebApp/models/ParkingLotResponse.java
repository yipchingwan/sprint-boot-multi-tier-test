package com.oocl.web.sampleWebApp.models;

import com.oocl.web.sampleWebApp.domain.ParkingLot;

import java.util.Objects;

public class ParkingLotResponse {
    private String parkingLotId;
    private Integer capacity;

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

    public static ParkingLotResponse create(String parkingLotId, Integer capacity){
        final ParkingLotResponse response = new ParkingLotResponse();
        response.setParkingLotId(parkingLotId);
        response.setCapacity(capacity);
        return response;
    }

    public static ParkingLotResponse create(ParkingLot entity){
        return create(entity.getParkingLotId(), entity.getCapacity());
    }
}
