package ru.urusov.astonmvch.services;

import ru.urusov.astonmvch.model.dto.GetPositionByIdResponse;
import ru.urusov.astonmvch.model.dto.PositionDto;

import java.util.List;

public interface PositionsService {

    List<PositionDto> getAllPositions();
    GetPositionByIdResponse getByIdWithEmployees(Long id);
    PositionDto getByIdWithoutEmployees(Long id);
    void savePosition(PositionDto positionDto);
    void deleteById(Long id);
    void updatePositionById(PositionDto positionDto);
}
