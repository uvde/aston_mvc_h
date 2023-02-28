package ru.urusov.astonmvch.services;

import ru.urusov.astonmvch.model.dto.GetProjectByIdDto;
import ru.urusov.astonmvch.model.dto.ProjectDto;

import java.util.List;

public interface ProjectsService {
    List<ProjectDto> getAllProjects();
    ProjectDto getProjectById(Long id);
    Long saveProject(ProjectDto projectDto);
    void deleteProjectById(Long id);
    void updateProjectById(ProjectDto projectDto);
    GetProjectByIdDto getProjectWithEmployees(long id);
    void deleteEmployeeOnProjectById(long employeeId, long projectId);
    GetProjectByIdDto getEmployeesOnAnotherProject(long id);
    void addEmployeeToProject(long employeeId, long projectId);
}
