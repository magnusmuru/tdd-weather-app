package ee.taltech.testing.courseproject.Model;

import java.text.DecimalFormat;

public class Coordinate {

    public String getCoordinatesAsString(double inputLongitude, double inputLatitude) {
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        return decimalFormat.format(inputLatitude) + ", " + decimalFormat.format(inputLongitude);
    }
}
