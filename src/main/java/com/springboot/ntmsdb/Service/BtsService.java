package com.springboot.ntmsdb.Service;

import com.springboot.ntmsdb.Model.BTS;

import java.util.List;

public interface BtsService {


    List<BTS> getAllBtsList();

    List<BTS> getBtsByCircleId(String circle_id);
}
