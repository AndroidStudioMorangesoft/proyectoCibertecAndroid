package com.example.myapplication.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.myapplication.MainActivity;
import com.example.myapplication.R;
import com.example.myapplication.model.DataModel;
import java.util.List;
/**
 * Created by EA8034 on 11/03/2018.
 */
//click en el foco rojo clic implements metodos
public class AdapterData extends RecyclerView.Adapter<AdapterData.HolderData>{

    private List<DataModel> mList;
    private Context ctx;

    public AdapterData(Context ctx , List<DataModel>mList){
        this.ctx=ctx;
        this.mList=mList;
    }
    @Override
    public HolderData onCreateViewHolder(ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.layoutlist,parent,false);
        HolderData holder = new HolderData(layout);
        return holder;
    }

    @Override
    public void onBindViewHolder(HolderData holder, int position) {
        DataModel dm = mList.get(position);
        holder.NombrePaciente.setText(dm.getNombrePaciente());
        holder.ApellidoPaciente.setText(dm.getApellidoPaciente());
        holder.Edad.setText(dm.getEdad());
        holder.Sexo.setText(dm.getSexo());
        holder.direccion.setText(dm.getDireccion());
        holder.NombreMedico.setText(dm.getNombreMedico());
        holder.Especialidad.setText(dm.getEspecialidad());
        holder.fecha.setText(dm.getFecha());
        holder.sede.setText(dm.getSede());
        holder.dm=dm;


    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

//id,NombrePaciente,ApellidoPaciente,Edad,direccion,NombreMedico,Especialidad,fecha,sede;

    class HolderData extends RecyclerView.ViewHolder{
        TextView NombrePaciente,ApellidoPaciente,Edad,Sexo,direccion,NombreMedico,Especialidad,fecha,sede;
        DataModel dm;

        public HolderData(View v){
            super(v);
            NombrePaciente=(TextView) v.findViewById(R.id.tvNombrePaciente);
            ApellidoPaciente=(TextView) v.findViewById(R.id.tvApellidoPaciente);
            Edad=(TextView) v.findViewById(R.id.tvEdad);
            Sexo=(TextView) v.findViewById(R.id.tvSexo);
            direccion=(TextView) v.findViewById(R.id.tvDireccion);
            NombreMedico=(TextView) v.findViewById(R.id.tvNombreMedico);
            Especialidad=(TextView) v.findViewById(R.id.tvEspecialidad);
            fecha=(TextView) v.findViewById(R.id.tvFecha);
            sede=(TextView) v.findViewById(R.id.tvSede);

            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent goInput = new Intent(ctx, MainActivity.class);
                    goInput.putExtra("id",dm.getId());
                    goInput.putExtra("NombrePaciente",dm.getNombrePaciente());
                    goInput.putExtra("ApellidoPaciente",dm.getApellidoPaciente());
                    goInput.putExtra("Edad",dm.getEdad());
                    goInput.putExtra("Sexo",dm.getSexo());
                    goInput.putExtra("direccion",dm.getDireccion());
                    goInput.putExtra("NombreMedico",dm.getNombreMedico());
                    //NombreMedico.getSelectedItem().toString()
                    goInput.putExtra("Especialidad",dm.getEspecialidad());
                    goInput.putExtra("fecha",dm.getFecha());
                    goInput.putExtra("sede",dm.getSede());
                    ctx.startActivity(goInput);
                }
            });

        }
    }





}
