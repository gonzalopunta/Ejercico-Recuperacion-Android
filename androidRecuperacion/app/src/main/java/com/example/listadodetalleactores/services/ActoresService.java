package com.example.listadodetalleactores.services;

import com.example.listadodetalleactores.models.Actores;
import com.example.listadodetalleactores.models.DetailsActor;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ActoresService {

    @GET("person/popular")
    Call<List<Actores>> listActores();

    @GET("/person/{person_id}")
    Call<DetailsActor> getDetailActor(@Path("person_id") Integer idActor);
}
