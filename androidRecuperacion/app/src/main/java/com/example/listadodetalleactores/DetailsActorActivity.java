package com.example.listadodetalleactores;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailsActorActivity extends AppCompatActivity {

    TextView nombre, cumpleanos, biografia;
    ImageView ivActor;

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
    }
}
