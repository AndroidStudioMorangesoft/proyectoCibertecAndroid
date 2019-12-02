package com.example.myapplication.api;

/**
 * Created by EA8034 on 05/03/2018.
 */
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
public class Retroserver {
    private static final String base_url="http://192.168.56.1:8080/wsBDBoston/";
  //  private static final String base_url="http://10.166.205.9/wscrud/";
    private static Retrofit retrofit;

    public static Retrofit getClient()
    {
        if(retrofit == null)
        {
            retrofit = new Retrofit.Builder()
                    .baseUrl(base_url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }





}
