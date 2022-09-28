package org.example.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
public static Connection getConnection() throws SQLException {
    String user="postgres";
    String password="postgres";
    return DriverManager.getConnection("jdbc:postgresql://localhost:5432/test",user,password);
   // return DriverManager.getConnection("jdbc:postgresql:/Program Files/PostgreSQL/13/pgAdmin 4/test.db");

}
}
