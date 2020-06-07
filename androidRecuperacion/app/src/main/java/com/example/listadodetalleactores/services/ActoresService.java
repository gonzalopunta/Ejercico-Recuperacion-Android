package com.example.listadodetalleactores.services;

import com.example.listadodetalleactores.models.Actores;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ActoresService {

    @GET("person/popular")
    Call<List<Actores>> listActores();


}
