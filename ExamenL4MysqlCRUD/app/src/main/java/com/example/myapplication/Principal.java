package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Principal extends AppCompatActivity {

    TextView AgregarCita;
    TextView vistamedico;
    TextView vistasede;
    TextView vistaintervencion;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        AgregarCita =(TextView)findViewById(R.id.txtAgregarCita);
        vistamedico=(TextView)findViewById(R.id.txtvistamedico);
        vistasede =(TextView)findViewById(R.id.txtVerSede);
        vistaintervencion=(TextView)findViewById(R.id.txtTextIntervencion);

        AgregarCita.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            Intent i = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(i);

            }
        });

        vistamedico.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),MedicoMain.class);
                startActivity(i);
            }
        });


        vistasede.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(getApplicationContext(),SedeMain.class);
                startActivity(i);

            }
        });

        vistaintervencion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(getApplicationContext(),SlaiderMain.class);
                startActivity(i);

            }
        });


    }
}
