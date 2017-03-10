import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;

/**
 * Created by William on 08-03-2017.
 */
public class Panelet extends JPanel {

    BufferedImage bi = null;
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponents(g);

        try {
            bi = ImageIO.read(new File("C:\\Users\\William\\IdeaProjects\\IT2\\Session6\\dix.png"));
            g.drawImage(bi, 0, 0, null);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Fy fan!");
        }

        //tegnPenis(g);

    }

    //Bare for at vise hvordan du sætter et billede ind.
    private void tegnPenis(Graphics g) {
        //metode til at tegne en pik midt i JPanel, lavet i paint.
        BufferedImage bi = null;
        try {
            bi = ImageIO.read(new File("C:\\Users\\William\\IdeaProjects\\IT2\\Session6\\dix.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        g.drawImage(bi, 0, 0, null);
    }
}
