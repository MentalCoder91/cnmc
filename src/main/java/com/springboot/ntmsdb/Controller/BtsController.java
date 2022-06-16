package com.springboot.ntmsdb.Controller;


import com.springboot.ntmsdb.Model.BTS;
import com.springboot.ntmsdb.Model.DownReportCircleWise;
import com.springboot.ntmsdb.Repository.BtsRepository;
import com.springboot.ntmsdb.Service.BtsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/api" )
public class BtsController {


    @Autowired
    private BtsService btsService;


    @Autowired
    private BtsRepository btsRepository;


    @GetMapping(value = "/helloBts")
    public  String helloBTS()
    {
        return "Hello BTS  !!!!!!!!!";

    }


        @RequestMapping(value = "/BtsAll/{circleId}",method = RequestMethod.GET , produces = "application/xml")
        public ResponseEntity<?> getAllBtsByCircleId(@PathVariable String circleId){

            List<BTS> listBts = btsService.getBtsByCircleId(circleId);
            Map<String, Long> mapBts = listBts.stream().collect(Collectors
                    .groupingBy(BTS::getCircleId,Collectors.counting()));

            return new ResponseEntity<>(mapBts, HttpStatus.OK);
        }

        @RequestMapping(value = "/btsNetworkDownReport",method = RequestMethod.GET , produces = "application/json")
        public ResponseEntity<List<DownReportCircleWise>> getCustomQuery(){
            return new ResponseEntity<List<DownReportCircleWise>>((List<DownReportCircleWise>) btsRepository.getDownCircleList(), HttpStatus.OK);
        }

}
