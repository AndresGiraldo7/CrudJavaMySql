package com.institucion.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.io.Serializable;


@Data
@Entity
@Table(name = "estudiante")
public class Estudiante implements Serializable {

    private static final long serialVersionUID= 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "id_tipodocumento")
    private String id_tipodocumento;

    @Column(name= "numerodocumento")
    private String numerodocumento;

    @Column(name= "nombre")
    private String nombre;

    @Column(name= "apellidos")
    private String apellidos;

    @Column(name = "fecha_nacimiento")
    private String fecha_nacimiento;

    @Column(name = "id_grado")
    private String id_grado;

    @Column(name = "id_dane")
    private String id_dane;

    @Column(name = "direccion")
    private String direccion;

    @Column(name = "email")
    private String email;

    @Column(name = "fijo")
    private String fijo;

    @Column(name = "celular")
    private String celular;





}
