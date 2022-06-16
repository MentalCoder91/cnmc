package com.springboot.ntmsdb.Model;




import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@NamedNativeQuery(
        name = "BTS.getDownCircleList",
        query ="SELECT CASE WHEN cm.ZONE='E' THEN 'EAST' WHEN cm.ZONE='N' THEN 'NORTH' WHEN cm.ZONE='S' THEN 'SOUTH' WHEN cm.ZONE='W' THEN 'WEST' END AS zone,  \n" +
                "mbm.circle_id  circleId, \n" +
                "SUM(IF(mbm.site_type = 'BS', 1, 0)* IF(mbm.bts_type = 'G', 1, 0)* IF(mbm.bts_status=0,1,0)*IF(mbm.bts_down_cell_cnt = mbm.bts_cell_cnt, 1, 0))gbdown, \n" +
                "SUM(IF(mbm.site_type = 'BS', 1, 0)* IF(mbm.bts_type = 'U', 1, 0)* IF(mbm.bts_status=0,1,0)*IF(mbm.bts_down_cell_cnt = mbm.bts_cell_cnt, 1, 0))ubdown, \n" +
                "SUM(IF(mbm.site_type = 'BS', 1, 0)* IF(mbm.bts_type = 'L', 1, 0)* IF(mbm.bts_status=0,1,0)*IF(mbm.bts_down_cell_cnt = mbm.bts_cell_cnt, 1, 0))lbdown,  \n" +
                "SUM(IF(mbm.site_type = 'NB', 1, 0)* IF(mbm.bts_type = 'G', 1, 0)* IF(mbm.bts_status=0,1,0)*IF(mbm.bts_down_cell_cnt = mbm.bts_cell_cnt, 1, 0))gnbdown, \n" +
                "SUM(IF(mbm.site_type = 'NB', 1, 0)* IF(mbm.bts_type = 'U', 1, 0)* IF(mbm.bts_status=0,1,0)*IF(mbm.bts_down_cell_cnt = mbm.bts_cell_cnt, 1, 0))unbdown, \n" +
                "SUM(IF(mbm.site_type = 'NB', 1, 0)* IF(mbm.bts_type = 'L', 1, 0)* IF(mbm.bts_status=0,1,0)*IF(mbm.bts_down_cell_cnt = mbm.bts_cell_cnt, 1, 0))lnbdown, \n" +
                "SUM(IF(mbm.site_type = 'IP', 1, 0)* IF(mbm.bts_type = 'G', 1, 0)* IF(mbm.bts_status=0,1,0)*IF(mbm.bts_down_cell_cnt = mbm.bts_cell_cnt, 1, 0))gidown, \n" +
                "SUM(IF(mbm.site_type = 'IP', 1, 0)* IF(mbm.bts_type = 'U', 1, 0)* IF(mbm.bts_status=0,1,0)*IF(mbm.bts_down_cell_cnt = mbm.bts_cell_cnt, 1, 0))uidown, \n" +
                "SUM(IF(mbm.site_type = 'IP', 1, 0)* IF(mbm.bts_type = 'L', 1, 0)* IF(mbm.bts_status=0,1,0)*IF(mbm.bts_down_cell_cnt = mbm.bts_cell_cnt, 1, 0))lidown, \n" +
                "SUM(IF(mbm.site_type = 'US', 1, 0)* IF(mbm.bts_type = 'G', 1, 0)* IF(mbm.bts_status=0,1,0)*IF(mbm.bts_down_cell_cnt = mbm.bts_cell_cnt, 1, 0))gusdown, \n" +
                "SUM(IF(mbm.site_type = 'US', 1, 0)* IF(mbm.bts_type = 'U', 1, 0)* IF(mbm.bts_status=0,1,0)*IF(mbm.bts_down_cell_cnt = mbm.bts_cell_cnt, 1, 0))uusdown, \n" +
                "SUM(IF(mbm.site_type = 'US', 1, 0)* IF(mbm.bts_type = 'L', 1, 0)* IF(mbm.bts_status=0,1,0)*IF(mbm.bts_down_cell_cnt = mbm.bts_cell_cnt, 1, 0))lusdown, \n" +
                "SUM(IF(mbm.site_type = 'UI', 1, 0)* IF(mbm.bts_type = 'G', 1, 0)* IF(mbm.bts_status=0,1,0)*IF(mbm.bts_down_cell_cnt = mbm.bts_cell_cnt, 1, 0))gudown, \n" +
                "SUM(IF(mbm.site_type = 'UI', 1, 0)* IF(mbm.bts_type = 'U', 1, 0)* IF(mbm.bts_status=0,1,0)*IF(mbm.bts_down_cell_cnt = mbm.bts_cell_cnt, 1, 0))uudown, \n" +
                "SUM(IF(mbm.site_type = 'UI', 1, 0)* IF(mbm.bts_type = 'L', 1, 0)* IF(mbm.bts_status=0,1,0)*IF(mbm.bts_down_cell_cnt = mbm.bts_cell_cnt, 1, 0))ludown , \n" +
                "SUM(IF(mbm.bts_status = 0, 1, 0)*IF(mbm.bts_type = 'G', 1, 0)* IF(mbm.bts_down_cell_cnt > 0, 1, 0)* IF(mbm.bts_down_cell_cnt<>mbm.bts_cell_cnt,1,0)) Gpartl, \n" +
                "SUM(IF(mbm.bts_status = 0, 1, 0)*IF(mbm.bts_type = 'U', 1, 0)* IF(mbm.bts_down_cell_cnt > 0, 1, 0) * IF(mbm.bts_down_cell_cnt<>mbm.bts_cell_cnt,1,0)) Upartl, \n" +
                "SUM(IF(mbm.bts_status = 0, 1, 0)*IF(mbm.bts_type = 'L', 1, 0)* IF(mbm.bts_down_cell_cnt > 0, 1, 0) * IF(mbm.bts_down_cell_cnt<>mbm.bts_cell_cnt,1,0)) Lpartl, \n" +
                "SUM(IF(mbm.bts_status=0,1,0)* IF(mbm.bts_down_cell_cnt = mbm.bts_cell_cnt, 1, 0)) totDown, \n" +
                "SUM(IF(mbm.bts_type = 'G', 1, 0)* IF(mbm.site_type='UI',0,1)) totG, \n" +
                "SUM(IF(mbm.bts_type = 'U', 1, 0)* IF(mbm.site_type='UI',0,1)) totU, \n" +
                "SUM(IF(mbm.bts_type = 'L', 1, 0)* IF(mbm.site_type='UI',0,1)) totL, \n" +
                "SUM(IF(mbm.bts_type = 'G', 1, 0)*IF(mbm.bts_status = 0, 1, 0)*IF(mbm.bts_down_cell_cnt = mbm.bts_cell_cnt, 1, 0)) totDG, \n" +
                "SUM(IF(mbm.bts_type = 'U', 1, 0)*IF(mbm.bts_status = 0, 1, 0)*IF(mbm.bts_down_cell_cnt = mbm.bts_cell_cnt, 1, 0)) totDU, \n" +
                "SUM(IF(mbm.bts_type = 'L', 1, 0)*IF(mbm.bts_status = 0, 1, 0)*IF(mbm.bts_down_cell_cnt = mbm.bts_cell_cnt, 1, 0)) totDL, \n" +
                "SUM(IF(mbm.site_type='UI',0,1)) totWoUI, SUM(1) total, \n" +
                "ROUND(SUM(IF(mbm.bts_status=0,1,0)*IF(mbm.site_type='UI',0,1))*100/SUM(IF(mbm.site_type='UI',0,1)),2) downPerWoUI, \n" +
                "ROUND(SUM(IF(mbm.bts_status=0,1,0)* IF(mbm.bts_down_cell_cnt=mbm.bts_cell_cnt, 1, 0))*100/SUM(1),2) downPerWithUIP  \n" +
                "FROM m_bts_master mbm,circle_master cm \n" +
                "WHERE mbm.circle_id = cm.circle_id  \n" +
                "GROUP BY cm.zone,mbm.circle_id"
               ,
        resultSetMapping = "down_report_circle_wise_mapping"
)
@SqlResultSetMapping(
        name = "down_report_circle_wise_mapping",
        classes = @ConstructorResult(
                targetClass = DownReportCircleWise.class,
                columns = {
                        @ColumnResult(name = "zone", type = Character.class),
                        @ColumnResult(name = "circleId", type = String.class),
                        @ColumnResult(name = "gbdown", type = Long.class),
                        @ColumnResult(name = "ubdown", type = Long.class),
                        @ColumnResult(name = "lbdown", type = Long.class),
                        @ColumnResult(name = "gnbdown", type = Long.class),
                        @ColumnResult(name = "unbdown", type = Long.class),
                        @ColumnResult(name = "lnbdown", type = Long.class),
                        @ColumnResult(name = "gidown", type = Long.class),
                        @ColumnResult(name = "uidown", type = Long.class),
                        @ColumnResult(name = "lidown", type = Long.class),
                        @ColumnResult(name = "gusdown", type = Long.class),
                        @ColumnResult(name = "uusdown", type = Long.class),
                        @ColumnResult(name = "lusdown", type = Long.class),
                        @ColumnResult(name = "gudown", type = Long.class),
                        @ColumnResult(name = "uudown", type = Long.class),
                        @ColumnResult(name = "ludown ", type = Long.class),
                        @ColumnResult(name = "Gpartl", type = Long.class),
                        @ColumnResult(name = "Upartl", type = Long.class),
                        @ColumnResult(name = "Lpartl", type = Long.class),
                        @ColumnResult(name = "totDown", type = Long.class),
                        @ColumnResult(name = "totG", type = Long.class),
                        @ColumnResult(name = "totU", type = Long.class),
                        @ColumnResult(name = "totL", type = Long.class),
                        @ColumnResult(name = "totDG", type = Long.class),
                        @ColumnResult(name = "totDU", type = Long.class),
                        @ColumnResult(name = "totDL", type = Long.class),
                        @ColumnResult(name = "totWoUI", type = Long.class),
                        @ColumnResult(name = "total", type = Long.class),
                        @ColumnResult(name = "downPerWoUI", type = Double.class),
                        @ColumnResult(name = "downPerWithUIP", type = Double.class)
                }
        )
)

