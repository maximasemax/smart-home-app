package com.smart.house.app.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "app_user") // лучше без явного указания, пусть hibernate сделает сам
public class User { // почему здесь нельзя lombok builder?

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // изучить, как генерятся уникальные id
    private Long id;

    private String phoneNumber;

    private String fio; // fio

}
