import javax.swing.*;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;

/**
 * Created by William on 08-03-2017.
 */
public class GUI extends JFrame {
    private JPanel panel1;
    private JTextField maxTempTextField;
    private JTextField temperaturMinTextField;
    private JButton plotTidligereMålingerButton;
    private JButton plotNyesteMålingerButton;
    private JCheckBox shrekbox;
    private JLabel pulslabel1;
    private JLabel pulslabel2;
    private JLabel pulsMin;
    private JLabel pulsMax;
    /*
    I denne klasse sætter vi vores brugergrænseflade op. Det program, jeg anvender, har en GUI designer i stil med Netbeans, der bare er træk og slip.
    Men, vi beskæftiger os ikke med at sætte grafen op i dette panel. Det bruger vi en separat tegneklasse til.
     */

    public GUI(){
setContentPane(panel1);
hidePulseComponents();
        /*
        Først skal vi tænke lidt over hvad der skal ske, når GUI initaliseres.
         */
//hidePulseComponents();



    }

void hidePulseComponents(){
        pulslabel1.setVisible(false);
        pulslabel2.setVisible(false);
        pulsMax.setVisible(false);
        pulsMin.setVisible(false);

        //This method is called as soon as the class is made, to hide the Pulse sensor functionality.
    //
}


}
