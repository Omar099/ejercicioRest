package com.sistemas.omarin.contactos;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Sistemas on 20/04/2017.
 */

public class AdaptadorContacto extends RecyclerView.Adapter<AdaptadorContacto.ContactoViewHolder> {

    ArrayList<Contacto> contactos;
    Activity activity;

    public AdaptadorContacto(ArrayList<Contacto> contactos, Activity activity) {
        this.contactos = contactos;
        this.activity = activity;
    }

    @Override
    public AdaptadorContacto.ContactoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_contacto,parent,false);
        return new ContactoViewHolder(v);
    }

    @Override
    public void onBindViewHolder(AdaptadorContacto.ContactoViewHolder contactoViewHolder, int position) {
        final Contacto contactoRow = contactos.get(position);
        contactoViewHolder.tvId.setText(String.valueOf(contactoRow.getId()));
        contactoViewHolder.tvNombre.setText(contactoRow.getFirst_name());
        contactoViewHolder.tvApellido.setText(contactoRow.getLast_name());
    }

    @Override
    public int getItemCount() {

        return contactos.size();
    }

    public class ContactoViewHolder extends RecyclerView.ViewHolder {
        private TextView tvId;
        private TextView tvNombre;
        private TextView tvApellido;
        //private ImageView ivAvatar;

        public ContactoViewHolder(View itemView) {
            super(itemView);

            tvId = (TextView) itemView.findViewById(R.id.tvId);
            tvNombre = (TextView) itemView.findViewById(R.id.tvNombre);
            tvApellido = (TextView) itemView.findViewById(R.id.tvApellido);
            //ivAvatar = (ImageView) itemView.findViewById(R.id.ivAvatar);
        }
    }
}
