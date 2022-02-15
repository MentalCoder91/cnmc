package com.springboot.restapicnmc.Model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Data
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
}
