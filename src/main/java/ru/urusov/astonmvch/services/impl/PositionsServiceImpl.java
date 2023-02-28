package ru.urusov.astonmvch.services.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.urusov.astonmvch.dao.PositionsDao;
import ru.urusov.astonmvch.model.dto.GetPositionByIdResponse;
import ru.urusov.astonmvch.model.dto.PositionDto;
import ru.urusov.astonmvch.model.entities.Position;
import ru.urusov.astonmvch.services.PositionsService;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class PositionsServiceImpl implements PositionsService {

    private final PositionsDao positionsDao;

    public PositionsServiceImpl(PositionsDao positionsDao) {
        this.positionsDao = positionsDao;
    }

    @Override
    @Transactional(readOnly = true)
    public List<PositionDto> getAllPositions() {
        List<PositionDto> positionDtoList = new ArrayList<>();
        positionsDao.getAllPositions()
                .forEach(position -> positionDtoList
                        .add(new PositionDto(position.getId()
                                ,position.getName()
                                ,position.getSalary())));
        return positionDtoList;
    }

    @Override
    @Transactional(readOnly = true)
    public GetPositionByIdResponse getByIdWithEmployees(Long id) {
        Position position = positionsDao.getById(id);
        return new GetPositionByIdResponse(position.getId(),
                position.getName(), position.getSalary(), position.getEmployees());
    }

    @Override
    @Transactional(readOnly = true)
    public PositionDto getByIdWithoutEmployees(Long id) {
        Position position = positionsDao.getById(id);
        return new PositionDto(position.getId(), position.getName(), position.getSalary());
    }

    @Override
    @Transactional
    public void savePosition(PositionDto positionDto) {
        Position position = new Position(positionDto.getId(), positionDto.getName(), positionDto.getSalary());
        positionsDao.savePosition(position);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        positionsDao.deleteById(id);
    }

    @Override
    @Transactional
    public void updatePositionById(PositionDto positionDto) {
        Position position = new Position();
        position.setId(positionDto.getId());
        position.setName(positionDto.getName());
        position.setSalary(positionDto.getSalary());
        positionsDao.updatePositionById(position);
    }
}
