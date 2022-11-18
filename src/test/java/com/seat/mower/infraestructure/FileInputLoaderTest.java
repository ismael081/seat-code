package com.seat.mower.infraestructure;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.nio.file.Files.writeString;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FileInputLoaderTest {
    private final String INPUT_PATH = "scenario.txt";
    private final String EMPTY_LINE = "" + System.lineSeparator();
    private final FileInputLoader fileInputLoader = new FileInputLoader();

    public FileInputLoaderTest() throws FileNotFoundException {
    }

    @Test
    void getDimensionsTest() throws IOException {
        String expected = "5 5";
        writeString(Path.of(INPUT_PATH), expected);

        assertEquals(expected, fileInputLoader.getDimensions());
    }

    @Test
    void loadMowerInputs() throws IOException {
        List<MowerInput> expectedMowerInputs = Stream.of(
                createMower("1 2 N","LRM"),
                createMower("3 4 N","MRL"))
                .collect(Collectors.toList());

        String inputData = expectedMowerInputs.stream()
                .map(this::toStringForFile)
                .reduce(EMPTY_LINE, (added, current) -> added + current);

        writeString(Path.of(INPUT_PATH), inputData);

        List<MowerInput> actualMowerInputs = fileInputLoader.getMowerInputs();

        assertEquals(expectedMowerInputs.size(), actualMowerInputs.size());
        IntStream.range(0, expectedMowerInputs.size())
                .forEach(i -> assertEquals(expectedMowerInputs.get(i), actualMowerInputs.get(i)));
    }

    private MowerInput createMower(String initialPosition, String movements) {
        return MowerInput.builder()
                .initialPosition(initialPosition)
                .movements(movements)
                .build();
    }
    private String toStringForFile(MowerInput mowerInput) {
        return mowerInput.getInitialPosition() + System.lineSeparator() +
                mowerInput.getMovements() + System.lineSeparator();
    }
}
