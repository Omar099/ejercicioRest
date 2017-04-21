package com.sistemas.omarin.pokemonrest.RestApi;

import com.sistemas.omarin.pokemonrest.modelo.Pokemon;
import com.sistemas.omarin.pokemonrest.modelo.Result;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Sistemas on 20/04/2017.
 */

public interface iEndPoints {
    @GET("pokemon")
    Call<Pokemon> getData();
}
