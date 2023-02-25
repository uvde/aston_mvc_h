package ru.urusov.astonmvch.services;

import ru.urusov.astonmvch.model.dto.PositionDto;

import java.util.List;

public interface PositionsService {

    List<PositionDto> getAllPositions();
    PositionDto getById(Long id);
    Long savePosition(PositionDto positionDto);
    void deleteById(Long id);
    void updatePositionById(PositionDto positionDto);
}
