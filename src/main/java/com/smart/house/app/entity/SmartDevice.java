package com.smart.house.app.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "smart_device")
@Getter
@Setter
public class SmartDevice {

    @Setter
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    @Getter
    private String name;

    @OneToMany(mappedBy = "smartDevice")
    private Set<SmartDeviceType> type;

}