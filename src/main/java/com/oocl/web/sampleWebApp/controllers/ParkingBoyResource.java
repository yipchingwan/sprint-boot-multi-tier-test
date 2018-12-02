package com.oocl.web.sampleWebApp.controllers;

import com.oocl.web.sampleWebApp.domain.ParkingBoy;
import com.oocl.web.sampleWebApp.domain.ParkingBoyRepository;
import com.oocl.web.sampleWebApp.models.CheckCreateParkingIsVaild;
import com.oocl.web.sampleWebApp.models.ParkingBoyResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;

@RestController
@RequestMapping("/parkingboys")
public class ParkingBoyResource {

    @Autowired
    private ParkingBoyRepository parkingBoyRepository;

    @GetMapping
    public ResponseEntity<ParkingBoyResponse[]> getAll() {
        final ParkingBoyResponse[] parkingBoys = parkingBoyRepository.findAll().stream()
            .map(ParkingBoyResponse::create)
            .toArray(ParkingBoyResponse[]::new);
        return ResponseEntity.ok(parkingBoys);
    }

    @PostMapping
    public ResponseEntity<String> create(@RequestBody(required = false) ParkingBoy parkingBoy) throws Exception {
        CheckCreateParkingIsVaild parkingBoyVaildation = new CheckCreateParkingIsVaild(parkingBoy);
        if(parkingBoyVaildation.isVaild()){
           try{
               parkingBoyRepository.save(parkingBoy);
               return ResponseEntity.created(new URI("/parkingboys/"+parkingBoy.getEmployeeId())).body("Created");
           }
           catch (Exception e){
               return ResponseEntity.badRequest().body("Invaild parking boy");
           }

        }

        return ResponseEntity.badRequest().body("Invaild parking boy");
    }

}
