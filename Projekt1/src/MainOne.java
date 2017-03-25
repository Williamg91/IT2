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


        //Control cont = new Control(new GUI());

        final XYDataset dataset = lavdataSaet();

        JFreeChart chart = lavChart(dataset);
        ChartPanel panel = new ChartPanel(chart);

        JFrame ramme = new JFrame("grafpanel");
        ramme.add(panel);
        ramme.setVisible(true);
        ramme.setSize(700, 400);
        ramme.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        ramme.setLocation(200, 300);

    }

    private static JFreeChart lavChart(final XYDataset dataset) {
        JFreeChart chart = ChartFactory.createXYLineChart("Eksempel på chart",
                "Tids-aksens label", "y-aksens label", dataset, PlotOrientation.VERTICAL, true, true, false);
        return chart;


    }


    static XYDataset lavdataSaet() {

        final XYSeries temp = new XYSeries("Temperatur");
        for (int i = 0; i < 10; i++) {
            temp.add(5 + i,  sens.simulateMeasurement());
        }
        final XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(temp);
        return dataset;
    }

    static void setupFrame() {
        JFrame ramme = new JFrame("grafpanel");
        //ramme.add(panel);
        ramme.setVisible(true);
        ramme.setSize(700, 400);
        ramme.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        ramme.setLocation(200, 300);


    }


}
