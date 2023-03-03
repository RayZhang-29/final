package com.mercury.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class JdbcPostgresUtil {

    // for connecting to DB by using JDBC
    // need below 4 informations:

    private static final String DRIVER = "org.postgresql.Driver";
    private static final String URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "mercury";

    public static Connection getConnection(){
        Connection conn = null;
        try{
            // Class.forName() will load the class during runtime
            Class.forName(DRIVER);
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        }catch(Exception e){
            System.err.println(e);
        }
        return conn;
    }

}