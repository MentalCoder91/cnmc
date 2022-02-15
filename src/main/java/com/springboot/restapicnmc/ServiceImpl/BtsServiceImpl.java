package com.springboot.restapicnmc.ServiceImpl;

import com.springboot.restapicnmc.Model.BTS;
import com.springboot.restapicnmc.Repository.BtsRepository;
import com.springboot.restapicnmc.Service.BtsService;
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
