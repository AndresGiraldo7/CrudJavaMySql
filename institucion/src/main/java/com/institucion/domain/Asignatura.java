package com.institucion.domain;


import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "asignatura")
public class Asignatura implements Serializable {

    private static final long serialVersionUID= 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;


    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "id_docente")
    private String id_docente;


}