@Entity
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


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BTS bts = (BTS) o;
        return  Objects.equals(btsId, bts.btsId) && Objects.equals(btsName, bts.btsName) && Objects.equals(btsSiteId, bts.btsSiteId)  && Objects.equals(circleId, bts.circleId) && Objects.equals(ssaId, bts.ssaId) && Objects.equals(ssa, bts.ssa);
    }

    @Override
    public int hashCode() {
        return Objects.hash(btsId, btsName, btsSiteId, btsDownDate, circleId, ssaId, ssa);
    }


    public Integer getBtsId() {
        return btsId;
    }

    public void setBtsId(Integer btsId) {
        this.btsId = btsId;
    }

    public String getBtsName() {
        return btsName;
    }

    public void setBtsName(String btsName) {
        this.btsName = btsName;
    }

    public String getBtsSiteId() {
        return btsSiteId;
    }

    public void setBtsSiteId(String btsSiteId) {
        this.btsSiteId = btsSiteId;
    }

    public boolean isBtsStatus() {
        return btsStatus;
    }

    public void setBtsStatus(boolean btsStatus) {
        this.btsStatus = btsStatus;
    }

    public Date getBtsDownDate() {
        return btsDownDate;
    }

    public void setBtsDownDate(Date btsDownDate) {
        this.btsDownDate = btsDownDate;
    }

    public String getCircleId() {
        return circleId;
    }

    public void setCircleId(String circleId) {
        this.circleId = circleId;
    }

    public String getSsaId() {
        return ssaId;
    }

    public void setSsaId(String ssaId) {
        this.ssaId = ssaId;
    }

    public SSA getSsa() {
        return ssa;
    }

    public void setSsa(SSA ssa) {
        this.ssa = ssa;
    }
}
