package com.seat.mower.domain;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Plateau {
    private final int maxX;
    private final int maxY;
}
