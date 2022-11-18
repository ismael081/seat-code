package com.seat.mower.domain;

import java.util.HashMap;

public class Rotation {
    public static HashMap<Direction, Direction> right = new HashMap<Direction, Direction>(){{
        put(Direction.N, Direction.E);
        put(Direction.E, Direction.S);
        put(Direction.S, Direction.W);
        put(Direction.W, Direction.N);
    }};

    public static HashMap<Direction, Direction> left = new HashMap<Direction, Direction>(){{
        put(Direction.N, Direction.W);
        put(Direction.W, Direction.S);
        put(Direction.S, Direction.E);
        put(Direction.E, Direction.N);
    }};
}
