package com.sistemas.omarin.contactos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class ListaContactosVista extends AppCompatActivity {

    private ArrayList<Contacto> Contactos;
    private RecyclerView rvListaContactos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lista_contactos_vista);

        rvListaContactos = (RecyclerView) findViewById(R.id.rvListaContactos);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rvListaContactos.setLayoutManager(llm);

        crearListaContactos();
        startAdaptador();

    }

    public void startAdaptador(){
        AdaptadorContacto adaptador= new AdaptadorContacto(Contactos,this);
        rvListaContactos.setAdapter(adaptador);
    }

    public void crearListaContactos() {
        Contactos = new ArrayList<Contacto>();
        Contactos.add(new Contacto(1,"Lopez","100","url"));
        Contactos.add(new Contacto(2,"Aranda","80","url"));
        Contactos.add(new Contacto(3,"Articulo","40","url"));
        Contactos.add(new Contacto(4,"Tacubaya","0","url"));
        Contactos.add(new Contacto(5,"Tlalnepantla","0","url"));
    }
}
