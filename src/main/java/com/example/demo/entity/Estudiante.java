package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.Getter;
import lombok.Setter;
import java.sql.Date;
import java.time.LocalDate;

@Entity
@Table(name = "estudiante")
@Getter
@Setter
public class Estudiante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    /*@size(max=40)*/

    @Column(name = "nombres", nullable = false)
    private String nombres;

    @Column(name = "apellidos", nullable = false)
    private String apellidos;

    @Column(name = "dni",nullable = false, length = 8)
    private String dni;

    @Column(name = "codigoPucp", nullable = false,length = 8)
    private String codigoPucp;

    @Column(name = "fechaDeNacimiento",nullable = false)
    private LocalDate fechaDeNacimiento;

    @Column(name = "sexo", nullable = false,length = 1)
    private String sexo;

    @Column(name = "correoInstitucional", nullable = false)
    @Email
    private String correoInstitucional;

    @Column(name = "correoPersonal", nullable = false)
    @Email
    private String correoPersonal;

    @Column(name = "telefono",nullable = false, length = 12)
    private String telefono;

    @Column
    private String direccion;

    @Column
    private String departamento;

    @Column
    private String provincia;

    @Column
    private String carrera;

    @Column(name = "fechaDeRegistro",nullable = false)
    private LocalDate fechaDeRegistro;

    @Column(name = "ultimaActualizacion",nullable = false)
    private LocalDate ultimaActualizacion;

    @Column
    private Boolean estado;
}