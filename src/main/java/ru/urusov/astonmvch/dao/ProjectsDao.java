package ru.urusov.astonmvch.dao;

import ru.urusov.astonmvch.model.dto.ProjectDto;
import ru.urusov.astonmvch.model.entities.Employee;
import ru.urusov.astonmvch.model.entities.Project;

import java.util.List;

public interface ProjectsDao {

    List<Project> getAllProjects();
    Project getProjectById(Long id);
    Long saveProject(Project project);
    void deleteProjectById(Long id);
    void updateProjectById(ProjectDto projectDto);
    List<Employee> getAllEmployees();
    void deleteEmployeeOnProjectById(long employeeId, long projectId);
    void addEmployeeToProject(long employeeId, long projectId);
}
