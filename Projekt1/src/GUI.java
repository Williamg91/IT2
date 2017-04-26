import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by William on 20-03-2017.
 */
public class GUI extends JFrame {
/*
Bemærk at i modsætning til normale attributter, er disse IKKE private, men de er heller ikke public. De skal kendes til af Control klassen, så den kan pille ved, eller tilføje Listeners til variable.

 */
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
     JButton visTidligereDataButton;
     JButton plotNyesteDataButton;


    // Control control = new Control(this);
    JLabel nyesteT;

    JLabel nyesteP;
    //Stort set alt hvad der sker her, er ting, som sættes op når grænsefladen kører første gang. Dvs. det er en JFrame med et JPanel sat som skelet. Indholdet af det JPanel styres via Controller


    public GUI() {
      /*
      Konstruktøren for GUI, som er en JFrame. Kort sagt, hvad skal der ske når jeg laver et objekt af GUI klassen?
       */

        setupFrame();
        //En lille metode, jeg skrev til at sætte opstarten for JFrame.
        setupIcons();
        //Tilsvarende for ikoner, såsom Labels med billeder.
        maxTFelt.setToolTipText("Temperatur som et decimal med et punktum, ikke komma, og tryk enter");
        minimumTFelt.setToolTipText("Temperatur som et decimal med et punktum, ikke komma, og tryk enter");
        pulsmin.setToolTipText("Indtast grænsen som et heltal og tryk enter");
        pulsmax.setToolTipText("Indtast grænsen som et heltal og tryk enter");
//Tooltips vises når musen holdes over det specifikke view.


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

//Læg mærke til hvor LIDT logik der egentlig er i min grafiske brugergrænseflade. Der er "kun" statiske ting, men næsten ingen ActionListeners, fordi al reaktion sidder i controllerklassen.


        plotNyesteDataButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              Control ctrl = new Control();
                ctrl.tegnNuMinGraf();
            }
        });
    }



    private void setupFrame() {
        this.setContentPane(mainPane);
        this.setVisible(true);
        this.setSize(700, 400);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setTitle("Projekt 1: Puls og temperaturvisualisering");
        this.setLocation(200, 300);
    }


    private void setupIcons() {
        /*
        AlarmP og T er sat til false fra start af. Programmet skal jo ikke vise fejl, allerede ved start.
         */

        alarmP.setVisible(false);
        alarmT.setVisible(false);
        dtutrademark.setIcon(new ImageIcon(getClass().getResource("DTU3.jpg")));
        dtutrademark.setText(null);
        nyesteT.setIcon(new ImageIcon(getClass().getResource("a.png")));

        nyesteP.setIcon(new ImageIcon(getClass().getResource("b.png")));
        nyesteP.setText("  BPM");
    }


    //nyesteT.

}

