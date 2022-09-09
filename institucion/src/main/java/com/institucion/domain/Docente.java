package com.institucion.domain;


import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "docente")
public class Docente implements Serializable {

    private static final long serialVersionUID= 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "id_tipodocumento")
    private String id_tipodocumento;

    @Column(name= "numerodocumento")
    private String numerodocumento;

    @Column(name= "nombres")
    private String nombres;

    @Column(name= "apellidos")
    private String apellidos;

    @Column(name = "fecha_nacimiento")
    private String fecha_nacimiento;

    @Column(name = "asig_dictadas")
    private String asig_dictadas;

    @Column (name = "grado_escolaridad")
    private String grado_escolaridad;

    @Column (name = "id_gradoresponsable")
    private String id_gradoresponsable;

    @Column(name = "email")
    private String email;

    @Column(name = "fijo")
    private String fijo;

    @Column(name = "celular")
    private String celular;











}
