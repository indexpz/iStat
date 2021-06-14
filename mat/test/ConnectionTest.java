package pl.indexpz.iStat.test;


import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionTest {
    public static void main(String[] args) {

        try (Connection conn_istat = DbUtil.conn("serwer31807_istat7", args[0])) {
            System.out.println("Połączono z bazą danych...");
        } catch (SQLException ex) {
            ex.printStackTrace();
//            throw new RuntimeException("Nie udało połączyć się z bazą danych.", ex);
        }
    }
}
