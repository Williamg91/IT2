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
        JPanel panel = new Panelet();
        ramme.setSize(700, 500);
        ramme.add(panel);


        //Ikke noget komplekst her, Bos slides leverer det samme.
        ramme.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        ramme.setVisible(true);

    }
}
