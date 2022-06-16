package com.springboot.ntmsdb.Model;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "ssa_master")
public class SSA {


    @Id
    @Column(name = "SSA_ID")
    private String ssaId;


    @Column(name = "SSA_NAME")
    private String ssaName;

    @JsonIgnore
    @OneToMany(mappedBy = "ssa",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<BTS> btsList= new ArrayList<>();

    public String getSsaId() {
        return ssaId;
    }

    public void setSsaId(String ssaId) {
        this.ssaId = ssaId;
    }

    public String getSsaName() {
        return ssaName;
    }

    public void setSsaName(String ssaName) {
        this.ssaName = ssaName;
    }

    public List<BTS> getBtsList() {
        return btsList;
    }

    public void setBtsList(List<BTS> btsList) {
        this.btsList = btsList;
    }





}
