import org.jfree.chart.*;

import org.jfree.chart.plot.*;
import org.jfree.data.xy.*;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

/**
 * Created by William on 10-03-2017.
 */
public class Control {

    Timer timer;
    SensorMaster sens = new SensorMaster();
    double temperaturmaaling = sens.simulateMeasurement();
    //DEnne her tilføjes automatisk når programmet køres.

    //Aha! Jeg erklærer et GUI objekt, men definerer det ikke før konstruktøren.
    GUI gui;

    //Disse variabler bruger jeg til JFreeChart plotting.

    final XYSeriesCollection dataset = new XYSeriesCollection();
    //SeriesCollection virker lidt som en ArrayList, men kan kun indeholde objekter af typen XYSeries, som den nedenunder.

    XYSeries tempSerie = new XYSeries("Temperatur");
    //Lav bare en samling XY-data.
    XYSeries pulsSerie = new XYSeries("Puls");
    XYDataset dataset;


    public Control(GUI gui) {
        //Her er det vigtigt at tænke på hvilken rækkefølge vi beder om tingene udført
        this.gui = gui;
        //Den GUI, jeg erklærede, men ikke definerede, fra start? Det er nu den, jeg får ind via DENNE konstruktør.
                togglePulseShow(false);
        //Når GUI vises, skal puls-funktionen så vises fra start? False
        tilfoejMouseListener();
        //Tilføj klikfunktion og toggle for checkboxen.

        setupTextfields();
        //opsætning for tekstfelter, så de fx. tømmes når jeg klikker på dem, eller parser når jeg trykker Enter.

        lavdataSaet();
        //Lav dataset, så jeg kan løbende fylde værdier ind i dem i baggrunden.
        controlTimer();

    }

    public Control() {
        //Konstruktør til kun at tilgå metoder, så den kan kaldes fra GUI.
        //Når denne konstruktør kaldes, gøres der ikke de ting, som angives i konstruktøren foroven.
    }


    private void controlTimer() {

        //hvad skal vi lave løbende? En alternativ måde at lave run() metode på, men denne her er nemmere at bruge til grafik.
        timer = new Timer(4000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                sens = new SensorMaster();
                temperaturmaaling = sens.simulateMeasurement();
                gui.nyesteT.setText(temperaturmaaling + "C");

                Random r = new Random();
                int maxpuls = 90;
                int minpuls = 85;
                int pulsRandom = r.nextInt((maxpuls - minpuls + 1) + minpuls);
                gui.nyesteP.setText((pulsRandom + "BPM"));
                //har fået Temperatursimulering til at fungere. Så for at illustrere hvad der kan gøres med en pulsmåling, gøres det samme her.

                //Der skal løbende tilføjes målinger til vores XY-serier kaldet temp og pulsserier.
                int taeller = 0;
                taeller++; //for hvert 4. sekund eller 4000 milisekunder, taeller vi op.

                tempSerie.add(taeller, temperaturmaaling);
                pulsSerie.add(taeller, pulsRandom);
                //Slut på hvad der gøres løbende.
            }
        });

        timer.setInitialDelay(0);
        if (!timer.isRunning()) {
            timer.start();
        }
    }

    public void tegnNuMinGraf() {

        //Tilføj serierne til vores dataset, dvs. XYseriesCollection

        JFreeChart chart = lavChart(dataset);
        ChartPanel panel = new ChartPanel(chart);
        JFrame ramme = new JFrame("grafpanel");
        ramme.add(panel);
        ramme.setVisible(true);
        ramme.setSize(400, 300);
        ramme.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        ramme.setLocation(900, 300);
    }

    private static JFreeChart lavChart(final XYDataset dataset) {
        //Simpel metode til at lave en JFreeChart, der kan smides ind i et panel.
        JFreeChart chart = ChartFactory.createXYLineChart("Eksempel på chart",
                "Tids-aksens label", "y-aksens label", dataset, PlotOrientation.VERTICAL, true, true, false);
        return chart;


    }

    void lavdataSaet() {
        dataset.addSeries(tempSerie);
        dataset.addSeries(pulsSerie);
        //Til vores samling med serier, kaldet dataset

        //Tilføj serien "temp"

    }


    //Sætter et par listeners op til at modtage grænseintervaller fra bruger.
    private void setupTextfields() {
        controlTempTextField(gui.maxTFelt, gui.ovreT);

        controlTempTextField(gui.minimumTFelt, gui.nedreT);
        controlPulseTextField(gui.pulsmax, gui.ovrep);
        controlPulseTextField(gui.pulsmin, gui.nedreP);
    }

    public void controlTempTextField(JTextField target, JLabel label) {
        String labeltekst = label.getText();
//Hvad skal der ske når brugeren fx. trykker på feltet?
        target.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                if (target.getText().contains("temp")) {
                    target.setText("");
                }

            }
        });
//Hvad skal der ske, når brugeren trykker Enter på textfeltet?
        target.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double result = Double.parseDouble(target.getText());
                System.out.println("parset værdi:" + result);
                String[] arr = labeltekst.split(" ", 1);
                label.setText(arr[0] + result + " C");
                //Tag første ord i label, og anvend det i den sætning, som du bruger til erstatning.
                //Dvs der skelnes mellem øvre og nedre.

            }
        });
        //Hvad skal der ske, ved de øvre?

    }


    public void controlPulseTextField(JTextField target, JLabel label) {
//Som for controlTempTextField, men med puls. Indeholder ikke en MouseReleased metode fordi brugerne kan regne ud at det er samme
        //funktionalitet som i ovenstående, fordi det ligner til forveksling.
        String labeltekst = label.getText();
        target.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                int result = Integer.parseInt(target.getText());
                System.out.println("parset værdi:" + result);
                //Nu skal vi få den til at skelne mellem om det er den øvre eller nedre label, der skal justeres.
                //Programmet ved hvilket tekstfelt, result kommer fra, og hvilken label der skal hen
                //Der skal bare lige findes det første ord, og genbruges:
                String[] arr = labeltekst.split(" ", 1);
//Find første ord.
                label.setText(arr[0] + result + " BPM");


            }
        });
    }


    private void tilfoejMouseListener() {


        //Lille metode til at vise eller skjule modulet med puls.
        gui.checkBox1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                int count = 0;
                count = count + 1;
                if (count > 0) {
                    gui.titellabel.setText("      ");
                }
                if (gui.checkBox1.isSelected()) {
                    togglePulseShow(true);
                    controlPulseTextField(gui.pulsmax, gui.ovrep);
                    controlPulseTextField(gui.pulsmin, gui.nedreP);

                } else {
                    togglePulseShow(false);

                }

            }
        });
    }

    private void togglePulseShow(boolean value) {
        gui.pulsmax.setVisible(value);
        gui.pulsmin.setVisible(value);

        gui.ovrep.setVisible(value);
        gui.nedreP.setVisible(value);
        gui.nyesteP.setVisible(value);


    }


    public void updateLabel(JLabel target, int data) {
        target.setText("" + data);
    }

    public void updateLabel(JLabel target, double data) {
        target.setText("" + data);
    }
}
