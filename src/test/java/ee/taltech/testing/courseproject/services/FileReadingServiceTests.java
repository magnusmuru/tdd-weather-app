package ee.taltech.testing.courseproject.services;

import ee.taltech.testing.courseproject.configuration.Configuration;
import ee.taltech.testing.courseproject.exceptions.InvalidInputPathException;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.slf4j.Logger;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class FileReadingServiceTests {

    @Test
    public void fileReaderCanFindRightInputFileAndItsContents() throws InvalidInputPathException, IOException {
        List<String> expectedList = new ArrayList<>();
        expectedList.add("Tallinn");

        FileReadingService fileReadingService = new FileReadingService();

        List<String> inputCities = fileReadingService.getInputFileContents();

        assertEquals(expectedList, inputCities);
    }
}
