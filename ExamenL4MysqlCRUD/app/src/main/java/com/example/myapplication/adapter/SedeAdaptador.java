package com.example.myapplication.adapter;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplication.R;

/**
 * Created by user on 01/07/2018.
 */

public class SedeAdaptador extends ArrayAdapter<String> {

    private String[]sedenombre;
    private String[]descSede;
    private  Integer[] imageViewSede;
    private Activity context;


    public SedeAdaptador(Activity context, String[]sedenombre, String[]descSede, Integer[] imageViewSede) {
        super(context, R.layout.activity_sede_layout,sedenombre);

        this.context=context;
        this.sedenombre = sedenombre;
        this.descSede = descSede;
        this.imageViewSede= imageViewSede;


    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View r= convertView;
        SedeAdaptador.ViewHolder viewHolder= null;
        if(r == null){

            LayoutInflater layoutInflater = context.getLayoutInflater();
            r= layoutInflater.inflate(R.layout.activity_sede_layout,null,true);
            viewHolder = new SedeAdaptador.ViewHolder(r);
            r.setTag(viewHolder);

        }else{
            viewHolder =(SedeAdaptador.ViewHolder)r.getTag();

        }

        viewHolder.ivw.setImageResource(imageViewSede[position]);
        viewHolder.tvw1.setText(sedenombre[position]);
        viewHolder.tvw2.setText(descSede[position]);


        return r;
    }

    class ViewHolder
    {
        TextView tvw1;
        TextView tvw2;
        ImageView ivw;

        ViewHolder(View v){
            tvw1= (TextView)v.findViewById(R.id.tvnombreSede);
            tvw2=(TextView)v.findViewById(R.id.tvdescripcionSede);
            ivw=(ImageView)v.findViewById(R.id.imageViewSede);
        }
    }

}
