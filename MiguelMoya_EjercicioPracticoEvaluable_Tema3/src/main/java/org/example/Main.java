package org.example;


import org.example.dao.HibernateUtil;
import org.example.dao.OpinionDAO;
import org.example.dao.PeliculaDAO;
import org.example.models.Pelicula;
import org.hibernate.SessionFactory;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        //Para probar que funcione muestro brevemente todas las peliculas
        HibernateUtil.getSessionFactory();
        System.out.println("Pruebas:");
        HibernateUtil.getSessionFactory().inSession(
                (session)->{
                    session.createQuery("From Pelicula ", Pelicula.class)
                            .list()
                            .forEach(System.out::println);
                    System.out.println("-----------------------------------------------------------------");
                }
        );
        //Inicializo los DAOS con el session factory referenciado y creado a ellos
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        PeliculaDAO peliculaDAO=new PeliculaDAO(sessionFactory);
        OpinionDAO opinionDAO=new OpinionDAO(sessionFactory);

        //1. Agregar nuevas peliculas
        Pelicula p=new Pelicula("Nueva Pelicula");
        Pelicula p2=new Pelicula("Nueva Pelicula2");
        peliculaDAO.insert(p);
        peliculaDAO.insert(p2);

        //Muestro las peliculas nuevamente
        System.out.println("Todas las peliculas actualmente:");
        List<Pelicula> estrellas = peliculaDAO.findAll();
        estrellas.forEach(System.out::println);

        //2.Obtener opniones de un usuario especifico
        //No me dio tiempo pero el metodo esta hecho y los siguientes los metodos de la interfaz estan hechos

    }
}