import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by William on 20-03-2017.
 */
public class CustomJLabel extends JLabel {
    //Denne her laves for at tilføje en timer til Custom label. Det er noget nemmere på den her måde, fordi det giver os en skabelon
    //at vise vores nyeste værdier efter
    public CustomJLabel(ImageIcon type) {
        this.setIcon(type);
        this.setText(null);
        Timer timer = new Timer(3000, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                repaint();
            }
        });
        timer.start();
        repaint();
    }


    public void updateMeasurements(double temp) {
        this.setText(temp + "C");
    }

    public void updateMeasurements(int BPM) {
        this.setText(BPM + "BPM");
    }

    public void updateAlarm() {

        this.setIcon(null);
        this.setText(null);
    }

}
