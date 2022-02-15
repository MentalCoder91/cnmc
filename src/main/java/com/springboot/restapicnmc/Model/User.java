package com.springboot.restapicnmc.Model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;



@NoArgsConstructor
@Entity
@Getter
@Setter
@Table(name = "user_master")
public class User {

    @Id
    @Column(name = "USER_ID")
    private String username;

    @Column(name ="PASSWORD")
    private String password;

    @Column(name = "SSA_ID")
    private String ssa;

    @Column(name = "CIRCLE_ID")
    private String circle;



    public User(String username, String password, String ssa, String circle) {
        this.username = username;
        this.password = password;
        this.ssa = ssa;
        this.circle = circle;
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
