package ee.taltech.testing.courseproject.services;

import org.junit.Test;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class FileReadingServiceTests {

    @Test
    public void fileReaderCanFindRightInputFileAndItsContents() {
        String inputPath = "D:\\Projects\\testing-course-project\\input";

        FileReadingService fileReadingService = new FileReadingService();

        List<String> expectedList = new ArrayList<>();
        expectedList.add("Tallinn");

        List<String> inputCities = fileReadingService.getInputFileContents();

        assertEquals(expectedList, inputCities);
    }
}
