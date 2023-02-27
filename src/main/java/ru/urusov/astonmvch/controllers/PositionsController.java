package ru.urusov.astonmvch.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.urusov.astonmvch.model.dto.PositionDto;
import ru.urusov.astonmvch.services.PositionsService;

@Controller
@RequestMapping("/v1/positions")
public class PositionsController {

    @Autowired
    private final PositionsService positionsService;

    public PositionsController(PositionsService positionsService) {
        this.positionsService = positionsService;
    }

    @GetMapping()
    public String getAllPositions(Model model){
        model.addAttribute("positionsDto", positionsService.getAllPositions());
        return "positions/all";
    }

    @GetMapping("/{id}")
    public String getPositionById(Model model, @PathVariable("id") long id){
        model.addAttribute("response", positionsService.getByIdWithEmployees(id));
        return "positions/position";
    }
    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") long id){
        model.addAttribute("positionDto", positionsService.getByIdWithoutEmployees(id));
        return "positions/edit";
    }

    @PatchMapping("/{id}")
    public String updatePositionById(@ModelAttribute("positionDto")PositionDto positionDto){
        positionsService.updatePositionById(positionDto);
        return "redirect:/v1/positions";
    }

    @DeleteMapping("/{id}")
    public void deletePotionById(@PathVariable("id") long id){
        positionsService.deleteById(id);
    }

    @PostMapping()
    public void creatNewPosition(@ModelAttribute("positionDto") PositionDto positionDto){
        positionsService.savePosition(positionDto);
    }
}
