package com.seat.mower.application;

import com.seat.mower.application.mapper.PlateauMapper;
import com.seat.mower.domain.Mower;
import com.seat.mower.domain.Plateau;
import com.seat.mower.infraestructure.FileInputLoader;
import lombok.AllArgsConstructor;
import com.seat.mower.application.mapper.MowerMapper;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
public class MowerController {
    private MovementService movementService;
    private FileInputLoader fileInputLoader;

    public List<Mower> runMowers() throws IOException {
        List<Mower> mowers = fileInputLoader.getMowerInputs().stream()
                .map(MowerMapper::toDomain)
                .collect(Collectors.toList());

        Plateau plateau = PlateauMapper.toDomain(fileInputLoader.getDimensions());

        mowers.forEach(mower -> movementService.doMovements(plateau, mowers, mower));

        return mowers;
    }
}