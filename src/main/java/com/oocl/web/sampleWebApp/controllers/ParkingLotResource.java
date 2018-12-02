package com.oocl.web.sampleWebApp.controllers;

import com.oocl.web.sampleWebApp.domain.ParkingLot;
import com.oocl.web.sampleWebApp.domain.ParkingLotRepository;
import com.oocl.web.sampleWebApp.models.CheckCreateParkingIsVaild;
import com.oocl.web.sampleWebApp.models.CheckCreateParkingLotIsVaild;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.net.URISyntaxException;

@RestController
@RequestMapping("/parkinglots")
public class ParkingLotResource {

    @Autowired
    private ParkingLotRepository parkingLotRepository;

    @PostMapping
    public ResponseEntity<String> createLot(@RequestBody ParkingLot parkingLot) throws Exception {
        CheckCreateParkingLotIsVaild checkCreateParkingLotIsVaild = new CheckCreateParkingLotIsVaild(parkingLot);
        if(checkCreateParkingLotIsVaild.isVaild()){
            try{
                parkingLotRepository.saveAndFlush(parkingLot);
                return ResponseEntity.created(new URI("/parkinglots/"+parkingLot.getParkingLotId())).body("Parking Lot is created");
            }
            catch (Exception e){
                return ResponseEntity.badRequest().body("Invaild parking boy");
            }
        }
        return ResponseEntity.badRequest().body("Invaild parking boy");

    }




}
