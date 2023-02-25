package ru.urusov.astonmvch.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import ru.urusov.astonmvch.dao.EmployeesDao;
import ru.urusov.astonmvch.model.entities.Employee;

import java.util.List;

@Repository
public class EmployeesDaoImpl implements EmployeesDao {

    private final SessionFactory sessionFactory;

    public EmployeesDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Employee> getAllEmployees() {
        Session session = sessionFactory.getCurrentSession();
        Query<Employee> query = session.createQuery("SELECT e FROM Employee e", Employee.class);

        return query.list();
    }

    @Override
    public Employee getById(Long id) {
        Session currentSession = sessionFactory.getCurrentSession();
        return currentSession.get(Employee.class, id);
    }

    @Override
    public Long saveEmployee(Employee employee) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.persist(employee);
        return null;
    }

    @Override
    public void deleteById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Employee book = session.byId(Employee.class).load(id);
        session.remove(book);
    }

    @Override
    public void updateEmployeeById(Employee employee) {
        Session session = sessionFactory.getCurrentSession();
        session.merge(employee);
    }
}
