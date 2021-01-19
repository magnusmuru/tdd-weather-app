package ee.taltech.testing.courseproject.Model;

import ee.taltech.testing.courseproject.Model.Coordinate;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CoordinateValidationTest {

    @Test
    public void shouldReturnValidCoordinateFormat() {
        String expectedCoordinates = "59.44, 24.75";
        double inputLongitude = 24.7535;
        double inputLatitude = 59.437;

        Coordinate coordinate = new Coordinate();

        String resultCoordinates = coordinate.getCoordinatesAsString(inputLongitude, inputLatitude);

        assertEquals(expectedCoordinates, resultCoordinates);
    }
}
