import java.util.Random;

/**
 * Created by William on 10-03-2017.
 */
public class SensorMaster implements Measurements {
//Superklasse til hhv. EKG sensor og temperatursensor

    @Override
    public double simulateMeasurement() {
    double res;
    Random r = new Random();
        res = 36+(38.2-36)*r.nextDouble();
        System.out.println("Målt temp:" + res);
    return res;
    }
}
