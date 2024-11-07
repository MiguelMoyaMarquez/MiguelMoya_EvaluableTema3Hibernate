package org.example.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table (name = "opinion")
public class Opinion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descripcion;
    private  String usuario;
    private int puntuacion;

    //@OneToMany(mappedBy = "pelicula_id")
    //private List<Pelicula> peliculas;
     private int pelicula_id;

    public Opinion() {
    }


}
