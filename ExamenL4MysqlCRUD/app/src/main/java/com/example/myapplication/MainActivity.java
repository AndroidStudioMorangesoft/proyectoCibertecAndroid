package com.example.myapplication;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.myapplication.api.ApiRequestBiodata;
import com.example.myapplication.api.Retroserver;
import com.example.myapplication.model.ResponsModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    EditText NombrePaciente,ApellidoPaciente,Edad,Sexo,direccion,fecha,sede;

    Spinner NombreMedico ;
    String[] items;

    Spinner Especialidad ;
    String[] items2;



    Button btnsave , btnTampildata,btnupdate,btndelete;
    ProgressDialog pd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        NombrePaciente=(EditText) findViewById(R.id.edt_NombrePaciente);
        ApellidoPaciente=(EditText) findViewById(R.id.edt_ApellidoPaciente);
        Edad=(EditText) findViewById(R.id.edt_Edad);
        Sexo = (EditText) findViewById(R.id.edt_Sexo);
        direccion=(EditText) findViewById(R.id.edt_Direccion);
       // NombreMedico=(EditText) findViewById(R.id.edt_NombreMedico);
        NombreMedico=(Spinner)findViewById(R.id.spinnermedico);
        items = getResources().getStringArray(R.array.lista_doctores);
        ArrayAdapter<String> adapter= new ArrayAdapter<String>(getBaseContext(),android.R.layout.simple_spinner_item,items);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        NombreMedico.setAdapter(adapter);

        //-----------------------

        //  Especialidad=(EditText) findViewById(R.id.edt_Especialidad);
        Especialidad=(Spinner)findViewById(R.id.spinnespecialidad);
        items2 = getResources().getStringArray(R.array.lista_especialidades);
        ArrayAdapter<String> adap= new ArrayAdapter<String>(getBaseContext(),android.R.layout.simple_spinner_item,items2);
        adap.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Especialidad.setAdapter(adap);
        //-----------------------
        fecha=(EditText) findViewById(R.id.edt_Fecha);
        sede=(EditText) findViewById(R.id.edt_Sede);




        btnTampildata=(Button) findViewById(R.id.btntampildata);
        btnupdate=(Button) findViewById(R.id.btnUpdate);
        btnsave=(Button) findViewById(R.id.btn_insertdata);
        btndelete=(Button) findViewById(R.id.btnDelete);

        Intent data = getIntent();
      final String iddata=data.getStringExtra("id");

       if (iddata != null){

            btnupdate.setVisibility(View.VISIBLE);
            btndelete.setVisibility(View.VISIBLE);

           NombrePaciente.setText(data.getStringExtra("NombrePaciente"));
           ApellidoPaciente.setText(data.getStringExtra("ApellidoPaciente"));
           Edad.setText(data.getStringExtra("Edad"));
           Sexo.setText(data.getStringExtra("Sexo"));
           direccion.setText(data.getStringExtra("direccion"));

        // NombreMedico (data.getStringExtra("NombreMedico"));
          // Especialidad.setText(data.getStringExtra("Especialidad"));
           fecha.setText(data.getStringExtra("fecha"));
           sede.setText(data.getStringExtra("sede"));
        }


        pd= new ProgressDialog(this);



        btnTampildata.setOnClickListener(new View.OnClickListener(){
        @Override
        public void onClick(View v){
            Intent goData = new Intent(MainActivity.this,TampilData.class);
            startActivity(goData);
        }
         });

        btndelete.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                pd.setMessage("Loading Delete ...");
                pd.setCancelable(false);
                pd.show();

                ApiRequestBiodata api = Retroserver.getClient().create(ApiRequestBiodata.class);
                Call<ResponsModel>del=
                        api.deleteData(iddata);

                del.enqueue(new Callback<ResponsModel>() {
                    @Override
                    public void onResponse(Call<ResponsModel> call, Response<ResponsModel> response) {
                        Log.d("Retro","OnResponse");
                        Toast.makeText(MainActivity.this,response.body().getMensaje(),Toast.LENGTH_SHORT).show();

                        Intent gotAmpil =new Intent(MainActivity.this,TampilData.class);
                        startActivity(gotAmpil);

                        //pd.hide();
                    }

                    @Override
                    public void onFailure(Call<ResponsModel> call, Throwable t) {
                        pd.hide();
                        Log.d("Retro","OnFail");

                    }
                });
            }
        });



        btnupdate.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                pd.setMessage("Update Data ...");
                pd.setCancelable(false);
                pd.show();
                ApiRequestBiodata api = Retroserver.getClient().create(ApiRequestBiodata.class);
                Call<ResponsModel>update=
                        api.updateData(iddata,NombrePaciente.getText().toString(),ApellidoPaciente.getText().toString(),Edad.getText().toString(),Sexo.getText().toString(),
                                direccion.getText().toString() ,NombreMedico.getSelectedItem().toString(),Especialidad.getSelectedItem().toString(),
                                fecha.getText().toString(),sede.getText().toString());

                update.enqueue(new Callback<ResponsModel>() {
                    @Override
                    public void onResponse(Call<ResponsModel> call, Response<ResponsModel> response) {
                        Log.d("Retro","Response");
                      Toast.makeText(MainActivity.this,response.body().getMensaje(),Toast.LENGTH_SHORT).show();
                        Intent gotAmpil =new Intent(MainActivity.this,TampilData.class);
                        startActivity(gotAmpil);
                        pd.hide();
                    }

                    @Override
                    public void onFailure(Call<ResponsModel> call, Throwable t) {
                        pd.hide();
                        Log.d("Retro","OnFail");

                    }
                });



            }
        });

        //  EditText NombrePaciente,ApellidoPaciente,Edad,direccion,NombreMedico,Especialidad,fecha,sede;

        btnsave.setOnClickListener(new View.OnClickListener(){
        @Override
            public void onClick(View v){
            pd.setMessage("Send Data ...");
            pd.setCancelable(false);
            pd.show();
            String sNombrePaciente= NombrePaciente.getText().toString();
            String sApellidoPaciente= ApellidoPaciente.getText().toString();
            String sEdad= Edad.getText().toString();
            String sSexo= Sexo.getText().toString();
            String sdireccion= direccion.getText().toString();
            String sNombreMedico= NombreMedico.getSelectedItem().toString();
            String sEspecialidad= Especialidad.getSelectedItem().toString();
            String sfecha= fecha.getText().toString();
            String ssede= sede.getText().toString();

            ApiRequestBiodata api = Retroserver.getClient().create(ApiRequestBiodata.class);
            Call<ResponsModel> sendbio = api.senBiodata(sNombrePaciente,sApellidoPaciente,sEdad,sSexo,sdireccion,sNombreMedico,sEspecialidad,sfecha,ssede);
            sendbio.enqueue(new Callback<ResponsModel>() {
                @Override
                public void onResponse(Call<ResponsModel> call, Response<ResponsModel> response) {
                    pd.hide();
                    Log.d("RETRO","response : " + response.body().toString());
                    String kode = response.body().getCodigo();

                    if (kode.equals("1")){
                        Toast.makeText(MainActivity.this,"Inserción realizada con éxito",Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(MainActivity.this,"Error en la Inserción",Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<ResponsModel> call, Throwable t) {
                    pd.hide();
                    Log.d("RETRO","failure : " + "Gagal ... ");
                }
            });



        }

        });
    }
}
