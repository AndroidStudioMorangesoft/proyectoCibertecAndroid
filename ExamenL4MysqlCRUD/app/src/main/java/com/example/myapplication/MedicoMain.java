package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.myapplication.adapter.MedicoAdaptador;

public class MedicoMain extends AppCompatActivity {

       ListView lst;
        String[] medicotname={" Samantha Samaniego ","Milton Reyes","Helen Gonzáles","Benjamín Valdivia","Fernando Álvarez","Manuel Rivera","Ray Foronda","Ely Rodríguez"};
        String[]desc={"CADIOLOGÍA :- Es la rama de la medicina encargada del estudio, diagnóstico y tratamiento de las enfermedades del corazón y del aparato circulatorio. Es médica, pero no quirúrgica; los especialistas en el abordaje quirúrgico del corazón son el cirujano cardiaco o el cirujano cardiovascular",
                "NEUROLOGÍA :- Es la especialidad médica que trata los trastornos del sistema nervioso. Específicamente se ocupa de la prevención, diagnóstico, tratamiento y rehabilitación de todas las enfermedades que involucran al sistema nervioso central, sistema nervioso periférico y el sistema nervioso autónomo",
                "TOXICOLOGÍA :- Es una ciencia que identifica, estudia y describe la dosis, la naturaleza, la incidencia, la severidad, la reversibilidad y, generalmente, los mecanismos de los efectos tóxicos que producen los xenobióticos que dañan el organismo. La toxicología también estudia los efectos nocivos de los agentes químicos.",
                "PEDRÍATRIA :- Es la especialidad médica que estudia al niño y sus enfermedades. El término procede del griego paidos (niño) e iatrea (curación), pero su contenido es mucho mayor que la curación de las enfermedades de los niños, ya que la pediatría estudia tanto al niño sano como al enfermo.",
                "NUTRICIÓN :- Es la especialidad médica que estudia la alimentación humana y su relación con los procesos químicos, biológicos y metabólicos, así como su relación con la composición corporal y estado de salud humana. Existen distintos modelos de nutriología, organizadas en dos grandes grupos.",
                "GEIATRÍA :-  Es una especialidad médica dedicada al estudio de la prevención, el diagnóstico, el tratamiento y la rehabilitación de las enfermedades en las personas de la tercera edad.",
                "ENDOCRINOLOGÍA :- Es una disciplina de la medicina que estudia el sistema endocrino y las enfermedades provocadas por un funcionamiento inadecuado del mismo. Algunas de las enfermedades de las que se ocupa la endocrinología son la diabetes mellitus provocada por deficiencia de insulina o resistencia." ,
                "INFECTOLOGÍA :-  Es una especialidad médica que se encarga del estudio, la prevención, el diagnóstico y el tratamiento de las enfermedades producidas por agentes infecciosos, está muy relacionada con la medicina interna y de la pediatría, en algunos países incluso todavía es una subespecialidad o área de estas dos especialidades."
        };
        Integer[] imgid = {R.drawable.medico5,R.drawable.medico6,R.drawable.medico7,R.drawable.medico8,R.drawable.medico9,R.drawable.medico10,R.drawable.medico11,R.drawable.medico12};




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medico_main);

lst = (ListView)findViewById(R.id.listView);
MedicoAdaptador medicoAdaptador = new MedicoAdaptador(this,medicotname,desc,imgid);
lst.setAdapter(medicoAdaptador);

    }




}
