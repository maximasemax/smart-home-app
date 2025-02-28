package com.smart.house.app.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "smart_device_type")
@Getter
@Setter
public class SmartDeviceType {

    @Setter
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "smart_device_id", nullable = false)
    private SmartDevice smartDevice;

    @Setter
    @Getter
    private String type;


}