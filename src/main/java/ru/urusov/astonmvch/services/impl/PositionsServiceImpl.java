package ru.urusov.astonmvch.services.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.urusov.astonmvch.dao.PositionsDao;
import ru.urusov.astonmvch.model.dto.PositionDto;
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
    public PositionDto getById(Long id) {
        return null;
    }

    @Override
    public Long savePosition(PositionDto positionDto) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public void updatePositionById(PositionDto positionDto) {

    }
}
