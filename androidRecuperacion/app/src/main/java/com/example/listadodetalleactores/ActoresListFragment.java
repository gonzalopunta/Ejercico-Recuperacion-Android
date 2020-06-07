package com.example.listadodetalleactores;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Response;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.listadodetalleactores.models.Actores;
import com.example.listadodetalleactores.services.ActoresService;
import com.example.listadodetalleactores.services.ServiceGenerateActores;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ActoresListFragment extends Fragment {

    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters
    private int mColumnCount = 1;
    private MyActoresListRecyclerViewAdapter myActoresListRecyclerViewAdapter;
    private List<Actores> listaActores = new ArrayList<>();
    Context ctx;
    private ActoresService actoresService;
    private IActoresListener actoresListener;
    RecyclerView recyclerView;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public ActoresListFragment() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static ActoresListFragment newInstance(int columnCount) {
        ActoresListFragment fragment = new ActoresListFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_actores_list_list , container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }
            listaActores = new ArrayList<>();
            myActoresListRecyclerViewAdapter =new MyActoresListRecyclerViewAdapter(listaActores, ctx, actoresListener);
            recyclerView.setAdapter(myActoresListRecyclerViewAdapter);
            actoresService = ServiceGenerateActores.createService(ActoresService.class);
            new funcionAsinkTask();
        }
        return view;
    }

    private class funcionAsinkTask extends AsyncTask <Void, Void, List<Actores>>{

        @Override
        protected List<Actores> doInBackground(Void... voids) {
            Call<List<Actores>> getActores = actoresService.listActores();
            Response<List<Actores>> responseGetAllActores = null;

            try {
                responseGetAllActores = getActores.execute();
            }
            catch (IOException e){
                e.printStackTrace();
            }

            if(responseGetAllActores.isSuccessful()){
                listaActores.addAll(responseGetAllActores.body());
            }
            return listaActores;
        }
    }
}
