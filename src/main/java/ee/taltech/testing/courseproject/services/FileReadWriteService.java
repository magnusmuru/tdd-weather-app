package ee.taltech.testing.courseproject.services;

import ee.taltech.testing.courseproject.configuration.Configuration;
import ee.taltech.testing.courseproject.exceptions.InvalidInputPathException;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Service
public class FileReadWriteService {

    private final Configuration configuration = new Configuration();

    public List<String> getInputFileContents() throws InvalidInputPathException, IOException {
        if (!configuration.getWorkingFile().endsWith(".txt")) {
            String errorMessage = "Invalid input format, please use input.txt";
            throw new InvalidInputPathException(errorMessage);
        }
        Path path = Paths.get(configuration.getWorkingFile());

        if (path.toFile().isFile()) {
            return Files.readAllLines(path, StandardCharsets.UTF_8);
        } else {
            throw new InvalidInputPathException("File not present, please add input.txt to input folder");
        }
    }

    public void writeWeatherReport() {
    }
}