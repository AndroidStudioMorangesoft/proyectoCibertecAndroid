package com.example.myapplication.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.myapplication.R;

/**
 * Created by user on 02/07/2018.
 */

public class SlaiderAdaptador extends PagerAdapter {

    private int[] imgs ={R.drawable.presentacion,R.drawable.tratamien1
            ,R.drawable.tratamien2,R.drawable.tratamien3,R.drawable.tratamien4,R.drawable.tratamien5,R.drawable.tratamien6,R.drawable.tratamiento7
            ,R.drawable.tratamiento8};

    private Context ctx;
    private LayoutInflater inflater;


    public SlaiderAdaptador (Context ctx){
        this.ctx = ctx;
    }

    @Override
    public int getCount() {
        return imgs.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return (view==(LinearLayout)object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        inflater = (LayoutInflater)ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = inflater.inflate(R.layout.swipe,container,false);
        ImageView img = (ImageView)v.findViewById(R.id.imageView);
        TextView tv =(TextView)v.findViewById(R.id.textViewSlaider);
        img.setImageResource(imgs[position]);
        tv.setText("PACIENTE TRATADO  :  "+position);
        container.addView(v);
        return v;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.invalidate();
    }
}











