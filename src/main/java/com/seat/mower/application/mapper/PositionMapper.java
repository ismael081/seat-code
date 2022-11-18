package com.seat.mower.application.mapper;

import org.apache.commons.lang3.StringUtils;
import com.seat.mower.domain.Direction;
import com.seat.mower.domain.Position;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PositionMapper {
    public static Position toDomain(String positionInput) {
        if(StringUtils.isEmpty(positionInput)) {
            return Position.builder().build();
        }

        List<String> positionPieces = Arrays.stream(positionInput.split(" "))
                .map(String::trim)
                .collect(Collectors.toList());

        return Position.builder()
                .x(Integer.parseInt(positionPieces.get(0)))
                .y(Integer.parseInt(positionPieces.get(1)))
                .direction(Direction.valueOf(positionPieces.get(2)))
                .build();
    }
}
