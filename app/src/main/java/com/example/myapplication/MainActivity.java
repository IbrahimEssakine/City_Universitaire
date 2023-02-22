package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;

public class MainActivity extends AppCompatActivity {

    private static clsConexionPG con = new clsConexionPG();
    Variables_Globales va = Variables_Globales.getInstance();
    Button btn_login;
    EditText txtCodeMassar, txtPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_login = findViewById(R.id.btn_login);
        //extract values of EditTexts
        txtCodeMassar = findViewById(R.id.txtCodeMassar);
        txtPassword = findViewById(R.id.txtPassword);
        EditText CodeMassrText = (EditText) findViewById(R.id.txtCodeMassar);
        EditText passwordText = (EditText) findViewById(R.id.txtPassword);
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //start function login after clicking the button "LOGIN"
                login(txtCodeMassar.getText().toString(), txtPassword.getText().toString());

            }
        });

    }

    public void login(String username, String password) {
        // here we creat the connection to the database ATTIRE

        try {
            //here we CALL the function from the database ATTIRE
            String storeProcedureCall="{CALL pa_login_android(?,?,?,?,?,?,?,?,?,?)}";
            CallableStatement cStmt = con.connectionDB().prepareCall(storeProcedureCall);
            //we insert the IN values from the function
            cStmt.setString(1,username);
            cStmt.setString(2,password);
            // we get the OUT values from the fonction
            cStmt.registerOutParameter(3, Types.VARCHAR);
            cStmt.registerOutParameter(4, Types.VARCHAR);
            cStmt.registerOutParameter(5, Types.VARCHAR);
            cStmt.registerOutParameter(6, Types.VARCHAR);
            cStmt.registerOutParameter(7, Types.VARCHAR);
            cStmt.registerOutParameter(8, Types.INTEGER);
            cStmt.registerOutParameter(9, Types.VARCHAR);
            cStmt.registerOutParameter(10, Types.VARCHAR);
            //we exedute the statement and wait for results
            cStmt.executeUpdate();
            //getting the result OUT from DB
            String _gender=cStmt.getString(3);
            String _email=cStmt.getString(4);
            String _phone=cStmt.getString(5);
            String _name=cStmt.getString(6);
            String _last_name=cStmt.getString(7);
            Integer _solde=cStmt.getInt(8);
            String _hex_id=cStmt.getString(9);
            String _msg=cStmt.getString(10);
            // msg is a variable in the function that go "OK" if IN values exist in the DB , and "code_massar or pass is incorrect"  IF the values r incorrect
            if(_msg.equals("OK")){
                //va is class that sets all variables to a globale variables so i can use them in other class
                va.set_email(_email);
                va.set_gender(_gender);
                va.set_phone(_phone);
                va.set_name(_name);
                va.set_last_name(_last_name);
                va.set_solde(_solde);
                va.set_hex_id(_hex_id);
                va.set_msg(_msg);
                //creat the profil View
                Intent menu = new Intent(this,actevity_menu.class);
                startActivity(menu);
            }else{
                //toast a respond from the DB
                Toast.makeText(getApplicationContext(),_msg,Toast.LENGTH_SHORT).show();
            }

        }catch (SQLException er){
            //toast an Exception
            Toast.makeText(getApplicationContext(),er.toString()+"HELLO",Toast.LENGTH_SHORT).show();
        }


    }
    }