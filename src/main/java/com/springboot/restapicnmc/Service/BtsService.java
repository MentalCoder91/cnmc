package com.springboot.restapicnmc.Service;

import com.springboot.restapicnmc.Model.BTS;

import java.util.List;

public interface BtsService {


    List<BTS> getAllBtsList();

    List<BTS> getBtsByCircleId(String circle_id);
}
