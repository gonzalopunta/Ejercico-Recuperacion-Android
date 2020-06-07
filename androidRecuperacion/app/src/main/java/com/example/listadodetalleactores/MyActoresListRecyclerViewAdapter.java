package com.example.listadodetalleactores;

import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.listadodetalleactores.models.Actores;

import java.util.List;

public class MyActoresListRecyclerViewAdapter extends RecyclerView.Adapter<MyActoresListRecyclerViewAdapter.ViewHolder> {

    private Context ctx;
    private List<Actores> actores;
    private IActoresListener actoresListener;

    public MyActoresListRecyclerViewAdapter(List<Actores> actoresDetails, Context ctx, IActoresListener actoresListener) {
        this.actores = actoresDetails;
        this.ctx = ctx;
        this.actoresListener = actoresListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_actores_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = actores.get(position);
        holder.nombre.setText(holder.mItem.getName());
        holder.valoracion.setText(holder.mItem.getPopularity().toString());

        Glide.with(ctx)
                .load("https://image.tmdb.org/t/p/w500" + holder.mItem.getProfilePath())
                .into(holder.imagenActor);
        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                actoresListener.onClickActor(holder.mItem);
            }
        });
    }

    @Override
    public int getItemCount() {
        return actores.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView nombre;
        public final TextView valoracion;
        public final ImageView imagenActor;
        public Actores mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            nombre = (TextView) view.findViewById(R.id.TvNombre);
            valoracion = (TextView) view.findViewById(R.id.TvValoracion);
            imagenActor = (ImageView) view.findViewById(R.id.IvActor);
        }
    }
}
