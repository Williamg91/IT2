import javax.swing.*;

/**
 * Created by William on 08-03-2017.
 */
public class MainOne {


    public static void main(String[] args) {
//laver ramme som jeg fylder med et Panel.

        setupFrame();
        SensorMaster sens = new SensorMaster();
        sens.simulateMeasurement();

    }

    static void setupFrame() {
       // GUI ramme = new GUI();
        Control cont = new Control(new GUI());


    }


}
