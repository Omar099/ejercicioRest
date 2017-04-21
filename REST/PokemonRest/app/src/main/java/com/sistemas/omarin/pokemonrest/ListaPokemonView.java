package com.sistemas.omarin.pokemonrest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sistemas.omarin.pokemonrest.RestApi.ApiAdapter;
import com.sistemas.omarin.pokemonrest.RestApi.iEndPoints;

import com.sistemas.omarin.pokemonrest.adaptador.ResultAdapter;
import com.sistemas.omarin.pokemonrest.modelo.Pokemon;
import com.sistemas.omarin.pokemonrest.modelo.Result;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class ListaPokemonView extends AppCompatActivity {

    private RecyclerView rvlistaPokemon;
    private ArrayList<Result> resul;
    private List<Result> pokemons;
    private ResultAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_lista_pokemon);

        initViews();

    }
    private void initViews(){
        resul = new ArrayList<Result>();

        rvlistaPokemon = (RecyclerView)findViewById(R.id.rvListaPokemon);
        rvlistaPokemon.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        rvlistaPokemon.setLayoutManager(layoutManager);

        adapter = new ResultAdapter(this, resul);
        rvlistaPokemon.setAdapter(adapter);
        loadJSON();
    }

    private void loadJSON() {
        /*Gson gson = new GsonBuilder().setLenient().create();
                //.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://pokeapi.co/api/v2/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
                */
        ApiAdapter apiAdapter = new ApiAdapter();
        iEndPoints puntoAcceso = apiAdapter.establecerConexionServidor();
        puntoAcceso.getData();

        Call<Pokemon> Accesocall = puntoAcceso.getData();
        Accesocall.enqueue(new Callback<Pokemon>() {
            @Override
            public void onResponse(Call<Pokemon> call, Response<Pokemon> response) {
                Pokemon DatosPokemon = response.body();
                pokemons = DatosPokemon.getResults();
                for (Result pokemon : pokemons) {
                    resul.add(pokemon);
                }
                adapter.notifyDataSetChanged();

            }

            @Override
            public void onFailure(Call<Pokemon> call, Throwable t) {

            }
        });

/*
        Call<Pokemon> call = puntoAcceso.getData();
        call.enqueue(new Callback<List<Result>>() {
            @Override
            public void onResponse(Call<List<Result>> call, Response<List<Result>> response) {
                if (response.isSuccessful()) {
                    Log.i("Codigo de respuesta", String.valueOf(response.message()));
                    List<Result> ResultRest = response.body();
                    for (Result resultadoUnico : ResultRest) {
                        resul.add(resultadoUnico);
                    }
                    adapter.notifyDataSetChanged();

                } else {
                    System.out.print(response.errorBody());
                }
            }

            @Override
            public void onFailure(Call<List<Result>> call, Throwable t) {
                t.printStackTrace();
            }
        });*/
    }
}
