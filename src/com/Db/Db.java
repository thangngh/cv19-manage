/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Db;

/**
 *
 * @author pv
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Db {
    protected Connection sqlConnection;

    public Connection getSqlConnection() {
        return sqlConnection;
    }

    public void setSqlConnection(Connection sqlConnection) {
        this.sqlConnection = sqlConnection;
    }

    public Db() {
    }

    public void getConnection() throws SQLException, ClassNotFoundException {

        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

        sqlConnection = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;useUnicode=true;characterEncoding=UTF-8;" 
                        + "Databasename=mn_cvd", "sa","00000000");

    }

}
