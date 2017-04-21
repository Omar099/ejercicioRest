package com.sistemas.omarin.pokemonrest.RestApi;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Sistemas on 20/04/2017.
 */

public class ApiAdapter {
    public iEndPoints establecerConexionServidor(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://pokeapi.co/api/v2/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(iEndPoints.class);
    }
}
