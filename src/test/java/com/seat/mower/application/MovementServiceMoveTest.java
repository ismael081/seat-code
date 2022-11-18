package com.seat.mower.application;

import com.seat.mower.domain.*;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MovementServiceMoveTest {
    private final MovementService movementService = new MovementService();
    private final Plateau plateau = Plateau.builder().maxX(5).maxY(5).build();

    List<Mower> blockingMowers = Collections.emptyList();

    @Test
    public void moveVerticalTest() {
        Position actualPosition = Position.builder()
                .x(0).y(0).direction(Direction.N).build();

        movementService.move(plateau, actualPosition, Action.M, blockingMowers);

        assertEquals(0, actualPosition.getX());
        assertEquals(1, actualPosition.getY());
    }

    @Test
    public void tryToMoveOutVerticalDownTest() {
        Position actualPosition = Position.builder()
                .x(0).y(0).direction(Direction.S).build();
        movementService.move(plateau, actualPosition, Action.M, blockingMowers);

        assertEquals(0, actualPosition.getX());
        assertEquals(0, actualPosition.getY());
    }

    @Test
    public void tryToMoveOutVerticalTopTest() {
        Position actualPosition = Position.builder()
                .x(5).y(5).direction(Direction.N).build();
        movementService.move(plateau, actualPosition, Action.M, blockingMowers);

        assertEquals(5, actualPosition.getX());
        assertEquals(5, actualPosition.getY());
    }

    @Test
    public void tryToMoveOutHorizontalWestTest() {
        Position actualPosition = Position.builder()
                .x(0).y(0).direction(Direction.W).build();
        movementService.move(plateau, actualPosition, Action.M, blockingMowers);

        assertEquals(0, actualPosition.getX());
        assertEquals(0, actualPosition.getY());
    }

    @Test
    public void tryToMoveOutHorizontalEastTest() {
        Position actualPosition = Position.builder()
                .x(5).y(5).direction(Direction.E).build();
        movementService.move(plateau, actualPosition, Action.M, blockingMowers);

        assertEquals(5, actualPosition.getX());
        assertEquals(5, actualPosition.getY());
    }
}
