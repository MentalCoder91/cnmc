package com.springboot.ntmstest.Model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "qos_data_voice_today_test")
public class Traffic {

    @Id
    @Column(name = "bts_id")
    private Long btsId;

    @Column(name = "zone")
    private Character zone;

    @Column(name = "circle_id")
    private String circleId;

    @Column(name="ssa_id")
    private String ssaId;

    @Column(name = "bsc_name")
    private String bscName;

    @Column(name = "bts_site_id")
    private String btsSiteId;

    @Column(name = "bts_type")
    private Character btsType;

    @Column(name = "make")
    private String make;

    @Column(name = "data_traffic_mb")
    private Double dataTrafficMb;

    @Column(name = "cell_traffic_erl")
    private Double cellTrafficErl;








}
