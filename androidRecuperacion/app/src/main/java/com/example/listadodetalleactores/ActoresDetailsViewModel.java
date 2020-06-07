package com.example.listadodetalleactores;

import android.app.Application;

import com.example.listadodetalleactores.models.DetailsActor;
import com.example.listadodetalleactores.services.ActoresRepository;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

public class ActoresDetailsViewModel extends AndroidViewModel {

    MutableLiveData<DetailsActor> actor;
    ActoresRepository actoresRepository;

    public ActoresDetailsViewModel(@NonNull Application application) {
        super(application);
        actoresRepository = new ActoresRepository();
    }

    public MutableLiveData<DetailsActor> getActor(int idActor){
        actor = actoresRepository.getActor(idActor);
        return actor;
    }
}
