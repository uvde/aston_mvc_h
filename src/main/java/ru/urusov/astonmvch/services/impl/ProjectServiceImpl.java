package ru.urusov.astonmvch.services.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.urusov.astonmvch.dao.ProjectsDao;
import ru.urusov.astonmvch.model.dto.EmployeeDto;
import ru.urusov.astonmvch.model.dto.GetProjectByIdDto;
import ru.urusov.astonmvch.model.dto.ProjectDto;
import ru.urusov.astonmvch.model.entities.Project;
import ru.urusov.astonmvch.services.ProjectsService;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectsService {

    private final ProjectsDao projectsDao;

    public ProjectServiceImpl(ProjectsDao projectsDao) {
        this.projectsDao = projectsDao;
    }

    @Override
    @Transactional(readOnly = true)
    public List<ProjectDto> getAllProjects() {
        List<Project> projects = projectsDao.getAllProjects();
        List<ProjectDto> projectDtoList = new ArrayList<>();
        projects.forEach(project -> projectDtoList
                .add(new ProjectDto(project.getId()
                        , project.getName())));
        return projectDtoList;
    }

    @Override
    @Transactional(readOnly = true)
    public ProjectDto getProjectById(Long id) {
        Project project = projectsDao.getProjectById(id);
        return new ProjectDto(project.getId(), project.getName());
    }

    @Override
    @Transactional
    public Long saveProject(ProjectDto projectDto) {
        projectsDao.saveProject(new Project(projectDto.getName()));
        return null;
    }

    @Override
    @Transactional
    public void deleteProjectById(Long id) {
        projectsDao.deleteProjectById(id);
    }

    @Override
    @Transactional
    public void updateProjectById(ProjectDto projectDto) {
        projectsDao.updateProjectById(projectDto);
    }

    @Override
    @Transactional(readOnly = true)
    public GetProjectByIdDto getProjectWithEmployees(long id) {
        Project project = projectsDao.getProjectById(id);
        List<EmployeeDto> employeeDtoList = new ArrayList<>();
        project.getEmployees().forEach(e -> employeeDtoList.add(new EmployeeDto(e.getId(), e.getName(),
                e.getBirthday(), e.getCity(), e.getPosition().getSalary(), e.getPosition().getName(), e.getPosition().getId())));
        GetProjectByIdDto projectDto = new GetProjectByIdDto();
        projectDto.setId(project.getId());
        projectDto.setProjectName(project.getName());
        projectDto.setEmployeeDtoList(employeeDtoList);
        return projectDto;
    }

    @Override
    @Transactional
    public void deleteEmployeeOnProjectById(long employeeId, long projectId) {
        projectsDao.deleteEmployeeOnProjectById(employeeId, projectId);
    }

    @Override
    @Transactional(readOnly = true)
    public GetProjectByIdDto getEmployeesOnAnotherProject(long id) {
        List<EmployeeDto> employeeDtoList = new ArrayList<>();
        projectsDao.getAllEmployees().forEach(e -> employeeDtoList.add(new EmployeeDto(e.getId(), e.getName(),
                e.getBirthday(), e.getCity(), e.getPosition().getSalary(), e.getPosition().getName(), e.getPosition().getId())));
        Project project = projectsDao.getProjectById(id);
        project.getEmployees().forEach(e -> employeeDtoList.remove(new EmployeeDto(e.getId(), e.getName(),
                e.getBirthday(), e.getCity(), e.getPosition().getSalary(), e.getPosition().getName(), e.getPosition().getId())));
        GetProjectByIdDto projectByIdDto = new GetProjectByIdDto(project.getId(),project.getName(), employeeDtoList);
        return projectByIdDto;
    }

    @Override
    @Transactional
    public void addEmployeeToProject(long employeeId, long projectId) {
        projectsDao.addEmployeeToProject(employeeId, projectId);
    }
}
