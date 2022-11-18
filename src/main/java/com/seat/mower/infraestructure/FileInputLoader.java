package com.seat.mower.infraestructure;

import org.apache.commons.lang3.StringUtils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.nio.file.Files.notExists;
import static org.apache.commons.lang3.math.NumberUtils.isCreatable;

public class FileInputLoader {
    private final String EXCEPTION_FILE_NOT_FOUND = "File not found";
    private final String INPUT_PATH = "scenario.txt";
    private final Path filePath;

    Pattern patternMovement = Pattern.compile("[LMR]");

    public FileInputLoader() throws FileNotFoundException {
        filePath = Path.of(INPUT_PATH);
        if(filePath==null
                || StringUtils.isEmpty(filePath.toString())
                || notExists(Path.of(""))) {
            throw new FileNotFoundException(EXCEPTION_FILE_NOT_FOUND);
        }
    }

    public String getDimensions() throws IOException {
        return Files.lines(filePath).findFirst().get();
    }

    public List<MowerInput> getMowerInputs() throws IOException {
        List<String> initialPositions = Files.lines(filePath)
                .skip(1)
                .filter(l -> isCreatable(l.substring(0, 1)))
                .collect(Collectors.toList());

        List<String> movements = Files.lines(filePath)
                .skip(1)
                .filter(l ->
                    patternMovement.matcher(l.substring(0, 1)).matches()
                ).collect(Collectors.toList());

        return IntStream.range(0, initialPositions.size()).mapToObj(
                i -> MowerInput.builder()
                        .initialPosition(initialPositions.get(i))
                        .movements(movements.get(i)).build())
                .collect(Collectors.toList());
    }
}