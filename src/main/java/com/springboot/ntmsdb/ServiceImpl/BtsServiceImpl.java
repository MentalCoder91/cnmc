package com.springboot.ntmsdb.ServiceImpl;

import com.springboot.ntmsdb.Model.BTS;
import com.springboot.ntmsdb.Repository.BtsRepository;
import com.springboot.ntmsdb.Service.BtsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BtsServiceImpl implements BtsService {


    @Autowired
    private BtsRepository btsRepository;

    @Override
    public List<BTS> getAllBtsList() {
        return btsRepository.findAll();
    }

    @Override
    public List<BTS> getBtsByCircleId(String circle_id) {
        return btsRepository.getBtsListByCircleId(circle_id);
    }


}
