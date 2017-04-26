import java.sql.*;
import java.util.ArrayList;

/**
 * Created by William on 29-03-2017.
 */
public class Database {
    private String user;
    private String url;
    private Connection conn;


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


            System.out.println("fuck, jeg lukker her");


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
            e.printStackTrace();

        }
    }

    public ArrayList skafNogetFraSQL(int samplesize, String tabelnavn, String type) {
        //Hvor langt ArrayList vil vi have? Hvad hedder tabellen? er det T eller P?

        Statement seekInDatabase = new Statement() {
            @Override
            public ResultSet executeQuery(String sql) throws SQLException {
                return null;
            }

            @Override
            public int executeUpdate(String sql) throws SQLException {
                return 0;
            }

            @Override
            public void close() throws SQLException {

            }

            @Override
            public int getMaxFieldSize() throws SQLException {
                return 0;
            }

            @Override
            public void setMaxFieldSize(int max) throws SQLException {

            }

            @Override
            public int getMaxRows() throws SQLException {
                return 0;
            }

            @Override
            public void setMaxRows(int max) throws SQLException {

            }

            @Override
            public void setEscapeProcessing(boolean enable) throws SQLException {

            }

            @Override
            public int getQueryTimeout() throws SQLException {
                return 0;
            }

            @Override
            public void setQueryTimeout(int seconds) throws SQLException {

            }

            @Override
            public void cancel() throws SQLException {

            }

            @Override
            public SQLWarning getWarnings() throws SQLException {
                return null;
            }

            @Override
            public void clearWarnings() throws SQLException {

            }

            @Override
            public void setCursorName(String name) throws SQLException {

            }

            @Override
            public boolean execute(String sql) throws SQLException {
                return false;
            }

            @Override
            public ResultSet getResultSet() throws SQLException {
                return null;
            }

            @Override
            public int getUpdateCount() throws SQLException {
                return 0;
            }

            @Override
            public boolean getMoreResults() throws SQLException {
                return false;
            }

            @Override
            public void setFetchDirection(int direction) throws SQLException {

            }

            @Override
            public int getFetchDirection() throws SQLException {
                return 0;
            }

            @Override
            public void setFetchSize(int rows) throws SQLException {

            }

            @Override
            public int getFetchSize() throws SQLException {
                return 0;
            }

            @Override
            public int getResultSetConcurrency() throws SQLException {
                return 0;
            }

            @Override
            public int getResultSetType() throws SQLException {
                return 0;
            }

            @Override
            public void addBatch(String sql) throws SQLException {

            }

            @Override
            public void clearBatch() throws SQLException {

            }

            @Override
            public int[] executeBatch() throws SQLException {
                return new int[0];
            }

            @Override
            public Connection getConnection() throws SQLException {
                return null;
            }

            @Override
            public boolean getMoreResults(int current) throws SQLException {
                return false;
            }

            @Override
            public ResultSet getGeneratedKeys() throws SQLException {
                return null;
            }

            @Override
            public int executeUpdate(String sql, int autoGeneratedKeys) throws SQLException {
                return 0;
            }

            @Override
            public int executeUpdate(String sql, int[] columnIndexes) throws SQLException {
                return 0;
            }

            @Override
            public int executeUpdate(String sql, String[] columnNames) throws SQLException {
                return 0;
            }

            @Override
            public boolean execute(String sql, int autoGeneratedKeys) throws SQLException {
                return false;
            }

            @Override
            public boolean execute(String sql, int[] columnIndexes) throws SQLException {
                return false;
            }

            @Override
            public boolean execute(String sql, String[] columnNames) throws SQLException {
                return false;
            }

            @Override
            public int getResultSetHoldability() throws SQLException {
                return 0;
            }

            @Override
            public boolean isClosed() throws SQLException {
                return false;
            }

            @Override
            public void setPoolable(boolean poolable) throws SQLException {

            }

            @Override
            public boolean isPoolable() throws SQLException {
                return false;
            }

            @Override
            public void closeOnCompletion() throws SQLException {

            }

            @Override
            public boolean isCloseOnCompletion() throws SQLException {
                return false;
            }

            @Override
            public <T> T unwrap(Class<T> iface) throws SQLException {
                return null;
            }

            @Override
            public boolean isWrapperFor(Class<?> iface) throws SQLException {
                return false;
            }
        };
        //Den indeholder ca. 200 linjer med grænseflademetoder, og derfor skal I ikke trykke på linjen for at se hvad den indeholder. Luk den her hvis I kan.


        try {
            //Forsøg noget der kan gå galt.
            seekInDatabase.executeQuery("");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        ArrayList AL = new ArrayList();

        return AL;
    }

    public void lavDummyTabel() {

    }

}
