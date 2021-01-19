package ee.taltech.testing.courseproject.services;

import java.text.DecimalFormat;

public class CoordinateService {

    public String getCoordinatesAsString(double inputLongitude, double inputLatitude) {
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        return decimalFormat.format(inputLatitude) + ", " + decimalFormat.format(inputLongitude);
    }
}
