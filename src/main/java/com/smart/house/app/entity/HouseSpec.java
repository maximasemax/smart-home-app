package com.smart.house.app.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "house_spec")
public class HouseSpec {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Byte floors;

    @ManyToOne
    @JoinColumn(name = "material_id", nullable = false)
    private Material material;

    @Column(name = "total_cost")
    private BigDecimal totalCost;

    @OneToMany(mappedBy = "house",cascade = CascadeType.ALL)
    private List<SmartDeviceSpec> smartDeviceSpecs;

    
}
