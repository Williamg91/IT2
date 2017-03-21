import java.text.DecimalFormat;
import java.util.Random;

/**
 * Created by William on 10-03-2017.
 */
public class SensorMaster implements Measurements {


    @Override
    public double simulateMeasurement() {
        double res;
        Random r = new Random();
        res = 36.5 + (38.2 - 36.5) * r.nextDouble();
        System.out.println("Målt temp:" + res);
        DecimalFormat df = new DecimalFormat("##.##");
        String re = df.format(res).replace(",",".");
        res = Double.parseDouble(re);

        return res;
    }
}
