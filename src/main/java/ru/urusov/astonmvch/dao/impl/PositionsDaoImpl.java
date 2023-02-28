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
        Query<Position> query = session.createQuery("SELECT p FROM Position p", Position.class);
        return query.getResultList();
    }

    @Override
    public Position getById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Position.class, id);
    }

    @Override
    public void savePosition(Position position) {
        getCurrentSession().persist(position);
    }

    @Override
    public void deleteById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Position position = session.byId(Position.class).load(id);
        session.remove(position);
    }

    @Override
    public void updatePositionById(Position position) {
        getCurrentSession().merge(position);
    }

    private Session getCurrentSession(){
        return sessionFactory.getCurrentSession();
    }
}
