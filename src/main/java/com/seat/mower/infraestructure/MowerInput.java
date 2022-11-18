package com.seat.mower.infraestructure;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Builder
@Getter
@EqualsAndHashCode
public class MowerInput {
    private final String initialPosition;
    private final String movements;
}
