import java.sql.*;
import java.util.ArrayList;

/**
 * Created by William on 29-03-2017.
 */
public class Database {
    private String user;
    private String url;
    private Connection conn;
    Statement stmt;


    //Alright, hvor vi før har oprettet forbindelse til en fil, for at hente et ArrayList ud med værdier.
    public Database() {
        //Konstruktør til at oprette forbindelse når objekt laves.
        user = "suit200";
        String pass = "dtu127961F17";
        url = "jdbc:mysql://server3.eduhost.dk/suit200";
        String hostname = "server3.eduhost.dk/";
        String tabel = "suit200";
        String connurl = "jdbc:mysql://" + hostname + tabel;


        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conn = DriverManager.getConnection(connurl, user, pass);
            System.out.println("Hey! der åbent!");


        } catch (Exception e) {

            //Denne her del sker kun hvis jeg ikke kan få adgang til skolens DB.
            url = "jdbc:sqlite:C:\\Users\\William\\IdeaProjects\\IT2\\test.db";
            //Den skal så ændres til en lokal SQLIte database. Det bliver ikke så relevant for jer, men jeg brugte den bare for at kunne arbejde hjemmefra/uden net.
            try {
                conn = DriverManager.getConnection(url);
                System.out.println("Hej, jeg er her for dig!");
            } catch (SQLException e1) {
                e1.printStackTrace();
                System.out.println("jeg kan heller ikke finde mig selv :'(");
            }
           // e.printStackTrace();

        }
    }

    public ArrayList skafNogetFraSQL(int samplesize, String tabelnavn, String type) {
        //Hvor langt ArrayList vil vi have? Hvad hedder tabellen? er det T eller P?


        //Den indeholder ca. 200 linjer med grænseflademetoder, og derfor skal I ikke trykke på linjen for at se hvad den indeholder. Luk den her hvis I kan.

        ArrayList<Double> AL = new ArrayList<>();
        try {
            //Forsøg noget der kan gå galt.
            stmt = conn.createStatement();


            //differentiate between types

            //temperature

            //pulse
            ResultSet set = stmt.executeQuery("SELECT * FROM " + tabelnavn + " where type = '"
                    + type + "" +
                    " ' order by iddata desc limit " + samplesize + " ;");
            while (set.next()) {
                double res = set.getDouble("value");
                AL.add(res);

            }
            System.out.println(AL.get(0));
        } catch (SQLException ex) {
            ex.printStackTrace();
        }


        return AL;
    }

    public void indsaetMaaling(double temp) {
        try {
            stmt.executeUpdate("insert into data(value,type,time) values(" + temp + ",'t',now());");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void indsaetMaaling(int puls) {
        try {
            stmt.executeUpdate("insert into data(value,type,time) values(" + puls + ",'p',now());");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void lavDummyTabel() {

    }

}
