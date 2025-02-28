package com.smart.house.app.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "material_type")
@Getter
@Setter
public class MaterialType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "material_id", nullable = false)
    private Material material;

    private String type;
}