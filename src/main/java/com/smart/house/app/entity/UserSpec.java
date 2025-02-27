package com.smart.house.app.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "user_spec")
public class UserSpec {

    @Id
    @ManyToOne
    @JoinColumn(name = "spec_id", nullable = false)
    private HouseSpec house;

    @Id
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

}
