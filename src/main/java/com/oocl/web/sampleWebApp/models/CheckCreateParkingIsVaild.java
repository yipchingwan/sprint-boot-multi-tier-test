package com.oocl.web.sampleWebApp.models;

import com.oocl.web.sampleWebApp.domain.ParkingBoy;

public class CheckCreateParkingIsVaild {
    private ParkingBoy parkingBoy=null;

    public CheckCreateParkingIsVaild(ParkingBoy parkingBoy) {
        this.parkingBoy = parkingBoy;
    }
    public CheckCreateParkingIsVaild(){

    }

    public ParkingBoy getParkingBoy() {
        return parkingBoy;
    }
    public boolean isVaild(){
        if(this.parkingBoy==null){
            return false;
        }
        return true;
    }


}
