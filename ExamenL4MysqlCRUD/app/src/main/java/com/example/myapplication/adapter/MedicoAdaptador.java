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

public class MedicoAdaptador extends ArrayAdapter<String> {
      private String[]medicotname;
    private String[]desc;
    private  Integer[] imgid;
    private Activity context;


    public MedicoAdaptador(Activity context,String[]medicotname,String[]desc,Integer[] imgid) {
        super(context, R.layout.activity_medico_layout,medicotname);

    this.context=context;
    this.medicotname = medicotname;
    this.desc = desc;
    this.imgid= imgid;


    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

    View r= convertView;
    ViewHolder viewHolder= null;
    if(r == null){

        LayoutInflater layoutInflater = context.getLayoutInflater();
        r= layoutInflater.inflate(R.layout.activity_medico_layout,null,true);
        viewHolder = new ViewHolder(r);
        r.setTag(viewHolder);

    }else{
        viewHolder =(ViewHolder)r.getTag();

    }

    viewHolder.ivw.setImageResource(imgid[position]);
    viewHolder.tvw1.setText(medicotname[position]);
        viewHolder.tvw2.setText(desc[position]);


        return r;
    }

    class ViewHolder
    {
        TextView tvw1;
        TextView tvw2;
        ImageView ivw;

        ViewHolder(View v){
            tvw1= (TextView)v.findViewById(R.id.tvnombre);
            tvw2=(TextView)v.findViewById(R.id.tvdescripcion);
            ivw=(ImageView)v.findViewById(R.id.imageView);
        }
    }


}
