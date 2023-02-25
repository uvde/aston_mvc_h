package ru.urusov.astonmvch.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
}
