package ru.urusov.astonmvch.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import ru.urusov.astonmvch.dao.ProjectsDao;
import ru.urusov.astonmvch.model.dto.ProjectDto;
import ru.urusov.astonmvch.model.entities.Employee;
import ru.urusov.astonmvch.model.entities.Project;

import java.util.List;

@Repository
public class ProjectsDaoImpl implements ProjectsDao {

    private final SessionFactory sessionFactory;

    public ProjectsDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Project> getAllProjects() {
        Session session = getCurrentSession();
        Query<Project> projectQuery = session.createQuery("select p from Project p ", Project.class);
        return projectQuery.getResultList();
    }

    @Override
    public Project getProjectById(Long id) {
        return getCurrentSession().get(Project.class, id);
    }

    @Override
    public Long saveProject(Project project) {
        getCurrentSession().persist(project);
        return null;
    }

    @Override
    public void deleteProjectById(Long id) {
        Session session = getCurrentSession();
        Project project = session.get(Project.class, id);
        session.remove(project);
    }

    @Override
    public void updateProjectById(ProjectDto projectDto) {
        Session session = getCurrentSession();
        Project project = session.get(Project.class, projectDto.getId());
        project.setName(projectDto.getName());
    }

    @Override
    public List<Employee> getAllEmployees() {
        Session session = getCurrentSession();
        Query<Employee> query = session.createQuery("SELECT e" +
                " FROM Employee e JOIN FETCH e.position", Employee.class);
        return query.list();
    }

    @Override
    public void deleteEmployeeOnProjectById(long employeeId, long projectId) {
        Session session = getCurrentSession();
        Project project = session.get(Project.class, projectId);
        Employee employee = session.get(Employee.class, employeeId);
        project.getEmployees().remove(employee);
        employee.getProjects().remove(project);
    }

    @Override
    public void addEmployeeToProject(long employeeId, long projectId) {
        Session session = getCurrentSession();
        Project project = session.get(Project.class, projectId);
        Employee employee = session.get(Employee.class, employeeId);
        project.getEmployees().add(employee);
        employee.getProjects().add(project);
    }

    private Session getCurrentSession(){
        return sessionFactory.getCurrentSession();
    }
}
