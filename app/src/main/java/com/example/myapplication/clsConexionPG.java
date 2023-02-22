package com.example.myapplication;

import android.util.Log;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class clsConexionPG {
    Connection connexion = null;

    public Connection connectionDB() {

        try {
            Class.forName("org.postgresql.Driver");
            connexion = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/ATTIRE", "openpg", "openpgpwd");
            Log.i("info","after driver");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return connexion;
    }



}
