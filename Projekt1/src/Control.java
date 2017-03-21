import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by William on 10-03-2017.
 */
public class Control {
    SensorMaster sens = new SensorMaster();
    Timer times;
    //Styrer hvad vi tegner i vores TegnNoget-klasse. Dvs. panel-klassen er et værktøj, vi definerer. men Control
    //bestemmer hvordan det skal virke.
    GUI gui;


    public Control(GUI gui) {
        this.gui = gui;
        togglePulseShow(false);
        tilfoejMouseListener();

    }




    public void controlTempTextField(JTextField target, JLabel label) {
        String labeltekst = label.getText();

        target.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                if (target.getText().contains("temp")) {
                    target.setText("");
                }

            }
        });

        target.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double result = Double.parseDouble(target.getText());
                System.out.println("parset værdi:" + result);
                String[] arr = labeltekst.split(" ", 1);
                label.setText(arr[0] + result + " C");

            }
        });
        //Hvad skal der ske, ved de øvre?

    }

    public void controlPulseTextField(JTextField target, JLabel label) {

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
