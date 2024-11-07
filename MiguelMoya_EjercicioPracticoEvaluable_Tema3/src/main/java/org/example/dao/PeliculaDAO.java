package org.example.dao;

import org.example.models.Opinion;
import org.example.models.Pelicula;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.List;

public class PeliculaDAO implements DAO<Pelicula>{
    private SessionFactory sF;

    public PeliculaDAO(SessionFactory sF) {
        this.sF = sF;
    }

    @Override
    public List<Pelicula> findAll() {
        try (Session session = sF.openSession()) {
            return session.createQuery("SELECT p FROM Pelicula p", Pelicula.class).list();
        } catch (Exception e) {
            return new ArrayList<Pelicula>(0);
        }
    }

    @Override
    public Pelicula findByID(Long id) {
        try (Session session = sF.openSession()) {
            return session.get(Pelicula.class, id);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public void insert(Pelicula pelicula) {
        sF.inTransaction( session -> session.persist(pelicula));
    }

    @Override
    public void delete(Pelicula pelicula) {
        sF.inTransaction( session -> session.remove(pelicula));
    }

    @Override
    public void update(Pelicula pelicula) {
        sF.inTransaction( session -> session.merge(pelicula));
    }


}
