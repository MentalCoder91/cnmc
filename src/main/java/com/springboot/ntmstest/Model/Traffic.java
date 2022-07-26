package com.springboot.ntmstest.Model;


import com.springboot.ntmsdb.Model.DownReportCircleWise;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NamedNativeQuery(
        name = "Traffic.getAvgTrafficCircleWise",
        query ="select circle_id as circleId,round((SUM(data_traffic_mb)/SUM(1)),2) as trafficDataGb, round((SUM(cell_traffic_erl)/SUM(1)),2) as voiceTrafficErl" +
                "  FROM ntmstest.qos_data_voice_today group by circle_id" +
                " order by circle_id"

        ,
        resultSetMapping = "avg_circle_wise_traffic_mapping"
)
@SqlResultSetMapping(
        name = "avg_circle_wise_traffic_mapping",
        classes = @ConstructorResult(
                targetClass = AvgTrafficCircleWise.class,
                columns = {
                        @ColumnResult(name = "circleId", type = String.class),
                        @ColumnResult(name = "trafficDataGb", type = Double.class),
                        @ColumnResult(name = "voiceTrafficErl", type = Double.class),

                }
        )
)

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
