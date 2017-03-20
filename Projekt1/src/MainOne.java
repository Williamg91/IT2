import javax.swing.*;

/**
 * Created by William on 08-03-2017.
 */
public class MainOne {

    public static void main(String[] args){
//laver ramme som jeg fylder med et Panel.

        setupFrame();
        SensorMaster sens = new SensorMaster();
        sens.simulateMeasurement();

    }
    static void setupFrame(){
       Fyforden ramme = new Fyforden();

       /*ramme.setSize(500,600);

       ramme.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
       ramme.setVisible(true);

        ramme.add(new Fyforden());
    */
    }
}
