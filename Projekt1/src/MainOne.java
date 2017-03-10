import javax.swing.*;

/**
 * Created by William on 08-03-2017.
 */
public class MainOne {

    public static void main(String[] args){
//laver ramme som jeg fylder med et Panel.
        JFrame ramme = new JFrame("Fyld mig op, kælling");
        ramme.setSize(700,300);
        ramme.setVisible(true);
        GUI gui = new GUI();
        ramme.add(gui);
        //Ikke noget komplekst her, Bos slides leverer det samme.
        ramme.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }
}
