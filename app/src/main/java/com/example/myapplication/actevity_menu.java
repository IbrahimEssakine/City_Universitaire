package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class actevity_menu extends AppCompatActivity {

    Variables_Globales va=Variables_Globales.getInstance();
    TextView txtName,txtLastName,txtPhone,txtGender,txtEmail;
    Button btn_solde;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        txtEmail=findViewById(R.id.txtEmail);
        txtGender=findViewById(R.id.txtGender);
        txtLastName=findViewById(R.id.txtLastName);
        txtName=findViewById(R.id.txtName);
        txtLastName=findViewById(R.id.txtLastName);

        if(va.get_phone()!=""){
            txtName.setText(va.get_name());
            txtLastName.setText(va.get_last_name());
            txtGender.setText(va.get_gender());
            txtPhone.setText(va.get_phone());
            txtEmail.setText(va.get_email());




        }


    }
}