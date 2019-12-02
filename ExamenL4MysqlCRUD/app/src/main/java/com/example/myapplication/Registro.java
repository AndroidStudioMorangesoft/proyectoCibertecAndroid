package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import OpenHelper.SQLite_OpenHelper;

public class Registro extends AppCompatActivity {
    Button btngrabar;
    EditText txtNomUsu,txtDisUsu,txtCorUsu,txtPasUsu;
    //instancia de la base de datos create
    SQLite_OpenHelper bd = new SQLite_OpenHelper(this,"DB1",null,1);



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);



        btngrabar = (Button)findViewById(R.id.btnRegistrarUsu);
        txtNomUsu =(EditText)findViewById(R.id.txtNomUsu);
        txtDisUsu =(EditText)findViewById(R.id.txtDisUsu);
        txtCorUsu =(EditText)findViewById(R.id.txtCorUsu);
        txtPasUsu =(EditText)findViewById(R.id.txtPasUsu);

        btngrabar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bd.abrir();
                bd.insertarRegistro(String.valueOf(txtNomUsu.getText()),
                        String.valueOf(txtDisUsu.getText()),
                        String.valueOf(txtCorUsu.getText()),
                        String.valueOf(txtPasUsu.getText()));
                bd.cerrar();

                Toast.makeText(getApplicationContext(),"Registro Almancenado",Toast.LENGTH_LONG).show();
                Intent i = new Intent(getApplicationContext(),Main2Activity.class);
                startActivity(i);
            }
        });



    }
}
