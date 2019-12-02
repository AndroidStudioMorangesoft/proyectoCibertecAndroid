package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.myapplication.adapter.MedicoAdaptador;
import com.example.myapplication.adapter.SedeAdaptador;

public class SedeMain extends AppCompatActivity {


    ListView lstSede;
    String[] sedenombre={"","","","","",""};
    String[]descSede={
            "Clínica Municipal Santa Anita: Jr. San Pablo S/N 34 Urb. Los Productores – Santa Anita",
            "Sede central: Av. Alfredo Mendiola 5515 ,Urb. Villa del Norte – Los Olivos , Correo: clinica.",
            "Hospital Universitario de Piura: Avenida Andrés Avelino Cáceres con Avenida Luis Montero",
            "Ubícanos Av. Inca Garcilaso de la Vega 1420 Cercado de Lima",
            "Av. Tingo Maria 623 Breña, Lima Teléfono: (01) 3407739",
            "Av. Tingo Maria 623 Breña, Lima Teléfono: (01) 3407739"};
    Integer[] imageViewSede = {R.drawable.sede,R.drawable.sede1,R.drawable.sede2,R.drawable.sede3,R.drawable.sede4,R.drawable.sede5};




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sede_main);

        lstSede = (ListView)findViewById(R.id.listViewSede);
        SedeAdaptador sedeAdaptador = new SedeAdaptador(this,sedenombre,descSede,imageViewSede);
        lstSede.setAdapter(sedeAdaptador);

    }









}
