package com.smart.house.app.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "smart_device_spec")
public class SmartDeviceSpec {

    @Id
    @ManyToOne
    @JoinColumn(name = "house_spec_id", nullable = false)
    private HouseSpec house;

    @Id
    @ManyToOne
    @JoinColumn(name = "smart_device_id", nullable = false)
    private SmartDevice smartDevice;


}