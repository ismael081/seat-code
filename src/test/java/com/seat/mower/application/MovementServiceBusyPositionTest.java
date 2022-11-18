package com.seat.mower.application;

import com.seat.mower.domain.*;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MovementServiceBusyPositionTest {
    private final Plateau plateau = Plateau.builder().maxX(5).maxY(5).build();
    private final MovementService movementService = new MovementService();
    private final List<Mower> blockingMowers = Arrays.asList(
            Mower.builder().position(Position.builder().x(1).y(0).build()).build(),
            Mower.builder().position(Position.builder().x(0).y(1).build()).build(),
            Mower.builder().position(Position.builder().x(1).y(2).build()).build(),
            Mower.builder().position(Position.builder().x(2).y(1).build()).build()
    );

    @Test
    public void checkPositionsOfOtherMowersForAllDirections() {
        Arrays.stream(Direction.values()).forEach(direction -> {
            Mower blockedMower = createBlockedMower(direction);
            movementService.move(plateau,
                    blockedMower.getPosition(),
                    blockedMower.getActions().get(0),
                    blockingMowers);
            validateBlockedMower(blockedMower);
        });
    }

    private Mower createBlockedMower(Direction direction) {
        Position position = Position.builder()
                .x(1).y(1)
                .direction(direction)
                .build();
        return Mower.builder()
                .position(position)
                .actions(Arrays.asList(Action.M))
                .build();
    }

    private void validateBlockedMower(Mower blockedMower) {
        assertEquals(1, blockedMower.getPosition().getX());
        assertEquals(1, blockedMower.getPosition().getY());
    }
}