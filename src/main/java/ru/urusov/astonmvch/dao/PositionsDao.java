package ru.urusov.astonmvch.dao;

import ru.urusov.astonmvch.model.entities.Employee;
import ru.urusov.astonmvch.model.entities.Position;

import java.util.List;

public interface PositionsDao {

    List<Position> getAllPositions();
    Position getById(Long id);
    void savePosition(Position position);
    void deleteById(Long id);
    void updatePositionById(Position position);
}
