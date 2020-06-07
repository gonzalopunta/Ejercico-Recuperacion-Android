package com.example.listadodetalleactores;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.listadodetalleactores.models.DetailsActor;

public class DetailsActorActivity extends AppCompatActivity {

    TextView nombre, cumpleanos, biografia;
    ImageView ivActor;
    ActoresDetailsViewModel actoresDetailsViewModel;
    int idActor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_actor);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        nombre = findViewById(R.id.TvActor);
        cumpleanos = findViewById(R.id.TvCumpleaños);
        biografia = findViewById(R.id.TvBiografia);
        ivActor = findViewById(R.id.IvActor);

        actoresDetailsViewModel = new ViewModelProvider(this, (ViewModelProvider.Factory) actoresDetailsViewModel).get(ActoresDetailsViewModel.class);

        actoresDetailsViewModel.getActor(idActor).observe(this, new Observer<DetailsActor>() {
            @Override
            public void onChanged(DetailsActor detailsActor) {

            }
        });
    }
}
