package com.journaldev.retrofitintro.adaptador;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.journaldev.retrofitintro.R;
import com.journaldev.retrofitintro.pojo.MultipleResource;

import java.util.ArrayList;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Callback;

/**
 * Created by Sistemas on 19/04/2017.
 */

public class AdaptadorDatum extends RecyclerView.Adapter<AdaptadorDatum.DatumViewHolder>{

    ArrayList<MultipleResource.Datum> datos;
    Activity ActivityActual;

    public AdaptadorDatum(ArrayList<MultipleResource.Datum> datos) {
        this.datos = datos;
        //ActivityActual = activityActual;
    }

    @Override
    public AdaptadorDatum.DatumViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_datum,parent,false);
        return new DatumViewHolder(v);
    }

    @Override
    public void onBindViewHolder(AdaptadorDatum.DatumViewHolder holder, int position) {
        final MultipleResource.Datum datoActual = datos.get(position);
        holder.tvname.setText(datoActual.getName());
        holder.tvyear.setText(datoActual.getYear());
        holder.tvpantoneValue.setText(datoActual.getPantoneValue());
    }

    @Override
    public int getItemCount() {
        return datos.size();
    }

    public class DatumViewHolder extends RecyclerView.ViewHolder {
        private TextView tvid;
        private TextView tvname;
        private TextView tvyear;
        private TextView tvpantoneValue;
        public DatumViewHolder(View itemView) {
            super(itemView);
            tvname = (TextView) itemView.findViewById(R.id.tvNombre);
            tvyear = (TextView) itemView.findViewById(R.id.tvDetalle);
            tvpantoneValue = (TextView) itemView.findViewById(R.id.tvEstado);
        }
    }
}

