package ru.urusov.astonmvch.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.urusov.astonmvch.model.dto.GetProjectByIdDto;
import ru.urusov.astonmvch.model.dto.ProjectDto;
import ru.urusov.astonmvch.services.ProjectsService;

@Controller
@RequestMapping("/v1/projects")
public class ProjectsController {

    private final ProjectsService projectsService;

    public ProjectsController(ProjectsService projectsService) {
        this.projectsService = projectsService;
    }

    @GetMapping()
    public String getAllProjects(Model model){
        model.addAttribute("projects", projectsService.getAllProjects());
        model.addAttribute("project", new ProjectDto());
        return "projects/all";
    }

    @PostMapping()
    public String creatNewProject(@ModelAttribute("project") ProjectDto project){
        projectsService.saveProject(project);
        return "redirect:/v1/projects";
    }

    @DeleteMapping("/{id}")
    public String deleteProjectById(@PathVariable("id") long id){
        projectsService.deleteProjectById(id);
        return "redirect:/v1/projects";
    }

    @DeleteMapping("/employees/{employeeId}/{projectId}")
    public String deleteEmployeeOnProjectById(@PathVariable("employeeId") long employeeId, @PathVariable("projectId") long projectId){
        projectsService.deleteEmployeeOnProjectById(employeeId, projectId);
        return "redirect:/v1/projects/" + projectId;
    }

    @PostMapping("/employees/{employeeId}/{projectId}")
    public String addEmployeeToProject(@PathVariable("employeeId") long employeeId, @PathVariable("projectId") long projectId){
        projectsService.addEmployeeToProject(employeeId, projectId);
        return "redirect:/v1/projects/employees/" + projectId;
    }

    @GetMapping("/employees/{id}")
    public String getEmployeesOnAnotherProject(@PathVariable("id") long id, Model model){
        model.addAttribute("project", projectsService.getEmployeesOnAnotherProject(id));
        return "projects/add";
    }

    @PatchMapping("/{id}")
    public String updateProjectById(@ModelAttribute("project") ProjectDto project){
        projectsService.updateProjectById(project);
        return "redirect:/v1/projects";
    }

    @GetMapping("/{id}")
    public String getProjectById(Model model, @PathVariable("id") long id){
        model.addAttribute("project", projectsService.getProjectWithEmployees(id));
        return "projects/project";
    }

    @GetMapping("/{id}/edit")
    public String editProject(Model model, @PathVariable("id") long id){
        model.addAttribute("project", projectsService.getProjectById(id));
        return "projects/edit";
    }

}
