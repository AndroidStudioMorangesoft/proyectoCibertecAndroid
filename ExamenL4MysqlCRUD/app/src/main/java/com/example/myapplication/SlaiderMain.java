package com.example.myapplication;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.myapplication.adapter.SlaiderAdaptador;

public class SlaiderMain extends AppCompatActivity {
    SlaiderAdaptador adapter;
    ViewPager viewPager;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slaider_main);

        viewPager = (ViewPager)findViewById(R.id.view_pager);
        adapter = new SlaiderAdaptador(this);
        viewPager.setAdapter(adapter);



    }
}
















