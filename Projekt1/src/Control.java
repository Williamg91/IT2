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
    long startTime = -1;

    Timer timer;
    SensorMaster sens;
    //Styrer hvad vi tegner i vores TegnNoget-klasse. Dvs. panel-klassen er et værktøj, vi definerer. men Control
    //bestemmer hvordan det skal virke.
    GUI gui;


    public Control(GUI gui) {
        this.gui = gui;
        togglePulseShow(false);
        tilfoejMouseListener();
        setupTextfields();

        controlTimer();
    }

    private void controlTimer() {
        sens = new SensorMaster();
        //hvad skal vi lave løbende?
        timer = new Timer(4000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                double temp = sens.simulateMeasurement();

                gui.nyesteT.setText(temp + "C");
                Random r = new Random();
                int maxpuls= 90;
                int minpuls = 85;
                int ud = r.nextInt((maxpuls-minpuls+1)+minpuls);
                gui.nyesteP.setText(( ud +"BPM"));
                //har fået Temperatursimulering til at fungere. Så for at illustrere hvad der kan gøres med en pulsmåling, gøres det samme her.

            }
        });
        timer.setInitialDelay(0);
        if (!timer.isRunning()) {
            timer.start();
        }
    }

//Sætter et par listeners op til at modtage grænseintervaller fra bruger.
    private void setupTextfields(){
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
