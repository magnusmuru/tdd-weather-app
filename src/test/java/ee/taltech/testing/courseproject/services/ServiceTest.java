package ee.taltech.testing.courseproject.services;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ServiceTest {

    @Test
    public void shouldReturnValidCoordinateFormat() {
        String expectedCoordinates = "59.44, 24.75";
        double inputLongitude = 24.7535;
        double inputLatitude = 59.437;

        CoordinateService coordinateService = new CoordinateService();

        String resultCoordinates = coordinateService.getCoordinatesAsString(inputLongitude, inputLatitude);

        assertEquals(expectedCoordinates, resultCoordinates);
    }
}
