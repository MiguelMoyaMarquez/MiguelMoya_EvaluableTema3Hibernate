package org.example.dao;

import org.example.models.Opinion;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.List;

public class OpinionDAO implements DAO<Opinion>{
    private SessionFactory sF;

    public OpinionDAO(SessionFactory sF) {
        this.sF = sF;
    }

    @Override
    public List<Opinion> findAll() {
        try (Session session = sF.openSession()) {
            return session.createQuery("SELECT o FROM Opinion o", Opinion.class).list();
        } catch (Exception e) {
            return new ArrayList<Opinion>(0);
        }
    }

    @Override
    public Opinion findByID(Long id) {
        try (Session session = sF.openSession()) {
            return session.get(Opinion.class, id);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public void insert(Opinion opinion) {
        sF.inTransaction( session -> session.persist(opinion));
    }

    @Override
    public void delete(Opinion opinion) {
        sF.inTransaction( session -> session.remove(opinion));
    }

    @Override
    public void update(Opinion opinion) {
        sF.inTransaction( session -> session.merge(opinion));
    }

    public List<Opinion> mostrarOpnionDeUsuario(String usuario){
        try (Session session = sF.openSession()) {
            return session.createQuery("SELECT o FROM Opinion o WHERE o.usuario = :usuario", Opinion.class).list();
        } catch (Exception e) {
            return new ArrayList<Opinion>(0);
        }
    }


}
