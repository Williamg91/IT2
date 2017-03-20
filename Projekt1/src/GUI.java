import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
     JLabel nyesteT;
     JLabel nyesteP;
     JLabel alarmP;
     JLabel alarmT;
    JLabel titellabel;

    ImageIcon icon = new ImageIcon(getClass().getResource("DTU3.jpg"));
    Control control = new Control(this);
//Stort set alt hvad der sker her, er ting, som sættes op når grænsefladen kører første gang. Dvs. det er en JFrame med et JPanel sat som skelet. Indholdet af det JPanel styres via Controller

    public GUI() {
       setupFrame();

        setupIcons();




        control.controlTempTextField(maxTFelt, ovreT);
        //Sætter et par listeners op til at modtage grænseintervaller fra bruger.
        control.controlTempTextField(minimumTFelt, nedreT);
        control.controlPulseTextField(pulsmax, ovrep);
        control.controlPulseTextField(pulsmin, nedreP);



    }

    private void setupFrame() {
        this.setContentPane(mainPane);
        this.setVisible(true);
        this.setSize(700, 400);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setTitle("Projekt 1: Puls og temperaturvisualisering");
        this.setLocation(200, 300);
    }




    private void setupIcons(){
        alarmP.setVisible(false);
        alarmT.setVisible(false);
        dtutrademark.setIcon(icon);
        dtutrademark.setText(null);
        nyesteT.setIcon(new ImageIcon(getClass().getResource("a.png")));
        nyesteT.setText("0 C");
       nyesteP.setIcon(new ImageIcon(getClass().getResource("b.png")));
       nyesteP.setText("  BPM");
    }



}
