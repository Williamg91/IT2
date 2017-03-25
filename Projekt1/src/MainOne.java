import javax.swing.*;
import org.jfree.chart.*;
import org.jfree.data.*;
import org.jfree.ui.*;
/**
 * Created by William on 08-03-2017.
 */
public class MainOne {


    public static void main(String[] args) {
//laver ramme som jeg fylder med et Panel.


        //Control cont = new Control(new GUI());


    }

    static void setupFrame() {
       JFrame ramme = new JFrame("grafpanel");

        ramme.setVisible(true);
        ramme.setSize(700, 400);
        ramme.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        ramme.setLocation(200, 300);



    }


}
