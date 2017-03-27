import javax.swing.*;

import org.jfree.chart.*;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.*;
import org.jfree.data.general.Dataset;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.*;

/**
 * Created by William on 08-03-2017.
 */
public class MainOne {

    static SensorMaster sens = new SensorMaster();

    public static void main(String[] args) {
//laver ramme som jeg fylder med et Panel.


        Control cont = new Control(new GUI());




    }
/*
    private static JFreeChart lavChart(final XYDataset dataset) {
        //Simpel metode til at lave en Chart
        JFreeChart chart = ChartFactory.createXYLineChart("Eksempel på chart",
                "Tids-aksens label", "y-aksens label", dataset, PlotOrientation.VERTICAL, true, true, false);
        return chart;


    }
*/
/*
    static XYDataset lavdataSaet() {

        final XYSeries temp = new XYSeries("Temperatur");
        //Lav bare en samling XY-data.
        for (int i = 0; i < 10; i++) {
            //Gør dette 10 gange
            temp.add(5 + i,  sens.simulateMeasurement());
            //Til vores samling kaldet temp, tilføj (x-værdi, y-værdi) hvor y = et tilfældigt double.
        }
        final XYSeriesCollection dataset = new XYSeriesCollection();
        //Til vores samling med serier, kaldet dataset
        dataset.addSeries(temp);
        //Tilføj serien "temp"
        return dataset;
    }*/
/*
    static void setupFrame() {
        JFrame ramme = new JFrame("grafpanel");
        //ramme.add(panel);
        ramme.setVisible(true);
        ramme.setSize(700, 400);
        ramme.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        ramme.setLocation(200, 300);


    }
*/

}
