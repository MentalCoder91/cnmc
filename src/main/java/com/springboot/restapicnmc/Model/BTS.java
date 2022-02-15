package com.springboot.restapicnmc.Model;


import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "m_bts_master")
public class BTS {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bts_id")
    private Integer btsId;

    @Column(name = "bts_name")
    private String btsName;

    @Column(name = "bts_site_id")
    private String btsSiteId;

    @Column(name = "bts_status", columnDefinition = "TINYINT(1)")
    private boolean btsStatus;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "bts_status_dt")
    private Date btsDownDate;

    @Column(name = "circle_id")
    private String circleId;

    @Column(name="ssa_id")
    private String ssaId;

    @ManyToOne()
    @JoinColumn(name = "ssa_id",referencedColumnName = "SSA_ID",insertable = false, updatable = false)
    private SSA ssa;








}
