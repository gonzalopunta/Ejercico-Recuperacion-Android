package com.example.listadodetalleactores.services;

import android.widget.Toast;

import com.example.listadodetalleactores.MyApp;
import com.example.listadodetalleactores.models.Actores;
import com.example.listadodetalleactores.models.DetailsActor;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ActoresRepository {

    private ActoresService actoresService;

    public MutableLiveData<DetailsActor> getActor(int idActor) {
        final MutableLiveData<DetailsActor> actoresDetails = new MutableLiveData<>();

        Call<DetailsActor> call = actoresService.getDetailActor(idActor);
        call.enqueue(new Callback<DetailsActor>() {
            @Override
            public void onResponse(Call<DetailsActor> call, Response<DetailsActor> response) {
                if (response.isSuccessful()) {
                    actoresDetails.setValue(response.body());
                } else {
                    Toast.makeText(MyApp.getContext(), "Algo ha fallado", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<DetailsActor> call, Throwable t) {
                Toast.makeText(MyApp.getContext(), "Error de conexión", Toast.LENGTH_LONG).show();
            }
        });

        return actoresDetails;
    }

}
