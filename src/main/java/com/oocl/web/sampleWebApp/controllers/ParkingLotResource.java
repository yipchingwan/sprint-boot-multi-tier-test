package com.oocl.web.sampleWebApp.controllers;

import com.oocl.web.sampleWebApp.domain.ParkingLot;
import com.oocl.web.sampleWebApp.domain.ParkingLotRepository;
import com.oocl.web.sampleWebApp.models.CheckCreateParkingIsVaild;
import com.oocl.web.sampleWebApp.models.CheckCreateParkingLotIsVaild;
import com.oocl.web.sampleWebApp.models.ParkingLotResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

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
                parkingLotRepository.save(parkingLot);
                return ResponseEntity.created(new URI("/parkinglots/"+parkingLot.getParkingLotId())).body("Parking Lot is created");
            }
            catch (Exception e){
                return ResponseEntity.badRequest().body("Invaild parking g");
            }
        }
        return ResponseEntity.badRequest().body("Invaild parking lot");

    }
    @GetMapping
    public ResponseEntity<ParkingLotResponse[]> getAllParkingLots(){
        final ParkingLotResponse[] parkingLots = parkingLotRepository.findAll()
                .stream().map(ParkingLotResponse::create)
                .toArray(ParkingLotResponse[]::new);

        return ResponseEntity.ok(parkingLots);

    }




}
