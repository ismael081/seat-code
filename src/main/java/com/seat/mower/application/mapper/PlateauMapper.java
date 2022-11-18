package com.seat.mower.application.mapper;

import org.apache.commons.lang3.StringUtils;
import com.seat.mower.domain.Plateau;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PlateauMapper {
    public static Plateau toDomain(String maxDimensions) {
        if(StringUtils.isEmpty(maxDimensions)) {
            return Plateau.builder().build();
        }

        List<String> dimensionsPieces = Arrays.stream(maxDimensions.split(" "))
                .map(String::trim)
                .map(String::toUpperCase)
                .collect(Collectors.toList());

        if(dimensionsPieces.size()!=2) {
            throw new IllegalArgumentException("Dimensions for the plateau not properly set");
        }

        return Plateau.builder()
                .maxX(Integer.valueOf(dimensionsPieces.get(0)))
                .maxY(Integer.valueOf(dimensionsPieces.get(1)))
                .build();
    }
}
