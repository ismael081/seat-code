package com.seat;

import com.seat.mower.application.MowerController;
import com.seat.mower.domain.Mower;
import com.seat.mower.infraestructure.FileInputLoader;
import com.seat.mower.application.MovementService;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        MovementService movementService = new MovementService();
        FileInputLoader fileInputLoader = new FileInputLoader();
        MowerController mowerController = new MowerController(movementService, fileInputLoader);

        List<Mower> mowers = mowerController.runMowers();
        mowers.forEach(mower -> System.out.println(mower.toString()));
    }
}