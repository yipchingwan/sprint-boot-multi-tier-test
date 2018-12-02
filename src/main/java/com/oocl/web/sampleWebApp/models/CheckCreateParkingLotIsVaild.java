package com.oocl.web.sampleWebApp.models;

import com.oocl.web.sampleWebApp.domain.ParkingLot;

public class CheckCreateParkingLotIsVaild {
    private ParkingLot parkingLot = null;

    public CheckCreateParkingLotIsVaild(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public CheckCreateParkingLotIsVaild() {
    }

    public ParkingLot getParkingLot() {
        return parkingLot;
    }

    public boolean isVaild(){
        return this.parkingLot!=null;
    }
}
