package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {
    final static String driverMySQl = "com.mysql.jdbc.Driver";
    final static String url = "jdbc:mysql://localhost/space_trader";
    final static String uid = "gui_user";
    final static String pwd = "user123";
    private Connection con = null;

    public DBConnector() {
        try {
            Class.forName(driverMySQl).newInstance();
            con = DriverManager.getConnection(url,uid,pwd);
            con.setAutoCommit(true);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("Nie znaleziono sterownika bazy danych");
            System.out.println(e);
            System.exit(1);
        } catch (SQLException e) {
            System.out.println("Nie połaczyłem się z bazą " + url);
            System.out.println(e);
            System.exit(1);
        }
    }

    public Connection getCon() {
        return con;
    }
}
