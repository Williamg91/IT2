import javax.swing.*;

/**
 * Created by William on 08-03-2017.
 */
public class Main {
    //Læg lige mærke til at alle klasser med en main metode hedder Main med stort M.
    //Dvs klasserne

    public static void main(String[] args) {
//Standard fremgang til at lave en ramme.
        JFrame ramme = new JFrame("Brugergrænseflade");

        ramme.setSize(700, 300);
        ramme.setVisible(true);
        //Ikke noget komplekst her, Bos slides leverer det samme.
        ramme.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JPanel panel = new Panelet();
        ramme.add(panel);
    }
}
