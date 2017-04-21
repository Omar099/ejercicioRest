package com.sistemas.omarin.restpruebaspaises.Adaptador;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.sistemas.omarin.restpruebaspaises.Model.Pais;
import com.sistemas.omarin.restpruebaspaises.R;

import java.util.ArrayList;
/**
 * Created by Sistemas on 19/04/2017.
 */

public class PaisAdaptador extends RecyclerView.Adapter<PaisAdaptador.PaisViewHolder>{

    ArrayList<Pais> Paises;
    Activity ActivityActual;

    public PaisAdaptador(ArrayList<Pais> paises, Activity activityActual) {
        Paises = paises;
        ActivityActual = activityActual;
    }

    @Override
    public PaisAdaptador.PaisViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_pais,parent,false);
        return new PaisViewHolder(v);
    }

    @Override
    public void onBindViewHolder(PaisAdaptador.PaisViewHolder PaisHolder, int position) {
        final Pais paisActual = Paises.get(position);
        PaisHolder.tvNombre.setText(paisActual.getName());
        PaisHolder.tvcode2.setText(paisActual.getAlpha2_code());
        PaisHolder.tvcode3.setText(paisActual.getAlpha3_code());
    }

    @Override
    public int getItemCount() {

        if (Paises == null){
            Toast.makeText(ActivityActual, "No hay datos en el Arreglo Paises", Toast.LENGTH_LONG).show();
            return -1;
        }
        return Paises.size();
    }

    public static class PaisViewHolder extends RecyclerView.ViewHolder {
        private TextView tvNombre;
        private TextView tvcode2;
        private TextView tvcode3;

        public PaisViewHolder(View itemView) {
            super(itemView);
            tvNombre = (TextView)itemView.findViewById(R.id.tvNombre);
            tvcode2 = (TextView)itemView.findViewById(R.id.tvEstado);
            tvcode3 = (TextView)itemView.findViewById(R.id.tvDetalle);
        }
    }
}

