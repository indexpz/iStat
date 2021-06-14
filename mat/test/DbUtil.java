package pl.indexpz.iStat.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtil {
    public static final String EXCEL_PATH = "src/main/java/pl/indexpx/pl/ireport/_mat/odczyty.xlsx";
    public static final String INSERT_QUERY = "INSERT INTO meters (data, hot_water, cold_water, electricity, heat_meter) VALUES (?,?,?,?,?);";

    public static final String SQL = "jdbc:mysql://serwer31807_istat7";
    public static final String USER = "serwer31807_istat7";

//  private static final String DB_PARAMS = "?characterEncoding=utf8";
//  private static final String DB_PARAMS = "?characterEncoding=utf8&serverTimezone=UTC&useSSL=true[&nazwa=wartość]*";
    private static final String DB_PARAMS = "?characterEncoding=utf8&serverTimezone=UTC";


    public static Connection conn(String dbName, String password) throws SQLException {
        String sql = SQL + (dbName != null ? "/" + dbName : "") + DB_PARAMS;
        Connection connection = DriverManager.getConnection(sql, USER, password);
        return connection;
    }

}


