package com.springboot.ntmstest.Controller;


import com.springboot.ntmstest.Model.Traffic;
import com.springboot.ntmstest.Repository.TrafficRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/traffic")
public class TrafficController{


    @Autowired
    private TrafficRepository trafficRepository;


    @GetMapping("/hello")
    public String helloTraffic(){
        return "I am Traffic";
    }


    @GetMapping(value = "/getGsmTraffic",produces = "application/json")
    public ResponseEntity<List<Traffic>> getGsmTraffic(){

       List<Traffic> getGsmTraffic = trafficRepository.getTrafficGsm();
       return new ResponseEntity<List<Traffic>>(getGsmTraffic,HttpStatus.OK);

    }





}
