package com.springboot.restapicnmc.Controller;


import com.springboot.restapicnmc.Model.BTS;
import com.springboot.restapicnmc.Model.User;
import com.springboot.restapicnmc.Service.BtsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BtsController {


    @Autowired
    private BtsService btsService;


    @GetMapping("/helloBts")
    public  String helloBTS()
    {
        return "Hello BTS  !!!!!!!!!";

    }


    @RequestMapping(value = "/BtsAll/{circleId}",method = RequestMethod.GET)
    public ResponseEntity<List<BTS>> getAllBtsByCircleId(@PathVariable("circleId") String circle_id){

        return new ResponseEntity<List<BTS>>(btsService.getBtsByCircleId(circle_id) , HttpStatus.OK);
    }

}
