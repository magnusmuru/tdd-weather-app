package ee.taltech.testing.courseproject.services;

import ee.taltech.testing.courseproject.configuration.Configuration;
import ee.taltech.testing.courseproject.exceptions.InvalidInputPathException;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class FileReadingWritingServiceTests {

    @Test
    public void fileReaderCanFindRightInputFileAndItsContents() throws InvalidInputPathException, IOException {
        FileWriter writer;
        Configuration configuration = new Configuration();
        writer = new FileWriter(configuration.getWorkingFile());
        writer.write("Tallinn");
        writer.close();

        FileReadWriteService testService = new FileReadWriteService();
        List<String> expectedList = new ArrayList<>();
        expectedList.add("Tallinn");

        List<String> inputCities = testService.getInputFileContents();

        assertEquals(expectedList, inputCities);
    }

    @Test
    public void fileWriterCanOutputReportContent() {
        FileReadWriteService testService = new FileReadWriteService();

        String expectedCity = "Tallinn";

        Configuration configuration = new Configuration();

        testService.writeWeatherReport(expectedCity);

        Path path = Paths.get(configuration.getWorkingPath() + expectedCity.toLowerCase() + ".json");

        assert(path.toFile().isFile());
    }
}
