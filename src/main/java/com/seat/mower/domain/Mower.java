package com.seat.mower.domain;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
public class Mower {
    private final Position position;
    private final List<Action> actions;

    @Override
    public String toString() {
        return String.format("%s %s %s", position.getX(), position.getY(), position.getDirection());
    }
}
