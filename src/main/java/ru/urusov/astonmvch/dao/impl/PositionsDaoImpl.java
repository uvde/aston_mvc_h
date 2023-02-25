package ru.urusov.astonmvch.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import ru.urusov.astonmvch.dao.PositionsDao;
import ru.urusov.astonmvch.model.entities.Position;

import java.util.List;

@Repository
public class PositionsDaoImpl implements PositionsDao {

    private final SessionFactory sessionFactory;

    public PositionsDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Position> getAllPositions() {
        Session session = sessionFactory.getCurrentSession();
        Query<Position> query = session.createQuery("FROM Position", Position.class);
        return query.getResultList();
    }

    @Override
    public Position getById(Long id) {
        return null;
    }

    @Override
    public Long savePosition(Position position) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public void updatePositionById(Position position) {

    }

    private Session getCurrentSession(){
        return sessionFactory.getCurrentSession();
    }
}
