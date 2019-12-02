package com.example.myapplication;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import OpenHelper.SQLite_OpenHelper;

public class Main2Activity extends AppCompatActivity {

    TextView tvRegistrar;
    // principal
    Button btnIngresar;
    // instancia que te permite trabajr con la base de datos
    SQLite_OpenHelper db = new SQLite_OpenHelper(this,"DB1",null,1);




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        tvRegistrar =(TextView)findViewById(R.id.tv_Registrese);




        tvRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(getApplicationContext(),Registro.class);
                startActivity(i);

            }
        });

        btnIngresar =(Button)findViewById(R.id.btnIngreso);

        btnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                EditText usu=(EditText)findViewById(R.id.txtUsuario);
                EditText pas=(EditText)findViewById(R.id.txtPassword);

                try {
                    Cursor micursor = db.ConsultarUsuPas(usu.getText().toString(),pas.getText().toString());
                    if(micursor.getCount()>0){

                        Intent i = new Intent(getApplicationContext(),Principal.class);
                        startActivity(i);

                    }else{
                        Toast.makeText(getApplicationContext(),"Usuario y/o Password Incorrectos",Toast.LENGTH_LONG).show();

                    }

                    usu.setText("");
                    pas.setText("");
                    usu.findFocus();

                }catch (Exception e){
                    e.printStackTrace();
                }


            }
        });



    }
}
