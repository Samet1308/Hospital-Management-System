package com.hospitalmanagement.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "patients")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    private String name;

    private String age;

    private String blood;

    private String prescription;

    private String dose;

    private String fees;

    private String urgency;

}
