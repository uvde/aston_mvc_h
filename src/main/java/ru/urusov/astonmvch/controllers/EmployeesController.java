package ru.urusov.astonmvch.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.urusov.astonmvch.model.dto.EmployeeDto;
import ru.urusov.astonmvch.model.dto.GetAllEmployeesDtoResponse;
import ru.urusov.astonmvch.services.EmployeesService;
import ru.urusov.astonmvch.services.PositionsService;


@Controller
@RequestMapping("/v1/employees")
public class EmployeesController {

    @Autowired
    private final EmployeesService employeesService;
    private final PositionsService positionsService;

    public EmployeesController(EmployeesService employeesService, PositionsService positionsService) {
        this.employeesService = employeesService;
        this.positionsService = positionsService;
    }

    @GetMapping()
    public String getAllEmployees(Model model){
        model.addAttribute("response",
                new GetAllEmployeesDtoResponse(employeesService.getAllEmployees(),
                        positionsService.getAllPositions()) );
        model.addAttribute("employeeDto", new EmployeeDto());
        return "employees/all";
    }

    @GetMapping("/{id}")
    public String getById(Model model, @PathVariable("id") long id){
        model.addAttribute("employee", employeesService.getById(id));
        return "employees/employee";
    }

    @PostMapping()
    public String creatNewEmployee(@ModelAttribute("employeeDto") EmployeeDto employeeDto){
        employeesService.saveEmployee(employeeDto);
        return "redirect:/v1/employees";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") long id){
        EmployeeDto employeeDto = employeesService.getById(id);
        model.addAttribute("employee", employeeDto);
        return "employees/edit";
    }

    @PatchMapping("/{id}")
    public String updateEmployeeById(@ModelAttribute("employee") EmployeeDto employeeDto){
        employeesService.updateEmployeeById(employeeDto);
        return "redirect:/v1/employees";
    }

    @DeleteMapping("/{id}")
    public String deleteEmployeeById(@PathVariable("id") long id){
        employeesService.deleteById(id);
        return "redirect:/v1/employees";
    }
}
