package com.example.myapplication.api;

import com.example.myapplication.model.ResponsModel;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

//id,NombrePaciente,ApellidoPaciente,Edad,direccion,NombreMedico,Especialidad,fecha,sede;



public interface ApiRequestBiodata {
    @FormUrlEncoded
    @POST("insert.php")
    Call<ResponsModel>senBiodata(@Field("NombrePaciente") String NombrePaciente,
                                 @Field("ApellidoPaciente") String ApellidoPaciente,
                                 @Field("Edad") String Edad,
                                 @Field("Sexo") String Sexo,
                                 @Field("direccion") String direccion,
                                 @Field("NombreMedico") String NombreMedico,
                                 @Field("Especialidad") String Especialidad,
                                 @Field("fecha") String fecha,
                                 @Field("sede") String sede);

    @GET("read.php")
    Call<ResponsModel>getBiodata();

    @FormUrlEncoded
    @POST("update.php")
    Call<ResponsModel>updateData(@Field("id") String id,
                                 @Field("NombrePaciente") String NombrePaciente,
                                 @Field("ApellidoPaciente") String ApellidoPaciente,
                                 @Field("Edad") String Edad,
                                 @Field("Sexo") String Sexo,
                                 @Field("direccion") String direccion,
                                 @Field("NombreMedico") String NombreMedico,
                                 @Field("Especialidad") String Especialidad,
                                 @Field("fecha") String fecha,
                                 @Field("sede") String sede);

    @FormUrlEncoded
    @POST("delete.php")
    Call<ResponsModel>deleteData(@Field("id") String id);
}
