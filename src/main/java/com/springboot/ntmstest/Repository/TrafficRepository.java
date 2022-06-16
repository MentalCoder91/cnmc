package com.springboot.ntmstest.Repository;

import com.springboot.ntmstest.Model.Traffic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TrafficRepository  extends JpaRepository<Traffic,Long> {


    @Query(value = "select * from qos_data_voice_today_test where bts_type = 'U'",nativeQuery = true)
    List<Traffic> getTrafficGsm();

}
