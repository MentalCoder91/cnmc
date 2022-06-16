package com.springboot.ntmsdb.Model;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DownReportCircleWise {

    private Character	zone;
    private String	circleId;
    private Long gbdown;
    private Long ubdown;
    private Long lbdown;
    private Long gnbdown;
    private Long unbdown;
    private Long lnbdown;
    private Long gidown;
    private Long uidown;
    private Long lidown;
    private Long gusdown;
    private Long uusdown;
    private Long lusdown;
    private Long gudown;
    private Long uudown;
    private Long ludown ;
    private Long Gpartl;
    private Long Upartl;
    private Long Lpartl;
    private Long totDown;
    private Long totG;
    private Long totU;
    private Long totL;
    private Long totDG;
    private Long totDU;
    private Long totDL;
    private Long totWoUI;
    private Long total;
    private Double downPerWoUI;
    private Double downPerWithUIP;


    public DownReportCircleWise() {
    }

    public DownReportCircleWise(Character zone, String circleId, Long gbdown, Long ubdown, Long lbdown, Long gnbdown, Long unbdown, Long lnbdown, Long gidown, Long uidown, Long lidown, Long gusdown, Long uusdown, Long lusdown, Long gudown, Long uudown, Long ludown, Long gpartl, Long upartl, Long lpartl, Long totDown, Long totG, Long totU, Long totL, Long totDG, Long totDU, Long totDL, Long totWoUI, Long total, Double downPerWoUI, Double downPerWithUIP) {
        this.zone = zone;
        this.circleId = circleId;
        this.gbdown = gbdown;
        this.ubdown = ubdown;
        this.lbdown = lbdown;
        this.gnbdown = gnbdown;
        this.unbdown = unbdown;
        this.lnbdown = lnbdown;
        this.gidown = gidown;
        this.uidown = uidown;
        this.lidown = lidown;
        this.gusdown = gusdown;
        this.uusdown = uusdown;
        this.lusdown = lusdown;
        this.gudown = gudown;
        this.uudown = uudown;
        this.ludown = ludown;
        Gpartl = gpartl;
        Upartl = upartl;
        Lpartl = lpartl;
        this.totDown = totDown;
        this.totG = totG;
        this.totU = totU;
        this.totL = totL;
        this.totDG = totDG;
        this.totDU = totDU;
        this.totDL = totDL;
        this.totWoUI = totWoUI;
        this.total = total;
        this.downPerWoUI = downPerWoUI;
        this.downPerWithUIP = downPerWithUIP;
    }



}
