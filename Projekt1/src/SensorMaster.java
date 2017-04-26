import java.text.DecimalFormat;
import java.util.Random;

import jssc.*;


/**
 * Created by William on 10-03-2017.
 */
public class SensorMaster implements Measurements {
    public double res;
    String navn;
    SerialPort port;

    public SensorMaster(String navn) {
        this.navn = navn;
        //Hvad skal porten være for denne sensor?
        //

        try {
            port = new SerialPort(navn);
            port.openPort();
            //Åbner port.
            port.setParams(SerialPort.BAUDRATE_9600, SerialPort.DATABITS_8,
                    SerialPort.STOPBITS_1, SerialPort.PARITY_NONE);
            System.out.println("CD: " + port.isRLSD() + "\tCTS: " + port.isCTS() +
                    "\tDSR: " + port.isDSR() + "\tRI: " + port.isRING());
            port.setRTS(true);
            port.setDTR(true);

        } catch (SerialPortException ex) {
            ex.printStackTrace();
            String[] portnames = SerialPortList.getPortNames();

            port = new SerialPort(portnames[0]);

            try {
                port.openPort();
                port.setParams(SerialPort.BAUDRATE_9600, SerialPort.DATABITS_8,
                        SerialPort.STOPBITS_1, SerialPort.PARITY_NONE);
                System.out.println("CD: " + port.isRLSD() + "\tCTS: " + port.isCTS() +
                        "\tDSR: " + port.isDSR() + "\tRI: " + port.isRING());
                port.setRTS(true);
                port.setDTR(true);
            } catch (SerialPortException e) {
                System.out.println("Alternativ port fejlet.");
            }
        }

            System.out.println("hvad fuck? der er ingen port åben. ");
        }



    public SensorMaster() {
        //hvis ingen sensor defineres, bruges den først tilngængelige

    }

    @Override
    public double simulateMeasurement() {
//Bruges til at simulere en måling hvis ingen sensor er aktiv.
        Random r = new Random();
        res = 36.5 + (38.2 - 36.5) * r.nextDouble();
        System.out.println("Målt temp:" + res);
        DecimalFormat df = new DecimalFormat("##.##");
        String re = df.format(res).replace(",", ".");
        res = Double.parseDouble(re);

        return res;
    }


    public double rigtigMaaling() {
        try {

            for (int i = 0; i < 10; i++) {
                if (port.getInputBufferBytesCount() > 0) {
                    String ind = port.readString();
                    System.out.println(ind);

                }else{

                }
            }

        } catch (SerialPortException se) {

            System.out.println("Fejl ved serialport");
        }
        return res;
    }
}
