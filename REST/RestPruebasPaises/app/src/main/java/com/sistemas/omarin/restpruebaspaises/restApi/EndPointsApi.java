package com.sistemas.omarin.restpruebaspaises.restApi;

import com.sistemas.omarin.restpruebaspaises.Model.PaisResponse;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Sistemas on 19/04/2017.
 */

public interface EndPointsApi {

    @GET(ConstantesRestApi.URL_GET)
    Call<PaisResponse> getRecentDate();
}
