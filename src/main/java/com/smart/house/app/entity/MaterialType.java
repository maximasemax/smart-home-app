package com.smart.house.app.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "material_type")
public class MaterialType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "material_id", nullable = false)
    private Material material;

    private String type;
}