package com.seat.mower.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Position {
    private int x;
    private int y;
    private Direction direction;
}
