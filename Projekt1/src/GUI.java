import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by William on 20-03-2017.
 */
public class GUI extends JFrame {

    JPanel mainPane;
    JTextField maxTFelt;
    JTextField minimumTFelt;
    JTextField pulsmax;
    JTextField pulsmin;
    JCheckBox checkBox1;
    JLabel ovrep;
    JLabel nedreP;
    JLabel ovreT;
    JLabel nedreT;
    JLabel dtutrademark;

    JLabel alarmP;
    JLabel alarmT;
    JLabel titellabel;
    private JButton visTidligereDataButton;
    private JButton plotNyesteDataButton;

    private ImageIcon icon = new ImageIcon(getClass().getResource("DTU3.jpg"));

    // Control control = new Control(this);
    JLabel nyesteT;

    JLabel nyesteP;
    //Stort set alt hvad der sker her, er ting, som sættes op når grænsefladen kører første gang. Dvs. det er en JFrame med et JPanel sat som skelet. Indholdet af det JPanel styres via Controller


    public GUI() {
        //Al koden til at bikse med dette her, rykker jeg nu over i en metode i Controller klassen, så den kan arbejde med GUI objektet.
       /* timer = new Timer(3000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (startTime < 0) {
                    startTime = System.currentTimeMillis();
                }


                sens.simulateMeasurement();
                nyesteT.setText(sens.simulateMeasurement() + "C");
            }
        });
        timer.setInitialDelay(0);
        if (!timer.isRunning()) {
            timer.start();
        }*/

        setupFrame();

        setupIcons();
        maxTFelt.setToolTipText("Temperatur som et decimal med et punktum, ikke komma, og tryk enter");
        minimumTFelt.setToolTipText("Temperatur som et decimal med et punktum, ikke komma, og tryk enter");
        pulsmin.setToolTipText("Indtast grænsen som et heltal og tryk enter");
        pulsmax.setToolTipText("Indtast grænsen som et heltal og tryk enter");



/*
todo: Implementer database og graffunktion.
        visTidligereDataButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Fuck, den dovne udvikler har ikke lavet dette endnu");
            }
        });
        plotNyesteDataButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Fuck, den dovne udvikler har ikke lavet dette endnu");
            }
        });
*/


        plotNyesteDataButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              Control ctrl = new Control();
                ctrl.tegnNuMinGraf();
            }
        });
    }
//Kodning til at opdatere automatisk


    private void setupFrame() {
        this.setContentPane(mainPane);
        this.setVisible(true);
        this.setSize(700, 400);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setTitle("Projekt 1: Puls og temperaturvisualisering");
        this.setLocation(200, 300);
    }


    private void setupIcons() {
        alarmP.setVisible(false);
        alarmT.setVisible(false);
        dtutrademark.setIcon(icon);
        dtutrademark.setText(null);
        nyesteT.setIcon(new ImageIcon(getClass().getResource("a.png")));

        nyesteP.setIcon(new ImageIcon(getClass().getResource("b.png")));
        nyesteP.setText("  BPM");
    }


    //nyesteT.

}

