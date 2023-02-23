package ru.urusov.astonmvch.dao.impl;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
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
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Employee> cq = cb.createQuery(Employee.class);
        Root< Employee > root = cq.from(Employee.class);
        cq.select(root);
        Query<Employee> query = session.createQuery(cq);
        return query.getResultList();
    }

    @Override
    public Employee getById(Long id) {
        return null;
    }

    @Override
    public Long saveEmployee(Employee employee) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public void updateEmployeeById(Employee employee) {}
}
