package ee.taltech.testing.courseproject.services;

import ee.taltech.testing.courseproject.API.WeatherAPI;
import ee.taltech.testing.courseproject.configuration.Configuration;
import ee.taltech.testing.courseproject.exceptions.InvalidInputPathException;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.assertj.core.api.Assertions.assertThat;

public class FileReadingWritingServiceTests {

    private static FileReadWriteService fileReadWriteService;

    @BeforeAll
    public static void setUp() {
        fileReadWriteService = new FileReadWriteService();
    }

    @Test
    public void fileReaderCanFindRightInputFileAndItsContents() throws InvalidInputPathException, IOException {
        List<String> expectedList = new ArrayList<>();
        expectedList.add("Tallinn");

        List<String> inputCities = fileReadWriteService.getInputFileContents();

        assertEquals(expectedList, inputCities);
    }

    @Test
    public void fileWriterCanOutputReportContent() {
        String expectedCity = "Tallinn";

        Configuration configuration = new Configuration();

        fileReadWriteService.writeWeatherReport();

        Path path = Paths.get(configuration.getWorkingPath() + expectedCity.toLowerCase() + ".json");

        assert(path.toFile().isFile());
    }
}
