package org.example.models;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table (name = "pelicula")
public class Pelicula implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;

    public Pelicula() {
    }

    public Pelicula(String titulo) {
        this.titulo = titulo;
    }
}
