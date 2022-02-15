package com.springboot.restapicnmc.Repository;


import com.springboot.restapicnmc.Model.BTS;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BtsRepository extends JpaRepository<BTS,Long> {

    @Query(value = "select * from m_bts_master where circle_id = ?1 and bts_status =0",nativeQuery = true)
    List<BTS> getBtsListByCircleId(String circle_id);

}
