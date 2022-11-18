package com.seat.mower.application.mapper;

import com.seat.mower.domain.Mower;
import com.seat.mower.infraestructure.MowerInput;
import org.apache.commons.lang3.StringUtils;
import com.seat.mower.domain.Action;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class MowerMapper {
    public static Mower toDomain(MowerInput mowerInput) {
        if(mowerInput == null){
            return Mower.builder().build();
        }
        return Mower.builder()
                .position(PositionMapper.toDomain(mowerInput.getInitialPosition()))
                .actions(toDomain(mowerInput.getMovements()))
                .build();
    }

    private static List<Action> toDomain(String movements) {
        if(StringUtils.isEmpty(movements)) {
            return Collections.emptyList();
        }
        return movements.toUpperCase()
                .chars()
                .mapToObj(m -> Action.valueOf(String.valueOf((char)m)))
                .collect(Collectors.toList());
    }
}
